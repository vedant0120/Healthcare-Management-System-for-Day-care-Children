package version_without_rules;

import java.util.Vector;

public class Classroom {
	int capacity;
	Vector<Teacher> teachers = new Vector<Teacher>(3);
	Vector<Student> students = new Vector<Student>(30);
	
	public Classroom() {
		super();
		this.capacity = 33;
		// TODO Auto-generated constructor stub
	}
	
	public Classroom(int capacity, Vector<Teacher> teachers, Vector<Student> students) {
		super();
		this.capacity = capacity;
		this.teachers = teachers;
		this.students = students;
	}
	
	public int getCapacity() {
		return capacity;
	}

	public void setCredits(int credits) {
		for(Teacher t: teachers) {
			t.setCredits(credits);
		}
	}
	
	public void AddStudent(Student s) {
		students.add(s);
		this.capacity--;
	}
	
	public void AddTeacher(Teacher t) {
		teachers.add(t);
		this.capacity--;
	}
	
	public void Show(){
		System.out.println("\nTeachers: ");
		for(Teacher t: teachers) {
			System.out.println(t + ", ");
		}
		System.out.println("\nStudents: ");
		for(Student t: students) {
			System.out.println(t + ", ");
		}
	}
}
