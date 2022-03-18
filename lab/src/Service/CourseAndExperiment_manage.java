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

	private JPanel contentPane;//���
	private JButton btnNewButton_1;//����ͼƬ��ť
	private JLabel lblNewLabel_1;//��ӭ
	private JButton btnNewButton_2;//��Ϣ¼��
	private JButton btnNewButton_3;//һ���ſ�
	private JButton btnNewButton_4;//��ѯ����

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
		setTitle("�γ���ʵ�����");//��������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//��漴�رճ���
		setBounds(300, 100, 760, 590);//���ý���Ĵ�С
		setResizable(false);//���ý��治�ɱ仯
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);//���
		
		btnNewButton_1=new JButton();
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);//ʵ������ʵ��Ա���治�ɼ�
				super_activity_choose frame = new super_activity_choose(user);
				frame.setVisible(true);//������ѡ�����ɼ�
			}
		});
		contentPane.setLayout(null);
		btnNewButton_1.setIcon(new ImageIcon("image/ͨ��-�˳���¼ͼ��.png"));
		btnNewButton_1.setBounds(80, 80, 60, 60);
		btnNewButton_1.setBorderPainted(false);
		contentPane.add(btnNewButton_1);//����ͼƬ��ť
		
		lblNewLabel_1 = new JLabel("��ӭ�����γ���ʵ��������");
		lblNewLabel_1.setFont(new Font("΢���ź�", Font.PLAIN, 35));
		lblNewLabel_1.setBounds(162, 80, 536, 53);
		contentPane.add(lblNewLabel_1);//��ӭ
		
		btnNewButton_2 = new JButton("��Ϣ¼��");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);//�γ���ʵ�������治�ɼ�
				Message_insert frame = new Message_insert(user);
				frame.setVisible(true);//��Ϣ¼�����ɼ�
			}
		});
		btnNewButton_2.setFont(new Font("����", Font.PLAIN, 32));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(214, 234, 328, 78);
		contentPane.add(btnNewButton_2);//��Ϣ¼��
		
		btnNewButton_3 = new JButton("һ���ſ�");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);//�γ���ʵ�������治�ɼ�
				Arrange_course frame = new Arrange_course(user);
				frame.setVisible(true);//һ���ſν���ɼ�
			}
		});
		btnNewButton_3.setFont(new Font("����", Font.PLAIN, 32));
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setBounds(214, 335, 328, 78);
		contentPane.add(btnNewButton_3);//һ���ſ�
		
		btnNewButton_4 = new JButton("��ѯ����");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);//�γ���ʵ�������治�ɼ�
				Select_arrangedExp frame = new Select_arrangedExp(user);
				frame.setVisible(true);//��ѯ���Ž���ɼ�
			}
		});
		btnNewButton_4.setFont(new Font("����", Font.PLAIN, 32));
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.setBounds(214, 435, 328, 78);
		contentPane.add(btnNewButton_4);//��ѯ����
		
		setVisible(true);
		
	}
}
