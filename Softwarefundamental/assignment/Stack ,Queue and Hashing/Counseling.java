
public class Counseling {
	CircularQueue students=new CircularQueue();
	CircularQueue studentProgram=new CircularQueue();
	String[] studentList;
	String[] studentProgramList;
	private int capacity(String programName,int[] programCapacity,int totalProgram,String[] nameOfProgram){
		for(int i=2;i<totalProgram+2;i++){
			if(programName.equals(nameOfProgram[i])){
				return i;
			}
		}return -1;
	}
	public void addStudentList(String[] studentList,int numOfStudents){
		for(int i=1;i<numOfStudents;i++){
			students.enqueue(studentList[i]);
		}
		students.display();
		this.studentList=students.getQueue();
	}
	public void assignProgram(String[][] programPreferList,
			int numOfStudents,int[] programCapacity,int totalProgram,String[] nameOfProgram){
		for(int i=1;i<numOfStudents;i++){
			int flag=0;
			for(int j=0;j<5;j++){
				String choosenProgram=programPreferList[i][j];
				int index=this.capacity(choosenProgram, programCapacity, totalProgram, nameOfProgram);
				if(index!=-1){
					if(programCapacity[index-2]>0){
						studentProgram.enqueue(choosenProgram);
						programCapacity[index-2]--;
						flag=1;
						break;
					}
				}
				
			}
			if(flag==0){
				studentProgram.enqueue("NULL");
			}
		}
		studentProgram.display();
		this.studentProgramList=studentProgram.getQueue();
	}
	
}
