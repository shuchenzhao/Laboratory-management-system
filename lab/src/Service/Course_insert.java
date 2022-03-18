package Service;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Object.User;
import Object.testJComboBox.RwJComboBox;
import java.awt.Dimension;

public class Course_insert extends JFrame {

	private JPanel contentPane;//面板
	private JButton btnNewButton_1;//返回图片按钮
	private JLabel lblNewLabel;//课程ID
	private JLabel lblNewLabel_1;//课程名称
	private JLabel lblNewLabel_2;//所属学院
	private JLabel lblNewLabel_3;//开课学期
	private JLabel lblNewLabel_4;//对应实验
	private JTextField textField;//课程ID文本框
	private JTextField textField_1;//课程名称文本框
	private JButton btnNewButton;//确定
	private JComboBox comboBox;//学期下拉框
	private JComboBox comboBox_1;//学院下拉框
	private JComboBox comboBox_2;//实验下拉框
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Course_insert frame = new Course_insert(new User());
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
	public Course_insert(User user) {
		setTitle("课程信息录入");//界面名字
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
				setVisible(false);//课程信息录入界面不可见
				Message_insert frame = new Message_insert(user);
				frame.setVisible(true);//信息录入界面可见
			}
		});
		contentPane.setLayout(null);
		btnNewButton_1.setIcon(new ImageIcon("image/通用-退出登录图标.png"));
		btnNewButton_1.setBorderPainted(false);
		contentPane.add(btnNewButton_1);//返回图片按钮
		
		lblNewLabel = new JLabel("课程ID");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel.setBounds(148, 144, 122, 32);
		contentPane.add(lblNewLabel);//课程ID
		
		lblNewLabel_1 = new JLabel("课程名称");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(148, 208, 122, 32);
		contentPane.add(lblNewLabel_1);//课程名称
		
		lblNewLabel_2 = new JLabel("所属学院");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(148, 276, 122, 32);
		contentPane.add(lblNewLabel_2);//所属学院
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(327, 144, 213, 32);
		contentPane.add(textField);//课程ID文本框
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(327, 208, 213, 32);
		contentPane.add(textField_1);
		
		btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String course_id=textField.getText().toString();
				String course_name=textField_1.getText().toString();
				String course_time=comboBox.getSelectedItem().toString();
				String teaching_college=comboBox_1.getSelectedItem().toString();
				String exp_name=comboBox_2.getSelectedItem().toString();
				String exp_id;
				
				String order2="select * from experiment where exp_name='"+exp_name+"'";//获取实验对应行
				ResultSet result1;//获取数据库中实验的state
				database_order dc1 = new database_order(order2);//执行命令，获取数据库中实验对应行
				result1=dc1.resultset;
				try {
					if(result1.next()) {
						exp_id=result1.getString("exp_id");
						String order="insert into course values('"+course_id+"','"+course_name+"','"+course_time+"','"+exp_id+"','"+teaching_college+"')";//更改数据库的命令
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
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 17));
		btnNewButton.setBounds(301, 471, 97, 23);
		contentPane.add(btnNewButton);//确定
		
		lblNewLabel_3 = new JLabel("开课学期");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(148, 336, 122, 32);
		contentPane.add(lblNewLabel_3);//开课学期
		
		Vector v= new Vector();
		v.addElement("第一学期");
		v.addElement("第二学期");
		v.addElement("第三学期");
		v.addElement("第四学期");
		v.addElement("第五学期");
		v.addElement("第六学期");
		v.addElement("第七学期");
		v.addElement("第八学期");
		comboBox = new JComboBox(v);
		comboBox.setEditable(true);
		comboBox.setPreferredSize(new java.awt.Dimension(400, 60));
		comboBox.setBounds(327, 335, 213, 32);
		contentPane.add(comboBox);//学期下拉框
		
		lblNewLabel_4 = new JLabel("对应实验");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel_4.setBounds(148, 395, 122, 32);
		contentPane.add(lblNewLabel_4);//对应实验
		
		Vector v1= new Vector();
		String order="select exp_name from experiment";//获取实验名的命令
		ResultSet result;//获取数据库中的实验名的state
		database_order dc = new database_order(order);//执行命令，获取数据库中的实验名
		result=dc.resultset;
		try {
			while(result.next()) {//将实验名输入对应vector
				v1.addElement(result.getString(1));
			}
		} catch (SQLException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		comboBox_2 = new JComboBox(v1);
		comboBox_2.setEditable(true);
		comboBox_2.setPreferredSize(new java.awt.Dimension(400, 60));
		comboBox_2.setBounds(327, 395, 213, 32);
		contentPane.add(comboBox_2);//实验下拉框
		
		Vector v2= new Vector();
		v2.addElement("计算机科学与技术学院");
		v2.addElement("电子工程学院");
		v2.addElement("通信工程学院");
		v2.addElement("机电工程学院");
		v2.addElement("物理与光电工程学院");
		comboBox_1 = new JComboBox(v2);
		comboBox_1.setPreferredSize(new Dimension(400, 60));
		comboBox_1.setEditable(true);
		comboBox_1.setBounds(327, 276, 213, 32);
		contentPane.add(comboBox_1);//学院下拉框
		
		setVisible(true);
	}

}
