import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class MakeDB {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Company com = new Company();
//		Controller c = new Controller();
		Database db = new Database();
		ArrayList<Employee> al =  new ArrayList<Employee>();
		com.setTotalBudget(1000000000);
		com.setTeamBudget(0, 5000000);
		com.setTeamBudget(1, 5000000);
		com.setTeamBudget(2, 5000000);

//		com = db.loadCompany();
//		System.out.println(com);
		
		al.add(new DesignTeam("장묘주", "부장", "010-1234-5678", com.getNextEmployeeNum(), "디자인팀", 20));
		al.add(new SalesTeam("나현", "부장", "010-4578-9982", com.getNextEmployeeNum(), "영업팀", 21));
		al.add(new BSTeam("이기철", "부장", "010-7448-6520", com.getNextEmployeeNum(), "경영지원팀", 20));
		al.add(new DesignTeam("박원희", "사원", "010-5585-5585", com.getNextEmployeeNum(), "디자인팀", 500));
		al.add(new BSTeam("임태환", "과장", "010-5574-8206", com.getNextEmployeeNum(), "경영지원팀", 54));
		al.add(new BSTeam("권준영", "대리", "010-5547-5813", com.getNextEmployeeNum(), "경영지원팀", 19));
		al.add(new SalesTeam("양아론", "과장", "010-4710-2550", com.getNextEmployeeNum(), "영업팀", 41));
		al.add(new SalesTeam("이지원", "대리", "010-1002-7448", com.getNextEmployeeNum(), "영업팀", 35));
		al.add(new BSTeam("김경민", "사원", "010-1405-4116", com.getNextEmployeeNum(), "경영지원팀", 65));
		al.add(new SalesTeam("김원준", "사원", "010-5001-4663", com.getNextEmployeeNum(), "영업팀", 35));
		Collections.sort(al);
		EmployeeData ed = new EmployeeData(al);
		db.saveEmployee(ed);
		db.saveCompany(com);
		
//		ed = db.loadEmployee();
//		Iterator<Employee> iter = ed.getArrayList().iterator();
//		while(iter.hasNext())
//			System.out.println(iter.next());
	}
}
