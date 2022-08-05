package Employee;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class Search_View implements ActionListener{
	
	JFrame f;
	JTextField t;
	JLabel l1,l2;
	JButton b1,b2,b3;
	
	 Search_View() {
		 	f =new JFrame("Search View");
		 	f.setBackground(Color.green);
		 	f.setLayout(null);
		 	
		 	l1 =new JLabel();
		 	l1.setBounds(0, 0, 500, 270);
		 	l1.setLayout(null);
		 	ImageIcon img =new ImageIcon(ClassLoader.getSystemResource("Employee/icons/search_view.jpeg"));
		 	l1.setIcon(img);
		 	
		 	l2 =new JLabel("Employee Id");
		 	l2.setVisible(true);
		 	
		 	l2.setBounds(20, 130, 200, 30);
		 	l2.setForeground(Color.BLACK);
		 	Font F1=new Font("serif",Font.BOLD,30);
		 	l2.setFont(F1);
		 	l1.add(l2);
		 	f.add(l1);
		 	
		 	t =new JTextField();
		 	t.setBounds(130, 130, 200, 30);
		 	l1.add(t);
		 	
		 	b1 =new JButton("View");
		 	b1.setBounds(125, 210, 100, 60);
		 	b1.setBackground(Color.BLACK);
		 	b1.setForeground(Color.WHITE);
		 	b1.addActionListener(this);
		 	l1.add(b1);
		 	
		 	b2 =new JButton("Back");
		 	b2.setBounds(260, 210, 100, 60);
		 	b2.setBackground(Color.BLACK);
		 	b2.setForeground(Color.WHITE);
		 	b2.addActionListener(this);
		 	l1.add(b2);
		 	
		 	b3 =new JButton("Logout");
		 	b3.setBounds(430, 210, 100, 60);
		 	b3.setBackground(Color.RED);
		 	b3.setForeground(Color.WHITE);
		 	b3.addActionListener(this);
		 	l1.add(b3);
		 	
		 	f.setSize(500,270);
		 	f.setLocation(450, 250);
		 	f.setVisible(true);
	}
	 	
	 public void actionPerformed(ActionEvent ae) {
		 	
		 	if(ae.getSource()==b1) {
		 		f.setVisible(false);
		 		View_Emp v =new View_Emp(t.getText());
		 		
		 	}
		 	if(ae.getSource()==b2) {
		 		f.setVisible(false);
		 		new admin();
		 	}
		 	if(ae.getSource()==b3) {
		 		f.setVisible(false);
		 		new Front_Page();
		 	}
		 	
		 	public static Void main(String[] ar) {
		 		Search_View sv =new Search_View();
		 	}
	 }
}
