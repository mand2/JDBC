package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Day01_HW_1 {
	public static void main(String[] args) {
		/*
		 * 1. DB 드라이벌 
		 * */
		/*
		 * 1. JDBC 라이브러리 추가. 
		 * 2. DB 드라이버 로드
		 * 3. 데이터베이스 연결
		 * 4. ~~작업~~
		 * 		Statement 객체 생성 - Connection 객체의 CreateStatement
		 * 		SQL 실행 - SELECT / 
		 * 			     - (INSERT / UPDATE / DELETE) ==> 실행횟수에 따라 결과 출력 가능
		 * 5. 결과출력
		 * 6. 객체 CLOSE -> ResultSet - Statement - Connection 순
		 * 7. 데이터베이스 연결종료(작업 후)
		 * */
		

//		DRIVER road 오류나는이유? forName자체가,,,, 오류남, 즉 try catch해야함.
		try {
			
//		SQL.Connection으로 연결 준비
			Connection conn = null;
			
//		JDBC URL을 문자열로 만든다.
			String jdbcUrl = "jdbc:mysql://localhost:3306/project_01?characterEncoding=UTF-8&serverTimezone=UTC";
			
			String user = "bit";
			String password = "bit";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
//		DB 연결 - add catch clause ~~해줘야 함. 반환형 타입은 Connection으로 동일.
			conn = DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("데이터베이스 연결 성공!");
			System.out.println("=====================================");
			
			
//		4.작업!	

//		-1 Statement 객체 생성
			Statement st = conn.createStatement();
			
//		-2 insert EMP 테이블에 새로운 사원 정보를 입력하는 프로그램
			String sql = "insert into project_01.emp (empno, ename, job, sal, deptno) values (?, ?, ?, ?, ?)";
			
			PreparedStatement pst = conn.prepareStatement(sql);  //먼저 완성시켜주기.
		
			pst.setInt(1, 8190);
			pst.setString(2, "nayeon");
			pst.setString(3, "HR");
			pst.setInt(4, 4850);
			pst.setInt(5, 40);
			
//			------ 결과값
			int pnum = pst.executeUpdate();
			
			
//			제대로 입력되면 나오도록 함 --> 입력X면 catch로 빠지게됨.
			if(pnum > 0 ) {
			System.out.println(pnum + "개가 증가하였습니다.");
			} 
			
			
			
//			EMP 테이블의 모든 데이터를 출력하는 프로그램을 작성
			
			String sql_show = "select * from project_01.emp order by empno";
			ResultSet rs = st.executeQuery(sql_show);
			
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
			
			
			rs.close();
			pst.close();
			st.close();
			
//		DB 연결 종료
			conn.close();
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
