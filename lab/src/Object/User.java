package Object;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Service.database_connect;

public class User {

	private String user_id;//用户ID
	private String user_name;//用户名字
	private String user_password;//用户密码

	public String get_user_name() {//获得姓名
		return user_name;
	}
	
	public String get_user_password() {//获得密码
		return user_password;
	}
	
	public String get_user_id() {//获得ID
		return user_id;
	}
	
	public User() {
		
	}
	
	public void insert_id(String id) {//写入id
		user_id=id;
	}
	
	public void insert_name(String name) {//写入姓名
		user_name=name;
	}
	
	public void insert_password(String password) {//写入密码
		user_password=password;
	}
	
	public void change_password(String password) {//修改密码
		//user_password=password;
		insert_password(password);//把对象的密码修改
		String order="update user set password="+password+" where user_id="+user_id;//更改数据库的命令
		database_connect dc = new database_connect();
        //System.out.println("成功连接MySQL");
		
		Statement state;
		try {
			state = dc.conn.createStatement();
			state.executeUpdate(order);//执行命令，更改数据库中的密码
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
      
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		//User user=new User();
		//user.insert_id("1903070015");
		//user.insert_password("1234");
		//user.change_password("1633");
		
	}

}
