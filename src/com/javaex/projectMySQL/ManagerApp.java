package com.javaex.projectMySQL;

import java.util.List;
import java.util.Scanner;

public class ManagerApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ManagerDao managerDao = new ManagerDao();

		
		// 1 근태관리 변수
		ManageDao manageDao = new ManageDao();
		manageDao.memberList();
		String memberCode;
		String menuCode;
		String type;
		boolean stop = true;

		// 3 회원관리 변수
		String memberId;
		String menuNo;
		boolean run = true;

		exit: while (true) {
			System.out.println("-------------------------------------------------------------");
			System.out.println("< 관리자 프로그램 접속 >");
			System.out.println("1.근태관리 2.부서관리 3.회원관리 ");
			System.out.println("(종료 : /q)");
			System.out.println("-------------------------------------------------------------");
			System.out.print("메뉴선택>");
			String menuSelect = sc.nextLine(); // 메뉴선택
			System.out.println();

			if (menuSelect.equals("/q")) {
				break exit;
			}

			switch (menuSelect) {
			case "1":
				System.out.println("<근태관리 접속>");
				while (stop) {
					System.out.println();
					System.out.println("-------------------------------------------------------------");
					manageDao.historyCount();
					System.out.println("직원ID   이름       날짜       근무상태");
					List<ManageVo> manageList = manageDao.memberList();
					for (ManageVo Vo : manageList) {
						System.out.println(
								Vo.getMbId() + "\t" + Vo.getName() + "\t " + Vo.getDate() + "\t " + Vo.getState());
					}
					System.out.println("-------------------------------------------------------------");
					System.out.println("수정할 직원번호를 입력하세요");
					System.out.println("(뒤로가기 : -1, 종료 : /q)");
					System.out.print("선택>");
					memberCode = sc.nextLine();
					System.out.println();
					if (memberCode.equals("-1")) {
						break;
					} else if (memberCode.equals("/q")) {
						stop = false;
						break exit;
					}
					manageDao.personalHistoryCount(memberCode);
					while (true) {
						System.out.println("-------------------------------------------------------------");
						manageDao.oneMemberList(memberCode);
						System.out.println("-------------------------------------------------------------");
						System.out.println("수정할 날짜를 입력하세요");
						System.out.println("(뒤로가기 : -1, 종료 : /q)");
						System.out.print("선택>");
						menuCode = sc.nextLine();
						if (menuCode.equals("-1")) {
							break;
						} else if (menuCode.equals("/q")) {
							break exit;
						}
						System.out.println();
						System.out.println("수정할 내용을 입력하세요");
						System.out.print("입력> ");
						type = sc.nextLine();
						manageDao.dateAttendanceUpdate(memberCode, menuCode, type);
					}
				} // while
				break;

			case "2":
				System.out.println("<부서관리 접속>");
				break;

			case "3":
				System.out.println("<회원관리 접속>");
				System.out.println();
				System.out.println(
						"--------------------------------------------------------------------------------------------------------------");
				System.out.println(
						"--------------------------------------------------------------------------------------------------------------");
				managerDao.memberList();
				System.out.println(
						"--------------------------------------------------------------------------------------------------------------");
				while (run) {
					System.out.println(
							"--------------------------------------------------------------------------------------------------------------");
					System.out.println("1.추가  2.수정  3.삭제  4.검색");
					System.out.println("메뉴를 선택하세요");
					System.out.println("(뒤로가기 : -1, 종료 : /q)");
					System.out.print("선택>");
					menuSelect = sc.nextLine();
					System.out.println();
					if ("/q".equals(menuSelect)) {
						break exit;
					}
					if ("-1".equals(menuSelect)) {
						break;
					}
					switch (menuSelect) {
					case "1":
						managerDao.memberAdd();
						
						break;

					case "2":
						while (true) {
							System.out.println("수정할 직원번호를 입력하세요");
							System.out.println("(뒤로가기 : -1, 종료 : /q)");
							System.out.print("선택>");
							memberId = sc.nextLine(); // 직원번호
							if ("-1".equals(memberId)) {
								break;
							}
							// 1~직원아이디 수까지 for 문? (-1 이면 뒤로가기 /q 입력 종료)
							// 여기까지 반복되게 해야됨
							if ("/q".equals(memberId)) {
								break exit;
							}
							System.out.println();
							System.out.println("1.아이디  2.이름  3.전화번호  4.생년월일  5.입사일  6.부서번호  7.부서명  8.직급");
							System.out.println("수정할 메뉴를 입력하세요");
							System.out.println("(뒤로가기 : -1, 종료 : /q)");
							System.out.print("선택>");

							// 1~8이면 진행 (-1이면 뒤로가기 /q입력 종료)
							menuNo = sc.nextLine(); // 수정할 메뉴
							System.out.println();
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
								System.out.println("수정이 완료되었습니다");
								System.out.println();
								break;
							case "-1":
								break;
							case "/q":
								break exit;
							default:
								System.out.println("다른번호를 입력하세요");
								break;
							}

						} 
					case "3":
						System.out.println("삭제할 직원번호를 입력하세요");
						System.out.print("선택>");
						int no = sc.nextInt();
						managerDao.memberDelete(no);
						System.out.println("삭제되었습니다");
						System.out.println();
						break;
					
					case "4" :
						System.out.println("검색할 직급을 입력하세요");
					    System.out.print("검색>");
					    String str = sc.nextLine();
						System.out.println();
						System.out.println(
								"--------------------------------------------------------------------------------------------------------------");
						System.out.println("직원번호 아이디  이름      전화번호\t 생년월일\t  입사일     부서번호  부서명   직급 ");
						System.out.println(
								"--------------------------------------------------------------------------------------------------------------");
						managerDao.memberSearch(str);
						System.out.println(
								"--------------------------------------------------------------------------------------------------------------");
						System.out.println();
						break;
					} // switch문

				} // while문
			default: // case3 break
				System.out.println("다른번호를 입력하세요");
				break;

			}

		}
		
		
		

		System.out.println("종료");
		sc.close();

	
		
		
	}

}
