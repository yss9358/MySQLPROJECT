package com.javaex.projectMySQL;

import java.util.Scanner;

public class ManagerApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ManagerDao managerDao = new ManagerDao();

		String memberId;
		String menuNo;
		String str;

		while (true) {
			System.out.println("-------------------------------------------------------------");
			System.out.println("1.근태관리 2.부서관리 3.회원관리 ");
			System.out.println("(/q 입력시 프로그램 종료)");
			System.out.println("-------------------------------------------------------------");
			System.out.print("선택>");
			String menuSelect = sc.nextLine();
			
			if (menuSelect.equals("/q")) {
				System.out.println("프로그램종료");
				break;
			}
			
			switch (menuSelect) {
			case "1":
				System.out.println("<근태관리 프로그램>");
				break;
				
			case "2" :
				System.out.println("<부서관리 프로그램>");
				break;
			
			case "3" :
				System.out.println("<회원관리 프로그램 접속>");
				System.out.println("-------------------------------------------------------------");
				managerDao.memberList();
				System.out.println("-------------------------------------------------------------");
				System.out.print("수정할 직원번호 선택>");
				// 1~직원아이디 수까지 for 문? (-1 이면 뒤로가기 /q 입력 종료)
				// 여기까지 반복되게 해야됨
				memberId = sc.nextLine(); // 직원번호
				System.out.println("1.아이디 2.이름 3.전화번호 4.생년월일 5.입사일 6.부서번호 7.부서명 8.직급");
				System.out.print("수정할 메뉴 선택>"); 
				//1~8이면 진행 (-1이면 뒤로가기 /q입력 종료)
				menuNo = sc.nextLine(); // 수정할 메뉴
				managerDao.memberUpdate(memberId, menuNo);
				System.out.println("수정이 완료되었습니다.");
				break;
				
			default :
					System.out.println("다른번호를 입력하세요");

			}
		
		}
		
		sc.close();

	}

}
