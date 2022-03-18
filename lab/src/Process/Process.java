package Process;

import Object.User;
import Service.Sign_up;

public class Process {

	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		User user=new User();//用户
		Sign_up frame = new Sign_up(user);//登录界面
		frame.setVisible(true);
		
		
		
	}

}
