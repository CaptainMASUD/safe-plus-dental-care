
package safe.plus.dental.care;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Account_reg extends JFrame implements ActionListener{
    
    private Container c;
    private ImageIcon icon,icon4;
    private JLabel textlabel,namelabel,agelabel,addresslabel,phnlabel,email,password;
    private JTextField nf,agef,addf,phnf,emailf;
    private JPasswordField passf;
    private Font f,f2,fs;
    private JButton regbutton,backbutton;
    private Cursor cursor;
    
    Account_reg(){
    
        initcomponent();
        
    }
    public void initcomponent(){
    
        c= this.getContentPane();
        c.setLayout(null);
        
        //icon and image
        icon = new ImageIcon(getClass().getResource("logo.png"));
        this.setIconImage(icon.getImage());
        
        //icon and image
        icon4 = new ImageIcon(getClass().getResource("1.png"));
        this.setIconImage(icon4.getImage());
        
        //fonts
        f = new Font("Arial",Font.BOLD,25);
        f2 = new Font("Arial",Font.BOLD,18);
        fs = new Font("Arial",Font.BOLD,14);
        
        //
        cursor = new Cursor(Cursor.HAND_CURSOR);
        
        //jlabel
        textlabel = new JLabel();
        textlabel.setFont(f);
        Color customColor = new Color(0,0,128);
        textlabel.setForeground(customColor);
        textlabel.setBounds(360,5,400,50);
        textlabel.setText("Registration");
        c.add(textlabel);
        
        namelabel = new JLabel();
        namelabel.setText("Username");
        namelabel.setFont(f2);
        namelabel.setBounds(170, 120, 120, 50);
        c.add(namelabel);
        
        agelabel = new JLabel();
        agelabel.setText("Age");
        agelabel.setFont(f2);
        agelabel.setBounds(170, 170, 120, 50);
        c.add(agelabel);
        
        phnlabel = new JLabel();
        phnlabel.setText("Phone no.");
        phnlabel.setFont(f2);
        phnlabel.setBounds(170, 220, 120, 50);
        c.add(phnlabel);
        
        addresslabel = new JLabel();
        addresslabel.setText("Address");
        addresslabel.setFont(f2);
        addresslabel.setBounds(170, 320, 120, 50);
        c.add(addresslabel);
        
        email = new JLabel();
        email.setText("Email");
        email.setFont(f2);
        email.setBounds(170, 270, 120, 50);
        c.add(email);
        
        password = new JLabel();
        password.setText("Password");
        password.setFont(f2);
        password.setBounds(170, 370, 120, 50);
        c.add(password);
        
        
        //textfield
        nf = new JTextField();
        nf.setBounds(380, 130, 300, 30);
        c.add(nf);
        
        agef = new JTextField();
        agef.setBounds(380, 178, 300, 30);
        c.add(agef);
        
        phnf = new JTextField();
        phnf.setBounds(380, 229, 300, 30);
        c.add(phnf);
        
        addf = new JTextField();
        addf.setBounds(380, 280, 300, 30);
        c.add(addf);
        
        emailf = new JTextField();
        emailf.setBounds(380, 330, 300, 30);
        c.add(emailf);
        
        passf = new JPasswordField();
        passf.setBounds(380, 380, 300, 30);
        c.add(passf);
        
        regbutton = new JButton();
        regbutton.setText("Register");
        regbutton.setOpaque(true);
        regbutton.setBackground(Color.blue);
        regbutton.setForeground(Color.white);
        regbutton.setCursor(cursor);
        regbutton.setBounds(580, 420, 100, 30);
        c.add(regbutton);
        
        backbutton = new JButton();
        backbutton.setText("Back");
        backbutton.setOpaque(true);
        backbutton.setBackground(Color.blue);
        backbutton.setForeground(Color.white);
        backbutton.setCursor(cursor);
        backbutton.setBounds(10, 10, 100, 30);
        c.add(backbutton);
        
        regbutton.addActionListener(this);
        backbutton.addActionListener(this);
        
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backbutton) {
            
            
            dispose();
            Login ln = new Login();
            ln.setVisible(true);
            ln.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ln.setBounds(400, 100, 850, 550);
            ln.setTitle("Log in / Sign up");
            ln.setResizable(false);
        } else if (e.getSource() == regbutton) {
            // Retrieve user data from text fields
            String username = nf.getText();
            String age = agef.getText();
            String phoneNumber = phnf.getText();
            String address = addf.getText();
            String email = emailf.getText();
            String password = new String(passf.getPassword());

            if (username.isEmpty() || age.isEmpty() || phoneNumber.isEmpty() || address.isEmpty() || email.isEmpty() || password.isEmpty()) {
                // Handle empty fields
                // You can show an error message here.
            } else {
                boolean usernameExists = false;
                boolean phoneNumberExists = false;
                boolean emailExists = false;

                try (BufferedReader reader = new BufferedReader(new FileReader("user_data.txt"))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        if (line.startsWith("Username: " + username)) {
                            usernameExists = true;
                        }
                        if (line.startsWith("Phone Number: " + phoneNumber)) {
                            phoneNumberExists = true;
                        }
                        if (line.startsWith("Email: " + email)) {
                            emailExists = true;
                        }
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                   
                }

                if (usernameExists) {
                    // Show an error message that the username is already in use.
                    JOptionPane.showMessageDialog(this, "Username is already in use. Please use a different username.", "Registration Error", JOptionPane.ERROR_MESSAGE);
                } else if (phoneNumberExists) {
                    // Show an error message that the phone number is already in use.
                    JOptionPane.showMessageDialog(this, "Phone number is already in use. Please use a different phone number.", "Registration Error", JOptionPane.ERROR_MESSAGE);
                } else if (emailExists) {
                    // Show an error message that the email is already in use.
                    JOptionPane.showMessageDialog(this, "Email is already in use. Please use a different email.", "Registration Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("user_data.txt", true))) {
                        // Append user data to the file with line breaks
                        writer.write("Username: " + username);
                        writer.newLine();
                        writer.write("Age: " + age);
                        writer.newLine();
                        writer.write("Phone Number: " + phoneNumber);
                        writer.newLine();
                        writer.write("Address: " + address);
                        writer.newLine();
                        writer.write("Email: " + email);
                        writer.newLine();
                        writer.write("Password: " + password);
                        writer.newLine();
                        writer.newLine(); // Add a line gap

                        // Clear the text fields
                        nf.setText("");
                        agef.setText("");
                        phnf.setText("");
                        addf.setText("");
                        emailf.setText("");
                        passf.setText(""); // Corrected line to clear the password field
                        
                        String c = nf.getText();
                        JOptionPane.showMessageDialog(null, c+"Your account has been created successfully");
                        dispose();

                        Login ln = new Login();
                        ln.setVisible(true);
                        ln.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        ln.setBounds(400, 100, 850, 550);
                        ln.setTitle("Log in / Registration");
                        ln.setResizable(false);
            
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        // Handle file write errors here.
                    }
                }
            }
        }

    }

    
    public static void main(String[] args) {
        Account_reg ar = new Account_reg();
        
        ar.setVisible(true);
        ar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ar.setBounds(400, 100, 850, 550);
        ar.setResizable(false);
        ar.setTitle("Account Registration");
    }

    
}
