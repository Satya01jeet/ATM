package atm.stimulation.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener{
    JButton back;
    String pinNum;
    String bal;
    BalanceEnquiry(String pinNum){
        this.pinNum = pinNum;
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("Icon/atm.jpg"));
        Image image = icon1.getImage().getScaledInstance(900, 900, Image.SCALE_SMOOTH);
        ImageIcon icon2 = new ImageIcon(image);
        JLabel imgLabel = new JLabel(icon2);
        imgLabel.setBounds(0, 0, 900, 900);
        add(imgLabel);
        
        JLabel text = new JLabel("AVAILABLE BALANCE");
        text.setBounds(250, 290, 350, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Poppins", Font.BOLD, 16));
        imgLabel.add(text);
        
        Conn c = new Conn();
        try{
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
        
        JLabel balance = new JLabel(bal);
        balance.setBounds(300, 340, 150, 25);
        balance.setForeground(Color.WHITE);
        balance.setFont(new Font("Poppins", Font.BOLD, 26));
        imgLabel.add(balance);
        
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
        setVisible(false);
        new Transactions(pinNum).setVisible(true);
    }
    public static void main(String[] args){
        new BalanceEnquiry("");
    }
}
