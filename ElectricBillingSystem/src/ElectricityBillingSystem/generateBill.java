package ElectricityBillingSystem;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class generateBill  extends JFrame  implements ActionListener{
	JButton bill;
	String meter;
	Choice cMonth;
	JTextArea area;
	generateBill(String meter){
		
		this.meter= meter;
		
		setLayout(new BorderLayout());
		JPanel jp=new JPanel();
		
		
		JLabel heading= new JLabel("Generate Bill");
		
		JLabel meterno= new JLabel(meter);
		
		
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
		
		
		area= new JTextArea(50,15);
		area.setText("\n\n\t----------Click on the----------\n\t Generate Bill Button to Get \n\the Bill of The Selected Month ");
		area.setFont(new Font("Senserif",Font.ITALIC,18));
		
		JScrollPane pane= new JScrollPane(area);
		
		bill= new JButton("Generate Bill");
		bill.addActionListener(this);
		
		
		jp.add(heading);
		jp.add(cMonth);
		jp.add(meterno);
		add(jp,"North");
		add(pane,"Center");
		add(bill,"South");
		
		
		
		
		setSize(550,600);
		setLocation(400,50);
		setVisible(true);
		 // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new generateBill("");

	}


	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		try {
			Conn c= new Conn();
			String month= cMonth.getSelectedItem();
			
			area.setText("\tReliance Power Limited\nELECTRICITY BILL FOR THE MONTH OF "+month+" ,2021\n\n\n");
			ResultSet rs = c.s.executeQuery("select * from customer where meter_no='"+ meter+"'");
			
			  
            if(rs.next()){
                area.append("\n    Customer Name:"+rs.getString("name"));
                area.append("\n    Meter Number:  "+rs.getString("meter_no"));
                area.append("\n    Address:            "+rs.getString("address"));
                area.append("\n    State:                 "+rs.getString("state"));
                area.append("\n    City:                   "+rs.getString("city"));
                area.append("\n    Email:                "+rs.getString("email"));
                area.append("\n    Phone Number  "+rs.getString("phone"));
                area.append("\n-------------------------------------------------------------");
                area.append("\n");
            }
            rs = c.s.executeQuery("select * from meter_info where meter_no ='"+ meter+"' " );
            
            if(rs.next()){
                area.append("\n    Meter Location:"+rs.getString("meter_location"));
                area.append("\n    Meter Type:      "+rs.getString("meter_type"));
                area.append("\n    Phase Code:    "+rs.getString("phase_code"));
                area.append("\n    Bill Type:         "+rs.getString("bill_type"));
                area.append("\n    Days:               "+rs.getString("days"));
                area.append("\n");
            }
            
            rs = c.s.executeQuery("select * from tax");
            
            if(rs.next()){
                area.append("---------------------------------------------------------------");
                area.append("\n\n");
                area.append("\n Cost per Unit:             Rs "+rs.getString("cost_per_unit"));
                area.append("\n Meter Rent:                Rs "+rs.getString("meter_rent"));
                area.append("\n Service Charge:            Rs "+rs.getString("service_charge"));
                area.append("\n Service Tax:               Rs "+rs.getString("service_tax"));
                area.append("\n Swacch Bharat Cess:        Rs "+rs.getString("swacch_bharat_cess"));
                area.append("\n Fixed Tax:                 Rs "+rs.getString("fixed_tax"));
                area.append("\n");
            }
            
            rs = c.s.executeQuery("select * from bill where meter='"+meter+"' AND month = '"+cMonth.getSelectedItem()+"'");
            
            
            
            if(rs.next()){
                area.append("\n    Current Month :\t"+rs.getString("month"));
                area.append("\n    Units Consumed:\t"+rs.getString("units"));
                area.append("\n    Total Charges :\t"+rs.getString("total_bill"));
                area.append("\n---------------------------------------------------------------");
                area.append("\n    TOTAL PAYABLE :\t"+rs.getString("total_bill"));
            }
            
            
		}catch(Exception e) {
			
		}
		
		
	}

}
