package Service;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Object.Experiment;
import Object.User;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;

public class Grade_management extends JFrame {

	private JPanel contentPane;//���
	private JButton btnNewButton_1;//����ͼƬ��ť
	private JLabel lblNewLabel;//ʵ����
	private JLabel lblNewLabel_1;//�γ���
	private JLabel lblNewLabel_2;//��ӭ
	private final JComboBox comboBox;//ʵ����������
	private final JComboBox comboBox_1;//�γ���������
	private JButton btnNewButton;//ȷ����ť

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Grade_management frame = new Grade_management(new User());
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
	public Grade_management(User user) {
		setTitle("\u6210\u7EE9\u7BA1\u7406");//��������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//��漴�رճ���
		setBounds(300, 100, 760, 590);//���ý���Ĵ�С
		setResizable(false);//���ý��治�ɱ仯
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);//���
		
		lblNewLabel_2 = new JLabel("��ѡ��ʵ�����Ϳγ���");
		lblNewLabel_2.setFont(new Font("΢���ź�", Font.PLAIN, 35));
		lblNewLabel_2.setBounds(200, 90, 500, 53);
		contentPane.add(lblNewLabel_2);//��ӭ
		
		btnNewButton_1=new JButton();
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);//�ɼ���������ʵ����治�ɼ�
				activity_choose frame = new activity_choose(user);
				frame.setVisible(true);//�ɼ��������ɼ�
			}
		});
		contentPane.setLayout(null);
		btnNewButton_1.setIcon(new ImageIcon("image/ͨ��-�˳���¼ͼ��.png"));
		btnNewButton_1.setBounds(80, 80, 60, 60);
		btnNewButton_1.setBorderPainted(false);
		contentPane.add(btnNewButton_1);//����ͼƬ��ť
		
		lblNewLabel = new JLabel("\u5B9E\u9A8C\u540D");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 30));
		lblNewLabel.setBounds(158, 180, 112, 45);
		contentPane.add(lblNewLabel);//ʵ����
		
		lblNewLabel_1 = new JLabel("\u8BFE\u7A0B\u540D");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(158, 281, 112, 45);
		contentPane.add(lblNewLabel_1);//�γ���
		
		Vector v1 = new Vector();//���ʵ������vector
		Vector v2 = new Vector();//��ſγ�����vector
		
		String order="select exp_name from experiment";//��ȡʵ����������
		String order1="select course_name from course";//��ȡ�γ���������
		ResultSet result;//��ȡ���ݿ��е�ʵ������state
		ResultSet result1;//��ȡ���ݿ��еĿγ�����state
		database_order dc = new database_order(order);//ִ�������ȡ���ݿ��е�ʵ����
		database_order dc1 = new database_order(order1);//ִ�������ȡ���ݿ��е�ʵ����
		result=dc.resultset;
		result1=dc1.resultset;
		try {
			while(result.next()) {//��ʵ���������Ӧvector
				v1.addElement(result.getString(1));
			}
		} catch (SQLException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		}
		try {
			while(result1.next()) {//���γ��������Ӧvector
				v2.addElement(result1.getString(1));
			}
		} catch (SQLException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		}
		
		comboBox = new JComboBox(v1);
		comboBox.setBounds(319, 191, 177, 33);
		contentPane.add(comboBox);//ʵ����������
		
		comboBox_1 = new JComboBox(v2);
		comboBox_1.setBounds(319, 292, 177, 33);
		
		contentPane.add(comboBox_1);//�γ���������
		
		btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String exp_name=comboBox.getSelectedItem().toString();
				String course_name=comboBox_1.getSelectedItem().toString();
				
				String order="select * from experiment where exp_name='"+exp_name+"'";//��ȡʵ���Ӧʵ���
				String order1="select * from course where course_name='"+course_name+"'";//��ȡʵ���Ӧ�γ���
				ResultSet result;//��ȡ���ݿ���ʵ���state
				ResultSet result1;//��ȡ���ݿ���������state
				database_order dc = new database_order(order);//ִ�������ȡ���ݿ��������
				database_order dc1 = new database_order(order1);//ִ�������ȡ���ݿ��пγ̺�
				result=dc.resultset;
				result1=dc1.resultset;
				
				try {
					if(result.next()&&result1.next()) {
						String exp_id = result.getString(1);
						String course_id = result1.getString(1);
						Experiment exp=new Experiment();
						exp.insert_exp_id(exp_id);
						exp.insert_exp_name(exp_name);
						exp.insert_course_id(course_id);
						exp.insert_course_name(course_name);
						//System.out.println("exp_name="+exp_name+",exp_id="+exp_id+",course_name"+course_name+",course_id="+course_id);
						if(exp_name.equals(course_name+"ʵ��")) {
							setVisible(false);//�γ�����ʵ����ѡ����治�ɼ�
							Grade_choose_student frame = new Grade_choose_student(user,exp);
							frame.setVisible(true);//�ɼ��������ɼ�
						}
						else {
							Error frame = new Error("�γ�����ʵ��������Ӧ",0);
							frame.setVisible(true);//�������ɼ�
						}	
					}
				} catch (SQLException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 17));
		btnNewButton.setBounds(347, 429, 97, 23);
		contentPane.add(btnNewButton);//ȷ����ť
		
		setVisible(true);
	}
}
