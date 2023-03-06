import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Employee extends Person{
	private int Salary;
	private String Statu;
	private static  List<Employee> Employees = new ArrayList<Employee>();

	public Employee(String name, String surname, String id ,int Salary,String Statu) throws FileNotFoundException {
		super(name, surname, id);
		this.Salary = Salary;
		this.Statu = Statu;
		
		
	}

	public String getStatu() {
		return Statu;
	}

	public void setStatu(String statu) {
		Statu = statu;
	}

	public int getSalary() {
		return Salary;
	}

	public void setSalary(int salary) {
		Salary = salary;
	}
	public static void addEmployeeToList() throws FileNotFoundException {
		int c = 0;
		Scanner sc = new Scanner(new File("./Employees.txt"));		
		while(sc.hasNext()) {
			String line = sc.nextLine();
			String[] split = line.split(",");		
			Employee employee = new Employee(split[0],split[1],split[2],Integer.valueOf(split[3]),split[4]);
			Employees.add(employee);
			

		}
	}
	public static List<Employee> getEmployees() {
		return Employees;
	}

	public static void setEmployees(List<Employee> employees) {
		Employees = employees;
	}

	public static void writeTxt(List<Employee> employees) throws IOException {		
		FileWriter writer = new FileWriter("./Employees.txt"); 
		for(Employee e: employees) {
			String emp = e.getName() + "," + e.getSurname() + "," + e.getId() + "," + e.getSalary() + "," + e.getStatu();
		    writer.write(emp + System.lineSeparator());
		}
		writer.close();
		
		
	}


}
