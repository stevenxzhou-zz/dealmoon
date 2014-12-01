package udel.cisc637.steven.controller;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import udel.cisc637.steven.db.MysqlConnector;
import udel.cisc637.steven.model.FavoritesModel;

public class FavoritesController {
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	private static PreparedStatement pst;
	
	public List<FavoritesModel> getAllFavorites(){
		
		String sql="select * from Favorites";
		List<FavoritesModel> favoritesList = new ArrayList<FavoritesModel>();
		
		try {
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.executeQuery();
			ResultSet rs = pst.getResultSet();

			while(rs.next()){
				FavoritesModel favoritesModel = new FavoritesModel();
				favoritesModel.setStoreName(rs.getString("StoreName"));
				favoritesModel.setEmail(rs.getString("Email"));
				favoritesModel.setProductID(Integer.parseInt(rs.getString("ProductID")));
				favoritesModel.setAddDate(rs.getDate("AddDate"));
				favoritesList.add(favoritesModel);
			}
			return favoritesList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public List<FavoritesModel> addFavorite(String Email, String ProductID, String StoreName, Date AddDate){
		String sql="insert into Favorites values (?,?,?,?)";
		
		try {
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			
			pst.setString(1, Email);
			pst.setString(2, ProductID);
			pst.setString(3, StoreName);
			pst.setDate(4, AddDate);
			
			pst.addBatch();
			MysqlConnector.getInstance().commit();
			
			return getAllFavorites();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 

	}
	
	public List<FavoritesModel> deleteFavoriteStore(String Email, String StoreName){
		
		String sql="delete from Favorites where StoreName=? and Email=? ";
		
		try {
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			
			pst.setString(1, Email);
			pst.setString(2, StoreName);
			
			pst.addBatch();
			MysqlConnector.getInstance().commit();
			return getAllFavorites();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}
	
public List<FavoritesModel> deleteFavoriteProduct(String Email, String ProductID){
		
		String sql="delete from Favorites where ProductID=? and Email=? ";
		
		try {
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			
			pst.setString(1, Email);
			pst.setString(2, ProductID);
			
			pst.addBatch();
			MysqlConnector.getInstance().commit();
			return getAllFavorites();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}
}
