package atm.stimulation.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
public class SignupThree extends JFrame implements ActionListener {
    String formNo;
    JRadioButton saving, fd, current, recurrdepo;
    JCheckBox c1, c2, c3, c4, c5, c6, c7a;
    JButton submit, cancel;
    SignupThree(String formNo){
        this.formNo = formNo;
        setLayout(null);
        setSize(850,800);
        setTitle("NEW ACCONT APPLICAITON FORM - PAGE 3");
        getContentPane().setBackground(Color.WHITE);
        setLocation(350,10);
        setVisible(true);
        
        JLabel title = new JLabel("ACCOUNT DETAILS - PAGE 3");
        title.setFont(new Font("Serif", Font.BOLD, 30));
        title.setBounds(180, 60, 500, 30);
        add(title);
        
        JLabel AccType = new JLabel("Account Type");
        AccType.setBounds(100, 130, 200, 40);
        AccType.setFont(new Font("Raleway", Font.BOLD, 24));
        add(AccType);
        
        saving = new JRadioButton("Savings Account");
        saving.setBackground(Color.WHITE);
        saving.setBounds(110, 180, 200, 24);
        add(saving);
        
        fd = new JRadioButton("Fixed Deposit Account");
        fd.setBackground(Color.WHITE);
        fd.setBounds(320, 180, 200, 24);
        add(fd);
        
        current = new JRadioButton("Current Account");
        current.setBackground(Color.WHITE);
        current.setBounds(110, 220, 200, 24);
        add(current);
        
        recurrdepo = new JRadioButton("Recurring Deposit Account");
        recurrdepo.setBackground(Color.WHITE);
        recurrdepo.setBounds(320, 220, 200, 24);
        add(recurrdepo);
        
        ButtonGroup accountType = new ButtonGroup();
        accountType.add(fd);
        accountType.add(saving);
        accountType.add(current);
        accountType.add(recurrdepo);
        
        JLabel cardNum = new JLabel("Card Number:");
        cardNum.setFont(new Font("Raleway", Font.BOLD, 24));
        cardNum.setBounds(100, 300, 300, 24);
        add(cardNum);
        
        JLabel cardNumdel = new JLabel("Your 16 digit card number");
        cardNumdel.setFont(new Font("Raleway", Font.PLAIN, 14));
        cardNumdel.setBounds(100, 320, 300, 24);
        add(cardNumdel);
        
        JLabel cardn = new JLabel("XXXX-XXXX-XXXX-1234");
        cardn.setFont(new Font("Raleway", Font.BOLD, 22));
        cardn.setBounds(350, 300, 300, 24);
        add(cardn);
        
        JLabel pinNum = new JLabel("Pin:");
        pinNum.setFont(new Font("Raleway", Font.BOLD, 24));
        pinNum.setBounds(100, 370, 300, 24);
        add(pinNum);
        
        JLabel pinNumdel = new JLabel("Your 4 digit pin");
        pinNumdel.setFont(new Font("Raleway", Font.PLAIN, 14));
        pinNumdel.setBounds(100, 390, 300, 24);
        add(pinNumdel);
        
        JLabel pinn = new JLabel("XXXX");
        pinn.setFont(new Font("Raleway", Font.BOLD, 22));
        pinn.setBounds(350, 370, 300, 24);
        add(pinn);
        
        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD, 24));
        services.setBounds(100, 440, 300, 24);
        add(services);
        
        c1 = new JCheckBox("ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setBounds(120,470,200,24);
        c1.setFont(new Font("Raleway",Font.PLAIN, 12));
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setBounds(350,470,200,24);
        c2.setFont(new Font("Raleway",Font.PLAIN, 12));
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setBounds(580,470,200,24);
        c3.setFont(new Font("Raleway",Font.PLAIN, 12));
        add(c3);
        
        c4 = new JCheckBox("Email & SMS alerts");
        c4.setBackground(Color.WHITE);
        c4.setBounds(120,500,200,24);
        c4.setFont(new Font("Raleway",Font.PLAIN, 12));
        add(c4);
        
        c5 = new JCheckBox("Check Book");
        c5.setBackground(Color.WHITE);
        c5.setBounds(350,500,200,24);
        c5.setFont(new Font("Raleway",Font.PLAIN, 12));
        add(c5);
        
        c6 = new JCheckBox("E-Statements");
        c6.setBackground(Color.WHITE);
        c6.setBounds(580,500,200,24);
        c6.setFont(new Font("Raleway",Font.PLAIN, 12));
        add(c6);
        
        c7a = new JCheckBox("I hereby declare that all the information rovided above is true and accurate to the best of my knowledge.");
        c7a.setBackground(Color.WHITE);
        c7a.setBounds(100,540,600,24);
        c7a.setFont(new Font("Raleway",Font.PLAIN, 12));
        add(c7a);
        
        c7a = new JCheckBox("I hereby declare that all the information rovided above is true and accurate to the best of my knowledge.");
        c7a.setBackground(Color.WHITE);
        c7a.setBounds(100,540,600,24);
        c7a.setFont(new Font("Raleway",Font.PLAIN, 12));
        add(c7a);
        
        JLabel c7b = new JLabel("I understand that providing false information may lead to consequences as per the rules and regulations.");
        c7b.setBackground(Color.WHITE);
        c7b.setBounds(121,560,600,24);
        c7b.setFont(new Font("Raleway",Font.PLAIN, 12));
        add(c7b);
        
        JLabel c7c = new JLabel("I take full responsibility for the accuracy of the details provided in this form.");
        c7c.setBackground(Color.WHITE);
        c7c.setBounds(121,580,600,24);
        c7c.setFont(new Font("Raleway",Font.PLAIN, 12));
        add(c7c);
     
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(430,650,100,40);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(550,650,100,40);
        cancel.addActionListener(this);
        add(cancel);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }else if(ae.getSource() == submit){
            String accountType = "";
            if(saving.isSelected()){
                accountType = "Savings Account";
            }else if(fd.isSelected()){
                accountType = "Fixed Deposit Account";
            }else if(current.isSelected()){
                accountType = "Current Account";
            }else if(recurrdepo.isSelected()){
                accountType = "Reccuring Deposit Account";
            }
            Random random = new Random();
            String cardNumber = "" + Math.abs(random.nextLong()%90000000L);
            
            String pinNumber = ""+(Math.abs(random.nextLong() % 9000L)+1000L);
            String facilities = "";
            if(c1.isSelected()){
                facilities += "ATM Card ";
            }else if(c2.isSelected()){
                facilities += "Internet Banking ";
            }else if(c3.isSelected()){
                facilities += "Mobile Banking ";
            }else if(c4.isSelected()){
                facilities += "Email & SMS alerts ";
            }else if(c5.isSelected()){
                facilities += "Check Book ";
            }
            else if(c6.isSelected()){
                facilities += "E-Statements";
            }
            try{
                if(accountType.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Select account type.");
                }else if(facilities.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Select atleast one service.");
                }else if(c7a.isSelected()){
                    JOptionPane.showMessageDialog(null, "Tick the checkbox below");
                }else{
                    Conn c = new Conn();
                    String query1 = "insert into signupThree values('"+formNo+"','"+accountType+"', '"+cardNumber+"', '"+pinNumber+"', '"+facilities+"')"; 
                    c.s.executeUpdate(query1);
                    String query2 = "insert into login values('"+formNo+"', '"+cardNumber+"', '"+pinNumber+"')"; 
                    c.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "Card Number: "+ cardNumber+"\n Pin Number: "+pinNumber);
                    setVisible(false);
                    new Deposit(pinNumber).setVisible(true);
                 }
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String[] args){
        new SignupThree("");
    }
}
