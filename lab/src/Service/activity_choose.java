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

	private JPanel contentPane;//���
	private JLabel lblNewLabel_1;//��ӭ
	private JButton btnNewButton_1;//����ͼƬ��ť
	private JButton btnNewButton_2;//�û�����ͼƬ��ť
	private JButton btnNewButton_3;//ʵ�����
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
		setTitle("\u6559\u5E08\u7BA1\u7406");//��������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//��漴�رճ���
		setBounds(300, 100, 760, 590);//���ý���Ĵ�С
		setResizable(false);//���ý��治�ɱ仯
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);//�������
		
		btnNewButton_1=new JButton();
		btnNewButton_1.addActionListener(new ActionListener() {//���ذ�ť�����
			public void actionPerformed(ActionEvent e) {
				setVisible(false);//��ʦ����ѡ����治�ɼ�
				User user=new User();//�û�
				Sign_up frame = new Sign_up(user);//���ع���Ա����ѡ�����
				frame.setVisible(true);//��¼����ɼ�
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("image/ͨ��-�˳���¼ͼ��.png"));
		btnNewButton_1.setBounds(80, 100, 60, 60);
		btnNewButton_1.setBorderPainted(false);
		contentPane.add(btnNewButton_1);//�û�����ͼƬ��ť
		
		lblNewLabel_1 = new JLabel("\u6B22\u8FCE\u8FDB\u5165\u5B9E\u9A8C\u5458\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel_1.setFont(new Font("΢���ź�", Font.PLAIN, 35));
		lblNewLabel_1.setBounds(178, 90, 392, 53);
		contentPane.add(lblNewLabel_1);//��ӭ
		
		btnNewButton_2=new JButton();
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);//ʵ��Ա����ѡ����治�ɼ�
				UserCenter frame = new UserCenter(user);
				frame.setVisible(true);//�ɼ��������ɼ�
				
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("image/ͨ��-�û���ͼ�꣨��.png"));
		btnNewButton_2.setBounds(600, 100, 60, 60);
		btnNewButton_2.setBorderPainted(false);
		contentPane.add(btnNewButton_2);//�û�����ͼƬ��ť
		
		btnNewButton_3 = new JButton("\u6210\u7EE9\u7BA1\u7406");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);//����Ա����ѡ����治�ɼ�
				Grade_management frame = new Grade_management(user);
				frame.setVisible(true);//�γ���ʵ��������ɼ�
				
			}
		});
		btnNewButton_3.setBounds(217, 267, 328, 78);
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setFont(new Font("����", Font.PLAIN, 32));
		contentPane.add(btnNewButton_3);//�γ���ʵ�����
		
		setVisible(true);
	}
	
}