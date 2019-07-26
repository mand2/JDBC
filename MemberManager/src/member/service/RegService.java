package member.service;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;
import member.dao.MemberDAO;
import member.model.MemberVO;

public class RegService implements memberService {

	
	//member 가입 service
	public int regMember(MemberVO member) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = ConnectionProvider.getConnection();
		
			MemberDAO dao = MemberDAO.getInstance();
			result = dao.insertMember(conn, member);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn);
		}
		
		return result;
	}
	
	
	
	@Override
	public String getViewName(HttpServletRequest request, HttpServletResponse response) {
		String viewName = "member/memberReg2.jsp";
		
		int result = 0;
		
		//사용자입력데이터받음 + 한글처리!! 필터가정의되어있음 ㄱㅊ아니면 각각지정,,
		try {
			request.setCharacterEncoding("utf-8");
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
				
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String photo = request.getParameter("photo");
		
		MemberVO member = new MemberVO(id, pw, name, photo);
		result = regMember(member); 
		
		request.setAttribute("result", result);
		request.setAttribute("member", member);
		
		return viewName;
	}

}
