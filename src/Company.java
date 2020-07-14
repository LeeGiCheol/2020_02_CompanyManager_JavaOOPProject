import java.io.Serializable;

public class Company implements Serializable{
	private int totalBudget;
	private int teamBudget[] = new int[3];
	private int nextEmployeeNum = 1;
	
	public Company() {
		totalBudget = 0;
		for (int i = 0; i < teamBudget.length; i++) {
			teamBudget[i] = 0;
		}
	}
	
	public int getNextEmployeeNum() {
		return nextEmployeeNum++;
	}
	
	public int getTotalBudget() {
		return this.totalBudget;
	}
	
	public int getTeamBudget(int i) {
		return this.teamBudget[i];
	}
	
	public void setTotalBudget(int money) {
		this.totalBudget += money;
	}
	
	public void setTeamBudget(int i, int money) {
		this.teamBudget[i] += money;
	}
	
	@Override
	public String toString() {
		return "┌ 기업 총예산 : " + totalBudget + 
				"\n├ 영업팀 예산 : " + teamBudget[0] + 
				"\n├ 경영지원팀 예산 : " + teamBudget[1] + 
				"\n└ 디자인팀 예산 : " + teamBudget[2];
	}
}
