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
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class Experiment_insert extends JFrame {

	private JPanel contentPane;//面板
	private JButton btnNewButton_1;//返回图片按钮
	private JLabel lblNewLabel;//实验ID
	private JLabel lblNewLabel_1;//实验名称
	private JLabel lblNewLabel_2;//学时
	private JTextField textField;//实验ID文本框
	private JTextField textField_1;//实验名称文本框
	private JTextField textField_2;//学时文本框
	private JButton btnNewButton;//确定
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Experiment_insert frame = new Experiment_insert(new User());
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
	public Experiment_insert(User user) {
		setTitle("实验信息录入");//界面名字
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
				setVisible(false);//实验信息录入界面不可见
				Message_insert frame = new Message_insert(user);
				frame.setVisible(true);//信息录入管理界面可见
			}
		});
		contentPane.setLayout(null);
		btnNewButton_1.setIcon(new ImageIcon("image/通用-退出登录图标.png"));
		btnNewButton_1.setBorderPainted(false);
		contentPane.add(btnNewButton_1);//返回图片按钮
		
		lblNewLabel = new JLabel("实验ID");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel.setBounds(148, 181, 122, 32);
		contentPane.add(lblNewLabel);//实验ID
		
		lblNewLabel_1 = new JLabel("实验名称");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(148, 261, 122, 32);
		contentPane.add(lblNewLabel_1);//实验名称
		
		lblNewLabel_2 = new JLabel("学时");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(148, 345, 122, 32);
		contentPane.add(lblNewLabel_2);//学时
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(327, 181, 213, 32);
		contentPane.add(textField);//实验ID文本框
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(327, 261, 213, 32);
		contentPane.add(textField_1);//实验名称文本框
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(327, 345, 213, 32);
		contentPane.add(textField_2);//学时文本框
		
		btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String exp_id=textField.getText().toString();
				String exp_name=textField_1.getText().toString();
				String exp_period=textField_2.getText().toString();
				
				String order="insert into experiment values('"+exp_id+"','"+exp_name+"','"+exp_period+"')";//更改数据库的命令
				database_connect dc = new database_connect();
				Statement state;
				try {
					state = dc.conn.createStatement();
					state.executeUpdate(order);//执行命令，更改数据库中类型
					Error frame = new Error("实验录入成功",1);
					frame.setVisible(true);//提示界面可见
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 17));
		btnNewButton.setBounds(301, 471, 97, 23);
		contentPane.add(btnNewButton);//确定
		
		setVisible(true);
	}

}
