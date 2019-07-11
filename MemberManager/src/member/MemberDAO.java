package member;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDAO {

	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	String driverName = "com.mysql.cj.jdbc.Driver";

	String jdbcUrl = "jdbc:mysql://localhost:3306/project_01?characterEncoding=UTF-8&serverTimezone=UTC";
	String user = "bit";
	String password = "bit";

	DataSource ds = null;

	
	public MemberDAO() {
		try {
			//conn = DriverManager.getConnection(jdbcUrl, user, password);
			String jdbcDriver = "jdbc:apache:commons:dbcp:pool";
			conn = DriverManager.getConnection(jdbcDriver);
			
			/*
			 * Context ctx = new InitialContext(); ds=
			 * (DataSource)ctx.lookup("java:comp/env/jdbc_mysql");
			 * 
			 * conn = ds.getConnection();
			 */
			
		} catch (SQLException e) {
			System.out.println(e + "연결실패");
		} 
		
	}

	public void db_close() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			System.out.println(e + "닫기 오류가 났습니다.");
		}
	}// db_close
	
	
	//VO객체를 이용하여 : JDBC insert query 작성, 실행
	public int memberInsert(MemberVO vo) {
		int result = 0;
		
		String sql = "insert into project_01.memberinfo (ID, PW, NAME, PHOTO) values (?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getPhoto());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e + " memberInsert FAIL!!");
		} finally {
			db_close();
		}
		
		return result;
	}
	
	public ArrayList<MemberVO> getALLMemberList() {
		
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
			stmt = conn.createStatement();
		
			String sql = "select * from project_01.memberinfo order by idx";
			
			rs = stmt.executeQuery(sql);
		
			
			
		while(rs.next()) {
			MemberVO vo = new MemberVO();
			
			vo.setIdx(rs.getInt(1));
			vo.setId(rs.getString(2));
			vo.setPw(rs.getString(3));
			vo.setName(rs.getString(4));
			vo.setPhoto(rs.getString(5));
			vo.setRegDate(rs.getDate(6));
			
			list.add(vo);
		};
		
		
		} catch (SQLException e) {
			System.out.println(e + "Show ALL member LIST FAIL!!");
		}
		
		return list;
	}
	
	
	
	
	
	
	
}
