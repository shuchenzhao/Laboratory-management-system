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
import Object.testJComboBox.RwJComboBox;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class Arrange_assistant extends JFrame {

	private JPanel contentPane;//面板
	private JButton btnNewButton_1;//返回图片按钮
	private JButton btnNewButton;//确定
	private JLabel lblNewLabel;//姓名
	private JLabel lblNewLabel_1;//工号
	private JLabel lblNewLabel_2;//可带实验
	private JTextField textField;//姓名
	private JTextField textField_1;//工号
	private JComboBox comboBox;//实验名下拉框
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Arrange_assistant frame = new Arrange_assistant(new User());
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
	public Arrange_assistant(User user) {
		setTitle("设置实验员属性");//界面名字
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
				setVisible(false);//安排实验员界面不可见
				LabAndAssistant_manage frame = new LabAndAssistant_manage(user);
				frame.setVisible(true);//实验与实验员管理界面可见
			}
		});
		contentPane.setLayout(null);
		btnNewButton_1.setIcon(new ImageIcon("image/通用-退出登录图标.png"));
		btnNewButton_1.setBorderPainted(false);
		contentPane.add(btnNewButton_1);//返回图片按钮
		
		lblNewLabel = new JLabel("\u59D3\u540D");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel.setBounds(157, 201, 72, 32);
		contentPane.add(lblNewLabel);//姓名
		
		lblNewLabel_1 = new JLabel("\u5DE5\u53F7");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(157, 266, 72, 32);
		contentPane.add(lblNewLabel_1);//工号
		
		lblNewLabel_2 = new JLabel("\u53EF\u5E26\u5B9E\u9A8C");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(157, 335, 122, 32);
		contentPane.add(lblNewLabel_2);//可带实验
		
		Vector v4 = new Vector();//存放实验名的vector
		String order4="select exp_name from experiment";//获取实验名的命令
		ResultSet result;//获取数据库中的实验名的state
		database_order dc = new database_order(order4);//执行命令，获取数据库中的实验名
		result=dc.resultset;
		try {
			while(result.next()) {//将实验名输入对应vector
				v4.addElement(result.getString(1));
			}
		} catch (SQLException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		String str[][] = new String[v4.size()][3];
		for(int i=0;i<v4.size();i++) {//将vector中实验名放在string数组内
			str[i][0]=(String) v4.elementAt(i);
		}
		
		comboBox = new RwJComboBox(str);
		comboBox.setEditable(true);
		comboBox.setPreferredSize(new java.awt.Dimension(400, 60));
		comboBox.setBounds(306, 335, 213, 32);
		contentPane.add(comboBox);//实验名下拉框
		
		textField = new JTextField();
		textField.setBounds(306, 201, 213, 32);
		contentPane.add(textField);
		textField.setColumns(10);//姓名
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(306, 266, 213, 32);
		contentPane.add(textField_1);//工号
		
		btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tch_name=textField.getText().toString();
				String tch_id=textField_1.getText().toString();
				String exp_name=comboBox.getSelectedItem().toString();
				
				String order1="select * from teacher where user_id="+tch_id;//获取教师对应行
				ResultSet result1;//获取数据库中教师的state
				database_order dc1 = new database_order(order1);//执行命令，获取数据库中教师对应行
				result1=dc1.resultset;
				
				try {
					if(result1.next()) {
						String tch_name1 = result1.getString("tch_name");
						if(tch_name1.equals(tch_name)) {//姓名与工号匹配
							String order="update teacher set tch_type='"+exp_name+"' where user_id="+tch_id;//更改数据库的命令
							database_connect dc = new database_connect();
							Statement state;
							try {
								state = dc.conn.createStatement();
								state.executeUpdate(order);//执行命令，更改数据库中类型
								Error frame = new Error("实验员安排成功",1);
								frame.setVisible(true);//报错界面可见
							} catch (SQLException e1) {
								// TODO 自动生成的 catch 块
								e1.printStackTrace();
							}
						}
						else {//姓名与工号不匹配
							Error frame = new Error("姓名与工号不匹配",0);
							frame.setVisible(true);//报错界面可见
						}
						
					}
					else {//姓名与工号不匹配
						Error frame = new Error("姓名与工号不匹配",0);
						frame.setVisible(true);//报错界面可见
					}
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 17));
		btnNewButton.setBounds(334, 465, 97, 23);
		contentPane.add(btnNewButton);//确定
		
		setVisible(true);
	}
}
