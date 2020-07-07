package version_without_rules;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPersonFactory {

	    public abstract Person createPerson(String csvline);

	    public List<Person> createPersonFromCsv(String csvFile) {
	        List<Person> persons = new ArrayList<>();
	        try {
	            BufferedReader br = new BufferedReader(new FileReader(csvFile));
	            String line = br.readLine();
	            while (line!=null) {
	                Person person = this.createPerson(line);
	                if(person!=null) {
	                    persons.add(person);
	                }
	                line = br.readLine();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return persons;
	    }

}
