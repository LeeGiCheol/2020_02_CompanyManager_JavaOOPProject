import java.io.Serializable;

public class SalesTeam extends Employee implements Serializable, Comparable<Employee>{

	public SalesTeam(String name, String level, String phoneNum, int employeeNum, String team, int annualLeave){
		super(name, level, phoneNum, employeeNum, team, annualLeave);
	}

	@Override
	public int work(int teamBudget) {
		if(teamBudget < 50000) {
			System.out.println("예산이 부족합니다.");
			return 0;
		}
		else {
			System.out.println("영업 실적 목표 달성!");
			return -50000;
		}
	}
}
