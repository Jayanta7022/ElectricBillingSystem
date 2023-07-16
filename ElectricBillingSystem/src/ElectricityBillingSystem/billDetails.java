package ElectricityBillingSystem;

import java.awt.*;

import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class billDetails extends JFrame {
	 String meter;
	billDetails(String meter){
		this.meter=meter;
		
		setSize(700,500);
		setLocation(400,50);
		getContentPane().setBackground(Color.white);
		JTable table= new JTable();
		
		
		try {
			Conn c= new Conn();
			String querry ="select * from bill where meter='"+meter+"' ";
			ResultSet rs= c.s.executeQuery(querry);
			System.out.println(meter);
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		JScrollPane sp= new JScrollPane(table);
		sp.setBounds(0, 0, 700, 500);
		add(sp);
		
		setVisible(true);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new billDetails("");

	}

}
