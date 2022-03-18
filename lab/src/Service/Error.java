package Service;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Error extends JFrame {

	private JPanel contentPane;//面板
	private JLabel lblNewLabel;//文字
	private JLabel lblNewLabel_1;//图标
	private JButton btnNewButton;//确定按钮

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Error frame = new Error("用户名或密码错误",0);
					//frame.setVisible(true);
					Error frame1 = new Error("单纯提示",1);
					frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Error(String err,int sign) {
		setTitle("\u63D0\u793A");//界面名字
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点叉即关闭程序
		setBounds(400, 300, 600, 300);//设置界面的大小
		setResizable(false);//设置界面不可变化
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);//面板
		
		lblNewLabel = new JLabel(err);
		lblNewLabel.setBounds(188, 81, 366, 47);
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		contentPane.add(lblNewLabel);//文字
		
		if(sign==0) {//失败提示
		lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setIcon(new ImageIcon("image/通用-弹窗关闭图标.png"));
		lblNewLabel_1.setBounds(130, 75, 60, 60);
		contentPane.add(lblNewLabel_1);//报错图标
		}
		if(sign==1) {//单纯只是提示
			lblNewLabel_1 = new JLabel();
			lblNewLabel_1.setIcon(new ImageIcon("image/通用-提醒图标.png"));
			lblNewLabel_1.setBounds(130, 75, 60, 60);
			contentPane.add(lblNewLabel_1);//报错图标
		}
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.setBounds(240, 173, 97, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//点击确定按钮之后页面不可见
				
				setVisible(false);//页面不可见
				
			}
		});
		contentPane.add(btnNewButton);
		
		setVisible(true);
	}

}
