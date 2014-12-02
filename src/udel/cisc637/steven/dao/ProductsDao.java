package udel.cisc637.steven.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import udel.cisc637.steven.app.Main;
import udel.cisc637.steven.db.MysqlConnector;
import udel.cisc637.steven.model.ProductsModel;

public class ProductsDao {
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	private static PreparedStatement pst;
	
	public void addProduct(ProductsModel product){
		String sql="insert into Products (ProductID, ProductName, ListPrice, CurrentPrice, ProductDescription, AddDate, ExpirationDate, Hits, Image, StoreName, SubCategoryName) values (?,?,?,?,?,?,?,?,?,?,?)";
	
		try {
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.setInt(1, product.getProductID());
			pst.setString(2, product.getProductName());
			pst.setDouble(3, product.getListPrice());
			pst.setString(4, product.getProductDescritpion());
			pst.setDouble(5, product.getCurrentPrice());
			pst.setDate(6, product.getAddDate());
			pst.setDate(7, product.getExpirationDate());
			pst.setInt(8, product.getHits());
			pst.setBlob(9, product.getImage());
			pst.setString(10, product.getStoreName());
			pst.setString(11, product.getSubCategoryName());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void deleteProduct(int ProductID){

		try {
			String sql="delete from Products where ProductID=?";
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.setInt(1, ProductID);
			pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void updateProduct(ProductsModel product){
		String sql="update Products set ProductName=?, ListPrice=?, CurrentPrice=?, ProductDescription=?, AddDate=?, ExpirationDate=?, Hits=?, Image=?, StoreName=?, SubCategoryName=? where ProductId=?";
	
		try {
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.setString(1, product.getProductName());
			pst.setDouble(2, product.getListPrice());
			pst.setString(3, product.getProductDescritpion());
			pst.setDouble(4, product.getCurrentPrice());
			pst.setDate(5, product.getAddDate());
			pst.setDate(6, product.getExpirationDate());
			pst.setInt(7, product.getHits());
			pst.setBlob(8, product.getImage());
			pst.setString(9, product.getStoreName());
			pst.setString(10, product.getSubCategoryName());
			pst.setInt(11, product.getProductID());
			pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public List<ProductsModel> getProductsFromSub(String SubCategoryName){
		
		List<ProductsModel> productsList = new ArrayList<ProductsModel>();
		
		try {
			String sql="select * from Products where SubCategoryName=?";
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.setString(1, SubCategoryName);
			pst.executeQuery();
			
			ResultSet rs = pst.getResultSet();
			while(rs.next()){
				ProductsModel productsModel = new ProductsModel();
				productsModel.setProductID(rs.getInt("ProductID"));
				productsModel.setProductName(rs.getString("ProductName"));
				productsList.add(productsModel);
			}
			Main.setSubCategoryName(SubCategoryName);
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productsList;
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
	
	public ProductsModel getProduct(int ProductID){
		
		ProductsModel product=new ProductsModel();
		List<ProductsModel> productsList = new ArrayList<ProductsModel>();
		try {
			String sql="select * from Products where ProductID=?";
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.setInt(1, ProductID);
			pst.executeQuery();
			
			ResultSet rs = pst.getResultSet();

			if(rs.next()){
				product.setProductName(rs.getString("ProductName"));
				product.setProductDescritpion(rs.getString("ProductDescription"));
				product.setCurrentPrice(rs.getDouble("CurrentPrice"));
				product.setListPrice(rs.getDouble("ListPrice"));
				product.setHits(rs.getInt("Hits"));
				productsList.add(product);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}

	public List<ProductsModel> getAllProducts(int items,int page){

		int start=items*page-5;
		List<ProductsModel> productsList = new ArrayList<ProductsModel>();
		
		try {
			String sql="select * from Products limit "+start+","+items;
			pst = MysqlConnector.getInstance().prepareStatement(sql);
			pst.executeQuery();
			ResultSet rs = pst.getResultSet();

			while(rs.next()){
				ProductsModel productsModel = new ProductsModel();
				productsModel.setProductID(rs.getInt("ProductID"));
				productsModel.setProductName(rs.getString("ProductName"));
				productsList.add(productsModel);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productsList;
	}
}
