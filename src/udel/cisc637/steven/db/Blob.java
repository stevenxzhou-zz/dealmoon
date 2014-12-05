package udel.cisc637.steven.db;

import java.nio.file.Path;
import java.sql.*;
import java.io.*;

public class Blob{

Statement statement = null;
PreparedStatement preparedStatement = null;
ResultSet resultSet = null;
private static PreparedStatement pst;

public static void main(String args[]) throws SQLException, IOException{


String filename = "/Users/Steven/Downloads/123.jpg";
InputStream filecontent = new FileInputStream(filename);

String sql="update Products set Image=? where ProductId=?";
pst = MysqlConnector.getInstance().prepareStatement(sql);
int size = filecontent.available();

pst.setBlob(1, filecontent);
pst.setInt(2, 1);
pst.executeUpdate();
ResultSet rs = null;
sql = "SELECT Image FROM Products where ProductID=2";

pst = MysqlConnector.getInstance().prepareStatement(sql);
rs=pst.executeQuery();

if (rs.next()){
    InputStream contentStream = rs.getBinaryStream("Image");
    String newFilename = filename;
    // storing the input stream in the file

    OutputStream out=new FileOutputStream(newFilename);
    byte buf[]=new byte[1024];
    int len;
    while((len=contentStream.read(buf))>0)

    out.write(buf,0,len);
    out.close();
}
}
}