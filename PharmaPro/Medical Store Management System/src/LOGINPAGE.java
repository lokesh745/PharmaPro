import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class LOGINPAGE {
	public JTextField txtusername;
	public JPasswordField txtpassword;
	LOGINPAGE(){ //I am using this to call the constructor which I  HAVE DIFINED NOT THE DEFAULT ONE.
		 JFrame f= new JFrame();
		 f.getContentPane().setBackground(new Color(138, 43, 226));
		 f.getContentPane().setForeground(new Color(123, 104, 238));
		  f.setTitle("MEDICAL STORE MANAGEMENT SYSTEM: LOGIN");
		  f.setBounds(100, 100, 1000, 700);
		  f.setLocationRelativeTo(null);
		  f.getContentPane().setLayout(null);
		  
		  JPanel panel = new JPanel();
		  panel.setBounds(641, 0, 343, 326);
		  f.getContentPane().add(panel);
		  panel.setLayout(null);
		  
		  JLabel lblNewLabel = new JLabel("");
		  lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Shreyas\\Documents\\Mini Project-Medical Management System\\Pics\\logo.jpeg"));
		  lblNewLabel.setBounds(20, 11, 323, 305);
		  panel.add(lblNewLabel);
		  
		  JLabel lblNewLabel_5 = new JLabel("");
		  lblNewLabel_5.setBounds(0, 0, 46, 14);
		  panel.add(lblNewLabel_5);
		  
		  JLabel lblNewLabel_1 = new JLabel("   MEDICAL STORE MANAGEMENT SYSTEM");
		  lblNewLabel_1.setBounds(46, 27, 549, 42);
		  f.getContentPane().add(lblNewLabel_1);
		  lblNewLabel_1.setForeground(new Color(255, 255, 255));
		  lblNewLabel_1.setFont(new Font("Lucida Handwriting", Font.PLAIN, 24));
		  lblNewLabel_1.setBackground(Color.WHITE);
		  
		  JPanel panel_1 = new JPanel();
		  panel_1.setBounds(641, 324, 343, 337);
		  f.getContentPane().add(panel_1);
		  panel_1.setLayout(null);
		  
		  JLabel lblNewLabel_2 = new JLabel("");
		  lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Shreyas\\Documents\\Mini Project-Medical Management System\\Pics\\pills.jpeg"));
		  lblNewLabel_2.setBounds(10, 0, 323, 326);
		  panel_1.add(lblNewLabel_2);
		  
		  JPanel panel_2 = new JPanel();
		  panel_2.setBackground(new Color(147, 112, 219));
		  panel_2.setForeground(new Color(255, 255, 255));
		  panel_2.setBounds(89, 337, 467, 228);
		  f.getContentPane().add(panel_2);
		  panel_2.setLayout(null);
		  
		  JLabel Username = new JLabel("USERNAME");
		  Username.setForeground(new Color(255, 255, 255));
		  Username.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		  Username.setBounds(41, 35, 134, 25);
		  panel_2.add(Username);
		  
		  JLabel Password = new JLabel("PASSWORD");
		  Password.setForeground(new Color(255, 255, 255));
		  Password.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		  Password.setBounds(41, 88, 134, 25);
		  panel_2.add(Password);
		  
		  txtusername = new JTextField();
		  txtusername.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		  txtusername.setBounds(217, 35, 198, 23);
		  panel_2.add(txtusername);
		  txtusername.setColumns(10);
		  
		  txtpassword = new JPasswordField();
		  txtpassword.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		  txtpassword.setColumns(10);
		  txtpassword.setBounds(217, 89, 198, 22);
		  panel_2.add(txtpassword);
		  
		  JButton Login = new JButton("LOGIN");
		  Login.setBackground(UIManager.getColor("Button.light"));
		  Login.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent arg0) {
		  		
		  		 String uname=txtusername.getText();
		  		 String pwd=txtpassword.getText();
		  		 
		  		 System.out.println("Testing of uname and pwd--->"+uname+" "+pwd);
		  		 
		  		 if(uname.equals("Mini Project") && pwd.equals("123456")) {
		  			//Logic to move from one page to another.
				  		f.setVisible(false);
				  		new HOMEPAGE();
		  		 }
		  		 else {
		  			 JOptionPane.showMessageDialog(null, "Username or Password is Incorrect");
		  		 }
		  			 
		  		
		  		
		  	
		  	}
		  });
		  Login.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		  Login.setBounds(189, 177, 89, 23);
		  panel_2.add(Login);
		  
		  JCheckBox chckbxShowPassword = new JCheckBox("Show Password");
		  chckbxShowPassword.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		  chckbxShowPassword.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		if(chckbxShowPassword.isSelected())
		  		{
		  		    txtpassword.setEchoChar((char)0);
		  		}else
		  		{
		  			txtpassword.setEchoChar('*');
		  		}
		  	}
		  });
		  chckbxShowPassword.setBounds(217, 118, 114, 21);
		  panel_2.add(chckbxShowPassword);
		  
		  JLabel lblNewLabel_4 = new JLabel("");
		  lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Shreyas\\Documents\\Mini Project-Medical Management System\\Pics\\globe.jpeg"));
		  lblNewLabel_4.setBounds(10, 91, 621, 228);
		  f.getContentPane().add(lblNewLabel_4);
		  f.setVisible(true);
	}
	 
	

	public static void main(String[] args) {
		new LOGINPAGE(); 
		
	}
}
