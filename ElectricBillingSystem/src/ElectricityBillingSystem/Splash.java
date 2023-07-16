package ElectricityBillingSystem;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Image;

import javax.swing.*;

public class Splash extends JFrame implements Runnable {
	Thread t;
	
	Splash(){
		
		ImageIcon  i1= new ImageIcon(getClass().getResource("elect.jpg"));
		Image i2= i1.getImage().getScaledInstance(730, 550, Image.SCALE_DEFAULT);
		JLabel image=new JLabel(new ImageIcon(i2));
		add(image);
		setVisible(true);
		
		int x=1;
		for(int i=2;i<550;i+=4,x++) {
			setSize(i+x,i);
			setLocation(650-((i+x)/2),300-i/2);
			
			try {
				Thread.sleep(15	);
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		t=new Thread(this);
		t.start();
		setVisible(true);
		  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void run() {
		try {
			Thread.sleep(6000);
			setVisible(false);
			new Login();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String args[]) {
		new Splash();
	}
	
}
