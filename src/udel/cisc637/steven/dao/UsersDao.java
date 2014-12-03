package udel.cisc637.steven.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import app.start.Start;

import udel.cisc637.steven.db.MysqlConnector;
import udel.cisc637.steven.model.UsersModel;

public class UsersDao {
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	private static PreparedStatement pst;
	
	public void addUser(UsersModel user){
		
		try {
			String sql="insert into Users values (?,?,?,?)";
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.setString(1, user.getEmail());
			pst.setString(2, user.getName());
			pst.setString(3, user.getPassword());
			pst.setBoolean(4, user.isAdmin());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void deleteUser(String Email){
		
		try {
			String sql="delete from Users where Email=?";
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.setString(1, Email);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void updateUser(UsersModel user){
		
		try {
			String sql="update Users set Name=?, Password=?, isAdmin=? where Email=?";
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.setString(1, user.getName());
			pst.setString(2, user.getPassword());
			pst.setBoolean(3, user.isAdmin());
			pst.setString(4, user.getEmail());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public UsersModel getUser(String Email){
		
		UsersModel user = new UsersModel();
		try {
			
			String sql="select * from Users where Email=?";
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.setString(1, Email);
			ResultSet rs=pst.executeQuery();
			
			if(rs.next()){
				user.setEmail(rs.getString("Email"));
				user.setName(rs.getString("Name"));
				user.setPassword(rs.getString("Password"));
				user.setAdmin(rs.getBoolean("Admin"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return user;
	}
	
	public List<UsersModel> getAllUsers(){
		
		List<UsersModel> UsersList = new ArrayList<UsersModel>();
		
		try {
			String sql="select * from Users";
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.executeQuery();
			ResultSet rs = pst.getResultSet();

			while(rs.next()){
				UsersModel user = new UsersModel();
				user.setEmail(rs.getString("Email"));
				user.setName(rs.getString("Name"));
				user.setPassword(rs.getString("Password"));
				user.setAdmin(rs.getBoolean("Admin"));
				UsersList.add(user);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return UsersList;
	}

	public void login(UsersModel user){
		
		try {
			String sql="select * from Users where Name=? and Password=?";
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.setString(1, user.getName());
			pst.setString(2, user.getPassword());
			pst.addBatch();
			
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				Start.setAdmin(rs.getBoolean("Admin"));
				Start.setLogin(true);
				Start.setUserName(rs.getString("Name"));
				Start.setEmail(rs.getString("Email"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void logout(){
		Start.setAdmin(false);
		Start.setLogin(false);
	}
}