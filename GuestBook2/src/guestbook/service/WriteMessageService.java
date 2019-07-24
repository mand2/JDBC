package guestbook.service;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.dao.MessageDao;
import guestbook.model.Message;
import jdbc.ConnectionProvider;

public class WriteMessageService implements GuestBookService{
	/*USER가 직접 메세지를 작성하는 서비스
	 * write() : 커넥션 생성->dao생성->insert메서드 실행
	 * */
	
	/* Command pattern에서 싱글톤처리X */
/*
	private static WriteMessageService service = new WriteMessageService();
	private WriteMessageService() {}
	public static WriteMessageService getInstance() {
		return service;
	}
*/
	public int write(Message message) {
		int result = 0;

		Connection conn = null;

		try {

			conn = ConnectionProvider.getConnection();

			MessageDao dao = MessageDao.getInstance();

			result = dao.insert(conn, message);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public String getViewName(HttpServletRequest request, HttpServletResponse response) {
		
		
		/*응답view지정*/
		String viewName = "WEB-INF/view/writeMessage.jsp";
		
		/*응답view로 전달할 결과 데이터 
		 * 데이터 받고 -> dao 만들어서 처리하고 -> 디비저장ㄴ
		 * 
		 * 
		 * 1. 사용자 입력데이터 받기 ->
		 * 2. Message 객체 생성 -> 
		 * 3. DAO생성 connection 객체생성->
		 * 4. insert메서드 실행
		 * 결과데이터를 request 속성에 저장
		 * 
		 * 데이터베이스에 데이터 저장
		 * */
		
		//사용자입력데이터받음 + 한글처리!! 필터가정의되어있음 ㄱㅊ아니면 각각지정,,
		try {
			request.setCharacterEncoding("utf-8");
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String guestName = request.getParameter("guestName"); //name
		String password = request.getParameter("password"); //pw
		String message = request.getParameter("message"); //message
		
		//객체생성
		Message msg = new Message(0, guestName, password, message);
		
		//3 dao생성
		MessageDao dao = MessageDao.getInstance();
		Connection conn = null;
		int result = 0;
		
		
		//4 insert
		try {
			conn = ConnectionProvider.getConnection();
			//insert 실행
			result = dao.insert(conn, msg);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		//5 request 에 저장
		request.setAttribute("result", result);
		
		return viewName;
	}

}
