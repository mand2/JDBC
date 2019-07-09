package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Day01_HW_3 {

	public static void main(String[] args) {
		
		Connection conn = null;
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/project_01?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "bit";
		String password = "bit";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection(jdbcUrl, user, password);
			
			
//			EMP 테이블에 서 “SCOTT” 이름으로 검색한 결과를 출력하는 프로그램을 작성해보자
			Statement st = conn.createStatement();
			
			String sql = "select * from project_01.emp where ename = 'SCOTT'";
//			PreparedStatement pst = conn.prepareStatement(sql);
//			pst.setString(1, "SCOTT");
			
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				System.out.println("=====================================");
				System.out.println("사원번호 : " + rs.getInt(1));
				System.out.println("사원이름 : " + rs.getString(2));
				System.out.println("사원직무 : " + rs.getString(3));
				System.out.println("담당선임 : " + rs.getString(4));
				System.out.println("입 사 일 : " + rs.getDate(5));
				System.out.println("사원급여 : " + rs.getInt(6));
				System.out.println("사원상여 : " + rs.getInt(7));
				System.out.println("부서번호 : " + rs.getInt(8));
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
