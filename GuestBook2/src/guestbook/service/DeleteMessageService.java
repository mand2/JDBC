package guestbook.service;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.dao.MessageDao;
import guestbook.model.Message;
import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;

public class DeleteMessageService implements GuestBookService{
	
	/*싱글턴처리*/
	/*
	private DeleteMessageService() {}
	private static DeleteMessageService service = new DeleteMessageService();
	
	public static DeleteMessageService getInstance() {
		return service;
	}
	*/
	
	
	public int deleteMessage(int messageID, String password) throws SQLException, MessageNotFoundException, InvalidMessagePasswordException {
			int result = 0;
			Connection conn = null;
			
			try {
				conn = ConnectionProvider.getConnection();
				
				//트랜젝션처리->autocommit막고, 시작
				conn.setAutoCommit(false);
				
				/*DELETE 시작*/
				MessageDao dao = MessageDao.getInstance();
				Message message = dao.select(conn, messageID);
				
				
				//게시물 있는지 없는지
				if(message == null ) {
					throw new MessageNotFoundException("메세지가 존재하지 않음 : " + messageID);
				
				} else {
				//비번 비교 시작
					if(!message.hasPassword()) {//not exist
						throw new InvalidMessagePasswordException("비밀번호가 일치하지 않습니다.");
					} 
					
					if(!message.matchPassword(password)){//비번일치X
						throw new InvalidMessagePasswordException("비밀번호가 일치하지 않습니다.");
					}
					//정상처리 될 때
					result= (dao.deleteMessage(conn, messageID));
					conn.commit(); 
				
				}//게시물있을때완료.
			//rollback필요할때
			} catch (SQLException e) {
				JdbcUtil.rollback(conn);
				e.printStackTrace();
				
				throw e;
			} catch (MessageNotFoundException e) {
				JdbcUtil.rollback(conn);
				e.printStackTrace();
				throw e;
			} catch (InvalidMessagePasswordException e) {
				JdbcUtil.rollback(conn);
				e.printStackTrace();
				throw e;
			}
			
			return result;
	}

	@Override
	public String getViewName(HttpServletRequest request, HttpServletResponse response) {
		
		String viewName = "WEB-INF/view/deleteMsg_view.jsp";
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		int messageID = Integer.parseInt(request.getParameter("messageID"));
		String password = request.getParameter("password");
		
		
		//business 핵심 로직 처리
		int result = 0;
		
		boolean chk = false;
		String msg = "";
		
		try {
			result = deleteMessage(messageID, password);
			chk = true;
			
		} catch (SQLException e) {
			msg = e.getMessage();
		
		} catch (MessageNotFoundException e) {
			msg = e.getMessage();
		
		} catch (InvalidMessagePasswordException e) {
			msg = e.getMessage();
		}
		
		//뷰페이지에 결과 데이터 공유/전달
		request.setAttribute("msg", msg);
		request.setAttribute("result", result);	
		request.setAttribute("chk", chk);
		
		return viewName;
	}
}
