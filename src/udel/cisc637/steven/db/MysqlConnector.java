package udel.cisc637.steven.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnector {
	
	private static Connection conn = null;
	
	private MysqlConnector(){}
	
	public static Connection getInstance()  {
		if(conn == null){
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/xzhou?" +  "user=xzhou&password=0036");
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
		}else{
			return conn;
		}
	}
}