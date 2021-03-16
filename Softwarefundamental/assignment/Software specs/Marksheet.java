
public class Marksheet {
	public final int[] gradeList;
	
	public Marksheet(int[] grade_list) {
		// TODO Auto-generated constructor stub
		this.gradeList=grade_list;
	}
	/**
	 * 
	 * @return average of all n number of students grade as float type
	 */
	public float avgOfGrades(){
		float sum=0;
		for (int grade : this.gradeList){
			sum+=grade;
		}
		return this.gradeList.length!=0?sum/this.gradeList.length:0;
	}
	/**
	 * 
	 * @return maximum grade of n number of students in integer type
	 */
	public int maximumGrade(){
		int max=0;
		for(int grade:this.gradeList){
			if(max<grade){
				max=grade;
			}
		}
		return max;
	}
	/**
	 * 
	 * @return minimum grade of n number of students in integer type
	 */
	public int minimumGrade(){
		int mini=0;
		for(int grade:this.gradeList){
			if(mini>grade){
				mini=grade;
			}
		}
		return mini;
	}
	/**
	 * 
	 * @return percentage student passed having >=40 grade in float type
	 */
	public float percentPassed(){
		int MINI_PASS=40;
		int numOfStudentPassed=0;
		for(int grade : this.gradeList){
			if(grade>=MINI_PASS){
				numOfStudentPassed++;
			}
		}
		return this.gradeList.length!=0?numOfStudentPassed/this.gradeList.length:0;
	}
}
