package udel.cisc637.steven.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import udel.cisc637.steven.db.MysqlConnector;
import udel.cisc637.steven.model.StoresModel;
import udel.cisc637.steven.model.StoresModel;

public class StoresController {
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	private static PreparedStatement pst;
	
	public List<StoresModel> getAllStores(int items,int page){
		
		int start=items*page-5;
		String sql="select * from Stores limit "+start+","+items;
		List<StoresModel> StoresList = new ArrayList<StoresModel>();
		
		try {
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.executeQuery();
			ResultSet rs = pst.getResultSet();

			while(rs.next()){
				StoresModel StoresModel = new StoresModel();
				StoresModel.setStoreName(rs.getString("StoreName"));
				StoresList.add(StoresModel);
			}
			return StoresList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public List<StoresModel> addStore(String StoreName){
		String sql="insert into Stores values ("+StoreName+")";
	
		try {
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.executeQuery();
			return getAllStores(5,1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}
	
	public List<StoresModel> deleteStore(String StoreName){
		
		String sql="delete from Stores where StoreName='"+StoreName+"'";
		
		try {
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.executeQuery();
			return getAllStores(5,1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}
	
	public List<StoresModel> getStore(String StoreName){
		
		String sql="select * from Stores where StoreName='"+StoreName+"'";
		List<StoresModel> storesList = new ArrayList<StoresModel>();
		
		try {
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.executeQuery();
			ResultSet rs = pst.getResultSet();

			while(rs.next()){
				StoresModel storesModel = new StoresModel();
				storesModel.setStoreName(rs.getString("StoreName"));
				storesModel.setStoreLink(rs.getString("StoreLink"));
				storesList.add(storesModel);
			}
			return storesList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
