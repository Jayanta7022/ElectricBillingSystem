package ElectricityBillingSystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Signup extends JFrame implements ActionListener {
	
	//declairing buttons globally because if  it would be in the constructor
		//it can not be called from another function like actionperformer
	JButton Create,Back;
	Choice accountType;
	JTextField meterNo,userName,Name,password;
	
	 public Signup() {
		 //frame draw
		setSize(700, 400);
		setLocation(450, 150);
		getContentPane().setBackground(Color.white);
		
		//panel draw=>
		JPanel panel=new JPanel();
		panel.setBounds(30, 30, 630, 300);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(200,250,130), 7),"Create_Account",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(200,250,130)));
		panel.setBackground(Color.white);
		panel.setLayout(null);
		panel.setForeground(new Color(13,130,13));
		add(panel);
		
		//heading label=>
		JLabel heading = new JLabel("Crreate Account As");
		heading.setBounds(75, 50, 145,20 );
		heading.setForeground(Color.GRAY);
		heading.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(heading);
		
		//making to select admin or users
		
		 accountType= new Choice();
		accountType.add("Admin");
		accountType.add("Users");
		accountType.setBounds(230, 50, 150, 20);
		panel.add(accountType);
		
		//making meter no label
		JLabel lblMeterNo = new JLabel("User Name");
		lblMeterNo.setBounds(75,90 , 145,20 );
		lblMeterNo.setForeground(Color.GRAY);
		lblMeterNo.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(lblMeterNo);
		
		
		//making text box for meterno
		meterNo=new JTextField();
		meterNo.setBounds(230, 90, 150, 20);
		panel.add(meterNo);
		
		
		//making username no label
		JLabel lblUserName = new JLabel("Meter No");
		lblUserName.setBounds(75,130 , 145,20 );
		lblUserName.setForeground(Color.GRAY);
		lblUserName.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(lblUserName);
				
				
		//making text box for username
		 userName=new JTextField();
		userName.setBounds(230, 130, 150, 20);
		panel.add(userName);
		
		
		//making username no label
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(75,170 , 145,20 );
		lblName.setForeground(Color.GRAY);
		lblName.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(lblName);
						
						
		//making text box for username
		 Name=new JTextField();
		Name.setBounds(230, 170, 150, 20);
		panel.add(Name);
				
		
		
		
		//making password no label
		JLabel lblpassword = new JLabel("Password");
		lblpassword.setBounds(75,210 , 145,20 );
		lblpassword.setForeground(Color.GRAY);
		lblpassword.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(lblpassword);
						
						
		//making text box for password
		password=new JTextField();
		password.setBounds(230, 210, 150, 20);
		panel.add(password);
		
		
		//making create button
		 Create= new JButton("create");
		Create.setBackground(Color.black);
		Create.setForeground(Color.WHITE);
		Create.setBounds(180, 240, 80, 25);
		Create.addActionListener(this);
		panel.add(Create);
		
		//making back button
		 Back= new JButton("Back");
		Back.setBackground(Color.black);
		Back.setForeground(Color.WHITE);
		Back.setBounds(330, 240, 80, 25);
		Back.addActionListener(this);
		panel.add(Back);
				
		
		//image for signup page
		ImageIcon i1=new ImageIcon(getClass().getResource("signupImage.png"));
		Image i2= i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
		JLabel image=new JLabel(new  ImageIcon(i2));
		image.setBounds(400, 20, 250, 250);
		panel.add(image);
		
		
		setLayout(null);
		
		
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Signup();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// code for entry in database
		if(e.getSource()==Create) {
			String aType=accountType.getSelectedItem();
			String sUserName= userName.getText();
			String sName= Name.getText();
			String sPassword= password.getText();
			String sMeterNo= meterNo.getText();
			
			//connection with data base
			try {
				Conn c= new Conn();
				String query= "insert into login values( ' " +sUserName+" ',  ' " +sMeterNo+" ',    ' " +sName+ " ',  ' " +sPassword+" ',  ' " +aType+" ' )";
				
				// executing query 
				c.s.executeUpdate(query);
				
				// showing success
				
				JOptionPane.showMessageDialog(null, "Account Created Successfully");
				
				// changing tab to login
				setVisible(false);
				new Login();
			}catch(Exception e1){
				e1.printStackTrace();
			}
			
		}
		else if(e.getSource()==Back) {
			setVisible(false);
			new Login();
			
		}
		
	}

}
