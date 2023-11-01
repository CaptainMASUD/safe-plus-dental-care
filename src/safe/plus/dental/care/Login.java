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
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Login extends JFrame implements ActionListener {

    private Container c;
    private ImageIcon icon, icon2, icon4;
    private JLabel headerlabel, loglabel, userlabel, passlabel, tipslabel, tipslabel2;
    private JTextField textfield;
    private JPasswordField passfield;
    private Font f, f2, f3;
    private JButton logbutton, regbutton, backbutton;
    private Cursor cursor;

    Login() {
        initcomponent();
    }

    public void initcomponent() {
        c = this.getContentPane();
        c.setLayout(null);

        // ImageIcon
        icon = new ImageIcon(getClass().getResource("logo.png"));
        this.setIconImage(icon.getImage());

        icon2 = new ImageIcon(getClass().getResource("left-arrow.png"));

        //icon and image
        icon4 = new ImageIcon(getClass().getResource("1.png"));
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
        tipslabel.setText("Tips: If you haven't registered yet, then register now by clicking the register button.");
        tipslabel.setBounds(100, 450, 600, 40);
        tipslabel.setForeground(Color.blue);
        c.add(tipslabel);

        tipslabel2 = new JLabel();
        tipslabel2.setText("This will help you use the features of this application.");
        tipslabel2.setBounds(130, 465, 600, 40);
        tipslabel2.setForeground(Color.blue);
        c.add(tipslabel2);

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
        logbutton.setBounds(380, 300, 80, 30);
        c.add(logbutton);

        regbutton = new JButton("Register");
        regbutton.setToolTipText("Click for registration");
        regbutton.setCursor(cursor);
        regbutton.setOpaque(true);
        regbutton.setBackground(Color.blue);
        regbutton.setForeground(Color.white);
        regbutton.setBounds(480, 300, 100, 30);
        c.add(regbutton);

        backbutton = new JButton(icon2);
        backbutton.setToolTipText("Click for registration");
        backbutton.setCursor(cursor);
        backbutton.setOpaque(true);
        backbutton.setBackground(Color.blue);
        backbutton.setForeground(Color.white);
        backbutton.setBounds(0, 0, 40, 35);
        c.add(backbutton);

        regbutton.addActionListener(this);
        logbutton.addActionListener(this);
        backbutton.addActionListener(this);
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logbutton) {
            String enteredUsername = textfield.getText();
            String enteredPassword = new String(passfield.getPassword());

            // Read the user_data.txt file line by line
            try (BufferedReader reader = new BufferedReader(new FileReader("user_data.txt"))) {
                String line;
                boolean loggedIn = false;
                String storedUsername = null;
                String storedPassword = null;

                while ((line = reader.readLine()) != null) {
                    if (line.startsWith("Username: ")) {
                        storedUsername = line.substring("Username: ".length());
                    } else if (line.startsWith("Password: ")) {
                        storedPassword = line.substring("Password: ".length());

                        // Check if the entered credentials match the stored ones
                        if (storedUsername != null && storedPassword != null
                                && enteredUsername.equals(storedUsername) && enteredPassword.equals(storedPassword)) {
                            loggedIn = true;
                            break;
                        }
                    }
                }

                if (loggedIn) {
                    // Save the username and password to a separate text file
                    try (FileWriter writer = new FileWriter("successful_logins.txt", true)) {
                        writer.write( enteredUsername + "\n");
                        writer.write( enteredPassword + "\n\n");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        // Handle file write errors here.
                    }

                    dispose();
                    MainFrame fr = new MainFrame();
                    fr.setVisible(true);
                    fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    fr.setBounds(300, 100, 1000, 600);
                    fr.setTitle("Safe Plus Dental Clinic");
                    fr.setResizable(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid username or password. Please try again.", "Login Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
                // Handle file read errors here.
            }
        } else if (e.getSource() == regbutton) {
            // Handle the registration button click to open the registration form
            dispose();
            Account_reg ar = new Account_reg();
            ar.setVisible(true);
            ar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ar.setBounds(400, 100, 850, 550);
            ar.setResizable(false);
            ar.setTitle("Account Registration");
        } else if (e.getSource() == backbutton) {
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

        Login ln = new Login();
        ln.setVisible(true);
        ln.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ln.setBounds(400, 100, 850, 550);
        ln.setTitle("Log in / Registration");
        ln.setResizable(false);
    }
}
