package udel.cisc637.steven.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import udel.cisc637.steven.app.Main;
import udel.cisc637.steven.db.MysqlConnector;
import udel.cisc637.steven.model.UsersModel;

public class UsersController {
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	private static PreparedStatement pst;
	
	public List<UsersModel> getAllUsers(){
		
		String sql="select * from Users";
		List<UsersModel> UsersList = new ArrayList<UsersModel>();
		
		try {
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.executeQuery();
			ResultSet rs = pst.getResultSet();

			while(rs.next()){
				UsersModel UsersModel = new UsersModel();
				UsersModel.setName(rs.getString("Name"));
				UsersList.add(UsersModel);
			}
			return UsersList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public List<UsersModel> addUser(String UserName){
		String sql="insert into Users values ("+UserName+")";
	
		try {
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.executeQuery();
			return getAllUsers();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}
	
	public List<UsersModel> deleteUser(String UserName){
		
		String sql="delete from Users where Name='"+UserName+"'";
		
		try {
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.executeQuery();
			return getAllUsers();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}
	
	public void login(String Name, String Password){
		
		String sql="select * from Users where Name=? and Password=?";
		
		try {
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			
			pst.setString(1, Name);
			pst.setString(2, Password);
			
			pst.addBatch();
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				
				Main.setUser(true);
				boolean isAdmin = rs.getBoolean("Admin");
				Main.setAdmin(isAdmin);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void logout(){
	
		Main.setUser(false);
		Main.setAdmin(false);
		
	}
}