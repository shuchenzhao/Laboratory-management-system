package Service;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;

import Object.User;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.util.Vector;

public class Select extends JFrame {

	private JPanel contentPane;//面板
	private JButton btnNewButton;//确定
	private JButton btnNewButton_1;//返回图片按钮
	private JTextField textField;//号码文本
	private JLabel lblNewLabel_1;//查询号码
	private JLabel lblNewLabel_2;//查询类型
	private JComboBox comboBox;//类型下拉框
	private JTable table;//返回表
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Select frame = new Select(new User());
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
	public Select(User user) {
		setTitle("查询");//界面名字
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点叉即关闭程序
		setBounds(300, 100, 760, 590);//设置界面的大小
		setResizable(false);//设置界面不可变化
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);//面板
		
		btnNewButton_1=new JButton();
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);//班级与学生管理界面不可见
				ClassAndStudent_manage frame = new ClassAndStudent_manage(user);
				frame.setVisible(true);//管理功能选择界面可见
			}
		});
		contentPane.setLayout(null);
		btnNewButton_1.setIcon(new ImageIcon("image/通用-退出登录图标.png"));
		btnNewButton_1.setBounds(80, 80, 60, 60);
		btnNewButton_1.setBorderPainted(false);
		contentPane.add(btnNewButton_1);//用户中心图片按钮
		
		lblNewLabel_1 = new JLabel("查询号码");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(129, 197, 122, 35);
		contentPane.add(lblNewLabel_1);//查询号码
		
		lblNewLabel_2 = new JLabel("查询类型");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(129, 283, 122, 35);
		contentPane.add(lblNewLabel_2);//查询类型
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(297, 197, 233, 35);
		contentPane.add(textField);//查询号码
		
		Vector v2 = new Vector();//存放类型的vector
		v2.addElement("学生");
		v2.addElement("班级");
		comboBox = new JComboBox(v2);
		comboBox.setBounds(297, 283, 232, 35);
		contentPane.add(comboBox);//查询类型
		
		btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type=comboBox.getSelectedItem().toString();
				
				if(type.equals("学生")) {
					String user_id=textField.getText();
					String columnNames[]= {"user_id","stu_name","stu_sex","stu_class"};
					
					String order3="select * from student where user_id="+user_id;//获取实验对应数据
					ResultSet result3;//获取实验对应数据的state
					database_order dc3 = new database_order(order3);//执行命令，获取实验对应数据
					result3=dc3.resultset;
					Vector v1=new Vector();
					v1.addElement("user_id");
					v1.addElement("stu_name");
					v1.addElement("stu_sex");
					v1.addElement("stu_class");
					
					try {
						while(result3.next()) {//将信息输入对应vector
							v1.addElement(result3.getString(1));
							v1.addElement(result3.getString(2));
							v1.addElement(result3.getString(3));
							v1.addElement(result3.getString(4));
						}
						if (v1.size()==4) {
							Error frame = new Error("所查询对象数据库中不存在",0);
							frame.setVisible(true);//报错界面可见
						}
						else {
							//System.out.println(v1.size());
							Object[][] data =new Object[v1.size()/4][4];
							for(int i1=0;i1<v1.size()/4;i1++) {
								for (int j=0;j<4;j++) {
									data[i1][j]=v1.elementAt((i1)*4+j);
								}
							}
							table = new JTable(data, columnNames);
							table.setBounds(240, 400, 300, 120);
							//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  
							contentPane.add(table);//查询结果
							validate();
							repaint();
						}
						
						
					} catch (SQLException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
				}
				else {
					String class_id=textField.getText();
					String columnNames[]= {"class_id","number"};
					
					String order3="select * from class where class_id="+class_id;//获取实验对应数据
					ResultSet result3;//获取实验对应数据的state
					database_order dc3 = new database_order(order3);//执行命令，获取实验对应数据
					result3=dc3.resultset;
					Vector v1=new Vector();
					v1.addElement("class_id");
					v1.addElement("number");
					
					try {
						while(result3.next()) {//将信息输入对应vector
							v1.addElement(result3.getString(1));
							v1.addElement(result3.getString(2));
						}
						if (v1.size()==2) {
							Error frame = new Error("所查询对象数据库中不存在",0);
							frame.setVisible(true);//报错界面可见
						}
						else {
							//System.out.println(v1.size());
							Object[][] data =new Object[v1.size()/2][2];
							for(int i1=0;i1<v1.size()/2;i1++) {
								for (int j=0;j<2;j++) {
									data[i1][j]=v1.elementAt((i1)*2+j);
								}
							}
							table = new JTable(data, columnNames);
							table.setBounds(240, 400, 300, 120);
							//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  
							contentPane.add(table);//查询结果
							validate();
							repaint();
						}
					} catch (SQLException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
					
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 17));
		btnNewButton.setBounds(321, 361, 97, 23);
		contentPane.add(btnNewButton);//确定
		
		setVisible(true);
	}

}
