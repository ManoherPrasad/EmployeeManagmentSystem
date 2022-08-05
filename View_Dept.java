package Employee;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


class View_Dept implements ActionListener{
	
		JFrame f;
		JLabel id8,id,aid,id1,aid1,id9;
		String dept_id,dept_name;
		JButton b1,b2,b3;
		ImageIcon icon;
		
		 View_Dept() {
			 try {
				 ConnectionToMySQL con = new ConnectionToMySQL();
				 String str ="select*from departments where id="+d_id+"";
				 ResultSet rs = con.s.executeQuery(str);
				 
				 while(rs.next()) {
					 
					 dept_id = rs.getString("dept_id");
					 dept_name = rs.getString("dept_name");
					 
				 }
						
			 }catch (Exception e) {
				e.printStackTrace();
			}
		
			 	f = new JFrame("View Department");
			 	f.setVisible(true);
			 	f.setSize(600,350);
			 	f.setLocation(450, 642);
			 	f.setBackground(Color.white);
			 	f.setLayout(null);
			 	
			 	id9 = new JLabel();
			 	id9.setBounds(0, 0, 600, 350);
			 	id9.setLayout(null);
			 	ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/view_dept.jpeg"));
			 	id9.setIcon(img);
			 	
			 	id8 = new JLabel("View Department");
			 	id8.setBounds(230, 20, 200, 30);
			 	f.add(id8);
			 	id8.setFont(new Font("serf",Font.BOLD,25));
			 	id9.add(id8);
			 	f.add(id9);
			 	
			 	id = new JLabel("Department Id:");
			 	id.setBounds(110, 70, 120, 30);
			 	id.setFont(new Font("serif",Font.BOLD,20));
			 	id9.add(id);
			 	
			 	aid = new JLabel("dept_id");
			 	aid.setBounds(270, 70, 200, 30);
			 	aid.setFont(new Font("serif",Font.BOLD,20));
			 	id9.add(aid);
			 	
			 	id1 = new JLabel("Department Name:");
			 	id1.setBounds(110, 120, 120, 30);
			 	id1.setFont(new Font("serif",Font.BOLD,20));
			 	id9.add(id1);
			 	
			 	aid1 = new JLabel("dept_name");
			 	aid1.setBounds(270, 120, 200, 30);
			 	aid1.setFont(new Font("serif",Font.BOLD,20));
			 	id9.add(aid1);
			 	
			 	b1 = new JButton("Print");
			 	b1.setBounds(30, 300, 100, 30);
			 	b1.setBackground(Color.BLACK);
			 	b1.setForeground(Color.WHITE);
			 	b1.addActionListener(this);
			 	id9.add(b1);
			 	
			 	b2 = new JButton("Back");
			 	b2.setBounds(180, 300, 100, 30);
			 	b2.setBackground(Color.BLACK);
			 	b2.setForeground(Color.WHITE);
			 	b2.addActionListener(this);
			 	id9.add(b2);
			 	
			 	b3 = new JButton("Logout");
			 	b3.setBounds(510, 300, 100, 30);
			 	b3.setBackground(Color.BLACK);
			 	b3.setForeground(Color.WHITE);
			 	b3.addActionListener(this);
			 	id9.add(b3);
			 	
		 }
		 
		 public void actionPerformed(ActionEvent ae) {
			 
			 if(ae.getSource()==b1) {
				 JOptionPane.showMessageDialog(null,"Printed Successfully");
				 f.setVisible(false);
				 admin a = new admin();
			 }
			 if(ae.getSource()==b2) {
				 f.setVisible(false);
				 new Search_Dept();	 
			 }
			 if(ae.getSource()==b3) {
				 f.setVisible(false);
				 new Front_Page();
				 
			 }
		 }
		 public static void main(String[] args) {
			 new View_Dept();
		 }
}

























