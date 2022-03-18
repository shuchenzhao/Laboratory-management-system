package Service;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;

import Object.User;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.util.Vector;

public class Select extends JFrame {

	private JPanel contentPane;//���
	private JButton btnNewButton;//ȷ��
	private JButton btnNewButton_1;//����ͼƬ��ť
	private JTextField textField;//�����ı�
	private JLabel lblNewLabel_1;//��ѯ����
	private JLabel lblNewLabel_2;//��ѯ����
	private JComboBox comboBox;//����������
	private JTable table;//���ر�
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Select frame = new Select(new User());
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
	public Select(User user) {
		setTitle("��ѯ");//��������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//��漴�رճ���
		setBounds(300, 100, 760, 590);//���ý���Ĵ�С
		setResizable(false);//���ý��治�ɱ仯
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);//���
		
		btnNewButton_1=new JButton();
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);//�༶��ѧ��������治�ɼ�
				ClassAndStudent_manage frame = new ClassAndStudent_manage(user);
				frame.setVisible(true);//������ѡ�����ɼ�
			}
		});
		contentPane.setLayout(null);
		btnNewButton_1.setIcon(new ImageIcon("image/ͨ��-�˳���¼ͼ��.png"));
		btnNewButton_1.setBounds(80, 80, 60, 60);
		btnNewButton_1.setBorderPainted(false);
		contentPane.add(btnNewButton_1);//�û�����ͼƬ��ť
		
		lblNewLabel_1 = new JLabel("��ѯ����");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(129, 197, 122, 35);
		contentPane.add(lblNewLabel_1);//��ѯ����
		
		lblNewLabel_2 = new JLabel("��ѯ����");
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(129, 283, 122, 35);
		contentPane.add(lblNewLabel_2);//��ѯ����
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(297, 197, 233, 35);
		contentPane.add(textField);//��ѯ����
		
		Vector v2 = new Vector();//������͵�vector
		v2.addElement("ѧ��");
		v2.addElement("�༶");
		comboBox = new JComboBox(v2);
		comboBox.setBounds(297, 283, 232, 35);
		contentPane.add(comboBox);//��ѯ����
		
		btnNewButton = new JButton("ȷ��");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type=comboBox.getSelectedItem().toString();
				
				if(type.equals("ѧ��")) {
					String user_id=textField.getText();
					String columnNames[]= {"user_id","stu_name","stu_sex","stu_class"};
					
					String order3="select * from student where user_id="+user_id;//��ȡʵ���Ӧ����
					ResultSet result3;//��ȡʵ���Ӧ���ݵ�state
					database_order dc3 = new database_order(order3);//ִ�������ȡʵ���Ӧ����
					result3=dc3.resultset;
					Vector v1=new Vector();
					v1.addElement("user_id");
					v1.addElement("stu_name");
					v1.addElement("stu_sex");
					v1.addElement("stu_class");
					
					try {
						while(result3.next()) {//����Ϣ�����Ӧvector
							v1.addElement(result3.getString(1));
							v1.addElement(result3.getString(2));
							v1.addElement(result3.getString(3));
							v1.addElement(result3.getString(4));
						}
						if (v1.size()==4) {
							Error frame = new Error("����ѯ�������ݿ��в�����",0);
							frame.setVisible(true);//�������ɼ�
						}
						else {
							//System.out.println(v1.size());
							Object[][] data =new Object[v1.size()/4][4];
							for(int i1=0;i1<v1.size()/4;i1++) {
								for (int j=0;j<4;j++) {
									data[i1][j]=v1.elementAt((i1)*4+j);
								}
							}
							table = new JTable(data, columnNames);
							table.setBounds(240, 400, 300, 120);
							//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  
							contentPane.add(table);//��ѯ���
							validate();
							repaint();
						}
						
						
					} catch (SQLException e1) {
						// TODO �Զ����ɵ� catch ��
						e1.printStackTrace();
					}
				}
				else {
					String class_id=textField.getText();
					String columnNames[]= {"class_id","number"};
					
					String order3="select * from class where class_id="+class_id;//��ȡʵ���Ӧ����
					ResultSet result3;//��ȡʵ���Ӧ���ݵ�state
					database_order dc3 = new database_order(order3);//ִ�������ȡʵ���Ӧ����
					result3=dc3.resultset;
					Vector v1=new Vector();
					v1.addElement("class_id");
					v1.addElement("number");
					
					try {
						while(result3.next()) {//����Ϣ�����Ӧvector
							v1.addElement(result3.getString(1));
							v1.addElement(result3.getString(2));
						}
						if (v1.size()==2) {
							Error frame = new Error("����ѯ�������ݿ��в�����",0);
							frame.setVisible(true);//�������ɼ�
						}
						else {
							//System.out.println(v1.size());
							Object[][] data =new Object[v1.size()/2][2];
							for(int i1=0;i1<v1.size()/2;i1++) {
								for (int j=0;j<2;j++) {
									data[i1][j]=v1.elementAt((i1)*2+j);
								}
							}
							table = new JTable(data, columnNames);
							table.setBounds(240, 400, 300, 120);
							//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  
							contentPane.add(table);//��ѯ���
							validate();
							repaint();
						}
					} catch (SQLException e1) {
						// TODO �Զ����ɵ� catch ��
						e1.printStackTrace();
					}
					
				}
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 17));
		btnNewButton.setBounds(321, 361, 97, 23);
		contentPane.add(btnNewButton);//ȷ��
		
		setVisible(true);
	}

}
