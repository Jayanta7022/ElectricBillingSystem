package ElectricityBillingSystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class CustomerDetails extends JFrame implements ActionListener {
	
	//Choice meterNo,month;
	JTable table;
	JButton search,print;
	
	CustomerDetails (){
		super("Deposit Details");
		
		
		setSize(1000,500);
		setLocation(100, 150);
		//setLayout(new BorderLayout());
		

		
		
	
		
		
		table=new JTable();
		try {
			Conn c= new Conn();
		ResultSet rs=	c.s.executeQuery("select * from customer");
		table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		add(table);
		
		
		JScrollPane sp= new JScrollPane(table);
		add(sp);
		
		print=new JButton("print");
		print.addActionListener(this);
		add(print,"South");
		
		
		setVisible(true);
	}
	

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			table.print();
			}
		catch(Exception e1) {
			e1.printStackTrace();
		}
		
	}
	
	
	
	public static void main(String []args) {
		new CustomerDetails();
	}





	

	
}
