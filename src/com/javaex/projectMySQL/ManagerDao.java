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
	private String id = "member";
	private String pw = "member";

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
			System.out.println("직원번호 아이디  이름      전화번호\t 생년월일\t  입사일     부서번호  부서명   직급 ");
			for (ManagerVo vo : memberList) {
				System.out.println(vo.getMemberId() + "\t" + vo.getId() + "\t"  + vo.getName() + "\t" + vo.getHp() + "\t"+ vo.getBirth()
					+ "\t" + vo.getHireDate() + "\t" + vo.getDepartmentId() + "\t" + vo.getDepartmentName() + "\t" + vo.getPosition());
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();
		return memberList;
	} // memberList();

	public void memberUpdate(String str1, String str2) {
		this.getConnection();
		Scanner sc = new Scanner(System.in);
		String memberId = str1; // 직원번호 str1
		String menuNo = str2; // 수정할 메뉴 column str2
		String str; // 변경할 값

		//System.out.println("1.아이디 2.이름 3.전화번호 4.생년월일 5.입사일 6.부서번호 7.부서명 8.직급");
		switch (menuNo) {
			
		case "1": // 아이디
			try {
				System.out.print("변경할 아이디 입력>");
				str = sc.nextLine();
				String query = "";
				query += " update members ";
				query += " set id = ? ";
				query += " where member_id = ? ";

				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, str);
				pstmt.setString(2, memberId);
				pstmt.executeUpdate();

			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
			break;

		case "2": // 이름
			try {
				System.out.print("변경할 이름 입력>");
				str = sc.nextLine();
				String query = "";
				query += " update members ";
				query += " set name = ? ";
				query += " where member_id = ? ";

				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, str);
				pstmt.setString(2, memberId);
				pstmt.executeUpdate();

			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
			break;

		case "3": // 전화번호
			try {
				System.out.print("변경할 이름 입력>");
				str = sc.nextLine();
				String query = "";
				query += " update members ";
				query += " set hp = ? ";
				query += " where member_id = ? ";

				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, str);
				pstmt.setString(2, memberId);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
			break;

		case "4": // 생년월일
			try {
				System.out.print("변경할 생년월일 입력>");
				str = sc.nextLine();
				String query = "";
				query += " update members ";
				query += " set birth = ? ";
				query += " where member_id = ? ";

				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, str);
				pstmt.setString(2, memberId);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
			break;

		case "5": // 입사일
			try {
				System.out.print("변경할 생년월일 입력>");
				str = sc.nextLine();
				String query = "";
				query += " update members ";
				query += " set hire_date = ? ";
				query += " where member_id = ? ";

				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, str);
				pstmt.setString(2, memberId);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
			break;

		case "6": // 부서번호
			try {
				System.out.print("변경할 입사일 입력>");
				str = sc.nextLine();
				String query = "";
				query += " update members ";
				query += " set department_id = ? ";
				query += " where member_id = ? ";

				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, str);
				pstmt.setString(2, memberId);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
			break;

		case "7": // 부서명
			try {
				System.out.print("변경할 부서번호 입력>");
				str = sc.nextLine();
				String query = "";
				query += " update members ";
				query += " set department_name = ? ";
				query += " where member_id = ? ";

				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, str);
				pstmt.setString(2, memberId);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
			break;

		case "8": // 직급
			try {
				System.out.print("변경할 부서명 입력>");
				str = sc.nextLine();
				String query = "";
				query += " update members ";
				query += " set position = ? ";
				query += " where member_id = ? ";

				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, str);
				pstmt.setString(2, memberId);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}

		}// switch case

		this.close();

	}

}
