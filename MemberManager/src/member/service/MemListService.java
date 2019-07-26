package member.service;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ConnectionProvider;
import member.dao.MemberDAO;
import member.model.MemberVO;

public class MemListService implements memberService {

	
	public ArrayList<MemberVO> getMemList() {
		Connection conn = null;
		ArrayList<MemberVO> member = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			MemberDAO dao = MemberDAO.getInstance();
			
			member = dao.getALLMemberList(conn);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return member;
	}
	
	
	
	@Override
	public String getViewName(HttpServletRequest request, HttpServletResponse response) {
		
		String viewName = "member/memberList.jsp";
		
		try {
			request.setCharacterEncoding("utf-8");
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
		ArrayList<MemberVO> member = getMemList();
		
		request.setAttribute("memList", member);
		
		return viewName;
	}
	 
}
