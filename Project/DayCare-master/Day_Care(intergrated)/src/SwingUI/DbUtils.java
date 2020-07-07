package SwingUI;
import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.*;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mongodb.DBObject;


public class DbUtils {
    public static TableModel resultSetToTableModel(List<DBObject> list,String name) {
        try {

        	List<String> teacher = Arrays.asList("Teacher Name","Age","Credit","Teacher Comment","Class Number","Group Number");
        	List<String> student = Arrays.asList("StudentName","Age","Gpa","ParentName","Address","PhoneNumber","Vaccine", "ClassNum","GroupNum","TeaName","Hib" ,"Dtap" ,"Polio" ,"Hepatitis_B" , "MMR" , "Varicella" , "Tdap", "Meningococcal");
        	
            Vector columnNames = new Vector();
            if(name=="Teacher") {
            for (int i = 0; i < teacher.size(); i++) {
            	
            		columnNames.addElement(teacher.get(i));
		
			}
           }
            if(name=="Student") {
                for (int i = 0; i < student.size(); i++) {
                	columnNames.addElement(student.get(i));
    				
    			}
               }
       
            Vector rows = new Vector();

           
            if(name=="Teacher") {
                for (int i = 0; i < list.size(); i++) {
                	 Vector newRow = new Vector();
                	for (int j = 0; j < teacher.size(); j++) {
                		newRow.addElement( list.get(i).get(teacher.get(j).toString()));
    				}
                	rows.addElement(newRow);
                }
                
                	
    			
               }
                if(name=="Student") {
                    for (int i = 0; i < list.size(); i++) {
                    	 Vector newRow = new Vector();
                    	for (int j = 0; j < student.size(); j++) {
                    		newRow.addElement(list.get(i).get(student.get(j).toString()));
        				}
                    	rows.addElement(newRow);
        			}
                  }
            return new DefaultTableModel(rows, columnNames);
         
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }
}