package SwingUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import version_without_rules.Daycare_rule;
import version_without_rules.ImmunizationRec;
import version_without_rules.Person;
import version_without_rules.Student;
import version_without_rules.StudentFactory;
import version_without_rules.Teacher;
import version_without_rules.TeacherFactory;
import version_without_rules.GetImzRecord;
import javax.swing.ImageIcon;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient; 
import com.mongodb.client.FindIterable; 
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
public class stuImmuRec extends JFrame {

	private JPanel contentPane;
	private JFrame frame;

	/**
	 * Create the frame.
	 */
	public stuImmuRec(String Name, String age, String Gpa, String PName, String Address, String PhoneNum,Daycare_rule d) {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.LIGHT_GRAY);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 725, 510);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 710, 470);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 726, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStrudentImmunizationRecord = new JLabel("Student Immunization Record Form");
		lblStrudentImmunizationRecord.setBounds(19, 21, 512, 60);
		lblStrudentImmunizationRecord.setFont(new Font("Sitka Banner", Font.BOLD, 24));
		contentPane.add(lblStrudentImmunizationRecord);
		
		JLabel lblNewLabel = new JLabel("Hib :");
		lblNewLabel.setBounds(19, 84, 164, 32);
		lblNewLabel.setFont(new Font("Sitka Banner", Font.PLAIN, 22));
		contentPane.add(lblNewLabel);
		
		JComboBox Hib = new JComboBox();
		Hib.setBounds(149, 92, 119, 20);
		Hib.setMaximumRowCount(10);
		Hib.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		Hib.setSelectedIndex(0);
		contentPane.add(Hib);
		
		JLabel lblDtap = new JLabel("DTap :");
		lblDtap.setBounds(19, 127, 164, 32);
		lblDtap.setFont(new Font("Sitka Banner", Font.PLAIN, 22));
		contentPane.add(lblDtap);
		
		JLabel IbPolio = new JLabel("Polio :");
		IbPolio.setBounds(19, 170, 164, 32);
		IbPolio.setFont(new Font("Sitka Banner", Font.PLAIN, 22));
		contentPane.add(IbPolio);
		
		JLabel lblHepatitisB = new JLabel("Hepatitis B :");
		lblHepatitisB.setBounds(19, 213, 164, 32);
		lblHepatitisB.setFont(new Font("Sitka Banner", Font.PLAIN, 22));
		contentPane.add(lblHepatitisB);
		
		JLabel lblVaricella = new JLabel("Varicella :");
		lblVaricella.setBounds(19, 303, 164, 32);
		lblVaricella.setFont(new Font("Sitka Banner", Font.PLAIN, 22));
		contentPane.add(lblVaricella);
		
		JLabel lblNewLabel_1 = new JLabel("MMR :");
		lblNewLabel_1.setBounds(19, 256, 164, 32);
		lblNewLabel_1.setFont(new Font("Sitka Banner", Font.PLAIN, 22));
		contentPane.add(lblNewLabel_1);
		
		JComboBox DTap = new JComboBox();
		DTap.setBounds(149, 133, 119, 20);
		DTap.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		DTap.setSelectedIndex(0);
		contentPane.add(DTap);
		
		JComboBox Polio = new JComboBox();
		Polio.setBounds(149, 176, 119, 20);
		Polio.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		Polio.setSelectedIndex(0);
		contentPane.add(Polio);
		
		JComboBox Hep = new JComboBox();
		Hep.setBounds(149, 219, 119, 20);
		Hep.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		Hep.setSelectedIndex(0);
		contentPane.add(Hep);
		
		JComboBox MMR = new JComboBox();
		MMR.setBounds(149, 262, 119, 20);
		MMR.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		MMR.setSelectedIndex(0);
		contentPane.add(MMR);
		
		JComboBox Vari = new JComboBox();
		Vari.setBounds(149, 309, 119, 20);
		Vari.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		Vari.setSelectedIndex(0);
		contentPane.add(Vari);
		
		JComboBox Tdap = new JComboBox();
		Tdap.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		Tdap.setSelectedIndex(0);
		Tdap.setMaximumRowCount(10);
		Tdap.setBounds(514, 91, 119, 20);
		contentPane.add(Tdap);
		
		JComboBox Meningococcal = new JComboBox();
		Meningococcal.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		Meningococcal.setSelectedIndex(0);
		Meningococcal.setMaximumRowCount(10);
		Meningococcal.setBounds(514, 134, 119, 20);
		contentPane.add(Meningococcal);
		//setup student immurec
		String csv = Name+","+age+","+Gpa+","+PName+","+Address+","+PhoneNum;
		StudentFactory  st = new StudentFactory();
		version_without_rules.Student stu = st.createPerson(csv);
		d.getSizeRatio(stu);
		d.addStudent(stu);
		
		if(d.getClassNum() == 0 || d.getGroupStuNum() == 0 ) {
			JOptionPane.showMessageDialog(null, "No enough Teacher for This Student!");
		}

		GetImzRecord rec = new GetImzRecord();
		int temp = Integer.parseInt(age);
		ImmunizationRec Im = new ImmunizationRec(temp);
		JButton btnNewButton = new JButton("Check for Missing Records");
		btnNewButton.setBounds(363, 290, 278, 32);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				

				
				rec.updateImmuRec("Hib" + "," + Hib.getSelectedItem().toString());
				rec.updateImmuRec("DTap" + "," + DTap.getSelectedItem().toString());
				rec.updateImmuRec("Polio" + "," + Polio.getSelectedItem().toString());
				rec.updateImmuRec("Hepatitis B" + "," + Hep.getSelectedItem().toString());
				rec.updateImmuRec("MMR" + "," + MMR.getSelectedItem().toString());
				rec.updateImmuRec("Varicella" + "," + Vari.getSelectedItem().toString());
				rec.updateImmuRec("Tdap" + "," + Tdap.getSelectedItem().toString());
				rec.updateImmuRec("Meningococcal" + "," + Meningococcal.getSelectedItem().toString());
				
				
				if(Im.NeedVaccin(temp, rec.getImmurec())) {
					JOptionPane.showMessageDialog(null, "This Student needs to take new Immunization shots : "+ Im.getVaccine().toString());
				}else {
					JOptionPane.showMessageDialog(null, "This Student's Immunization record is perfect!!");
				}

			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnShowUpdatedTable = new JButton("Complete Adding Records");
		btnShowUpdatedTable.setBounds(363, 230, 278, 32);
		btnShowUpdatedTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// MAKE another Jframe
				String x = String.valueOf(Im.NeedVaccin(temp, rec.getImmurec()));
				addStudent(Name, age, Gpa, PName, Address, PhoneNum, x, d.getClassNum(), d.getGroupStuNum(), d.getTeacherName(),Hib.getSelectedItem().toString(),DTap.getSelectedItem().toString(),Polio.getSelectedItem().toString(),Hep.getSelectedItem().toString(),MMR.getSelectedItem().toString(),Vari.getSelectedItem().toString(),Tdap.getSelectedItem().toString(),Meningococcal.getSelectedItem().toString());

				dispose();
			}
		});
		contentPane.add(btnShowUpdatedTable);
		
		JLabel lblTdap = new JLabel("Tdap :");
		lblTdap.setFont(new Font("Sitka Banner", Font.PLAIN, 22));
		lblTdap.setBounds(365, 83, 164, 32);
		contentPane.add(lblTdap);
		
		
		
		JLabel lblMeningococcal = new JLabel("Meningococcal :");
		lblMeningococcal.setFont(new Font("Sitka Banner", Font.PLAIN, 22));
		lblMeningococcal.setBounds(365, 126, 164, 32);
		contentPane.add(lblMeningococcal);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 710, 410);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(stuImmuRec.class.getResource("/images/b11.png")));
		lblNewLabel_2.setBounds(0, 0, 710, 410);
		panel_1.add(lblNewLabel_2);
	}
	
	private void addStudent(String Name, String age, String Gpa, String PName, String Address, String PhoneNum, String NeedVaccine, int ClassNum,int GroupNum, String TeaName,String Hib ,String Dtap , String Polio ,String Hepatitis_B , String MMR , String Varicella , String Tdap, String Meningococcal) {
		String csv = Name+","+ age + "," + Gpa+","+ PName + "," + Address+","+PhoneNum;
		StudentFactory  st = new StudentFactory();
//		Person stu = st.createPerson(csv);

			try{

				
				MongoClient mongoclient = new MongoClient("localhost",27017);
				DB db = mongoclient.getDB("myDb");
				DBCollection userCollec = db.getCollection("Student");
				BasicDBObject b0 = new BasicDBObject();
				b0.put("StudentName", Name);
				b0.put("Age", age);
				b0.put("Gpa", Gpa);
				b0.put("ParentName", PName);
				b0.put("Address", Address);
				b0.put("PhoneNumber", PhoneNum);
				b0.put("Vaccine", NeedVaccine);
				b0.put("ClassNum", ClassNum);
				b0.put("GroupNum", GroupNum);
				b0.put("TeaName", TeaName);
				b0.put("Hib", Hib);
				b0.put("Dtap", Dtap);
				b0.put("Polio", Polio);
				b0.put("Hepatitis_B", Hepatitis_B);
				b0.put("MMR", MMR);
				b0.put("Varicella", Varicella);
				b0.put("Tdap", Tdap);
				b0.put("Meningococcal", Meningococcal);
				userCollec.insert(b0);
				
			}
			catch(Exception ex)
				{
				System.out.print(ex);
				ex.printStackTrace();
			}
	}
	
}
