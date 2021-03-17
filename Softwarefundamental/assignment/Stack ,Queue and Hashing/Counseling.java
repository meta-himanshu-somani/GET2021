
public class Counseling {
	CircularQueue students=new CircularQueue();
	CircularQueue studentProgram=new CircularQueue();
	String[] studentList;
	String[] studentProgramList;
	/**
	*@param programName program choosen by student
	*@param programCapacity list of capacity correspond to program that student can choose
	*@param totalProgram number of program available in college
	*@param nameOfProgram list of all program name that are available
	*@return index of program in nameOfProgram if program choosen by student is available else -1
	*/
	private int indexOfChoosenProgram(String programName,int totalProgram,String[] nameOfProgram){
		for(int i=2;i<totalProgram+2;i++){
			if(programName.equals(nameOfProgram[i])){
				return i;
			}
		}return -1;
	}
	/**
	*@param studentList list of students name 
	*@param numOfStudents total students for counseling
	*/
	public void addStudentList(String[] studentList,int numOfStudents){
		for(int i=1;i<numOfStudents;i++){
			students.enqueue(studentList[i]);
		}
		students.display();
		this.studentList=students.getQueue();
	}
	/**
	*@param programPreferList list of program preference choosen by students
	*@param numOfStudents total students for counseling
	*@param programCapacity list of capacity correspond to program that student can choose
	*@param totalProgram number of program available in college
	*@param nameOfProgram list of all program name that are available
	*/
	public void assignProgramToStudent(String[][] programPreferList,
			int numOfStudents,int[] programCapacity,int totalProgram,String[] nameOfProgram){
		for(int i=1;i<numOfStudents;i++){
			int flag=0;
			for(int j=0;j<5;j++){
				String choosenProgram=programPreferList[i][j];
				int index=this.indexOfChoosenProgram(choosenProgram, totalProgram, nameOfProgram);
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
