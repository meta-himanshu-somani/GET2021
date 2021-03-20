import java.util.ArrayList;
import java.util.List;


public class Animal {
	String name;
	double weight;
	int age=0;
	List<String> animalList=new ArrayList<String>();
	List<String> animalTypelList=new ArrayList<String>();
	int totalAnimals=0;
	int totalCages=0;
	int totalZone=0;
	
	public Animal(){}
	public Animal(String name,int age,double weight){
	this.name=name	;
	this.age=age;
	this.weight=weight;
	}
	public List<String> addNewAnimalType(String animalType){
		animalTypelList.add(animalType);
		this.totalZone++;
		this.totalAnimals++;
		return animalTypelList;
	}
	public List<String> addAnimal(String animalName){
		this.animalList.add(animalName);
		this.totalAnimals++;
		return this.animalList;
	}
}
