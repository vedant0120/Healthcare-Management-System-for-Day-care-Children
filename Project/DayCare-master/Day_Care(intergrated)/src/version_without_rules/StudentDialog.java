package version_without_rules;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class StudentDialog extends JDialog {

    Student student;

    public StudentDialog(Window owner) {
        super(owner);
        initComponents();
        student = null;
    }

    public Student getStudent() {
        return student;
    }

    public void updateView(Student student) {
        this.student = student;
        txtName.setText(student.getName());
        txtAge.setText(String.valueOf(student.getAge()));
        txtAddress.setText(student.getAddress());
        txtParentName.setText(student.getParentName());
        txtPhoneNumber.setText(student.getPhoneNumber());
    }

    public void updateStudent() {
        student.setName(txtName.getText());
        student.setAge(Integer.parseInt(txtAge.getText()));
        student.setParentName(txtParentName.getText());
        student.setPhoneNumber(txtPhoneNumber.getText());
        student.setAddress(txtAddress.getText());
    }

    private void btnOKActionPerformed(ActionEvent e) {
        if(student==null) {
            student = new Student();
        }
        updateStudent();
        this.setVisible(false);
    }

    private void btnCancelActionPerformed(ActionEvent e) {
        this.setVisible(false);
    }


    private void initComponents() {
        txtName = new JTextField();
        label1 = new JLabel();
        label2 = new JLabel();
        txtAge = new JTextField();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        txtParentName = new JTextField();
        txtAddress = new JTextField();
        txtPhoneNumber = new JTextField();
        btnOK = new JButton();
        btnCancel = new JButton();

        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.add(txtName);
        txtName.setBounds(130, 15, 210, 27);

        label1.setText("Student Name:");
        contentPane.add(label1);
        label1.setBounds(25, 20, 92, 16);

        label2.setText("Student Age:");
        contentPane.add(label2);
        label2.setBounds(25, 55, 92, 16);
        contentPane.add(txtAge);
        txtAge.setBounds(130, 50, 210, 27);

        label3.setText("Parent Name:");
        contentPane.add(label3);
        label3.setBounds(25, 90, 92, 16);

        label4.setText("Address:");
        contentPane.add(label4);
        label4.setBounds(25, 125, 92, 16);

        label5.setText("PhoneNumber:");
        contentPane.add(label5);
        label5.setBounds(25, 160, 92, 16);
        contentPane.add(txtParentName);
        txtParentName.setBounds(130, 85, 210, 27);
        contentPane.add(txtAddress);
        txtAddress.setBounds(130, 120, 210, 27);
        contentPane.add(txtPhoneNumber);
        txtPhoneNumber.setBounds(130, 155, 210, 27);

        btnOK.setText("OK");
        btnOK.addActionListener(e -> btnOKActionPerformed(e));
        contentPane.add(btnOK);
        btnOK.setBounds(175, 205, 78, 27);

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(e -> btnCancelActionPerformed(e));
        contentPane.add(btnCancel);
        btnCancel.setBounds(260, 205, 78, 27);

        // compute preferred size
        Dimension preferredSize = new Dimension();
        for(int i = 0; i < contentPane.getComponentCount(); i++) {
            Rectangle bounds = contentPane.getComponent(i).getBounds();
            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
        }
        Insets insets = contentPane.getInsets();
        preferredSize.width += insets.right;
        preferredSize.height += insets.bottom;
        contentPane.setMinimumSize(preferredSize);
        contentPane.setPreferredSize(preferredSize);
        pack();
        setLocationRelativeTo(getOwner());
    }

    private JTextField txtName;
    private JLabel label1;
    private JLabel label2;
    private JTextField txtAge;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JTextField txtParentName;
    private JTextField txtAddress;
    private JTextField txtPhoneNumber;
    private JButton btnOK;
    private JButton btnCancel;
}