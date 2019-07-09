package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Day01_HW_2 {

	public static void main(String[] args) {
		
//		EMP 테이블에 서 “SCOTT” 사원의 급여(sal) 정보를 1000으로 바꾸는 프로그램을 작성해보자.
		try {
			Connection conn = null;
			
			String jdbcUrl = "jdbc:mysql://localhost:3306/project_01?characterEncoding=UTF-8&serverTimezone=UTC";
			String user = "bit";
			String password = "bit";

			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("데이터베이스 연결 성공!");
			System.out.println("=====================================");
			
			
			String str =  "update project_01.emp set sal = ? where ename = ?"; 
//			Statement st = conn.createStatement(); 
			PreparedStatement pst = conn.prepareStatement(str);
			pst.setInt(1, 1000);
			pst.setString(2, "SCOTT");
			
			pst.executeUpdate();

//			------ 결과값
			int pnum = pst.executeUpdate();
			
//			제대로 입력되면 나오도록 함 --> 입력X면 catch로 빠지게됨.
			if(pnum > 0 ) {
			System.out.println(pnum + "개가 증가하였습니다.");
			} 
			
			pst.close();
			conn.close();
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
