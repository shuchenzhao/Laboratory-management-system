package Process;

import Object.User;
import Service.Sign_up;

public class Process {

	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		User user=new User();//�û�
		Sign_up frame = new Sign_up(user);//��¼����
		frame.setVisible(true);
		
		
		
	}

}
