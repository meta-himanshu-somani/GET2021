public class Lion extends Mammal {
	public Lion(String lionName,int age,double weight){
		super(lionName,age,weight);
	}
	@Override
	public String getSound(String animalName) {
		// TODO Auto-generated method stub
		return "Roar";
	}

	@Override
	public int getLegs(String animalName) {
		// TODO Auto-generated method stub
		return 4;
	}
	
	public void displayLionDetails(){
		System.out.println("Name:"+this.name+" "+
							"Age:"+this.age+" "+
							"Weight:"+this.weight);
	}
}
