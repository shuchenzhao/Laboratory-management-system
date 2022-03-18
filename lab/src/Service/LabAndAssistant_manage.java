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

	private JPanel contentPane;//���
	private JButton btnNewButton_1;//����ͼƬ��ť
	private JLabel lblNewLabel_1;//��ӭ
	private JButton btnNewButton_2;//����ʵ����
	private JButton btnNewButton_3;//����ʵ��Ա
	private JButton btnNewButton_4;//��ѯ���а���

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
		setTitle("\u5B9E\u9A8C\u5BA4\u4E0E\u5B9E\u9A8C\u5458\u7BA1\u7406");//��������
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
		
		lblNewLabel_1 = new JLabel("��ӭ����ʵ������ʵ��Ա�������");
		lblNewLabel_1.setFont(new Font("΢���ź�", Font.PLAIN, 35));
		lblNewLabel_1.setBounds(162, 80, 536, 53);
		contentPane.add(lblNewLabel_1);//��ӭ
		
		btnNewButton_2 = new JButton("����ʵ����");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);//ʵ����ʵ��Ա������治�ɼ�
				Arrange_room frame = new Arrange_room(user);
				frame.setVisible(true);//����ʵ���ҽ���ɼ�
			}
		});
		btnNewButton_2.setFont(new Font("����", Font.PLAIN, 32));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(214, 234, 328, 78);
		contentPane.add(btnNewButton_2);//����ʵ����
		
		btnNewButton_3 = new JButton("����ʵ��Ա");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);//ʵ����ʵ��Ա������治�ɼ�
				Arrange_assistant frame = new Arrange_assistant(user);
				frame.setVisible(true);//����ʵ��Ա����ɼ�
			}
		});
		btnNewButton_3.setFont(new Font("����", Font.PLAIN, 32));
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setBounds(214, 335, 328, 78);
		contentPane.add(btnNewButton_3);//����ʵ��Ա
		
		btnNewButton_4 = new JButton("��ѯ���а���");
		btnNewButton_4.setFont(new Font("����", Font.PLAIN, 32));
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.setBounds(214, 435, 328, 78);
		//contentPane.add(btnNewButton_4);//��ѯ���а���
		
		setVisible(true);
	}
}
