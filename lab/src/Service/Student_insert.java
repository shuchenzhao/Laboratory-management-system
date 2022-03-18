package Service;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Object.User;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class Student_insert extends JFrame {

	private JPanel contentPane;//���
	private JButton btnNewButton_1;//����ͼƬ��ť
	private JLabel lblNewLabel;//ѧ��
	private JLabel lblNewLabel_1;//ѧ������
	private JLabel lblNewLabel_2;//ѧ���Ա�
	private JLabel lblNewLabel_3;//�����༶
	private JTextField textField;//ѧ���ı�
	private JTextField textField_1;//ѧ�������ı�
	private JComboBox comboBox_2;//ѧ���Ա��ı�
	private JComboBox comboBox;//�����༶������
	private JButton btnNewButton;//ȷ��

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_insert frame = new Student_insert(new User());
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
	public Student_insert(User user) {
		setTitle("ѧ��¼��");//��������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//��漴�رճ���
		setBounds(300, 100, 760, 590);//���ý���Ĵ�С
		setResizable(false);//���ý��治�ɱ仯
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);//���
		
		btnNewButton_1=new JButton();
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);//ѧ��¼����治�ɼ�
				Insert frame = new Insert(user);
				frame.setVisible(true);//¼�����ɼ�
			}
		});
		contentPane.setLayout(null);
		btnNewButton_1.setIcon(new ImageIcon("image/ͨ��-�˳���¼ͼ��.png"));
		btnNewButton_1.setBounds(80, 80, 60, 60);
		btnNewButton_1.setBorderPainted(false);
		contentPane.add(btnNewButton_1);//�û�����ͼƬ��ť
		
		lblNewLabel = new JLabel("ѧ��");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 30));
		lblNewLabel.setBounds(154, 174, 113, 35);
		contentPane.add(lblNewLabel);//ѧ��
		
		lblNewLabel_1 = new JLabel("ѧ������");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(154, 234, 122, 35);
		contentPane.add(lblNewLabel_1);//ѧ������
		
		lblNewLabel_2 = new JLabel("ѧ���Ա�");
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(154, 294, 122, 35);
		contentPane.add(lblNewLabel_2);//ѧ���Ա�
		
		lblNewLabel_3 = new JLabel("�����༶");
		lblNewLabel_3.setFont(new Font("����", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(154, 352, 122, 35);
		contentPane.add(lblNewLabel_3);//�����༶
		
		textField = new JTextField();
		textField.setBounds(300, 174, 233, 35);
		contentPane.add(textField);
		textField.setColumns(10);//ѧ���ı�
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(300, 234, 233, 35);
		contentPane.add(textField_1);//ѧ�������ı�
		
		Vector v2 = new Vector();//����Ա��vector
		v2.addElement("��");
		v2.addElement("Ů");
		comboBox_2 = new JComboBox(v2);
		comboBox_2.setBounds(300, 294, 233, 35);
		contentPane.add(comboBox_2);//ѧ���Ա��ı�
		
		Vector v6 = new Vector();//��Ű༶�ŵ�vector
		String order6="select class_id from class";//��ȡ�༶�ŵ�����
		ResultSet result6;//��ȡ���ݿ��еİ༶�ŵ�state
		database_order dc6 = new database_order(order6);//ִ�������ȡ�༶��
		result6=dc6.resultset;
		try {
			while(result6.next()) {//�����Һ������Ӧvector
				v6.addElement(result6.getString(1));
			}
		} catch (SQLException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		}
		comboBox = new JComboBox(v6);
		comboBox.setBounds(301, 352, 232, 35);
		contentPane.add(comboBox);//�����༶������
		
		btnNewButton = new JButton("ȷ��");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String stu_sex=comboBox_2.getSelectedItem().toString();
				String stu_class=comboBox.getSelectedItem().toString();
				String user_id=textField.getText();
				String stu_name=textField_1.getText();
				
				String order="insert into student values("+user_id+",'"+stu_name+"','"+stu_sex+"','"+stu_class+"')";//�������ݿ������
				database_connect dc = new database_connect();
				Statement state;
				try {
					state = dc.conn.createStatement();
					state.executeUpdate(order);
					Error frame = new Error("ѧ��¼��ɹ�",1);
					frame.setVisible(true);//�������ɼ�
				} catch (SQLException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}//ִ������������ݿ�������
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 17));
		btnNewButton.setBounds(322, 452, 97, 23);
		contentPane.add(btnNewButton);//ȷ��
		
		setVisible(true);
	}

}
