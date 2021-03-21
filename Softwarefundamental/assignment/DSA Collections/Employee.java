import java.util.ArrayList;
import java.util.List;
public class Employee {
	public int empID=0;
	public String empName;
	private String empAddress;
	public static List<Employee> employeeObjectList = new ArrayList<Employee>();
	
	Employee(String empName,int empID,String empAddress){
	this.empName=empName;
	this.empID=empID;
	this.empAddress=empAddress;
	}
	/**
	 * 
	 * @param emp employee class object to insert in employee list if does not exists
	 */
	public static void addEmployee(Employee emp){
		boolean flag=true;
		for(Employee employee:employeeObjectList){
			if(employee.empID==emp.empID){
				System.out.println("Employee ID : "+emp.empID+" already present");
				flag=false;
				break;
			}
		}
		if(flag){
			employeeObjectList.add(emp);
		}
	}
	/**
	 * Sort the employee based on there IDs
	 */
	public static void sortEmployeeID(){
		for(int i=0;i<employeeObjectList.size();i++){
			for(int j=i+1;j<employeeObjectList.size();j++){
				if(employeeObjectList.get(i).empID>employeeObjectList.get(j).empID){
					Employee tempEmp=employeeObjectList.get(i);
					employeeObjectList.set(i,employeeObjectList.get(j));
					employeeObjectList.set(j, tempEmp);
				}
			}
		}
	}
	/**
	 * Sort the employee based on there names
	 */
	public static void sortEmployeeName(){
		for(int i=0;i<employeeObjectList.size();i++){
			for(int j=i+1;j<employeeObjectList.size();j++){
				if(employeeObjectList.get(i).empName.compareToIgnoreCase(employeeObjectList.get(j).empName)>0){
					Employee tempEmp=employeeObjectList.get(i);
					employeeObjectList.set(i,employeeObjectList.get(j));
					employeeObjectList.set(j, tempEmp);
				}
			}
		}
	}
	
	public static List<Employee> getEmpList(){
		return employeeObjectList;
	}
}
