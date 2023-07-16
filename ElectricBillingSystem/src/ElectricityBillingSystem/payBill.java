package ElectricityBillingSystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class payBill extends JFrame implements ActionListener{
	
	Choice cMonth;
	JButton pay,back;
	String meter;
	public payBill(String meter) {
		this.meter=meter;
		setLayout(null);
		setBounds(300,50,700,500);
		
		JLabel heading= new JLabel("Pay Electric Bill");
		heading.setFont(new Font("tohoma",Font.BOLD	,24));
		heading.setBounds(200,5,400,30);
		add(heading);
		
		JLabel lblMeter= new JLabel("meter No");
		lblMeter.setBounds(50,60,100,20);
		add(lblMeter);
		
		JLabel meterNo= new JLabel("");
		meterNo.setBounds(200,60,100,20);
		add(meterNo);
		
		
		
		JLabel lblName= new JLabel("Name");
		lblName.setBounds(50, 100, 100,20);;
		add(lblName);
		
		JLabel Name= new JLabel("");
		Name.setBounds(200,100,100,20);
		add(Name);
		
		
		JLabel lblMonth= new JLabel("Month");
		lblMonth.setBounds(50, 140, 100,20);;
		add(lblMonth);
		
		cMonth=new Choice();
		cMonth.add("January");
		cMonth.add("February");
		cMonth.add("March");
		cMonth.add("April");
		cMonth.add("May");
		cMonth.add("June");
		cMonth.add("July");
		cMonth.add("August");
		cMonth.add("September");
		cMonth.add("October");
		cMonth.add("Novemmber");
		cMonth.add("December");
		
		cMonth.setBounds(200, 140, 200, 20);
		add(cMonth);
		
		JLabel lblUnits= new JLabel("Units");
		lblUnits.setBounds(50, 180, 100,20);;
		add(lblUnits);
		
		JLabel Units= new JLabel("");
		Units.setBounds(200,180,100,20);
		add(Units);
		
		
		JLabel lblTotalBill= new JLabel("Total Bill");
		lblTotalBill.setBounds(50, 220, 100,20);;
		add(lblTotalBill);
		
		JLabel TotalBill= new JLabel("");
		TotalBill.setBounds(200,220,100,20);
		add(TotalBill);
		
		
		JLabel lblStatus= new JLabel(" Bill Status");
		lblStatus.setBounds(50, 260, 100,20);;
		add(lblStatus);
		
		JLabel status= new JLabel("");
		status.setBounds(200,260,100,20);
		status.setForeground(Color.red);
		add(status);
		
		
		try {
			Conn c= new Conn();
			ResultSet rs= c.s.executeQuery("select * from  customer where meter_no='"+meter+"'");
			while(rs.next()) {
				meterNo.setText(meter);
				Name.setText(rs.getString("name"));
			}
			
			rs= c.s.executeQuery("select * from  bill where meter='"+meter+"' and month='"+cMonth.getSelectedItem()+"' ");
			while(rs.next()) {
				Units.setText(rs.getString("units"));
				TotalBill.setText(rs.getString("total_bill"));
				status.setText(rs.getString("status"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		cMonth.addItemListener(new  ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
			
				try {
					//System.out.println("yes");
					Conn c= new Conn();
					ResultSet rs= c.s.executeQuery("select * from  bill where meter='"+meter+"' and month='"+cMonth.getSelectedItem()+"' ");
					while(rs.next()) {
						Units.setText(rs.getString("units"));
						TotalBill.setText(rs.getString("total_bill"));
						status.setText(rs.getString("status"));
					}
					
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		
		
		pay= new JButton("Pay");
		pay.setBackground(Color.black);
		pay.setForeground(Color.white);
		pay.setBounds(150,350 , 80, 30);
		add(pay);
		pay.addActionListener(this);
		
		back= new JButton("Back");
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.setBounds(250,350 , 80, 30);
		add(back);
		back.addActionListener(this);

		
		
		setVisible(true);
		//  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new payBill("");

	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==pay) {
			try {
				Conn c= new Conn();
				c.s.executeUpdate("update bill set status='paid' where meter='"+meter+"' and month='"+cMonth.getSelectedItem()+"'");
			
			}catch(Exception e) {
				e.printStackTrace();
			}
			setVisible(false);
			new paytm(meter);
		}else{
			setVisible(false);
		}
	}

}
