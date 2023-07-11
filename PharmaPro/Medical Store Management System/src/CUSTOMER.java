import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;

public class CUSTOMER {
	public JTextField textid;
	public JTextField textname;
	public JTextField textage;
	public JTextField textphone;
	Connection con;
	PreparedStatement pst;
	public JTable table;
	public JTextField textquantity;
	ResultSet rs;
	
	CUSTOMER(){
		
		JFrame f= new JFrame();
		f.getContentPane().setBackground(new Color(50, 205, 50));
		  f.setTitle("MEDICAL STORE MANAGEMENT SYSTEM: CUSTOMERS");
		  f.setBounds(100, 100, 1000, 700);
		  f.setVisible(true);
		  f.setLocationRelativeTo(null);
		  f.getContentPane().setLayout(null);
		  
		  JPanel panel = new JPanel();
		  panel.setBounds(10, 68, 964, 582);
		  panel.setBackground(new Color(152, 251, 152));
		  f.getContentPane().add(panel);
		  
		  JButton btnBack = new JButton("BACK");
		  btnBack.setBounds(799, 216, 155, 34);
		  btnBack.setForeground(new Color(0, 128, 0));
		  btnBack.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		
		  		f.setVisible(false);
		  		new HOMEPAGE();
		  		
		  	}
		  });
		  panel.setLayout(null);
		  btnBack.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		  panel.add(btnBack);
		
		  
		  JLabel lblName = new JLabel("NAME");
		  lblName.setBounds(10, 56, 155, 34);
		  lblName.setForeground(new Color(0, 128, 0));
		  lblName.setFont(new Font("Segoe UI", Font.BOLD, 20));
		  panel.add(lblName);
		  
		  JLabel lblAge = new JLabel("AGE");
		  lblAge.setBounds(10, 101, 155, 32);
		  lblAge.setForeground(new Color(0, 128, 0));
		  lblAge.setFont(new Font("Segoe UI", Font.BOLD, 20));
		  panel.add(lblAge);
		  
		 
		  
		  JLabel lblPhone = new JLabel("PHONE NO.");
		  lblPhone.setBounds(521, 9, 194, 32);
		  lblPhone.setForeground(new Color(0, 128, 0));
		  lblPhone.setFont(new Font("Segoe UI", Font.BOLD, 20));
		  panel.add(lblPhone);
		  
		  JLabel lblGender = new JLabel("GENDER");
		  lblGender.setBounds(521, 57, 194, 32);
		  lblGender.setForeground(new Color(0, 128, 0));
		  lblGender.setFont(new Font("Segoe UI", Font.BOLD, 20));
		  panel.add(lblGender);
		  
		  JScrollPane scrollPane_1 = new JScrollPane();
		  scrollPane_1.setBounds(175, 144, 201, 34);
		  panel.add(scrollPane_1);
		  
		  JComboBox comboBoxmedname = new JComboBox();
		  
		  try {
	        	 Class.forName("com.mysql.cj.jdbc.Driver");
	  			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/msms", "root","Lokeshmysql@14");
	        	 pst = con.prepareStatement("select MEDNAME from medicine_list");
	        	 ResultSet rs = pst.executeQuery();
	        	 while (rs.next()) {  
	        	     comboBoxmedname.addItem(rs.getString("MEDNAME"));  
	        	 }
			}catch(Exception e){
				
			}
	        
//		  
//		  comboBoxmedname.addActionListener(new ActionListener() {
//		  	public void actionPerformed(ActionEvent arg0) {
//		  		
//		  		String medname = (String) comboBoxmedname.getSelectedItem();
//				try {
//					Class.forName("com.mysql.cj.jdbc.Driver");
//		  			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store_management?useSSL=false&allowPublicKeyRetrieval=true", "root","Shreyas@123");
//					pst = con.prepareStatement("select * from medicine where name=?");
//					pst.setString(1, medname);
//					rs = pst.executeQuery();
//					table.setModel(DbUtils.resultSetToTableModel(rs));
//				}catch (Exception e1) {
//					e1.printStackTrace();
//				}
//		  		
//		  	}
//		  });
		  
		  scrollPane_1.setViewportView(comboBoxmedname);
		  comboBoxmedname.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		  
		  JScrollPane scrollPane_2 = new JScrollPane();
		  scrollPane_2.setBounds(730, 56, 224, 33);
		  panel.add(scrollPane_2);
		  
		  JComboBox comboBoxgender = new JComboBox();
		  comboBoxgender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "Transgender"}));
		  scrollPane_2.setViewportView(comboBoxgender);
		  comboBoxgender.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		  

		  try {
	        	 Class.forName("com.mysql.cj.jdbc.Driver");
	 			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store_management?useSSL=false&allowPublicKeyRetrieval=true", "root","Shreyas@123");
	        	 pst = con.prepareStatement("select name from medicine");
	        	 ResultSet rs = pst.executeQuery();
	        	 while (rs.next()) {  
	        	     comboBoxmedname.addItem(rs.getString("name"));  
	        	 }
			}catch(Exception e){
				
			}
		  
		  
		  JButton btnDelete = new JButton("DELETE");
		  btnDelete.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent arg0) {
		  		

		  		String id;
		  		id = textid.getText();
		  		
		  		try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store_management?useSSL=false&allowPublicKeyRetrieval=true", "root","Shreyas@123");
		  			pst = con.prepareStatement("delete from customer where id =?");
		  			pst.setString(1, id);
		  			pst.execute();
		  			JOptionPane.showMessageDialog(null, "Record Deleted!");
		  			pst.close();
		  			
		  			textname.setText(null);
			  		textage.setText(null);
			  		
			  		textphone.setText(null);
			  		
			  		textquantity.setText(null);
			  		
		  			getAllRecords();
		  			
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		  		
		  	}
		  });
		  btnDelete.setBounds(600, 216, 155, 34);
		  btnDelete.setForeground(new Color(0, 128, 0));
		  btnDelete.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		  panel.add(btnDelete);
		  
		  JButton btnUpdate = new JButton("UPDATE");
		  btnUpdate.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent arg0) {
		  		

		  		String id,name,age,phone,quantity;
		          
		  		id=textid.getText();
		  		name=textname.getText();
		  		age=textage.getText();
		  		String medname = (String) comboBoxmedname.getSelectedItem();
		  		phone=textphone.getText();
		  		String gender = (String) comboBoxgender.getSelectedItem();
		  		quantity=textquantity.getText();
		  		
		  		try {
		  			
		  			Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store_management?useSSL=false&allowPublicKeyRetrieval=true", "root","Shreyas@123");
		  			
		  			PreparedStatement pst=con.prepareStatement("update customer set id=?,name=?,age=?,gender=?,medicine=?,quantity=? where phone_no =?");
		  			
		  			pst.setString(1, id);
		  			pst.setString(2, name);
		  			pst.setString(3, age);
		  			pst.setString(4, gender);
		  			pst.setString(5, medname);
		  			pst.setString(6, quantity);
		  			pst.setString(7, phone);
		  					  		
		  			pst.executeUpdate();
		  			
		  			getAllRecords();
		  			
		  			JOptionPane.showMessageDialog(null, "Record Updated!");
		  			
		  			pst.close();	
		  			
		  		} catch (Exception e1) {
		  			e1.printStackTrace();
		  		}
		  		
		  		
		  		
		  	}
		  });
		  btnUpdate.setBounds(202, 216, 155, 34);
		  btnUpdate.setForeground(new Color(0, 128, 0));
		  btnUpdate.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		  panel.add(btnUpdate);
		  
		  JButton btnAdd = new JButton("ADD");
		  btnAdd.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent arg0) {
		  		
		  		String id,name,age,phone,quantity;
		  		
		  		id=textid.getText();
		  		name=textname.getText();
		  		age=textage.getText();
		  		String medname = (String) comboBoxmedname.getSelectedItem();
		  		phone=textphone.getText();
		  	    String gender = (String) comboBoxgender.getSelectedItem();
		  		quantity=textquantity.getText();
		  		
		  		
		  		try {

		  		Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store_management?useSSL=false&allowPublicKeyRetrieval=true", "root","Shreyas@123");
		  		pst = con.prepareStatement("insert into customer values(?,?,?,?,?,?,?)");
		  		pst.setString(1, id);
		  		pst.setString(2, name);
		  		pst.setString(3, age);
		  		pst.setString(4, gender);
		  		pst.setString(5, phone);
		  		pst.setString(6, medname);
		  		pst.setString(7, quantity);
		  		pst.execute();
		  		JOptionPane.showMessageDialog(null, "Record Added!");
		  		
		  		getAllRecords();
		  		pst.close();

		  		}
		  		catch (Exception e1)
		  		{
		  		e1.printStackTrace();
		  		JOptionPane.showMessageDialog(null, "ID ALREADY USED");
		  		}

		  		
		  		try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store_management?useSSL=false&allowPublicKeyRetrieval=true", "root","Shreyas@123");
					String sql = "Select * from customer";
					PreparedStatement pst = con.prepareStatement(sql);
					ResultSet rs = pst.executeQuery(sql);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		  		
		  	}
		  });
		  btnAdd.setBounds(10, 216, 155, 34);
		  btnAdd.setForeground(new Color(0, 100, 0));
		  btnAdd.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		  panel.add(btnAdd);
		  
		  JButton btnClear = new JButton("CLEAR");
		  btnClear.setBounds(402, 216, 155, 34);
		  btnClear.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent arg0) {
		  		
		  		textid.setText(null);
		  		textname.setText(null);
		  		textage.setText(null);
		  		
		  		textphone.setText(null);
		  		
		  		textquantity.setText(null);
		  		
		  	}
		  });
		  btnClear.setForeground(new Color(0, 128, 0));
		  btnClear.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		  panel.add(btnClear);
		  
		  JLabel lbld = new JLabel("ID");
		  lbld.setBounds(10, 11, 155, 34);
		  lbld.setForeground(new Color(0, 128, 0));
		  lbld.setFont(new Font("Segoe UI", Font.BOLD, 20));
		  panel.add(lbld);
		  
		  textid = new JTextField();
		  textid.addKeyListener(new KeyAdapter() {
		  	@Override
		  	public void keyPressed(KeyEvent e) {
		  		
		  		char c = e.getKeyChar();
		  		
		  		if(Character.isDigit(c) || Character.isWhitespace(c) || Character.isISOControl(c))
		  		{
		  			textid.setEditable(true);
		  		}
		  		else
		  		{
		  			textid.setEditable(false);
		  			JOptionPane.showMessageDialog(null, "Invalid Number");
		  		}
		  		
		  	}
		  });
		  textid.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		  textid.setBounds(175, 9, 201, 34);
		  panel.add(textid);
		  textid.setColumns(10);
		  
		  textname = new JTextField();
			
			  textname.addKeyListener(new KeyAdapter() {
			  
			  @Override 
			  public void keyPressed(KeyEvent e) {
			 
			  char c = e.getKeyChar();
			  
			 if(Character.isAlphabetic(c) || Character.isWhitespace(c) ||
			 Character.isISOControl(c) || Character.isUpperCase(c)) {
			 textname.setEditable(true); } else { textname.setEditable(false);
			 JOptionPane.showMessageDialog(null, "Invalid Character"); }
			  
			  } });
			 
		  textname.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		  textname.setBounds(175, 54, 201, 34);
		  textname.setColumns(10);
		  panel.add(textname);
		  
		  textage = new JTextField();
		  textage.addKeyListener(new KeyAdapter() {
		  	@Override
		  	public void keyPressed(KeyEvent e) {
		  		
		  		char c = e.getKeyChar();
		  		
		  		if(Character.isDigit(c) || Character.isWhitespace(c) || Character.isISOControl(c))
		  		{
		  			textage.setEditable(true);
		  		}
		  		else
		  		{
		  			textage.setEditable(false);
		  			JOptionPane.showMessageDialog(null, "Invalid Number");
		  		}
		  		
		  		
		  	}
		  });
		  textage.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		  textage.setBounds(175, 99, 201, 34);
		  textage.setColumns(10);
		  panel.add(textage);
		  
		  textphone = new JTextField();
		  textphone.addKeyListener(new KeyAdapter() {
		  	@Override
		  	public void keyPressed(KeyEvent e) {
		  		
		  		char c = e.getKeyChar();
		  		
		  		if(Character.isDigit(c) || Character.isWhitespace(c) || Character.isISOControl(c))
		  		{
		  			textphone.setEditable(true);
		  		}
		  		else
		  		{
		  			textphone.setEditable(false);
		  			JOptionPane.showMessageDialog(null, "Invalid Number");
		  		}
		  		
		  		
		  	}
		  });
		  textphone.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		  textphone.setBounds(730, 9, 224, 34);
		  textphone.setColumns(10);
		  panel.add(textphone);
		  
		  JLabel lblNewLabel_1 = new JLabel("Customers List");
		  lblNewLabel_1.setFont(new Font("Lucida Handwriting", Font.PLAIN, 20));
		  lblNewLabel_1.setBounds(395, 261, 174, 29);
		  panel.add(lblNewLabel_1);
		  
		  JLabel lblMedname = new JLabel("MEDNAME");
		  lblMedname.setForeground(new Color(0, 128, 0));
		  lblMedname.setFont(new Font("Segoe UI", Font.BOLD, 20));
		  lblMedname.setBounds(10, 146, 155, 32);
		  panel.add(lblMedname);
		  
		  JScrollPane scrollPane = new JScrollPane();
		  scrollPane.setBounds(10, 290, 944, 281);
		  panel.add(scrollPane);
		  
		  table = new JTable();
		  scrollPane.setViewportView(table);
		  table.setModel(new DefaultTableModel(
		  	new Object[][] {
		  	},
		  	new String[] {
		  		"ID", "NAME", "AGE", "MEDNAME", "PHONE", "GENDER","QUANTITY"
		  	}
		  ));
		  
		  getAllRecords();
		  
		  JButton btnSearch = new JButton("SEARCH");
		  btnSearch.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		

		  		String id,name,age,phone,quantity;
		  		
		  		id=textid.getText();
		  		name=textname.getText();
		  		age=textage.getText();
		  		String medname = (String) comboBoxmedname.getSelectedItem();
		  		phone=textphone.getText();
		  		String gender = (String) comboBoxgender.getSelectedItem();
		  		quantity=textquantity.getText();
		  		
		  		try {
					
		  			Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store_management?useSSL=false&allowPublicKeyRetrieval=true", "root","Shreyas@123");
		  			pst = con.prepareStatement("Select id,name,age,gender,medicine,quantity from customer where phone_no =?");
		  			pst.setString(1, phone);
		  			
		  			ResultSet rs=pst.executeQuery();
		  			
		  			if(rs.next()==false)
		  			{
		  				JOptionPane.showMessageDialog(null, "NUMBER NOT FOUND");
		  			}
		  			else
		  			{
		  				id=rs.getString(1);
				  		name=rs.getString(2);
				  		age=rs.getString(3);
				  		gender=rs.getString(4);
				  		medname=rs.getString(5);
				  		quantity=rs.getString(6);
				  		
				  		textid.setText(id);
				  		textname.setText(name);
				  		textage.setText(age);
				  		comboBoxmedname.setSelectedItem(medname);
				  		comboBoxgender.setSelectedItem(gender);
				  		textquantity.setText(quantity);
				  		
				  		
		  			}
		  			
		  			
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		  		
		  	}
		  });
		  btnSearch.setForeground(new Color(0, 128, 0));
		  btnSearch.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		  btnSearch.setBounds(799, 143, 155, 34);
		  panel.add(btnSearch);
		  
		  JLabel lblQuantity = new JLabel("QUANTITY");
		  lblQuantity.setForeground(new Color(0, 128, 0));
		  lblQuantity.setFont(new Font("Segoe UI", Font.BOLD, 20));
		  lblQuantity.setBounds(521, 101, 194, 32);
		  panel.add(lblQuantity);
		  
		  textquantity = new JTextField();
//		  textquantity.addKeyListener(new KeyAdapter() {
//		  	@Override
//		  	public void keyPressed(KeyEvent e) {
//		  		
//		  		char c = e.getKeyChar();
//		  		
//		  		if(Character.isDigit(c) || Character.isWhitespace(c) || Character.isISOControl(c))
//		  		{
//		  			textquantity.setEditable(true);
//		  		}
//		  		else
//		  		{
//		  			textquantity.setEditable(false);
//		  			JOptionPane.showMessageDialog(null, "Invalid Number");
//		  		}
//		  		
//		  		int textquantity1 = Integer.parseInt(textquantity.getText());
//		  		
//		  		try {
//
//			  		Class.forName("com.mysql.cj.jdbc.Driver");
//			  	    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store_management?useSSL=false&allowPublicKeyRetrieval=true", "root","Shreyas@123");
//			  		pst = con.prepareStatement("select quantity from medicine where name=?")
//			  		
//			  		pst.execute();
//			  		
//			  		
//			  		pst.close();
//
//			  		}
//			  		catch (Exception e1)
//			  		{
//			  		e1.printStackTrace();
//			  		}
//
//		  		
//		  		
//		  	}
//		  });
//		  
		  
		  textquantity.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		  textquantity.setColumns(10);
		  textquantity.setBounds(730, 101, 224, 34);
		  panel.add(textquantity);
		  
		 
		  
		 
		  JPanel panel_1 = new JPanel();
		  panel_1.setBackground(new Color(144, 238, 144));
		  panel_1.setBounds(10, 11, 964, 59);
		  f.getContentPane().add(panel_1);
		  panel_1.setLayout(null);
		  
		  JLabel lblNewLabel = new JLabel("Manage Customers");
		  lblNewLabel.setFont(new Font("Lucida Handwriting", Font.PLAIN, 25));
		  lblNewLabel.setBounds(331, 11, 376, 36);
		  panel_1.add(lblNewLabel);
		
	}

	public void getAllRecords() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store_management?useSSL=false&allowPublicKeyRetrieval=true", "root","Shreyas@123");
			String sql = "Select * from customer";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery(sql);
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new CUSTOMER();
	
}
}