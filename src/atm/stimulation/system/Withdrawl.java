package atm.stimulation.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;
public class Withdrawl extends JFrame implements ActionListener{
    JTextField amount;
    JButton confirm, back;
    String pinNum;
    Withdrawl(String pinNum){
        this.pinNum = pinNum;
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("Icon/atm.jpg"));
        Image image = icon1.getImage().getScaledInstance(900, 900, Image.SCALE_SMOOTH);
        ImageIcon icon2 = new ImageIcon(image);
        JLabel imgLabel = new JLabel(icon2);
        imgLabel.setBounds(0, 0, 900, 900);
        add(imgLabel);
        
        JLabel text = new JLabel("Enter the amount you want to withdraw");
        text.setBounds(185, 290, 350, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Poppins", Font.BOLD, 16));
        imgLabel.add(text);
        
        amount = new JTextField();
        amount.setBounds(195, 335, 283, 24);
        amount.setFont(new Font("Raleway",Font.PLAIN,16));
        imgLabel.add(amount);
        
        confirm = new JButton("Confirm");
        confirm.setBounds(358, 490, 150, 24);
        confirm.addActionListener(this);
        imgLabel.add(confirm);
        
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
        if(ae.getSource() == confirm){
            String amt = amount.getText();
            Date date = new Date();
            if(amt.isEmpty()){
                JOptionPane.showMessageDialog(null, "Enter valid Amount");
            }else{
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from bank where pin_num = '"+pinNum+"'");
                    int balance = 0;
                    while(rs.next()){
                        if(rs.getString("transaction_type").equals("Deposit")){
                            balance += Integer.parseInt(rs.getString("amount"));
                        }else{
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }
                    if(balance < Integer.parseInt(amt)){
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }else{
                        String query = "insert into bank values('"+pinNum+"' ,'"+date+"', 'Withdrawl', '"+amt+"')";
                        c.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null,"RS "+amt+" Withdrawn successfully.");
                        setVisible(false);
                        new Transactions(pinNum).setVisible(true);
                    }
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
        new Withdrawl("");
    }
}
