
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

	private JPanel contentPane;//���
	private JLabel lblNewLabel_1;//��ӭ
	private JButton btnNewButton_1;//�γ̹���
	private JButton btnNewButton_2;//�༶����
	private JButton btnNewButton_3;//ʵ�����
	private JButton btnNewButton_4;//�û�����ͼƬ��ť
	private JButton btnNewButton_5;//����ͼƬ��ť

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
		setTitle("\u7BA1\u7406\u5458\u7BA1\u7406");//��������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//��漴�رճ���
		setBounds(300, 100, 760, 590);//���ý���Ĵ�С
		setResizable(false);//���ý��治�ɱ仯
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);//���
		
		btnNewButton_1 = new JButton("\u5B9E\u9A8C\u5BA4\u4E0E\u5B9E\u9A8C\u5458\u7BA1\u7406");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);//����Ա����ѡ����治�ɼ�
				LabAndAssistant_manage frame = new LabAndAssistant_manage(user);
				frame.setVisible(true);//ʵ������ʵ��Ա�������ɼ�
				
			}
		});
		btnNewButton_1.setBounds(217, 448, 328, 78);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("����", Font.PLAIN, 32));
		contentPane.add(btnNewButton_1);//ʵ������ʵ��Ա����
		
		btnNewButton_2 = new JButton("\u73ED\u7EA7\u4E0E\u5B66\u751F\u7BA1\u7406");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);//����Ա����ѡ����治�ɼ�
				ClassAndStudent_manage frame = new ClassAndStudent_manage(user);
				frame.setVisible(true);//�༶��ѧ���������ɼ�
				
			}
		});
		btnNewButton_2.setBounds(217, 355, 328, 78);
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setFont(new Font("����", Font.PLAIN, 32));
		contentPane.add(btnNewButton_2);//�༶��ѧ������
		
		btnNewButton_3 = new JButton("\u8BFE\u7A0B\u4E0E\u5B9E\u9A8C\u7BA1\u7406");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);//����Ա����ѡ����治�ɼ�
				CourseAndExperiment_manage frame = new CourseAndExperiment_manage(user);
				frame.setVisible(true);//�γ���ʵ��������ɼ�
				
			}
		});
		btnNewButton_3.setBounds(217, 267, 328, 78);
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setFont(new Font("����", Font.PLAIN, 32));
		contentPane.add(btnNewButton_3);//�γ���ʵ�����
		
		lblNewLabel_1 = new JLabel("\u6B22\u8FCE\u8FDB\u5165\u7BA1\u7406\u5458\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel_1.setFont(new Font("΢���ź�", Font.PLAIN, 35));
		lblNewLabel_1.setBounds(178, 90, 392, 53);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton_4=new JButton();
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);//����Ա����ѡ����治�ɼ�
				UserCenter frame = new UserCenter(user);
				frame.setVisible(true);//�û����Ľ���ɼ�
				
			}
		});
		//btnNewButton_4.setPreferredSize(new Dimension(60,60));
		btnNewButton_4.setIcon(new ImageIcon("image/ͨ��-�û���ͼ�꣨��.png"));
		btnNewButton_4.setBounds(600, 100, 60, 60);
		btnNewButton_4.setBorderPainted(false);
		contentPane.add(btnNewButton_4);//�û�����ͼƬ��ť
		
		btnNewButton_5=new JButton();
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);//����Ա����ѡ����治�ɼ�
				User user=new User();//�û�
				Sign_up frame = new Sign_up(user);//���ص�¼����
				frame.setVisible(true);
			}
		});
		btnNewButton_5.setIcon(new ImageIcon("image/ͨ��-�˳���¼ͼ��.png"));
		btnNewButton_5.setBounds(80, 100, 60, 60);
		btnNewButton_5.setBorderPainted(false);
		contentPane.add(btnNewButton_5);//����ͼƬ��ť
		
		setVisible(true);
	}
}
