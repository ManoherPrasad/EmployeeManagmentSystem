package Employee;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

 class Search_RL_Comments implements ActionListener{
	 
	 JFrame f;
	 JTextField t;
	 JLabel l1,l2;
	 JButton b1,b2,b3;
	 
	 Search_RL_Comments() {
		 
		 f = new JFrame("Search RL Comments");
		 f.setBackground(Color.green);
		 f.setLayout(null);
		 
		 l1 = new JLabel();
		 l1.setBounds(0, 0, 500, 270);
		 l1.setLayout(null);
		 ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/search_rl_comments"));
		 l1.setIcon(img);
		 
		 l2 = new JLabel("Regulation Id");
		 l2.setVisible(true);
		 l2.setBounds(20, 130, 200, 30);
		 l2.setForeground(Color.black);
		 Font F1 = new Font("serif",Font.BOLD,30);
		 l2.setFont(F1);
		 l1.add(l2);
		 f.add(l1);
		 
		 t = new JTextField();
		 t.setBounds(130, 130, 220, 30);
		 l1.add(t);
		 
		 b1 = new JButton("Search");
		 b1.setBounds(125, 210, 100, 60);
		 b1.setBackground(Color.BLACK);
		 b1.setForeground(Color.WHITE);
		 b1.addActionListener(this);
		 l1.add(b1);
		 
		 b2 = new JButton("Back");
		 b2.setBounds(260, 210, 100, 60);
		 b2.setBackground(Color.BLACK);
		 b2.setForeground(Color.WHITE);
		 b2.addActionListener(this);
		 l1.add(b2);
		 
		 b3 = new JButton("Logout");
		 b3.setBounds(430, 210, 100, 60);
		 b3.setBackground(Color.BLACK);
		 b3.setForeground(Color.WHITE);
		 b3.addActionListener(this);
		 l1.add(b3);
		 
		 f.setVisible(true);
		 f.setSize(500, 270);
		 f.setLocation(450, 250);
		 
		 }
	 	
	 public void actionPerformed(ActionEvent ae) {
		 
		 	if(ae.getSource()==b1) {
		 		f.setVisible(false);
		 		Update_Comments uc = new Update_Comments(t.getText());
		 	}
		 	if(ae.getSource()==b2) {
		 		f.setVisible(false);
		 		new admin();
		 	}
		 	if(ae.getSource()==b3) {
		 		f.setVisible(false);
		 		new Front_Page();
		 	}
		 	public static void main(String[] arg) {
		 		Search_RL_Comments sr = new Search_RL_Comments();
		 	}
}
	 
 }

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 