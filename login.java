package Employee;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class login implements ActionListener{
	
	private static final String esle = null;
	JFrame f;
	JLabel l1,l2;
	JTextField t1;
	JPasswordField t2;
	JButton b1,b2,b3;
	
	login(){
		f=new JFrame("Login");
		
		f.setBackground(Color.white);
		f.setLayout(null);
		
		l1=new JLabel("Username");
		l1.setBounds(40, 20, 100, 30);;
		f.add(l1);
		
		l2=new JLabel("Password");
		l2.setBounds(40, 70, 100, 30);
		f.add(l2);
		
		t1=new JTextField();
		t1.setBounds(150, 20, 150, 30);
		f.add(t1);
		
		t2=new JPasswordField();
		t2.setBounds(150, 70, 150, 30);
		f.add(t2);
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("Employee/icons/login.jpeg"));
		Image i2= i1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
		JLabel l3 = new JLabel(i3);
		l3.setBounds(350, 20, 150, 150);
		f.add(l3);
		
		b1 =new JButton("Admin Login");
		b1.setBounds(40, 140, 120, 30);
		b1.setFont(new Font("Serif",Font.BOLD,15));
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		f.add(b1);
		
		b2 =new JButton("Employee Login");
		b2.setBounds(180, 140, 120, 30);
		b2.setFont(new Font("Serif",Font.BOLD,15));
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		f.add(b2);
		
		b2.addActionListener(this);
		
		b3 =new JButton("Logout");
		b3.setBounds(180, 140, 120, 30);
		b3.setFont(new Font("serif",Font.BOLD,15));
		b3.setBackground(Color.RED);
		b3.setBackground(Color.WHITE);
		f.add(b3);
		
		b3.addActionListener(this);
		
		f.getContentPane().setBackground(Color.WHITE);
		
		f.setVisible(true);
		f.setSize(600,300);
		f.setLocation(400, 300);
		
	}
	
		@SuppressWarnings("depreaction")
		public void actionPerformed(ActionEvent ae) {
			
			try {
				ConnectionToMySQL c1=new ConnectionToMySQL();
				String u=t1.getText();
				String v=t2.getText();
				
				String q="select*from login where username"+u+"and pasword="+v+"";
				String r="select*from emp_login where username="+u+"and password="+v+"";
				ResultSet rs1=c1.s.executeQuery(q);
				ResultSet rs2=c1.s.executeQuery(r);
				if(ae.getSource()==b1) {
						if(rs1.next()) {
								new admin().f.setVisible(true);
								f.setVisible(false);
						}else {
								JOptionPane.showMessageDialog(null, "Invalid login");
								f.setVisible(false);
			
						}
				}
					if(ae.getSource()==b2) {
						if(rs2.next()) {
								new emp_account().f.setVisible(true);
								f.setVisible(false);
						}else{	
							JOptionPane.showMessageDialog(null, "Invalid login");
							f.setVisible(false);
						}
							if(ae.getSource()==b3) {
								f.setVisible(false);
								new Front_Page();
						}
					}
					}catch (Exception e) {
						e.printStackTrace();
					}
			}
			public static void main(String[] arg) {
					login l =new login();
				
	}

}
