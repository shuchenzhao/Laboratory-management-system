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
import Object.testJComboBox.RwJComboBox;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class Arrange_assistant extends JFrame {

	private JPanel contentPane;//���
	private JButton btnNewButton_1;//����ͼƬ��ť
	private JButton btnNewButton;//ȷ��
	private JLabel lblNewLabel;//����
	private JLabel lblNewLabel_1;//����
	private JLabel lblNewLabel_2;//�ɴ�ʵ��
	private JTextField textField;//����
	private JTextField textField_1;//����
	private JComboBox comboBox;//ʵ����������
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Arrange_assistant frame = new Arrange_assistant(new User());
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
	public Arrange_assistant(User user) {
		setTitle("����ʵ��Ա����");//��������
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
				LabAndAssistant_manage frame = new LabAndAssistant_manage(user);
				frame.setVisible(true);//ʵ����ʵ��Ա�������ɼ�
			}
		});
		contentPane.setLayout(null);
		btnNewButton_1.setIcon(new ImageIcon("image/ͨ��-�˳���¼ͼ��.png"));
		btnNewButton_1.setBorderPainted(false);
		contentPane.add(btnNewButton_1);//����ͼƬ��ť
		
		lblNewLabel = new JLabel("\u59D3\u540D");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 30));
		lblNewLabel.setBounds(157, 201, 72, 32);
		contentPane.add(lblNewLabel);//����
		
		lblNewLabel_1 = new JLabel("\u5DE5\u53F7");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(157, 266, 72, 32);
		contentPane.add(lblNewLabel_1);//����
		
		lblNewLabel_2 = new JLabel("\u53EF\u5E26\u5B9E\u9A8C");
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(157, 335, 122, 32);
		contentPane.add(lblNewLabel_2);//�ɴ�ʵ��
		
		Vector v4 = new Vector();//���ʵ������vector
		String order4="select exp_name from experiment";//��ȡʵ����������
		ResultSet result;//��ȡ���ݿ��е�ʵ������state
		database_order dc = new database_order(order4);//ִ�������ȡ���ݿ��е�ʵ����
		result=dc.resultset;
		try {
			while(result.next()) {//��ʵ���������Ӧvector
				v4.addElement(result.getString(1));
			}
		} catch (SQLException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		}
		String str[][] = new String[v4.size()][3];
		for(int i=0;i<v4.size();i++) {//��vector��ʵ��������string������
			str[i][0]=(String) v4.elementAt(i);
		}
		
		comboBox = new RwJComboBox(str);
		comboBox.setEditable(true);
		comboBox.setPreferredSize(new java.awt.Dimension(400, 60));
		comboBox.setBounds(306, 335, 213, 32);
		contentPane.add(comboBox);//ʵ����������
		
		textField = new JTextField();
		textField.setBounds(306, 201, 213, 32);
		contentPane.add(textField);
		textField.setColumns(10);//����
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(306, 266, 213, 32);
		contentPane.add(textField_1);//����
		
		btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tch_name=textField.getText().toString();
				String tch_id=textField_1.getText().toString();
				String exp_name=comboBox.getSelectedItem().toString();
				
				String order1="select * from teacher where user_id="+tch_id;//��ȡ��ʦ��Ӧ��
				ResultSet result1;//��ȡ���ݿ��н�ʦ��state
				database_order dc1 = new database_order(order1);//ִ�������ȡ���ݿ��н�ʦ��Ӧ��
				result1=dc1.resultset;
				
				try {
					if(result1.next()) {
						String tch_name1 = result1.getString("tch_name");
						if(tch_name1.equals(tch_name)) {//�����빤��ƥ��
							String order="update teacher set tch_type='"+exp_name+"' where user_id="+tch_id;//�������ݿ������
							database_connect dc = new database_connect();
							Statement state;
							try {
								state = dc.conn.createStatement();
								state.executeUpdate(order);//ִ������������ݿ�������
								Error frame = new Error("ʵ��Ա���ųɹ�",1);
								frame.setVisible(true);//�������ɼ�
							} catch (SQLException e1) {
								// TODO �Զ����ɵ� catch ��
								e1.printStackTrace();
							}
						}
						else {//�����빤�Ų�ƥ��
							Error frame = new Error("�����빤�Ų�ƥ��",0);
							frame.setVisible(true);//�������ɼ�
						}
						
					}
					else {//�����빤�Ų�ƥ��
						Error frame = new Error("�����빤�Ų�ƥ��",0);
						frame.setVisible(true);//�������ɼ�
					}
				} catch (SQLException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 17));
		btnNewButton.setBounds(334, 465, 97, 23);
		contentPane.add(btnNewButton);//ȷ��
		
		setVisible(true);
	}
}
