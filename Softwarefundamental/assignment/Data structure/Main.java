
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();
		list = list.insertPoly(2, 1,2,3);
		list = list.insertPoly(3, 4,5,6);
		list = list.insertPoly(2, 1,2,3);
		list = list.insertPoly(3, 4,5,6);
		list.printPolyList(list);
		System.out.println(list.degreeofPoly(list));
	}

}
