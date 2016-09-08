package com.youedata.cd.cdyoueOA.web;


import com.youedata.cd.cdyoueOA.utill.upload.UploadPathConfig;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2016/3/10 0010.
 */
@Controller
public class UEditorController {

    private static Logger logger = Logger.getLogger(UEditorController.class);
    public void upload(HttpServletRequest request, HttpServletResponse response){
	
    	//判断是否是多数据段提交格式  
        boolean isMultipart = ServletFileUpload.isMultipartContent(request); 
        
    	DiskFileItemFactory factory = new DiskFileItemFactory();
    	
    	ServletFileUpload upload = new ServletFileUpload(factory);
    	try {
    	List<FileItem> fileItems = upload.parseRequest(request);
    	for (Iterator iter = fileItems.iterator(); iter.hasNext();) { 
    		FileItem item = (FileItem) iter.next();
    		if (!item.isFormField()) {  
                String fileName = item.getName();
                Calendar calendar=Calendar.getInstance();
                
                SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");
                String filedisk=sdf.format(new Date());
                int year=calendar.YEAR;//年
                int month=calendar.MONTH;//月
                
                int index = fileName.lastIndexOf(".");
                int length = fileName.length();
                String type = fileName.substring(index, length);
                
                String imgPath= UploadPathConfig.IMAGES_SERVER_DISK+UploadPathConfig.IMAGES_SERVER_PATH+"/"+filedisk;
                
                /* 根据图片名生成唯一文件路径 */
                File imgFile = new File(imgPath);
                if(!imgFile.exists()){
                	imgFile.mkdirs();
                }
                
                String newFileName=""+UUID.randomUUID().toString().replace("-", "")+type;
                try {
                	 //item.write( new File(imgPath,newFileName)); 
                	 FileUtils.copyInputStreamToFile(item.getInputStream(), new File(imgPath,newFileName));
				} catch (Exception e) {
					e.printStackTrace();
				}

                long size = item.getSize();
                String url=UploadPathConfig.IMAGES_SERVER_PATH+"/"+filedisk+"/"+newFileName;
                
                String result = "{\"name\":\""+ fileName +"\", \"originalName\": \""+ fileName
                        +"\", \"size\": "+ size +", \"state\": \""+ "SUCCESS" +"\", \"type\": \""
                        + type +"\", \"url\": \""+ url +"\"}";
                result = result.replaceAll( "\\\\", "\\\\" );
                response.setHeader("Content-Type", "text/html");
                response.setHeader("x-frame-options","SAMEORIGIN");
                PrintWriter writer = null;
                try {
                    writer = response.getWriter();
                } catch (IOException e) {
                    logger.error(e.getMessage());
                }
                writer.write(result);
                writer.flush();
            } 
    	}
    	 
    	} catch (Exception e) {
			// TODO: handle exception
    		e.printStackTrace();
		}
    }
    

    private void test(MultipartFile upfile, HttpServletResponse response, HttpSession session) {

        String rootPath = session.getServletContext().getRealPath("/upload");
        String fileName = upfile.getName();
        String originalFilename = upfile.getOriginalFilename();
        long size = upfile.getSize();
        int index = originalFilename.lastIndexOf(".");
        int length = originalFilename.length();
        String type = originalFilename.substring(index, length);
        File file = new File(rootPath + originalFilename);
        try {
            upfile.transferTo(file);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        String url = "/"+originalFilename;

        String result = "{\"name\":\""+ fileName +"\", \"originalName\": \""+ originalFilename
                +"\", \"size\": "+ size +", \"state\": \""+ "SUCCESS" +"\", \"type\": \""
                + type +"\", \"url\": \""+ url +"\"}";
        result = result.replaceAll( "\\\\", "\\\\" );

        response.setHeader("Content-Type", "text/html");
        response.setHeader("x-frame-options","SAMEORIGIN");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        writer.write(result);
        writer.flush();

    }

}