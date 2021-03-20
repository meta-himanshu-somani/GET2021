import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public abstract class Reptile extends Animal {
	Map<String,List<Integer>> animalCageCapacityList=new HashMap<String,List<Integer>>();
	Map<String,List<Integer>> currentCageCapacity=new HashMap<String,List<Integer>>();
	Reptile() {}
	/**
	 * 
	 * @param name pet name of animal
	 * @param age 
	 * @param weight
	 */
	public Reptile(String name,int age,double weight){
		
		super(name,age,weight);
	}
	@Override // animal name like lion,wolf ,
	public List<String> addAnimal(String animalName) {
		// TODO Auto-generated method stub
		List<Integer> cageCapacityList=animalCageCapacityList.get(animalName);
		List<Integer> currentCageCapacityList=this.currentCageCapacity.get(animalName);
		if(cageCapacityList!=null){
			for(int i=0;i<cageCapacityList.size();i++){
				if(currentCageCapacityList.get(i)<cageCapacityList.get(i)){
					currentCageCapacityList.set(i, currentCageCapacityList.get(i)+1);	
				}
				else{
					cageCapacityList.add(10);//10-->total capacity for animal in cage
					currentCageCapacityList.add(1);//1--> new animal name of animalName				
				}
			}
		}
		return super.addAnimal(animalName);
	}
	/**
	 * 
	 * @param animalType type of animal to insert 
	 * @param noOfCage total cage to insert for particular animal type
	 * @param capacity capacity of each cage
	 * @return list of all animal type added with new type
	 */
	public List<String> addNewAnimalType(String animalType,int noOfCage, int capacity) {
		this.animalCageCapacityList.put(animalType,
							this.addCageForNewType(noOfCage, capacity));
		return super.addNewAnimalType(animalType);
	}
	/**
	 * 
	 * @param noOfCage total cage to insert for particular animal type
	 * @param capacity of each cage
	 * @return new list of cage with given capacity
	 */
	private List<Integer> addCageForNewType(int noOfCage,int capacity){
		List<Integer> newCageList=new ArrayList<Integer>();
		for(int i=0;i<noOfCage;i++){
			newCageList.add(capacity);
		}
		return newCageList;
	}
	
	abstract public String getSound(String animalName);
	abstract public int getLegs(String animalName);
}
