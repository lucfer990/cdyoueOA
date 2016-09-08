<%@page import="com.youedata.cd.cdyoueOA.web.UEditorController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.baidu.ueditor.ActionEnter"

    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%

    request.setCharacterEncoding( "utf-8" );
	response.setHeader("Content-Type" , "text/html");

	String rootPath = application.getRealPath( "/" );

	String action=request.getParameter("action");
	if(action!=null && "uploadimage".equalsIgnoreCase(action)){
		new UEditorController().upload(request, response);

	}else{
		out.write( new ActionEnter( request, rootPath ).exec() );
	}


%>