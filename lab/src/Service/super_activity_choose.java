
package Service;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Object.User;

import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.SystemColor;

public class super_activity_choose extends JFrame {

	private JPanel contentPane;//面板
	private JLabel lblNewLabel_1;//欢迎
	private JButton btnNewButton_1;//课程管理
	private JButton btnNewButton_2;//班级管理
	private JButton btnNewButton_3;//实验管理
	private JButton btnNewButton_4;//用户中心图片按钮
	private JButton btnNewButton_5;//返回图片按钮

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					super_activity_choose frame = new super_activity_choose(new User());
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
	public super_activity_choose(User user) {
		setTitle("\u7BA1\u7406\u5458\u7BA1\u7406");//界面名字
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点叉即关闭程序
		setBounds(300, 100, 760, 590);//设置界面的大小
		setResizable(false);//设置界面不可变化
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);//面板
		
		btnNewButton_1 = new JButton("\u5B9E\u9A8C\u5BA4\u4E0E\u5B9E\u9A8C\u5458\u7BA1\u7406");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);//管理员功能选择界面不可见
				LabAndAssistant_manage frame = new LabAndAssistant_manage(user);
				frame.setVisible(true);//实验室与实验员管理界面可见
				
			}
		});
		btnNewButton_1.setBounds(217, 448, 328, 78);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("仿宋", Font.PLAIN, 32));
		contentPane.add(btnNewButton_1);//实验室与实验员管理
		
		btnNewButton_2 = new JButton("\u73ED\u7EA7\u4E0E\u5B66\u751F\u7BA1\u7406");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);//管理员功能选择界面不可见
				ClassAndStudent_manage frame = new ClassAndStudent_manage(user);
				frame.setVisible(true);//班级与学生管理界面可见
				
			}
		});
		btnNewButton_2.setBounds(217, 355, 328, 78);
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setFont(new Font("仿宋", Font.PLAIN, 32));
		contentPane.add(btnNewButton_2);//班级与学生管理
		
		btnNewButton_3 = new JButton("\u8BFE\u7A0B\u4E0E\u5B9E\u9A8C\u7BA1\u7406");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);//管理员功能选择界面不可见
				CourseAndExperiment_manage frame = new CourseAndExperiment_manage(user);
				frame.setVisible(true);//课程与实验管理界面可见
				
			}
		});
		btnNewButton_3.setBounds(217, 267, 328, 78);
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setFont(new Font("仿宋", Font.PLAIN, 32));
		contentPane.add(btnNewButton_3);//课程与实验管理
		
		lblNewLabel_1 = new JLabel("\u6B22\u8FCE\u8FDB\u5165\u7BA1\u7406\u5458\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 35));
		lblNewLabel_1.setBounds(178, 90, 392, 53);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton_4=new JButton();
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);//管理员功能选择界面不可见
				UserCenter frame = new UserCenter(user);
				frame.setVisible(true);//用户中心界面可见
				
			}
		});
		//btnNewButton_4.setPreferredSize(new Dimension(60,60));
		btnNewButton_4.setIcon(new ImageIcon("image/通用-用户名图标（大）.png"));
		btnNewButton_4.setBounds(600, 100, 60, 60);
		btnNewButton_4.setBorderPainted(false);
		contentPane.add(btnNewButton_4);//用户中心图片按钮
		
		btnNewButton_5=new JButton();
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);//管理员功能选择界面不可见
				User user=new User();//用户
				Sign_up frame = new Sign_up(user);//返回登录界面
				frame.setVisible(true);
			}
		});
		btnNewButton_5.setIcon(new ImageIcon("image/通用-退出登录图标.png"));
		btnNewButton_5.setBounds(80, 100, 60, 60);
		btnNewButton_5.setBorderPainted(false);
		contentPane.add(btnNewButton_5);//返回图片按钮
		
		setVisible(true);
	}
}
