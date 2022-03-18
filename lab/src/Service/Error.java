package Service;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Error extends JFrame {

	private JPanel contentPane;//���
	private JLabel lblNewLabel;//����
	private JLabel lblNewLabel_1;//ͼ��
	private JButton btnNewButton;//ȷ����ť

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Error frame = new Error("�û������������",0);
					//frame.setVisible(true);
					Error frame1 = new Error("������ʾ",1);
					frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Error(String err,int sign) {
		setTitle("\u63D0\u793A");//��������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//��漴�رճ���
		setBounds(400, 300, 600, 300);//���ý���Ĵ�С
		setResizable(false);//���ý��治�ɱ仯
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);//���
		
		lblNewLabel = new JLabel(err);
		lblNewLabel.setBounds(188, 81, 366, 47);
		lblNewLabel.setFont(new Font("΢���ź�", Font.PLAIN, 30));
		contentPane.add(lblNewLabel);//����
		
		if(sign==0) {//ʧ����ʾ
		lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setIcon(new ImageIcon("image/ͨ��-�����ر�ͼ��.png"));
		lblNewLabel_1.setBounds(130, 75, 60, 60);
		contentPane.add(lblNewLabel_1);//����ͼ��
		}
		if(sign==1) {//����ֻ����ʾ
			lblNewLabel_1 = new JLabel();
			lblNewLabel_1.setIcon(new ImageIcon("image/ͨ��-����ͼ��.png"));
			lblNewLabel_1.setBounds(130, 75, 60, 60);
			contentPane.add(lblNewLabel_1);//����ͼ��
		}
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.setBounds(240, 173, 97, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//���ȷ����ť֮��ҳ�治�ɼ�
				
				setVisible(false);//ҳ�治�ɼ�
				
			}
		});
		contentPane.add(btnNewButton);
		
		setVisible(true);
	}

}
