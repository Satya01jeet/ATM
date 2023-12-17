package atm.stimulation.system;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
    
    long randomForm;
    JTextField nameTextField, FNameTextField, EmailTextField, addressTextFld,
            stateTextFld, cityTxtFld, pinTxtFld;
    JDateChooser dateChooser;
    JRadioButton male, female, married, unmarried;
    JButton next;
    
    SignupOne(){
        setLayout(null);
        setSize(850,800);
        setTitle("NEW ACCONT APPLICAITON FORM - PAGE 1");
        getContentPane().setBackground(Color.WHITE);
        setLocation(350,10);
        setVisible(true);
        
        Random ran = new Random();
        randomForm = Math.abs(ran.nextInt()%10000) + 1000;
        
        JLabel formNo = new JLabel("APPLICATION NUMBER - "+randomForm);
        formNo.setFont(new Font("Serif", Font.BOLD, 38));
        formNo.setBounds(140, 20, 600, 40);
        add(formNo);
        
        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 24));
        personalDetails.setBounds(280, 80, 500, 30);
        add(personalDetails);
        
        JLabel nameField = new JLabel("Name:");
        nameField.setFont(new Font("Raleway", Font.BOLD, 24));
        nameField.setBounds(100, 140, 200, 30);
        add(nameField);
        
        nameTextField = new JTextField();
        nameTextField.setBounds(350, 140, 300, 24);
        nameTextField.setFont(new Font("Arial", Font.PLAIN, 16));
        add(nameTextField);
        
        JLabel FNameField = new JLabel("Father's Name:");
        FNameField.setFont(new Font("Raleway", Font.BOLD, 24));
        FNameField.setBounds(100, 190, 200, 30);
        add(FNameField);
        
        FNameTextField = new JTextField();
        FNameTextField.setBounds(350, 190, 300, 24);
        FNameTextField.setFont(new Font("Arial", Font.PLAIN, 16));
        add(FNameTextField);
        
        JLabel DOB = new JLabel("Date of Birth:");
        DOB.setFont(new Font("Raleway", Font.BOLD, 24));
        DOB.setBounds(100, 240, 200, 30);
        add(DOB);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(350, 240, 200, 24);
        dateChooser.setForeground(Color.BLACK);
        add(dateChooser);
        
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 24));
        gender.setBounds(100, 290, 200, 30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(350, 290, 80, 24);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(450, 290, 80, 24);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        
        JLabel Email = new JLabel("Email Address:");
        Email.setFont(new Font("Raleway", Font.BOLD, 24));
        Email.setBounds(100, 340, 200, 30);
        add(Email);
        
        EmailTextField = new JTextField();
        EmailTextField.setBounds(350, 340, 300, 24);
        EmailTextField.setFont(new Font("Arial", Font.PLAIN, 16));
        add(EmailTextField);
        
        JLabel maritalStatus = new JLabel("Marital Status:");
        maritalStatus.setFont(new Font("Raleway", Font.BOLD, 24));
        maritalStatus.setBounds(100, 390, 200, 30);
        add(maritalStatus);
        
        married = new JRadioButton("Married");
        married.setBounds(350, 390, 80, 24);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 390, 120, 24);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        ButtonGroup maritialstatus = new ButtonGroup();
        maritialstatus.add(married);
        maritialstatus.add(unmarried);
        
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 24));
        address.setBounds(100, 440, 200, 30);
        add(address);
        
        addressTextFld = new JTextField();
        addressTextFld.setBounds(350, 440, 300, 24);
        addressTextFld.setFont(new Font("Arial", Font.PLAIN, 16));
        add(addressTextFld);
        
        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 24));
        city.setBounds(100, 490, 200, 30);
        add(city);
        
        cityTxtFld = new JTextField();
        cityTxtFld.setBounds(350, 490, 300, 24);
        cityTxtFld.setFont(new Font("Arial", Font.PLAIN, 16));
        add(cityTxtFld);
        
        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 24));
        state.setBounds(100, 540, 200, 30);
        add(state);
        
        stateTextFld = new JTextField();
        stateTextFld.setBounds(350, 540, 300, 24);
        stateTextFld.setFont(new Font("Arial", Font.PLAIN, 16));
        add(stateTextFld);
        
        JLabel pin = new JLabel("Pin Code:");
        pin.setFont(new Font("Raleway", Font.BOLD, 24));
        pin.setBounds(100, 590, 200, 30);
        add(pin);
        
        pinTxtFld = new JTextField();
        pinTxtFld.setBounds(350, 590, 300, 24);
        pinTxtFld.setFont(new Font("Arial", Font.PLAIN, 16));
        add(pinTxtFld);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 16));
        next.setBounds(550, 640, 100, 40);
        next.addActionListener(this);
        add(next);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        String formNo = "" + randomForm;
        String name = nameTextField.getText();
        String fname = FNameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = "";
        if(male.isSelected()){
            gender = "Male";
        }else if(female.isSelected()){
            gender = "Female";
        }
        String email = EmailTextField.getText();
        String maritalStatus = "";
        if(married.isSelected()){
            maritalStatus = "Married";
        }else if(unmarried.isSelected()){
            maritalStatus = "UnMarried";
        }
        String address = addressTextFld.getText();
        String city = cityTxtFld.getText();
        String state = stateTextFld.getText();
        String pin = pinTxtFld.getText();
        
        try{
            if(name.equals("") || fname.equals("") || dob.equals("") || gender.isEmpty() || email.equals("")
                    || maritalStatus.isEmpty() || address.equals("") || city.equals("") || state.equals("")
                    || pin.equals("")){
                JOptionPane.showMessageDialog(null, "All the feilds are required!!!");
            }else{
                Conn c = new Conn();
                String query = "insert into signup values('"+formNo+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+
                        "', '"+email+"', '"+maritalStatus+"', '"+address+"', '"+city+"', '"+state+"', '"+pin+"')"; 
                c.s.executeUpdate(query);    
//                JOptionPane.showMessageDialog(null, "Data uploaded successfully");
                setVisible(false);
                new SignupTwo(formNo).setVisible(true);
            } 
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String args[]){
       new SignupOne();
    }
}
