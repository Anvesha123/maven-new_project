
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

public class Employeedao {
	public void insert(Employee emp) 
	{

	Connection conn=null;
	PreparedStatement ps=null;
	try
	{
		InputStream is=this.getClass().getResourceAsStream("dev-db.properties");
		Properties dbProps=new Properties();
		dbProps.load(is);
		String driverClassName=dbProps.getProperty("driverClassName");
		String url= dbProps.getProperty("url");
		String username= dbProps.getProperty("username");
		String password= dbProps.getProperty("password");
		Class.forName(driverClassName);
	    conn=DriverManager.getConnection(url,username,password);	
	    System.out.println("Connected");
	    ps=conn.prepareStatement("insert into emp3 values(?,?,?)");
	    ps.setString(1,emp.getEmpno());
	    ps.setString(2,emp.getName());
	    ps.setString(3,emp.getSalary());
	    ps.executeUpdate();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		try
		{
			ps.close();
		}
		catch(Exception e)
		{
			
		}
		try
		{
			conn.close();
		}
		catch(Exception e)
		{
			
		}
	}
	}
}