	import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class EmployeeData implements Serializable{
	ArrayList<Employee> a = new ArrayList<Employee>();
	
	public EmployeeData(ArrayList<Employee> a) {
		this.a = a;
	}
	
	public void showEmployeeInfo( ) {
		Iterator<Employee> iter = a.iterator();
		while(iter.hasNext())
			System.out.println(iter.next());
	}

	
	public ArrayList<Employee> getArrayList() {
		return this.a;
	}
}
