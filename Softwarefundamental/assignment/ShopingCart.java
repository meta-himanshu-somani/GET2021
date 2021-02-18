import java.util.*;


public class ShopingCart {
	// index of item in Category and Quantity are parallel
	private static String[] availableStockCatgory={"Cloths","Shoes","Laptop","Mobile"};
	private static int[] availableStockQuantity={10,12,13,14};
	private static double[] priceListPerItem={400.0,350.50,20000.0,14000.0};
	public static List<String> buyerCart= new ArrayList<String>();
	public static List<Integer> buyerQuantity= new ArrayList<Integer>();
	/**
	*add item into cart
	*@param item name of item to be added
	*@return added if item add in cart else not add or item not present
	*
	*/
	
	public static String addTOCart(String item,int Quantity){
		
		for(int index=0;index<availableStockCatgory.length;++index){
			
			if(availableStockCatgory[index].equals(item)) {
				
					if(0<=availableStockQuantity[index] && availableStockQuantity[index]>=Quantity){
						
						availableStockQuantity[index]-=Quantity;
						buyerCart.add(item);
						buyerQuantity.add(Quantity);
						return "Item added .";
					}else return "Item "+item +" -- "+availableStockQuantity[index] +" Qunatity only";
			}
		}
		return "No such item  "+item +" in shope";
	}
	/**
	 * *
	 * 
	 * @return index of item in available stock category
	 */
	private static int indexOFItem(String item_name){
		int indexOfItem;
		for( indexOfItem=0;indexOfItem<availableStockCatgory.length;++indexOfItem){
			if (availableStockCatgory[indexOfItem].equals(item_name))
				return indexOfItem;
		}
		return -1;
	}
	/**
	 * @param Quantity must be positive
	 * @return Item add in cart else no such item
	 */
	public static String addItemQuantity(String item_name,int Quantity){
		if(buyerCart.contains(item_name)){
			int item_quantity=buyerQuantity.get(buyerCart.indexOf(item_name));
			
			int index=indexOFItem(item_name);
			if (Quantity<availableStockQuantity[index]){
				item_quantity+=Quantity;
				buyerQuantity.remove(buyerCart.indexOf(item_name));
				buyerQuantity.add(buyerCart.indexOf(item_name), item_quantity);
				availableStockQuantity[index]-=Quantity;
				return Quantity+" Item added of " + item_name;
			}else{
				return "Out of stock!";
			}
		}
		return "No such item in your cart.";
	}
	/**
	 * 
	 * @param Quantity must be positive
	 * @return item deleted in such quantity else no such item
	 */
	public static String deleteItemQuantity(String item_name,int Quantity){
		if(buyerCart.contains(item_name)){
			int item_quantity=buyerQuantity.get(buyerCart.indexOf(item_name));
			int index=indexOFItem(item_name);
			if (item_quantity>=Quantity){
				item_quantity-=Quantity;
				buyerQuantity.remove(buyerCart.indexOf(item_name));
				buyerQuantity.add(buyerCart.indexOf(item_name), item_quantity);
				availableStockQuantity[index]+=Quantity;
				return Quantity+" Item deleted of " + item_name;
			}else{
				return "More than present item entered";
			}
		}
		return "No such item in your cart.";
	}
	// display cart of buyer category
	public static List<String> displayItemCart(){
		return buyerCart;
	}
	// display cart of buyer quantity
	public static List<Integer> displayItemQuantityCart(){		
		return buyerQuantity;
	}
	/**
	 * 
	 * @return Total_amount amount of cart will generate.
	 */
	private static double generateBill(){
		double total_amount=0.0;
		System.out.println("Item list " + displayItemCart());
		System.out.println("Quantity list " + displayItemQuantityCart());
		for(String item : buyerCart){
			int index=indexOFItem(item);
			total_amount+=priceListPerItem[index]*buyerQuantity.get(buyerCart.indexOf(item));
		}
		return total_amount;
	}
	
	public static void main(String[] args){
		System.out.println("-----Hello----- ");
		System.out.println("-----Welcome to Shopping Cart-----");
		System.out.println("-----Available Catagory-----");
		System.out.println("Catagory-------Quantity");
		for(int index=0;index<availableStockCatgory.length;++index){
			System.out.println(availableStockCatgory[index]+"---------"+availableStockQuantity[index]);
		}
		System.out.println(addTOCart("Cloths", 10));
		System.out.println(addTOCart("Shoes", 10));
		System.out.println(addTOCart("Laptop", 10));
		System.out.print(displayItemCart());
		System.out.println(displayItemQuantityCart());
		System.out.println(deleteItemQuantity("Cloths", 5));
		System.out.print(displayItemCart());
		System.out.println(displayItemQuantityCart());
		System.out.println(addItemQuantity("Cloths", 2));
		System.out.print(displayItemCart());
		System.out.println(displayItemQuantityCart());
		System.out.println(generateBill());
		
	}

}
