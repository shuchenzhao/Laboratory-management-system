package Service;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Object.User;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class Student_insert extends JFrame {

	private JPanel contentPane;//面板
	private JButton btnNewButton_1;//返回图片按钮
	private JLabel lblNewLabel;//学号
	private JLabel lblNewLabel_1;//学生姓名
	private JLabel lblNewLabel_2;//学生性别
	private JLabel lblNewLabel_3;//所属班级
	private JTextField textField;//学号文本
	private JTextField textField_1;//学生姓名文本
	private JComboBox comboBox_2;//学生性别文本
	private JComboBox comboBox;//所属班级下拉框
	private JButton btnNewButton;//确定

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_insert frame = new Student_insert(new User());
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
	public Student_insert(User user) {
		setTitle("学生录入");//界面名字
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点叉即关闭程序
		setBounds(300, 100, 760, 590);//设置界面的大小
		setResizable(false);//设置界面不可变化
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);//面板
		
		btnNewButton_1=new JButton();
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);//学生录入界面不可见
				Insert frame = new Insert(user);
				frame.setVisible(true);//录入界面可见
			}
		});
		contentPane.setLayout(null);
		btnNewButton_1.setIcon(new ImageIcon("image/通用-退出登录图标.png"));
		btnNewButton_1.setBounds(80, 80, 60, 60);
		btnNewButton_1.setBorderPainted(false);
		contentPane.add(btnNewButton_1);//用户中心图片按钮
		
		lblNewLabel = new JLabel("学号");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel.setBounds(154, 174, 113, 35);
		contentPane.add(lblNewLabel);//学号
		
		lblNewLabel_1 = new JLabel("学生姓名");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(154, 234, 122, 35);
		contentPane.add(lblNewLabel_1);//学生姓名
		
		lblNewLabel_2 = new JLabel("学生性别");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(154, 294, 122, 35);
		contentPane.add(lblNewLabel_2);//学生性别
		
		lblNewLabel_3 = new JLabel("所属班级");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(154, 352, 122, 35);
		contentPane.add(lblNewLabel_3);//所属班级
		
		textField = new JTextField();
		textField.setBounds(300, 174, 233, 35);
		contentPane.add(textField);
		textField.setColumns(10);//学号文本
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(300, 234, 233, 35);
		contentPane.add(textField_1);//学生姓名文本
		
		Vector v2 = new Vector();//存放性别的vector
		v2.addElement("男");
		v2.addElement("女");
		comboBox_2 = new JComboBox(v2);
		comboBox_2.setBounds(300, 294, 233, 35);
		contentPane.add(comboBox_2);//学生性别文本
		
		Vector v6 = new Vector();//存放班级号的vector
		String order6="select class_id from class";//获取班级号的命令
		ResultSet result6;//获取数据库中的班级号的state
		database_order dc6 = new database_order(order6);//执行命令，获取班级号
		result6=dc6.resultset;
		try {
			while(result6.next()) {//将教室号输入对应vector
				v6.addElement(result6.getString(1));
			}
		} catch (SQLException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		comboBox = new JComboBox(v6);
		comboBox.setBounds(301, 352, 232, 35);
		contentPane.add(comboBox);//所属班级下拉框
		
		btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String stu_sex=comboBox_2.getSelectedItem().toString();
				String stu_class=comboBox.getSelectedItem().toString();
				String user_id=textField.getText();
				String stu_name=textField_1.getText();
				
				String order="insert into student values("+user_id+",'"+stu_name+"','"+stu_sex+"','"+stu_class+"')";//更改数据库的命令
				database_connect dc = new database_connect();
				Statement state;
				try {
					state = dc.conn.createStatement();
					state.executeUpdate(order);
					Error frame = new Error("学生录入成功",1);
					frame.setVisible(true);//报错界面可见
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}//执行命令，更改数据库中类型
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 17));
		btnNewButton.setBounds(322, 452, 97, 23);
		contentPane.add(btnNewButton);//确定
		
		setVisible(true);
	}

}
