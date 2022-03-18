package Service;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Object.User;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import java.awt.Dimension;

public class Sign_up extends JFrame {

	private JPanel contentPane;//面板
	private JPasswordField passwordField;//密码输入框
	private JTextField textField;//用户名输入框
	private JButton btnNewButton;//登录按钮
	private JLabel lblNewLabel_1;//用户名文本框
	private JLabel lblNewLabel_2;//密码文本框
	private JLabel lblNewLabel_3;//管理系统文本框
	private JLabel lblNewLabel_4;//小锁头
	private JLabel lblNewLabel_5;//小人

	/**
	 * Launch the application.
	 */
	
	public String get_text() {//获取文本框输入内容
		return textField.getText();
	}
	
	public String get_pass() {//获取密码框输入内容
		return passwordField.getText();
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sign_up frame = new Sign_up(new User());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Sign_up(User user) {
		
		setForeground(Color.WHITE);
		setBackground(Color.WHITE);//设置背景颜色
			
		setTitle("\u5B9E\u9A8C\u7BA1\u7406\u7CFB\u7EDF");//界面名字
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点叉即关闭程序
		setBounds(300, 100, 760, 590);//设置界面的大小
		setResizable(false);//设置界面不可变化
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);//面板创建
		
		passwordField = new JPasswordField();
		passwordField.setBounds(296, 265, 235, 41);
		contentPane.add(passwordField);//密码输入创建
		
		textField = new JTextField();
		textField.setBounds(296, 197, 235, 41);
		contentPane.add(textField);
		textField.setColumns(10);//文本输入创建
		
		
		lblNewLabel_1 = new JLabel("\u7528\u6237\u540D");
		lblNewLabel_1.setFont(new Font("新宋体", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(178, 196, 91, 42);
		contentPane.add(lblNewLabel_1);//用户名
		
		lblNewLabel_2 = new JLabel("\u5BC6\u7801");
		lblNewLabel_2.setFont(new Font("新宋体", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(208, 271, 61, 35);
		contentPane.add(lblNewLabel_2);//密码
		
		lblNewLabel_4 = new JLabel();
		lblNewLabel_4.setIcon(new ImageIcon("image/通用-修改密码图标.png"));
		lblNewLabel_4.setBounds(269, 280, 20, 20);
		contentPane.add(lblNewLabel_4);//锁
		
		lblNewLabel_5 = new JLabel();
		lblNewLabel_5.setIcon(new ImageIcon("image/通用-用户名图标.png"));
		lblNewLabel_5.setBounds(269, 206, 20, 20);
		contentPane.add(lblNewLabel_5);//小人
		
		btnNewButton = new JButton("\u767B\u5F55");//登录按钮创建
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//点击登录按钮后的操作
				
				database_connect dc = new database_connect();
	           
				try {
					PreparedStatement state=dc.conn.prepareStatement("select * from user where user_id=?");
					state.setString(1, get_text());
					
					ResultSet rs = state.executeQuery();
					
					if(rs.next()) {//有返回，即用户名正确
						if(rs.getString("password").equals(get_pass())) {//密码正确
							if(rs.getString("user_type").equals("tch")) {//教师身份
								{//给教师用户赋初值
									user.insert_id(get_text());//输入用户ID
									user.insert_password(get_pass());//输入用户密码
									Statement statement=dc.conn.createStatement();
									ResultSet resultset=statement.executeQuery("select * from teacher where user_id="+user.get_user_id());//寻找数据库中对应用户
									if (resultset.next())//sql有返回
										user.insert_name(resultset.getString("tch_name"));//将教师姓名输入用户姓名
									else {
										Error frame = new Error("教师中不存在该用户",0);
										frame.setVisible(true);//报错界面可见
									}
									
									//System.out.println("id="+user.get_user_id()+",name="+user.get_user_name()+",password="+user.get_user_password());
								}//给教师用户赋初值
								setVisible(false);//登录界面不可见
								activity_choose frame = new activity_choose(user);
								frame.setVisible(true);//教师功能选择界面可见
							}
							else if(rs.getString("user_type").equals("admin")) {//管理员身份
								{//给管理员用户赋初值
									user.insert_id(get_text());//输入用户ID
									user.insert_password(get_pass());//输入用户密码
									Statement statement=dc.conn.createStatement();
									ResultSet resultset=state.executeQuery("select * from administrator where user_id="+user.get_user_id());//寻找数据库中对应用户
									if (resultset.next())//sql有返回
										user.insert_name(resultset.getString("admin_name"));//将管理员姓名输入用户姓名
									else {
										Error frame = new Error("管理员中不存在该用户",0);
										frame.setVisible(true);//报错界面可见
									}
									
									//System.out.println("id="+user.get_user_id()+",name="+user.get_user_name()+",password="+user.get_user_password());
								}//给管理员用户赋初值
									setVisible(false);//登录界面不可见
									super_activity_choose frame = new super_activity_choose(user);
									frame.setVisible(true);//管理员功能选择界面可见
								}
							    else {//除此之外的身份无法登录
							    	Error frame = new Error("该身份无法登录此网站",0);
									frame.setVisible(true);//报错界面可见
							    }
						}
						else {//密码不正确
							
							Error frame = new Error("密码错误",0);
							frame.setVisible(true);//报错界面可见
						}
					}
					else {//无返回，即用户名不正确
						Error frame = new Error("用户不存在",0);
						frame.setVisible(true);//报错界面可见
					}
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(362, 330, 97, 23);
		contentPane.add(btnNewButton);//登录按钮
		
		lblNewLabel_3 = new JLabel("\u5B9E\u9A8C\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel_3.setFont(new Font("楷体", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(316, 73, 184, 57);
		contentPane.add(lblNewLabel_3);//系统说明
		
		setVisible(true);
		
	}
}
