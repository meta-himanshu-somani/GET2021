/*Given Linked list is 2->3->4->5->6->7 and L=2, R=5 and N=2
Sublist is 3->4->5->6
Rotating the sublinklist 3->4->5->6 with N=2 the result would be 5->6->3->4.
So, our new linked list is 2->5->6->3->4->7.
As an output display the modified linked list.*/

public class LinkedList {
	Node head;							// |    |    |
	NodePoly Polyhead;					// |Data|next|
	static class Node{					// |    |    |
		int data;
		Node next;
		Node(int data){
			this.data=data;
			next=null;
		}
		
	}
	static class NodePoly{								// -----------------------------
		int coefficient;								// |           |               |
		NodePoly nextCoefficient;						// |coefficient|nextcoefficient|
		NodePoly coefficientpower_list;					// |           |			   |
		NodePoly(int coefficient){						// |----------------------------
			this.coefficient=coefficient;				// |coefficient power list     |
			nextCoefficient=null;						// -----------------------------
			coefficientpower_list=null;
		}
	} 
	/**
	 * 
	 * @param data integer data to be inserted in list
	 * @return return list with inserted data
	 */
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
	/**
	 * 
	 * @param coefficient of polynomial
	 * @param powerOfvariable variable powers to corresponding coefficient in x,y,z... form 
	 * @return  list having coefficient with nested list having respective powers to coefficient  
	 */
	public LinkedList insertPoly(int coefficient,int... powerOfvariable){
		NodePoly new_node_poly=new NodePoly(coefficient);
		new_node_poly.nextCoefficient=null;
		new_node_poly.coefficientpower_list=null;
		NodePoly new_node_power=new NodePoly(powerOfvariable[0]);
		System.out.println("Power "+new_node_power.coefficient);
		new_node_power.coefficientpower_list=null;
		if(this.Polyhead==null){
			this.Polyhead=new_node_poly;
			if(powerOfvariable.length>0){
				new_node_poly.coefficientpower_list=new_node_power;
				for(int i=1 ; i<powerOfvariable.length;i++){
					if (powerOfvariable[i]!=0){
						NodePoly node_power=new NodePoly(powerOfvariable[i]);
						node_power.coefficientpower_list=null;
						new_node_power.coefficientpower_list=node_power;
						new_node_power=new_node_power.coefficientpower_list;
						}
					}
			}
		}else{
		if(powerOfvariable.length>0){
			NodePoly traverse=this.Polyhead;
			while(traverse.nextCoefficient!=null){
				traverse=traverse.nextCoefficient;
			}
			traverse.nextCoefficient=new_node_poly;
			new_node_poly.coefficientpower_list=new_node_power;
			for(int i=1 ; i<powerOfvariable.length;i++){
				if (powerOfvariable[i]!=0){
					NodePoly node_power=new NodePoly(powerOfvariable[i]);
					node_power.coefficientpower_list=null;
					new_node_power.coefficientpower_list=node_power;
					new_node_power=new_node_power.coefficientpower_list;
					}
				}
			}
		}
		return this;
	}
	/**
	 * 
	 * @param list linked list
	 * @return highest degree of polynomial like 3x^2y^3 --> x's power 2 + y's power 3= 5
	 */
	public int degreeofPoly(LinkedList list){
		NodePoly temp_power=list.Polyhead.coefficientpower_list;
		NodePoly temp_coeff=list.Polyhead;
		int degree=0;
		while(temp_coeff!=null){
			int sumOfdegree=0;
			while(temp_power!=null){
				sumOfdegree+=temp_power.coefficient;
			temp_power=temp_power.coefficientpower_list;
		}
			temp_coeff=temp_coeff.nextCoefficient;
			if(temp_coeff!=null)temp_power=temp_coeff.coefficientpower_list;
			if(sumOfdegree>degree) degree=sumOfdegree;
		}
		return degree;
	}
	/**
	 * 
	 * @param list polynomial linked list to display 
	 */
	public void printPolyList(LinkedList list){
		NodePoly temp_power=list.Polyhead.coefficientpower_list;
		NodePoly temp_coeff=list.Polyhead;
		while(temp_coeff!=null){
			System.out.println("coefficient->"+temp_coeff.coefficient+"");
			while(temp_power!=null){
			System.out.println("power->"+temp_power.coefficient);
			temp_power=temp_power.coefficientpower_list;
		}
			temp_coeff=temp_coeff.nextCoefficient;
			if(temp_coeff!=null)temp_power=temp_coeff.coefficientpower_list;
		}
	}
	/**
	 * 
	 * @param list linked list to display 
	 */
	public void printList(LinkedList list){
		Node temp=list.head;
		System.out.println("Linked List: ");
		while( temp!=null ){
			System.out.print(temp.data+"->");
			temp=temp.next;
		}
	}
	/**
	 * 
	 * @param Left left element of list to rotate from
	 * @param Right element of list to rotate to
	 * @param noOfTimes rotate list sublist(left,right) in clockwise and noOfTime < length of sublist
	 * @return list rotated from given left to right remaining other element as it is.
	 * 2->3->4->5->6->7 and L=2, R=5 and N=2
	 * new linked list is 2->5->6->3->4->7.
	 */
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
	
}
