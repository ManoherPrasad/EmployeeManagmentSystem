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

class Edit_Employee implements ActionListener{

		JFrame f;
		JLabel id_emp,id1,id2,id3,id4,id5,id6,id8,id15;
		JTextField t,t1,t2,t3,t4,t5,t6;
		JButton b1,b2,b3;
		String id_emp;
		
		 Edit_Employee(String idaa) {
			 super(0);
			 f=new JFrame("Edit Employee Details:");
			 f.setVisible(true);
			 f.setSize(900, 500);
			 f.setLocation(450, 250);
			 f.setBackground(Color.white);
			 f.setLayout(null);
			 
			 id_emp = idaa;
			 id15=new JLabel();
			 id15.setBounds(0, 0, 900, 500);
			 id15.setLayout(null);
			 ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Employees/icons/edit_employees.jpeg"));
			 id15.setIcon(img);
			 
			 id8 = new JLabel("Edit Employee Details:");
			 id8.setBounds(340, 20, 500, 50);
			 id8.setFont(new Font("serif",Font.BOLD,40));
			 id8.setForeground(Color.white);
			 id15.add(id8);
			 f.add(id15);
			 
			 id1 = new JLabel("Employee Id:");
			 id1.setBounds(290, 150, 100, 30);
			 id1.setFont(new Font("serif",Font.BOLD,20));
			 id15.add(id1);
			 
			 t1 = new JTextField();
			 t1.setBounds(400,150,150,30);
			 id15.add(t1);
			 
			 id2 = new JLabel("First Name:");
			 id2.setBounds(290,200,100,30);
			 id2.setFont(new Font("serif",Font.BOLD,20));
			 id15.add(id2);
			 
			 t2 = new JTextField();
			 t2.setBounds(400,200,150,30);
			 id15.add(t2);
			 
			 id3 = new JLabel("Last Name:");
			 id3.setBounds(290,250,100,30);
			 id3.setFont(new Font("serif",Font.BOLD,20));
			 id15.add(id3);
			 
			 t3 = new JTextField();
			 t3.setBounds(400,250,100,30);
			 id15.add(t3);
			 
			 id4 = new JLabel("Date of Birth:");
			 id4.setBounds(290,300,100,30);
			 id4.setFont(new Font("serif",Font.BOLD,20));
			 id15.add(id4);
			 
			 t4 = new JTextField();
			 t4.setBounds(400,300,150,30);
			 id15.add(t4);
			 
			 id5 = new JLabel("Email:");
			 id5.setBounds(290,350,100,30);
			 id5.setFont(new Font("serif",Font.BOLD,20));
			 id15.add(id5);
			 
			 t5 = new JTextField();
			 t5.setBounds(400,350,150,30);
			 id15.add(t5);
			 
			 id6 = new JLabel("Department:");
			 id6.setBounds(290,400,100,30);
			 id6.setFont(new Font("serif",Font.BOLD,20));
			 id15.add(id6);
			 
			 t6 = new JTextField();
			 t6.setBounds(400,400,150,30);
			 id15.add(t6);
			 
			 b1 = new JButton("Update");
			 b1.setBounds(290,450,100,30);
			 b1.setBackground(Color.BLACK);
			 b1.setForeground(Color.WHITE);
			 b1.addActionListener(this);
			 id15.add(b1);
			 
			 b2 = new JButton("Back");
			 b2.setBounds(510,450,100,30);
			 b2.setBackground(Color.BLACK);
			 b2.setForeground(Color.WHITE);
			 b2.addActionListener(this);
			 id15.add(b2);
			 
			 b3 = new JButton("Logout");
			 b3.setBounds(780,450,100,30);
			 b3.setBackground(Color.BLACK);
			 b3.setForeground(Color.WHITE);
			 b3.addActionListener(this);
			 id15.add(b3);
			 
			 showData(idaa);
			 
			 }
		 	int	i=0;
		 		
	 		void showData(String s) {
	 			try {
	 				ConnectionToMySQL con = new ConnectionToMySQL();
		 			String str ="select*from employees where emp_id="+s+"";						
		 			ResultSet rs = con.s.executeQuery(str);
		 							
		 				if(rs.next()) {
		 					f.setVisible(true);
		 					i=1;
		 							
		 					t1.setText(rs.getString(1));
							t2.setText(rs.getString(2));
		 					t3.setText(rs.getString(3));
		 					t4.setText(rs.getString(4));
		 					t5.setText(rs.getString(5));
							t6.setText(rs.getString(6));
		
		 				}
		 				if(i==0)
		 					JOptionPane.showMessageDialog(null,"id not found");
		 				new Search_Edit();
	 			}catch (Exception ex) {}
	 			f.setVisible(true);
	 			f.setSize(900,500);
	 			f.setLocation(400,100);
	 		}
	 		public void actionPerformed(ActionEvent ae) {
	 					if(ae.getSource()==b1 && i==1);
	 					try{
	 						ConnectionToMySQL con = new ConnectionToMySQL();
	 						String str ="update employees set emp_id="+t1.getText()+",fname="+t2.getText()+
	 								",lname="+t3.getText()+",dob="+t4.getText()+",email="+t5.getText()+",department="+t6.getText()+"where emp_id="+id_emp+"";
	 								con.s.executeUpdate(str);
	 								JOptionPane.showMessageDialog(null,"Successfully updated");
	 								f.setVisible(false);
	 								Search_Edit se = new Search_Edit();
	 							}catch (Exception e) {
									System.out.println("This error is:"+e);
								}
	 		}
						{
							
						
	 					if(ae.getSource()==b2) {
	 						f.setVisible(false);
	 						admin a = new admin();	
	 					}
	 					if(ae.getSource()==b3) {
	 						f.setVisible(false);
	 						Front_Page f = new Front_Page();
	 					
	 				}
						}
						public static void main(String[] arg) {
								new Edit_Employee("Edit Employee");
								
						}
}
