package Employee;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

 class Dept_Reg implements ActionListener{
	 
	 JFrame f;
	 JTextField t;
	 JLabel id8,id,aid,id1,aid1,id9,id2,aid2,id3;
	 JButton b1,b2,b3;
	 String dept_id,dept_name,regulations;
	 ImageIcon icon;
	 
	  Dept_Reg(String d_id) {
		  try {
			  
			  	ConnectionToMySQL con = new ConnectionToMySQL();
			  	String str = "select * from departments where dept_id="+d_id+"";
			  	ResultSet rs = con.s.executeQuery(str);
			  	
			  	while(rs.next()) {
			  		
			  			dept_id = rs.getString("dept_id");
			  			dept_name = rs.getString("dept_name");
			  	}
		  }catch (Exception e) {
			  	e.printStackTrace();
		}
		  	try {
		  			ConnectionToMySQL co = new ConnectionToMySQL();
		  			ResultSet rs1 = co.s.executeQuery("select * from regulations where dept_id="+d_id+"");
		  			
		  			while(rs1.next()) {
		  				regulations = rs1.getString("r_id")+" "+rs1.getString("rl_type")+" "+rs1.getString("creation date");
		  				
		  			}
		  	}catch (Exception e1) {
		  			e1.printStackTrace();
			}
		  		f = new JFrame("Department Regulations");
		  		f.setVisible(true);
		  		f.setSize(900, 500);
		  		f.setLocation(450, 642);
		  		f.setBackground(Color.white);
		  		f.setLayout(null);

		  		id9 = new JLabel();
		  		id9.setBounds(0, 0, 900, 550);
		  		id9.setLayout(null);
		  		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/dept_reg.jpeg"));
		  		id9.setIcon(img);
		  		
		  		id8 = new JLabel("Department Regulations");
		  		id8.setBounds(320, 20, 250, 40);
		  		id8.setForeground(Color.WHITE);
		  		f.add(id8);
		  		id8.setFont(new Font("serif",Font.BOLD,25));
		  		id9.add(id8);
		  		f.add(id9);
		  		
		  		id = new JLabel("Dept id:");
		  		id.setBounds(15, 20, 75, 30);
		  		id.setForeground(Color.WHITE);
		  		id.setFont(new Font("serif",Font.BOLD,10));
		  		id9.add(id);
		  		
		  		aid = new JLabel(dept_id);
		  		aid.setBounds(100, 20, 90, 30);
		  		aid.setForeground(Color.WHITE);
		  		aid.setFont(new Font("serif",Font.BOLD,10));
		  		id9.add(aid);
		  		
		  		id1 = new JLabel("Dept Name:");
		  		id1.setBounds(15, 70, 75, 30);
		  		id1.setForeground(Color.WHITE);
		  		id1.setFont(new Font("serif",Font.BOLD,10));
		  		id9.add(id1);
		  		
		  		aid1 = new JLabel(dept_name);
		  		aid1.setBounds(100, 70, 90, 30);
		  		aid1.setForeground(Color.WHITE);
		  		aid1.setFont(new Font("serif",Font.BOLD,10));
		  		id9.add(aid);
		  		
		  		id2 = new JLabel("Regulations: (Order: RL_id, RL_Type, Creation Date");
		  		id2.setBounds(315, 100, 450, 30);
		  		id2.setForeground(Color.BLACK);
		  		id2.setFont(new Font("serif",Font.BOLD,20));
		  		id9.add(id2);
		  		
		  		aid2 = new JLabel(regulations);
		  		aid2.setBounds(315, 150, 675, 350);
		  		aid2.setForeground(Color.BLACK);
		  		aid2.setFont(new Font("srief",Font.ITALIC,20));
		  		id9.add(aid2);
		  		
		  		id3 = new JLabel("Type in RL Id:");
		  		id3.setBounds(15, 240, 100, 30);
		  		id3.setForeground(Color.WHITE);
		  		id3.setFont(new Font("serif",Font.BOLD,10));
		  		id9.add(id3);
		  		
		  		t = new JTextField();
		  		t.setBounds(15, 290, 100, 30);
		  		id9.add(t);
		  		
		  		b1 = new JButton("Read Details");
		  		b1.setBackground(Color.BLACK);
		  		b1.setForeground(Color.WHITE);
		  		b1.setBounds(15, 350, 100, 30);
		  		b1.addActionListener(this);
		  		id9.add(b1);
		  		
		  		b2 = new JButton("Back");
		  		b2.setBackground(Color.BLACK);
		  		b2.setForeground(Color.WHITE);
		  		b2.setBounds(630, 500, 100, 30);
		  		b2.addActionListener(this);
		  		id9.add(b2);
		  		
		  		b3 = new JButton("Logout");
		  		b3.setBackground(Color.BLACK);
		  		b3.setForeground(Color.WHITE);
		  		b3.setBounds(770, 500, 100, 30);
		  		b3.addActionListener(this);
		  		id9.add(b3);
	  }

	  	public void actionPerformed(ActionEvent ae) {
	  		
	  		if(ae.getSource()==b1) {
	  			f.setVisible(false);
	  			RL_Detail rd = new RL_Detail(t.getText());
	  		}
	  		if(ae.getSource()==b2) {
	  			f.setVisible(false);
	  			new Emp_Dept();
	  		}
	  		if(ae.getSource()==b3) {
	  			f.setVisible(false);
	  			new Front_Page();
	  		}
	  		
	  		public static void main(String[] ar) {
	  			new Dept_Reg();
	  		}
	  	}
	  	
 }

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 