import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		    Class.forName("com.mysql.jdbc.Driver");
		    Connection con = DriverManager.getConnection(
		    		"jdbc:mysql://localhost:3306/storefront","root","xerxes");
		    
		    Statement stmt = con.createStatement();
		    //Assignment1
		    Scanner input = new Scanner(System.in);
		    System.out.println("Enter shopperID");
		    int shopperID = input.nextInt();
		    ResultSet rs = stmt.executeQuery("select ShopperID,OrderID,Order_date,Order_status from orders where ShopperID="+shopperID+" and Order_status='shipped' ;");
		    System.out.println("ShopperID"+"\t"+"OrderID"+"\t "+"Order_date"+"\t"+"Order_status"+" ");
		    while(rs.next()){
		    	System.out.println(rs.getInt(1)+"\t\t "+rs.getInt(2) +"\t "+rs.getString(3)+"\t "+rs.getString(4)+"\t ");
		    }
		    
		    //Assinment2
		    /*java.sql.PreparedStatement pstmt= con.prepareStatement("insert into ProductImage values(?,?,?);");
		    pstmt.setInt(1, 1);
		    InputStream in = new FileInputStream("C:\\Users\\himanshu.somani_meta\\Downloads\\1613621366186.jpg");
		    pstmt.setInt(2, 1);
		    pstmt.setBlob(3, in);
		    pstmt.execute();*/
		    
		    
		    
		  //Assignment3
		    
		    stmt.executeUpdate("drop table if exists DP ;");
		    stmt.executeUpdate("create table DP(select p.ProductID from product as p left outer join orders as o on o.ProductID=p.ProductID where o.ProductID is null);");
		    ResultSet rs2=stmt.executeQuery("select count(ProductID) from DP;");
		    System.out.println(rs2.next());
		    System.out.println(rs2.getInt(1));
		    stmt.executeUpdate("delete product from product,DP where product.ProductID=  DP.ProductID ;");
		    
		    
		  //Assignment4
		    ResultSet rs3=stmt.executeQuery("select c.ID,c.Name , count(sc.ID) from categories as c,sub_categories as sc where c.ID=sc.Parent_CategorieID group by c.Name order by c.ID asc; ");
		    while(rs3.next()){
		    	System.out.println(rs3.getInt(1)+"\t"+rs3.getString(2)+"\t"+rs3.getInt(3));
		    }
		    
		    con.close();
		} catch ( ClassNotFoundException cnfe) {
		    System.out.println("Error loading driver: " +cnfe);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
