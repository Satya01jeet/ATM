
package atm.stimulation.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton signin, clear, signup;
    JTextField cardNumfield;
    JPasswordField pinField;
    Login(){
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/logo.jpg"));
        Image i = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i);
        JLabel label = new JLabel(i2);
        label.setBounds(150, 13, 70, 70);
        add(label);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osworld", Font.BOLD, 38));
        text.setBounds(250, 30, 500, 50);
        add(text);
        
        JLabel cardNum = new JLabel("Card Number :");
        cardNum.setFont(new Font("Osworld", Font.BOLD, 20));
        cardNum.setBounds(150, 100, 200, 30);
        add(cardNum);
        
        cardNumfield = new JTextField();
        cardNumfield.setBounds(310, 103, 220, 30);
        cardNumfield.setFont(new Font("Arial", Font.BOLD, 18));
        add(cardNumfield);
        
        JLabel pin = new JLabel("PIN :");
        pin.setFont(new Font("Osworld", Font.BOLD, 20));
        pin.setBounds(150, 150, 300, 30);
        add(pin);
        
        pinField = new JPasswordField();
        pinField.setBounds(310, 153, 220, 30);
        pinField.setFont(new Font("Arial", Font.BOLD, 18));
        add(pinField);
        
        signin = new JButton("Sign In");
        signin.setBounds(310, 200, 100, 30);
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.WHITE);
        signin.addActionListener(this);
        add(signin);
        
        clear = new JButton("Clear");
        clear.setBounds(430, 200, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("Sign Up");
        signup.setBounds(310, 250, 220, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        setTitle("AUTOMATED TELLER MACHINE");
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == signin){
            Conn c = new Conn();
            String cardNum = cardNumfield.getText();
            String pinNum = pinField.getText();
            
            String query = "Select * from login where card_num = '"+cardNum+"' and pin_num = '"+pinNum+"'";
            try{
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinNum).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                }
            }catch(Exception e){
            System.out.println(e);
            }
        }
        else if(ae.getSource() == clear){
            cardNumfield.setText("");
            pinField.setText("");
        }
        else if(ae.getSource() == signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    public static void main (String args[]){
        new Login();
    }
}
