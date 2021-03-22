public class Employee {
	public LinkedList employeeList = new LinkedList();
	public String empName;
	public int empAge;
	public double empSalary;
	
	Employee(String name,int age,double salary){
		this.empName=name;
		this.empAge=age;
		this.empSalary=salary;
	}
	
	Employee(LinkedList root){
		this.employeeList.head =root.head;
	}
	/**
	 * Sort (descending) based on their salary
	 * If there is a tie between salaries then the 
	 * one with a lesser age add  before.
	 */
	public void sortEmployeeSalary()
	{
		LinkedList.Node i = this.employeeList.head;
		while(i!=null){
			LinkedList.Node j = i.next;
			while(j!=null){
				if(i.emp.empSalary<j.emp.empSalary){
					LinkedList.Node temp= new LinkedList.Node(i.emp);
					i.emp=j.emp;
					j.emp=temp.emp;
				}else if(i.emp.empSalary==j.emp.empSalary){
					
					if(i.emp.empAge<j.emp.empAge){
						LinkedList.Node temp= new LinkedList.Node(j.emp);
						j.emp=i.emp;
						i.emp=temp.emp;
					}else{
						LinkedList.Node temp= new LinkedList.Node(i.emp);
						i.emp=j.emp;
						j.emp=temp.emp;
					}
				}
				j=j.next;
			}
			i=i.next;
		}
	}
}
