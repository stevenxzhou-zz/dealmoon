package udel.cisc637.steven.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import udel.cisc637.steven.db.MysqlConnector;
import udel.cisc637.steven.model.MpcModel;

public class MpcController {
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	private static PreparedStatement pst;
	
	public List<MpcModel> getAllMainCategories(){
		
		String sql="select * from MainProductCategory";
		List<MpcModel> mpcList = new ArrayList<MpcModel>();
		
		try {
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.executeQuery();
			ResultSet rs = pst.getResultSet();

			while(rs.next()){
				MpcModel mpcModel = new MpcModel();
				mpcModel.setMainProductName(rs.getString("MainCategoryName"));
				mpcList.add(mpcModel);
			}
			return mpcList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public List<MpcModel> addMainCategory(String MainCategoryName){
		String sql="insert into MainProductCategory values ("+MainCategoryName+")";
	
		try {
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.executeQuery();
			return getAllMainCategories();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}
	
	public List<MpcModel> deleteMainCategory(String MainCategoryName){
		
		String sql="delete from MainProductCategory where MaincategoryName='"+MainCategoryName+"'";
		
		try {
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.executeQuery();
			return getAllMainCategories();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}
}
