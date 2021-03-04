/*Given Linked list is 2->3->4->5->6->7 and L=2, R=5 and N=2
Sublist is 3->4->5->6
Rotating the sublinklist 3->4->5->6 with N=2 the result would be 5->6->3->4.
So, our new linked list is 2->5->6->3->4->7.
As an output display the modified linked list.*/

public class LinkedList {
	Node head;
	static class Node{
		int data;
		Node next;
		Node(int data){
			this.data=data;
			next=null;
		}
	}
	public  LinkedList insert(int data){
		Node new_node= new Node(data);
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
	
	public void printList(LinkedList list){
		Node temp=list.head;
		System.out.println("Linked List: ");
		while( temp!=null ){
			System.out.print(temp.data+"->");
			temp=temp.next;
		}
	}
	
	public LinkedList rotateList(int Left , int Right,int noOfTimes){
		LinkedList sublist = new LinkedList();
		Node temp = this.head;
		int counter=1;
		while(temp!=null && counter<=Right){
			if(counter>=Left && counter<=Right){
				sublist.insert(temp.data);
			}
			temp=temp.next;counter++;
		}
		sublist.printList(sublist);
		if(noOfTimes>0){
		int rotator=0;
		Node last_node=sublist.head;
		Node nextofprev_node=sublist.head;
		Node prev_node=sublist.head;
		Node start_node=sublist.head;
		while(last_node.next!=null ){
			if(rotator<noOfTimes){
				prev_node=nextofprev_node;
				nextofprev_node=nextofprev_node.next;
				rotator++;
			}
			last_node=last_node.next;
		}
		last_node.next=start_node;
		sublist.head=nextofprev_node;
		prev_node.next=null;
		sublist.printList(sublist);
		}
		Node this_temp=this.head;
		Node start_rotater=this.head;
		Node end_rotater=this.head;
		int count=1;
		int count2=1;
		while(this_temp!=null){
			if(count<Left-1){
			start_rotater=this.head;
			start_rotater=start_rotater.next;
			count++;
			}
			if(count2<Right+1){
				end_rotater=end_rotater.next;
				count2++;
			}else break;
			this_temp=this_temp.next;
		}
		Node sublist_last_node=sublist.head;
		while(sublist_last_node.next!=null){sublist_last_node=sublist_last_node.next;}
		if(Left==1){this.head=sublist.head;}
		else{start_rotater.next=sublist.head;}
		sublist_last_node.next=end_rotater;
		return this;
	}
	
	public boolean containsLoop(){
		Node head=this.head;
		Node prev=head;
		Node next=head;
		boolean loop=false;
		while(prev!=null && next!=null && next.next!=null){
			prev=prev.next;
			next=next.next.next;
			if(prev==next){
				loop =true;
			}
		}
		return loop;
	}
	
	/*public int findDegree(LinkedList list_x,LinkedList list_y){
		Node list1_head=list_x.head;
		Node list2_head=list_y.head;
		while(list1_head!=null){
			while(list2_head!=null){
				//if(list1_head.data!=0 && list)
			}
		}
	}*/
}
