package member.dao;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jdbc.JdbcUtil;
import member.model.MemberVO;

public class MemberDAO {


	private MemberDAO() {}
	private static MemberDAO dao = new MemberDAO();
	public static MemberDAO getInstance() {
		return dao;
	}
	
	
	//VO객체를 이용하여 : JDBC insert query 작성, 실행
	public int insertMember(Connection conn, MemberVO vo) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
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
			JdbcUtil.close(pstmt);
		}
		
		return result;
	}
	
	
	//전체회원 리스트가져오기
	public ArrayList<MemberVO> getALLMemberList(Connection conn) {
		
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		Statement stmt = null;
		ResultSet rs = null;
		
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
	
	//로그인-1 member의 존재여부와 id pw가져올수있게,,,
	public MemberVO selectOneMem(Connection conn, String id) {
		MemberVO member = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from project_01.memberinfo "
					+ " where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new MemberVO();
				
				member.setId(rs.getString(2));
				member.setPw(rs.getString(3));
				member.setName(rs.getString(4));
				member.setPhoto(rs.getString(5));
				member.setRegDate(rs.getDate(6));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return member;
	}
	
	
	
	
}
