package safe.plus.dental.care;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JWindow;

public class Start_page_2 extends JFrame implements ActionListener{
    private Container c;
    private JWindow j;
    private ImageIcon icon;
    private JLabel selectlabel, textlabel,orlabel;
    private JTextArea area1;
    private JScrollPane scroll1;
    private Font f1, f2,f;
    private JButton patientbutton,adminbutton;
    private Cursor cursor;
    private JCheckBox box1;

    Start_page_2() {
        initComponents();
    }

    public void initComponents() {
        c = this.getContentPane();
        c.setLayout(null);
      //c.setBackground( new Color(107, 106, 104) );

        // ImageIcon
        icon = new ImageIcon(getClass().getResource("1.png"));
        this.setIconImage(icon.getImage());
        

        // Scale the image to the label size
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(icon.getIconWidth(), icon.getIconHeight(), Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaledImg);

        // Fonts
        f = new Font("Arial",Font.BOLD+Font.ITALIC,16);
        f1 = new Font("Calibri", Font.ROMAN_BASELINE + Font.ITALIC, 20);
        f2 = new Font("Arial", Font.ROMAN_BASELINE, 15);

        // Cursor
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // Jtextarea
        area1 = new JTextArea();
        area1.setEditable(false);
        area1.setText("""
                      1. Data Collection: This section outlines what kind of data the app collects from users. This may include personal information (like names, contact details), medical information, and any other data required for dental appointments.
                      
                      2. Data Usage: The policy explains how the collected data is used. For instance, it is used for appointment booking, sending reminders, and for dental professionals to access patients' medical records.
                      
                      3. Data Protection: The policy should detail the security measures in place to protect user data. This can include encryption, secure servers, and access control to ensure that sensitive information is safeguarded.
                      
                      4. Data Sharing: It clarifies who has access to user data. Typically, only authorized personnel within the dental clinic should have access. Users' data should not be shared with third parties without consent.
                      
                      5. User Consent: The policy explains that by using the app, users consent to the collection and processing of their data. It may also describe how users can withdraw consent or delete their account if they wish to do so.
                      
                      6. Data Retention: The policy outlines how long user data is retained. For instance, medical records might need to be kept for a certain period according to legal requirements.
                      
                      7. Updates to Privacy Policy: Users are informed that the privacy policy may change over time, and they will be notified of any updates. It's essential to keep users informed about how their data is handled.
                      
                      8. Compliance with Regulations: The privacy policy ensures that the app complies with relevant data protection regulations, such as GDPR (General Data Protection Regulation) or HIPAA (Health Insurance Portability and Accountability Act) in the case of medical""");
        area1.setForeground(Color.white);
        area1.setFont(f2);
        area1.setLineWrap(true);
        area1.setWrapStyleWord(true);
        Color bgColor = new Color(0, 0, 0);
        area1.setBackground(bgColor);
        area1.setBorder(BorderFactory.createLineBorder(Color.blue));
        c.add(area1);

        
        
        // Jscrollpane
        scroll1 = new JScrollPane(area1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll1.setBounds(50, 35, 750, 300);
        c.add(scroll1);
      
        
        
        // Jlabel
        textlabel = new JLabel(" Privacy Policy and Terms of Service");
        textlabel.setForeground(Color.black);
        textlabel.setBounds(279, 2, 500, 40);
        textlabel.setFont(f1);
        c.add(textlabel);
        
        selectlabel = new JLabel("Please choose the log in button you'd like to use.");
        selectlabel.setForeground(Color.black);
        selectlabel.setBounds(225, 360, 500, 40);
        selectlabel.setFont(f1);
        c.add(selectlabel);
        
        orlabel = new JLabel("OR");
        orlabel.setForeground(Color.black);
        orlabel.setBounds(420, 425, 500, 40);
        orlabel.setFont(f1);
        c.add(orlabel);
        
        
        //Checkbox
        box1 = new JCheckBox();
        box1.setText("Are you agreee with our policy");
        box1.setFont(f);
        box1.setSelected(true);
        box1.setBounds(50, 335, 260, 20);
        box1.setBackground(Color.blue);
        box1.setForeground(Color.WHITE);
        c.add(box1);
        
        //jbutton for patient and admins
        patientbutton = new JButton("Patient");
        patientbutton.setBounds(385, 400, 100, 30);
        patientbutton.setOpaque(true);
        patientbutton.setBackground(Color.blue);
        patientbutton.setForeground(Color.white);
        patientbutton.setCursor(cursor);
        c.add(patientbutton);
        
        adminbutton = new JButton("Doctor");
        adminbutton.setBounds(385, 460, 100, 30);
        adminbutton.setOpaque(true);
        adminbutton.setBackground(Color.blue);
        adminbutton.setForeground(Color.white);
        adminbutton.setCursor(cursor);
        c.add(adminbutton);
        
      patientbutton.addActionListener(this);
      adminbutton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==adminbutton){
            dispose();
       Doctors_login ln = new Doctors_login();
        ln.setVisible(true);
        ln.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ln.setBounds(400, 100, 850, 550);
         ln.setTitle(" Doctors Log in");
        ln.setResizable(false);
        }
        else if(e.getSource()==patientbutton){
        
        dispose();    
        Login ln= new Login();
        ln.setVisible(true);
        ln.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ln.setBounds(400, 100, 850, 550);
        ln.setTitle("Log in / Sing up");
        ln.setResizable(false);
        }
     
    }

    public static void main(String[] args) {
        Start_page_2 sp = new Start_page_2();
        sp.setVisible(true);
        sp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sp.setBounds(400, 100, 850, 550);
        sp.setTitle("Safe Plus Dental Clinic");
        sp.setResizable(false);
    }

    
}
