
public class Crocodile extends Reptile {

	public Crocodile(String crocodileName,int age,double weight){
		super(crocodileName,age,weight);
	}
	@Override
	public String getSound(String animalName) {
		// TODO Auto-generated method stub
		return "Hiss";
	}

	@Override
	public int getLegs(String animalName) {
		// TODO Auto-generated method stub
		return 4;
	}
	
	public void displayCrocodileDetails(){
		System.out.println("Name:"+this.name+" "+
							"Age:"+this.age+" "+
							"Weight:"+this.weight);
	}

}
