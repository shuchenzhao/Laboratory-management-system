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

	private JPanel contentPane;//���
	private JButton btnNewButton_1;//����ͼƬ��ť
	private JLabel lblNewLabel_1;//��ӭ
	private JButton btnNewButton;//�γ���Ϣ¼��
	private JButton btnNewButton_2;//ʵ����Ϣ¼��
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
		setTitle("����¼��");//��������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//��漴�رճ���
		setBounds(300, 100, 760, 590);//���ý���Ĵ�С
		setResizable(false);//���ý��治�ɱ仯
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);//���
		
		btnNewButton_1=new JButton();
		btnNewButton_1.setBounds(80, 80, 60, 60);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);//����ʵ��Ա���治�ɼ�
				CourseAndExperiment_manage frame = new CourseAndExperiment_manage(user);
				frame.setVisible(true);//ʵ����ʵ��Ա�������ɼ�
			}
		});
		contentPane.setLayout(null);
		btnNewButton_1.setIcon(new ImageIcon("image/ͨ��-�˳���¼ͼ��.png"));
		btnNewButton_1.setBorderPainted(false);
		contentPane.add(btnNewButton_1);//����ͼƬ��ť
		
		lblNewLabel_1 = new JLabel("��Ϣ¼��");
		lblNewLabel_1.setFont(new Font("΢���ź�", Font.PLAIN, 35));
		lblNewLabel_1.setBounds(300, 80, 350, 53);
		contentPane.add(lblNewLabel_1);//��ӭ
		
		btnNewButton = new JButton("�γ���Ϣ¼��");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);//��Ϣ¼����治�ɼ�
				Course_insert frame = new Course_insert(user);
				frame.setVisible(true);//�γ���Ϣ¼�����ɼ�
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 32));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(202, 230, 328, 78);
		contentPane.add(btnNewButton);//�γ���Ϣ¼��
		
		btnNewButton_2 = new JButton("ʵ����Ϣ¼��");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);//��Ϣ¼����治�ɼ�
				Experiment_insert frame = new Experiment_insert(user);
				frame.setVisible(true);//ʵ����Ϣ¼�����ɼ�
			}
		});
		btnNewButton_2.setFont(new Font("����", Font.PLAIN, 32));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(202, 366, 328, 78);
		contentPane.add(btnNewButton_2);//ʵ����Ϣ¼��
		
		lblNewLabel = new JLabel("��ʾ����¼��ʵ����Ϣ��¼���Ӧ�Ŀγ���Ϣ");
		lblNewLabel.setBounds(242, 488, 240, 15);
		contentPane.add(lblNewLabel);//��ʾ
		
		setVisible(true);
	}

}
