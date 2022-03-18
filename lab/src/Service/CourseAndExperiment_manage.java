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
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.event.AncestorListener;

import Object.User;

import javax.swing.event.AncestorEvent;
import javax.swing.JComboBox;

public class CourseAndExperiment_manage extends JFrame {

	private JPanel contentPane;//面板
	private JButton btnNewButton_1;//返回图片按钮
	private JLabel lblNewLabel_1;//欢迎
	private JButton btnNewButton_2;//信息录入
	private JButton btnNewButton_3;//一键排课
	private JButton btnNewButton_4;//查询安排

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CourseAndExperiment_manage frame = new CourseAndExperiment_manage(new User());
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
	public CourseAndExperiment_manage(User user) {
		setTitle("课程与实验管理");//界面名字
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点叉即关闭程序
		setBounds(300, 100, 760, 590);//设置界面的大小
		setResizable(false);//设置界面不可变化
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);//面板
		
		btnNewButton_1=new JButton();
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);//实验室与实验员界面不可见
				super_activity_choose frame = new super_activity_choose(user);
				frame.setVisible(true);//管理功能选择界面可见
			}
		});
		contentPane.setLayout(null);
		btnNewButton_1.setIcon(new ImageIcon("image/通用-退出登录图标.png"));
		btnNewButton_1.setBounds(80, 80, 60, 60);
		btnNewButton_1.setBorderPainted(false);
		contentPane.add(btnNewButton_1);//返回图片按钮
		
		lblNewLabel_1 = new JLabel("欢迎来到课程与实验管理界面");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 35));
		lblNewLabel_1.setBounds(162, 80, 536, 53);
		contentPane.add(lblNewLabel_1);//欢迎
		
		btnNewButton_2 = new JButton("信息录入");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);//课程与实验管理界面不可见
				Message_insert frame = new Message_insert(user);
				frame.setVisible(true);//信息录入界面可见
			}
		});
		btnNewButton_2.setFont(new Font("仿宋", Font.PLAIN, 32));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(214, 234, 328, 78);
		contentPane.add(btnNewButton_2);//信息录入
		
		btnNewButton_3 = new JButton("一键排课");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);//课程与实验管理界面不可见
				Arrange_course frame = new Arrange_course(user);
				frame.setVisible(true);//一键排课界面可见
			}
		});
		btnNewButton_3.setFont(new Font("仿宋", Font.PLAIN, 32));
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setBounds(214, 335, 328, 78);
		contentPane.add(btnNewButton_3);//一键排课
		
		btnNewButton_4 = new JButton("查询安排");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);//课程与实验管理界面不可见
				Select_arrangedExp frame = new Select_arrangedExp(user);
				frame.setVisible(true);//查询安排界面可见
			}
		});
		btnNewButton_4.setFont(new Font("仿宋", Font.PLAIN, 32));
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.setBounds(214, 435, 328, 78);
		contentPane.add(btnNewButton_4);//查询安排
		
		setVisible(true);
		
	}
}
