package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOutService implements memberService {

	@Override
	public String getViewName(HttpServletRequest request, HttpServletResponse response) {
		
		String viewName = "member/logout.jsp";
		
		HttpSession session = request.getSession(false);
		session.invalidate();
		
		
		
		return viewName;
	}

}
