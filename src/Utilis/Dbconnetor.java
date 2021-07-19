package Utilis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnetor {
	
	private static Connection cn;
	public static Connection fetchConnection() throws ClassNotFoundException, SQLException {
		if(cn==null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/test?useSSL=false&allowPublicKeyRetrieval=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			cn=DriverManager.getConnection(url,"root","12345");
		}
		return cn;
		
		
	}
}
