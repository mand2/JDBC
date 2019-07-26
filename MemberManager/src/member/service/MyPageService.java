package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;
import member.dao.MemberDAO;
import member.model.MemberVO;

public class MyPageService implements memberService {

	public MemberVO getMemberInfo(String id) {
		
		MemberVO member = null;
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			MemberDAO dao = MemberDAO.getInstance();
			member = dao.selectOneMem(conn, id);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return member;
	}
	
	
	@Override
	public String getViewName(HttpServletRequest request, HttpServletResponse response) {
		
		String viewName = "member/myPage2.jsp";
		HttpSession session = request.getSession(false);
		
		String id = (String) session.getAttribute("sessionID");
		MemberVO member = getMemberInfo(id);	
		
		
		request.setAttribute("loginInfo", member);
		
		return viewName;
	}

}
