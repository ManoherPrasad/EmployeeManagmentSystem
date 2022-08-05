package Employee;

import java.sql.*;

public class ConnectionToMySQL {

	public Connection c;
	public Statement s;
	
	public ConnectionToMySQL() {
		
		try {
			Class.forName("com.mysql,jdbc.Driver");
			c =DriverManager.getConnection("jdbc:mysql://project2","root","root");
			s =c.createStatement();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
