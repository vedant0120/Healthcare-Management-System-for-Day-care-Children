package version_without_rules;

import java.util.Vector;

public class ClassroomFactory {
	private static ClassroomFactory instance;
	
	private ClassroomFactory() {
		instance = null;
	}
	
	public static synchronized ClassroomFactory getInstance() {
		if (null == instance) {
			instance = new ClassroomFactory();
		}
		return instance;
	}
	
	public Classroom getObject() {
		// TODO Auto-generated method stub
		return new Classroom();
	}

	public Classroom getObject(int capacity, Vector<Teacher> teachers, Vector<Student> students) {
		// TODO Auto-generated method stub
		return new Classroom(capacity, teachers, students);
	}
}
