
package safe.plus.dental.care;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Doctors_login extends JFrame implements ActionListener {
    
    private Container c;
    private ImageIcon icon, icon2,icon4,icon5;
    private JLabel headerlabel, loglabel, userlabel, passlabel, tipslabel, tipslabel2;
    private JTextField textfield;
    private JPasswordField passfield;
    private Font f, f2, f3;
    private JButton logbutton, backbutton;
    private Cursor cursor;
    
    Doctors_login() {
        initcomponent();
    }
    
    public void initcomponent() {
        c = this.getContentPane();
        c.setLayout(null);
        
        
        icon5 = new ImageIcon(getClass().getResource("left-arrow.png"));
        
        
          //icon and image
        icon4 = new ImageIcon(getClass().getResource("doctor.png"));
        this.setIconImage(icon4.getImage());
        
        // Fonts
        f = new Font("Arial", Font.BOLD, 25);
        f2 = new Font("Arial", Font.BOLD, 23);
        f3 = new Font("Arial", Font.BOLD, 18);
        
        // Cursor
        cursor = new Cursor(Cursor.HAND_CURSOR);
        
        // JLabel
        headerlabel = new JLabel("Safe Plus Dental Clinic");
        headerlabel.setBounds(300, 5, 400, 50);
        Color customColor = new Color(0, 0, 128);
        headerlabel.setForeground(customColor);
        headerlabel.setFont(f);
        c.add(headerlabel);
        
        loglabel = new JLabel("Log in");
        loglabel.setBounds(395, 40, 200, 50);
        loglabel.setForeground(Color.blue);
        loglabel.setFont(f2);
        c.add(loglabel);
        
        userlabel = new JLabel("Username");
        userlabel.setBounds(250, 200, 200, 50);
        userlabel.setFont(f3);
        c.add(userlabel);
        
        passlabel = new JLabel("Password");
        passlabel.setBounds(250, 250, 200, 50);
        passlabel.setFont(f3);
        c.add(passlabel);
        
        tipslabel = new JLabel();
        tipslabel.setText("Tips: You can control the patient details after loging in");
        tipslabel.setBounds(280, 450, 600, 40);
        tipslabel.setForeground(Color.blue);
        c.add(tipslabel);
        
        // JTextField
        textfield = new JTextField();
        textfield.setBounds(380, 210, 200, 30);
        c.add(textfield);
        
        // JPasswordField
        passfield = new JPasswordField();
        passfield.setBounds(380, 260, 200, 30);
        c.add(passfield);
        
        // JButton
        logbutton = new JButton("Log in");
        logbutton.setCursor(cursor);
        logbutton.setOpaque(true);
        logbutton.setForeground(Color.white);
        logbutton.setBackground(Color.blue);
        logbutton.setBounds(500, 300, 80, 30);
        c.add(logbutton);
        
        backbutton = new JButton(icon5);
        backbutton.setToolTipText("Click for registration");
        backbutton.setCursor(cursor);
        backbutton.setOpaque(true);
        backbutton.setBackground(Color.blue);
        backbutton.setForeground(Color.white);
        backbutton.setBounds(0,0, 40, 35);
        c.add(backbutton);
        
       
        logbutton.addActionListener(this);
        backbutton.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String a = textfield.getText();
        String b = passfield.getText();

        if (e.getSource() == logbutton) {
            if (a.equals("admin") && b.equals("1234")) {
                dispose();
                Doctors_Panel p = new Doctors_Panel();
                p.setVisible(true);
                p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                p.setBounds(400, 100, 850, 550);
                p.setTitle("Doctors Panel");
                p.setResizable(false);
            } else {
                
                JOptionPane.showMessageDialog(this, "Invalid username or password", "Login Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(e.getSource()==backbutton){
      
            dispose();

            Start_page_2 sp = new Start_page_2();
            sp.setVisible(true);
            sp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            sp.setBounds(400, 100, 850, 550);
            sp.setTitle("Safe Plus Dental Clinic");
            sp.setResizable(false);
        }
    }
       
    
    public static void main(String[] args) {
        Doctors_login ln = new Doctors_login();
        ln.setVisible(true);
        ln.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ln.setBounds(400, 100, 850, 550);
         ln.setTitle(" Doctors Log in");
        ln.setResizable(false);
    }
}