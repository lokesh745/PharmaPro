import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class HOMEPAGE{
	public JButton Customer;
	
	HOMEPAGE(){
		JFrame f= new JFrame();
		f.getContentPane().setBackground(new Color(255, 255, 255));
	    f.setTitle("MEDICAL STORE MANAGEMENT SYSTEM: HOME");
	    f.setBounds(100, 100, 1000, 700);
		f.setLocationRelativeTo(null);
		f.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setForeground(new Color(255, 182, 193));
		panel.setBounds(10, 241, 254, 399);
		f.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton Medicine = new JButton("Manage Medicine");
		Medicine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				f.setVisible(false);
		  		new MEDICINE();
		  		
			}
		});
		Medicine.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		Medicine.setBounds(10, 11, 234, 33);
		panel.add(Medicine);
		
		JButton LogOut = new JButton("Log Out");
		LogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//JOptionPane.showMessageDialog(null, "Are you sure you want to LOG OUT");
				int result = JOptionPane.showConfirmDialog(null,
				        "Are you sure you want to logout?",
				        "Confirm logout", JOptionPane.YES_NO_CANCEL_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					//System.exit(0);
					f.setVisible(false);
			  		new LOGINPAGE();	
				}
				
				
			}
		});
		LogOut.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		LogOut.setBounds(10, 365, 234, 34);
		panel.add(LogOut);
		
		JButton Company = new JButton("Manage Company");
		Company.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				f.setVisible(false);
		  		new COMPANY();
				
			}
		});
		Company.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		Company.setBounds(10, 68, 234, 33);
		panel.add(Company);
		
		Customer = new JButton("Manage Customer");
		Customer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				f.setVisible(false);
		  		new CUSTOMER();
				
			}
		});
		Customer.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		Customer.setBounds(10, 127, 234, 33);
		panel.add(Customer);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(10, 11, 254, 219);
		f.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel(" ");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Shreyas\\Documents\\Mini Project-Medical Management System\\Pics\\glass.jpeg"));
		lblNewLabel_1.setBounds(10, 11, 234, 197);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Shreyas\\Documents\\Mini Project-Medical Management System\\Pics\\globe.jpeg"));
		lblNewLabel.setBounds(270, 11, 669, 219);
		f.getContentPane().add(lblNewLabel);
		f.setVisible(true);
		
	}

	
	public static void main(String[] args) {
		new HOMEPAGE();
		
	}
}
