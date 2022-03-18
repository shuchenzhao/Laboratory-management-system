package Object;

public class Experiment {
	private String exp_id;
	private String exp_name;
	private String course_id;
	private String course_name;

	public void insert_exp_id(String s) {
		exp_id=s;
	}
	
	public void insert_exp_name(String s) {
		exp_name=s;
	}
	
	public void insert_course_id(String s) {
		course_id=s;
	}
	
	public void insert_course_name(String s) {
		course_name=s;
	}
	
	public String get_course_id() {
		// TODO 自动生成的方法存根
		return course_id;
	}

	public String get_exp_id() {
		// TODO 自动生成的方法存根
		return exp_id;
	}
	public static void main(String[] args) {
		
	}
}
