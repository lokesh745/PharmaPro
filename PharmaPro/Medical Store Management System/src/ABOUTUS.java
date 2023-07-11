import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ABOUTUS {

	ABOUTUS(){
		JFrame f= new JFrame();
	    f.setTitle("Medical STORE MANAGEMENT SYSTEM: ABOUT US");
	    f.setBounds(100, 100, 1000, 700);
		f.setLocationRelativeTo(null);
		f.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(253, 245, 230));
		panel_1.setBounds(0, 0, 984, 661);
		f.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\Mini Project-1\\Apurva Pagapalliwar\\C1234.jpg"));
		lblNewLabel_1.setBounds(154, 76, 624, 199);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("ABOUT US");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNewLabel.setBounds(400, 22, 103, 34);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("ABOUT MEDICAL SHOP MANAGEMENT SYSTEM");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(55, 301, 395, 25);
		panel_1.add(lblNewLabel_2);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(599, 332, -4, 5);
		panel_1.add(textPane);
		
		JLabel lblNewLabel_3 = new JLabel("FEATURES");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(654, 301, 103, 25);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\Mini Project-1\\Apurva Pagapalliwar\\dettol-antiseptic-liquid32-500x500.png"));
		lblNewLabel_4.setBounds(770, 76, 137, 199);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\Mini Project-1\\Apurva Pagapalliwar\\Online-Sale-of-Drugs.jpg"));
		lblNewLabel_5.setBounds(10, 76, 165, 199);
		panel_1.add(lblNewLabel_5);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBackground(new Color(253, 245, 230));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				f.setVisible(false);
				new HOMEPAGE();
			}
		});
		btnBack.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnBack.setBounds(832, 603, 112, 34);
		panel_1.add(btnBack);
		
		JTextPane txtpnMedicalShopManagement = new JTextPane();
		txtpnMedicalShopManagement.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtpnMedicalShopManagement.setText("Medical Shop Management System Software is created for managing and automating Medical Stores. It is a one-stop solution provider for the problems faced in the field of Medical Store Management. It is enhanced software for those customers who want better quality, accuracy and reduced R&D(Research and Development) costs. It is the complete medical shop management software designed to ease the workload of medical shop professionals. This software helps you to examine all the profits, losses, profitable clients, and products of the medical shop. Moreover, it can be used as accounting software. Flexible and adaptive software suited to medical shops, stores, or even pharmacies of any size. It is a fully loaded software with advanced features to meet all the requirements of Medical Stores.");
		txtpnMedicalShopManagement.setBackground(new Color(255, 245, 238));
		txtpnMedicalShopManagement.setBounds(10, 355, 468, 282);
		panel_1.add(txtpnMedicalShopManagement);
		
		JTextPane txtpntheSoftwareManages = new JTextPane();
		txtpntheSoftwareManages.setBackground(new Color(255, 245, 238));
		txtpntheSoftwareManages.setText("1.The software manages your purchase order automatically, no need to pick copy and pen. It removes your cumbersome schedule and provides an easy and accurate approach.                                                                                         2.Automatically removes medicine from the stock on their expiries.                                                                                                           3.Can find the alternate medicines according to type, Generics, Formula Wise,etc.                                                                                                                  4.It shows the profit and loss of every medicine.                                                                                                               5.Gives details about the medicine storages.                                                                                                   6.Reduces manpower and saves time. ");
		txtpntheSoftwareManages.setBounds(488, 355, 486, 237);
		panel_1.add(txtpntheSoftwareManages);
		f.setVisible(true);
		
	}
	
	public static void main(String[] args) {
	
	new ABOUTUS();
	
    }
  }