package com.youedata.cd.cdyoueOA.common.date;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.Md5Crypt;
/**
 * 
 * @类名: ApacheCommonsCodecEncryptionUtil
 * @描述: TODO
 * @创建人: Guzhendong
 * @创建时间: 2016年8月24日 上午10:08:25
 */
public class ApacheCommonsCodecEncryptionUtil {
	
    /**
     * @Title:ApacheCommonsCodecEncryptionUtil
     * @描述:TODO 加密
     * @param data
     * @return
     */
    public static String md5Crypt(byte[] data){
        return Md5Crypt.md5Crypt(data);
    }

    /**
     * @Title:ApacheCommonsCodecEncryptionUtil
     * @描述:TODO 加密并作对比
     * @param bytes
     * @param md5
     * @return
     */
    public static String md5Crypt(byte[] bytes, String md5) {
    	return Md5Crypt.md5Crypt(bytes, md5);
    }
	/**
     * 使用Base64加密算法加密字符串
     * return
     */
    public static String encodeStr(String plainText){
        byte[] b=plainText.getBytes();
        Base64 base64=new Base64();
        b=base64.encode(b);
        String s=new String(b);
        return s;
    }
    
    /**
     * 使用Base64加密
     * return
     */
    public static String decodeStr(String encodeStr){
        byte[] b=encodeStr.getBytes();
        Base64 base64=new Base64();
        b=base64.decode(b);
        String s=new String(b);
        return s;
    }

	public static void main(String[] args) throws UnsupportedEncodingException {
		//$1$.Y3.tI/.$ikG0GDAJLywMRJYfGhL/d0
		String md5 = md5Crypt("123456".getBytes("utf-8"));
		String md5t = md5Crypt("123456".getBytes("utf-8"),"$1$.Y3.tI/.$ikG0GDAJLywMRJYfGhL/d0");
		System.out.println("md5="+md5);  
		System.out.println("md5t="+md5t);  
//		String str1 = "123456";
//		String enstr1 = encodeStr(str1);
//		String str2 = decodeStr(enstr1);
//		System.out.println("原字符串：" + str1     + "     长度：" + str1.length());
//		System.out.println("encode字符串：" + enstr1    + "     长度：" + enstr1.length());
//		System.out.println("decode字符串：" + str2    + "     长度：" + str2.length() );
		
//		String s1 = null, s2 = null;
//        try {
//            // 加密
//            s1 = Md5Crypt.md5Crypt("$1$mNi6fDnO$SVsgOpSOSgC6vmVjxR/pO1".getBytes("UTF-8"));
//            // 验证：如果s2=s1则验证通过
//            s2 = Md5Crypt.md5Crypt("$1$mNi6fDnO$SVsgOpSOSgC6vmVjxR/pO1".getBytes("UTF-8"), s1);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        System.out.println(s1);
//        System.out.println(s2);
	}
}
