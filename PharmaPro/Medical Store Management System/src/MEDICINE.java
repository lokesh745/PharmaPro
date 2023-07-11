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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

import com.mysql.cj.xdevapi.Statement;
import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;
import java.awt.event.KeyEvent;

public class MEDICINE {
	public JTextField textid;
	public JTextField textname;
	public JTextField textprice;
	public JTextField textquantity;
	Connection con;
	PreparedStatement pst;
	public JDateChooser dateChoosermf;
	public JDateChooser dateChooserexp;
	public JTable table;
	
	
	ResultSet rs;
	public JTextField textbatch;

	
	
	MEDICINE(){
		
		JFrame f= new JFrame();
		f.getContentPane().setBackground(new Color(50, 205, 50));
	    f.setTitle("MEDICAL STORE MANAGEMENT SYSTEM: MEDICINE");
	    f.setBounds(100, 100, 1000, 700);
		f.setLocationRelativeTo(null);
		f.getContentPane().setLayout(null);
		f.setVisible(true);
		

		  JPanel panel = new JPanel();
		  panel.setBounds(10, 68, 964, 582);
		  panel.setBackground(new Color(152, 251, 152));
		  f.getContentPane().add(panel);
		  
		  JButton btnBack = new JButton("BACK");
		  btnBack.setBounds(799, 255, 155, 34);
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
		  
		  JLabel lblNAME = new JLabel("NAME");
		  lblNAME.setBounds(10, 54, 147, 34);
		  lblNAME.setForeground(new Color(0, 128, 0));
		  lblNAME.setFont(new Font("Segoe UI", Font.BOLD, 20));
		  panel.add(lblNAME);
		  
		  JLabel lblPrice = new JLabel("PRICE");
		  lblPrice.setBounds(10, 99, 147, 32);
		  lblPrice.setForeground(new Color(0, 128, 0));
		  lblPrice.setFont(new Font("Segoe UI", Font.BOLD, 20));
		  panel.add(lblPrice);
		  
		  JLabel lblQuantity = new JLabel("QUANTITY");
		  lblQuantity.setBounds(10, 142, 147, 34);
		  lblQuantity.setForeground(new Color(0, 128, 0));
		  lblQuantity.setFont(new Font("Segoe UI", Font.BOLD, 20));
		  panel.add(lblQuantity);
		  
		  JLabel lblMfdate = new JLabel("MFDATE");
		  lblMfdate.setBounds(499, 11, 155, 32);
		  lblMfdate.setForeground(new Color(0, 128, 0));
		  lblMfdate.setFont(new Font("Segoe UI", Font.BOLD, 20));
		  panel.add(lblMfdate);
		  
		  JLabel lblExpdate = new JLabel("EXPDATE");
		  lblExpdate.setBounds(499, 54, 155, 34);
		  lblExpdate.setForeground(new Color(0, 128, 0));
		  lblExpdate.setFont(new Font("Segoe UI", Font.BOLD, 20));
		  panel.add(lblExpdate);
		  
		  JLabel lblMedcomp = new JLabel("MEDCOMP");
		  lblMedcomp.setBounds(499, 99, 155, 32);
		  lblMedcomp.setForeground(new Color(0, 128, 0));
		  lblMedcomp.setFont(new Font("Segoe UI", Font.BOLD, 20));
		  panel.add(lblMedcomp);
		  
		  
		  
		  JScrollPane scrollPane_1 = new JScrollPane();
		  scrollPane_1.setBounds(727, 97, 227, 32);
		  panel.add(scrollPane_1);
		  
		  JComboBox comboBox = new JComboBox();
		  scrollPane_1.setViewportView(comboBox);
		  
		  
//		  comboBox.addActionListener(new ActionListener() {
//		  	public void actionPerformed(ActionEvent arg0) {
//		  		
		  		
//		  		String medcomp = (String) comboBox.getSelectedItem();
//				try {
//					Class.forName("com.mysql.cj.jdbc.Driver");
//		  			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store_management?useSSL=false&allowPublicKeyRetrieval=true", "root","Shreyas@123");
//					pst = con.prepareStatement("select * from company where name=?");
//					pst.setString(1, medcomp);
//					rs = pst.executeQuery();
//					table.setModel(DbUtils.resultSetToTableModel(rs));
//				}catch (Exception e1) {
//					e1.printStackTrace();
//				}
//		  		
//		  	}
//		  });
		  
		  
		  comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		  
		  try {
	        	 Class.forName("com.mysql.cj.jdbc.Driver");
	 			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store_management?useSSL=false&allowPublicKeyRetrieval=true", "root","Shreyas@123");
	        	 pst = con.prepareStatement("select name from company");
	        	 ResultSet rs = pst.executeQuery();
	        	 while (rs.next()) {  
	        	     comboBox.addItem(rs.getString("name"));  
	        	 }
			}catch(Exception e){
				
			}
		  
		  JButton btnDelete = new JButton("DELETE");
		  btnDelete.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent arg0) {
		  		
		  		String id,batch;
		  		id = textid.getText();
		  		batch = textbatch.getText();
		  		try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store_management?useSSL=false&allowPublicKeyRetrieval=true", "root","Shreyas@123");
		  			pst = con.prepareStatement("delete from medicine where id =? and batch_no =?");
		  			pst.setString(1, id);
		  			pst.setString(2, batch);
		  			pst.execute();
		  			JOptionPane.showMessageDialog(null, "Record Deleted!");
		  			pst.close();
		  			
		  			textname.setText(null);
		  			textprice.setText(null);
		  			textquantity.setText(null);
		  			dateChoosermf.setDate(null);
		  			dateChooserexp.setDate(null);
		  			textbatch.setText(null);
		  			
		  			getAllRecords();
		  			
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		  		
		  	}
		  });
		  
		  
		  btnDelete.setBounds(598, 255, 155, 34);
		  btnDelete.setForeground(new Color(0, 128, 0));
		  btnDelete.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		  panel.add(btnDelete);
		  
		  JButton btnUpdate = new JButton("UPDATE");
		  btnUpdate.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent arg0) {
		  		
		  		
		  		String id,name,price,quantity;
		           java.sql.Date manufacture_date,expiry_date;

		  		id=textid.getText();
		  		name=textname.getText();
		  		price=textprice.getText();
		  		quantity=textquantity.getText();
		  		manufacture_date=new java.sql.Date(dateChoosermf.getDate().getTime());
		  		expiry_date=new java.sql.Date(dateChooserexp.getDate().getTime());
		  		String medcomp = (String) comboBox.getSelectedItem();
		  		String batch=textbatch.getText();
		  		
		  		try {
		  			
		  			Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store_management?useSSL=false&allowPublicKeyRetrieval=true", "root","Shreyas@123");
		  			PreparedStatement pst=con.prepareStatement("update medicine set name=?,price=?,company=?,manufacture_date=?,expiry_date=?,quantity=?,batch_no=? where id =?");
		  			pst.setString(1, name);
		  			pst.setString(2, price);
		  			pst.setString(3, medcomp);
		  			pst.setDate(4, manufacture_date);
		  			pst.setDate(5, expiry_date);
		  			pst.setString(6, quantity);
		  			pst.setString(7, batch);
		  			pst.setString(8, id);
		  					  		
		  			pst.executeUpdate();
		  			
		  			getAllRecords();
		  			
		  			JOptionPane.showMessageDialog(null, "Record Updated!");
		  			
		  			pst.close();	
		  			
		  		} catch (Exception e1) {
		  			e1.printStackTrace();
		  		}
		  		
		  		
		  		
		  	}
		  });
		  btnUpdate.setBounds(201, 255, 155, 34);
		  btnUpdate.setForeground(new Color(0, 128, 0));
		  btnUpdate.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		  panel.add(btnUpdate);
		  
		 
		  
		  JButton btnAdd = new JButton("ADD");
		  btnAdd.setBounds(10, 255, 155, 34);
		  btnAdd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
		  		
		  		String id,name,price,quantity;
		           java.sql.Date manufacture_date,expiry_date;
		      
		  		id=textid.getText();
		  		name=textname.getText();
		  		price=textprice.getText();
		  		quantity=textquantity.getText();
		  		manufacture_date=new java.sql.Date(dateChoosermf.getDate().getTime());
		  		expiry_date=new java.sql.Date(dateChooserexp.getDate().getTime());
		  		String medcomp = (String) comboBox.getSelectedItem();
		  		String batch=textbatch.getText();
		  		
		  		try {

		  		Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store_management?useSSL=false&allowPublicKeyRetrieval=true", "root","Shreyas@123");
		  		pst = con.prepareStatement("insert into medicine values(?,?,?,?,?,?,?,?)");
		  		pst.setString(1, id);
		  		pst.setString(2, name);
		  		pst.setString(3, price);
		  		pst.setString(4, medcomp);
		  		pst.setDate(5, manufacture_date);
		  		pst.setDate(6, expiry_date);
		  		pst.setString(7, quantity);
		  		pst.setString(8, batch);
		  		
		  		pst.execute();
		  		JOptionPane.showMessageDialog(null, "Record Added!");
		  		

		  		pst.close();

		  		}
		  		catch (Exception e1)
		  		{
		  		e1.printStackTrace();
		  		JOptionPane.showMessageDialog(null, "BATCH NO. ALREADY USED");
		  		}

		  		
		  		try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store_management?useSSL=false&allowPublicKeyRetrieval=true", "root","Shreyas@123");
					String sql = "Select * from medicine";
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
		  
		   
		  
		  btnAdd.setForeground(new Color(0, 100, 0));
		  btnAdd.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		  panel.add(btnAdd);
		  
		  JButton btnClear = new JButton("CLEAR");
		  btnClear.setBounds(398, 255, 155, 34);
		  btnClear.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent arg0) {
		  		
		  		textid.setText(null);
		  		textname.setText(null);
		  		textprice.setText(null);
		  		textquantity.setText(null);
		  		textbatch.setText(null);
		  		
		  	}
		  });
		  btnClear.setForeground(new Color(0, 128, 0));
		  btnClear.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		  panel.add(btnClear);
		  
		  JLabel lblId = new JLabel("ID");
		  lblId.setBounds(10, 11, 147, 32);
		  lblId.setForeground(new Color(0, 128, 0));
		  lblId.setFont(new Font("Segoe UI", Font.BOLD, 20));
		  panel.add(lblId);
		  
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
		  textid.setBounds(201, 11, 215, 34);
		  textid.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		  panel.add(textid);
		  textid.setColumns(10);
		  
		  textname = new JTextField();
		  textname.setBounds(201, 55, 215, 34);
		  textname.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		  textname.setColumns(10);
		  panel.add(textname);
		  
		  textprice = new JTextField();
		  textprice.addKeyListener(new KeyAdapter() {
		  	@Override
		  	public void keyPressed(KeyEvent e) {
		  		
		  		char c = e.getKeyChar();
		  		
		  		if(Character.isDigit(c) || Character.isWhitespace(c) || Character.isISOControl(c))
		  		{
		  			textprice.setEditable(true);
		  		}
		  		else
		  		{
		  			textprice.setEditable(false);
		  			JOptionPane.showMessageDialog(null, "Invalid Number");
		  		}
		  		
		  		
		  	}
		  });
		  textprice.setBounds(201, 99, 215, 34);
		  textprice.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		  textprice.setColumns(10);
		  panel.add(textprice);
		  
		  textquantity = new JTextField();
	  textquantity.addKeyListener(new KeyAdapter() {
		  	@Override
		  	public void keyPressed(KeyEvent e) {
		  		
		  		char c = e.getKeyChar();
		  		
		  		if(Character.isDigit(c) || Character.isWhitespace(c) || Character.isISOControl(c))
		  		{
		  			textquantity.setEditable(true);
		  		}
		  		else
		  		{
		  			textquantity.setEditable(false);
		  			JOptionPane.showMessageDialog(null, "Invalid Number");
		  		}
		  		
		  	}
		  });
		  textquantity.setBounds(201, 143, 215, 34);
		  textquantity.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		  textquantity.setColumns(10);
		  panel.add(textquantity);
		 
		  dateChoosermf = new JDateChooser();
		  dateChoosermf.setBounds(727, 11, 227, 32);
		  int day=dateChoosermf.getJCalendar().getDayChooser().getDay();
		  int month=dateChoosermf.getJCalendar().getMonthChooser().getMonth();
		  int year=dateChoosermf.getJCalendar().getYearChooser().getYear();
		  String dateNow=year+"/"+month+"/"+day;
		  System.out.println(dateNow);

		 
		  dateChoosermf.setDateFormatString("dd-MM-yyyy"); 
		  Calendar currentDate =			Calendar.getInstance(); 
		  dateChoosermf.setDate(currentDate.getTime());
		  panel.add(dateChoosermf);
		  
		  dateChooserexp = new JDateChooser();
		  dateChooserexp.setBounds(727, 54, 227, 32);
		  int day1=dateChooserexp.getJCalendar().getDayChooser().getDay();
		  int month1=dateChooserexp.getJCalendar().getMonthChooser().getMonth();
		  int year1=dateChooserexp.getJCalendar().getYearChooser().getYear();
		  String dateNow1=year1+"/"+month1+"/"+day1;
		  System.out.println(dateNow1);

		 
		  dateChooserexp.setDateFormatString("dd-MM-yyyy"); 
		  Calendar currentDate1 =			Calendar.getInstance(); 
		  dateChooserexp.setDate(currentDate1.getTime());
		  panel.add(dateChooserexp);
		  
		  JScrollPane scrollPane = new JScrollPane();
		  scrollPane.setBounds(10, 293, 944, 278);
		  panel.add(scrollPane);
		  
		  table = new JTable();
		  table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		  scrollPane.setViewportView(table);
		  table.setModel(new DefaultTableModel(
		  	new Object[][] {
		  	},
		  	new String[] {
		  		"ID", "NAME", "PRICE", "QUANTITY", "MFD_DATE", "EXP_DATE", "MEDCOMP", "BATCH NO."
		  	}
		  ));
		  
		  JLabel lblBatch = new JLabel("BATCH NO.");
		  lblBatch.setForeground(new Color(0, 128, 0));
		  lblBatch.setFont(new Font("Segoe UI", Font.BOLD, 20));
		  lblBatch.setBounds(499, 143, 155, 32);
		  panel.add(lblBatch);
		  
		  textbatch = new JTextField();
		  textbatch.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		
		  	}
		  });
		  textbatch.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		  textbatch.setBounds(727, 143, 227, 34);
		  panel.add(textbatch);
		  textbatch.setColumns(10);
		  
		  JPanel panel_2 = new JPanel();
		  panel_2.setForeground(new Color(224, 255, 255));
		  panel_2.setBorder(new TitledBorder(null, "SEARCH", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		  panel_2.setBounds(499, 188, 455, 54);
		  panel.add(panel_2);
		  panel_2.setLayout(null);
		  
		  JScrollPane scrollPane_2 = new JScrollPane();
		  scrollPane_2.setBounds(230, 11, 215, 32);
		  panel_2.add(scrollPane_2);
		  
		  JComboBox comboBoxsearch = new JComboBox();
		  scrollPane_2.setViewportView(comboBoxsearch);
		  
		  comboBoxsearch.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent arg0) {
		  		
		  		
		  		String medcomp = (String) comboBoxsearch.getSelectedItem();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store_management?useSSL=false&allowPublicKeyRetrieval=true", "root","Shreyas@123");
					pst = con.prepareStatement("select * from medicine where name=?");
					pst.setString(1, medcomp);
					rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch (Exception e1) {
					e1.printStackTrace();
				}
		  		getAllRecords();
		  	}
		  });
		  
		  
		  comboBoxsearch.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		  
		  try {
	        	 Class.forName("com.mysql.cj.jdbc.Driver");
	 			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store_management?useSSL=false&allowPublicKeyRetrieval=true", "root","Shreyas@123");
	        	 pst = con.prepareStatement("select name from medicine");
	        	 ResultSet rs = pst.executeQuery();
	        	 while (rs.next()) {  
	        	     comboBoxsearch.addItem(rs.getString("name"));  
	        	 }
			}catch(Exception e){
				
			}
		 
		  
		  getAllRecords();
		  
		  JPanel panel_1 = new JPanel();
		  panel_1.setBackground(new Color(144, 238, 144));
		  panel_1.setBounds(10, 11, 964, 59);
		  f.getContentPane().add(panel_1);
		  panel_1.setLayout(null);
		  
		  JLabel lblNewLabel = new JLabel("Manage Medicine");
		  lblNewLabel.setFont(new Font("Lucida Handwriting", Font.PLAIN, 25));
		  lblNewLabel.setBounds(331, 11, 376, 36);
		  panel_1.add(lblNewLabel);
		
	}	
	
	public void getAllRecords() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store_management?useSSL=false&allowPublicKeyRetrieval=true", "root","Shreyas@123");
			String sql = "Select * from medicine";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery(sql);
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		new MEDICINE();
	
}
}
