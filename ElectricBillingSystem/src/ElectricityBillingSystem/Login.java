package ElectricityBillingSystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Login extends JFrame {
	
	Login(){
		super("login page");
		getContentPane().setBackground(Color.WHITE);
		
		setLayout(null);
		//lebel of user name=>
		JLabel lbluserName= new JLabel("username");
		lbluserName.setBounds(300, 20, 100, 20);
		add(lbluserName);
		
		//textfeild of username=>
		JTextField userName=new JTextField();
		userName.setBounds(400,20,200,20);
		add(userName);
		
		//label of password=>
		JLabel lblpassword= new JLabel("password");
		lblpassword.setBounds(300, 60, 100, 20);
		add(lblpassword);
		
		//textfeild of password=>
		JTextField password=new JTextField();
		password.setBounds(400,60,200,20);
		add(password);
		
		
		//label of login as=>
		JLabel lblLogInAs= new JLabel("logInAs");
		lblLogInAs.setBounds(300, 100, 100, 20);
		add(lblLogInAs);
		
		//dropdown of login as
		Choice loginAs= new Choice();
		loginAs.add("Admin");
		loginAs.add("User");
		loginAs.setBounds(400,100,200,20);
		add(loginAs);
		
		//login button
		ImageIcon i1= new ImageIcon(getClass().getResource("login.png"));
		Image i2=i1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		JButton login=new JButton("log in",new ImageIcon(i2));
		login.setBounds(350, 160, 100, 20);
		add(login);
		
		//cancel button=>
		ImageIcon i3=new ImageIcon(getClass().getResource("cancel.jpg"));
		Image i4=i3.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		JButton cancel = new JButton("cancel", new ImageIcon(i4));
		cancel.setBounds(470,160,100,20);
		add(cancel);
		
		//signup button
		ImageIcon i5=new ImageIcon(getClass().getResource("signup.png"));
		Image i6=i5.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		JButton signup = new JButton("signup",new ImageIcon(i6));
		signup.setBounds(400,200,100,20);
		add(signup);
		
		//add the last image
		ImageIcon i7=new ImageIcon(getClass().getResource("second.jpg"));
		Image i8=i7.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
		JLabel image= new JLabel(new ImageIcon(i8));
		image.setBounds(0,0,250,250);
		add(image);
		setSize(640, 300);
		setLocation(400, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		
		
		new Login();
	}

}
