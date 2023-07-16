package ElectricityBillingSystem;



import java.awt.*;
import java.net.URL;
import java.awt.event.*;
import javax.swing.*;

public class paytm extends JFrame implements ActionListener{
    String meter;
    JButton b1;
    paytm(String meter){
        this.meter = meter;
        JEditorPane j = new JEditorPane();
        j.setEditable(false);   
        
        b1 = new JButton("Back");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(500, 20, 120, 25);
        b1.addActionListener(this);
        j.add(b1);

        try {
            j.setPage(new URL("https://paytm.com/online-payments"));
        }catch (Exception e) {
            j.setContentType("text/html");
            j.setText("<html>Could not load</html>");
        } 

        JScrollPane scrollPane = new JScrollPane(j);  
        scrollPane.setBounds(250,120, 800,500);
        scrollPane .getVerticalScrollBar().setUnitIncrement(10);
       add(scrollPane);
      
       
       
       
        setSize(800,500);
        setLocation(250,120);
        setVisible(true);
     //   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
        new payBill(meter).setVisible(true);
    }
    public static void main(String[] args){
        new paytm("").setVisible(true);
    }
}
