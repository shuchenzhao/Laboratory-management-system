package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class database_order {
	
	public ResultSet resultset;//�������صĽ����
	private Statement state; 
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		database_order dc = new database_order("select * from user");
	}

	public database_order(String order) {
    	
    	try {
    		database_connect dc = new database_connect();
            //System.out.println("�ɹ�����MySQL");
    		
            state=dc.conn.createStatement();
            resultset=state.executeQuery(order);//ִ������
            
            //while (resultset.next()) {
            //	System.out.println(resultset.getString(1)+"\t"+resultset.getString(2)+"\t"+resultset.getString(3));
            //}
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	
    }
	
}
