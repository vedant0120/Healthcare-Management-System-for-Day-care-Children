package SwingUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import version_without_rules.Daycare_rule;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import org.bson.Document;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable; 
import com.mongodb.client.MongoCollection; 
import com.mongodb.client.MongoDatabase;
public class Selection extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;


	/**
	 * Create the frame.
	 */
	public Selection(Daycare_rule dcr) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 872,600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 709, 471);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.setBounds(9, 56, 160, 45);
		panel.add(btnAddStudent);
		
		JButton btnAddTeacher = new JButton("Add Teacher");
		btnAddTeacher.setBounds(9, 273, 160, 45);
		panel.add(btnAddTeacher);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(189, 24, 641, 221);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(189, 261, 641, 221);
		panel.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JButton btnUpdate = new JButton("Show Records");
		btnUpdate.setBounds(9, 405, 160, 45);
		panel.add(btnUpdate);
		
		btnUpdate.setIcon(
				new ImageIcon(TeacherUI.class.getResource("/images/icons8-note-26.png")));
		

		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					
					MongoClient mongoclient = new MongoClient("localhost",27017);
					DB db = mongoclient.getDB("myDb");
					DBCollection userCollec = db.getCollection("Student");
					List<DBObject> all = userCollec.find().toArray();
					table.setModel(DbUtils.resultSetToTableModel(all,"Student"));
					DBCollection userCollec1 = db.getCollection("Teacher");
					List<DBObject> all1 = userCollec1.find().toArray();
					table_1.setModel(DbUtils.resultSetToTableModel(all1,"Teacher"));
						
				}
				catch(Exception e)
					{
					System.out.print(e);
					e.printStackTrace();
				}
			}
			});
		btnAddTeacher.setIcon(
				new ImageIcon(TeacherUI.class.getResource("/images/note.png")));
		
		btnAddTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherUI addteacher = new TeacherUI(dcr);
				addteacher.setVisible(true);
			}
		});
		btnAddStudent.setIcon(
				new ImageIcon(TeacherUI.class.getResource("/images/note.png")));
		
		
		JButton btnShowImmuRec = new JButton("Vaccine Records");
		btnShowImmuRec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{

					MongoClient mongoclient = new MongoClient("localhost",27017);
					DB db = mongoclient.getDB("myDb");
					DBCollection userCollec = db.getCollection("Student");
					List<DBObject> all = userCollec.find().toArray();
					table.setModel(DbUtils.resultSetToTableModel(all,"Student"));
					
				}
				catch(Exception ex)
					{
					System.out.print(ex);
					ex.printStackTrace();
				}
			}
		});
		btnShowImmuRec.setIcon(new ImageIcon(Selection.class.getResource("/images/icons8-note-26.png")));
		btnShowImmuRec.setBounds(9, 169, 160, 45);
		panel.add(btnShowImmuRec);
		
		JLabel label_2 = new JLabel("");
		label_2.setVerticalAlignment(SwingConstants.TOP);
		label_2.setIcon(new ImageIcon(Selection.class.getResource("/images/b11.png")));
		label_2.setBounds(0, 0, 846, 551);
		panel.add(label_2);
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentUI stuui = new StudentUI( dcr);
				stuui.show();
			}
		});
	}
}

