import java.io.Serializable;

public abstract class Employee implements Serializable, Comparable<Employee> {
	private String name;
	private String level;
	private int levelNum;
	private String phoneNum;
	private int employeeNum;
	private String team;
	private int teamNum;
	private int annualLeave;

	public Employee(String name, String level, String phoneNum, int employeeNum, String team, int annualLeave) {
		this.name = name;
		this.level = level;
		if (this.level.equals("부장"))
			this.levelNum = 4;
		else if (this.level.equals("과장"))
			this.levelNum = 3;
		else if (this.level.equals("대리"))
			this.levelNum = 2;
		else if (this.level.equals("사원"))
			this.levelNum = 1;
		this.phoneNum = phoneNum;
		this.employeeNum = employeeNum;
		this.team = team;
		if (team.equals("디자인팀"))
			teamNum = 2;
		else if (team.equals("경영지원팀"))
			teamNum = 1;
		else if(team.equals("영업팀"))
			teamNum = 0;
		this.annualLeave = annualLeave;
	}

	public String getName() {
		return this.name;
	}
	
	public String getLevel() {
		return this.level;
	}
	
	public String getPhoneNum() {
		return this.phoneNum;
	}
	
	public String getTeam() {
		return this.team;
	}
	
	public int getlevelNum() {
		return this.levelNum;
	}
	
	public int getEmployeeNum() {
		return this.employeeNum;
	}
	
	public int getTeamNum() {
		return this.teamNum;
	}
	
	public int getAnnualLeave() {
		return this.annualLeave;
	}
	
	public void setInfo(String name, String level, String phoneNum, int employeeNum, String team, int annualLeave) {
		this.name = name;
		this.level = level;
		if (this.level.equals("부장"))
			this.levelNum = 4;
		else if (this.level.equals("과장"))
			this.levelNum = 3;
		else if (this.level.equals("대리"))
			this.levelNum = 2;
		else if (this.level.equals("사원"))
			this.levelNum = 1;
		this.phoneNum = phoneNum;
		this.employeeNum = employeeNum;
		this.team = team;
		if (team.equals("디자인팀"))
			teamNum = 2;
		else if (team.equals("경영지원팀"))
			teamNum = 1;
		else if(team.equals("영업팀"))
			teamNum = 0;
		this.annualLeave = annualLeave;
	}
	
	public void setInfo( String level, String team) {
		if (this.level.equals("부장"))
			this.levelNum = 4;
		else if (this.level.equals("과장"))
			this.levelNum = 3;
		else if (this.level.equals("대리"))
			this.levelNum = 2;
		else if (this.level.equals("사원"))
			this.levelNum = 1;
		
		this.team = team;
		if (team.equals("디자인팀"))
			teamNum = 2;
		else if (team.equals("경영지원팀"))
			teamNum = 1;
		else if(team.equals("영업팀"))
			teamNum = 0;
	}
	
	public void setAnnualLeave (int annualLeave) {
		this.annualLeave = annualLeave;
	}
	
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	
	public int compareTo(Employee e) {
		if (teamNum * 10 + levelNum > e.teamNum * 10 + e.levelNum)
			return -1;
		else if (teamNum * 10 + levelNum < e.teamNum * 10 + e.levelNum)
			return 1;
		return 0;
	}
	
	public abstract int work(int teamBudget);

	@Override
	public String toString() {
		return "┌ 이름 : " + name +
				"\n│ 직급 : " + level +
				"\n│ 부서 : " + team +
				"\n│ 전화번호 : " + phoneNum +
				"\n└ 사번 : " + employeeNum ;
	}
}
