package atm.stimulation.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
    JPasswordField newPinTxt,renewPinTxt;
    JButton confirm, back;
    String pinNum;
    PinChange(String pinNum){
        this.pinNum = pinNum;
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("Icon/atm.jpg"));
        Image image = icon1.getImage().getScaledInstance(900, 900, Image.SCALE_SMOOTH);
        ImageIcon icon2 = new ImageIcon(image);
        JLabel imgLabel = new JLabel(icon2);
        imgLabel.setBounds(0, 0, 900, 900);
        add(imgLabel);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(250, 290, 350, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Poppins", Font.BOLD, 16));
        imgLabel.add(text);
        
        JLabel newPin = new JLabel("Enter New Pin :");
        newPin.setBounds(185, 340, 150, 25);
        newPin.setForeground(Color.WHITE);
        newPin.setFont(new Font("Poppins", Font.BOLD, 16));
        imgLabel.add(newPin);
        
        JLabel renewPin = new JLabel("Re-Enter New Pin :");
        renewPin.setBounds(160, 370, 150, 25);
        renewPin.setForeground(Color.WHITE);
        renewPin.setFont(new Font("Poppins", Font.BOLD, 16));
        imgLabel.add(renewPin);
        
        newPinTxt = new JPasswordField();
        newPinTxt.setBounds(340, 340, 150, 25);
        newPinTxt.setFont(new Font("Raleway",Font.PLAIN,16));
        imgLabel.add(newPinTxt);
        
        renewPinTxt = new JPasswordField();
        renewPinTxt.setBounds(340, 370, 150, 25);
        renewPinTxt.setFont(new Font("Raleway",Font.PLAIN,16));
        imgLabel.add(renewPinTxt);
        
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
            try{
                String npin = newPinTxt.getText();
                String rnpin = renewPinTxt.getText();
                if(!npin.equals(rnpin)){
                    JOptionPane.showMessageDialog(null, "Pin does not match, try again!!!");
                }
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Pleasr enter new Pin");
                }
                if(rnpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Pleasr re-enter new Pin");
                }
                
                Conn c = new Conn();
                
                String query1 = "update bank set pin_num = '"+npin+"' where pin_num = '"+pinNum+"'";
                String query2 = "update login set pin_num = '"+npin+"' where pin_num = '"+pinNum+"'";
                String query3 = "update signupThree set pin_number = '"+npin+"' where pin_number = '"+pinNum+"'";
                
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, "PIN change successfully \n New PIN = "+npin);
                setVisible(false);
                new Transactions(npin).setVisible(true);
            }catch(Exception e){
                System.out.println(e);
            }
        }else{
            setVisible(false);
            new Transactions(pinNum).setVisible(true);
        }
    }
    public static void main(String[] args){
        new PinChange("");
    }
}
