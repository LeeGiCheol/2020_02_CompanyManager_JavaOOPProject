import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;

public class Controller {
	Database db;
	Company com;
	EmployeeData ed;
	Employee person;

	public Controller() throws ClassNotFoundException, IOException {
		 db = new Database();
		 com = db.loadCompany();
		 ed = db.loadEmployee();
	}

	public Employee pickPerson() {
		System.out.print("→ 조회용 사번 입력: ");
		Iterator<Employee> iter = ed.getArrayList().iterator();
		int eNum = Viewer.sc.nextInt();
		while (iter.hasNext()) {
			person = iter.next();
			if (eNum == person.getEmployeeNum())
				return person;

		}
		person = null;
		System.out.println("→ 존재하지 않는 사번입니다.");
		return person;
	}

	public void showPerson() {
		System.out.println("├ " + person.getName() + person.getLevel() + "님 반갑습니다");
	}
	
	public void paySalary() {
		int salary = 2000000;
		Iterator<Employee> iter = ed.getArrayList().iterator();
		System.out.println();
		System.out.println("┌ 급여지불자동시스템");
		Employee e;
		while (iter.hasNext()) {
			e = iter.next();
			if (e.getlevelNum() == 4) {
				System.out.println("├ " + e.getName() + " 부장에게 " + (salary * 4) + "원을 지급합니다.");
				com.setTotalBudget(salary * 4 * -1);
			}
	
			else if (e.getlevelNum() == 3) {
				System.out.println("├ " + e.getName() + " 차장에게 " + (salary * 3) + "원을 지급합니다.");
				com.setTotalBudget(salary * 3 * -1);
			}
	
			else if (e.getlevelNum() == 2) {
				System.out.println("├ " + e.getName() + " 대리에게 " + (salary * 2) + "원을 지급합니다.");
				com.setTotalBudget(salary * 2 * -1);
			}
	
			else if (e.getlevelNum() == 1) {
				System.out.println("└ " + e.getName() + " 사원에게 " + (salary) + "원을 지급합니다.");
				com.setTotalBudget(salary * 1 * -1);
			}
		}
	}

	void showBudget() {
		System.out.println();
		System.out.println(com);
	
	}

	void recruitEmployee() {
		String name, team, phoneNum, level;
		int emNum, annLeave;
	
		System.out.println();
		System.out.println("┌ 신입사원관리시스템");
		System.out.println("│");
		System.out.println("├ 입사한 사원의 정보를 입력해주십시오.");
		System.out.print("├ 이름: ");
		name = Viewer.sc.next();
		System.out.print("├ 직급: ");
		level = Viewer.sc.next();
		emNum = com.getNextEmployeeNum();
		System.out.print("├ 연락처: ");
		phoneNum = Viewer.sc.next();
		System.out.print("├ 부서: ");
		team = Viewer.sc.next();
		System.out.print("└ 연차정보: ");
		annLeave = Viewer.sc.nextInt();
		if (team.equals("디자인팀")) {
			ed.getArrayList().add(new DesignTeam(name, level, phoneNum, emNum, team, annLeave));
			Collections.sort(ed.getArrayList());
		} else if (team.equals("경영지원팀")) {
			ed.getArrayList().add(new BSTeam(name, level, phoneNum, emNum, team, annLeave));
			Collections.sort(ed.getArrayList());
		} else if (team.equals("영업팀")) {
			ed.getArrayList().add(new SalesTeam(name, level, phoneNum, emNum, team, annLeave));
			Collections.sort(ed.getArrayList());
		}
	}

	void rearrangeEmployee() {
		String team, level;
	
		System.out.println();
		System.out.println("┌ 인사이동관리시스템");
	
		if(pickPerson() == null)
			return;
		System.out.println();
		System.out.println("→ 선택한 사원 \\n" + person);
		System.out.print("├ 다음의 부서로 이동: ");
		team = Viewer.sc.next();
		System.out.print("└ 다음의 직급으로 이동: ");
		level = Viewer.sc.next();
		person.setInfo(team, level);
	}

	void fireEmployee() {
		if(pickPerson() == null)
			return;
		System.out.println("├ " + person.getName() + "를 선택하셨습니다.");
		ed.getArrayList().remove(person);
		System.out.println("├ 해고를 통지하였습니다.");
		System.out.println("└ 해당 사원의 데이터를 시스템에서 삭제 합니다.");
	}

	void editEmployeeInfo() {
	
		String phoneNum;
	
		System.out.println();
		System.out.println("┌ 사원정보관리시스템");
		if(pickPerson() == null)
			return;
		System.out.println();
		System.out.println(" →선택한 사원 \n" + person);
		System.out.print("└ 수정 연락처: ");
		phoneNum = Viewer.sc.next();
		person.setPhoneNum(phoneNum);
	}

	void showEmployeeInfo() {
		Iterator<Employee> iter = ed.getArrayList().iterator();
		System.out.println();
		while (iter.hasNext())
			System.out.println(iter.next());
	}

	void logOn() {
		System.out.println();
		System.out.println("┌ 출근 로그온 ");
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		Calendar time = Calendar.getInstance();
		String format_time1 = format1.format(time.getTime());
		System.out.println("└ " + person.getName() +" "+ person.getLevel() +"님" + format_time1 + "에 출근했습니다.");
	}

	void logOff() {
		System.out.println();
		System.out.println("┌ 퇴근 로그오프");
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		Calendar time = Calendar.getInstance();
		String format_time1 = format1.format(time.getTime());
		System.out.println("└ " + person.getName() +" "+ person.getLevel() + "님 " + format_time1 + "에 퇴근했습니다.");
	}

	public void work() {
		System.out.println();
		int money = person.work(com.getTeamBudget(person.getTeamNum()));
		com.setTeamBudget(person.getTeamNum(), money);
		if(money != 10000)
			com.setTotalBudget(money * -2);
	}

	void noticeSalary() {
		int salary = 2000000;
		System.out.println();
		System.out.println("┌ 급여조회시스템");
		if (person.getlevelNum() == 4) {
			System.out.println("└ " + person.getName() + " 부장님 이번달 지급액은 " + (salary * 4) + "원 입니다.");
	
		}
	
		else if (person.getlevelNum() == 3) {
			System.out.println("└ " + person.getName() + " 차장님 이번달 지급액은 " + (salary * 3) + "원 입니다.");
	
		}
	
		else if (person.getlevelNum() == 2) {
			System.out.println("└ " + person.getName() + " 대리님 이번달 지급액은 " + (salary * 2) + "원 입니다.");
	
		}
	
		else if (person.getlevelNum() == 1) {
			System.out.println("└ " + person.getName() + " 사원님 이번달 지급액은 " + (salary) + "원 입니다.");
	
		}
	}

	void requestMoney() {
		System.out.println("→ 업무비용요청 권한처리중입니다. ");
		if (person.getLevel().equals("부장")) { // 정보 중 직급이 부장일 경우
			System.out.println("├ 권한이 확인되었습니다.");
			System.out.println("└ 필요한 금액을 입력하세요.");
			int money = Viewer.sc.nextInt();
			
			if (money > com.getTotalBudget()) { // 회사보유금액보다 부서 활동비가 클경우
				System.out.println("└ " + com.getTotalBudget() + "원 이하로 입력해주세요.");
	
			} else if (money <= com.getTotalBudget()) {
				com.setTotalBudget(money * -1);
				com.setTeamBudget(person.getTeamNum(), money);
				System.out.println("└ " + money + "원 지급 완료되었습니다.");
			}
		} else { // 부장이 아닐 경우
			System.out.println("└ 권한이 없습니다.");
		}
	}

	void confirmAnnualLeave() {
		System.out.println();
		System.out.println("┌ 연차신청시스템");
		System.out.println("└ 사용하실 연차 일수를 입력하세요.");
		int i = Viewer.sc.nextInt();
		if (person.getAnnualLeave() >= i) {
			System.out.println("→ 연차가 승인되었습니다.");
			person.setAnnualLeave(i * -1);
		} else
			System.out.println("→ 연차일수 부족으로 거절되었습니다.");
	}

	void showAllPhoneNum() {
		Iterator<Employee> iter = ed.getArrayList().iterator();
		Employee e;
		System.out.println();
		while (iter.hasNext()) {
			e = iter.next();
			System.out.println(e.getName() +" "+ e.getLevel() +" "+ e.getPhoneNum() + " " + e.getTeam());
		}
	}
}
