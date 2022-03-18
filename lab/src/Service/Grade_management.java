package Service;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Object.Experiment;
import Object.User;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;

public class Grade_management extends JFrame {

	private JPanel contentPane;//面板
	private JButton btnNewButton_1;//返回图片按钮
	private JLabel lblNewLabel;//实验名
	private JLabel lblNewLabel_1;//课程名
	private JLabel lblNewLabel_2;//欢迎
	private final JComboBox comboBox;//实验名下拉框
	private final JComboBox comboBox_1;//课程名下拉框
	private JButton btnNewButton;//确定按钮

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Grade_management frame = new Grade_management(new User());
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
	public Grade_management(User user) {
		setTitle("\u6210\u7EE9\u7BA1\u7406");//界面名字
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点叉即关闭程序
		setBounds(300, 100, 760, 590);//设置界面的大小
		setResizable(false);//设置界面不可变化
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);//面板
		
		lblNewLabel_2 = new JLabel("请选择实验名和课程名");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 35));
		lblNewLabel_2.setBounds(200, 90, 500, 53);
		contentPane.add(lblNewLabel_2);//欢迎
		
		btnNewButton_1=new JButton();
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);//成绩管理·具体实验界面不可见
				activity_choose frame = new activity_choose(user);
				frame.setVisible(true);//成绩管理界面可见
			}
		});
		contentPane.setLayout(null);
		btnNewButton_1.setIcon(new ImageIcon("image/通用-退出登录图标.png"));
		btnNewButton_1.setBounds(80, 80, 60, 60);
		btnNewButton_1.setBorderPainted(false);
		contentPane.add(btnNewButton_1);//返回图片按钮
		
		lblNewLabel = new JLabel("\u5B9E\u9A8C\u540D");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel.setBounds(158, 180, 112, 45);
		contentPane.add(lblNewLabel);//实验名
		
		lblNewLabel_1 = new JLabel("\u8BFE\u7A0B\u540D");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(158, 281, 112, 45);
		contentPane.add(lblNewLabel_1);//课程名
		
		Vector v1 = new Vector();//存放实验名的vector
		Vector v2 = new Vector();//存放课程名的vector
		
		String order="select exp_name from experiment";//获取实验名的命令
		String order1="select course_name from course";//获取课程名的命令
		ResultSet result;//获取数据库中的实验名的state
		ResultSet result1;//获取数据库中的课程名的state
		database_order dc = new database_order(order);//执行命令，获取数据库中的实验名
		database_order dc1 = new database_order(order1);//执行命令，获取数据库中的实验名
		result=dc.resultset;
		result1=dc1.resultset;
		try {
			while(result.next()) {//将实验名输入对应vector
				v1.addElement(result.getString(1));
			}
		} catch (SQLException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		try {
			while(result1.next()) {//将课程名输入对应vector
				v2.addElement(result1.getString(1));
			}
		} catch (SQLException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		
		comboBox = new JComboBox(v1);
		comboBox.setBounds(319, 191, 177, 33);
		contentPane.add(comboBox);//实验名下拉框
		
		comboBox_1 = new JComboBox(v2);
		comboBox_1.setBounds(319, 292, 177, 33);
		
		contentPane.add(comboBox_1);//课程名下拉框
		
		btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String exp_name=comboBox.getSelectedItem().toString();
				String course_name=comboBox_1.getSelectedItem().toString();
				
				String order="select * from experiment where exp_name='"+exp_name+"'";//获取实验对应实验号
				String order1="select * from course where course_name='"+course_name+"'";//获取实验对应课程名
				ResultSet result;//获取数据库中实验的state
				ResultSet result1;//获取数据库中姓名的state
				database_order dc = new database_order(order);//执行命令，获取数据库中试验号
				database_order dc1 = new database_order(order1);//执行命令，获取数据库中课程号
				result=dc.resultset;
				result1=dc1.resultset;
				
				try {
					if(result.next()&&result1.next()) {
						String exp_id = result.getString(1);
						String course_id = result1.getString(1);
						Experiment exp=new Experiment();
						exp.insert_exp_id(exp_id);
						exp.insert_exp_name(exp_name);
						exp.insert_course_id(course_id);
						exp.insert_course_name(course_name);
						//System.out.println("exp_name="+exp_name+",exp_id="+exp_id+",course_name"+course_name+",course_id="+course_id);
						if(exp_name.equals(course_name+"实验")) {
							setVisible(false);//课程名与实验名选择界面不可见
							Grade_choose_student frame = new Grade_choose_student(user,exp);
							frame.setVisible(true);//成绩输入界面可见
						}
						else {
							Error frame = new Error("课程名与实验名不对应",0);
							frame.setVisible(true);//报错界面可见
						}	
					}
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 17));
		btnNewButton.setBounds(347, 429, 97, 23);
		contentPane.add(btnNewButton);//确定按钮
		
		setVisible(true);
	}
}
