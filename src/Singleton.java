import java.sql.*;

public class Singleton {

	private static Singleton instance;
	public Connection cnx;
	
	
	private Singleton() throws SQLException{
			cnx = DriverManager.getConnection("jdbc:mariadb://localhost:3306/worlddb?user=admin&password=root");
	}
	
	public static Singleton getInstance() throws SQLException {
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
}
