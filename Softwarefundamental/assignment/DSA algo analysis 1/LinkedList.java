
public class LinkedList {
	Node head;
	static class Node{
		Employee emp;
		Node next;
		Node(Employee empObject){
			this.emp=empObject;
			this.next=null;
		}
		
	} 
	/**
	 * 
	 * @param data integer data to be inserted in list
	 * @return return list with inserted data
	 */
	public  LinkedList insert(Employee empObject){
		Node new_node= new Node(empObject);
		new_node.next=null;
		
		if(this.head==null){
			this.head=new_node;
		}else{
			Node temp=this.head;
			while( temp.next!=null ){
				temp=temp.next;
			}
			temp.next=new_node;
		}
		return this;
	}
	/**
	 * 
	 * @param list linked list to display 
	 */
	public void printList(LinkedList list){
		Node temp=list.head;
		System.out.println("Linked List: ");
		while( temp!=null ){
			System.out.println("Name "+temp.emp.empName+" "+"Age "+temp.emp.empAge+" "+"Salary "+temp.emp.empSalary+"->");
			
			temp=temp.next;
		}
	}
	
}
