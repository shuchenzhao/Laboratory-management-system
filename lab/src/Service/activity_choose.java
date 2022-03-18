package Service;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Service.Sign_up;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import Object.User;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;

public class activity_choose extends JFrame {

	private JPanel contentPane;//面板
	private JLabel lblNewLabel_1;//欢迎
	private JButton btnNewButton_1;//返回图片按钮
	private JButton btnNewButton_2;//用户中心图片按钮
	private JButton btnNewButton_3;//实验管理
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					activity_choose frame = new activity_choose(new User());
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
	public activity_choose(User user) {
		setTitle("\u6559\u5E08\u7BA1\u7406");//界面名字
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点叉即关闭程序
		setBounds(300, 100, 760, 590);//设置界面的大小
		setResizable(false);//设置界面不可变化
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);//创建面板
		
		btnNewButton_1=new JButton();
		btnNewButton_1.addActionListener(new ActionListener() {//返回按钮被点击
			public void actionPerformed(ActionEvent e) {
				setVisible(false);//教师功能选择界面不可见
				User user=new User();//用户
				Sign_up frame = new Sign_up(user);//返回管理员功能选择界面
				frame.setVisible(true);//登录界面可见
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("image/通用-退出登录图标.png"));
		btnNewButton_1.setBounds(80, 100, 60, 60);
		btnNewButton_1.setBorderPainted(false);
		contentPane.add(btnNewButton_1);//用户中心图片按钮
		
		lblNewLabel_1 = new JLabel("\u6B22\u8FCE\u8FDB\u5165\u5B9E\u9A8C\u5458\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 35));
		lblNewLabel_1.setBounds(178, 90, 392, 53);
		contentPane.add(lblNewLabel_1);//欢迎
		
		btnNewButton_2=new JButton();
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);//实验员功能选择界面不可见
				UserCenter frame = new UserCenter(user);
				frame.setVisible(true);//成绩管理界面可见
				
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("image/通用-用户名图标（大）.png"));
		btnNewButton_2.setBounds(600, 100, 60, 60);
		btnNewButton_2.setBorderPainted(false);
		contentPane.add(btnNewButton_2);//用户中心图片按钮
		
		btnNewButton_3 = new JButton("\u6210\u7EE9\u7BA1\u7406");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);//管理员功能选择界面不可见
				Grade_management frame = new Grade_management(user);
				frame.setVisible(true);//课程与实验管理界面可见
				
			}
		});
		btnNewButton_3.setBounds(217, 267, 328, 78);
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setFont(new Font("仿宋", Font.PLAIN, 32));
		contentPane.add(btnNewButton_3);//课程与实验管理
		
		setVisible(true);
	}
	
}