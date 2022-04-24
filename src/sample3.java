import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class sample3
{
	public static void main(String st[])
	{
		 Connection con;
		 Statement st1;
		 try{
		   Class.forName("com.mysql.jdbc.Driver");
		   con=DriverManager.getConnection("jdbc:mysql://localhost/msudb","root","");
		   st1=con.createStatement();
		   ResultSet rs=st1.executeQuery("select * from user");
		   rs.next();
		   System.out.println("USER NAME: "+rs.getString(1));
		   System.out.println("PASSWORD: "+rs.getString(2));
		   
       	}
		 catch(Exception e)
		 {
			 System.out.println(e.getMessage());
			 
		 }
		   
		
		
	}

}
