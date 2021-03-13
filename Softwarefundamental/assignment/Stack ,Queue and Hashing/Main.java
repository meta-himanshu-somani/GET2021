
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileOutputStream;
import java.util.Iterator;  
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Main {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] nameOfProgram=new String[100];
		int[] capacityOfProgram=new int[100];
		int length=0;int length2=0;
		String[] studentList=new String[100];
		int length3=0;
		String[][] preferenceList=new String[100][5];
		try{
			File file = new File("C:\\Users\\himanshu.somani_meta\\Downloads\\Counseling.xlsx");
			FileInputStream fis=new FileInputStream(file);
			@SuppressWarnings("resource")
			XSSFWorkbook wb= new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0);
			XSSFSheet sheet2 = wb.getSheetAt(1);
			Iterator<Row> itr =sheet.iterator();
			Iterator<Row> itr2 =sheet2.iterator();
			
			while(itr.hasNext()){
				Row row=itr.next();
				Iterator<Cell> cellIterator = row.cellIterator();
			
			while (cellIterator.hasNext())   
			{  
			Cell cell = cellIterator.next();  
			switch (cell.getCellType())               
			{  
			case Cell.CELL_TYPE_STRING:    //field that represents string cell type  
			System.out.print(cell.getStringCellValue() + "\t\t\t"); 
			nameOfProgram[length++]=cell.getStringCellValue();
			break;  
			case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type  
			System.out.print(cell.getNumericCellValue() + "\t\t\t");  
			capacityOfProgram[length2++]=(int) cell.getNumericCellValue();
			break;  
			default:  
			}  
			} 
			System.out.println("");  
		}int i=0;
		while(itr2.hasNext()){
			Row row=sheet2.getRow(i);
			Cell cell=row.getCell(0);
			studentList[length3++]=cell.getStringCellValue();
			System.out.print(studentList[i]+"\t\t");
			preferenceList[i][0]=row.getCell(1).getStringCellValue();
			System.out.print(preferenceList[i][0]+"\t\t\t");
			preferenceList[i][1]=row.getCell(2).getStringCellValue();
			System.out.print(preferenceList[i][1]+"\t\t\t");
			preferenceList[i][2]=row.getCell(3).getStringCellValue();
			System.out.print(preferenceList[i][2]+"\t\t\t");
			preferenceList[i][3]=row.getCell(4).getStringCellValue();
			System.out.print(preferenceList[i][3]+"\t\t\t");
			preferenceList[i][4]=row.getCell(5).getStringCellValue();
			System.out.print(preferenceList[i][4]+"\t\t\t");
			row=itr2.next();
			i++;
			System.out.println("");
		}
		Counseling c=new Counseling();
		System.out.println(length3);
		c.addStudentList(studentList,length3);
		c.assignProgram(preferenceList,length3 , capacityOfProgram,length2,nameOfProgram);
		XSSFWorkbook wb2=new XSSFWorkbook();
		FileOutputStream f=new FileOutputStream(new File("C:\\Users\\himanshu.somani_meta\\Downloads\\ProgramList.xlsx"));
		XSSFSheet sheet3=wb2.createSheet("student assigned program");
		XSSFRow row;
		String[] studentNameList=c.studentList;
		String[] studentProgramList=c.studentProgramList;
		 Map < String, Object[] > studentProgram = new TreeMap < String, Object[] >();
		 studentProgram.put("1", new Object[] {"Name","Program"});
		 for(i=1;i<length3;i++){
			 studentProgram.put(Integer.toString(i+1),new Object[]{studentNameList[i-1], studentProgramList[i-1]});
		 }
		 Set < String > keyid = studentProgram.keySet();
	      int rowid = 0;
	      
	      for (String key : keyid) {
	         row = sheet3.createRow(rowid++);
	         Object [] objectArr = studentProgram.get(key);
	         int cellid = 0;
	         
	         for (Object obj : objectArr){
	            Cell cell = row.createCell(cellid++);
	            cell.setCellValue((String)obj);
	         }
	      }
	      
	      wb2.write(f);
	      
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
