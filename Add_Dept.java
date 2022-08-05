package Employee;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class Add_Dept implements ActionListener{
	
	JFrame f;
	JLabel id1,id2,id8,id15;
	JTextField t1,t2;
	JButton b,b1,b2;
	
	 Add_Dept(int i) {}

	 	 Add_Dept() {
	 		 	f = new JFrame("Add Department");
	 		 	f.setBackground(Color.white);
	 		 	f.setLayout(null);
	 		 	
	 		 	id15 = new JLabel();
	 		 	id15.setBounds(0, 0, 600, 400);
	 		 	id15.setLayout(null);
	 		 	ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Employees/icons/add_dept.jpeg"));
	 		 	id15.setIcon(img);
	 		 	
	 		 	id8 = new JLabel("Add Department");
	 		 	id8.setBounds(250, 20, 200, 50);
	 		 	id8.setBackground(Color.white);
	 		 	id8.setFont(new Font("serif",Font.BOLD,20));
	 		 	id15.add(id8);
	 		 	f.add(id15);
	 		 	
	 		 	id1 = new JLabel("Department Id");
	 		 	id1.setBounds(15, 135, 100, 30);
	 		 	id1.setFont(new Font("serif",Font.BOLD,20));
	 		 	id15.add(id1);
	 		 	
	 		 	t1 = new JTextField();
	 		 	t1.setBounds(130, 120, 150, 30);
	 		 	id15.add(t1);
	 		 	
	 		 	id2 = new JLabel("Department Name");
	 		 	id2.setBounds(15, 165, 200, 30);
	 		 	id2.setFont(new Font("serif",Font.BOLD,20));
	 		 	id15.add(id2);
	 		 	
	 		 	t2 = new JTextField();
	 		 	t2.setBounds(130, 165, 150, 30);
	 		 	id15.add(t2);
	 		 	
	 		 	b = new JButton("Add");
	 		 	b.setBackground(Color.BLACK);
	 		 	b.setForeground(Color.WHITE);
	 		 	b.setBounds(175, 350, 100, 40);
	 		 	id15.add(b);
	 		 	
	 		 	b1 = new JButton("Cancell");
	 		 	b1.setBackground(Color.BLACK);
	 		 	b1.setForeground(Color.WHITE);
	 		 	b1.setBounds(300, 350, 100, 40);
	 		 	id15.add(b1);
	 		 	
	 		 	b2 = new JButton("Logout");
	 		 	b2.setBackground(Color.BLACK);
	 		 	b2.setForeground(Color.WHITE);
	 		 	b2.setBounds(480, 350, 100, 40);
	 		 	id15.add(b2);
	 		 	
	 		 	b.addActionListener(this);
	 		 	b1.addActionListener(this);
	 		 	b2.addActionListener(this);
	 		 	
	 		 	f.setVisible(true);
	 		 	f.setSize(600,400);
	 		 	f.setLocation(400, 150);
		}
	 	 public void actionPerformed(ActionEvent ae) {
	 		 String aa = t1.getText();
	 		 String bbb = t2.getText();
	 		 
	 		 if(ae.getSource()==b) {
	 			try {
	 					ConnectionToMySQL cc = new ConnectionToMySQL();
	 					String n = "insert into departments values("+aa+","+bbb+")";
	 						cc.s.executeQuery(n);
	 						JOptionPane.showMessageDialog(null, "Department Successfully Inserted");
	 						f.setVisible(false);
	 						new admin();
	 			}catch (Exception ee) {
					System.out.println("The error is:"+ee);
				}
	 		 }else if(ae.getSource()==b1) {
	 			 	f.setVisible(false);
	 			 	new admin();	 	
	 		 }
	 		 if(ae.getSource()==b2) {
	 			 f.setVisible(false);
	 			 new Front_Page();
	 		 }
	 		 
	 	 }public static void main(String[] arg) {
	 		 Add_Department ad = new Add_Department();
	 		 
	 	 }
}
