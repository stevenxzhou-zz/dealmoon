package udel.cisc637.steven.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import udel.cisc637.steven.app.Main;
import udel.cisc637.steven.db.MysqlConnector;
import udel.cisc637.steven.model.ProductsModel;
import udel.cisc637.steven.model.SpcModel;

public class ProductsController {
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	private static PreparedStatement pst;
	
	public List<ProductsModel> getAllProducts(int items,int page){

		int start=items*page-5;

		String sql="select * from Products limit "+start+","+items;
		List<ProductsModel> productsList = new ArrayList<ProductsModel>();
		
		try {
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.executeQuery();
			ResultSet rs = pst.getResultSet();

			while(rs.next()){
				ProductsModel productsModel = new ProductsModel();
				productsModel.setProductID(rs.getInt("ProductID"));
				productsModel.setProductName(rs.getString("ProductName"));
				productsList.add(productsModel);
			}
			return productsList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public List<ProductsModel> getProduct(String ProductID){
		
		String sql="select * from Products where ProductID="+ProductID;
		List<ProductsModel> productsList = new ArrayList<ProductsModel>();
		
		try {
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.executeQuery();
			ResultSet rs = pst.getResultSet();

			while(rs.next()){
				ProductsModel productsModel = new ProductsModel();
				productsModel.setProductName(rs.getString("ProductName"));
				productsModel.setProductDescritpion(rs.getString("ProductDescription"));
				productsModel.setCurrentPrice(rs.getDouble("CurrentPrice"));
				productsModel.setListPrice(rs.getDouble("ListPrice"));
				productsModel.setHits(rs.getInt("Hits"));
				productsList.add(productsModel);
			}
			return productsList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public List<ProductsModel> addProduct(String ProductName){
		String sql="insert into Products values ("+ProductName+")";
	
		try {
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.executeQuery();
			return getAllProducts(5,1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}
	
	public List<ProductsModel> deleteProduct(String ProductName){
		
		String sql="delete from Products where ProductName='"+ProductName+"'";
		
		try {
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.executeQuery();
			return getAllProducts(5,1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}
	
	public List<ProductsModel> getProductsFromSub(String SubCategoryName){
		
		
		String sql="select * from Products where SubCategoryName='"+SubCategoryName+"'";
		List<ProductsModel> productsList = new ArrayList<ProductsModel>();
		
		try {
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.executeQuery();
			ResultSet rs = pst.getResultSet();

			while(rs.next()){
				ProductsModel productsModel = new ProductsModel();
				productsModel.setProductID(rs.getInt("ProductID"));
				productsModel.setProductName(rs.getString("ProductName"));
				productsList.add(productsModel);
			}
			Main.setSubCategoryName(SubCategoryName);
			return productsList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public List<ProductsModel> getProductFromStoreName(String StoreName){
		
		String sql="select * from Products where StoreName='"+StoreName+"'";
		List<ProductsModel> productsList = new ArrayList<ProductsModel>();
		
		try {
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.executeQuery();
			ResultSet rs = pst.getResultSet();

			while(rs.next()){
				ProductsModel productsModel = new ProductsModel();
				productsModel.setProductID(rs.getInt("ProductID"));
				productsModel.setProductName(rs.getString("ProductName"));
				productsList.add(productsModel);
			}
			Main.setStoreName(StoreName);
			return productsList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
