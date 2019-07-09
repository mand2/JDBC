package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Day01_HW_4 {

	public static void main(String[] args) {
		Connection conn = null;
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/project_01?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "bit";
		String password = "bit";
		
//		모든 사원정보를 출력하되 부서정보를 함께 출력하는 프로그램을 작성해보자
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl, user, password);
			
			Statement st = conn.createStatement();
			String str = "select d.deptno, d.dname, e.ename, e.job, e.empno, e.sal "
						+ "from project_01.emp e inner join project_01.dept d where e.deptno = d.deptno";
			ResultSet rs = st.executeQuery(str);
			
			
			
//				문자열 길이 계산 후 + 메서드로 탭 반환. 
			String format = "%-11s"; //String 
			String format1 = "%-13s"; //String 
			String format2 = "%-8d"; //int
//			System.out.println("부서번호  부서이름  사원이름  사원직무  사원번호  사원급여");
				System.out.format(format, "deptno");
				System.out.format(format, "dname");
				System.out.format(format, "ename");
				System.out.format(format, "job");
				System.out.format(format, "empno");
				System.out.format(format, "sal");
				System.out.println();
			
			
			while(rs.next()) {
				int deptno = rs.getInt(1);
				String dname = rs.getString(2);
				
				String ename = rs.getString(3);
				String job = rs.getString(4);
				int empno = rs.getInt(5);
				int sal = rs.getInt(6);
				System.out.println("===========================================================");
//				System.out.println("부서번호 : " + rs.getInt(1));
				
//				System.out.println("부서이름 : " + rs.getString(2));
//				System.out.println("사원이름 : " + rs.getString(3));
//				System.out.println("사원직무 : " + rs.getString(4));
//				
//				System.out.println("사원번호 : " + rs.getInt(5));
//				System.out.println("사원급여 : " + rs.getInt(6));
				

				System.out.format(format2, deptno);
				System.out.format(format1, dname);
				System.out.format(format1, ename);
				System.out.format(format1, job);
				System.out.format(format2, empno);
				System.out.format(format2, sal);
				System.out.println();
			}
			
			rs.close();
			st.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//main

}
