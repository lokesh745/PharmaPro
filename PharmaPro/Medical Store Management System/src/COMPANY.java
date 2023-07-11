import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class COMPANY{
	public JTextField textid;
	public JTextField textmedcomp;
	public JTextField textphone;
	public JTable table;
	Connection con;
	PreparedStatement pst;
	JScrollPane scrollPane;
	ResultSet rs;
	
	
	COMPANY(){
		
		JFrame f= new JFrame();
		f.getContentPane().setBackground(new Color(50, 205, 50));
		  f.setTitle("MEDICAL STORE MANAGEMENT SYSTEM: COMPANY");
		  f.setBounds(100, 100, 1000, 700);
		  f.setVisible(true);
		  f.setLocationRelativeTo(null);
		  f.getContentPane().setLayout(null);
		  
		  JPanel panel = new JPanel();
		  panel.setBounds(10, 68, 964, 582);
		  panel.setBackground(new Color(152, 251, 152));
		  f.getContentPane().add(panel);
		  
		  JButton btnBack = new JButton("BACK");
		  btnBack.setBounds(799, 176, 155, 34);
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
		
		  
		  JLabel lblMedcomp = new JLabel("MEDCOMP");
		  lblMedcomp.setBounds(10, 78, 111, 34);
		  lblMedcomp.setForeground(new Color(0, 128, 0));
		  lblMedcomp.setFont(new Font("Segoe UI", Font.BOLD, 20));
		  panel.add(lblMedcomp);
		  
		 
		  
		  JLabel lblPhone = new JLabel("PHONE NO.");
		  lblPhone.setBounds(521, 27, 111, 32);
		  lblPhone.setForeground(new Color(0, 128, 0));
		  lblPhone.setFont(new Font("Segoe UI", Font.BOLD, 20));
		  panel.add(lblPhone);
		  
		  JButton btnDelete = new JButton("DELETE");
		  btnDelete.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		
		  		String id;
		  		id = textid.getText();
		  		try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store_management?useSSL=false&allowPublicKeyRetrieval=true", "root","Shreyas@123");
		  			pst = con.prepareStatement("delete from company where id =?");
		  			pst.setString(1, id);
		  			pst.execute();
		  			JOptionPane.showMessageDialog(null, "Record Deleted!");
		  			pst.close();
		  			
		  			textmedcomp.setText(null);
		  			textphone.setText(null);
		  
		  			getAllRecords();
		  			
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		  		
		  	}
		  });
		  btnDelete.setBounds(599, 176, 155, 34);
		  btnDelete.setForeground(new Color(0, 128, 0));
		  btnDelete.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		  panel.add(btnDelete);
		  
		  JButton btnUpdate = new JButton("UPDATE");
		  btnUpdate.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		
		  		String id,medcomp,phone;
		          
		  		id=textid.getText();
		  		medcomp=textmedcomp.getText();
		  		phone=textphone.getText();
		  		
		  		try {
		  			
		  			Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store_management?useSSL=false&allowPublicKeyRetrieval=true", "root","Shreyas@123");
		  			PreparedStatement pst=con.prepareStatement("update company set id=?,phone_no=? where name=?");
		  			
		  			pst.setString(1, id);
		  			pst.setString(2, phone);
		  			pst.setString(3, medcomp);
		  					  		
		  			pst.executeUpdate();
		  			
		  			getAllRecords();
		  			
		  			JOptionPane.showMessageDialog(null, "Record Updated!");
		  			
		  			pst.close();	
		  			
		  		} catch (Exception e1) {
		  			e1.printStackTrace();
		  		}
		  		
		  		
		  	}
		  });
		  btnUpdate.setBounds(201, 176, 155, 34);
		  btnUpdate.setForeground(new Color(0, 128, 0));
		  btnUpdate.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		  panel.add(btnUpdate);
		  
		  JButton btnAdd = new JButton("ADD");
		  btnAdd.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent arg0) {
		  		
		  		String id,medcomp,phone;
		          
		  		id=textid.getText();
		  		medcomp=textmedcomp.getText();
		  		phone=textphone.getText();
		  		
		  		try {

		  		Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store_management?useSSL=false&allowPublicKeyRetrieval=true", "root","Shreyas@123");
		  		pst = con.prepareStatement("insert into company values(?,?,?)");
		  		pst.setString(1, id);
		  		pst.setString(2, medcomp);
		  		pst.setString(3, phone);	
		  		pst.execute();
		  		JOptionPane.showMessageDialog(null, "Record Added!");
		  		
		  		pst.close();
		  		
		  		}
		  		catch (Exception e1)
		  		{
		  		e1.printStackTrace();
		  		JOptionPane.showMessageDialog(null, "ID ALREADY USED");
		  		}

		  		
		  		try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store_management?useSSL=false&allowPublicKeyRetrieval=true", "root","Shreyas@123");
					String sql = "Select * from company";
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
		  btnAdd.setBounds(10, 176, 155, 34);
		  btnAdd.setForeground(new Color(0, 100, 0));
		  btnAdd.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		  panel.add(btnAdd);
		  
		  JButton btnClear = new JButton("CLEAR");
		  btnClear.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent arg0) {
		  		
		  		textid.setText(null);
		  		textmedcomp.setText(null);
		  		textphone.setText(null);
		  		
		  	}
		  });
		  btnClear.setForeground(new Color(0, 128, 0));
		  btnClear.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		  btnClear.setBounds(402, 176, 155, 34);
		  panel.add(btnClear);
		  
		  JLabel lbld = new JLabel("ID");
		  lbld.setForeground(new Color(0, 128, 0));
		  lbld.setFont(new Font("Segoe UI", Font.BOLD, 20));
		  lbld.setBounds(10, 27, 122, 29);
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
		  textid.setColumns(10);
		  textid.setBounds(156, 25, 249, 34);
		  panel.add(textid);
		  
		  textmedcomp = new JTextField();
		  textmedcomp.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		  textmedcomp.setColumns(10);
		  textmedcomp.setBounds(156, 78, 249, 34);
		  panel.add(textmedcomp);
		  
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
		  textphone.setColumns(10);
		  textphone.setBounds(705, 25, 249, 34);
		  panel.add(textphone);
		  
		  JLabel lblNewLabel_1 = new JLabel("Companies List");
		  lblNewLabel_1.setFont(new Font("Lucida Handwriting", Font.PLAIN, 20));
		  lblNewLabel_1.setBounds(382, 221, 201, 29);
		  panel.add(lblNewLabel_1);
		  
		  JButton btnSearch = new JButton("SEARCH");
		  btnSearch.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		

		  		String id,medcomp,phone;

		  		id=textid.getText();
		  		medcomp=textmedcomp.getText();
		  		phone=textphone.getText();
		  	
		  		
		  		try {
					
		  			Class.forName("com.mysql.cj.jdbc.Driver");
		  			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store_management?useSSL=false&allowPublicKeyRetrieval=true", "root","Shreyas@123");
		  			pst = con.prepareStatement("Select id,phone_no from company where name =?");
		  			pst.setString(1, medcomp);
		  			
		  			ResultSet rs=pst.executeQuery();
		  			
		  			if(rs.next()==false)
		  			{
		  				JOptionPane.showMessageDialog(null, "NAME NOT FOUND");
		  			}
		  			else
		  			{
				  		id=rs.getString(1);
				  		phone=rs.getString(2);
				  		
				  		textid.setText(id);
				  		textphone.setText(phone);
				  		
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
		  btnSearch.setBounds(799, 115, 155, 34);
		  panel.add(btnSearch);
		  
		  JScrollPane scrollPane = new JScrollPane();
		  scrollPane.setBounds(10, 258, 944, 313);
		  panel.add(scrollPane);
		  
		  table = new JTable();
		  table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		  scrollPane.setViewportView(table);
		  table.setModel(new DefaultTableModel(
		  	new Object[][] {
		  	},
		  	new String[] {
		  		"ID", "MEDCOMP", "PHONE NO."
		  	}
		  ));
		  
		  getAllRecords();
		  
		  JPanel panel_1 = new JPanel();
		  panel_1.setBackground(new Color(144, 238, 144));
		  panel_1.setBounds(10, 11, 964, 57);
		  f.getContentPane().add(panel_1);
		  panel_1.setLayout(null);
		  
		  JLabel lblNewLabel = new JLabel("Manage Company");
		  lblNewLabel.setFont(new Font("Lucida Handwriting", Font.PLAIN, 25));
		  lblNewLabel.setBounds(331, 11, 376, 36);
		  panel_1.add(lblNewLabel);
		
		
	}
	
	public void getAllRecords() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medical_store_management?useSSL=false&allowPublicKeyRetrieval=true", "root","Shreyas@123");
			String sql = "Select * from company";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery(sql);
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
	}
	
	public static void main(String[] args) {
		new COMPANY();
		
	}
}
	
	