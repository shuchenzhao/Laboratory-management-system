package Service;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Object.User;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.util.Vector;
import javax.swing.JTextField;
import java.awt.Font;

public class Class_insert extends JFrame {

	private JPanel contentPane;//面板
	private JButton btnNewButton;//确定
	private JButton btnNewButton_1;//返回图片按钮
	private JTextField textField;//班级ID
	private JTextField textField_1;//班级人数
	private JLabel lblNewLabel;//班级ID
	private JLabel lblNewLabel_1;//班级人数

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Class_insert frame = new Class_insert(new User());
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
	public Class_insert(User user) {
		setTitle("班级录入");//界面名字
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点叉即关闭程序
		setBounds(300, 100, 760, 590);//设置界面的大小
		setResizable(false);//设置界面不可变化
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);//面板
		
		btnNewButton_1=new JButton();
		btnNewButton_1.setBounds(80, 80, 60, 60);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);//班级录入界面不可见
				Insert frame = new Insert(user);
				frame.setVisible(true);//录入界面可见
			}
		});
		contentPane.setLayout(null);
		btnNewButton_1.setIcon(new ImageIcon("image/通用-退出登录图标.png"));
		btnNewButton_1.setBorderPainted(false);
		contentPane.add(btnNewButton_1);//用户中心图片按钮
		
		lblNewLabel = new JLabel("班级ID");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel.setBounds(174, 195, 113, 35);
		contentPane.add(lblNewLabel);//班级ID
		
		lblNewLabel_1 = new JLabel("班级人数");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(174, 293, 132, 35);
		contentPane.add(lblNewLabel_1);//班级人数
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(333, 200, 237, 35);
		contentPane.add(textField);//班级ID
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(333, 293, 237, 35);
		contentPane.add(textField_1);//班级人数
		
		btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String class_id=textField.getText();
				String number=textField_1.getText();
				
				String order="insert into class values("+class_id+",'"+number+"')";//更改数据库的命令
				database_connect dc = new database_connect();
				Statement state;
				try {
					state = dc.conn.createStatement();
					state.executeUpdate(order);
					Error frame = new Error("班级录入成功",1);
					frame.setVisible(true);//报错界面可见
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}//执行命令，更改数据库中类型
				
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 17));
		btnNewButton.setBounds(308, 422, 97, 23);
		contentPane.add(btnNewButton);//确定
		
		setVisible(true);
	}
}
