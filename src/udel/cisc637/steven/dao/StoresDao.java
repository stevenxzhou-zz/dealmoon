package udel.cisc637.steven.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import udel.cisc637.steven.db.MysqlConnector;
import udel.cisc637.steven.model.StoresModel;
import udel.cisc637.steven.model.StoresModel;

public class StoresDao {
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	private static PreparedStatement pst;
	
	
	
	public void addStore(StoresModel store){
		
		try {
			String sql="insert into Stores values (?,?,?)";
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.setString(1, store.getStoreName());
			pst.setString(2, store.getStoreLink());
			pst.setBlob(3, store.getStoreLogo());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void deleteStore(String StoreName){
		
		try {
			String sql="delete from Stores where StoreName=?";
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.setString(1, StoreName);
			pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void updateStore(StoresModel store){
		
		try {
			String sql="update Stores set StoreLink= ? where StoreName=?";
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.setString(1, store.getStoreLink());
			pst.setString(2, store.getStoreName());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public StoresModel getStore(String StoreName){
		
		
		StoresModel store = new StoresModel();
		
		try {
			String sql="select * from Stores where StoreName=?";
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.setString(1, StoreName);
			pst.executeQuery();
			ResultSet rs = pst.getResultSet();

			if(rs.next()){
				store.setStoreName(rs.getString("StoreName"));
				store.setStoreLink(rs.getString("StoreLink"));
				store.setStoreLogo(rs.getBlob("StoreLogo"));
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return store;
	}
	
	public List<StoresModel> getAllStores(int items,int page){
		
		int start=items*page-5;
		
		List<StoresModel> StoresList = new ArrayList<StoresModel>();
		
		try {
			String sql="select * from Stores limit "+start+","+items;
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.executeQuery();
			ResultSet rs = pst.getResultSet();

			while(rs.next()){
				StoresModel StoresModel = new StoresModel();
				StoresModel.setStoreName(rs.getString("StoreName"));
				StoresList.add(StoresModel);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return StoresList;
	}
}
