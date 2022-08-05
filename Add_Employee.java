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

class Add_Employee implements ActionListener{
	
	JFrame f;
	JLabel 	id1,id2,id3,id4,id5,id6,id8,id15;
	JTextField t1,t2,t3,t4,t5,t6;
	JButton b,b1,b2,b3;
	
	 Add_Employee(int i) {
		 f =new JFrame("Add Employee");
		 f.setBackground(Color.WHITE);
		 f.setLayout(null);
		 
		 id15 =new JLabel();
		 id15.setBounds(0, 0, 900, 700);
		 id15.setLayout(null);
		 ImageIcon img =new
		ImageIcon(ClassLoader.getSystemResource("Employee/icons/add_employee.jpeg"));
		id15.setIcon(img);
		
		id8 =new JLabel("Add Employee");
		id8.setBounds(340, 20, 500, 50);
		id8.setFont(new Font("serif",Font.BOLD,25));
		id8.setForeground(Color.white);
		id15.add(id8);
		f.add(id15);
		
		id1 =new JLabel("Employee Id");
		id1.setBounds(110, 120, 100, 30);
		id1.setFont(new Font("serif",Font.BOLD,20));
		id15.add(id1);
		
		t1 =new JTextField();
		t1.setBounds(230, 120, 150, 30);
		id15.add(t1);
		
		id2 =new JLabel("First Name");
		id2.setBounds(110, 120, 100, 30);
		id2.setFont(new Font("serif",Font.BOLD,20));
		id15.add(id2);
		
		t2 =new JTextField();
		t2.setBounds(230, 170, 150, 30);
		id15.add(t2);
		
		id3 =new JLabel("Last Name");
		id3.setBounds(110, 120, 100, 30);
		id3.setFont(new Font("serif",Font.BOLD,20));
		id15.add(id3);
		
		t3 =new JTextField();
		t3.setBounds(230, 220, 150, 30);
		id15.add(t3);
		
		id4 =new JLabel("Date of Birth");
		id4.setBounds(110, 320, 200, 30);
		id4.setFont(new Font("serif",Font.BOLD,20));
		id15.add(id4);
		
		t4 =new JTextField();
		t4.setBounds(230, 320, 150, 30);
		id15.add(t4);
		
		id5 =new JLabel("Email");
		id5.setBounds(110, 370, 100, 30);
		id5.setFont(new Font("serif",Font.BOLD,20));
		id15.add(id5);
		
		t5 =new JTextField();
		t5.setBounds(230, 370, 150, 30);
		id15.add(t5);
		
		id6 =new JLabel("Department");
		id6.setBounds(110, 420, 100, 30);
		id6.setFont(new Font("serif",Font.BOLD,20));
		id15.add(id6);
		
		t6 =new JTextField();
		t6.setBounds(230, 420, 150, 30);
		id15.add(t6);
		
		b =new JButton("Add");
		b.setBackground(Color.BLACK);
		b.setForeground(Color.WHITE);
		b.setBounds(250, 650, 150, 40);
		
		id15.add(b);
		
		b1 =new JButton("Back");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(450, 650, 150, 40);
		
		id15.add(b1);
		
		b2 =new JButton("Logout");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(780, 650, 170, 40);
		
		id15.add(b2);
		
		b.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		f.setVisible(true);
		f.setSize(900,700);
		f.setLocation(400, 150);
		
	}

	 public Add_Employee() {
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent ae) {
		 
		 String a= t1.getText();
		 String bb= t2.getText();
		 String c= t3.getText();
		 String d= t4.getText();
		 String e= t5.getText();
		 String ff= t6.getText();
		 
		 if(ae.getSource()==b) {
			 	try {
			 				ConnectionToMySQL cc = new ConnectionToMySQL();
			 				String q= "insert into employees values("+a+","+bb+","
			 						+c+","+d+","+e+","+ff+")";
			 					cc.s.executeUpdate(q);
			 					JOptionPane.showMessageDialog(null, "Details Successfully Inserted");
			 					f.setVisible(false);
			 					new admin();
			 	}catch (Exception ee) {
			 		System.out.println("This error is"+ee);
			 	
				}
		 }else if(ae.getSource()==b1);
		 		f.setVisible(false);
		 		new admin();
		 		{
	 		}		
	 		if(ae.getSource()==b2);
	 		f.setVisible(false);
	 		new Front_Page();
	 		}
			public static void main(String[] arg) {
				Add_Employee a= new Add_Employee();			
			}
	}
