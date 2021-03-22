import java.util.HashMap;
import java.util.Map;
public class BST implements Dictionary {
	public Map<String,String> bstListSorted=new HashMap<String,String>();
	Node Head ;
	BST(){}
	class Node{
		String key;
		String value;
		Node left;
		Node right;
		Node(String key,String value){
			this.key=key;
			this.value=value;
		}
	}
	/**
	 * traverse bst to add new_node at location  
	 * @param new_node new created node 
	 * @param key 
	 * 
	 */
	private void traversAdd(Node new_node,String key){
		Node temp=this.Head;
		int left=0,right=0;
		while(temp!=null){
			 left=0;
			right=0;
			if(temp.key.compareTo(key)>0){
				if(temp.left!=null){
					temp=temp.left;
				}else{
					left=1;
					break;
				}
			}else{
				if(temp.right!=null){
					temp=temp.right;
				}else{
					right=1;
					break;
				}
			}
		}if(right==1){
			temp.right=new_node;
		}else if(left==1){
			temp.left=new_node;
		}
	}
	@Override
	/**
	 * @param Key string to insert in dictionary
	 * @param value in string to insert at given key
	 */
	public void addEntry(String key, String value) {
		Node new_node=new Node(key,value);
		new_node.left=null;
		new_node.right=null;
		if(this.Head==null){
			this.Head=new_node;
		}else if(this.Head.key.compareTo(key)>0){
			this.traversAdd(new_node, key);
		}else if(this.Head.key.compareTo(key)<0){
			this.traversAdd(new_node, key);
		}
	}

	@Override
	public void deleteEntry(String key, String value) {
		// TODO Auto-generated method stub
		this.bstListSorted.remove(key, value);
	}



	@Override
	public Map<String,String> sortedKeyFrom(String key1, String key2) {
		// TODO Auto-generated method stub
		Map<String,String> subSortedKey=new HashMap<String,String>();
		this.bstListSorted=this.inorder(this.Head);
		int flag=0;
		for(String key: this.bstListSorted.keySet()){
			if(key.equals(key1)){
				flag=1;
			}
			if(key.equals(key2)){
				flag=0;
				subSortedKey.put(key, this.bstListSorted.get(key));
				break;
			}
			if(flag==1){
				subSortedKey.put(key, this.bstListSorted.get(key));
			}
			
		}
		return subSortedKey;
	}
	/**
	 * 
	 * @param Head root node of bst 
	 * @return ascending order of bst as key value pair
	 */
	public Map<String,String> inorder(Node Head){
		
		if(Head!=null){
			inorder(Head.left);
			this.bstListSorted.put(Head.key, Head.value);
			inorder(Head.right);
		}
		return this.bstListSorted; 
		
	}
	@Override
	public String getValue(String key) {
		// TODO Auto-generated method stub
		return this.bstListSorted.get(key);
	}
	@Override
	public Map<String, String> sortedKey() {
		// TODO Auto-generated method stub
		return this.inorder(this.Head);
	}

}
