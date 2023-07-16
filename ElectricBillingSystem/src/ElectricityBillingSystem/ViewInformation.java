package ElectricityBillingSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.*;
import java.sql.*;


public class ViewInformation extends JFrame implements ActionListener {
	
	JButton cancel;
	String meter;
public ViewInformation(String meter) {
	this.meter=meter;
	setSize(700,500);
	setLocation(350, 100);
	getContentPane().setBackground(Color.white);
	
	setLayout(null);
	
	
	
	JLabel heading=new JLabel("View Customer Information");
	heading.setBounds(220, 0, 500, 40);
	heading.setFont(new Font("Tahoma",Font.PLAIN,20));
	add(heading);
	
	
	JLabel lblName=new JLabel("Name");
	lblName.setBounds(70, 80, 100, 20);
	add(lblName);
	
	
	JLabel name=new JLabel("");
	name.setBounds(200, 80, 100, 20);
	add(name);
	
	
	
	JLabel lblMeterNo=new JLabel("Meter No");
	lblMeterNo.setBounds(70, 120, 100, 20);
	add(lblMeterNo);
	
	
	JLabel meterNo=new JLabel("");
	meterNo.setBounds(200, 120, 100, 20);
	add(meterNo);
	
	

	JLabel lblAddress=new JLabel("Address");
	lblAddress.setBounds(70, 160, 100, 20);
	add(lblAddress);
	
	
	JLabel address=new JLabel("");
	address.setBounds(200, 160, 100, 20);
	add(address);
	
	
	JLabel lblCity=new JLabel("City");
	lblCity.setBounds(70, 200, 100, 20);
	add(lblCity);
	
	
	JLabel city=new JLabel("");
	city.setBounds(200, 200, 100, 20);
	add(city);
	
	
	JLabel lblState=new JLabel("State");
	lblState.setBounds(350, 80, 100, 20);
	add(lblState);
	
	
	JLabel state=new JLabel("");
	state.setBounds(400, 80, 100, 20);
	add(state);
	
	
	
	
	JLabel lblEmail=new JLabel("Email");
	lblEmail.setBounds(350, 120, 100, 20);
	add(lblEmail);
	
	
	JLabel email=new JLabel("");
	email.setBounds(400, 120, 300, 20);
	add(email);
	
	
	JLabel lblPhone=new JLabel("Phone");
	lblPhone.setBounds(350, 160, 100, 20);
	add(lblPhone);
	
	
	JLabel phone=new JLabel("");
	phone.setBounds(400, 160, 100, 20);
	add(phone);
	
	
	try {
		Conn c= new Conn();
		ResultSet rs = c.s.executeQuery("select * from customer where meter_no= '"+meter+" ' ");
		//System.out.println(rs.getString("meter_no"));
//		System.out.println(rs.next());
//		System.out.println(meter);
//		System.out.println(rs.getString("meter_no"));
//		System.out.println(rs.getString("name"));
		while(rs.next()) {
			//System.out.println("fgxvhabjn");
		
			//System.out.println(rs.next());
	name.setText(rs.getString("name"));
			
			address.setText(rs.getString("address"));
			city.setText(rs.getString("city"));
			state.setText(rs.getString("state"));
			meterNo.setText(rs.getString("meter_no"));
			phone.setText(rs.getString("phone"));
			email.setText(rs.getString("email"));
			
			//System.out.println(rs.getString("meter_no"));
			
			
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	
	cancel= new JButton("cancel");
	cancel.setBackground(Color.black);
	cancel.setForeground(Color.white);
	cancel.setBounds(250, 220, 100, 30);
	cancel.addActionListener(this);
	add(cancel);
	
	
	ImageIcon i1=new ImageIcon(getClass().getResource("viewcustomer.jpg"));
	Image i2=i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
	JLabel image=new JLabel(new ImageIcon(i2));
	image.setBounds(60,250,500,200);
	add(image);
	
	
	setVisible(true);
}
	
	
	
	
	public static void main(String []args) {
		new ViewInformation("");
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==cancel) {
			setVisible(false);
		}
		
	}
}
