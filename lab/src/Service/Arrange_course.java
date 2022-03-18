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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Object.testJComboBox.RwJComboBox;
import Object.User;
import javax.swing.JLabel;
import java.awt.Font;

public class Arrange_course extends JFrame {

	private JPanel contentPane;//���
	private JButton btnNewButton;//ȷ��
	private JButton btnNewButton_1;//����ͼƬ��ť
	private JLabel lblNewLabel;//ʵ����
	private JLabel lblNewLabel_1;//ʵ��༶
	private JLabel lblNewLabel_2;//ʵ���ܴ�
	private JLabel lblNewLabel_3;//ʵ��ʱ��
	private JLabel lblNewLabel_4;//ʵ�����
	private JLabel lblNewLabel_5;//ʵ��Ա
	private JLabel lblNewLabel_6;//ʵ������
	private final JComboBox comboBox_1;//�ܴ�������
	private final JComboBox comboBox_2;//���ڼ�������
	private final JComboBox comboBox_3;//ʱ��������
	private final JComboBox comboBox_4;//ʵ������������
	private final JComboBox comboBox_5;//���Һ�������
	private final JComboBox comboBox_6;//ʵ��༶������
	private final JComboBox comboBox_7;//ʵ��Ա������

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Arrange_course frame = new Arrange_course(new User());
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
	public Arrange_course(User user) {
		setTitle("һ���ſ�");//��������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//��漴�رճ���
		setBounds(300, 100, 760, 590);//���ý���Ĵ�С
		setResizable(false);//���ý��治�ɱ仯
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);//���
		
		btnNewButton_1=new JButton();
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);//һ���ſν��治�ɼ�
				CourseAndExperiment_manage frame = new CourseAndExperiment_manage(user);
				frame.setVisible(true);//�γ���ʵ��������ɼ�
			}
		});
		contentPane.setLayout(null);
		btnNewButton_1.setIcon(new ImageIcon("image/ͨ��-�˳���¼ͼ��.png"));
		btnNewButton_1.setBounds(80, 80, 60, 60);
		btnNewButton_1.setBorderPainted(false);
		contentPane.add(btnNewButton_1);//����ͼƬ��ť
		
		lblNewLabel = new JLabel("ʵ������");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 30));
		lblNewLabel.setBounds(148, 124, 122, 34);
		contentPane.add(lblNewLabel);//ʵ����
		
		lblNewLabel_1 = new JLabel("ʵ��༶");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(148, 182, 122, 34);
		contentPane.add(lblNewLabel_1);//ʵ��༶
		
		lblNewLabel_2 = new JLabel("ʵ���ܴ�");
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(148, 241, 122, 34);
		contentPane.add(lblNewLabel_2);//ʵ���ܴ�
		
		lblNewLabel_3 = new JLabel("ʵ��ʱ��");
		lblNewLabel_3.setFont(new Font("����", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(417, 241, 122, 34);
		contentPane.add(lblNewLabel_3);//ʵ��ʱ��
		
		lblNewLabel_4 = new JLabel("ʵ�����");
		lblNewLabel_4.setFont(new Font("����", Font.PLAIN, 30));
		lblNewLabel_4.setBounds(148, 359, 122, 34);
		contentPane.add(lblNewLabel_4);//ʵ�����
		
		lblNewLabel_5 = new JLabel("ʵ��Ա");
		lblNewLabel_5.setFont(new Font("����", Font.PLAIN, 30));
		lblNewLabel_5.setBounds(148, 423, 122, 34);
		contentPane.add(lblNewLabel_5);//ʵ��Ա
		
		lblNewLabel_6 = new JLabel("ʵ������");
		lblNewLabel_6.setFont(new Font("����", Font.PLAIN, 30));
		lblNewLabel_6.setBounds(148, 296, 122, 34);
		contentPane.add(lblNewLabel_6);//ʵ������
		
		String str[][] = new String[10][3];
		str[0][0]="1";
		str[1][0]="2";
		str[2][0]="3";
		str[3][0]="4";
		str[4][0]="5";
		str[5][0]="6";
		str[6][0]="7";
		str[7][0]="8";
		str[8][0]="9";
		str[9][0]="10";
		comboBox_1 = new RwJComboBox(str);
		comboBox_1.setEditable(true);
		comboBox_1.setPreferredSize(new java.awt.Dimension(400, 60));
		comboBox_1.setBounds(299, 241, 89, 33);
		contentPane.add(comboBox_1);//��ֹ�ܴ�������

		String str1[][] = new String[7][3];
		str1[0][0]="1";
		str1[1][0]="2";
		str1[2][0]="3";
		str1[3][0]="4";
		str1[4][0]="5";
		str1[5][0]="6";
		str1[6][0]="7";
		comboBox_2 = new RwJComboBox(str1);
		comboBox_2.setEditable(true);
		comboBox_2.setPreferredSize(new java.awt.Dimension(400, 60));
		comboBox_2.setBounds(299, 296, 220, 33);
		contentPane.add(comboBox_2);//����������
		
		String str2[][] = new String[3][3];
		str2[0][0]="����";
		str2[1][0]="����";
		str2[2][0]="����";
		comboBox_3 = new RwJComboBox(str2);
		comboBox_3.setEditable(true);
		comboBox_3.setPreferredSize(new java.awt.Dimension(400, 60));
		comboBox_3.setBounds(565, 241, 89, 33);
		contentPane.add(comboBox_3);//ʱ��������
		
		Vector v4 = new Vector();//���ʵ������vector
		Vector v5 = new Vector();//��Ž��Һŵ�vector
		Vector v6 = new Vector();//��Ű༶�ŵ�vector
		Vector v7 = new Vector();//��Ž�ʦ����vector
		String order4="select exp_name from experiment";//��ȡʵ����������
		String order5="select lab_address from laboratory";//��ȡ���Һŵ�����
		String order6="select class_id from class";//��ȡ�༶�ŵ�����
		String order7="select tch_name from teacher";//��ȡ��ʦ��������
		ResultSet result4;//��ȡ���ݿ��е�ʵ������state
		ResultSet result5;//��ȡ���ݿ��еĽ��Һŵ�state
		ResultSet result6;//��ȡ���ݿ��еİ༶�ŵ�state
		ResultSet result7;//��ȡ���ݿ��еĽ�ʦ����state
		database_order dc4 = new database_order(order4);//ִ�������ȡʵ����
		database_order dc5 = new database_order(order5);//ִ�������ȡ���Һ�
		database_order dc6 = new database_order(order6);//ִ�������ȡ�༶��
		database_order dc7 = new database_order(order7);//ִ�������ȡ��ʦ��
		result4=dc4.resultset;
		result5=dc5.resultset;
		result6=dc6.resultset;
		result7=dc7.resultset;
		try {
			while(result4.next()) {//��ʵ���������Ӧvector
				v4.addElement(result4.getString(1));
			}
		} catch (SQLException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		}
		try {
			while(result5.next()) {//�����Һ������Ӧvector
				v5.addElement(result5.getString(1));
			}
		} catch (SQLException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		}
		String str4[][] = new String[v5.size()][3];
		for(int i=0;i<v5.size();i++) {
			str4[i][0]=(String) v5.elementAt(i);
		}
		comboBox_4 = new JComboBox(v4);
		comboBox_4.setPreferredSize(new java.awt.Dimension(400, 60));
		comboBox_4.setBounds(299, 124, 220, 33);
		contentPane.add(comboBox_4);//ʵ������������
		
		comboBox_5 = new RwJComboBox(str4);
		comboBox_5.setEditable(true);
		comboBox_5.setBounds(299, 359, 220, 33);
		contentPane.add(comboBox_5);//���Һ�������
		
		try {
			while(result6.next()) {//�����Һ������Ӧvector
				v6.addElement(result6.getString(1));
			}
		} catch (SQLException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		}
		comboBox_6 = new JComboBox(v6);
		comboBox_6.setBounds(301, 182, 218, 34);
		comboBox_6.setEditable(true);
		contentPane.add(comboBox_6);//ʵ��༶
		
		try {
			while(result7.next()) {//�����Һ������Ӧvector
				v7.addElement(result7.getString(1));
			}
		} catch (SQLException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		}
		comboBox_7 = new JComboBox(v7);
		comboBox_7.setEditable(true);
		comboBox_7.setBounds(299, 423, 220, 33);
		contentPane.add(comboBox_7);//ʵ��Ա
		
		btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String week=comboBox_1.getSelectedItem().toString();
				String weekday=comboBox_2.getSelectedItem().toString();
				String time=comboBox_3.getSelectedItem().toString();
				String exp_name=comboBox_4.getSelectedItem().toString();
				String lab_address=comboBox_5.getSelectedItem().toString();
				String class_id=comboBox_6.getSelectedItem().toString();
				String tch_name=comboBox_7.getSelectedItem().toString();
				
				String order1="select user_id from teacher where tch_name='"+tch_name+"'";//��ȡ��ʦ��Ӧ��
				ResultSet result1;//��ȡ���ݿ��н�ʦ��state
				database_order dc1 = new database_order(order1);//ִ�������ȡ���ݿ��н�ʦ��Ӧ��
				result1=dc1.resultset;
				String tch_id;
				
				String order3="select exp_id from experiment where exp_name='"+exp_name+"'";//��ȡ���Ҷ�Ӧ��
				ResultSet result3;//��ȡ���ݿ��н��ҵ�state
				database_order dc3 = new database_order(order3);//ִ�������ȡ���ݿ��н��Ҷ�Ӧ��
				result3=dc3.resultset;
				String exp_id;
				
				try {

					if(result3.next()) {//��ȡ��exp_id
						exp_id=result3.getString(1);
						if(result1.next()) {//��ȡ��tch_id
							tch_id=result1.getString(1);
							String order="insert into exp_arrangement values('"+exp_id+"','"+class_id+"','"+week+"','"+weekday+"','"+time+"','"+lab_address+"','"+tch_id+"')";//�������ݿ������
							database_connect dc = new database_connect();
							Statement state;
							state = dc.conn.createStatement();
							state.executeUpdate(order);//ִ������������ݿ�������
							Error frame = new Error("ʵ�鰲�ųɹ�",1);
							frame.setVisible(true);//�������ɼ�
						}
						else {
							Error frame = new Error("��ʦ�����������ݿ���",0);
							frame.setVisible(true);//�������ɼ�
						}
					}
					else {
						Error frame = new Error("ʵ�鲻���������ݿ���",0);
						frame.setVisible(true);//�������ɼ�
					}					
						
				} catch (SQLException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 17));
		btnNewButton.setBounds(334, 470, 97, 23);
		contentPane.add(btnNewButton);//ȷ��
		
		setVisible(true);
	}
}
