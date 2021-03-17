

public class CircularQueue implements Queue {
	int MAX=10;
	String[] queue=new String[MAX];
	int front=-1;
	int rear=-1;
	public String[] getQueue(){
		return queue;
	}
	/**
	*@return true if queue is full else false
	*/
	public boolean isFull(){
		if(this.rear==MAX-1 && this.front==0){
			return true;
		}else if((this.rear+1)%MAX==this.front){
			return true;
		}else{
			return false;
		}
	}
	/**
	*@return true if queue is empty else false
	*/
	public boolean isEmpty(){
		if(this.front==-1 && this.rear==-1){
			return true;
		}else{
			return false;
		}
	}
	/**
	*@param value insert string value into queue
	*/
	public void enqueue(String value){
		if(this.isFull()){
			System.out.println("Queue is full...");
		}else if(this.isEmpty()) {
			this.front++;
			this.rear++;
			this.queue[this.front]=value;
		}else {
			this.rear=(this.rear+1)%MAX;
			this.queue[this.rear]=value;
		}
	}
	// delete element from queue present at front
	public void dequeue(){
		if(this.isEmpty()){
			System.out.println("Queue is empty...");
			
		}else if(this.rear==this.front){
			System.out.println("dequeued element is : "+this.queue[this.front]);
			this.front=-1;
			this.rear=-1;
		}else{
			System.out.println("dequeued element is : "+this.queue[this.front]);
			this.front=(this.front+1)%MAX;
		}
	}
	// Display the queue elements
	public void display()  
	{  
	    int i=this.front;  
	    if(this.isEmpty())  
	    {  
	    	System.out.println(" Queue is empty..");  
	    }  
	    else  
	    {  
	    	System.out.println("Elements in a Queue are :");  
	        while(i<=this.rear)  
	        {  
	        	System.out.println(this.queue[i]);  
	            i++;  
	        }  
	    }  
	}  

}
