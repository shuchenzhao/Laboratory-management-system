package Service;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Object.User;
import Service.Error;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserCenter extends JFrame {

	private JPanel contentPane;//���
	private JLabel lblNewLabel_1;//�޸�����
	private JLabel lblNewLabel_2;//ԭ����
	private JLabel lblNewLabel_3;//������
	private JLabel lblNewLabel_4;//ȷ��������
	private JTextField textField;//ԭ�����ı�
	private JTextField textField_1;//�������ı�
	private JTextField textField_2;//ȷ���������ı�
	private JButton btnNewButton;//�����޸İ�ť
	private JButton btnNewButton_1;//���ذ�ť
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserCenter frame = new UserCenter(new User());
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
	public UserCenter(User user) {
		setTitle("\u7528\u6237\u4E2D\u5FC3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 760, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);//���
		
		lblNewLabel_1 = new JLabel("\u4FEE\u6539\u5BC6\u7801");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(308, 77, 160, 52);
		contentPane.add(lblNewLabel_1);//�޸�����
		
		lblNewLabel_2 = new JLabel("\u539F\u5BC6\u7801");
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(174, 187, 98, 38);
		contentPane.add(lblNewLabel_2);//ԭ����
		
		lblNewLabel_3 = new JLabel("\u65B0\u5BC6\u7801");
		lblNewLabel_3.setFont(new Font("����", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(174, 282, 98, 38);
		contentPane.add(lblNewLabel_3);//������
		
		lblNewLabel_4 = new JLabel("\u786E\u8BA4\u5BC6\u7801");
		lblNewLabel_4.setFont(new Font("����", Font.PLAIN, 30));
		lblNewLabel_4.setBounds(150, 376, 122, 38);
		contentPane.add(lblNewLabel_4);//ȷ��������
		
		textField = new JTextField();
		textField.setBounds(281, 187, 224, 35);
		contentPane.add(textField);
		textField.setColumns(10);//ԭ�����ı�
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(281, 282, 224, 35);
		contentPane.add(textField_1);//�������ı�
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(281, 376, 224, 35);
		contentPane.add(textField_2);//ȷ���������ı�
		
		btnNewButton = new JButton("\u4FDD\u5B58\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password=user.get_user_password();
				String s0=textField.getText();
				String s1=textField_1.getText();
				String s2=textField_2.getText();
				if (password.equals(s0)) {//��������ȷ
					if(s1.equals(s2)) {
						user.change_password(s1);
						setVisible(false);//����������治�ɼ�
						super_activity_choose frame = new super_activity_choose(user);
						frame.setVisible(true);//����Ա����ѡ�����ɼ�
						Error frame_1 = new Error("�����޸ĳɹ�",1);
						frame_1.setVisible(true);//��ʾ����ɼ�
					}
					else {
						Error frame=new Error("ȷ�������������벻һ��",0);
						frame.setVisible(true);//�������ɼ�
					}
				}
				else {
					Error frame=new Error("ԭ�������",0);
					frame.setVisible(true);//�������ɼ�
				}
				
				
				
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 12));
		btnNewButton.setBounds(344, 461, 97, 23);
		contentPane.add(btnNewButton);//�����޸İ�ť
		
		btnNewButton_1=new JButton();
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);//����������治�ɼ�
				super_activity_choose frame = new super_activity_choose(user);
				frame.setVisible(true);//����Ա����ѡ�����ɼ�
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("image/ͨ��-�˳���¼ͼ��.png"));
		btnNewButton_1.setBounds(80, 100, 60, 60);
		btnNewButton_1.setBorderPainted(false);
		contentPane.add(btnNewButton_1);//���ذ�ť
		
		setVisible(true);
	}
}
