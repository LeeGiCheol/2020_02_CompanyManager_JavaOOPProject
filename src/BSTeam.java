import java.io.Serializable;

public class BSTeam extends Employee implements Serializable, Comparable<Employee> {

	public BSTeam(String name, String level, String phoneNum, int employeeNum, String team, int annualLeave){
		super(name, level, phoneNum, employeeNum, team, annualLeave);
	}

	@Override
	public int work(int teamBudget) {
		if(teamBudget < 10000) {
			System.out.println("예산이 부족합니다.");
			return 0;
		}
		else {
			System.out.println("일해라 노예들아.");
			return -10000;
		}
	}
}
