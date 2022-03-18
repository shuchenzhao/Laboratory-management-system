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
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Object.User;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class Select_arrangedExp extends JFrame {

	private JPanel contentPane;//面板
	private JButton btnNewButton_1;//返回图片按钮
	private JTable table;//查询结果
	private JComboBox comboBox;//实验名称
	private JButton btnNewButton;//确定
	private JLabel lblNewLabel;//实验名称


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Select_arrangedExp frame = new Select_arrangedExp(new User());
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
	public Select_arrangedExp(User user) {
		setTitle("查询安排");//界面名字
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
		lblNewLabel.setBounds(144, 162, 128, 35);
		contentPane.add(lblNewLabel);
		
		Vector v0 = new Vector();//存放实验名的vector
		String order0="select exp_name from experiment";//获取实验名的命令
		ResultSet result0;//获取数据库中的实验名的state
		database_order dc0 = new database_order(order0);//执行命令，获取实验名
		result0=dc0.resultset;
		try {
			while(result0.next()) {//将实验名输入对应vector
				v0.addElement(result0.getString(1));
			}
		} catch (SQLException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		comboBox = new JComboBox(v0);
		comboBox.setBounds(309, 162, 234, 35);
		contentPane.add(comboBox);
		
		
		
		
		btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String exp_name=comboBox.getSelectedItem().toString();
				
				String order1="select exp_id from experiment where exp_name='"+exp_name+"'";//获取实验对应行
				ResultSet result1;//获取数据库中实验对应行的state
				database_order dc1 = new database_order(order1);//执行命令，获取数据库中实验对应行
				result1=dc1.resultset;
				
				try {
					if(result1.next()) {//获取了exp_id
						String exp_id=result1.getString(1);
						Vector v1 = new Vector();//存放返回结果的vector
						String columnNames[]= {"exp_id","class_id","week","weekday","time","lab_address","tch_id"};
						
						String order3="select * from exp_arrangement where exp_id='"+exp_id+"'";//获取实验对应数据
						ResultSet result3;//获取实验对应数据的state
						database_order dc3 = new database_order(order3);//执行命令，获取实验对应数据
						result3=dc3.resultset;
						v1.addElement("exp_id");
						v1.addElement("class_id");
						v1.addElement("week");
						v1.addElement("weekday");
						v1.addElement("time");
						v1.addElement("lab_address");
						v1.addElement("tch_id");
						while(result3.next()) {//将实验名输入对应vector
							v1.addElement(result3.getString(1));
							v1.addElement(result3.getString(2));
							v1.addElement(result3.getString(3));
							v1.addElement(result3.getString(4));
							v1.addElement(result3.getString(5));
							v1.addElement(result3.getString(6));
							v1.addElement(result3.getString(7));
						}
						if (v1.size()==7) {
							Error frame = new Error("实验尚未安排",0);
							frame.setVisible(true);//报错界面可见
						}
						else {
							//System.out.println(v1.size());
							Object[][] data =new Object[v1.size()/7][7];
							for(int i1=0;i1<v1.size()/7;i1++) {
								for (int j=0;j<7;j++) {
									data[i1][j]=v1.elementAt((i1)*7+j);
								}
							}
							table = new JTable(data, columnNames);
							table.setBounds(0, 280, 800, 230);
							//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  
							add(table);//查询结果
							validate();
						}
						
					}
					else {
						
					}					
						
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 17));
		btnNewButton.setBounds(309, 226, 97, 23);
		contentPane.add(btnNewButton);//确定
		
		setVisible(true);
	}
}
