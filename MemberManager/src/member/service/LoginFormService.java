package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFormService implements memberService {
	
	@Override
	public String getViewName(HttpServletRequest request, HttpServletResponse response) {
	
		String viewName = "member/loginForm.jsp";
		return viewName;
	}

}
