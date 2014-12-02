package udel.cisc637.steven.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import udel.cisc637.steven.db.MysqlConnector;
import udel.cisc637.steven.model.FavoritesModel;

public class FavoritesDao {
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	private static PreparedStatement pst;
	
	public void addFavorite(FavoritesModel favorite){
		
		try {
			String sql="insert into Favorites values (?,?,?,?)";
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.setString(1, favorite.getEmail());
			pst.setInt(2, favorite.getProductID());
			pst.setString(3, favorite.getStoreName());
			pst.setDate(4, favorite.getAddDate());
			
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteFavoriteStore(String Email, String StoreName){
		
		try {
			String sql="delete from Favorites where StoreName=? and Email=? ";
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.setString(1, Email);
			pst.setString(2, StoreName);
			pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	public void deleteFavoriteProduct(String Email, String ProductID){
		
		try {
			String sql="delete from Favorites where ProductID=? and Email=? ";
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.setString(1, Email);
			pst.setString(2, ProductID);
			pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	public List<FavoritesModel> getFavoritesByEmail(String Email){
		
		List<FavoritesModel> favoritesList = new ArrayList<FavoritesModel>();
		
		try {
			String sql="select * from Favorites where Email=?";
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.setString(1, Email);
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
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return favoritesList;
	}
		
	public List<FavoritesModel> getAllFavorites(){
	
	List<FavoritesModel> favoritesList = new ArrayList<FavoritesModel>();
	
	try {
		String sql="select * from Favorites";
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
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return favoritesList;
	}
}
