package Service;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Object.User;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class LabAndAssistant_manage extends JFrame {

	private JPanel contentPane;//面板
	private JButton btnNewButton_1;//返回图片按钮
	private JLabel lblNewLabel_1;//欢迎
	private JButton btnNewButton_2;//安排实验室
	private JButton btnNewButton_3;//安排实验员
	private JButton btnNewButton_4;//查询已有安排

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LabAndAssistant_manage frame = new LabAndAssistant_manage(new User());
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
	public LabAndAssistant_manage(User user) {
		setTitle("\u5B9E\u9A8C\u5BA4\u4E0E\u5B9E\u9A8C\u5458\u7BA1\u7406");//界面名字
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
		
		lblNewLabel_1 = new JLabel("欢迎来到实验室与实验员管理界面");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 35));
		lblNewLabel_1.setBounds(162, 80, 536, 53);
		contentPane.add(lblNewLabel_1);//欢迎
		
		btnNewButton_2 = new JButton("安排实验室");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);//实验与实验员管理界面不可见
				Arrange_room frame = new Arrange_room(user);
				frame.setVisible(true);//安排实验室界面可见
			}
		});
		btnNewButton_2.setFont(new Font("仿宋", Font.PLAIN, 32));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(214, 234, 328, 78);
		contentPane.add(btnNewButton_2);//安排实验室
		
		btnNewButton_3 = new JButton("安排实验员");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);//实验与实验员管理界面不可见
				Arrange_assistant frame = new Arrange_assistant(user);
				frame.setVisible(true);//安排实验员界面可见
			}
		});
		btnNewButton_3.setFont(new Font("仿宋", Font.PLAIN, 32));
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setBounds(214, 335, 328, 78);
		contentPane.add(btnNewButton_3);//安排实验员
		
		btnNewButton_4 = new JButton("查询已有安排");
		btnNewButton_4.setFont(new Font("仿宋", Font.PLAIN, 32));
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.setBounds(214, 435, 328, 78);
		//contentPane.add(btnNewButton_4);//查询已有安排
		
		setVisible(true);
	}
}
