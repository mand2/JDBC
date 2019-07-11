package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import guestbook.dao.MessageDao;
import guestbook.model.Message;
import jdbc.ConnectionProvider;

public class WriteMessageService {
	/*USER가 직접 메세지를 작성하는 서비스
	 * write() : 커넥션 생성->dao생성->insert메서드 실행
	 * */
	
	
	/* 싱글톤처리 */

	private static WriteMessageService service = new WriteMessageService();

	private WriteMessageService() {
	}

	public static WriteMessageService getInstance() {
		return service;
	}

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

}
