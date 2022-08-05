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

class Create_RL implements ActionListener{
	
	JFrame f;
	JLabel id1,id2,id3,id4,id5,id8,id15;
	JTextField t1,t2,t3,t4,t5;
	JButton b,b1,b2;
	
	 Create_RL() {
		f = new JFrame("Create Regulation");
		f.setBackground(Color.white);
		f.setLayout(null);
		
		id15 = new JLabel();
		id15.setBounds(0, 0, 800, 500);
		id15.setLayout(null);
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/create_rl.jpeg"));
		id15.setIcon(img);
		
		id8 = new JLabel("Create Regulation");
		id8.setBounds(350, 20, 200, 50);
		id8.setFont(new Font("serif",Font.BOLD,25));
		id8.setForeground(Color.white);
		id15.add(id8);
		f.add(id15);
		
		id1 = new JLabel("Regulation Id:");
		id1.setBounds(320, 90, 100, 30);
		id1.setFont(new Font("serif",Font.BOLD,15));
		id15.add(id1);
		
		t1 = new JTextField();
		t1.setBounds(440, 90, 300, 30);
		id15.add(t1);
		
		id2 = new JLabel("Regulation Type:");
		id2.setBounds(320, 140, 150, 30);
		id2.setFont(new Font("serif",Font.BOLD,20));
		id15.add(id2);
		
		t2 = new JTextField();
		t2.setBounds(440, 140, 300, 30);
		id15.add(t2);
		
		id3 = new JLabel("RL Details:");
		id3.setBounds(320, 190, 150, 30);
		id3.setFont(new Font("serif",Font.BOLD,20));
		id15.add(id3);
		
		t3 = new JTextField();
		t3.setBounds(440, 190, 300, 120);
		id15.add(t3);
		
		id4 = new JLabel("Creation Date:");
		id4.setBounds(320, 360, 150, 30);
		id4.setFont(new Font("serif",Font.BOLD,20));
		id15.add(id4);
		
		t4 = new JTextField();
		t4.setBounds(440, 360, 300, 30);
		id15.add(t4);
		
		id5 = new JLabel("Departemnt Id:");
		id5.setBounds(320, 410, 150, 30);
		id5.setFont(new Font("serif",Font.BOLD,20));
		id15.add(id5);
		
		t5 = new JTextField();
		t5.setBounds(440, 410, 180, 30);
		id15.add(t5);
		
		b = new JButton("Create");
		b.setBackground(Color.BLACK);
		b.setForeground(Color.WHITE);
		b.setBounds(30, 450, 100, 40);
		id15.add(b);
		
		b1 = new JButton("Back");
		b1.setBounds(160, 450, 100, 40);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		id15.add(b1);
		
		b2 = new JButton("Logout");
		b2.setBounds(680, 450, 100, 40);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		id15.add(b2);
		
		b.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		f.setVisible(true);
		f.setSize(800,500);
		f.setLocation(400, 150);
	}
	 public void actionPerformed(ActionEvent ae) {
		 
		 String hh = t1.getText();
		 String ii = t2.getText();
		 String jj = t3.getText();
		 String kk = t4.getText();
		 String mm = t5.getText();
		 
		 if(ae.getSource()==b) {
			 try {
				 ConnectionToMySQL con= new ConnectionToMySQL();
				 String n ="Insert into regulation values("+hh+","+ii+","+jj+","+kk+","+mm+")";
				 con.s.executeQuery(n);
				 JOptionPane.showMessageDialog(null,"Regulation Successfully created");
				 f.setVisible(false);
				 new admin();
				 
			 }catch (Exception ee) {
				System.out.println("The error is:"+ee);
			}
		 }else if(ae.getSource()==b1) {
			 f.setVisible(false);
			 new admin();
		 }
		 if(ae.getSource()==b2) {
			 f.setVisible(false);;
			 new Front_Page();
		 }
}
	 public static void main(String[] arg) {
		 Create_RL cr = new Create_RL();
	 }
}













































