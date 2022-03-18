package Service;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.xdevapi.Statement;

import Object.Experiment;
import Object.User;

public class Grade_choose_student extends JFrame {
	private JPanel contentPane;//面板
	private JButton btnNewButton_1;//返回图片按钮
	private JLabel lblNewLabel_1;//姓名
	private JLabel lblNewLabel_2;//学号
	private JLabel lblNewLabel_3;//提示
	private JLabel lblNewLabel_4;//成绩
	private JButton btnNewButton_2;//确定按钮
	private JTextField textField;//姓名
	private JTextField textField_1;//学号
	private JTextField textField_2;//成绩
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Grade_choose_student frame = new Grade_choose_student(new User(),new Experiment());
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
	public Grade_choose_student(User user,Experiment exp) {
		setTitle("\u6210\u7EE9\u7BA1\u7406");//界面名字
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点叉即关闭程序
		setBounds(300, 100, 760, 590);//设置界面的大小
		setResizable(false);//设置界面不可变化
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);//面板
		
		btnNewButton_1=new JButton();
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);//成绩管理·具体实验界面不可见
				Grade_management frame = new Grade_management(user);
				frame.setVisible(true);//成绩管理界面可见
			}
		});
		contentPane.setLayout(null);
		btnNewButton_1.setIcon(new ImageIcon("image/通用-退出登录图标.png"));
		btnNewButton_1.setBounds(80, 80, 60, 60);
		btnNewButton_1.setBorderPainted(false);
		contentPane.add(btnNewButton_1);//返回图片按钮
		
		lblNewLabel_1 = new JLabel("\u59D3\u540D");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(183, 196, 80, 32);
		contentPane.add(lblNewLabel_1);//姓名
		
		lblNewLabel_2 = new JLabel("\u5B66\u53F7*");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(183, 283, 80, 32);
		contentPane.add(lblNewLabel_2);//学号
		
		lblNewLabel_3 = new JLabel("\u8BF7\u8F93\u5165\u59D3\u540D\u5B66\u53F7\u53CA\u6210\u7EE9");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 35));
		lblNewLabel_3.setBounds(221, 53, 372, 60);
		contentPane.add(lblNewLabel_3);//提示
		
		lblNewLabel_4 = new JLabel("\u6210\u7EE9*");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel_4.setBounds(183, 368, 80, 32);
		contentPane.add(lblNewLabel_4);//成绩
		
		btnNewButton_2 = new JButton("\u786E\u5B9A");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s0=textField.getText();//姓名
				String s1=textField_1.getText();//学号
				String s2=textField_2.getText();//成绩
				
				String order="select stu_name from student where user_id="+s1;//获取学号对应姓名的命令
				String order1="select user_id from student where user_id="+s1;//判断学号是否存在的命令
				ResultSet result;//获取数据库中姓名的state
				ResultSet result1;//获取数据库中学号的state
				database_order dc = new database_order(order);//执行命令，获取数据库中姓名
				database_order dc1 = new database_order(order1);//执行命令，获取数据库中的学号
				result=dc.resultset;
				result1=dc1.resultset;
				try {
					if(result1.next()&&result1.getString(1).equals(s1)) {//输入了学号
						if(result.next()) {//学号有对应姓名
							if(!s0.equals("")) {//输入了姓名
								if(s0.equals(result.getString(1))) {//姓名与学号匹配
									String order3="update mark set mark="+s2+" where user_id="+s1+" and exp_id='"+exp.get_exp_id()+"'";//更改数据库的命令
									database_connect dc2 = new database_connect();
							        java.sql.Statement state;
									try {
										state = dc2.conn.createStatement();
										state.executeUpdate(order3);//执行命令，更改数据库中的成绩
										Error frame = new Error("成绩添加成功",1);
										frame.setVisible(true);//提示界面可见
									} catch (SQLException e1) {
										// TODO 自动生成的 catch 块
										e1.printStackTrace();
									}
								}
								else {
									Error frame = new Error("学号与姓名不匹配",0);
									frame.setVisible(true);//报错界面可见
								}
							}
							else {//没输入姓名
								String order3="update mark set mark="+s2+" where user_id="+s1+" and exp_id='"+exp.get_exp_id()+"'";//更改数据库的命令
								database_connect dc2 = new database_connect();
								java.sql.Statement state;
								try {
									state = dc2.conn.createStatement();
									state.executeUpdate(order3);//执行命令，更改数据库中的成绩
									Error frame = new Error("成绩添加成功",1);
									frame.setVisible(true);//提示界面可见
								} catch (SQLException e1) {
									// TODO 自动生成的 catch 块
									e1.printStackTrace();
								}
							}
						}
					}
					else {
						Error frame = new Error("尚未输入学号或学号不正确",0);
						frame.setVisible(true);//报错界面可见
					}
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 17));
		btnNewButton_2.setBounds(351, 466, 97, 23);
		contentPane.add(btnNewButton_2);//确定按钮
		
		textField = new JTextField();
		textField.setBounds(292, 196, 234, 32);
		contentPane.add(textField);
		textField.setColumns(10);//姓名
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(292, 289, 234, 32);
		contentPane.add(textField_1);//学号
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(292, 374, 234, 32);
		contentPane.add(textField_2);//成绩
		
		setVisible(true);
	}
}
