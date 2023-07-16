package ElectricityBillingSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class updateInformation extends JFrame implements ActionListener {
	JButton cancel,update;
	JTextField tfAddress,tfCity,tfState,tfEmail,tfPhone;
	String meter;
	JLabel name;
	
	public updateInformation(String meter) {
		// TODO Auto-generated constructor stub
		this.meter=meter;
		setBounds(200, 100, 800, 350);
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel heading=new JLabel("Update Customer Information");
		heading.setBounds(20, 0, 500, 40);
		heading.setFont(new Font("Tahoma",Font.PLAIN,20));
		add(heading);
		
		
		JLabel lblName=new JLabel("Name");
		lblName.setBounds(70, 80, 100, 20);
		add(lblName);
		
		
		 name=new JLabel("");
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
		
		
	tfAddress=new JTextField();
		tfAddress.setBounds(150, 160, 200, 20);
		add(tfAddress);
		
		
		JLabel lblCity=new JLabel("City");
		lblCity.setBounds(70, 200, 100, 20);
		add(lblCity);
		
		
		tfCity= new JTextField();
		tfCity.setBounds(150, 200, 200, 20);
		add(tfCity);
		
		
		JLabel lblState=new JLabel("State");
		lblState.setBounds(400, 80, 100, 20);
		add(lblState);
		
		
		tfState=new JTextField();
		tfState.setBounds(480, 80, 200, 20);
		add(tfState);
		
		
		
		
		JLabel lblEmail=new JLabel("Email");
		lblEmail.setBounds(400, 120, 100, 20);
		add(lblEmail);
		
		
		 tfEmail=new JTextField();
		 tfEmail.setBounds(480, 120, 200, 20);
		add(tfEmail);
		
		
		JLabel lblPhone=new JLabel("Phone");
		lblPhone.setBounds(400, 160, 100, 20);
		add(lblPhone);
		
		
		tfPhone=new JTextField();
		tfPhone.setBounds(480, 160, 200, 20);
		add(tfPhone);
		
		
		try {
			Conn c= new Conn();
			ResultSet rs = c.s.executeQuery("select * from customer where meter_no= '"+meter+" ' ");
			
			while(rs.next()) {
				
		name.setText(rs.getString("name"));
				
				tfAddress.setText(rs.getString("address"));
				tfCity.setText(rs.getString("city"));
				tfState.setText(rs.getString("state"));
				meterNo.setText(rs.getString("meter_no"));
				tfPhone.setText(rs.getString("phone"));
				tfEmail.setText(rs.getString("email"));
				
				//System.out.println(rs.getString("meter_no"));
				
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		update= new JButton("update");
		update.setBackground(Color.black);
		update.setForeground(Color.white);
		update.setBounds(220, 260, 100, 30);
	update.addActionListener(this);
		add(update);
		
		cancel= new JButton("cancel");
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		cancel.setBounds(360, 260, 100, 30);
		cancel.addActionListener(this);
		add(cancel);
		
		
//		ImageIcon i1=new ImageIcon(getClass().getResource("viewcustomer.jpg"));
//		Image i2=i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
//		JLabel image=new JLabel(new ImageIcon(i2));
//		image.setBounds(60,250,500,200);
//		add(image);
		
		
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==cancel) {
			setVisible(false);
		}
		else {
			String dAddress=tfAddress.getText();
			String dState= tfState.getText();
			String dCity=tfCity.getText();
			String dEmail=tfEmail.getText();
			String DPhone=tfPhone.getText();
			
			try {
				Conn c= new Conn();
				c.s.executeUpdate("update customer set address=' "+dAddress+" ', city=' "+dCity+" ', state=' "+dState+" ', email=' "+dEmail+" ', phone=' "+DPhone+" ' where meter_no=' "+meter+" '");
				JOptionPane.showMessageDialog(null,"User Information Updated Successfully");
				setVisible(false);
			}catch(Exception e1){
				e1.printStackTrace();
			}
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new  updateInformation("");

	}

}
