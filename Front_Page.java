package Employee;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

 class Front_Page implements ActionListener{
	
	JFrame f;
	JLabel l1;
	JButton b;
	
	 Front_Page() {
		
		 f=new JFrame("Front");
		 f.setBackground(Color.red);
		 f.setLayout(null);
		 
		 l1=new JLabel();
		 l1.setBounds(0, 150, 1360, 530);
		 l1.setLayout(null);
		 ImageIcon img=new ImageIcon(ClassLoader.getSystemResource(null));
		 l1.setIcon(img);
		 
		 b=new JButton("Login");
		 b.setBounds(500, 500, 300, 70);
		 b.setForeground(Color.WHITE);
		 b.setBackground(Color.BLACK);
		 b.addActionListener(this);
		 l1.add(b);
		 f.add(l1);
		 
		 f.setVisible(true);
		 f.setSize(1360,750);
		 f.setLocation(200, 100);
		
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==b) {
			f.setVisible(false);
//			new login();
		}
		
	}
	
		public static void main(String[] arg) {
			Front_Page f=new Front_Page();
		}

	
}
