package Service;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Object.Experiment;
import Object.User;
import Object.testJComboBox.RwJComboBox;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTextField;

public class Arrange_room extends JFrame {

	private JPanel contentPane;//面板
	private JButton btnNewButton_1;//返回图片按钮
	/*private final JComboBox comboBox_1;//周次下拉框
	private final JComboBox comboBox_2;//星期几下拉框
	private final JComboBox comboBox_3;//时段下拉框*/
	private final JComboBox comboBox_4;//实验名下拉框
	private final JComboBox comboBox_5;//教室号下拉框
	/*private JLabel lblNewLabel_1;//周次
	private JLabel lblNewLabel_2;//星期几
	private JLabel lblNewLabel_3;//时段*/
	private JLabel lblNewLabel_4;//实验名
	private JLabel lblNewLabel_5;//教室号
	private JButton btnNewButton;//确定
	private JLabel lblNewLabel;//容量
	private JTextField textField;//容量文本
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Arrange_room frame = new Arrange_room(new User());
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
	public Arrange_room(User user) {
		setTitle("设置实验室属性");//界面名字
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点叉即关闭程序
		setBounds(300, 100, 760, 590);//设置界面的大小
		setResizable(false);//设置界面不可变化
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);//面板
		
		btnNewButton_1=new JButton();
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);//安排实验室界面不可见
				LabAndAssistant_manage frame = new LabAndAssistant_manage(user);
				frame.setVisible(true);//实验与实验员管理界面可见
			}
		});
		contentPane.setLayout(null);
		btnNewButton_1.setIcon(new ImageIcon("image/通用-退出登录图标.png"));
		btnNewButton_1.setBounds(80, 80, 60, 60);
		btnNewButton_1.setBorderPainted(false);
		contentPane.add(btnNewButton_1);//返回图片按钮
		
		Vector v4 = new Vector();//存放实验名的vector
		Vector v5 = new Vector();//存放教室号的vector
		String order4="select exp_name from experiment";//获取实验名的命令
		String order5="select lab_address from laboratory";//获取教室号的命令
		ResultSet result;//获取数据库中的实验名的state
		ResultSet result1;//获取数据库中的教室号的state
		database_order dc = new database_order(order4);//执行命令，获取数据库中的实验名
		database_order dc1 = new database_order(order5);//执行命令，获取教室号中的实验名
		result=dc.resultset;
		result1=dc1.resultset;
		try {
			while(result.next()) {//将实验名输入对应vector
				v4.addElement(result.getString(1));
			}
		} catch (SQLException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		try {
			while(result1.next()) {//将教室号输入对应vector
				v5.addElement(result1.getString(1));
			}
		} catch (SQLException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		String str3[][] = new String[v4.size()][3];
		for(int i=0;i<v4.size();i++) {
			str3[i][0]=(String) v4.elementAt(i);
		}
		comboBox_4 = new RwJComboBox(str3);
		comboBox_4.setEditable(true);
		comboBox_4.setPreferredSize(new java.awt.Dimension(400, 60));
		comboBox_4.setBounds(306, 335, 234, 33);
		contentPane.add(comboBox_4);//实验名下拉框
	
		/*String str[][] = new String[10][3];
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
		comboBox_1.setBounds(250, 228, 279, 33);
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
		comboBox_2.setBounds(250, 317, 89, 33);
		contentPane.add(comboBox_2);//星期下拉框
		
		String str2[][] = new String[3][3];
		str2[0][0]="上午";
		str2[1][0]="下午";
		str2[2][0]="晚上";
		comboBox_3 = new RwJComboBox(str2);
		comboBox_3.setEditable(true);
		comboBox_3.setPreferredSize(new java.awt.Dimension(400, 60));
		comboBox_3.setBounds(529, 317, 89, 33);
		contentPane.add(comboBox_3);//时段下拉框
		
		lblNewLabel_1 = new JLabel("\u5468\u6B21\u9009\u62E9");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(106, 226, 89, 33);
		contentPane.add(lblNewLabel_1);//周次
		
		lblNewLabel_2 = new JLabel("\u661F\u671F\u9009\u62E9");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(106, 315, 89, 33);
		contentPane.add(lblNewLabel_2);//星期几
		
		lblNewLabel_3 = new JLabel("\u65F6\u6BB5\u9009\u62E9");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(382, 315, 89, 33);
		contentPane.add(lblNewLabel_3);//时段
		*/
		
		lblNewLabel_4 = new JLabel("可进行实验");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(157, 335, 120, 33);
		contentPane.add(lblNewLabel_4);//实验名
		
		lblNewLabel_5 = new JLabel("\u6559\u5BA4\u53F7");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(157, 201, 89, 33);
		contentPane.add(lblNewLabel_5);//教室号
		
		comboBox_5 = new JComboBox(v5);
		comboBox_5.setBounds(306, 201, 234, 33);
		contentPane.add(comboBox_5);//教室号下拉框
		
		btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//int  week=Integer.parseInt(comboBox_1.getSelectedItem().toString());
				/*String week=comboBox_1.getSelectedItem().toString();
				String weekday=comboBox_2.getSelectedItem().toString();
				String time=comboBox_3.getSelectedItem().toString();*/
				String exp_name=comboBox_4.getSelectedItem().toString();
				String lab_address=comboBox_5.getSelectedItem().toString();
				String lab_capacity=textField.getText().toString();
				

				String order1="select * from laboratory where lab_address='"+lab_address+"'";//获取教室对应教室号
				ResultSet result1;//获取数据库中教室的state
				database_order dc1 = new database_order(order1);//执行命令，获取数据库中教室号
				result1=dc1.resultset;
				
				try {
					if(result1.next()) {
						String lab_id = result1.getString(1);
						String order="update laboratory set lab_type='"+exp_name+" ' ,lab_capacity='"+lab_capacity+"' where lab_id="+lab_id;//更改数据库的命令
						database_connect dc = new database_connect();
						Statement state;
						try {
							state = dc.conn.createStatement();
							state.executeUpdate(order);//执行命令，更改数据库中类型
							Error frame = new Error("实验室安排成功",1);
							frame.setVisible(true);//报错界面可见
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
		btnNewButton.setBounds(331, 400, 97, 23);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("\u5BB9\u91CF");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(157, 266, 89, 33);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(306, 266, 234, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		setVisible(true);
	}
}
