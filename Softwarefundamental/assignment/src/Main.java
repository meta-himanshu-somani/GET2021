
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST bst = new BST();
		bst.addEntry("D", "12345");
		bst.addEntry("A", "12345");
		bst.addEntry("C", "12345");
		bst.addEntry("B", "12345");
		bst.addEntry("G", "12345");
		bst.addEntry("F", "12345");
		bst.addEntry("E", "12345");
		bst.inorder(bst.Head);
		
		LinkedList list= new LinkedList();
		Employee e1=new Employee("Himanshu", 21, 12345);
		Employee e2=new Employee("Shudanshu", 22, 12348);
		Employee e3=new Employee("Aakash", 31, 12348);
		Employee e4=new Employee("Cheshta", 20, 1234);
		Employee e5=new Employee("Radha", 12, 123);
		Employee e6=new Employee("Krishna", 14, 125);
		list.insert(e1);
		list.insert(e2);
		list.insert(e3);
		list.insert(e4);
		list.insert(e5);
		list.insert(e6);
		Employee empList=new Employee(list);
		list.printList(empList.employeeList);
		empList.sortEmployeeSalary();
		list.printList(empList.employeeList);

	}

}
