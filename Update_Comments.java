package Employee;

import java.awt.*;
import java.sql.*;

import javax.crypto.AEADBadTagException;
import javax.swing.*;
import java.awt.event.*;

 class Update_Comments extends RL_Detail implements ActionListener{
	 
	 JFrame f;
	 JLabel id_emp,id1,id2,id3,id4,id5,id6,id7,id8,id9,id15,aid1,aid2,aid3,aid4;
	 JTextField t,t1,t2,t3,t4,t5,t6;
	 JButton b1,b2,b3;
	 String id_rl;
	 
	 Edit_Employee(String iduc){
		 super(0);
		 
		 try {
			 
			 	ConnectionToMySQL con =  new ConnectionToMySQL();
			 	String str = "select * from regulations where rl_id="+r_id+"";
			 	ResultSet rs = con.s.executeQuery(str);
			 	
			 	while (rs.next()) {
			 		
			 		rl_id = rs.getString("rl_id");
			 		rl_type = rs.getString("rl_type");
			 		creation_date = rs.getString("creation_date");
			 		rl_details = rs.getString("rl_detisl");
					
				}
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		 f=new JFrame("Update Comments");
		 f.setVisible(true);
		 f.setSize(900, 500);
		 f.setLocation(450, 250);
		 f.setBackground(Color.white);
		 f.setLayout(null);
		 
		 id_rl = iduc;
		 id15 = new JLabel();
		 id15.setBounds(0, 0, 900, 550);
		 id15.setLayout(null);
		 ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/update_comments.jpeg"));
		 id15.setIcon(img);
		 
		 id8 = new JLabel("Update Comments:");
		 id8.setBounds(315, 30, 200, 50);
		 id8.setFont(new Font("serif",Font.BOLD,25));
		 id8.setForeground(Color.black);
		 id15.add(id8);
		 f.add(id15);
		 
		 id1 = new JLabel("Regulation Id:");
		 id1.setBounds(20, 80, 100, 30);
		 id1.setFont(new Font("serif",Font.BOLD,15));
		 id15.add(id1);
		 
		 aid1 = new JLabel(rl_id);
		 aid1.setBounds(170,80,70,30);
		 aid1.setForeground(Color.BLACK);
		 aid1.setFont(new Font("serif",Font.ITALIC,15));
		 id9.add(aid1);
		 
		 id2 = new JLabel("Regulation Type");
		 id2.setBounds(240, 80, 100, 30);
		 id2.setFont(new Font("serif",Font.BOLD,15));
		 id15.add(id2);
		 
		 aid2 = new JLabel(rl_type);
		 aid2.setBounds(400,80,100,30);
		 aid2.setForeground(Color.BLACK);
		 aid2.setFont(new Font("serif",Font.ITALIC,15));
		 id9.add(aid2);
		 
		 id3 = new JLabel("Creation Date:");
		 id3.setBounds(600, 80, 100, 30);
		 id3.setFont(new Font("serif",Font.BOLD,15));
		 id15.add(id3);
		 
		 aid3 = new JLabel(creation_date);
		 aid3.setBounds(750,80,100,30);
		 aid3.setForeground(Color.BLACK);
		 aid3.setFont(new Font("serif",Font.ITALIC,15));
		 id9.add(aid3);
		 
		 id4 = new JLabel("RL Description");
		 id4.setBounds(340, 150, 100, 30);
		 id4.setFont(new Font("serif",Font.BOLD,15));
		 id15.add(id4);
		 
		 aid4 = new JLabel(rl_details);
		 aid4.setBounds(500, 150, 400, 175);
		 aid4.setForeground(Color.BLACK);
		 aid4.setFont(new Font("serif",Font.ITALIC,15));
		 id9.add(aid4);
		 
		 id5 = new JLabel("Comment:");
		 id5.setBounds(375, 350, 100, 30);
		 id5.setFont(new Font("serif",Font.BOLD,15));
		 id15.add(id5);
		 
		 t1 = new JTextField();
		 t1.setBounds(490, 350, 400, 60);
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
		 id15.add(b1);
		 
		 b1 = new JButton("Back");
		 b1.setBackground(Color.BLACK);
		 b1.setForeground(Color.WHITE);
		 b1.setBounds(110, 490, 100, 40);
		 id15.add(b1);
		 
		 b2 = new JButton("Logout");
		 b2.setBackground(Color.RED);
		 b2.setForeground(Color.WHITE);
		 b2.setBounds(760, 490, 100, 40);
		 id15.add(b2);
		 
		 b.addActionListener(this);
		 b1.addActionListener(this);
		 b2.addActionListener(this);
		 
		 showData(iduc);
		 
	 }
	 	int i =0;
	 	void showData(String s) {
	 		try {
				
	 			ConnectionToMySQL con1 = new ConnectionToMySQL();
	 			String str1 = "select * from comments 1011 where rl_id="+s+"";
	 			ResultSet rs1 = con1.s.executeQuery(str1);
	 			
	 			if(rs1.next()) {
	 				
	 				f.setVisible(true);
	 				i=1;
	 				
	 				t1.setText(rs1.getString(2));
	 				t2.setText(rs1.getString(3));
	 				t3.setText(rs1.getString(1));
	 			}
	 			if(i==0)
	 				JOptionPane.showMessageDialog(null, "Id not found");
	 			new Search_RL_Comments();
	 			} catch (Exception ex) {}

	 		f.setVisible(true);
	 		f.setSize(900, 550);
	 		f.setLocation(400, 100);
	 	}
	 	
	 	public void actionPerformed(ActionEvent ae) {
	 		if(ae.getSource()==b1 && i==1) {
	 			try {
					
	 					ConnectionToMySQL con1 = new ConnectionToMySQL();
	 					String str1 = "update comments1011 set comments="+t1.getText()+",date="+t2.getText()+",emp_id"+t3.getText()+"where rl_id="+id_rl+"";
	 					con1.s.executeUpdate(str1);
	 					JOptionPane.showMessageDialog(null, "successfully update");
	 					f.setVisible(false);
	 					Search_RL_Comments sc = new Search_RL_Comments();
				} catch (Exception e) {
					System.out.println("The error is:"+e);
				}
	 		}
	 		if(ae.getSource()==b2) {
	 			f.setVisible(false);
	 			emp_login el = new emp_login();
	 		}
	 		if(ae.getSource()==b3) {
	 			f.setVisible(false);
	 			Front_Page f = new Front_Page();
	 		}
	 	}
	 	public static void main(String[] arg) {
	 		new Update_Comments("Update_Comments");
	 	}
 }

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 