package ElectricityBillingSystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class DepositDetails extends JFrame implements ActionListener{
	
	Choice meterNo,month;
	JTable table;
	JButton search,print;
	
	DepositDetails (){
		super("Deposit Details");
		
		
		setSize(700,500);
		setLocation(350, 100);
		
		
		
		setLayout(null);
		getContentPane().setBackground(Color.white);	
		
		JLabel lblMeter=new JLabel("Search By Meter No");
		lblMeter.setBounds(20, 20, 150, 20);
		add(lblMeter);
		
		
		meterNo= new Choice();
		meterNo.setBounds(180, 20, 150, 20);
		add(meterNo);
		
		
		try {
			Conn c=new Conn();
			ResultSet rs=c.s.executeQuery("select * from customer");
			while(rs.next()) {
				meterNo.add(rs.getString("meter_no"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		JLabel lblMonth=new JLabel("Search By Month");
		lblMonth.setBounds(350, 20, 150, 20);
		add(lblMonth);
		
		
		month= new Choice();
		month.setBounds(500, 20, 150, 20);
		month.add("January");
		month.add("February");
		month.add("March");
		month.add("April");
		month.add("May");
		month.add("June");
		month.add("July");
		month.add("August");
		month.add("September");
		month.add("October");
		month.add("November");
		month.add("December");
		add(month);
		
		
		table=new JTable();
		try {
			Conn c= new Conn();
		ResultSet rs=	c.s.executeQuery("select * from bill");
		table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		JScrollPane sp= new JScrollPane(table);
		sp.setBounds(0,100,700,300);
		add(sp);
		
		
		search=new JButton("search");
		search.setBounds(20,70,80,20);
		search.addActionListener(this);
		add(search);
		
		
		
		print=new JButton("print");
		print.setBounds(120,70,80,20);
		print.addActionListener(this);
		add(print);
		
		
		
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==search) {
			String querry="select * from bill where meter=' "+meterNo.getSelectedItem()+" ' and month=' "+month.getSelectedItem() +" ' ";
			try {
				Conn c=new  Conn();
				ResultSet rs=c.s.executeQuery(querry);
				
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		else {
			try {
				table.print();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	public static void main(String []args) {
		new DepositDetails();
	}

	
}
