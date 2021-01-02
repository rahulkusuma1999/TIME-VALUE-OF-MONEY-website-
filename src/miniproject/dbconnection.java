package miniproject;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbconnection {

	 public static Connection con=null;
	 public static Connection connection(){
	 
	 
	 	try {
	 		if(con==null)
	 		{
	 		Class.forName("com.mysql.jdbc.Driver");
	 		System.out.println("Driver Loaded..");
	         con =
	         DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_project","root","");
	         System.out.println("Connection Eastablished:");
	         
	 		}
	 	}
	         catch(Exception e)	
	         {
	         	System.err.println(e);
	         	e.printStackTrace();

	 	}	 	return con;

}
}