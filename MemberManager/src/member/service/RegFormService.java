package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegFormService implements memberService{

	@Override
	public String getViewName(HttpServletRequest request, HttpServletResponse response) {
		
		String viewName = "member/memberRegForm.jsp";
		return viewName;
	}

}
