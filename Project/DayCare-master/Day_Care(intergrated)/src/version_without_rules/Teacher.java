package version_without_rules;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {
	private int credits;
	private String Comment;

	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
	}

	public List<Student> StudentLsits = new ArrayList<Student>();
	
	public Teacher(){
		super();
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public Teacher(int age, String name) {
		super(age, name);
	}

	public Teacher(int age, String name, int credits) {
		super(age, name);
		this.credits = credits;
	}
	
	//add toString
	@Override
	public String toString() {
		return "Teacher [Name: "+ getName() + ", Age: " + getAge() + ", credits: " + credits + ", StudentLsits=" + StudentLsits + "]";
	}
}
