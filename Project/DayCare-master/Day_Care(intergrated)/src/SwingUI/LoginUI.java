package SwingUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import version_without_rules.Daycare_rule;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class LoginUI {

	private JFrame frame;
	private JTextField usertxt;
	private JPasswordField passwordtxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI window = new LoginUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 814, 514);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Sitka Banner", Font.BOLD, 16));
		lblUsername.setBounds(523, 115, 101, 44);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Sitka Banner", Font.BOLD, 16));
		lblPassword.setBounds(523, 160, 101, 38);
		
		usertxt = new JTextField();
		usertxt.setBounds(611, 132, 86, 20);
		usertxt.setColumns(10);
		
		passwordtxt = new JPasswordField();
		passwordtxt.setBounds(611, 170, 86, 20);
		passwordtxt.setColumns(10);
		
		Daycare_rule dcr = new Daycare_rule();
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(611, 211, 88, 23);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char[] temp = "admin".toCharArray();
				char[] password = passwordtxt.getPassword();
				if(usertxt.getText().toString().equals("admin")&& Arrays.equals(temp, password)) {
					Selection homepage = new Selection(dcr);
					homepage.setVisible(true);
					frame.setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, "User name or password is wrong! try again!");
				}

			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblUsername);
		frame.getContentPane().add(lblPassword);
		frame.getContentPane().add(passwordtxt);
		frame.getContentPane().add(usertxt);
		frame.getContentPane().add(btnLogin);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(LoginUI.class.getResource("/images/dc5.png")));
		label.setBounds(468, 0, 700, 144);
		frame.getContentPane().add(label);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(LoginUI.class.getResource("/images/b.gif")));
		label_2.setBounds(444, 119, 80, 90);
		frame.getContentPane().add(label_2);
		
		JLabel label_1 = new JLabel("");
		label_1.setVerticalAlignment(SwingConstants.TOP);
		label_1.setIcon(new ImageIcon(LoginUI.class.getResource("/images/sch11.jpg")));
		label_1.setBounds(0, 0,798,475);
		frame.getContentPane().add(label_1);
	}
}
