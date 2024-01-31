package com.javaex.projectMySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerDao {

	// 필드
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/member_db";
	private String id = "memberdb";
	private String pw = "1234";

	// 생성자

	// 메소드 g/s

	// 메소드 일반

	public void getConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	} // getConnection();

	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	} // close();
	/*
	 * public void start() {
	 * System.out.println("---------------------------------");
	 * System.out.println("1.근태관리 2.부서관리 3.회원관리");
	 * System.out.println("---------------------------------");
	 * System.out.print("메뉴선택>"); Scanner sc = new Scanner(System.in); int no =
	 * sc.nextInt();
	 * 
	 * switch (no) { case 1 :
	 * 
	 * break;
	 * 
	 * case 2 :
	 * 
	 * break;
	 * 
	 * case 3 :
	 * 
	 * 
	 * break; default : System.out.println("잘못입력하셨습니다."); break;
	 * 
	 * }
	 * 
	 * }
	 */

	public List<ManagerVo> memberList() {
		getConnection();

		List<ManagerVo> memberList = new ArrayList<ManagerVo>();

		try {
			String query = "";
			query += " select	m.member_id, ";
			query += " 			m.id, ";
			query += "  		m.name, ";
			query += "   		m.hp, ";
			query += "   		m.birth, ";
			query += " 			m.hire_date, ";
			query += "   		m.department_id, ";
			query += "  		d.department_name, ";
			query += "   		m.position ";
			query += " from members m ";
			query += " 		left join departments d ";
			query += "  		   on m.department_id = d.department_id ";
			// query += " where m.member_id = ? ";

			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int memberId = rs.getInt("m.member_id");
				String id = rs.getString("m.id");
				String name = rs.getString("m.name");
				String hp = rs.getString("m.hp");
				String birth = rs.getString("m.birth");
				String hireDate = rs.getString("m.hire_date");
				int departmentId = rs.getInt("m.department_id");
				String departmentName = rs.getString("d.department_name");
				String position = rs.getString("m.position");

				ManagerVo mangerVo = new ManagerVo(memberId, id, name, hp, birth, hireDate, departmentId,
						departmentName, position);
				memberList.add(mangerVo);
			}
			System.out.println("직원번호 아이디  이름 전화번호 생년월일 입사일 부서번호 부서명 직급 ");
			for (ManagerVo vo : memberList) {
				System.out.println(vo.getMemberId() + vo.getId() + vo.getName() + vo.getHp() + vo.getBirth()
						+ vo.getHireDate() + vo.getDepartmentId() + vo.getDepartmentName() + vo.getPosition());
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();
		return memberList;
	} // memberList();

	public void memberUpdate(int no, String str) {
		this.getConnection();
		Scanner sc = new Scanner(System.in);
		int memberId;
		String menuNo;
		
		
	
		
			System.out.print("수정할 직원번호 선택>");
			memberId = sc.nextInt();
			sc.nextLine();
			System.out.println("1.아이디 2.비밀번호 3.이름 4.전화번호 5.생년월일 6.입사일 7.부서번호 8.직급");
			menuNo = sc.nextLine();
			
			switch (menuNo) {

			case "1" : // 아이디
				try {
					System.out.print("변경할 아이디 입력>");
					str = sc.nextLine();
					String query = "";
					query += " update members ";
					query += " set id = ? ";
					query += " where member_id = ? ";

					pstmt = conn.prepareStatement(query);
					pstmt.setString(1, str);
					pstmt.setInt(2, no);
					pstmt.executeUpdate();

				} catch (SQLException e) {
					System.out.println("error:" + e);
				}
				break;

			case "2" : // 비밀번호
				try {
					System.out.print("변경할 비밀번호 입력>");
					str = sc.nextLine();
					String query = "";
					query += " update members ";
					query += " set pw = ? ";
					query += " where member_id = ? ";

					pstmt = conn.prepareStatement(query);
					pstmt.setString(1, str);
					pstmt.setInt(2, memberId);
					pstmt.executeUpdate();

				} catch (SQLException e) {
					System.out.println("error:" + e);
				}
				break;

			case "3" : // 이름
				try {
					System.out.print("변경할 이름 입력>");
					str = sc.nextLine();
					String query = "";
					query += " update members ";
					query += " set name = ? ";
					query += " where member_id = ? ";

					pstmt = conn.prepareStatement(query);
					pstmt.setString(1, str);
					pstmt.setInt(2, memberId);
					pstmt.executeUpdate();
				} catch (SQLException e) {
					System.out.println("error:" + e);
				}
				break;

			case "4" : // 전화번호
				try {
					System.out.print("변경할 전화번호 입력>");
					str = sc.nextLine();
					String query = "";
					query += " update members ";
					query += " set hp = ? ";
					query += " where member_id = ? ";

					pstmt = conn.prepareStatement(query);
					pstmt.setString(1, str);
					pstmt.setInt(2, memberId);
					pstmt.executeUpdate();
				} catch (SQLException e) {
					System.out.println("error:" + e);
				}
				break;

			case "5" : // 생년월일
				try {
					System.out.print("변경할 생년월일 입력>");
					str = sc.nextLine();
					String query = "";
					query += " update members ";
					query += " set birth = ? ";
					query += " where member_id = ? ";

					pstmt = conn.prepareStatement(query);
					pstmt.setString(1, str);
					pstmt.setInt(2, memberId);
					pstmt.executeUpdate();
				} catch (SQLException e) {
					System.out.println("error:" + e);
				}
				break;

			case "6" : // 입사일
				try {
					System.out.print("변경할 입사일 입력>");
					str = sc.nextLine();
					String query = "";
					query += " update members ";
					query += " set hire_date = ? ";
					query += " where member_id = ? ";

					pstmt = conn.prepareStatement(query);
					pstmt.setString(1, str);
					pstmt.setInt(2, memberId);
					pstmt.executeUpdate();
				} catch (SQLException e) {
					System.out.println("error:" + e);
				}
				break;

			case "7" : // 부서번호
				try {
					System.out.print("변경할 부서번호 입력>");
					str = sc.nextLine();
					String query = "";
					query += " update members ";
					query += " set department_id = ? ";
					query += " where member_id = ? ";

					pstmt = conn.prepareStatement(query);
					pstmt.setString(1, str);
					pstmt.setInt(2, memberId);
					pstmt.executeUpdate();
				} catch (SQLException e) {
					System.out.println("error:" + e);
				}
				break;

			case "8" : // 부서명
				try {
					System.out.print("변경할 부서명 입력>");
					str = sc.nextLine();
					String query = "";
					query += " update members ";
					query += " set department_name = ? ";
					query += " where member_id = ? ";

					pstmt = conn.prepareStatement(query);
					pstmt.setString(1, str);
					pstmt.setInt(2, memberId);
					pstmt.executeUpdate();
				} catch (SQLException e) {
					System.out.println("error:" + e);
				}
			case "-1" : 
				System.out.println("프로그램종료");
				break;
			case "/q" :
				break;
				
				
				// switch case
			}
			
			
			

		
			
			
			
			this.close();

	

	}

}