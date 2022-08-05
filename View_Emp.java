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

class View_Emp implements ActionListener{
	
	JFrame f;
	JLabel id8,id,aid,id1,aid1,id2,aid2,id3,aid3,id4,aid4,id5,aid5,id9;
	String emp_id,fname,lname,dob,email,departemnt;
	JButton b1,b2,b3;
	ImageIcon icon;
	
	View_Emp(String e_id){
			try {
					ConnectionToMySQL con =new ConnectionToMySQL();
					String str ="select*from employees where emp_id="+e_id+"";
					ResultSet rs =con.s.executeQuery(str);
					
					while(rs.next()) {
						
						emp_id = rs.getString("emp_id");
						fname = rs.getString("fname");
						lname = rs.getString("lname");
						dob = rs.getString("dob");
						email = rs.getString("email");
						department = rs.getString("department");
						
					}
			}catch(Exception e) {
				e.printStackTrace();
			}
		
				f = new JFrame("View Employee");
				f.setVisible(true);
				f.setSize(800,450);
				f.setLocation(450, 642);
				f.setBackground(Color.white);
				f.setLayout(null);
				
				id9 = new JLabel();
				id9.setBounds(0, 0, 800, 400);
				id9.setLayout(null);
				ImageIcon img = new 
						ImageIcon(ClassLoader.getSystemResource("Employee/icons/view_emp.jpeg"));
				id9.setIcon(img);
				
				id8 = new JLabel("View Employee Details");
				id8.setBounds(300, 20, 450, 30);
				f.add(id8);
				id8.setFont(new Font("serif",Font.BOLD,25));
				id9.add(id8);
				f.add(id9);
				
				id = new JLabel("Employee Id:");
				id.setBounds(50, 70, 120, 30);
				id.setFont(new Font("serif",Font.BOLD,20));
				id9.add(id);
				
				aid = new JLabel(emp_id);
				aid.setBounds(180, 70, 200, 30);
				aid.setFont(new Font("serif",Font.BOLD,20));
				id9.add(aid);
				
				id1 = new JLabel("First Name:");
				id1.setBounds(50, 120, 100, 30);
				id1.setFont(new Font("serif",Font.BOLD,20));
				id9.add(id1);
				
				aid1 = new JLabel("fname");
				aid1.setBounds(180, 120, 300, 30);
				aid1.setFont(new Font("serif",Font.BOLD,20));
				id9.add(aid1);
				
				id2 = new JLabel("Last Name:");
				id2.setBounds(50, 170, 200, 30);
				id2.setFont(new Font("serif",Font.BOLD,20));
				id9.add(id2);
				
				aid2 = new JLabel("lname");
				aid2.setBounds(180, 170, 300, 30);
				aid2.setFont(new Font("serif",Font.BOLD,20));
				id9.add(aid2);
				
				id3 = new JLabel("Date of Birth:");
				id3.setBounds(50, 270, 100, 30);
				id3.setFont(new Font("serif",Font.BOLD,20));
				id9.add(id3);
				
				aid3 = new JLabel("dob");
				aid3.setBounds(180, 270, 300, 30);
				aid3.setFont(new Font("serif",Font.BOLD,20));
				id9.add(aid3);
				
				id4 = new JLabel("Email");
				id4.setBounds(50, 320, 100, 30);
				id4.setFont(new Font("serif",Font.BOLD,20));
				id9.add(id4);
				
				aid4 = new JLabel("email");
				aid4.setBounds(180, 320, 300, 30);
				aid4.setFont(new Font("serif",Font.BOLD,20));
				id9.add(aid4);
				
				id5 = new JLabel("Departmenet:");
				id5.setBounds(50, 370, 100, 30);
				id5.setFont(new Font("serif",Font.BOLD,20));
				id9.add(id5);
				
				aid5 = new JLabel("department");
				aid5.setBounds(180, 370, 300, 30);
				aid5.setFont(new Font("serif",Font.BOLD,20));
				id9.add(aid5);
				
				b1 = new JButton("Print");
				b1.setBounds(280, 400, 100, 30);
				b1.setBackground(Color.BLACK);
				b1.setForeground(Color.WHITE);
				b1.addActionListener(this);
				id9.add(b1);
				
				b2 = new JButton("Back");
				b2.setBounds(280, 400, 100, 30);
				b2.setBackground(Color.BLACK);
				b2.setForeground(Color.WHITE);
				b2.addActionListener(this);
				id9.add(b2);
				
				b3 = new JButton("Logout");
				b3.setBounds(680, 400, 100, 30);
				b3.setBackground(Color.BLACK);
				b3.setForeground(Color.WHITE);
				b3.addActionListener(this);
				id9.add(b3);
	}

		public void actionPerformed(ActionEvent ae) {
			
			if(ae.getSource()==b1) {
					JOptionPane.showMessageDialog(null,"Printed Sucessfully");
					f.setVisible(false);
					admin a = new admin();
					{
			}
		}
		if(ae.getSource()==b2) {
				f.setVisible(false);
				new Search_View();
		}
		if(ae.getSource()==b3) {
				f.setVisible(false);
				new Front_Page();
		}
			
		}
		public static void main(String[] args) {
					new View_Emp();
		}
}