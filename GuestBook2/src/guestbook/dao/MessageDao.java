package guestbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import guestbook.model.Message;
import jdbc.JdbcUtil;

public class MessageDao {

	/*싱글턴처리*/
	
	private static MessageDao dao = new MessageDao();
	public static MessageDao getInstance() {
		return dao;
	}

	private MessageDao() {}
	
	
	/* 메세지 넣기 */
	public int insert(Connection conn, Message message) {
		int rCnt = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = "insert into PROJECT_01.GUESTBOOK_MESSAGE (GUEST_NAME, PASSWORD, MESSAGE) "
					+ "values (?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, message.getGuestName());
			pstmt.setString(2, message.getPassword());
			pstmt.setString(3, message.getMessage());
			
			rCnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
//		정상처리:1, 비정상:0으로 리턴됨
		return rCnt ;
	}
	
	
	/* 메세지 보기 : 삭제시 필요함.*/
	public Message select(Connection conn, int messageID) {

		Message message = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM PROJECT_01.GUESTBOOK_MESSAGE WHERE MESSAGE_ID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, messageID);
			
			rs = pstmt.executeQuery();

			if(rs.next()) {
				message = new Message();
				message.setId(rs.getInt(1));
				message.setGuestName(rs.getString(2));
				message.setPassword(rs.getString(3));
				message.setMessage(rs.getString(4));
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return message;
	}

	public int selectCount(Connection conn) {
		
		Statement stmt = null;
		ResultSet rs = null;
		
		int totalCnt = 0; //전체게시물의개수 카운트
		
		String sql = "select count(*) from PROJECT_01.GUESTBOOK_MESSAGE";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				totalCnt = rs.getInt(1);
			}

		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return totalCnt;
	}
	
	
	/*요청페이지의 게시글만 List형식으로 반환*/
	public List<Message> selectList(Connection conn, int firstRow, int messageCountPerPage){
		List<Message> list = new ArrayList<Message>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from project_01.guestbook_message order by message_id desc limit ?, ?";
	
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, firstRow);
			pstmt.setInt(2, messageCountPerPage);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Message msg = new Message();
				
				msg.setId(rs.getInt(1));
				msg.setGuestName(rs.getString(2));
				msg.setPassword(rs.getString(3));
				msg.setMessage(rs.getString(4));
				
				list.add(msg);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	
	
	
	//게시글삭제
	public int deleteMessage(Connection conn, int messageID) throws SQLException {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = "delete from project_01.guestbook_message where MESSAGE_ID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, messageID);
			
			result = pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return result;
	}
	
	
	
//	
	
	
	
}
