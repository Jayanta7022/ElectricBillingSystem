package ElectricityBillingSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conn {

	Connection c;
	Statement s;
	Conn(){
		//Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs","root","");
			s=c.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
