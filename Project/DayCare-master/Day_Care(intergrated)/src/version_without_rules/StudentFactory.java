package version_without_rules;

public class StudentFactory extends AbstractPersonFactory {
    @Override
    public Student createPerson(String csvline) {
        String[] parts = csvline.split(",");

        Student student = new Student();
        student.setName(parts[0]);
        try {
			student.setAge(Integer.parseInt(parts[1]));
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        try {
			student.setGpa(Double.parseDouble(parts[2]));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        student.setParentName(parts[3]);
        student.setAddress(parts[4]);
        student.setPhoneNumber(parts[5]);

        return student;
    }
}
