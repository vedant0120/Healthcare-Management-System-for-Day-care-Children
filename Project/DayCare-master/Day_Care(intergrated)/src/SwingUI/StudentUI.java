package SwingUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import version_without_rules.Daycare_rule;
import version_without_rules.Person;
import version_without_rules.StudentFactory;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class StudentUI extends JFrame{

	private JFrame frame;
	private JTextField StuName;
	private JTextField StuAge;
	private JTextField StuGpa;
	private JTextField StuPName;
	private JTextField StuAddress;
	private JTextField StuPhoneNum;

	/**
	 * Initialize the contents of the frame.
	 */
	public StudentUI(Daycare_rule d) {
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
		
		StuName = new JTextField();
		StuName.setBounds(188, 91, 120, 30);
		panel.add(StuName);
		StuName.setColumns(10);
		
		
		
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.setBounds(196, 214, 81, 25);
		btnNewButton_1.setIcon(
				new ImageIcon(TeacherUI.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		
		JLabel IblName = new JLabel("Name :");
		IblName.setFont(new Font("Sitka Banner", Font.PLAIN, 20));
		IblName.setBounds(58, 90, 120, 30);
		panel.add(IblName);
		
		JLabel lblStudentImmunizationRecord = new JLabel("Student ");
		lblStudentImmunizationRecord.setBounds(307, 13, 201, 41);
		panel.add(lblStudentImmunizationRecord);
		lblStudentImmunizationRecord.setForeground(Color.DARK_GRAY);
		lblStudentImmunizationRecord.setFont(new Font("Sitka Banner", Font.BOLD, 24));
		
		JLabel lblAge = new JLabel("Age :");
		lblAge.setFont(new Font("Sitka Banner", Font.PLAIN, 20));
		lblAge.setBounds(58, 133, 120, 30);
		panel.add(lblAge);
		
		JLabel lblGpa = new JLabel("Gpa :");
		lblGpa.setFont(new Font("Sitka Banner", Font.PLAIN, 20));
		lblGpa.setBounds(58, 176, 120, 30);
		panel.add(lblGpa);
		
		JLabel lblParentName = new JLabel("Parent Name :");
		lblParentName.setFont(new Font("Sitka Banner", Font.PLAIN, 20));
		lblParentName.setBounds(58, 219, 120, 30);
		panel.add(lblParentName);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setFont(new Font("Sitka Banner", Font.PLAIN, 20));
		lblAddress.setBounds(58, 262, 120, 30);
		panel.add(lblAddress);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number :");
		lblPhoneNumber.setFont(new Font("Sitka Banner", Font.PLAIN, 20));
		lblPhoneNumber.setBounds(58, 319, 132, 30);
		panel.add(lblPhoneNumber);
		
		StuAge = new JTextField();
		StuAge.setColumns(10);
		StuAge.setBounds(190, 133, 120, 30);
		panel.add(StuAge);
		
		StuGpa = new JTextField();
		StuGpa.setColumns(10);
		StuGpa.setBounds(190, 176, 120, 30);
		panel.add(StuGpa);
		
		StuPName = new JTextField();
		StuPName.setColumns(10);
		StuPName.setBounds(190, 219, 120, 30);
		panel.add(StuPName);
		
		StuAddress = new JTextField();
		StuAddress.setColumns(10);
		StuAddress.setBounds(190, 262, 120, 30);
		panel.add(StuAddress);
		
		StuPhoneNum = new JTextField();
		StuPhoneNum.setColumns(10);
		StuPhoneNum.setBounds(190, 319, 120, 30);
		panel.add(StuPhoneNum);
		
		JButton btnInsertStudent = new JButton("Add Student");
		btnInsertStudent.setBounds(378, 319, 130, 41);
		btnInsertStudent.setIcon(
				new ImageIcon(TeacherUI.class.getResource("/images/note.png")));
		panel.add(btnInsertStudent);
		
		JButton button = new JButton("");
		button.setIcon(
				new ImageIcon(TeacherUI.class.getResource("/images/32x32.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		button.setBounds(527, 319, 130, 41);
		panel.add(button);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(StudentUI.class.getResource("/images/b11.png")));
		label_2.setBounds(0, 0, 710, 470);
		panel.add(label_2);
		btnInsertStudent.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				addValueActionPerformed(e,d);
			}


		});
		
		
	}
	
	private void addValueActionPerformed(ActionEvent e, Daycare_rule d) {
		// TODO Auto-generated method stub
		if (StuName.getText().isEmpty() || StuAge.getText().isEmpty()||StuGpa.getText().isEmpty()||StuPName.getText().isEmpty()||StuAddress.getText().isEmpty()||StuPhoneNum.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Student information missing!!!");
		}else {
			stuImmuRec sir = new stuImmuRec(StuName.getText(),StuAge.getText(),StuGpa.getText(),StuPName.getText(),StuAddress.getText(),StuPhoneNum.getText(),d);
			sir.setVisible(true);
			frame.dispose();
		}
	}

	public void show() {
		frame.setVisible(true);
	}
	
	private void resetValueActionPerformed(ActionEvent evt) {
		this.resetValue();
	}
	private void resetValue() {
		this.StuName.setText("");
		this.StuAge.setText("");
		this.StuGpa.setText("");
		this.StuPName.setText("");
		this.StuAddress.setText("");
		this.StuPhoneNum.setText("");
	}
}
