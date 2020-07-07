package version_without_rules;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class TeacherFactory extends AbstractPersonFactory {

	
	//csvstring format "name,age,credit"
	@Override
	public Teacher createPerson(String csvline) {
		// TODO Auto-generated method stub
		String[] temp = csvline.split(",");
		Teacher teacher = new Teacher();
		teacher.setName(temp[0]);
		try {
			teacher.setAge(Integer.parseInt(temp[1]));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			teacher.setCredits(Integer.parseInt(temp[2]));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teacher;
	}

}
