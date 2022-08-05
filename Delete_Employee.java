package Employee;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class Delete_Employee implements ActionListener{

	JFrame f;
	JTextField t;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	JButton b,b1,b2,b3,b4;
	
	 Delete_Employee() {
		 f=new JFrame("Remove Employee");
		 f.setBackground(Color.green);
		 f.setLayout(null);
		 
		 l5 = new JLabel();
		 l5.setBounds(0, 0, 800, 500);
		 l5.setLayout(null);
		 ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Employees/icons/delete.jpeg"));
		 l5.setIcon(img);
		 f.add(l5);
		 
		 l1 = new JLabel("Employee Id");
		 l1.setBounds(180, 50, 250, 30);
		 l1.setForeground(Color.white);
		 Font f2 = new Font("serif",Font.BOLD,25);
		 l1.setFont(f2);
		 l5.add(l1);
		 
		 t = new JTextField();
		 t.setBounds(390, 50, 175, 40);
		 l5.add(t);
		 
		 b = new JButton("Search");
		 b.setBounds(390, 125, 100, 30);
		 b.setBackground(Color.BLACK);
		 b.setForeground(Color.WHITE);
		 b.addActionListener(this);
		 l5.add(b);
		 
		 b3 = new JButton("Back");
		 b3.setBounds(575, 125, 100, 30);
		 b3.setBackground(Color.BLACK);
		 b3.setForeground(Color.WHITE);
		 b3.addActionListener(this);
		 l5.add(b3);
		 
		 l2 = new JLabel("First Name:");
		 l2.setBounds(30, 200, 100, 30);
		 l2.setForeground(Color.white);
		 Font f3 = new Font("serif",Font.BOLD,20);
		 l2.setFont(f3);
		 l5.add(l2);
		 
		 l6 = new JLabel();
		 l6.setBounds(180, 200, 350, 30);
		 l6.setForeground(Color.white);
		 Font F6 = new Font("Serif",Font.BOLD,20);
		 l6.setFont(F6);
		 l5.add(l6);
		 
		 l3 = new JLabel("Last Name:");
		 l3.setBounds(30, 250, 250, 30);
		 l3.setBackground(Color.white);
		 Font f4 = new Font("serif",Font.BOLD,20);
		 l3.setFont(f4);
		 l5.add(l3);
		 
		 l7 = new JLabel();
		 l7.setBounds(180, 250, 350, 30);
		 l7.setBackground(Color.white);
		 Font F7 = new Font("serif",Font.BOLD,20);
		 l7.setFont(F7);
		 l5.add(l7);
		 
		 l4 = new JLabel("Email:");
		 l4.setBounds(30, 300, 250, 30);
		 l4.setBackground(Color.white);
		 Font F5 = new Font("Serif",Font.BOLD,20);
		 l4.setFont(F5);
		 l5.add(l4);
		 
		 l8 = new JLabel();
		 l8.setBounds(180, 300, 350, 30);
		 l8.setBackground(Color.white);
		 Font f8 = new Font("serif",Font.BOLD,20);
		 l8.setFont(f8);
		 l5.add(l8);
		 
		 b1 = new JButton("Remove");
		 b1.setBounds(180, 460, 100, 30);
		 b1.setBackground(Color.BLACK);
		 b1.setForeground(Color.WHITE);
		 b1.addActionListener(this);
		 l5.add(b1);
		 
		 b2 = new JButton("Cancel");
		 b2.setBounds(300, 460, 100, 30);
		 b2.setBackground(Color.BLACK);
		 b2.setForeground(Color.WHITE);
		 b2.addActionListener(this);
		 l5.add(b2);
		 
		 b4 = new JButton("Logout");
		 b4.setBounds(300, 680, 100, 30);
		 b4.setBackground(Color.BLACK);
		 b4.setForeground(Color.WHITE);
		 b4.addActionListener(this);
		 l5.add(b4);
		 
		 l2.setVisible(false);
		 l3.setVisible(false);
		 l4.setVisible(false);
		 b1.setVisible(false);
		 b2.setVisible(false);
		 b4.setVisible(false);
		 
		 f.setSize(800,500);
		 f.setLocation(500, 250);
		 f.setVisible(true);
			
	 }
	 	public void actionPerformed(ActionEvent ae) {

	 		if(ae.getSource()==b) {
	 			try {
	 				ConnectionToMySQL con = new ConnectionToMySQL();
	 				String str ="select fname,lname,email from employees where emp_id="+t.getText()+"";
	 				ResultSet rs = con.s.executeQuery(str);
	 				
	 				int i = 0;
	 				if(rs.next()) {
	 					String fname = rs.getString(1);
	 					String lnmae = rs.getString(2);
	 					String email = rs.getString(3);
	 					
	 					l2.setVisible(true);
	 					l3.setVisible(true);
	 					l4.setVisible(true);
	 					b1.setVisible(true);
	 					b2.setVisible(true);
	 					b4.setVisible(true);
	 					i = 1;
	 					l6.setText(fname);
	 					l7.setText(lnmae);
	 					l8.setText(email);
	 				}
	 				if(i==0);
	 					JOptionPane.showMessageDialog(null, "deleted successfully");
	 					l2.setVisible(false);
	 					l3.setVisible(false);
	 					l4.setVisible(false);
	 					l5.setVisible(false);
	 					l6.setVisible(false);
	 					l7.setVisible(false);
	 					l8.setVisible(false);
	 					b1.setVisible(false);
	 					b2.setVisible(false);
	 					b4.setVisible(false);
	 					
	 				}catch (Exception ex) {
	 					JOptionPane.showMessageDialog(null, "Exception occured while deleting record"+ex);
					}
	 		}
	 		if(ae.getSource()==b2) {
	 			f.setVisible(false);
	 			admin a = new admin();
	 		}
	 		if(ae.getSource()==b3) {
	 			f.setVisible(false);
	 			admin a = new admin();
	 		}
	 		if(ae.getSource()==b4) {
	 			f.setVisible(false);
	 			Front_Page f = new Front_Page();
	 		}
	 	}
	 		public static void main(String[] arg) {
	 				new Delete_Employee();
	 		}
}	
