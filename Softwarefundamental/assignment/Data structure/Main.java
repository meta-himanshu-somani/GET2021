
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();
		list = list.insert( 1);
		list = list.insert( 2);
		list = list.insert( 3);
		list = list.insert( 4);
		list = list.insert( 5);
		list = list.insert( 6);
		list = list.insert( 7);
		list.printList(list);
		LinkedList sublist;
		sublist=list.rotateList(1, 6, 4);
		sublist.printList(sublist);
		System.out.println(sublist.containsLoop());
	}

}
