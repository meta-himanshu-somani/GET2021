/**
 * 
 * @author himanshu.somani_meta
 *First come First Serve scheduling implementation
 */
public class FCFS {
	public static int[][] arrivalAndBurstTime={{0,10}, //{arrival,burst}
											   {6,20},
											   {6,15},
											   {60,40}};
	public static int[] entryTime = new int[FCFS.arrivalAndBurstTime.length];
	public static int[] waitingTime = new int[FCFS.arrivalAndBurstTime.length];
	public static int[] turnAroundTime = new int[FCFS.arrivalAndBurstTime.length];
	public static int[] completionTime = new int[FCFS.arrivalAndBurstTime.length];
	public static int totalCpuTime=0;
	// sort the process according to there arrival time
	private static void sortProcess(){
		for (int i=0;i<arrivalAndBurstTime.length;++i){
			for (int j=i;j<arrivalAndBurstTime.length;++j){
				if (arrivalAndBurstTime[i][0]> arrivalAndBurstTime[j][0]){
					int arrive=arrivalAndBurstTime[i][0];
					arrivalAndBurstTime[i][0]=arrivalAndBurstTime[j][0];
					arrivalAndBurstTime[j][0]=arrive;
					// sorting arrival with burst time
					int burst=arrivalAndBurstTime[i][1];
					arrivalAndBurstTime[i][1]=arrivalAndBurstTime[j][1];
					arrivalAndBurstTime[j][1]=burst;
				}
			}
		}
		cpuTimer();
	}
	public FCFS(){
		sortProcess();
	}
	// calculate total time cpu runs and process enter in cpu
	private static void cpuTimer(){
		
		for(int index=0;index<arrivalAndBurstTime.length;++index){
			if(totalCpuTime<=arrivalAndBurstTime[index][0]){
				totalCpuTime=arrivalAndBurstTime[index][0]+arrivalAndBurstTime[index][1];
				entryTime[index]=arrivalAndBurstTime[index][0];
			}
			else{
				entryTime[index]=totalCpuTime;
				totalCpuTime+=arrivalAndBurstTime[index][1];
				
			}
		}
	}
	
	/**
	 * 
	 * @return process waiting time list in there sorted arrival time
	 * 
	 */
	
	public static int[] waitingTime(){
		for(int index=0;index<arrivalAndBurstTime.length;++index){
			waitingTime[index]=entryTime[index]-arrivalAndBurstTime[index][0];
		}
		return waitingTime;
	}
	/**
	 * 
	 * @return process turn around time list in there sorted arrival time
	 */
	public static int[] turnAroundTime(){
		for(int index=0;index<arrivalAndBurstTime.length;++index){
			turnAroundTime[index]=arrivalAndBurstTime[index][1]+waitingTime[index];
		}
		return turnAroundTime;
	}
	/**
	 * 
	 * @return process completion time list in there sorted arrival time
	 */
	public static int[] completionTime(){
		for(int index=0;index<arrivalAndBurstTime.length;++index){
			completionTime[index]=entryTime[index]+arrivalAndBurstTime[index][1];
		}
		return completionTime;
	}
}
