package atm.stimulation.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    JTextField aadharNum, panNum;
    JRadioButton senYes, senNo, exAccYes, exAccNo;
    JComboBox religionBox, categoryBox, incomeBox, qualificationBox, occupationBox;
    JButton next;
    String formNo;
    SignupTwo(String formNo){
        this.formNo = formNo;
        setLayout(null);
        setSize(850,800);
        setTitle("NEW ACCONT APPLICAITON FORM - PAGE 2");
        getContentPane().setBackground(Color.WHITE);
        setLocation(350,10);
        setVisible(true);
        
        JLabel title = new JLabel("ADDITIONAL DETAILS - PAGE 2");
        title.setFont(new Font("Serif", Font.BOLD, 30));
        title.setBounds(180, 60, 500, 30);
        add(title);
        
        JLabel religion = new JLabel("Religion: ");
        religion.setFont(new Font("Raleway", Font.BOLD, 24));
        religion.setBounds(100, 130, 200, 40);
        add(religion);
        
        String[] valReligion = {"-Select-","Hindu","Sikh","Muslim","Christian","Other"};
        religionBox = new JComboBox(valReligion);
        religionBox.setBounds(350, 140, 300, 24);
        religionBox.setBackground(Color.WHITE);
        add(religionBox);
        
        JLabel category = new JLabel("Category: ");
        category.setFont(new Font("Raleway", Font.BOLD, 24));
        category.setBounds(100, 180, 200, 40);
        add(category);
        
        String[] valCategory = {"-Select-","General","OBC","SC","ST"};
        categoryBox = new JComboBox(valCategory);
        categoryBox.setBounds(350, 190, 300, 24);
        categoryBox.setBackground(Color.WHITE);
        add(categoryBox);
        
        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 24));
        income.setBounds(100, 230, 200, 40);
        add(income);
        
        String[] valIncome = {"-Select-","below 1L","below 5L","below 10L","above 10L"};
        incomeBox = new JComboBox(valIncome);
        incomeBox.setBounds(350, 240, 300, 24);
        incomeBox.setBackground(Color.WHITE);
        add(incomeBox);
        
        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway", Font.BOLD, 24));
        qualification.setBounds(100, 280, 200, 40);
        add(qualification);
        
        String[] valqualification = {"-Select-","High School","Diploma","Graduate","Post Graduate","Doctarate","Skipped Matrix"};
        qualificationBox = new JComboBox(valqualification);
        qualificationBox.setBounds(350, 290, 300, 24);
        qualificationBox.setBackground(Color.WHITE);
        add(qualificationBox);
        
        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 24));
        occupation.setBounds(100, 330, 200, 40);
        add(occupation);
        
        String[] valoccupation = {"-Select-","Student","Self Employed","Salaried Employee","Business Owner","Retired"};
        occupationBox = new JComboBox(valoccupation);
        occupationBox.setBounds(350, 340, 300, 24);
        occupationBox.setBackground(Color.WHITE);
        add(occupationBox);
        
        JLabel pannum = new JLabel("Pan Number:");
        pannum.setFont(new Font("Raleway", Font.BOLD, 24));
        pannum.setBounds(100, 380, 200, 40);
        add(pannum);
        
        panNum = new JTextField();
        panNum.setBounds(350, 390, 300, 24);
        panNum.setFont(new Font("Arial", Font.PLAIN, 16));
        add(panNum);
        
        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 24));
        aadhar.setBounds(100, 430, 200, 40);
        add(aadhar);
        
        aadharNum = new JTextField();
        aadharNum.setBounds(350, 440, 300, 24);
        aadharNum.setFont(new Font("Arial", Font.PLAIN, 16));
        add(aadharNum);
        
        JLabel senoirCitizen = new JLabel("Senior Citizen:");
        senoirCitizen.setFont(new Font("Raleway", Font.BOLD, 24));
        senoirCitizen.setBounds(100, 480, 200, 40);
        add(senoirCitizen);
        
        senYes = new JRadioButton("Yes");
        senYes.setBounds(350, 490, 80, 24);
        senYes.setBackground(Color.WHITE);
        add(senYes);
        
        senNo = new JRadioButton("No");
        senNo.setBounds(450, 490, 80, 24);
        senNo.setBackground(Color.WHITE);
        add(senNo);
        
        ButtonGroup senior = new ButtonGroup();
        senior.add(senNo);
        senior.add(senYes);
        
        JLabel existingAccount = new JLabel("Existing Account:");
        existingAccount.setFont(new Font("Raleway", Font.BOLD, 24));
        existingAccount.setBounds(100, 530, 300, 40);
        add(existingAccount);
        
        exAccYes = new JRadioButton("Yes");
        exAccYes.setBounds(350, 540, 80, 24);
        exAccYes.setBackground(Color.WHITE);
        add(exAccYes);
        
        exAccNo = new JRadioButton("No");
        exAccNo.setBounds(450, 540, 80, 24);
        exAccNo.setBackground(Color.WHITE);
        add(exAccNo);
        
        ButtonGroup exAcc = new ButtonGroup();
        exAcc.add(exAccYes);
        exAcc.add(exAccNo);
        
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
        String formNum = formNo;
        String rel = (String) religionBox.getSelectedItem();
        String catg = (String) categoryBox.getSelectedItem();
        String inc = (String) incomeBox.getSelectedItem();
        String quaf = (String) qualificationBox.getSelectedItem();
        String ocp = (String) occupationBox.getSelectedItem();
        String pan = panNum.getText();
        String aadhar = aadharNum.getText();
        String srcitizen = "";
        if(senYes.isSelected()) srcitizen = "Yes";
        else if(senNo.isSelected()) srcitizen = "No";
        String existing = "";
        if(exAccYes.isSelected()) existing = "Yes";
        else if(exAccNo.isSelected()) existing = "No";
        try{
            if(rel.matches("-Select-") || catg.matches("-Select-") || inc.matches("-Select-")
                    || quaf.matches("-Select-") || ocp.matches("-Select-")){
                JOptionPane.showMessageDialog(null, "Select a valid option");
            }
            else if(pan.isEmpty() || aadhar.isEmpty() || srcitizen.isEmpty() || existing.isEmpty()){
                JOptionPane.showMessageDialog(null, "All the feilds are required!!!");
            }else{
                Conn c = new Conn();
                String query = "insert into signupTwo values('"+formNum+"', '"+rel+"', '"+catg+"', '"+inc+"', '"+quaf+
                        "', '"+ocp+"', '"+pan+"', '"+aadhar+"', '"+srcitizen+"', '"+existing+"')"; 
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupThree(formNo).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String args[]){
        new SignupTwo("");
    }
}
