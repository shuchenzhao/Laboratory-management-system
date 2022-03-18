package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class database_order {
	
	public ResultSet resultset;//操作返回的结果集
	private Statement state; 
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		database_order dc = new database_order("select * from user");
	}

	public database_order(String order) {
    	
    	try {
    		database_connect dc = new database_connect();
            //System.out.println("成功连接MySQL");
    		
            state=dc.conn.createStatement();
            resultset=state.executeQuery(order);//执行命令
            
            //while (resultset.next()) {
            //	System.out.println(resultset.getString(1)+"\t"+resultset.getString(2)+"\t"+resultset.getString(3));
            //}
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	
    }
	
}
