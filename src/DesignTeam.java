import java.io.Serializable;

public class DesignTeam extends Employee implements Serializable, Comparable<Employee> {

	public DesignTeam(String name, String level, String phoneNum, int employeeNum, String team, int annualLeave){
		super(name, level, phoneNum, employeeNum, team, annualLeave);
	}

	@Override
	public int work(int teamBudget) {
		if(teamBudget < 1000000) {
			System.out.println("예산이 부족합니다.");
			return 0;
		}
		else {
			System.out.println("열심히 디자인을 합니다.");
			return -100000;
		}
	}
	
}
