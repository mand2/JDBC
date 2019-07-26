package member.service;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;
import member.dao.MemberDAO;
import member.model.MemberVO;

public class LoginService implements memberService {

	public int getMemberLogin(String id, String pw) throws SQLException, MemberNotFoundException, InvalidMemberPasswordException  {
		int result = 0;
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			MemberDAO dao = MemberDAO.getInstance();
			MemberVO member = dao.selectOneMem(conn, id);
			
			if(member == null) { //member not exist
				throw new MemberNotFoundException("멤버 존재하지 않음 : " + id);
			
			} else if(!member.hasPassword() || !member.matchPassword(pw)) {
				throw new InvalidMemberPasswordException("pw 불일치 : " + pw);
			}//없을 때 완료
			
			
			result = 1;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			throw e;
		} catch (MemberNotFoundException e) {
			e.printStackTrace();
			
			throw e;
		} catch (InvalidMemberPasswordException e) {
			e.printStackTrace();
			
			throw e;
		} finally {
			JdbcUtil.close(conn);
		}
		
				
		return result;
	}
	
	
	
	
	@Override
	public String getViewName(HttpServletRequest request, HttpServletResponse response) {
		String viewName = "member/loginProcess.jsp";
		
		boolean loginChk = false;
		String msg = "";
		int result = 0;
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		try {
			result = getMemberLogin(id, pw);
			loginChk = true;
			
		} catch (SQLException e) {
			msg = e.getMessage();

		} catch (MemberNotFoundException e) {
			msg = e.getMessage();
		
		} catch (InvalidMemberPasswordException e) {
			msg = e.getMessage();
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("loginChk", loginChk);
		request.setAttribute("result", result);
		
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("sessionID", id);

		return viewName;
	}

}
