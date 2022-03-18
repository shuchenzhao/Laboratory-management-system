package Service;

import java.awt.BorderLayout;
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
import java.awt.Color;

public class Message_insert extends JFrame {

	private JPanel contentPane;//面板
	private JButton btnNewButton_1;//返回图片按钮
	private JLabel lblNewLabel_1;//欢迎
	private JButton btnNewButton;//课程信息录入
	private JButton btnNewButton_2;//实验信息录入
	private JLabel lblNewLabel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Message_insert frame = new Message_insert(new User());
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
	public Message_insert(User user) {
		setTitle("数据录入");//界面名字
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
				setVisible(false);//安排实验员界面不可见
				CourseAndExperiment_manage frame = new CourseAndExperiment_manage(user);
				frame.setVisible(true);//实验与实验员管理界面可见
			}
		});
		contentPane.setLayout(null);
		btnNewButton_1.setIcon(new ImageIcon("image/通用-退出登录图标.png"));
		btnNewButton_1.setBorderPainted(false);
		contentPane.add(btnNewButton_1);//返回图片按钮
		
		lblNewLabel_1 = new JLabel("信息录入");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 35));
		lblNewLabel_1.setBounds(300, 80, 350, 53);
		contentPane.add(lblNewLabel_1);//欢迎
		
		btnNewButton = new JButton("课程信息录入");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);//信息录入界面不可见
				Course_insert frame = new Course_insert(user);
				frame.setVisible(true);//课程信息录入界面可见
			}
		});
		btnNewButton.setFont(new Font("仿宋", Font.PLAIN, 32));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(202, 230, 328, 78);
		contentPane.add(btnNewButton);//课程信息录入
		
		btnNewButton_2 = new JButton("实验信息录入");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);//信息录入界面不可见
				Experiment_insert frame = new Experiment_insert(user);
				frame.setVisible(true);//实验信息录入界面可见
			}
		});
		btnNewButton_2.setFont(new Font("仿宋", Font.PLAIN, 32));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(202, 366, 328, 78);
		contentPane.add(btnNewButton_2);//实验信息录入
		
		lblNewLabel = new JLabel("提示：先录入实验信息再录入对应的课程信息");
		lblNewLabel.setBounds(242, 488, 240, 15);
		contentPane.add(lblNewLabel);//提示
		
		setVisible(true);
	}

}
