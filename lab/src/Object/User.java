package Object;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Service.database_connect;

public class User {

	private String user_id;//�û�ID
	private String user_name;//�û�����
	private String user_password;//�û�����

	public String get_user_name() {//�������
		return user_name;
	}
	
	public String get_user_password() {//�������
		return user_password;
	}
	
	public String get_user_id() {//���ID
		return user_id;
	}
	
	public User() {
		
	}
	
	public void insert_id(String id) {//д��id
		user_id=id;
	}
	
	public void insert_name(String name) {//д������
		user_name=name;
	}
	
	public void insert_password(String password) {//д������
		user_password=password;
	}
	
	public void change_password(String password) {//�޸�����
		//user_password=password;
		insert_password(password);//�Ѷ���������޸�
		String order="update user set password="+password+" where user_id="+user_id;//�������ݿ������
		database_connect dc = new database_connect();
        //System.out.println("�ɹ�����MySQL");
		
		Statement state;
		try {
			state = dc.conn.createStatement();
			state.executeUpdate(order);//ִ������������ݿ��е�����
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
      
	}
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

		//User user=new User();
		//user.insert_id("1903070015");
		//user.insert_password("1234");
		//user.change_password("1633");
		
	}

}
