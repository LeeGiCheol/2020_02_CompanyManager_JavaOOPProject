import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.text.View;

public class Viewer {
	static Scanner sc = new Scanner(System.in);
	Controller c;
	Database db;

	public Viewer() throws ClassNotFoundException, IOException {
		c = new Controller();
		db = new Database();
	}

	public void mainLoop() throws IOException, ClassNotFoundException {

		while (true) {
			System.out.println();
			System.out.println("┏┓┏┓┏┳┓┏┓┏┳━┓╋┏┓");
			System.out.println("┃┃┃┃┃┃┃┃┃┃┃┃┗┓┃┃");
			System.out.println("┃┃┃┃┃┃┃┃┃┃┃┏┓┗┛┃");
			System.out.println("┃┗┛┗┛┃┗┛┗┛┃┃┗┓┃┃");
			System.out.println("┗┓┏┓┏┻┓┏┓┏┫┃╋┃┃┃");
			System.out.println("╋┗┛┗┛╋┗┛┗┛┗┛╋┗━┛");
			System.out.println();
			System.out.println("┌ 우우한남매들(주)관리시스템");
			System.out.println("│");
			System.out.println("├ 접속 권한을 선택하세요.");
			System.out.println("├ 1. 관리자");
			System.out.println("├ 2. 사원");
			System.out.println("└ 3. 시스템 종료");
			System.out.println("");
			int sel = sc.nextInt();
			if (sel == 3) {
				db.saveCompany(c.com);
				db.saveEmployee(c.ed);
				System.exit(0);
			}
			switch (sel) {
			case 1:
				System.out.println("→ 관리자 페이지로 이동합니다.");
				companyView();
				break;

			case 2:

				System.out.println("→ 사원 페이지로 이동합니다.");
				employeeView();
				break;

			default:
				System.out.println("→ 잘못된 입력입니다.");
				continue;
			}
		}

	}

	void companyView() {
		while (true) {
			System.out.println();
			System.out.println("┌ 관리자권한접속");
			System.out.println("│");
			System.out.println("├ 메뉴를 선택해주세요.");
			System.out.println("├ 1. 회사총액 및 활동비용");
			System.out.println("├ 2. 월급지급시스템");
			System.out.println("├ 3. 인사관리시스템");
			System.out.println("├ 4. 모든사원정보확인");
			System.out.println("└ 5. 이전메뉴로 이동");
			int sel = sc.nextInt();
			if (sel == 5)
				break;
			switch (sel) {
			case 1:

				System.out.println("→ 회사총액 및 활동비용관리 페이지로 이동합니다.");// 내역확인
				c.showBudget();
				break;
			case 2:

				System.out.println("→ 월급지급시스템으로 이동합니다.");
				c.paySalary();
				break;
			case 3:

				System.out.println("→ 인사관리시스템으로 이동합니다.");
				hrView();
				break;
			case 4:

				System.out.println("→ 모든 사원 정보보기로 이동합니다.");
				c.showEmployeeInfo();
				break;
			default:

				System.out.println("→ 잘못된 입력입니다.");
				continue;
			}
		}
	}

	void hrView() {
		while (true) {
			System.out.println();
			System.out.println("┌ 인사관리시스템");
			System.out.println("│");
			System.out.println("├ 메뉴를 선택해주세요.");
			System.out.println("├ 1. 신입사원 정보입력");// 내역확인
			System.out.println("├ 2. 사원정보수정");
			System.out.println("├ 3. 사원해고");
			System.out.println("└ 4. 이전메뉴로 이동");
			int sel = sc.nextInt();
			if (sel == 4)
				break;
			switch (sel) {
			case 1:

				System.out.println("→ 신입사원 정보입력으로 이동합니다.");// 내역확인
				c.recruitEmployee();
				break;
			case 2:

				System.out.println("→ 사원정보수정으로 이동합니다.");
				c.editEmployeeInfo();
				break;
			case 3:

				System.out.println("→ 사원해고로 이동합니다.");
				c.fireEmployee();
				break;
			default:

				System.out.println("→ 잘못된 입력입니다.");
				continue;
			}
		}
	}

	void employeeView() {
		
		if (c.pickPerson() == null)
			return;

		while (true) {
			System.out.println();
			System.out.println("┌ 사원권한접속");
			c.showPerson();
			System.out.println("│");
			System.out.println("├ 메뉴를 선택해주세요.");
			System.out.println("├ 1. 근태관리시스템");
			System.out.println("├ 2. 업무보고");
			System.out.println("├ 3. 업무비용요청");
			System.out.println("├ 4. 연차신청시스템");
			System.out.println("├ 5. 급여조회시스템");
			System.out.println("├ 6. 비상연락망확인");
			System.out.println("└ 7. 이전메뉴로 이동");
			int sel = sc.nextInt();
			if (sel == 7)
				break;
			switch (sel) {
			case 1:

				System.out.println("→ 근태관리로 이동합니다.");
				logOnOff();
				break;
			case 2:

				System.out.println("→ 업무보고로 이동합니다.");
				c.work();
				break;
			case 3:

				System.out.println("→ 업무비용요청으로 이동합니다.");
				c.requestMoney();
				break;
			case 4:

				System.out.println("→ 연차신청으로 이동합니다.");
				c.confirmAnnualLeave();
				break;
			case 5:

				System.out.println("→ 급여조회로 이동합니다.");
				c.noticeSalary();
				break;
			case 6:

				System.out.println("→ 비상연락망확인으로 이동합니다.");
				c.showAllPhoneNum();
				break;
			default:

				System.out.println("→ 잘못된 입력입니다.");
				continue;
			}
		}
	}
	void logOnOff() {
		while (true) {
			System.out.println();
			System.out.println("┌ 근태관리시스템");
			System.out.println("│");
			System.out.println("├ 메뉴를 선택해주세요.");
			System.out.println("├ 1. 출근 로그온");
			System.out.println("├ 2. 퇴근 로그오프");
			System.out.println("└ 3. 이전메뉴로 이동");
			int sel = sc.nextInt();
			if (sel == 3)
				break;
			switch (sel) {
			case 1:

				System.out.println("→ 출근 로그온으로 이동합니다.");
				c.logOn();
				break;
			case 2:

				System.out.println("→ 퇴근 로그오프로 이동합니다.");
				c.logOff();
				break;

			}
		}
	}
}