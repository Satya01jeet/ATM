package atm.stimulation.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Transactions extends JFrame implements ActionListener {
    JButton deposit,withdrawl,fastCash,minStatement,pinChange,balenq,exit;
    String pinNum;
    Transactions(String pinNum){
        this.pinNum = pinNum;
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("Icon/atm.jpg"));
        Image image = icon1.getImage().getScaledInstance(900, 900, Image.SCALE_SMOOTH);
        ImageIcon icon2 = new ImageIcon(image);
        JLabel imgLabel = new JLabel(icon2);
        imgLabel.setBounds(0, 0, 900, 900);
        add(imgLabel);
        
        JLabel text = new JLabel("Choose your transaction");
        text.setBounds(220, 290, 300, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Poppins", Font.BOLD, 18));
        imgLabel.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(155, 420, 150, 24);
        deposit.addActionListener(this);
        imgLabel.add(deposit);
        
        withdrawl = new JButton("Withdrawl");
        withdrawl.setBounds(366, 420, 150, 24);
        withdrawl.addActionListener(this);
        imgLabel.add(withdrawl);
        
        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(155, 453, 150, 24);
        fastCash.addActionListener(this);
        imgLabel.add(fastCash);
        
        minStatement = new JButton("Mini Statement");
        minStatement.setBounds(366, 453, 150, 24);
        minStatement.addActionListener(this);
        imgLabel.add(minStatement);
        
        pinChange = new JButton("Pin Change");
        pinChange.setBounds(155, 486, 150, 24);
        pinChange.addActionListener(this);
        imgLabel.add(pinChange);
        
        balenq = new JButton("Balance Enquiry");
        balenq.setBounds(366, 486, 150, 24);
        balenq.addActionListener(this);
        imgLabel.add(balenq);
        
        exit = new JButton("Exit");
        exit.setBounds(155, 519, 360, 24);
        exit.addActionListener(this);
        imgLabel.add(exit);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            System.exit(0);
        }else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinNum).setVisible(true);
        }else if(ae.getSource()==withdrawl){
            setVisible(false);
            new Withdrawl(pinNum).setVisible(true);
        }else if(ae.getSource()==fastCash){
            setVisible(false);
            new FastCash(pinNum).setVisible(true);
        }else if(ae.getSource()==pinChange){
            setVisible(false);
            new PinChange(pinNum).setVisible(true);
        }else if(ae.getSource()==balenq){
            setVisible(false);
            new BalanceEnquiry(pinNum).setVisible(true);
        }else if(ae.getSource()==minStatement){
            new MiniStatement(pinNum).setVisible(true);
        }
    }
    public static void main(String args[]){
        new Transactions("");
    }
}
