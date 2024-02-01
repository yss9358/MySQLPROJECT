package com.javaex.projectMySQL;

import java.util.Scanner;

public class ManagerApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ManagerDao managerDao = new ManagerDao();

		String memberId;
		String menuNo;
		boolean run = true;

		exit: while (true) {
			System.out.println("-------------------------------------------------------------");
			System.out.println("1.근태관리 2.부서관리 3.회원관리 ");
			System.out.println("(/q 입력시 프로그램 종료)");
			System.out.println("-------------------------------------------------------------");
			System.out.print("선택>");
			String menuSelect = sc.nextLine();

			if (menuSelect.equals("/q")) {
				break exit;
			}

			switch (menuSelect) {
			case "1":
				System.out.println("<근태관리 프로그램>");
				break;

			case "2":
				System.out.println("<부서관리 프로그램>");
				break;

			case "3":
				
				while (run) {
					System.out.println("<회원관리 프로그램 접속>");
					System.out.println("-------------------------------------------------------------");
					managerDao.memberList();
					System.out.println("-------------------------------------------------------------");
					System.out.print("수정할 직원번호 선택>");
					memberId = sc.nextLine(); // 직원번호
					// 1~직원아이디 수까지 for 문? (-1 이면 뒤로가기 /q 입력 종료)
					// 여기까지 반복되게 해야됨
					if(memberId.equals("/q")) {
						break exit;
					}

					System.out.println("1.아이디 2.이름 3.전화번호 4.생년월일 5.입사일 6.부서번호 7.부서명 8.직급");
					System.out.print("수정할 메뉴 선택>");

					// 1~8이면 진행 (-1이면 뒤로가기 /q입력 종료)
					menuNo = sc.nextLine(); // 수정할 메뉴
					switch (menuNo) {
					case "1":
					case "2":
					case "3":
					case "4":
					case "5":
					case "6":
					case "7":
					case "8":
						managerDao.memberUpdate(memberId, menuNo);
						System.out.println("수정이 완료되었습니다.");
						break;
					case "-1":
						break;
					case "/q":
						break exit;
					default:
						System.out.println("다른번호를 입력하세요");
						break;

					}
				} //while문
				break; // case3 break

			default:
				System.out.println("다른번호를 입력하세요");

			}

		}

		
		System.out.println("종료");
		sc.close();

	}

	
	
	
	
	
}
