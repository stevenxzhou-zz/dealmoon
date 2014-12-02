package udel.cisc637.steven.db;

import java.sql.*;

public class MysqlConnector {
	
	private static Connection conn = null;
	
	private MysqlConnector(){}
	
	public static Connection getInstance()  {
		if(conn == null){
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/xzhou?"+"user=xzhou&password=0036"+"&autoReconnect=true&failOverReadOnly=false&maxReconnects=10");
//				if(!conn.isClosed()){
//					System.out.println("Success");
//				}
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
		}else{
			return conn;
		}
	}
}