package com.javaex.projectMySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManageDao {

	// 근태관리 멤버 전체 리스트 출력
	public List<ManageVo> memberList() {

		// 리스트 준비
		List<ManageVo> manageList = new ArrayList<ManageVo>();

		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. Connection 얻어오기
			String url = "jdbc:mysql://localhost:3306/member_db";
			conn = DriverManager.getConnection(url, "member", "member");
			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "";
			query += " select   m.member_id, ";
			query += " 			m.name, ";
			query += " 			date_format(now(), '%Y-%m-%d'), ";
			query += " 			h.state ";
			query += " from Members m ";
			query += " left join History h on m.member_id = h.member_id ";
			query += " and h.date = date_format(now(), '%Y-%m-%d') ";

			pstmt = conn.prepareStatement(query);

			rs = pstmt.executeQuery();

			// 4.결과처리
			while (rs.next()) {
				int mbId = rs.getInt("m.member_id");
				String name = rs.getString("m.name");
				String date = rs.getString("date_format(now(), '%Y-%m-%d')");
				String state = rs.getString("h.state");

				ManageVo manageVo = new ManageVo(mbId, name, date, state);

				manageList.add(manageVo);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// 5. 자원정리
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
		}

		return manageList;
	}// memberList()

	// 한 명 선택해서 히스토리
	public void oneMemberList(String no) {

		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. Connection 얻어오기
			String url = "jdbc:mysql://localhost:3306/member_db";
			conn = DriverManager.getConnection(url, "member", "member");
			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "";
			query += " select  m.member_id, ";
			query += " m.name, ";
			query += " h.date, ";
			query += " h.state ";
			query += " from members m ";
			query += " inner join history h on m.member_id = h.member_id ";
			query += " where m.member_id = ? ";

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, no);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int mbId = rs.getInt("m.member_id");
				String name = rs.getString("m.name");
				String date = rs.getString("h.date");
				String state = rs.getString("h.state");

				System.out.println(mbId + "\t" + name + "\t" + date + "\t" + state);
			}

			// 4.결과처리
		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// 5. 자원정리
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
		}

	}// oneMemberList()

	public void dateAttendanceUpdate(String mbId, String date, String state) {

		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. Connection 얻어오기
			String url = "jdbc:mysql://localhost:3306/member_db";
			conn = DriverManager.getConnection(url, "member", "member");
			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "";
			query += " update history ";
			query += " set  state = ? ";
			query += " where date = ? ";
			query += " and member_id = ? ";

			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, state);
			pstmt.setString(2, date);
			pstmt.setString(3, mbId);

			pstmt.executeUpdate();

			System.out.println("수정이 완료되었습니다.");
			System.out.println();

			// 4.결과처리
		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// 5. 자원정리
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
		}

	}// dateAttendanceUpdate()

	public void personalHistoryCount(String mbId) {
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. Connection 얻어오기
			String url = "jdbc:mysql://localhost:3306/member_db";
			conn = DriverManager.getConnection(url, "member", "member");
			// 3. SQL문 준비 / 바인딩 / 실행
			// -SQL문 준비
			String query = " select state, count(*) count " + " from history h, members m "
					+ " where m.member_id = ? and h.member_id=m.member_id " + " group by state "
					+ " having state in ('근무', '휴가', '출장', '병가') ";

			// -바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mbId);

			// -실행
			rs = pstmt.executeQuery();
			System.out.print("");
			// 4.결과처리
			System.out.println("-------------------------------------------------------------");
			System.out.println("사원번호 : " + mbId + "번님의 근무상태 내역");
			System.out.println("-------------------------------------------------------------");
			while (rs.next()) {
				String state = rs.getString("state");
				int count = rs.getInt("count");
				System.out.print(state + " : " + count + "회");
				System.out.print(" | ");
			}
			System.out.println("");
			System.out.println("-------------------------------------------------------------");
		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// 5. 자원정리
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
		}

	}// historyCount()

	public void historyCount() {
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. Connection 얻어오기
			String url = "jdbc:mysql://localhost:3306/member_db";
			conn = DriverManager.getConnection(url, "member", "member");
			// 3. SQL문 준비 / 바인딩 / 실행
			// -SQL문 준비
			String query = " select state, count(*) count " + " from history h, members m "
					+ " where h.date = date_format(now(), '%Y-%m-%d') and h.member_id=m.member_id " + " group by state "
					+ " having state in ('근무', '휴가', '출장', '병가') ";

			// -바인딩
			pstmt = conn.prepareStatement(query);

			// -실행
			rs = pstmt.executeQuery();
			System.out.print("  ");
			// 4.결과처리
			System.out.println("            Today   직원 근무상태 현황");
			System.out.println("-------------------------------------------------------------");
			while (rs.next()) {
				String state = rs.getString("state");
				int count = rs.getInt("count");
				System.out.print(state + " : " + count + "회");
				System.out.print(" | ");
			}
			System.out.println("");
			System.out.println("-------------------------------------------------------------");
		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// 5. 자원정리
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
		}

	}// historyCount()

}
