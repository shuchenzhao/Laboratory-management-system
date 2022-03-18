package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.Spring;

import java.sql.ResultSet;

public class database_connect {
	
	public Connection conn;//连接
	
    public static void main(String[] args) {
       
    	database_connect order = new database_connect();
    	
    }
    
    public database_connect() {
    	
    	try {//连接到数据库中
    		
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn =DriverManager.getConnection("jdbc:mysql://localhost/laboratory?" +
			"user=root&password=1234");
            //System.out.println("成功连接MySQL");
            //Statement stat=conn.createStatement();
            //ResultSet rs=stat.executeQuery(order);
            //resultset=rs;
            //while (resultset.next()) {
            //	System.out.println(resultset.getString("loan_number")+"\t"+resultset.getString(2)+"\t"+resultset.getInt(3));
            //}
            
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	
    }
	    
}
