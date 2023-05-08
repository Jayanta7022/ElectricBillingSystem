package ElectricityBillingSystem;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class Project extends JFrame{
	
	Project(){
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		ImageIcon i1= new ImageIcon(getClass().getResource("elect1.jpg"));
		Image i2=i1.getImage().getScaledInstance(1400, 700, Image.SCALE_DEFAULT);
		JLabel image= new JLabel(new ImageIcon(i2));
		add(image);
		
		JMenuBar mb= new JMenuBar();
		setJMenuBar(mb);
		
		JMenu master = new JMenu("Master");
		master.setForeground(Color.blue);
		mb.add(master);
		// new customer menu item create
		JMenuItem newcustomer= new JMenuItem("New Customer");
		newcustomer.setFont(new Font("monospaced", Font.PLAIN,12));
		newcustomer.setBackground(Color.WHITE);
		ImageIcon icon1= new ImageIcon(getClass().getResource("icon1.png"));
		Image image1=icon1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		newcustomer.setIcon(new ImageIcon(image1));
		newcustomer.setMnemonic('D');
		newcustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
		master.add(newcustomer);
		
		
		//customer details menu item create
		JMenuItem customerdetails= new JMenuItem(" Customer Details");
		customerdetails.setFont(new Font("monospaced", Font.PLAIN,12));
		customerdetails.setBackground(Color.WHITE);
		ImageIcon icon2= new ImageIcon(getClass().getResource("icon2.png"));
		Image image2=icon2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		customerdetails.setIcon(new ImageIcon(image2));
		customerdetails.setMnemonic('M');
		customerdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
		master.add(customerdetails);
		
		
		
		//deposit details menuitem create
		
		JMenuItem  Depositdetail= new JMenuItem(" Deposit Details");
		 Depositdetail.setFont(new Font("monospaced", Font.PLAIN,12));
		 Depositdetail.setBackground(Color.WHITE);
		ImageIcon icon3= new ImageIcon(getClass().getResource("icon3.png"));
		Image image3=icon3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		 Depositdetail.setIcon(new ImageIcon(image3));
		 Depositdetail.setMnemonic('A');
		 Depositdetail.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
		master.add( Depositdetail);
		
		
		//Calculate Bill menuitem create
		
		JMenuItem  Calculatebill= new JMenuItem(" Calculate Bill");
		Calculatebill.setFont(new Font("monospaced", Font.PLAIN,12));
		Calculatebill.setBackground(Color.WHITE);
		ImageIcon icon4= new ImageIcon(getClass().getResource("icon4.png"));
		Image image4=icon4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		Calculatebill.setIcon(new ImageIcon(image4));
		Calculatebill.setMnemonic('B');
		Calculatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
		master.add( Calculatebill);
		
		
		//second menu info create
		JMenu info = new JMenu("Info");
		info.setForeground(Color.red);
		mb.add(info);
		
		
		// update info menuitem create
		JMenuItem  updateinfo= new JMenuItem(" Update Information");
		updateinfo.setFont(new Font("monospaced", Font.PLAIN,12));
		updateinfo.setBackground(Color.WHITE);
		ImageIcon icon5= new ImageIcon(getClass().getResource("icon5.png"));
		Image image5=icon5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		updateinfo.setIcon(new ImageIcon(image5));
		updateinfo.setMnemonic('P');
		updateinfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
		info.add( updateinfo);
		
		
		//view information menuitem create
		JMenuItem  viewinfo= new JMenuItem(" view Information");
		viewinfo.setFont(new Font("monospaced", Font.PLAIN,12));
		viewinfo.setBackground(Color.WHITE);
		ImageIcon icon6= new ImageIcon(getClass().getResource("icon6.png"));
		Image image6=icon6.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		viewinfo.setIcon(new ImageIcon(image6));
		viewinfo.setMnemonic('L');
		viewinfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.CTRL_MASK));
		info.add( viewinfo);
		
		
		//menu for user create
		JMenu user = new JMenu("User");
		user.setForeground(Color.blue);
		mb.add(user);
		
		
		// paybill menuitem create
				JMenuItem  paybill= new JMenuItem(" Pay Bill");
				paybill.setFont(new Font("monospaced", Font.PLAIN,12));
				paybill.setBackground(Color.WHITE);
				ImageIcon icon7= new ImageIcon(getClass().getResource("icon7.png"));
				Image image7=icon7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
				paybill.setIcon(new ImageIcon(image7));
				paybill.setMnemonic('R');
				paybill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
				user.add( paybill);
				
				
				//bill details menuitem create
				JMenuItem  billdetails= new JMenuItem(" Bill Details");
				 billdetails.setFont(new Font("monospaced", Font.PLAIN,12));
				 billdetails.setBackground(Color.WHITE);
				ImageIcon icon8= new ImageIcon(getClass().getResource("icon8.png"));
				Image image8=icon8.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
				 billdetails.setIcon(new ImageIcon(image8));
				 billdetails.setMnemonic('S');
				 billdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
				user.add(  billdetails);
				
				//report menu create
				JMenu report = new JMenu("Report");
				report.setForeground(Color.RED);
				mb.add(report);
				
				
				// generatebill menu item create
						JMenuItem  genbill= new JMenuItem(" Generate Bill");
						 genbill.setFont(new Font("monospaced", Font.PLAIN,12));
						 genbill.setBackground(Color.WHITE);
						ImageIcon icon9= new ImageIcon(getClass().getResource("icon9.png"));
						Image image9=icon9.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
						 genbill.setIcon(new ImageIcon(image9));
						 genbill.setMnemonic('T');
						 genbill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,ActionEvent.CTRL_MASK));
						report.add( genbill);
						
						
						
						//utility menu create
						JMenu utility = new JMenu("Utility");
						utility.setForeground(Color.blue);
						mb.add(utility);
						
						
						
						//notepad menu item create
						JMenuItem  notepad= new JMenuItem("Notepad");
						notepad.setFont(new Font("monospaced", Font.PLAIN,12));
						notepad.setBackground(Color.WHITE);
						ImageIcon icon10= new ImageIcon(getClass().getResource("icon12.png"));
						Image image10=icon10.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
						notepad.setIcon(new ImageIcon(image10));
						notepad.setMnemonic('N');
						notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
						utility.add( notepad);
						
						
						//calculator menu item added
						JMenuItem  calculator= new JMenuItem("Calculator");
						calculator.setFont(new Font("monospaced", Font.PLAIN,12));
						calculator.setBackground(Color.WHITE);
						ImageIcon icon11= new ImageIcon(getClass().getResource("icon9.png"));
						Image image11=icon10.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
						calculator.setIcon(new ImageIcon(image11));
						calculator.setMnemonic('U');
						calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,ActionEvent.CTRL_MASK));
						utility.add( calculator);
						
				
						
						//exit manu add
						JMenu mexit = new JMenu("Exit");
						mexit.setForeground(Color.red);
						mb.add(mexit);
						
						//exit menu item add
						JMenuItem  exit= new JMenuItem("exit");
						exit.setFont(new Font("monospaced", Font.PLAIN,12));
						exit.setBackground(Color.WHITE);
						ImageIcon icon12= new ImageIcon(getClass().getResource("icon11.png"));
						Image image12=icon12.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
						exit.setIcon(new ImageIcon(image12));
						exit.setMnemonic('U');
						exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,ActionEvent.CTRL_MASK));
						mexit.add( exit);
						
						
		
		
		
		setLayout(new FlowLayout());
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new Project();

	}

}
