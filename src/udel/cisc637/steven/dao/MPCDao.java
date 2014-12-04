package udel.cisc637.steven.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import udel.cisc637.steven.db.MysqlConnector;
import udel.cisc637.steven.model.MPCModel;

public class MPCDao {
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	private static PreparedStatement pst;
	
	public void addMainCategory(MPCModel MainCategory){
		
		String sql="insert into MainProductCategory values (?)";
		try {
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.setString(1, MainCategory.getMainProductName());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void deleteMainCategory(String MainCategoryName){
		
		String sql="delete from MainProductCategory where MainCategoryName=?";
		
		try {
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.setString(1, MainCategoryName);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Please input an existing MainCategoryName!");
		} 
	}
	
	public void updateMainCategory(MPCModel MainCategoryOld, MPCModel MainCategoryNew){
		
		String sql="update MainProductCategory set MainCategoryName=? where MainCategoryName=? ";
		try {
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.setString(1, MainCategoryNew.getMainProductName());
			pst.setString(2, MainCategoryOld.getMainProductName());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Please input an existing MaincategoryName!");
		} 
	}

	public List<MPCModel> getAllMainCategories(){
		
		List<MPCModel> mpcList = new ArrayList<MPCModel>();
		try {
			String sql="select * from MainProductCategory";
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.executeQuery();
			ResultSet rs = pst.getResultSet();

			while(rs.next()){
				MPCModel mpcModel = new MPCModel();
				mpcModel.setMainProductName(rs.getString("MainCategoryName"));
				mpcList.add(mpcModel);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mpcList;
	}
}
