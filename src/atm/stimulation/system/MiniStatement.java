package atm.stimulation.system;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
public class MiniStatement extends JFrame{
    String pinNum, bal;
    MiniStatement(String pinNum){
        this.pinNum = pinNum;
        setLayout(null);
        setTitle("Mini Statement");
        
        JLabel bank = new JLabel("BANK OF YASAT");
        bank.setBounds(105, 20, 200, 20);
        bank.setFont(new Font("Raleway", Font.BOLD,20));
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(30, 70, 400, 20);
        card.setFont(new Font("Raleway", Font.BOLD,20));
        add(card);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin_num = '"+pinNum+"'");
            int avalBal = 0;
            while(rs.next()){
                if(rs.getString("transaction_type").equals("Deposit")){
                    avalBal += Integer.parseInt(rs.getString("amount"));
                }else{
                    avalBal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            this.bal = ""+avalBal;
        }catch(Exception e){
            System.out.println(e);
        }
        JLabel balance = new JLabel("Available Balance : "+bal);
        balance.setBounds(30, 100, 400, 20);
        balance.setFont(new Font("Raleway", Font.BOLD,20));
        add(balance);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin_num = '"+pinNum+"'");
            while(rs.next()){
                card.setText("Card Number : " + rs.getString("card_num").substring(0,2)
                        +"XXXX"+rs.getString("card_num").substring(6));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        JLabel mini = new JLabel();
        mini.setBounds(30, 130, 300, 200);
        add(mini);
        try{
            Conn c = new Conn();
            ResultSet rs2 = c.s.executeQuery("select * from bank where pin_num = '"+pinNum+"'");
            while(rs2.next()){
                mini.setText(mini.getText() + "<html>"+rs2.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                        +rs2.getString("transaction_type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                        +rs2.getString("amount")+"<br><br></html>");
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        setSize(400,600);
        setLocation(300,0);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
  
    public static void main(String args[]){
        new MiniStatement("");
    }
}
