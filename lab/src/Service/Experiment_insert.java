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
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class Experiment_insert extends JFrame {

	private JPanel contentPane;//���
	private JButton btnNewButton_1;//����ͼƬ��ť
	private JLabel lblNewLabel;//ʵ��ID
	private JLabel lblNewLabel_1;//ʵ������
	private JLabel lblNewLabel_2;//ѧʱ
	private JTextField textField;//ʵ��ID�ı���
	private JTextField textField_1;//ʵ�������ı���
	private JTextField textField_2;//ѧʱ�ı���
	private JButton btnNewButton;//ȷ��
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Experiment_insert frame = new Experiment_insert(new User());
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
	public Experiment_insert(User user) {
		setTitle("ʵ����Ϣ¼��");//��������
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
				setVisible(false);//ʵ����Ϣ¼����治�ɼ�
				Message_insert frame = new Message_insert(user);
				frame.setVisible(true);//��Ϣ¼��������ɼ�
			}
		});
		contentPane.setLayout(null);
		btnNewButton_1.setIcon(new ImageIcon("image/ͨ��-�˳���¼ͼ��.png"));
		btnNewButton_1.setBorderPainted(false);
		contentPane.add(btnNewButton_1);//����ͼƬ��ť
		
		lblNewLabel = new JLabel("ʵ��ID");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 30));
		lblNewLabel.setBounds(148, 181, 122, 32);
		contentPane.add(lblNewLabel);//ʵ��ID
		
		lblNewLabel_1 = new JLabel("ʵ������");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(148, 261, 122, 32);
		contentPane.add(lblNewLabel_1);//ʵ������
		
		lblNewLabel_2 = new JLabel("ѧʱ");
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(148, 345, 122, 32);
		contentPane.add(lblNewLabel_2);//ѧʱ
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(327, 181, 213, 32);
		contentPane.add(textField);//ʵ��ID�ı���
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(327, 261, 213, 32);
		contentPane.add(textField_1);//ʵ�������ı���
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(327, 345, 213, 32);
		contentPane.add(textField_2);//ѧʱ�ı���
		
		btnNewButton = new JButton("ȷ��");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String exp_id=textField.getText().toString();
				String exp_name=textField_1.getText().toString();
				String exp_period=textField_2.getText().toString();
				
				String order="insert into experiment values('"+exp_id+"','"+exp_name+"','"+exp_period+"')";//�������ݿ������
				database_connect dc = new database_connect();
				Statement state;
				try {
					state = dc.conn.createStatement();
					state.executeUpdate(order);//ִ������������ݿ�������
					Error frame = new Error("ʵ��¼��ɹ�",1);
					frame.setVisible(true);//��ʾ����ɼ�
				} catch (SQLException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 17));
		btnNewButton.setBounds(301, 471, 97, 23);
		contentPane.add(btnNewButton);//ȷ��
		
		setVisible(true);
	}

}
