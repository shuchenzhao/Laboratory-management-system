package Service;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Object.User;

public class Insert extends JFrame {

	private JPanel contentPane;//面板
	private JButton btnNewButton_1;//返回图片按钮
	private JLabel lblNewLabel_1;//欢迎
	private JButton btnNewButton_2;//录入
	private JButton btnNewButton_3;//查询


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insert frame = new Insert(new User());
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
	public Insert(User user) {
		setTitle("录入");//界面名字
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
		
		lblNewLabel_1 = new JLabel("欢迎来到班级与学生录入界面");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 35));
		lblNewLabel_1.setBounds(162, 80, 536, 53);
		contentPane.add(lblNewLabel_1);//欢迎
		
		btnNewButton_2 = new JButton("班级录入");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);//录入管理界面不可见
				Class_insert frame = new Class_insert(user);
				frame.setVisible(true);//班级录入界面可见
			}
		});
		btnNewButton_2.setFont(new Font("仿宋", Font.PLAIN, 32));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(214, 234, 328, 78);
		contentPane.add(btnNewButton_2);//班级录入
		
		btnNewButton_3 = new JButton("学生录入");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);//录入管理界面不可见
				Student_insert frame = new Student_insert(user);
				frame.setVisible(true);//学生录入界面可见
			}
		});
		btnNewButton_3.setFont(new Font("仿宋", Font.PLAIN, 32));
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setBounds(214, 335, 328, 78);
		contentPane.add(btnNewButton_3);//学生录入
		
		setVisible(true);
	}

}
