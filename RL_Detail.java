package Employee;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

 class RL_Detail implements ActionListener{
	 
	 JFrame f;
	 JLabel id1,id2,id3,id4,id5,id6,id7,aid1,aid2,aid3,aid4,id8,id9,id15;
	 JTextField t1,t2,t3;
	 JButton b,b1,b2;
	 String rl_id,rl_type,rl_details,creation_date;
	 
	  RL_Detail(int i) {}

	  RL_Detail(String r_id) {
		  try {	
			   	 ConnectionToMySQL con = new ConnectionToMySQL();
			   	 String str = "select * from regulations where rl_id="+r_id+"";
			   	 ResultSet rs = con.s.executeQuery(str);
			   	 
			   	 while (rs.next()) {
			   		 
			   		 rl_id = rs.getString("rl_id");
			   		 rl_type = rs.getString("rl_type");
			   		 creation_date = rs.getString("creation_date");
			   		 rl_details = rs.getString("rl_details");
					
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		  
		  f = new JFrame("Regulation Details");
		  f.setBackground(Color.white);
		  f.setLayout(null);
	  
		  id15 = new JLabel();
		  id15.setBounds(0, 0, 900, 550);
		  id15.setLayout(null);
		  ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/rl_details.jpeg"));
		  id15.setIcon(img);
		  
		  id8 = new JLabel("Regulation Details");
		  id8.setBounds(315, 30, 200, 50);
		  id8.setFont(new Font("serif",Font.BOLD,25));
		  id8.setForeground(Color.black);
		  id15.add(id8);
		  f.add(id15);
		  
		  id1 = new JLabel("Regulation id:");
		  id1.setBounds(20, 80, 100, 30);
		  id1.setFont(new Font("serif",Font.BOLD,15));
		  id15.add(id1);
		  
		  aid1 = new JLabel(rl_id);
		  aid1.setBounds(170, 80, 70, 30);
		  aid1.setForeground(Color.BLACK);
		  aid1.setFont(new Font("serif",Font.ITALIC,15));
		  id9.add(aid1);

		  id2 = new JLabel("RegualtionType:");
		  id2.setBounds(240, 80, 100, 30);
		  id2.setFont(new Font("serif",Font.BOLD,15));
		  id15.add(id2);
		  
		  aid2 = new JLabel(rl_type);
		  aid2.setBounds(400, 80, 100, 30);
		  aid2.setForeground(Color.BLACK);
		  aid2.setFont(new Font("serif",Font.BOLD,15));
		  id9.add(aid2);
		  
		  id3 = new JLabel("Creation Date:");
		  id3.setBounds(600, 80, 100, 30);
		  id3.setFont(new Font("serif",Font.BOLD,15));
		  id15.add(id3);
		  
		  aid3 = new JLabel(creation_date);
		  aid3.setBounds(750, 80, 100, 30);
		  aid3.setForeground(Color.BLACK);
		  aid3.setFont(new Font("serif",Font.ITALIC,15));
		  id9.add(aid3);
		  
		  id4 = new JLabel("RL Description:");
		  id4.setBounds(340, 150, 100, 30);
		  id4.setFont(new Font("serif",Font.BOLD,15));
		  id15.add(id4);
		  
		  aid4 = new JLabel(rl_details);
		  aid4.setBounds(500, 150, 400, 175);
		  aid4.setForeground(Color.BLACK);
		  aid4.setFont(new Font("serif",Font.ITALIC,15));
		  id9.add(aid4);
		  
		  id5 = new JLabel("Comment:");
		  id5.setBounds(370, 350, 100, 30);
		  id5.setFont(new Font("serif",Font.BOLD,15));
		  id15.add(id5);
		  
		  t1 = new JTextField();
		  t1.setBounds(490, 350, 100, 60);
		  id15.add(t1);
		  
		  id6 = new JLabel("Date:");
		  id6.setBounds(375, 440, 100, 30);
		  id6.setFont(new Font("serif",Font.BOLD,15));
		  id15.add(id6);
		  
		  t2 = new JTextField();
		  t2.setBounds(490, 440, 100, 30);
		  id15.add(t2);
		  
		  id7 = new JLabel("Emp Id:");
		  id7.setBounds(375, 490, 100, 30);
		  id7.setFont(new Font("serif",Font.BOLD,15));
		  id15.add(id7);
		  
		  t3 = new JTextField();
		  t3.setBounds(490, 490, 100, 30);
		  id15.add(t3);
		  
		  b = new JButton("Edit Comment");
		  b.setBackground(Color.BLACK);
		  b.setForeground(Color.WHITE);
		  b.setBounds(20, 490, 120, 40);
		  id15.add(b);
		  
		  b1 = new JButton("Back");
		  b1.setBackground(Color.BLACK);
		  b1.setForeground(Color.WHITE);
		  b1.setBounds(110, 490, 100, 40);
		  id15.add(b1);
		  
		  b2 = new JButton("Logout");
		  b2.setBackground(Color.BLACK);
		  b2.setForeground(Color.WHITE);
		  b2.setBounds(760, 490, 100, 40);
		  id15.add(b2);
		  
		  b.addActionListener(this);
		  b1.addActionListener(this);
		  b2.addActionListener(this);
		  
		  f.setVisible(true);
		  f.setSize(900, 500);
		  f.setLocation(400, 150);
		  
	  }	

	  public void actionPerformed(ActionEvent ae) {
		  
		  String nn = t1.getText();
		  String oo = t2.getText();
		  String pp = t3.getText();
		  
		  if(ae.getSource()==b) {
			  try {
				
				  ConnectionToMySQL cc = new ConnectionToMySQL();
				  String n = "insert into regulations values("+pp+","+nn+","+oo+")";
				  cc.s.executeUpdate(n);
				  f.setVisible(false);
				  new emp_login();
				  
			} catch (Exception ee) {
				System.out.println("The error is:"+ee);
			}
		  }  else if(ae.getSource()==b1) {
			  	f.setVisible(false);
			  	new Dept_Reg();
			  }
		  	if(ae.getSource()==b2) {
		  		f.setVisible(false);
		  		new Front_Page();
	  }
	  }
	  public static void main(String[] arg) {
		  RL_Detail rd = new RL_Detail();
	  }
 }

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 