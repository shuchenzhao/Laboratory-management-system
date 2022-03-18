package Service;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Object.User;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.util.Vector;
import javax.swing.JTextField;
import java.awt.Font;

public class Class_insert extends JFrame {

	private JPanel contentPane;//���
	private JButton btnNewButton;//ȷ��
	private JButton btnNewButton_1;//����ͼƬ��ť
	private JTextField textField;//�༶ID
	private JTextField textField_1;//�༶����
	private JLabel lblNewLabel;//�༶ID
	private JLabel lblNewLabel_1;//�༶����

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Class_insert frame = new Class_insert(new User());
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
	public Class_insert(User user) {
		setTitle("�༶¼��");//��������
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
				setVisible(false);//�༶¼����治�ɼ�
				Insert frame = new Insert(user);
				frame.setVisible(true);//¼�����ɼ�
			}
		});
		contentPane.setLayout(null);
		btnNewButton_1.setIcon(new ImageIcon("image/ͨ��-�˳���¼ͼ��.png"));
		btnNewButton_1.setBorderPainted(false);
		contentPane.add(btnNewButton_1);//�û�����ͼƬ��ť
		
		lblNewLabel = new JLabel("�༶ID");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 30));
		lblNewLabel.setBounds(174, 195, 113, 35);
		contentPane.add(lblNewLabel);//�༶ID
		
		lblNewLabel_1 = new JLabel("�༶����");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(174, 293, 132, 35);
		contentPane.add(lblNewLabel_1);//�༶����
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(333, 200, 237, 35);
		contentPane.add(textField);//�༶ID
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(333, 293, 237, 35);
		contentPane.add(textField_1);//�༶����
		
		btnNewButton = new JButton("ȷ��");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String class_id=textField.getText();
				String number=textField_1.getText();
				
				String order="insert into class values("+class_id+",'"+number+"')";//�������ݿ������
				database_connect dc = new database_connect();
				Statement state;
				try {
					state = dc.conn.createStatement();
					state.executeUpdate(order);
					Error frame = new Error("�༶¼��ɹ�",1);
					frame.setVisible(true);//�������ɼ�
				} catch (SQLException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}//ִ������������ݿ�������
				
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 17));
		btnNewButton.setBounds(308, 422, 97, 23);
		contentPane.add(btnNewButton);//ȷ��
		
		setVisible(true);
	}
}
