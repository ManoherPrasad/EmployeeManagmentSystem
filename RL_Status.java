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

class RL_Status implements ActionListener{
	
	JFrame f;
	JLabel id8,id,aid,id1,aid1,id9,id2,aid2,id3,aid3,id4,aid4;
	String rl_id,rl_type,creation_date,dept_id,comments;
	JButton b1,b2,b3;
	ImageIcon icon;
	
	 RL_Status(String r_id) {
		try {
			ConnectionToMySQL con = new ConnectionToMySQL();
			String str = "Select * from regulation where id="+r_id+"";
			ResultSet rs = con.s.executeQuery(str);
			
			while(rs.next()) {
				
				rl_id = rs.getString("r_id");
				rl_type = rs.getString("rl_type");
				creation_date = rs.getString("creation_date");
				dept_id = rs.getString("dept_id");	
			}
		}
			catch (Exception e) {
				e.printStackTrace();
			}
			try {
			  
				ConnectionToMySQL co = new ConnectionToMySQL();
				ResultSet rs1 = co.s.executeQuery("select * from comments1021");
				while(rs1.next()) {
					comments = rs1.getString("emp_id")+""+rs1.getString("comments")+""+rs1.getString("date");
					
				}
			}catch (Exception e1) {
				e1.printStackTrace();
			}
				f= new JFrame("Regulation Status");
				f.setVisible(true);
				f.setSize(900, 500);
				f.setLocation(450,642);
				f.setBackground(Color.white);
				f.setLayout(null);
				
				id9 = new JLabel();
				id9.setBounds(0, 0, 900, 500);
				id9.setLayout(null);
				ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/rl_status.jpeg"));
				id9.setIcon(img);
				
				id8 = new JLabel("Regulation Status");
				id8.setBounds(320, 20, 250, 40);
				id8.setForeground(Color.WHITE);
				f.add(id8);
				id8.setFont(new Font("serif",Font.BOLD,25));
				id9.add(id8);
				f.add(id9);
				
				id = new JLabel("RL Id:");
				id.setBounds(15, 20, 75, 30);
				id.setForeground(Color.WHITE);
				id.setFont(new Font("serid",Font.BOLD,10));
				id.add(id);
				
				aid = new JLabel(rl_id);
				aid.setBounds(100, 20, 90, 30);
				aid.setForeground(Color.WHITE);
				aid.setFont(new Font("serif",Font.BOLD,10));
				id9.add(aid);
				
				id1 = new JLabel("RLType:");
				id1.setBounds(15, 70, 75, 30);
				id1.setForeground(Color.WHITE);
				id1.setFont(new Font("serif",Font.BOLD,10));
				id9.add(id1);
				
				aid1 = new JLabel(rl_type);
				aid1.setBounds(100, 70, 90, 30);
				aid1.setForeground(Color.WHITE);
				aid1.setFont(new Font("serif",Font.BOLD,10));
				id9.add(aid1);
				
				id2 = new JLabel("RL Date:");
				id2.setBounds(15,120,75,30);
				id2.setForeground(Color.WHITE);
				id2.setFont(new Font("serif",Font.BOLD,10));
				id9.add(id2);
				
				aid2 = new JLabel(creation_date);
				aid2.setBounds(100, 120, 90, 30);
				aid2.setForeground(Color.WHITE);
				aid2.setFont(new Font("serif",Font.BOLD,10));
				id9.add(aid2);
				
				id3 = new JLabel("Dept ID:");
				id3.setBounds(15, 170, 75, 30);
				id3.setForeground(Color.WHITE);
				id3.setFont(new Font("serif",Font.BOLD,10));
				id9.add(id3);
				
				aid3 = new JLabel(dept_id);
				aid3.setBounds(100, 170, 90, 30);
				aid3.setForeground(Color.WHITE);
				aid3.setFont(new Font("serif",Font.BOLD,10));
				id9.add(aid3);
				
				id4 = new JLabel("COMMENTS: (Order: Emp_Id,Comment, Date");
				id4.setBounds(200, 100, 450, 30);
				id4.setForeground(Color.BLACK);
				id4.setFont(new Font("serif",Font.BOLD,10));
				id9.add(id4);
				
				aid4  = new JLabel(comments);
				aid4.setBounds(200, 150, 675, 350);
				aid4.setForeground(Color.BLACK);
				aid4.setFont(new Font("serif",Font.ITALIC,20));
				id9.add(aid4);
				
				b1  = new JButton("Print");
				b1.setBackground(Color.BLACK);
				b1.setForeground(Color.WHITE);
				b1.setBounds(30, 500, 100, 30);
				b1.addActionListener(this);
				id9.add(b1);
				
				b2 = new JButton("Back");
				b2.setBackground(Color.BLACK);
				b2.setForeground(Color.WHITE);
				b2.setBounds(200, 500, 100, 30);
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
	 			JOptionPane.showMessageDialog(null, "Printed Successfully");
	 			f.setVisible(false);
	 			admin a = new admin();
	 		}
	 		if(ae.getSource()==b2) {
	 			f.setVisible(false);
	 			new Search_RL();
	 		}
	 		if(ae.getSource()==b3);
	 			f.setVisible(false);
	 			new Front_Page();
	 	}
		
	 	public static void main(String[] ar) {
			new RL_Status();
		}
		}






