import java.util.ArrayList;
import java.util.List;


public class Main {
	public static void main(String args[]){
	Employee e1=new Employee("Dakash sharma", 1004, "Delhi pratap nagar");
	Employee e2=new Employee("Bakash sharma", 1002, "Rajasthan jaipur pratap nagar");
	Employee e3=new Employee("Aakash sharma", 1001, "Rajasthan jaipur pratap nagar");
	Employee e4=new Employee("Eakash sharma", 1005, "Rajasthan jaipur pratap nagar");
	Employee e5=new Employee("Cakash sharma", 1003, "Rajasthan jaipur pratap nagar");
	Employee.addEmployee(e1);
	Employee.addEmployee(e2);
	Employee.addEmployee(e3);
	Employee.addEmployee(e4);
	Employee.addEmployee(e5);
	for(Employee emp:Employee.getEmpList()){
	System.out.println(emp.empID+"\t"+emp.empName);
	}
	Employee.sortEmployeeName();
	System.out.println("After Sort by Name");
	for(Employee emp:Employee.getEmpList()){
	System.out.println(emp.empID+"\t"+emp.empName);
	}
	Employee.sortEmployeeID();
	System.out.println("After Sort by ID");
	for(Employee emp:Employee.getEmpList()){
	System.out.println(emp.empID);
	}
	}
}
