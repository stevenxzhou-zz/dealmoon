package udel.cisc637.steven.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import udel.cisc637.steven.db.MysqlConnector;
import udel.cisc637.steven.model.SPCModel;

public class SPCDao {
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	private static PreparedStatement pst;
	
	
	
	public void addSubCategory(SPCModel spcModel){
		
		try {
			String sql="insert into SubProductCategory values (?,?)";
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.setString(1, spcModel.getMainProductName());
			pst.setString(2, spcModel.getSubProductName());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void deleteSubCategory(String SubCategoryName){
		
		try {
			String sql="delete from SubProductCategory where SubCategoryName=?";
			pst.setString(1, SubCategoryName);
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void updateSubCategory(SPCModel spcModelOld,SPCModel spcModelNew){
		
		try {
			String sql="update SubProductCategory set SubCategoryName=?, MainCategoryName=? where SubCategoryName=? and MainCategoryName=?";
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.setString(1, spcModelNew.getMainProductName());
			pst.setString(2, spcModelNew.getSubProductName());
			pst.setString(3, spcModelOld.getMainProductName());
			pst.setString(4, spcModelOld.getSubProductName());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public List<SPCModel> getAllSubCategories(){
		
		List<SPCModel> spcList = new ArrayList<SPCModel>();
		try {
			String sql="select * from SubProductCategory";
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.executeQuery();
			ResultSet rs = pst.getResultSet();

			while(rs.next()){
				SPCModel spcModel = new SPCModel();
				spcModel.setSubProductName(rs.getString("SubCategoryName"));
				spcModel.setMainProductName(rs.getString("MainCategoryName"));
				spcList.add(spcModel);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return spcList;
	}
	
	public List<SPCModel> getSubCategoriesByMainCategoryName(String MainCategoryName){
		
		List<SPCModel> spcList = new ArrayList<SPCModel>();
		
		try {
			String sql="select * from SubProductCategory where MainCategoryName=?";
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.setString(1, MainCategoryName);
			pst.executeQuery();
			ResultSet rs = pst.getResultSet();

			while(rs.next()){
				SPCModel spcModel = new SPCModel();
				spcModel.setSubProductName(rs.getString("SubCategoryName"));
				spcModel.setMainProductName(rs.getString("MainCategoryName"));
				spcList.add(spcModel);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return spcList;
	}
}
