<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
//	현재 session 객체 소멸시키기.	
	request.getSession(false).invalidate();

	response.sendRedirect(request.getContextPath());
	
	/* 쿠키 삭제 */
	response.addCookie(CookieBox.createCookie("ID", "", 0));
	
%>