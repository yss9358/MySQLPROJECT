package com.javaex.projectMySQL;

import java.util.Scanner;

public class ManagerApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ManagerDao managerDao = new ManagerDao();

		int memberId;
		String menuNo;
		String str;

		while (true) {
			System.out.println("---------------------------------");
			System.out.println("1.근태관리 2.부서관리 3.회원관리 ");
			System.out.println("/q 입력시 프로그램 종료");
			System.out.println("--------------------------------");
			System.out.print("선택>");
			String menu = sc.nextLine();
			if (menu.equals("/q")) {
				System.out.println("프로그램종료");
				break;
			}
			
			switch (menu) {
			case "1":
				System.out.println("근태관리프로그램");
				break;
				
			case "2" :
				System.out.println("부서관리프로그램");
				break;
			
			case "3" :
				managerDao.memberList();
				System.out.print("수정할 직원번호 선택>");
				memberId = sc.nextInt();
				sc.nextLine();
				System.out.println("1.아이디 2.비밀번호 3.이름 4.전화번호 5.생년월일 6.입사일 7.부서번호 8.직급");
				menuNo = sc.nextLine();
				managerDao.memberUpdate(memberId, menuNo);
			}
			

		}

		/*
		 * 
		 * System.out.print("수정할 직원번호 선택>"); int no2 = sc.nextInt();
		 * 
		 * 
		 * 
		 * ManagerDao managerDao = new ManagerDao();
		 * 
		 * //managerDao.memberList();
		 * System.out.println("-------------------------------------------------"); int
		 * memberId; int menuNo; String str;
		 * 
		 * 
		 * while(stop) { System.out.print("수정할 직원번호 선택>"); memberId = sc.nextInt();
		 * System.out.println("1.아이디 2.비밀번호 3.이름 4.전화번호 5.생년월일 6.입사일 7.부서번호 8.직급");
		 * menuNo = sc.nextInt();
		 * 
		 * }
		 * 
		 * 
		 * managerDao.memberUpdate();
		 * 
		 */

	}

}
