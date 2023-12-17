package atm.stimulation.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Deposit extends JFrame implements ActionListener{
    JTextField amount;
    JButton deposit, back;
    String pinNum;
    Deposit(String pinNum){
        this.pinNum = pinNum;
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("Icon/atm.jpg"));
        Image image = icon1.getImage().getScaledInstance(900, 900, Image.SCALE_SMOOTH);
        ImageIcon icon2 = new ImageIcon(image);
        JLabel imgLabel = new JLabel(icon2);
        imgLabel.setBounds(0, 0, 900, 900);
        add(imgLabel);
        
        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setBounds(195, 290, 350, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Poppins", Font.BOLD, 16));
        imgLabel.add(text);
        
        amount = new JTextField();
        amount.setBounds(195, 335, 283, 24);
        amount.setFont(new Font("Raleway",Font.PLAIN,16));
        imgLabel.add(amount);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(358, 490, 150, 24);
        deposit.addActionListener(this);
        imgLabel.add(deposit);
        
        back = new JButton("Back");
        back.setBounds(358, 520, 150, 24);
        back.addActionListener(this);
        imgLabel.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == deposit){
            String amt = amount.getText();
            Date date = new Date();
            if(amt.isEmpty()){
                JOptionPane.showMessageDialog(null, "Enter valid Amount");
            }else{
                
                try{
                    Conn c = new Conn();
                    String query = "insert into bank values('"+pinNum+"' ,'"+date+"', 'Deposit', '"+amt+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"RS "+amt+" deposited successfully.");
                    setVisible(false);
                    new Transactions(pinNum).setVisible(true);
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }else if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinNum).setVisible(true);
        }
    }
    public static void main(String[] args){
        new Deposit("");
    }
}
