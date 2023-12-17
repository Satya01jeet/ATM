package atm.stimulation.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;
public class FastCash extends JFrame implements ActionListener {
    JButton hund,fhund,thou,tthou,fthou,tnthou,back;
    String pinNum;
    FastCash(String pinNum){
        this.pinNum = pinNum;
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("Icon/atm.jpg"));
        Image image = icon1.getImage().getScaledInstance(900, 900, Image.SCALE_SMOOTH);
        ImageIcon icon2 = new ImageIcon(image);
        JLabel imgLabel = new JLabel(icon2);
        imgLabel.setBounds(0, 0, 900, 900);
        add(imgLabel);
        
        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(190, 290, 300, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Poppins", Font.BOLD, 18));
        imgLabel.add(text);
        
        hund = new JButton("100");
        hund.setBounds(155, 420, 150, 24);
        hund.addActionListener(this);
        imgLabel.add(hund);
        
        fhund = new JButton("500");
        fhund.setBounds(366, 420, 150, 24);
        fhund.addActionListener(this);
        imgLabel.add(fhund);
        
        thou = new JButton("1000");
        thou.setBounds(155, 453, 150, 24);
        thou.addActionListener(this);
        imgLabel.add(thou);
        
        tthou = new JButton("2000");
        tthou.setBounds(366, 453, 150, 24);
        tthou.addActionListener(this);
        imgLabel.add(tthou);
        
        fthou = new JButton("5000");
        fthou.setBounds(155, 486, 150, 24);
        fthou.addActionListener(this);
        imgLabel.add(fthou);
        
        tnthou = new JButton("10000");
        tnthou.setBounds(366, 486, 150, 24);
        tnthou.addActionListener(this);
        imgLabel.add(tnthou);
        
        back = new JButton("Back");
        back.setBounds(155, 519, 360, 24);
        back.addActionListener(this);
        imgLabel.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinNum).setVisible(true);
        }else{
            String amount = ((JButton) ae.getSource()).getText();
            Date date = new Date();
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin_num = '"+pinNum+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("transaction_type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource() == back || balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }else{
                    String query = "insert into bank values('"+pinNum+"' ,'"+date+"', 'Withdrawl', '"+amount+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"RS "+amount+" Withdrawn successfully.");
                    setVisible(false);
                    new Transactions(pinNum).setVisible(true);
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String args[]){
        new FastCash("");
    }
}
