package Service;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.xdevapi.Statement;

import Object.Experiment;
import Object.User;

public class Grade_choose_student extends JFrame {
	private JPanel contentPane;//���
	private JButton btnNewButton_1;//����ͼƬ��ť
	private JLabel lblNewLabel_1;//����
	private JLabel lblNewLabel_2;//ѧ��
	private JLabel lblNewLabel_3;//��ʾ
	private JLabel lblNewLabel_4;//�ɼ�
	private JButton btnNewButton_2;//ȷ����ť
	private JTextField textField;//����
	private JTextField textField_1;//ѧ��
	private JTextField textField_2;//�ɼ�
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Grade_choose_student frame = new Grade_choose_student(new User(),new Experiment());
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
	public Grade_choose_student(User user,Experiment exp) {
		setTitle("\u6210\u7EE9\u7BA1\u7406");//��������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//��漴�رճ���
		setBounds(300, 100, 760, 590);//���ý���Ĵ�С
		setResizable(false);//���ý��治�ɱ仯
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);//���
		
		btnNewButton_1=new JButton();
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);//�ɼ���������ʵ����治�ɼ�
				Grade_management frame = new Grade_management(user);
				frame.setVisible(true);//�ɼ��������ɼ�
			}
		});
		contentPane.setLayout(null);
		btnNewButton_1.setIcon(new ImageIcon("image/ͨ��-�˳���¼ͼ��.png"));
		btnNewButton_1.setBounds(80, 80, 60, 60);
		btnNewButton_1.setBorderPainted(false);
		contentPane.add(btnNewButton_1);//����ͼƬ��ť
		
		lblNewLabel_1 = new JLabel("\u59D3\u540D");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(183, 196, 80, 32);
		contentPane.add(lblNewLabel_1);//����
		
		lblNewLabel_2 = new JLabel("\u5B66\u53F7*");
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(183, 283, 80, 32);
		contentPane.add(lblNewLabel_2);//ѧ��
		
		lblNewLabel_3 = new JLabel("\u8BF7\u8F93\u5165\u59D3\u540D\u5B66\u53F7\u53CA\u6210\u7EE9");
		lblNewLabel_3.setFont(new Font("����", Font.PLAIN, 35));
		lblNewLabel_3.setBounds(221, 53, 372, 60);
		contentPane.add(lblNewLabel_3);//��ʾ
		
		lblNewLabel_4 = new JLabel("\u6210\u7EE9*");
		lblNewLabel_4.setFont(new Font("����", Font.PLAIN, 30));
		lblNewLabel_4.setBounds(183, 368, 80, 32);
		contentPane.add(lblNewLabel_4);//�ɼ�
		
		btnNewButton_2 = new JButton("\u786E\u5B9A");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s0=textField.getText();//����
				String s1=textField_1.getText();//ѧ��
				String s2=textField_2.getText();//�ɼ�
				
				String order="select stu_name from student where user_id="+s1;//��ȡѧ�Ŷ�Ӧ����������
				String order1="select user_id from student where user_id="+s1;//�ж�ѧ���Ƿ���ڵ�����
				ResultSet result;//��ȡ���ݿ���������state
				ResultSet result1;//��ȡ���ݿ���ѧ�ŵ�state
				database_order dc = new database_order(order);//ִ�������ȡ���ݿ�������
				database_order dc1 = new database_order(order1);//ִ�������ȡ���ݿ��е�ѧ��
				result=dc.resultset;
				result1=dc1.resultset;
				try {
					if(result1.next()&&result1.getString(1).equals(s1)) {//������ѧ��
						if(result.next()) {//ѧ���ж�Ӧ����
							if(!s0.equals("")) {//����������
								if(s0.equals(result.getString(1))) {//������ѧ��ƥ��
									String order3="update mark set mark="+s2+" where user_id="+s1+" and exp_id='"+exp.get_exp_id()+"'";//�������ݿ������
									database_connect dc2 = new database_connect();
							        java.sql.Statement state;
									try {
										state = dc2.conn.createStatement();
										state.executeUpdate(order3);//ִ������������ݿ��еĳɼ�
										Error frame = new Error("�ɼ���ӳɹ�",1);
										frame.setVisible(true);//��ʾ����ɼ�
									} catch (SQLException e1) {
										// TODO �Զ����ɵ� catch ��
										e1.printStackTrace();
									}
								}
								else {
									Error frame = new Error("ѧ����������ƥ��",0);
									frame.setVisible(true);//�������ɼ�
								}
							}
							else {//û��������
								String order3="update mark set mark="+s2+" where user_id="+s1+" and exp_id='"+exp.get_exp_id()+"'";//�������ݿ������
								database_connect dc2 = new database_connect();
								java.sql.Statement state;
								try {
									state = dc2.conn.createStatement();
									state.executeUpdate(order3);//ִ������������ݿ��еĳɼ�
									Error frame = new Error("�ɼ���ӳɹ�",1);
									frame.setVisible(true);//��ʾ����ɼ�
								} catch (SQLException e1) {
									// TODO �Զ����ɵ� catch ��
									e1.printStackTrace();
								}
							}
						}
					}
					else {
						Error frame = new Error("��δ����ѧ�Ż�ѧ�Ų���ȷ",0);
						frame.setVisible(true);//�������ɼ�
					}
				} catch (SQLException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setFont(new Font("����", Font.PLAIN, 17));
		btnNewButton_2.setBounds(351, 466, 97, 23);
		contentPane.add(btnNewButton_2);//ȷ����ť
		
		textField = new JTextField();
		textField.setBounds(292, 196, 234, 32);
		contentPane.add(textField);
		textField.setColumns(10);//����
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(292, 289, 234, 32);
		contentPane.add(textField_1);//ѧ��
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(292, 374, 234, 32);
		contentPane.add(textField_2);//�ɼ�
		
		setVisible(true);
	}
}
