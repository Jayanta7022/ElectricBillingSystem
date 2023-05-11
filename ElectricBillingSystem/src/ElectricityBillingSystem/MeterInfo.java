package ElectricityBillingSystem;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MeterInfo extends JFrame implements ActionListener{
	// globaly declaring text feild and button for action event
	JTextField name,address,state,city,email,phone;
	JButton next,cancel;
	JLabel meterNo;
	Choice meterlocation,metertype,phasecode, billtype;
	String meterno;
	MeterInfo(String meterno){
		this.meterno= meterno;
		setSize(700,500);
		setLocation(350,100);
		JPanel p=new JPanel();
		p.setLayout(null);
		p.setBackground(new Color(173,216,230));
		add(p);
		
		
		// heading 
		JLabel heading = new JLabel("Meter Information");
		heading.setBounds(280, 10, 250, 25);
		heading.setFont(new Font("Tahoma",Font.PLAIN,24));
		p.add(heading);
		
		
		
		JLabel lblmeternumber= new JLabel(" Meter Number");
		lblmeternumber.setBounds(100, 80, 100, 20);
		p.add(lblmeternumber);
		
		
		JLabel lblmeter = new JLabel(meterno);
		lblmeter.setBounds(240,80, 100, 20);
		p.add(lblmeter);
		
		
		
		JLabel lblmeterlcn = new JLabel(" Meter Location");
		lblmeterlcn .setBounds(100, 120, 100, 20);
		p.add(lblmeterlcn );
		
		meterlocation= new Choice();
		meterlocation.add("inside");
		meterlocation.add("outside");
		meterlocation.setBounds(240,120,200,20);
		p.add(meterlocation);
		
		
		
		
		//customer name created
				JLabel lblmetertype = new JLabel(" Meter Type");
				lblmetertype.setBounds(100, 160, 100, 20);
				p.add(lblmetertype);
				
				metertype= new Choice();
				metertype.add("Electric Meter");
				metertype.add("Solar Meter");
				metertype.add("Smart Meter");
				metertype.setBounds(240,160,200,20);
				p.add(metertype);
				
				
				
				//state label created
				JLabel lblphasecode = new JLabel(" Phase Code");
				lblphasecode.setBounds(100, 200, 100, 20);
				p.add(lblphasecode);
				
				phasecode= new Choice();
				phasecode.add("011");
				phasecode.add("022");
				phasecode.add("033");
				phasecode.add("044");
				phasecode.add("055");
				phasecode.add("066");
				phasecode.add("077");
				phasecode.add("088");
				phasecode.add("099");
				
				phasecode.setBounds(240,200,200,20);
				p.add(phasecode);
		
				
				//billtype label created
				JLabel lblbilltype = new JLabel(" Bill Type");
				lblbilltype.setBounds(100, 240, 100, 20);
				p.add(lblbilltype);
				
				// billtype choice is created
				billtype= new Choice();
				billtype.setBounds(240,240,200,20);
				billtype.add("Industrial Meter");
				billtype.add("Normal Meter");
				p.add(billtype);
				
				//mail label created
				JLabel lbldays = new JLabel(" Days");
				lbldays .setBounds(100, 280, 100, 20);
				p.add(lbldays );
				
				JLabel days = new JLabel(" 30 Days");
				days .setBounds(240, 280, 200, 20);
				p.add(days );
				
				
				JLabel lblnote = new JLabel(" Note");
				lblnote .setBounds(100, 320, 100, 20);
				p.add(lblnote);
				
				
				JLabel note= new JLabel("By Default Bill Is Calculated For 30 Days");
			note.setBounds(240,320,500,20);
				p.add(note);
		
				
				next= new JButton("Submit");
				next.setBounds(220, 380, 100, 25);
				next.setBackground(Color.black);
				next.setForeground(Color.white);
				p.add(next);
				next.addActionListener(this);
				
				
				
				
				setLayout(new BorderLayout());
				add(p,"Center");
				
				ImageIcon i1= new ImageIcon(getClass().getResource("hicon1.jpg"));
			   Image i2= i1.getImage().getScaledInstance(150, 300,Image.SCALE_DEFAULT);
			   ImageIcon i3=new ImageIcon(i2);
			   JLabel image= new JLabel(i3);
			   add(image,"West");
			   
			   
			   getContentPane().setBackground(Color.WHITE);;
				
				
		
		
		
		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==cancel) {
			setVisible(false);
		}
		if(e.getSource()==next) {
			String meter=meterno;
			String location= meterlocation.getSelectedItem();
			String type= metertype.getSelectedItem();
			String code= phasecode.getSelectedItem();
			String typebill= billtype.getSelectedItem();
			String days= "30";
			
			
			
			String query="insert into meter_info values(' "+meter +" ', ' "+location+" ', ' "+type+" ', ' "+code+" ', ' "+typebill+" ', ' "+days+" ')";
			
			
			try {
				Conn c= new Conn();
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Meter Information Added	Succesfully");
				setVisible(false);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			
		}
		
	}
	public static void main(String[] args) {
		
		new MeterInfo("");

	}


}

