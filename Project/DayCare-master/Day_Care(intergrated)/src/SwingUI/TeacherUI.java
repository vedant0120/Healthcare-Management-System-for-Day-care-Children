package SwingUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.SwingConstants;

import version_without_rules.Daycare_rule;
import version_without_rules.Teacher;
import version_without_rules.TeacherFactory;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Font;

public class TeacherUI extends JFrame {
	private JFrame frame;
	private JTextField TeaCredit;
	private JTextField TeaName;
	private JTextField TeaAge;
	private JTextField TeaComment;

	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { TeacherUI frame = new TeacherUI();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */

	/**
	 * Create the frame.
	 */
	public TeacherUI(Daycare_rule d) {

		frame = new JFrame();
		frame.getContentPane().setForeground(Color.LIGHT_GRAY);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 725, 510);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

//		setIconifiable(true);
		setTitle("Create a new teacher");
//		setClosable(true);
		setBounds(100, 100, 724, 501);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 708, 462);
		getContentPane().add(panel);
		panel.setLayout(null);

		TeaCredit = new JTextField();
		TeaCredit.setColumns(10);
		TeaCredit.setBounds(211, 203, 146, 30);
		panel.add(TeaCredit);

		JLabel lblCredit = new JLabel("Credit :");
		lblCredit.setFont(new Font("Sitka Banner", Font.PLAIN, 20));
		lblCredit.setBounds(47, 203, 120, 30);
		panel.add(lblCredit);

		JLabel label_1 = new JLabel("Age :");
		label_1.setFont(new Font("Sitka Banner", Font.PLAIN, 20));
		label_1.setBounds(47, 160, 120, 30);
		panel.add(label_1);

		JLabel label_2 = new JLabel("Name :");
		label_2.setFont(new Font("Sitka Banner", Font.PLAIN, 20));
		label_2.setBounds(47, 117, 120, 30);
		panel.add(label_2);

		JLabel lblTeacher = new JLabel("Teacher");
		lblTeacher.setForeground(Color.DARK_GRAY);
		lblTeacher.setFont(new Font("Sitka Banner", Font.BOLD, 24));
		lblTeacher.setBounds(321, 13, 201, 41);
		panel.add(lblTeacher);

		TeaName = new JTextField();
		TeaName.setColumns(10);
		TeaName.setBounds(211, 117, 146, 30);
		panel.add(TeaName);

		TeaAge = new JTextField();
		TeaAge.setColumns(10);
		TeaAge.setBounds(211, 160, 146, 30);
		panel.add(TeaAge);

		JButton btnAddTeacher = new JButton("Add Teacher");
		btnAddTeacher.setBounds(211, 305, 130, 41);
		btnAddTeacher.setIcon(
				new ImageIcon(TeacherUI.class.getResource("/images/note.png")));
		panel.add(btnAddTeacher);

		//
		/*StringBuffer sb = new StringBuffer();
		sb.append(TeaName.getText());
		sb.append(",");
		sb.append(TeaAge.getText());
		sb.append(",");
		sb.append(TeaCredit.getText());
		sb.append(",");
		sb.append(TeaComment.getText());
//		String csv = TeaName.getText() + "," + TeaAge.getText()+","+TeaCredit.getText();*/

		//

		btnAddTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addValueActionPerformed(e,d);
			}
		});

		JButton button_1 = new JButton("Reset");
		button_1.setIcon(
				new ImageIcon(TeacherUI.class.getResource("/images/32x32.png")));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValue();
			}
		});
		button_1.setBounds(392, 305, 130, 41);
		panel.add(button_1);
		
		TeaComment = new JTextField();
		TeaComment.setColumns(10);
		TeaComment.setBounds(211, 246, 146, 30);
		panel.add(TeaComment);
		
		JLabel lblComments = new JLabel("Comments :");
		lblComments.setFont(new Font("Sitka Banner", Font.PLAIN, 20));
		lblComments.setBounds(47, 246, 120, 30);
		panel.add(lblComments);
		
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setIcon(new ImageIcon(TeacherUI.class.getResource("/images/b11.png")));
				lblNewLabel.setBounds(0, 0, 708, 462);
				panel.add(lblNewLabel);

	}

	private void addValueActionPerformed(ActionEvent e, Daycare_rule d) {
		if (TeaName.getText().isEmpty() || TeaAge.getText().isEmpty() || TeaCredit.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Name, Age and Credit, those can't be empty!");
		} else {
			try {
				TeacherFactory tf = new TeacherFactory();
				Teacher tea = new Teacher();
				tea.setName(TeaName.getText());
				tea.setAge(Integer.parseInt(TeaAge.getText()));
				tea.setCredits(Integer.parseInt(TeaCredit.getText()));
				tea.setComment(TeaComment.getText());
				d.addTeacherToClass(tea);
				
//				Class.forName("com.mysql.jdbc.Driver");
//				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "mySQL");
//				Statement st1 = con.createStatement();
//				st1.executeUpdate("insert into tea(teacherName,Age,Credit,TeaComment,ClassNum,GroupNum) values('" + TeaName.getText() + "','"
//						+ TeaAge.getText() + "','" + TeaCredit.getText() +"','"+ TeaComment.getText() + "','"+ d.getClassNumTeacher() +"','"+ d.getGroupTeaNum()+"')");
				MongoClient mongoclient = new MongoClient("localhost",27017);
				DB db = mongoclient.getDB("myDb");
				DBCollection userCollec = db.getCollection("Teacher");
				BasicDBObject b0 = new BasicDBObject();
				b0.put("Teacher Name", TeaName.getText());
				b0.put("Age", TeaAge.getText());
				b0.put("Credit", TeaCredit.getText());
				b0.put("Teacher Comment", TeaComment.getText());
				b0.put("Class Number", d.getClassNumTeacher());
				b0.put("Group Number", d.getGroupTeaNum());
				userCollec.insert(b0);
				
			} catch (Exception ex) {
				System.out.print(ex);
				ex.printStackTrace();
			}
			dispose();
		}
	}

	private void resetValue() {
		TeaName.setText("");
		TeaAge.setText("");
		TeaCredit.setText("");
	}
}
