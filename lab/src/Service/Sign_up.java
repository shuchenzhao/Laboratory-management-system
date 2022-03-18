package Service;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Object.User;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import java.awt.Dimension;

public class Sign_up extends JFrame {

	private JPanel contentPane;//���
	private JPasswordField passwordField;//���������
	private JTextField textField;//�û��������
	private JButton btnNewButton;//��¼��ť
	private JLabel lblNewLabel_1;//�û����ı���
	private JLabel lblNewLabel_2;//�����ı���
	private JLabel lblNewLabel_3;//����ϵͳ�ı���
	private JLabel lblNewLabel_4;//С��ͷ
	private JLabel lblNewLabel_5;//С��

	/**
	 * Launch the application.
	 */
	
	public String get_text() {//��ȡ�ı�����������
		return textField.getText();
	}
	
	public String get_pass() {//��ȡ�������������
		return passwordField.getText();
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sign_up frame = new Sign_up(new User());
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
	public Sign_up(User user) {
		
		setForeground(Color.WHITE);
		setBackground(Color.WHITE);//���ñ�����ɫ
			
		setTitle("\u5B9E\u9A8C\u7BA1\u7406\u7CFB\u7EDF");//��������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//��漴�رճ���
		setBounds(300, 100, 760, 590);//���ý���Ĵ�С
		setResizable(false);//���ý��治�ɱ仯
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);//��崴��
		
		passwordField = new JPasswordField();
		passwordField.setBounds(296, 265, 235, 41);
		contentPane.add(passwordField);//�������봴��
		
		textField = new JTextField();
		textField.setBounds(296, 197, 235, 41);
		contentPane.add(textField);
		textField.setColumns(10);//�ı����봴��
		
		
		lblNewLabel_1 = new JLabel("\u7528\u6237\u540D");
		lblNewLabel_1.setFont(new Font("������", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(178, 196, 91, 42);
		contentPane.add(lblNewLabel_1);//�û���
		
		lblNewLabel_2 = new JLabel("\u5BC6\u7801");
		lblNewLabel_2.setFont(new Font("������", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(208, 271, 61, 35);
		contentPane.add(lblNewLabel_2);//����
		
		lblNewLabel_4 = new JLabel();
		lblNewLabel_4.setIcon(new ImageIcon("image/ͨ��-�޸�����ͼ��.png"));
		lblNewLabel_4.setBounds(269, 280, 20, 20);
		contentPane.add(lblNewLabel_4);//��
		
		lblNewLabel_5 = new JLabel();
		lblNewLabel_5.setIcon(new ImageIcon("image/ͨ��-�û���ͼ��.png"));
		lblNewLabel_5.setBounds(269, 206, 20, 20);
		contentPane.add(lblNewLabel_5);//С��
		
		btnNewButton = new JButton("\u767B\u5F55");//��¼��ť����
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//�����¼��ť��Ĳ���
				
				database_connect dc = new database_connect();
	           
				try {
					PreparedStatement state=dc.conn.prepareStatement("select * from user where user_id=?");
					state.setString(1, get_text());
					
					ResultSet rs = state.executeQuery();
					
					if(rs.next()) {//�з��أ����û�����ȷ
						if(rs.getString("password").equals(get_pass())) {//������ȷ
							if(rs.getString("user_type").equals("tch")) {//��ʦ���
								{//����ʦ�û�����ֵ
									user.insert_id(get_text());//�����û�ID
									user.insert_password(get_pass());//�����û�����
									Statement statement=dc.conn.createStatement();
									ResultSet resultset=statement.executeQuery("select * from teacher where user_id="+user.get_user_id());//Ѱ�����ݿ��ж�Ӧ�û�
									if (resultset.next())//sql�з���
										user.insert_name(resultset.getString("tch_name"));//����ʦ���������û�����
									else {
										Error frame = new Error("��ʦ�в����ڸ��û�",0);
										frame.setVisible(true);//�������ɼ�
									}
									
									//System.out.println("id="+user.get_user_id()+",name="+user.get_user_name()+",password="+user.get_user_password());
								}//����ʦ�û�����ֵ
								setVisible(false);//��¼���治�ɼ�
								activity_choose frame = new activity_choose(user);
								frame.setVisible(true);//��ʦ����ѡ�����ɼ�
							}
							else if(rs.getString("user_type").equals("admin")) {//����Ա���
								{//������Ա�û�����ֵ
									user.insert_id(get_text());//�����û�ID
									user.insert_password(get_pass());//�����û�����
									Statement statement=dc.conn.createStatement();
									ResultSet resultset=state.executeQuery("select * from administrator where user_id="+user.get_user_id());//Ѱ�����ݿ��ж�Ӧ�û�
									if (resultset.next())//sql�з���
										user.insert_name(resultset.getString("admin_name"));//������Ա���������û�����
									else {
										Error frame = new Error("����Ա�в����ڸ��û�",0);
										frame.setVisible(true);//�������ɼ�
									}
									
									//System.out.println("id="+user.get_user_id()+",name="+user.get_user_name()+",password="+user.get_user_password());
								}//������Ա�û�����ֵ
									setVisible(false);//��¼���治�ɼ�
									super_activity_choose frame = new super_activity_choose(user);
									frame.setVisible(true);//����Ա����ѡ�����ɼ�
								}
							    else {//����֮�������޷���¼
							    	Error frame = new Error("������޷���¼����վ",0);
									frame.setVisible(true);//�������ɼ�
							    }
						}
						else {//���벻��ȷ
							
							Error frame = new Error("�������",0);
							frame.setVisible(true);//�������ɼ�
						}
					}
					else {//�޷��أ����û�������ȷ
						Error frame = new Error("�û�������",0);
						frame.setVisible(true);//�������ɼ�
					}
				} catch (SQLException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(362, 330, 97, 23);
		contentPane.add(btnNewButton);//��¼��ť
		
		lblNewLabel_3 = new JLabel("\u5B9E\u9A8C\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel_3.setFont(new Font("����", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(316, 73, 184, 57);
		contentPane.add(lblNewLabel_3);//ϵͳ˵��
		
		setVisible(true);
		
	}
}
