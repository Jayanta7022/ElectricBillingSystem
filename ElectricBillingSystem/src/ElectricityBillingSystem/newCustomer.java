package ElectricityBillingSystem;

import java.awt.BorderLayout;
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

public class newCustomer extends JFrame implements ActionListener{
	// globaly declaring text feild and button for action event
	JTextField name,address,state,city,email,phone;
	JButton next,cancel;
	JLabel meterNo;
	newCustomer(){
		setSize(700,500);
		setLocation(350,100);
		JPanel p=new JPanel();
		p.setLayout(null);
		p.setBackground(new Color(173,216,230));
		add(p);
		
		
		// heading 
		JLabel heading = new JLabel("New Customer");
		heading.setBounds(280, 10, 250, 25);
		heading.setFont(new Font("Tahoma",Font.PLAIN,24));
		p.add(heading);
		
		
		//customer name created
		JLabel lblName = new JLabel(" Customer Name");
		lblName.setBounds(100, 80, 100, 20);
		p.add(lblName);
		
		// name textfeild
		name = new JTextField();
		name.setBounds(240,80,200,20);
		p.add(name);
		
		
		// lable for meter no
		JLabel lblmeterNo = new JLabel(" Meter No");
		lblmeterNo.setBounds(100, 120, 100, 20);
		p.add(lblmeterNo);
		
		//we have to make meterno feild auto generate and no editable so we have to make that feild as a label
		 meterNo = new JLabel(" ");
		meterNo .setBounds(240, 120, 100, 20);
		p.add(meterNo );
		
		//set random  meter no label
		Random ran= new Random();
		long number = ran.nextLong()%100000;
		meterNo.setText(""+Math.abs(number));
		
		
		
		//customer name created
				JLabel lbladdress = new JLabel(" Address");
				lbladdress.setBounds(100, 160, 100, 20);
				p.add(lbladdress);
				
				// name textfeild
				address = new JTextField();
				address.setBounds(240,160,200,20);
				p.add(address);
				
				
				
				//state label created
				JLabel lblstate = new JLabel(" State");
				lblstate.setBounds(100, 200, 100, 20);
				p.add(lblstate);
				
				// state textfeild
				state = new JTextField();
				state.setBounds(240,200,200,20);
				p.add(state);
		
				
				//city label created
				JLabel lblcity = new JLabel(" City");
				lblcity.setBounds(100, 240, 100, 20);
				p.add(lblcity);
				
				// city textfeild
				city = new JTextField();
				city.setBounds(240,240,200,20);
				p.add(city);
				
				//mail label created
				JLabel lblemail = new JLabel(" Email");
				lblemail .setBounds(100, 280, 100, 20);
				p.add(lblemail );
				
				// mail textfeild
				email = new JTextField();
				email.setBounds(240,280,200,20);
				p.add(email);
				
				
				//phone no label created
				JLabel lblphone = new JLabel(" Phone Number");
				lblphone .setBounds(100, 320, 100, 20);
				p.add(lblphone);
				
				// phone textfeild
				phone = new JTextField();
				phone.setBounds(240,320,200,20);
				p.add(phone);
		
				
				next= new JButton("Next");
				next.setBounds(120, 380, 100, 25);
				next.setBackground(Color.black);
				next.setForeground(Color.white);
				p.add(next);
				next.addActionListener(this);
				
				cancel= new JButton("Cancel");
				cancel.setBounds(380, 380, 100, 25);
				cancel.setBackground(Color.black);
				cancel.setForeground(Color.white);
				p.add(cancel);
				cancel.addActionListener(this);
				
				
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

	public static void main(String[] args) {
		
		new newCustomer();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==cancel) {
			setVisible(false);
		}
		if(e.getSource()==next) {
			String Dname= name.getText();
			String Dmeter= meterNo.getText();
			String Daddress= address.getText();
			String Dstate= state.getText();
			String Dcity= city.getText();
			String Demail= email.getText();
			String Dphone= phone.getText();
			
			
			String query1="insert into customer values(' "+Dname +" ', ' "+Dmeter+" ', ' "+Daddress+" ', ' "+Dcity+" ', ' "+Dstate+" ', ' "+Demail+" ', ' "+Dphone+" ')";
			String query2="insert into login values( '  ',' "+Dmeter+" ',' "+Dname+" ',' ',' ' )";
			
			try {
				Conn c= new Conn();
				c.s.executeUpdate(query1);
				c.s.executeUpdate(query2);
				
				JOptionPane.showMessageDialog(null, "customer details successfully");
				setVisible(false);
				new MeterInfo(Dmeter);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			
		}
		
	}

}
