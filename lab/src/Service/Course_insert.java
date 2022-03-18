package Service;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Object.User;
import Object.testJComboBox.RwJComboBox;
import java.awt.Dimension;

public class Course_insert extends JFrame {

	private JPanel contentPane;//���
	private JButton btnNewButton_1;//����ͼƬ��ť
	private JLabel lblNewLabel;//�γ�ID
	private JLabel lblNewLabel_1;//�γ�����
	private JLabel lblNewLabel_2;//����ѧԺ
	private JLabel lblNewLabel_3;//����ѧ��
	private JLabel lblNewLabel_4;//��Ӧʵ��
	private JTextField textField;//�γ�ID�ı���
	private JTextField textField_1;//�γ������ı���
	private JButton btnNewButton;//ȷ��
	private JComboBox comboBox;//ѧ��������
	private JComboBox comboBox_1;//ѧԺ������
	private JComboBox comboBox_2;//ʵ��������
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Course_insert frame = new Course_insert(new User());
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
	public Course_insert(User user) {
		setTitle("�γ���Ϣ¼��");//��������
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
				setVisible(false);//�γ���Ϣ¼����治�ɼ�
				Message_insert frame = new Message_insert(user);
				frame.setVisible(true);//��Ϣ¼�����ɼ�
			}
		});
		contentPane.setLayout(null);
		btnNewButton_1.setIcon(new ImageIcon("image/ͨ��-�˳���¼ͼ��.png"));
		btnNewButton_1.setBorderPainted(false);
		contentPane.add(btnNewButton_1);//����ͼƬ��ť
		
		lblNewLabel = new JLabel("�γ�ID");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 30));
		lblNewLabel.setBounds(148, 144, 122, 32);
		contentPane.add(lblNewLabel);//�γ�ID
		
		lblNewLabel_1 = new JLabel("�γ�����");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(148, 208, 122, 32);
		contentPane.add(lblNewLabel_1);//�γ�����
		
		lblNewLabel_2 = new JLabel("����ѧԺ");
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(148, 276, 122, 32);
		contentPane.add(lblNewLabel_2);//����ѧԺ
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(327, 144, 213, 32);
		contentPane.add(textField);//�γ�ID�ı���
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(327, 208, 213, 32);
		contentPane.add(textField_1);
		
		btnNewButton = new JButton("ȷ��");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String course_id=textField.getText().toString();
				String course_name=textField_1.getText().toString();
				String course_time=comboBox.getSelectedItem().toString();
				String teaching_college=comboBox_1.getSelectedItem().toString();
				String exp_name=comboBox_2.getSelectedItem().toString();
				String exp_id;
				
				String order2="select * from experiment where exp_name='"+exp_name+"'";//��ȡʵ���Ӧ��
				ResultSet result1;//��ȡ���ݿ���ʵ���state
				database_order dc1 = new database_order(order2);//ִ�������ȡ���ݿ���ʵ���Ӧ��
				result1=dc1.resultset;
				try {
					if(result1.next()) {
						exp_id=result1.getString("exp_id");
						String order="insert into course values('"+course_id+"','"+course_name+"','"+course_time+"','"+exp_id+"','"+teaching_college+"')";//�������ݿ������
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
				} catch (SQLException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 17));
		btnNewButton.setBounds(301, 471, 97, 23);
		contentPane.add(btnNewButton);//ȷ��
		
		lblNewLabel_3 = new JLabel("����ѧ��");
		lblNewLabel_3.setFont(new Font("����", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(148, 336, 122, 32);
		contentPane.add(lblNewLabel_3);//����ѧ��
		
		Vector v= new Vector();
		v.addElement("��һѧ��");
		v.addElement("�ڶ�ѧ��");
		v.addElement("����ѧ��");
		v.addElement("����ѧ��");
		v.addElement("����ѧ��");
		v.addElement("����ѧ��");
		v.addElement("����ѧ��");
		v.addElement("�ڰ�ѧ��");
		comboBox = new JComboBox(v);
		comboBox.setEditable(true);
		comboBox.setPreferredSize(new java.awt.Dimension(400, 60));
		comboBox.setBounds(327, 335, 213, 32);
		contentPane.add(comboBox);//ѧ��������
		
		lblNewLabel_4 = new JLabel("��Ӧʵ��");
		lblNewLabel_4.setFont(new Font("����", Font.PLAIN, 30));
		lblNewLabel_4.setBounds(148, 395, 122, 32);
		contentPane.add(lblNewLabel_4);//��Ӧʵ��
		
		Vector v1= new Vector();
		String order="select exp_name from experiment";//��ȡʵ����������
		ResultSet result;//��ȡ���ݿ��е�ʵ������state
		database_order dc = new database_order(order);//ִ�������ȡ���ݿ��е�ʵ����
		result=dc.resultset;
		try {
			while(result.next()) {//��ʵ���������Ӧvector
				v1.addElement(result.getString(1));
			}
		} catch (SQLException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		}
		comboBox_2 = new JComboBox(v1);
		comboBox_2.setEditable(true);
		comboBox_2.setPreferredSize(new java.awt.Dimension(400, 60));
		comboBox_2.setBounds(327, 395, 213, 32);
		contentPane.add(comboBox_2);//ʵ��������
		
		Vector v2= new Vector();
		v2.addElement("�������ѧ�뼼��ѧԺ");
		v2.addElement("���ӹ���ѧԺ");
		v2.addElement("ͨ�Ź���ѧԺ");
		v2.addElement("���繤��ѧԺ");
		v2.addElement("�������繤��ѧԺ");
		comboBox_1 = new JComboBox(v2);
		comboBox_1.setPreferredSize(new Dimension(400, 60));
		comboBox_1.setEditable(true);
		comboBox_1.setBounds(327, 276, 213, 32);
		contentPane.add(comboBox_1);//ѧԺ������
		
		setVisible(true);
	}

}
