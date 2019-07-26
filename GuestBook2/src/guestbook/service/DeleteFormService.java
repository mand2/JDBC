package guestbook.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteFormService implements GuestBookService{

	@Override
	public String getViewName(HttpServletRequest request, HttpServletResponse response) {
		
		String viewName="WEB-INF/view/confirmDeletion.jsp";
		
		//list_view에서 들어온 것을 다시 confirmDeletion.jsp로 연결해야함
//		String id = request.getParameter("messageID");
//		request.setAttribute("messageID", id);
		
		return viewName;
	}

}
