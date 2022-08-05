package Employee;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class admin implements ActionListener {
	
	JFrame f;
	JLabel l1,l2;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
	
	admin(){
		f=new JFrame("admin");
		f.setBackground(Color.white);
		
		f.setLayout(null);
		
		l1=new JLabel();
		l1.setBounds(0, 0, 700, 500);
		l1.setLayout(null);
		ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("admin.jpeg"));
		l1.setIcon(i1);
		f.add(l1);
		
		l2 =new JLabel("Welcome Administrator");
		l2.setBounds(250, 20, 200, 40);
		l2.setFont(new Font("serif",Font.BOLD,25));
		l2.setForeground(Color.white);
		l1.add(l2);
		
		b1 =new JButton("Add Employee");
		b1.setBounds(50, 80, 100, 40);
		b1.setFont(new Font("serif",Font.BOLD,15));
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		l1.add(b1);
		
		b2 =new JButton("View Employee");
		b2.setBounds(150, 80,100, 40);
		b2.setFont(new Font("serif",Font.BOLD,15));
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		l1.add(b2);
		
		b3 =new JButton("Edit Employee");
		b3.setBounds(50, 140, 100, 40);
		b3.setFont(new Font("serif",Font.BOLD,15));
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.addActionListener(this);
		l1.add(b3);
		
		b4 =new JButton("Delete Employee");
		b4.setBounds(150, 140, 100, 40);
		b4.setFont(new Font("serif",Font.BOLD,15));
		b4.setBackground(Color.BLACK);
		b4.setForeground(Color.RED);
		b4.addActionListener(this);
		l1.add(b4);
		
		b5 =new JButton("Add Department");
		b5.setBounds(50, 300, 100, 40);
		b5.setFont(new Font("serif",Font.BOLD,15));
		b5.setBackground(Color.BLACK);
		b5.setForeground(Color.WHITE);
		b5.addActionListener(this);
		l1.add(b5);
		
		b6 =new JButton("View Department");
		b6.setBounds(150, 300, 100, 40);
		b6.setFont(new Font("serif",Font.BOLD,15));
		b6.setBackground(Color.BLACK);
		b6.setForeground(Color.WHITE);
		b6.addActionListener(this);
		l1.add(b6);
		
		b7 =new JButton("Create RL");
		b7.setBounds(50, 440, 100, 40);
		b7.setFont(new Font("serif",Font.BOLD,15));
		b7.setBackground(Color.BLACK);
		b7.setForeground(Color.WHITE);
		b7.addActionListener(this);
		l1.add(b7);
		
		b8 =new JButton("View RL");
		b8.setBounds(150, 440, 100, 40);
		b8.setFont(new Font("serif",Font.BOLD,15));
		b8.setBackground(Color.BLACK);
		b8.setForeground(Color.WHITE);
		b8.addActionListener(this);
		l1.add(b8);
		
		b9 =new JButton("Logout");
		b9.setBounds(670, 440, 100, 40);
		b9.setFont(new Font("serif",Font.BOLD,15));
		b9.setBackground(Color.BLACK);
		b9.setForeground(Color.WHITE);
		b9.addActionListener(this);
		l1.add(b9);
		
		f.setVisible(true);
		f.setSize(700,500);
		f.setLocation(450,200);
		
	}
		
	public void actionPerformed(ActionEvent ae) {
			if(ae.getSource()==b1) {
					f.setVisible(false);
					new Add_Employee();
	         }
			 if(ae.getSource()==b2) {
				 	f.setVisible(false);
				 	new Search_View();
			 }
			 if(ae.getSource()==b3) {
				 	f.setVisible(false);
				 	new Search_Edit();
			 }	 	
			 if(ae.getSource()==b4) {
				 	f.setVisible(false);
				 	new Delete_Employee();
			 }	 	
			 if(ae.getSource()==b5) {
			 	f.setVisible(false);
			 	    new Add_Dept();
			 }
			 if(ae.getSource()==b6) {
				 f.setVisible(false);
				 	new Search_Dept();
			 }
			 if(ae.getSource()==b7) {
				 f.setVisible(false);
				 new Create_RL();	 
			 }
			 if(ae.getSource()==b8) {
				 f.setVisible(false);
				 new Search_RL();	 
			 }
			 if(ae.getSource()==b9) {
				 f.setVisible(false);
				 new Front_Page();
			 }
	}	
		public static void main(String[] arg) {
			admin a =new admin();
		}
}

