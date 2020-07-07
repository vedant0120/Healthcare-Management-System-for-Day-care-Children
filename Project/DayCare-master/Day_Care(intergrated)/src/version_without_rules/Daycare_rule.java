package version_without_rules;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;


public class Daycare_rule {
	
	private int ClassNum;        // suppose there are six classes, which is from 1 to 6 
	private int ClassNumTeacher;	// teacher class number
	private String TeacherName; // The teacher name for each student
	private int GroupStuNum ;		// the group number of each student
	private int GroupTeaNum ;		// the group number of each teacher
	
	private int TeacherNum = 0;  // the total number of teacher
	private int StudentNum = 0;  // the total number of student
	private int GroupSize = 0;	 // the ratio rate of student and teacher
	private int GroupNumMax = 0; // the max number of group in a class
	
	private int GroupNum1 = 0;        // the group number in class1
	private int GroupNum2 = 0;        // the group number in class2
	private int GroupNum3 = 0;        // the group number in class3
	private int GroupNum4 = 0;        // the group number in class4
	private int GroupNum5 = 0;        // the group number in class5
	private int GroupNum6 = 0;        // the group number in class6
	
	private int temNum1 = 1;
	private int temNum2 = 1;
	private int temNum3 = 1;
	private int temNum4 = 1;
	private int temNum5 = 1;
	private int temNum6 = 1;
	
	//student number in different class
	private int StudentNum1 = 0;
	private int StudentNum2 = 0;
	private int StudentNum3 = 0;
	private int StudentNum4 = 0;
	private int StudentNum5 = 0;
	private int StudentNum6 = 0;
	
	//teacher number in different class
	private int TeacherNum1 = 0;
	private int TeacherNum2 = 0;
	private int TeacherNum3 = 0;
	private int TeacherNum4 = 0;
	private int TeacherNum5 = 0;
	private int TeacherNum6 = 0;
	
	
	private static List TeacherList = new ArrayList<>();  // the list of teachers
	private static List ClassList = new ArrayList<>();		// the list of whole classes

	// teacher list in different class
	private List Teacher1 = new ArrayList<>();
	private List Teacher2 = new ArrayList<>();
	private List Teacher3 = new ArrayList<>();
	private List Teacher4 = new ArrayList<>();
	private List Teacher5 = new ArrayList<>();
	private List Teacher6 = new ArrayList<>();
	
	// the list of different class
	private static List Class1 = new ArrayList<>();
	private static List Class2 = new ArrayList<>();
	private static List Class3 = new ArrayList<>();
	private static List Class4 = new ArrayList<>();
	private static List Class5 = new ArrayList<>();
	private static List Class6 = new ArrayList<>();
	
	private static List FreeTeacher = new ArrayList<>();
	private static List FreeStudent = new ArrayList<>();
	
	public Daycare_rule() {
		// TODO Auto-generated constructor stub
		
		TeacherFactory tf = new TeacherFactory();
		ArrayList<String[]> itemList = new ArrayList<String[]>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader("Teacher.csv"));
			String line = null;
			while ((line = reader.readLine()) != null) {
				String item[] = line.split(",");
				itemList.add(item);
			}
			reader.readLine();
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {

			MongoClient mongoclient = new MongoClient("localhost",27017);
			DB db = mongoclient.getDB("myDb");
			DBCollection userCollec = db.getCollection("Teacher");
			BasicDBObject b0 = new BasicDBObject();
			ArrayList<Teacher> teachers = new ArrayList<>();

			int len = itemList.size();
			int i = 0;
			Teacher obj = null;
			String[] items = null;
			while (i < len) {
				items = itemList.get(i);
				obj = new Teacher();
				obj.setName(items[0]);
				obj.setAge(Integer.parseInt(items[1]));
				obj.setCredits(Integer.parseInt(items[2]));
				addTeacherToClass(obj);

				b0.put("_id",i);
				b0.put("Teacher Name", items[0]);
				b0.put("Age", items[1]);
				b0.put("Credit", items[2]);
				b0.put("Teacher Comment", items[3]);
				b0.put("Class Number", getClassNumTeacher());
				b0.put("Group Number", getGroupTeaNum());
				userCollec.insert(b0);
				i++;
			}
			
		} catch (Exception ex) {
			System.out.print(ex);
			ex.printStackTrace();
		}
		
		
	}
	
	
	public int getTeacherNum() {
		return TeacherNum;
	}
	
	public String getTeacherName() {
		return TeacherName;
	}

	public int getGroupSize() {
		return GroupSize;
	}
	
	public int getGroupNumMax() {
		return GroupNumMax;
	}
	
	
	public int getClassNum() {
		return ClassNum;
	}

	public int getGroupStuNum() {
		return GroupStuNum;
	}

	public int getGroupTeaNum() {
		return GroupTeaNum;
	}


	public int getClassNumTeacher() {
		return ClassNumTeacher;
	}


	// show the teacher 
	public void showTeachers() {
		// TODO Auto-generated method stub
		TeacherList.add(Teacher1);
		TeacherList.add(Teacher2);
		TeacherList.add(Teacher3);
		TeacherList.add(Teacher4);
		TeacherList.add(Teacher5);
		TeacherList.add(Teacher6);
		System.out.println(TeacherList);
	}
	
	//show the whole classes 
	public void showClass() {
		// TODO Auto-generated method stub
		
		System.out.println(Class1);
		System.out.println(Class2);
		System.out.println(Class3);
		System.out.println(Class4);
		System.out.println(Class5);
		System.out.println(Class6);
	}
	
	public List GetFinalClass() {
		ClassList.add(Class1);
		ClassList.add(Class2);
		ClassList.add(Class3);
		ClassList.add(Class4);
		ClassList.add(Class5);
		ClassList.add(Class6);
		return ClassList;
	}
	
	//show different class
	public void showClass1() {
		// TODO Auto-generated method stub
		System.out.println(Class1);
	}
	
	public void showClass2() {
		// TODO Auto-generated method stub
		System.out.println(Class2);
	}
	
	public void showClass3() {
		// TODO Auto-generated method stub
		System.out.println(Class3);
	}
	public void showClass4() {
		// TODO Auto-generated method stub
		System.out.println(Class4);
	}
	
	public void showClass5() {
		// TODO Auto-generated method stub
		System.out.println(Class5);
	}
	
	public void showClass6() {
		// TODO Auto-generated method stub
		System.out.println(Class6);
	}
	
	// get the ratio and the max group number for each student
	public void getSizeRatio(Student student) {
		
		// groupMaxNum
		if( student.getAge() > 5 && student.getAge() < 48)
		{
			this.GroupNumMax = 3;
		}
		else {
			this.GroupNumMax = 2;
		}
		
		// get the class that the student need to go 
		if( student.getAge() > 5 && student.getAge() <=12)
		{
			this.ClassNum = 1;
			this.GroupSize = 4;
		}
		if( student.getAge() > 12 && student.getAge() <= 24)
		{
			this.ClassNum = 2;
			this.GroupSize = 5;
		}
		if( student.getAge() > 24 && student.getAge() <= 35)
		{
			this.ClassNum = 3;
			this.GroupSize = 6;
		}
		if( student.getAge() > 35 && student.getAge() <= 47)
		{
			this.ClassNum = 4;
			this.GroupSize = 8;
		}
		if( student.getAge() > 47 && student.getAge() <= 59)
		{
			this.ClassNum = 5;
			this.GroupSize = 12;
		}
		if( student.getAge() > 59 )
		{
			this.ClassNum = 6;
			this.GroupSize = 15;
		}

	}
	
	// add each teacher to class
	public void addTeacherToClass(Teacher teacher) {
		
		//get the name of teacher
		List tem1 = new ArrayList<>();
		tem1.add(teacher.getName());
		String str = tem1.toString();
		this.TeacherNum = TeacherNum + 1;
		
		// add 1 teacher to each classroom
		if( TeacherNum == 1 || TeacherNum == 7) {

			this.GroupNum1 = GroupNum1 + 1;
			this.TeacherNum1 = TeacherNum1 + 1;
			this.GroupTeaNum=GroupNum1;
			this.ClassNumTeacher = 1;
			Class1.add(GroupNum1);
			Class1.add(tem1);
			Teacher1.add(str);
		}
		if( TeacherNum == 2 || TeacherNum == 8 ) {
			this.GroupNum2 = GroupNum2 + 1;
			this.TeacherNum2 = TeacherNum2 + 1;
			this.GroupTeaNum=GroupNum2;
			this.ClassNumTeacher = 2;
			Class2.add(GroupNum2);
			Class2.add(tem1);
			Teacher2.add(str);
		}
		if( TeacherNum == 3 || TeacherNum == 9 ) {
			this.TeacherNum3 = TeacherNum3 + 1;
			this.GroupNum3 = GroupNum3 + 1;
			this.GroupTeaNum=GroupNum3;
			this.ClassNumTeacher = 3;
			Class3.add(GroupNum3);
			Class3.add(tem1);
			Teacher3.add(str);
		}
		if( TeacherNum == 4 || TeacherNum == 10 ) {
			this.GroupNum4 = GroupNum4 + 1;
			this.TeacherNum4 = TeacherNum4 + 1;
			this.GroupTeaNum=GroupNum4;
			this.ClassNumTeacher = 4;
			Class4.add(GroupNum4);
			Class4.add(tem1);
			Teacher4.add(str);
		}
		if( TeacherNum == 5 ) {
			this.GroupNum5 = GroupNum5 + 1;
			this.TeacherNum5 = TeacherNum5 + 1;
			this.GroupTeaNum=GroupNum5;
			this.ClassNumTeacher = 5;
			Class5.add(GroupNum5);
			Class5.add(tem1);
			Teacher5.add(str);
		}
		if( TeacherNum == 6  ) {
			this.GroupNum6 = GroupNum6 + 1;
			this.TeacherNum6 = TeacherNum6 + 1;
			this.GroupTeaNum=GroupNum6;
			this.ClassNumTeacher = 6;
			Class6.add(GroupNum6);
			Class6.add(tem1);
			Teacher6.add(str);
		}
		if( TeacherNum > 10 && TeacherNum <= 16) {
			if( FreeStudent.isEmpty() == true ) {
				FreeTeacher.add(tem1);
			}
			else {
				List z = new ArrayList<>() ; // the full teacher number
				int j = -1;  
				
				for (int i=0; i < FreeStudent.size();i++) {
					List a= new ArrayList<>();
					a=(List) FreeStudent.get(i);
					int age = (int) a.get(0);
					if( age > 5 && age <=12 ) {
						if(TeacherNum1 < 3) {
							this.GroupNum1 = GroupNum1 + 1;
							this.TeacherNum1 = TeacherNum1 + 1;
							this.GroupTeaNum=GroupNum1;
							this.ClassNumTeacher = 1;
							Class1.add(GroupNum1);
							Class1.add(tem1);
							Teacher1.add(str);
							j=i;
						}
						else {
							System.out.println("Class1 teacher is full");
							z.add(i);
						}
					}
					
					if( age > 12 && age <=24 ) {
						if(TeacherNum2 < 3) {
							this.GroupNum2 = GroupNum2 + 1;
							this.TeacherNum2 = TeacherNum2 + 1;
							this.GroupTeaNum=GroupNum2;
							this.ClassNumTeacher = 2;
							Class2.add(GroupNum2);
							Class2.add(tem1);
							Teacher2.add(str);
							j=i;
						}
						else {
							System.out.println("Class2 teacher is full");
							z.add(i);
						}
					}
					
					if( age > 24 && age <=35 ) {
						if(TeacherNum3 < 3) {
							this.TeacherNum3 = TeacherNum3 + 1;
							this.GroupNum3 = GroupNum3 + 1;
							this.GroupTeaNum=GroupNum3;
							this.ClassNumTeacher = 3;
							Class3.add(GroupNum3);
							Class3.add(tem1);
							Teacher3.add(str);
							j=i;
						}
						else {
							System.out.println("Class3 teacher is full");
							z.add(i);
						}
					}
					
					if( age > 35 && age <=47 ) {
						if(TeacherNum4 < 3) {
							this.GroupNum4 = GroupNum4 + 1;
							this.TeacherNum4 = TeacherNum4 + 1;
							this.GroupTeaNum=GroupNum4;
							this.ClassNumTeacher = 4;
							Class4.add(GroupNum4);
							Class4.add(tem1);
							Teacher4.add(str);
							j=i;
						}
						else {
							System.out.println("Class4 teacher is full");
							z.add(i);
						}
					}
					
					if( age > 47 && age <=59 ) {
						if(TeacherNum5 < 2) {
							this.GroupNum5 = GroupNum5 + 1;
							this.TeacherNum5 = TeacherNum5 + 1;
							this.GroupTeaNum=GroupNum5;
							this.ClassNumTeacher = 5;
							Class5.add(GroupNum5);
							Class5.add(tem1);
							Teacher5.add(str);
							j=i;
						}
						else {
							System.out.println("Class5 teacher is full");
							z.add(i);
						}
					}

					if( age > 59 ) {
						if(TeacherNum6 < 2) {
							this.GroupNum6 = GroupNum6 + 1;
							this.TeacherNum6 = TeacherNum6 + 1;
							this.GroupTeaNum=GroupNum6;
							this.ClassNumTeacher = 6;
							Class6.add(GroupNum6);
							Class6.add(tem1);
							Teacher6.add(str);
							j=i;
						}
						else {
							System.out.println("Class6 teacher is full");
							z.add(i);
						}
					}	
				}
			
				if(j!=-1) {
					FreeStudent.remove(j);
					if(z.size()>0) {
						for (int i = 0; i<z.size();i++) {
							int d = ( int ) z.get(i);
							FreeStudent.remove(d-i -1);
						}
					}
				}
				else {
					if(z.size()>0) {
						for (int i = 0; i<z.size();i++) {
							int d = ( int ) z.get(i);
							FreeStudent.remove(d-i);
						}
					}
				}	
			}
		}
		if(TeacherNum > 16) {
			System.out.println("All the classroom is full");
		}
	}
	
	
	// add each student to class
	public void addStudent(Student student) {
		
		//get the name and age of the student
		List tem = new ArrayList<>();
		tem.add(student.getAge());
		tem.add(student.getName());
			
		StudentNum = StudentNum + 1;

		//send student to teacher in each class 
		//for class 1 whose age is between 6-12
		if( ClassNum == 1 ) {
			StudentNum1 = StudentNum1 + 1;
			if( StudentNum1 > GroupSize * GroupNumMax) {
//				System.out.println("Classroom1 is full");
				temNum1 = 0;
				StudentNum1 = StudentNum1 - 1;
				StudentNum = StudentNum - 1;
				this.ClassNum =0;
				this.GroupStuNum = 0;
			}
			else {
				
				if (temNum1 <= TeacherNum1) {
					this.GroupStuNum = (int) Class1.get(temNum1* 2 - 2);
				}
				
				if(StudentNum1 <= GroupSize * temNum1 && StudentNum1 > GroupSize * (temNum1-1)){

					if (temNum1 <= TeacherNum1) {
						List temteacher = new ArrayList<>();
						temteacher = (List) Class1.get(temNum1* 2 - 1);
						this.TeacherName = (String) temteacher.get(0);
						temteacher.add(tem);
						Class1.set(temNum1* 2-1,temteacher);
					}
					else {
//						System.out.println("No enough Teacher in Class1");
						StudentNum1 = StudentNum1 - 1;
						temNum1 = temNum1 - 1;
						StudentNum = StudentNum - 1;
						FreeStudent.add(tem);
						this.ClassNum = 0;
						this.GroupStuNum = 0;
					}
				}
			
				if( StudentNum1 % GroupSize ==0) {
					temNum1 = temNum1 + 1;
				}
			}
		}
		
		//for class 2 whose age is between 13-24
				if( ClassNum == 2 ) {
					
					StudentNum2 = StudentNum2 + 1;
					
					if( StudentNum2 > GroupSize * GroupNumMax) {
//						System.out.println("Classroom2 is full");
						temNum2 = 0;
						StudentNum2 = StudentNum2 - 1;
						StudentNum = StudentNum - 1;
						this.ClassNum = 0;
						this.GroupStuNum = 0;
					}
					else {
						
						if (temNum2 <= TeacherNum2) {
							this.GroupStuNum = (int) Class2.get(temNum2* 2 - 2);
						}
						
						if(StudentNum2 <= GroupSize * temNum2 && StudentNum2 > GroupSize * (temNum2 -1)) {
							
							if (temNum2 <= TeacherNum2) {
								List temteacher = new ArrayList<>();
								temteacher = (List) Class2.get(temNum2 *2 - 1);
								this.TeacherName = (String) temteacher.get(0);
								temteacher.add(tem);
								Class2.set(temNum2* 2-1,temteacher);		
							}
							else {
//								System.out.println("No enough Teacher in Class2");
								StudentNum2 = StudentNum2 - 1;
								temNum2 = temNum2 - 1;
								StudentNum = StudentNum - 1;
								FreeStudent.add(tem);
								this.ClassNum = (Integer) null;
								this.GroupStuNum = (Integer) null;
							}
						}
					
						if( StudentNum2 % GroupSize ==0) {
							temNum2 = temNum2 + 1;
						}
					}
				}
				
			//for class 3 whose age is between 25-35
				if( ClassNum == 3 ) {
					
					StudentNum3 = StudentNum3 + 1;
					
					if( StudentNum3 > GroupSize * GroupNumMax) {
//						System.out.println("Classroom3 is full");
						temNum3 = 0;
						StudentNum3 = StudentNum3 - 1;
						StudentNum = StudentNum - 1;
						this.ClassNum = (Integer) null;
						this.GroupStuNum = (Integer) null;
					}
					else {
						if (temNum3 <= TeacherNum3) {
							this.GroupStuNum = (int) Class3.get(temNum3* 2 - 2);
						}
						
						if(StudentNum3 <= GroupSize * temNum3 && StudentNum3 > GroupSize * (temNum3 -1)) {
							
							if (temNum3 <= TeacherNum3) {
								List temteacher = new ArrayList<>();
								temteacher = (List) Class3.get(temNum3 * 2 - 1);
								this.TeacherName = (String) temteacher.get(0);
								temteacher.add(tem);
								Class3.set(temNum3 * 2 - 1,temteacher);	
							}
							else {
//								System.out.println("No enough Teacher in Class3");
								FreeStudent.add(tem);
								temNum3 = temNum3 - 1;
								StudentNum = StudentNum - 1;
								StudentNum3 = StudentNum3 - 1;
								this.ClassNum = 0;
								this.GroupStuNum = 0;
							}
								
						}
					
						if( StudentNum3 % GroupSize ==0) {
							temNum3 = temNum3 + 1;
						}
					}
				}
				
				//for class 4 whose age is between 36-47
				if( ClassNum == 4 ) {
					
					StudentNum4 = StudentNum4 + 1;
					
					if( StudentNum4 > GroupSize * GroupNumMax) {
//						System.out.println("Classroom4 is full");
						temNum4 = 0;
						StudentNum4 = StudentNum4 - 1;
						StudentNum = StudentNum - 1;
						this.ClassNum = 0;
						this.GroupStuNum = 0;
					}
					else {
						if (temNum4 <= TeacherNum4) {
							this.GroupStuNum = (int) Class4.get(temNum4* 2 - 2);
						}
						
						if(StudentNum4 <= GroupSize * temNum4 && StudentNum4 > GroupSize * (temNum4 -1)) {
							
							if (temNum4 <= TeacherNum4) {
								List temteacher = new ArrayList<>();
								temteacher = (List) Class4.get(temNum4* 2 - 1);
								this.TeacherName = (String) temteacher.get(0);
								temteacher.add(tem);
								Class4.set(temNum4* 2-1,temteacher);	
							}
							else {
//								System.out.println("No enough Teacher in Class4");
								FreeStudent.add(tem);
								StudentNum4 = StudentNum4 - 1;
								temNum4 = temNum4 - 1;
								StudentNum = StudentNum - 1;
								this.ClassNum = 0;
								this.GroupStuNum = 0;
							}
						}
					
						if( StudentNum4 % GroupSize ==0) {
							temNum4 = temNum4 + 1;
						}
					}
				}
				
				//for class 5 whose age is between 48-59
				if( ClassNum == 5 ) {
					
					StudentNum5 = StudentNum5 + 1;
					
					if( StudentNum5 > GroupSize * GroupNumMax) {
//						System.out.println("Classroom5 is full");
						temNum5 = 0;
						StudentNum5 = StudentNum5 - 1;
						StudentNum = StudentNum - 1;
						this.ClassNum = 0;
						this.GroupStuNum = 0;
					}
					else {
						if (temNum5 <= TeacherNum5) {	
							this.GroupStuNum = (int) Class5.get(temNum5* 2 - 2);
						}
						
						if(StudentNum5 <= GroupSize * temNum5 && StudentNum5 > GroupSize * (temNum5 -1)) {
							if (temNum5 <= TeacherNum5) {
								List temteacher = new ArrayList<>();
								temteacher = (List) Class5.get(temNum5* 2 - 1);
								this.TeacherName = (String) temteacher.get(0);
								temteacher.add(tem);
								Class5.set(temNum5* 2-1,temteacher);
							}
							else {
//								System.out.println("No enough Teacher in Class5");
								FreeStudent.add(tem);
								temNum5 = temNum5 - 1;
								StudentNum = StudentNum - 1;
								this.ClassNum =0;
								this.GroupStuNum = 0;
								StudentNum5 = StudentNum5 - 1;
							}
						}
					
						if( StudentNum5 % GroupSize ==0) {
							temNum5 = temNum5 + 1;
						}
					}
				}
				
				//for class 6 whose age above 60
				if( ClassNum == 6 ) {
					
					StudentNum6 = StudentNum6 + 1;
					
					if( StudentNum6 > GroupSize * GroupNumMax) {
//						System.out.println("Classroom6 is full");
						temNum6 = 0;
						StudentNum6 = StudentNum6 - 1;
						StudentNum = StudentNum - 1;
						this.ClassNum = 0;
						this.GroupStuNum = 0;
					}
					else {
						if (temNum6 <= TeacherNum6) {
							this.GroupStuNum = (int) Class6.get(temNum6* 2 - 2);
						}

						if(StudentNum6 <= GroupSize * temNum6 && StudentNum6 > GroupSize * (temNum6 -1)) {
							if (temNum6 <= TeacherNum6) {
								List temteacher = new ArrayList<>();
								temteacher = (List) Class6.get(temNum6* 2 - 1);
								this.TeacherName = (String) temteacher.get(0);
								temteacher.add(tem);
								Class6.set(temNum6*2-1,temteacher);
							}
							else {
//								System.out.println("No enough Teacher in Class6");
								FreeStudent.add(tem);
								StudentNum6 = StudentNum6 - 1;
								temNum6 = temNum6 - 1;
								StudentNum = StudentNum - 1;
								this.ClassNum = 0;
								this.GroupStuNum = 0;
							}
						}
					
						if( StudentNum6 % GroupSize ==0) {
							temNum6 = temNum6 + 1;
						}
					}
				}
	}
	
	
	public static void demo() {
		
		
	}
}
