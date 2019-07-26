<%@page import="java.io.File"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	
	String name = "";
	String sNum = "";
	String fileName = ""; //파일이름
	String saveFileName = ""; //서버에저장할 파일이름변경(사용자별중복 X 위함)
	long fileSize = 0;
	String uploadPath = "/upload";
	String dir = request.getSession().getServletContext().getRealPath(uploadPath);
	
	
	/* real multipart/form-data로 받은건가 확인 */
	boolean isMultipart = ServletFileUpload.isMultipartContent(request);


	DiskFileItemFactory factory = new DiskFileItemFactory();
	
	ServletFileUpload upload = new ServletFileUpload(factory);
	
	/* FileItem : 
		form 페이지에서 전송한 데이터들(uName, sNumber, report)을 
		객체하나로 만들어 가져옴. */
		
	List<FileItem> items = upload.parseRequest(request);
	
	/* 반복하기 + 순서는 모름 */
	Iterator<FileItem> itr = items.iterator();
	
	while(itr.hasNext()){
		FileItem item = itr.next();
		
		
		if(item.isFormField()){
			//input type = file X
			
			//params 중 누가 먼저 넘어올 지 모르기에 비교시작
			if(item.getFieldName().equals("uName")){
				name = item.getString("utf-8");
			}
			
			if(item.getFieldName().equals("sNumber")){
				sNum = item.getString("utf-8");
			}
			
			
					
		} else {
			//input type = file O
			if(item.getFieldName().equals("report")){
				fileName = item.getName();
				fileSize = item.getSize();
				/* 중복X 2가지. nano가 더 작은단위이므로 굿굿*/
				//saveFileName = System.currentTimeMillis()+"_"+fileName;
				saveFileName = System.nanoTime()+"_"+fileName;
				item.write(new File(dir, saveFileName));
			}
		}
		
	}
	

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일업로드::전달</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style></style>
</head>
<body>
	
	<h1>
		이름: <%= name %><br>
		학번: <%= sNum %><br>
		과제 파일: <%= fileName %>
		( <%= fileSize %> )<br>
		저장파일이름: <%=saveFileName %><br>
		저장 폴더: <%=dir %>
	</h1>	
	
	<a href="uploadForm.jsp"> 과제제출하러가기 </a>
</body>
</html>