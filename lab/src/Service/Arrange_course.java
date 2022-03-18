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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Object.testJComboBox.RwJComboBox;
import Object.User;
import javax.swing.JLabel;
import java.awt.Font;

public class Arrange_course extends JFrame {

	private JPanel contentPane;//面板
	private JButton btnNewButton;//确定
	private JButton btnNewButton_1;//返回图片按钮
	private JLabel lblNewLabel;//实验名
	private JLabel lblNewLabel_1;//实验班级
	private JLabel lblNewLabel_2;//实验周次
	private JLabel lblNewLabel_3;//实验时段
	private JLabel lblNewLabel_4;//实验教室
	private JLabel lblNewLabel_5;//实验员
	private JLabel lblNewLabel_6;//实验星期
	private final JComboBox comboBox_1;//周次下拉框
	private final JComboBox comboBox_2;//星期几下拉框
	private final JComboBox comboBox_3;//时段下拉框
	private final JComboBox comboBox_4;//实验名称下拉框
	private final JComboBox comboBox_5;//教室号下拉框
	private final JComboBox comboBox_6;//实验班级下拉框
	private final JComboBox comboBox_7;//实验员下拉框

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Arrange_course frame = new Arrange_course(new User());
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
	public Arrange_course(User user) {
		setTitle("一键排课");//界面名字
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点叉即关闭程序
		setBounds(300, 100, 760, 590);//设置界面的大小
		setResizable(false);//设置界面不可变化
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);//面板
		
		btnNewButton_1=new JButton();
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);//一键排课界面不可见
				CourseAndExperiment_manage frame = new CourseAndExperiment_manage(user);
				frame.setVisible(true);//课程与实验管理界面可见
			}
		});
		contentPane.setLayout(null);
		btnNewButton_1.setIcon(new ImageIcon("image/通用-退出登录图标.png"));
		btnNewButton_1.setBounds(80, 80, 60, 60);
		btnNewButton_1.setBorderPainted(false);
		contentPane.add(btnNewButton_1);//返回图片按钮
		
		lblNewLabel = new JLabel("实验名称");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel.setBounds(148, 124, 122, 34);
		contentPane.add(lblNewLabel);//实验名
		
		lblNewLabel_1 = new JLabel("实验班级");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(148, 182, 122, 34);
		contentPane.add(lblNewLabel_1);//实验班级
		
		lblNewLabel_2 = new JLabel("实验周次");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(148, 241, 122, 34);
		contentPane.add(lblNewLabel_2);//实验周次
		
		lblNewLabel_3 = new JLabel("实验时段");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(417, 241, 122, 34);
		contentPane.add(lblNewLabel_3);//实验时段
		
		lblNewLabel_4 = new JLabel("实验教室");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel_4.setBounds(148, 359, 122, 34);
		contentPane.add(lblNewLabel_4);//实验教室
		
		lblNewLabel_5 = new JLabel("实验员");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel_5.setBounds(148, 423, 122, 34);
		contentPane.add(lblNewLabel_5);//实验员
		
		lblNewLabel_6 = new JLabel("实验星期");
		lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel_6.setBounds(148, 296, 122, 34);
		contentPane.add(lblNewLabel_6);//实验星期
		
		String str[][] = new String[10][3];
		str[0][0]="1";
		str[1][0]="2";
		str[2][0]="3";
		str[3][0]="4";
		str[4][0]="5";
		str[5][0]="6";
		str[6][0]="7";
		str[7][0]="8";
		str[8][0]="9";
		str[9][0]="10";
		comboBox_1 = new RwJComboBox(str);
		comboBox_1.setEditable(true);
		comboBox_1.setPreferredSize(new java.awt.Dimension(400, 60));
		comboBox_1.setBounds(299, 241, 89, 33);
		contentPane.add(comboBox_1);//终止周次下拉框

		String str1[][] = new String[7][3];
		str1[0][0]="1";
		str1[1][0]="2";
		str1[2][0]="3";
		str1[3][0]="4";
		str1[4][0]="5";
		str1[5][0]="6";
		str1[6][0]="7";
		comboBox_2 = new RwJComboBox(str1);
		comboBox_2.setEditable(true);
		comboBox_2.setPreferredSize(new java.awt.Dimension(400, 60));
		comboBox_2.setBounds(299, 296, 220, 33);
		contentPane.add(comboBox_2);//星期下拉框
		
		String str2[][] = new String[3][3];
		str2[0][0]="上午";
		str2[1][0]="下午";
		str2[2][0]="晚上";
		comboBox_3 = new RwJComboBox(str2);
		comboBox_3.setEditable(true);
		comboBox_3.setPreferredSize(new java.awt.Dimension(400, 60));
		comboBox_3.setBounds(565, 241, 89, 33);
		contentPane.add(comboBox_3);//时段下拉框
		
		Vector v4 = new Vector();//存放实验名的vector
		Vector v5 = new Vector();//存放教室号的vector
		Vector v6 = new Vector();//存放班级号的vector
		Vector v7 = new Vector();//存放教师名的vector
		String order4="select exp_name from experiment";//获取实验名的命令
		String order5="select lab_address from laboratory";//获取教室号的命令
		String order6="select class_id from class";//获取班级号的命令
		String order7="select tch_name from teacher";//获取教师名的命令
		ResultSet result4;//获取数据库中的实验名的state
		ResultSet result5;//获取数据库中的教室号的state
		ResultSet result6;//获取数据库中的班级号的state
		ResultSet result7;//获取数据库中的教师名的state
		database_order dc4 = new database_order(order4);//执行命令，获取实验名
		database_order dc5 = new database_order(order5);//执行命令，获取教室号
		database_order dc6 = new database_order(order6);//执行命令，获取班级号
		database_order dc7 = new database_order(order7);//执行命令，获取教师名
		result4=dc4.resultset;
		result5=dc5.resultset;
		result6=dc6.resultset;
		result7=dc7.resultset;
		try {
			while(result4.next()) {//将实验名输入对应vector
				v4.addElement(result4.getString(1));
			}
		} catch (SQLException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		try {
			while(result5.next()) {//将教室号输入对应vector
				v5.addElement(result5.getString(1));
			}
		} catch (SQLException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		String str4[][] = new String[v5.size()][3];
		for(int i=0;i<v5.size();i++) {
			str4[i][0]=(String) v5.elementAt(i);
		}
		comboBox_4 = new JComboBox(v4);
		comboBox_4.setPreferredSize(new java.awt.Dimension(400, 60));
		comboBox_4.setBounds(299, 124, 220, 33);
		contentPane.add(comboBox_4);//实验名称下拉框
		
		comboBox_5 = new RwJComboBox(str4);
		comboBox_5.setEditable(true);
		comboBox_5.setBounds(299, 359, 220, 33);
		contentPane.add(comboBox_5);//教室号下拉框
		
		try {
			while(result6.next()) {//将教室号输入对应vector
				v6.addElement(result6.getString(1));
			}
		} catch (SQLException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		comboBox_6 = new JComboBox(v6);
		comboBox_6.setBounds(301, 182, 218, 34);
		comboBox_6.setEditable(true);
		contentPane.add(comboBox_6);//实验班级
		
		try {
			while(result7.next()) {//将教室号输入对应vector
				v7.addElement(result7.getString(1));
			}
		} catch (SQLException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		comboBox_7 = new JComboBox(v7);
		comboBox_7.setEditable(true);
		comboBox_7.setBounds(299, 423, 220, 33);
		contentPane.add(comboBox_7);//实验员
		
		btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String week=comboBox_1.getSelectedItem().toString();
				String weekday=comboBox_2.getSelectedItem().toString();
				String time=comboBox_3.getSelectedItem().toString();
				String exp_name=comboBox_4.getSelectedItem().toString();
				String lab_address=comboBox_5.getSelectedItem().toString();
				String class_id=comboBox_6.getSelectedItem().toString();
				String tch_name=comboBox_7.getSelectedItem().toString();
				
				String order1="select user_id from teacher where tch_name='"+tch_name+"'";//获取教师对应行
				ResultSet result1;//获取数据库中教师的state
				database_order dc1 = new database_order(order1);//执行命令，获取数据库中教师对应行
				result1=dc1.resultset;
				String tch_id;
				
				String order3="select exp_id from experiment where exp_name='"+exp_name+"'";//获取教室对应行
				ResultSet result3;//获取数据库中教室的state
				database_order dc3 = new database_order(order3);//执行命令，获取数据库中教室对应行
				result3=dc3.resultset;
				String exp_id;
				
				try {

					if(result3.next()) {//获取了exp_id
						exp_id=result3.getString(1);
						if(result1.next()) {//获取了tch_id
							tch_id=result1.getString(1);
							String order="insert into exp_arrangement values('"+exp_id+"','"+class_id+"','"+week+"','"+weekday+"','"+time+"','"+lab_address+"','"+tch_id+"')";//更改数据库的命令
							database_connect dc = new database_connect();
							Statement state;
							state = dc.conn.createStatement();
							state.executeUpdate(order);//执行命令，更改数据库中类型
							Error frame = new Error("实验安排成功",1);
							frame.setVisible(true);//报错界面可见
						}
						else {
							Error frame = new Error("教师不存在于数据库中",0);
							frame.setVisible(true);//报错界面可见
						}
					}
					else {
						Error frame = new Error("实验不存在于数据库中",0);
						frame.setVisible(true);//报错界面可见
					}					
						
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 17));
		btnNewButton.setBounds(334, 470, 97, 23);
		contentPane.add(btnNewButton);//确定
		
		setVisible(true);
	}
}
