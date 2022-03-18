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
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Object.User;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class Select_arrangedExp extends JFrame {

	private JPanel contentPane;//���
	private JButton btnNewButton_1;//����ͼƬ��ť
	private JTable table;//��ѯ���
	private JComboBox comboBox;//ʵ������
	private JButton btnNewButton;//ȷ��
	private JLabel lblNewLabel;//ʵ������


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Select_arrangedExp frame = new Select_arrangedExp(new User());
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
	public Select_arrangedExp(User user) {
		setTitle("��ѯ����");//��������
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
		lblNewLabel.setBounds(144, 162, 128, 35);
		contentPane.add(lblNewLabel);
		
		Vector v0 = new Vector();//���ʵ������vector
		String order0="select exp_name from experiment";//��ȡʵ����������
		ResultSet result0;//��ȡ���ݿ��е�ʵ������state
		database_order dc0 = new database_order(order0);//ִ�������ȡʵ����
		result0=dc0.resultset;
		try {
			while(result0.next()) {//��ʵ���������Ӧvector
				v0.addElement(result0.getString(1));
			}
		} catch (SQLException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		}
		comboBox = new JComboBox(v0);
		comboBox.setBounds(309, 162, 234, 35);
		contentPane.add(comboBox);
		
		
		
		
		btnNewButton = new JButton("ȷ��");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String exp_name=comboBox.getSelectedItem().toString();
				
				String order1="select exp_id from experiment where exp_name='"+exp_name+"'";//��ȡʵ���Ӧ��
				ResultSet result1;//��ȡ���ݿ���ʵ���Ӧ�е�state
				database_order dc1 = new database_order(order1);//ִ�������ȡ���ݿ���ʵ���Ӧ��
				result1=dc1.resultset;
				
				try {
					if(result1.next()) {//��ȡ��exp_id
						String exp_id=result1.getString(1);
						Vector v1 = new Vector();//��ŷ��ؽ����vector
						String columnNames[]= {"exp_id","class_id","week","weekday","time","lab_address","tch_id"};
						
						String order3="select * from exp_arrangement where exp_id='"+exp_id+"'";//��ȡʵ���Ӧ����
						ResultSet result3;//��ȡʵ���Ӧ���ݵ�state
						database_order dc3 = new database_order(order3);//ִ�������ȡʵ���Ӧ����
						result3=dc3.resultset;
						v1.addElement("exp_id");
						v1.addElement("class_id");
						v1.addElement("week");
						v1.addElement("weekday");
						v1.addElement("time");
						v1.addElement("lab_address");
						v1.addElement("tch_id");
						while(result3.next()) {//��ʵ���������Ӧvector
							v1.addElement(result3.getString(1));
							v1.addElement(result3.getString(2));
							v1.addElement(result3.getString(3));
							v1.addElement(result3.getString(4));
							v1.addElement(result3.getString(5));
							v1.addElement(result3.getString(6));
							v1.addElement(result3.getString(7));
						}
						if (v1.size()==7) {
							Error frame = new Error("ʵ����δ����",0);
							frame.setVisible(true);//�������ɼ�
						}
						else {
							//System.out.println(v1.size());
							Object[][] data =new Object[v1.size()/7][7];
							for(int i1=0;i1<v1.size()/7;i1++) {
								for (int j=0;j<7;j++) {
									data[i1][j]=v1.elementAt((i1)*7+j);
								}
							}
							table = new JTable(data, columnNames);
							table.setBounds(0, 280, 800, 230);
							//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  
							add(table);//��ѯ���
							validate();
						}
						
					}
					else {
						
					}					
						
				} catch (SQLException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 17));
		btnNewButton.setBounds(309, 226, 97, 23);
		contentPane.add(btnNewButton);//ȷ��
		
		setVisible(true);
	}
}
