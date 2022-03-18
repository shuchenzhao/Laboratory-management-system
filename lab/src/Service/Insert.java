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

	private JPanel contentPane;//���
	private JButton btnNewButton_1;//����ͼƬ��ť
	private JLabel lblNewLabel_1;//��ӭ
	private JButton btnNewButton_2;//¼��
	private JButton btnNewButton_3;//��ѯ


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
		setTitle("¼��");//��������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//��漴�رճ���
		setBounds(300, 100, 760, 590);//���ý���Ĵ�С
		setResizable(false);//���ý��治�ɱ仯
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);//���
		
		btnNewButton_1=new JButton();
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);//�༶��ѧ��������治�ɼ�
				ClassAndStudent_manage frame = new ClassAndStudent_manage(user);
				frame.setVisible(true);//������ѡ�����ɼ�
			}
		});
		contentPane.setLayout(null);
		btnNewButton_1.setIcon(new ImageIcon("image/ͨ��-�˳���¼ͼ��.png"));
		btnNewButton_1.setBounds(80, 80, 60, 60);
		btnNewButton_1.setBorderPainted(false);
		contentPane.add(btnNewButton_1);//�û�����ͼƬ��ť
		
		lblNewLabel_1 = new JLabel("��ӭ�����༶��ѧ��¼�����");
		lblNewLabel_1.setFont(new Font("΢���ź�", Font.PLAIN, 35));
		lblNewLabel_1.setBounds(162, 80, 536, 53);
		contentPane.add(lblNewLabel_1);//��ӭ
		
		btnNewButton_2 = new JButton("�༶¼��");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);//¼�������治�ɼ�
				Class_insert frame = new Class_insert(user);
				frame.setVisible(true);//�༶¼�����ɼ�
			}
		});
		btnNewButton_2.setFont(new Font("����", Font.PLAIN, 32));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(214, 234, 328, 78);
		contentPane.add(btnNewButton_2);//�༶¼��
		
		btnNewButton_3 = new JButton("ѧ��¼��");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);//¼�������治�ɼ�
				Student_insert frame = new Student_insert(user);
				frame.setVisible(true);//ѧ��¼�����ɼ�
			}
		});
		btnNewButton_3.setFont(new Font("����", Font.PLAIN, 32));
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setBounds(214, 335, 328, 78);
		contentPane.add(btnNewButton_3);//ѧ��¼��
		
		setVisible(true);
	}

}
