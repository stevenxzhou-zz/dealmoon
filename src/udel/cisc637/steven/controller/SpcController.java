package udel.cisc637.steven.controller;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import udel.cisc637.steven.db.MysqlConnector;
import udel.cisc637.steven.model.SpcModel;

public class SpcController {
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	private static PreparedStatement pst;
	
	public List<SpcModel> getAllSubCategories(){
		
		String sql="select * from SubProductCategory";
		List<SpcModel> spcList = new ArrayList<SpcModel>();
		
		try {
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.executeQuery();
			ResultSet rs = pst.getResultSet();

			while(rs.next()){
				SpcModel spcModel = new SpcModel();
				spcModel.setSubProductName(rs.getString("SubCategoryName"));
				spcModel.setMainProductName(rs.getString("MainCategoryName"));
				spcList.add(spcModel);
			}
			return spcList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public List<SpcModel> getSubCategoriesFromMain(String MainCategoryName){
		
		String sql="select * from SubProductCategory where MainCategoryName='"+MainCategoryName+"'";
		List<SpcModel> spcList = new ArrayList<SpcModel>();
		
		try {
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.executeQuery();
			ResultSet rs = pst.getResultSet();

			while(rs.next()){
				SpcModel spcModel = new SpcModel();
				spcModel.setSubProductName(rs.getString("SubCategoryName"));
				spcModel.setMainProductName(rs.getString("MainCategoryName"));
				spcList.add(spcModel);
			}
			return spcList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public List<SpcModel> addSubCategory(String MainCategoryName, String SubCategoryName){
		
		String sql="insert into SubProductCategory values ('"+SubCategoryName+"','"+MainCategoryName+"')";
	
		try {
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.executeQuery();
			return getAllSubCategories();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}
	
	public List<SpcModel> deleteSubCategory(String SubCategoryName){
		
		String sql="delete from SubProductCategory where SubCategoryName='"+SubCategoryName+"'";
		
		try {
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.executeQuery();
			return getAllSubCategories();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}
}
