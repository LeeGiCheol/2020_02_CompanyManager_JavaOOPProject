import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;


public class Database{
	
	void saveCompany(Company com) throws IOException{
		OutputStream os = new FileOutputStream("Company.ser");
		ObjectOutputStream out = new ObjectOutputStream(os);
		out.writeObject(com);
		out.close();
	}
	
	void saveEmployee (EmployeeData a) throws IOException, ClassNotFoundException{
		OutputStream os = new FileOutputStream("Employee.ser");
		ObjectOutputStream out = new ObjectOutputStream(os);
		out.writeObject(a);
		out.close();
	}
	
	Company loadCompany() throws IOException, ClassNotFoundException {
		InputStream is = new FileInputStream("Company.ser");
		ObjectInputStream in = new ObjectInputStream(is);
		Company com = (Company)in.readObject();
		in.close();
		return com;
	}
	
	EmployeeData loadEmployee() throws IOException, ClassNotFoundException {
		InputStream is = new FileInputStream("Employee.ser");
		ObjectInputStream in = new ObjectInputStream(is);
		EmployeeData a = (EmployeeData)in.readObject();
		in.close();
		return a;
	}
}
