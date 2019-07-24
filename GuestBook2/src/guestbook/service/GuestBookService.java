package guestbook.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface GuestBookService {
	
	
	String getViewName(HttpServletRequest request, HttpServletResponse response);
	//request 전달받아도 되는 형태도 있음. 여기선 전달안받으려했으나 사용!
}
