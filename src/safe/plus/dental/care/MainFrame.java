
package safe.plus.dental.care;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;



public class MainFrame extends JFrame  implements ActionListener{
    private Container c;
    private Cursor cursor,cursor2;
    private JMenuBar menubar;
    private JMenu home, appointments, history, doctors,imgmenu;
    private JMenuItem homeItem, appointmentsItem, historyItem, doctorsItem;
    private JPanel mainPanel;
    private JPanel homePanel, appointmentsPanel, historyPanel, doctorsPanel;
    private JLabel homelabel,imglabel,headlabel,sublabel,paralabel,paralabel2,doclabel,doclabel2,doclabel3,doclabel4,doclabel5,doclabel6,
    doclabel7, doclabel8,doclabel9,doclabel10,doclabel11,doclabel12,doclabel13,doclabel14,doclabel15,doclabel16,doclabel17,doclabel18,doclabel19
    ,doclabel20,doclabel21,doclabel22,doclabel23,doclabel24,doclabel25,doclabel26,doclabel27,doclabel36,doclabel28,doclabel29,doclabel30,doclabel31,doclabel32,doclabel33,doclabel34,doclabel35,
            applabel1,applabel2,applabel3,applabel4,applabel5,applabel6,applabel7,applabel8,applabel9,applabel10,applabel11,applabel12,applabel13,applabel14,applabel15,applabel16,patientNameLabel,patientAgeLabel,patientDiseaseLabel,medicinesLabel;
    private Font f1,f2,f3,f4,f5;
    private ImageIcon icon,icon2,icon3,icon4;
    private JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14;
    private JTextArea area,medicinesTextArea;
    private JTextField tf,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10,tf11,tf12,tf13,tf14,patientNameTextField,patientAgeTextField,patientDiseaseTextField;
    private JComboBox box1;
    private String[] cb ={"1-9-2023","12-8-2023","1-9-2023","3-6-2023","15-5-2023","select"};
  


    
    

    MainFrame() {
        initComponent();
         
    }
    
    private String readUsernameFromFile(String fileName) {
    try {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String username = reader.readLine();
        reader.close(); // Close the reader after reading

        return username;
    } catch (IOException e) {
        e.printStackTrace();
        return "Default Username"; // Handle the error by providing a default username
    }
}

    
    
    
    
    public void initComponent() {
        c = this.getContentPane();
        c.setLayout(new BorderLayout());
        
        //icon and image
         icon = new ImageIcon(getClass().getResource("t.jpg"));
         icon2 = new ImageIcon(getClass().getResource("docp.png"));
         icon3 = new ImageIcon(getClass().getResource("p.png"));
         
         //icon and image
        icon4 = new ImageIcon(getClass().getResource("1.png"));
        this.setIconImage(icon4.getImage());
         
        // Scale the image to the label size
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(icon.getIconWidth(), icon.getIconHeight(), Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaledImg);
        
        //doctors image
        Image img2 = icon2.getImage();
        Image scaledImg2 = img2.getScaledInstance(icon2.getIconWidth(), icon2.getIconHeight(), Image.SCALE_SMOOTH);
        icon2 = new ImageIcon(scaledImg2);
        
        //doctors image
        Image img3 = icon3.getImage();
        Image scaledImg3 = img2.getScaledInstance(icon3.getIconWidth(), icon3.getIconHeight(), Image.SCALE_SMOOTH);
        icon3 = new ImageIcon(scaledImg3);
        
        //Cursor
        cursor = new Cursor(Cursor.HAND_CURSOR);
        cursor2 = new Cursor(Cursor.TEXT_CURSOR);
        
        
        //fonts
        f1 = new Font("Arial",Font.CENTER_BASELINE,22);
        f2 = new Font("Arial",Font.CENTER_BASELINE,30);
        f3 = new Font("Arial",Font.CENTER_BASELINE,19);
        f4 = new Font("Arial",Font.CENTER_BASELINE,15);
        f5 = new Font("Arial",Font.CENTER_BASELINE,13);
        
        // JMenuBar
        menubar = new JMenuBar();
        menubar.setBackground(Color.blue);
        this.setJMenuBar(menubar);

        // JMenu
        home = new JMenu("Home");
        home.setForeground(Color.white);
        home.setCursor(cursor);
        menubar.add(home);

        doctors = new JMenu("Doctors");
        doctors.setForeground(Color.white);
        doctors.setCursor(cursor);
        menubar.add(doctors);

        appointments = new JMenu("Appointments");
        appointments.setForeground(Color.white);
        appointments.setCursor(cursor);
        menubar.add(appointments);

        history = new JMenu("History");
        history.setForeground(Color.white);
        history.setCursor(cursor);
        menubar.add(history);
        
        imgmenu = new JMenu();
        imgmenu.setForeground(Color.white);
        imgmenu.setCursor(cursor);
        menubar.add(imgmenu);
        
        ImageIcon newMenuIcon = new ImageIcon(getClass().getResource("account.png")); 
        Image scaledNewMenuIcon = newMenuIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        newMenuIcon = new ImageIcon(scaledNewMenuIcon);
        imgmenu.setIcon(newMenuIcon);
        
        menubar.add(Box.createHorizontalGlue());
        menubar.add(imgmenu);
        
        
        // Read the username data from serial_data.txt
        String username = readUsernameFromFile("successful_logins.txt");

        // Create a new JMenu with the username
        JMenu userMenu = new JMenu(username);
        userMenu.setForeground(Color.white);
        userMenu.setCursor(cursor);

        // Add this new JMenu to the JMenuBar and set it to the left side of "New Menu"
        menubar.add(userMenu);
        
        
//----------------------------------------home muenuitem---------------------------------------       

        // JMenuItem
        homeItem = new JMenuItem("Clinic");
        home.add(homeItem);
        homeItem.setCursor(cursor);
        homeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                cardLayout.show(mainPanel, "Home");
            }
        });

//----------------------------------------doctor muenuitem---------------------------------------      

        doctorsItem = new JMenuItem("Find doctors");
        doctors.add(doctorsItem);
        doctorsItem.setCursor(cursor);
        doctorsItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                cardLayout.show(mainPanel, "Doctors");
            }
        });
        
        
//----------------------------------------Apppoinmet muenuitem---------------------------------------   
        appointmentsItem = new JMenuItem("Show Appointments");
        appointments.add(appointmentsItem);
        appointmentsItem.setCursor(cursor);
        appointmentsItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                cardLayout.show(mainPanel, "Appointments");
            }
        });
        
        
//----------------------------------------history muenuitem---------------------------------------   
        historyItem = new JMenuItem("Show History");
        history.add(historyItem);
        historyItem.setCursor(cursor);
        historyItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                cardLayout.show(mainPanel, "History");
            }
        });
       JMenuItem newItem = new JMenuItem("Log out");
        imgmenu.add(newItem);
        newItem.setCursor(cursor);
        newItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                try {
                    
                    File file = new File("successful_logins.txt");
                    if (file.exists()) {
                        PrintWriter writer = new PrintWriter(file);
                        writer.print(""); 
                        writer.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                    
                }

                
                dispose();

               
                Login ln = new Login();
                ln.setVisible(true);
                ln.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ln.setBounds(400, 100, 850, 550);
                ln.setTitle("Log in / Registration");
                ln.setResizable(false);
            }
        });
        
      
//-----------------------------------------Panels--------------------------------------------------

        //panel with CardLayout
        mainPanel = new JPanel(new CardLayout());
        
        //panels
        homePanel = new JPanel();
        homePanel.setBackground(Color.WHITE);
        mainPanel.add(homePanel, "Home");
        homePanel.setLayout(null);

        
        appointmentsPanel = new JPanel();
        appointmentsPanel.setBackground(Color.WHITE);
        mainPanel.add(appointmentsPanel, "Appointments");
        appointmentsPanel.setLayout(null);
        
        historyPanel = new JPanel();
        historyPanel.setBackground(Color.WHITE);
        mainPanel.add(historyPanel, "History");
        historyPanel.setLayout(null);
        
        doctorsPanel = new JPanel();
        doctorsPanel.setBackground(Color.WHITE);
        mainPanel.add(doctorsPanel, "Doctors");
        doctorsPanel.setLayout(null);
        
        // Add the main panel below the JMenuBar
        c.add(mainPanel, BorderLayout.CENTER);
        
        
        
        
//-------------------------------------------------Home page---------------------------------    
    
        homelabel = new JLabel("Safe Plus Dental Clinic");
        homelabel.setFont(f1);
        homelabel.setBounds(400, 10, 300, 30);
        Color customColor = new Color(0,0,128);
        homelabel.setForeground(customColor);
        homePanel.add(homelabel);
        
        
        imglabel = new JLabel(icon);
        imglabel.setBounds(487, 100, icon.getIconWidth(), icon.getIconHeight());
        homePanel.add(imglabel);
        

        headlabel = new JLabel("Welcome to,");
        headlabel.setFont(f2);
        headlabel.setBounds(100, 170, 200, 30);
        headlabel.setForeground(customColor);
        homePanel.add(headlabel);
        
        sublabel = new JLabel("Safe Plus Dental Clinic");
        sublabel.setFont(f1);
        sublabel.setBounds(100, 210, 300, 30);
        sublabel.setForeground(customColor);
        homePanel.add(sublabel);
        
        paralabel = new JLabel("Take you appoinment now,");
        paralabel.setFont(f3);
        paralabel.setBounds(100, 240, 300, 30);
        paralabel.setForeground(customColor);
        homePanel.add(paralabel);
        
        
        paralabel2 = new JLabel("* We have the best available doctors in this clinic. Click the doctors menu to find your suitable doctor.");
        paralabel2.setFont(f4);
        paralabel2.setBounds(100, 510, 800, 30);
        paralabel2.setForeground(customColor);
        homePanel.add(paralabel2);
        
        //jbutton
        b1 = new JButton(" Get Appoinment >>");
        b1.setOpaque(true);
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        b1.setCursor(cursor);
        b1.setBounds(100, 280, 150, 30);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                cardLayout.show(mainPanel, "Doctors");
            }
        });
        homePanel.add(b1);
        
//----------------------------------------Dcotors Page---------------------------------------------       
        
        //jlabel
        doclabel = new JLabel();
        doclabel.setText("Here you can find your suitabel doctor");
        doclabel.setBounds(345, 50, 500, 40);
        doclabel.setFont(f3);
        doclabel.setForeground(customColor);
        doctorsPanel.add(doclabel);
        
        doclabel2 = new JLabel();
        doclabel2.setText("Doctors of Clinic ");
        doclabel2.setBounds(400, 5, 300, 40);
        doclabel2.setFont(f2);
        doclabel2.setForeground(customColor);
        doctorsPanel.add(doclabel2);
        
        //profile image
        doclabel2 = new JLabel(icon2);
        doclabel2.setBounds(80, 150, icon2.getIconWidth(), icon2.getIconHeight());
        doctorsPanel.add(doclabel2);
        
        doclabel3 = new JLabel(icon2);
        doclabel3.setBounds(320, 150, icon2.getIconWidth(), icon2.getIconHeight());
        doctorsPanel.add(doclabel3);
        
        doclabel4 = new JLabel(icon2);
        doclabel4.setBounds(560, 150, icon2.getIconWidth(), icon2.getIconHeight());
        doctorsPanel.add(doclabel4);
        
        doclabel5 = new JLabel(icon2);
        doclabel5.setBounds(810, 150, icon2.getIconWidth(), icon2.getIconHeight());
        doctorsPanel.add(doclabel5);   
 
        doclabel6 = new JLabel(icon2);
        doclabel6.setBounds(80, 350, icon2.getIconWidth(), icon2.getIconHeight());
        doctorsPanel.add(doclabel6);
        
        doclabel7 = new JLabel(icon2);
        doclabel7.setBounds(320, 350, icon2.getIconWidth(), icon2.getIconHeight());
        doctorsPanel.add(doclabel7);
        
        doclabel8 = new JLabel(icon2);
        doclabel8.setBounds(560, 350, icon2.getIconWidth(), icon2.getIconHeight());
        doctorsPanel.add(doclabel8);
        
        doclabel9 = new JLabel(icon2);
        doclabel9.setBounds(810, 350, icon2.getIconWidth(), icon2.getIconHeight());
        doctorsPanel.add(doclabel9);
//-------------------------------------Top details-------------------------------------------------        
        //profile names
        doclabel10 = new JLabel();
        doclabel10.setText("Dr. Himel");
        doclabel10.setForeground(Color.blue);
        doclabel10.setBounds(89, 220, 150, 30);
        doctorsPanel.add(doclabel10);
        
        doclabel11 = new JLabel();
        doclabel11.setText("Dr. Rajib");
        doclabel11.setForeground(Color.blue);
        doclabel11.setBounds(328, 220, 150, 30);
        doctorsPanel.add(doclabel11);
        
        doclabel12 = new JLabel();
        doclabel12.setText("Dr. Ruma");
        doclabel12.setForeground(Color.blue);
        doclabel12.setBounds(570, 220, 150, 30);
        doctorsPanel.add(doclabel12);

        
        doclabel13 = new JLabel();
        doclabel13.setText("Dr. Kazi");
        doclabel13.setForeground(Color.blue);
        doclabel13.setBounds(820, 220, 150, 30);
        doctorsPanel.add(doclabel13);
        
//-------------------------------------Top details-------------------------------------------------   
        //custom colors
        Color customColor1 = new Color(0,0,102);

        //doctor degree
        doclabel14 = new JLabel();
        doclabel14.setText("MCM (Medicine)");
        doclabel14.setForeground(customColor1);
        doclabel14.setBounds(72, 235, 200, 30);
        doctorsPanel.add(doclabel14);
        
        doclabel15 = new JLabel();
        doclabel15.setText("MPhil (Philosophy)");
        doclabel15.setForeground(customColor1);
        doclabel15.setBounds(305, 235, 150, 30);
        doctorsPanel.add(doclabel15);
        
        doclabel16 = new JLabel();
        doclabel16.setText("MPH (Public Health)");
        doclabel16.setForeground(customColor1);
        doclabel16.setBounds(546, 235, 150, 30);
        doctorsPanel.add(doclabel16);
        
        doclabel17 = new JLabel();
        doclabel17.setText("MPhO (Philosophy in Ophthalmology)");
        doclabel17.setForeground(customColor1);
        doclabel17.setBounds(750, 235, 250, 30);
        doctorsPanel.add(doclabel17);

        //Buttons
        b2 = new JButton("Get Serial");
        b2.setBounds(67, 265, 100, 22);
        b2.setOpaque(true);
        b2.setBackground(Color.BLUE);
        b2.setForeground(Color.white);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Serial s = new Serial();
        s.setVisible(true);
        s.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        s.setBounds(550, 200, 500, 400);
        s.setTitle("Serial maker");
        s.setResizable(false);
            }
        });
        b2.setCursor(cursor);
        
        doctorsPanel.add(b2);
        
        b3 = new JButton("Get Serial");
        b3.setBounds(306, 265, 100, 22);
        b3.setOpaque(true);
        b3.setBackground(Color.BLUE);
        b3.setForeground(Color.white);
        b3.setCursor(cursor);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Serial s = new Serial();
        s.setVisible(true);
        s.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        s.setBounds(550, 200, 500, 400);
        s.setTitle("Serial maker");
        s.setResizable(false);
            }
        });
        doctorsPanel.add(b3);
        
        b4 = new JButton("Get Serial");
        b4.setBounds(550, 265, 100, 22);
        b4.setOpaque(true);
        b4.setBackground(Color.BLUE);
        b4.setForeground(Color.white);
        b4.setCursor(cursor);
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Serial s = new Serial();
        s.setVisible(true);
        s.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        s.setBounds(550, 200, 500, 400);
        s.setTitle("Serial maker");
        s.setResizable(false);
            }
        });
        doctorsPanel.add(b4);
        
        b5 = new JButton("Get Serial");
        b5.setBounds(795, 265, 100, 22);
        b5.setOpaque(true);
        b5.setBackground(Color.BLUE);
        b5.setForeground(Color.white);
        b5.setCursor(cursor);
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Serial s = new Serial();
        s.setVisible(true);
        s.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        s.setBounds(550, 200, 500, 400);
        s.setTitle("Serial maker");
        s.setResizable(false);
            }
        });
        doctorsPanel.add(b5);
        
 //----------------------------------------bottom details--------------------------------- 
 
        
        //profile names
        doclabel21 = new JLabel();
        doclabel21.setText("Dr. Abdullah");
        doclabel21.setForeground(Color.blue);
        doclabel21.setBounds(89, 420, 150, 30);
        doctorsPanel.add(doclabel21);
        
        doclabel22 = new JLabel();
        doclabel22.setText("Dr. Faysal");
        doclabel22.setForeground(Color.blue);
        doclabel22.setBounds(328, 420, 150, 30);
        doctorsPanel.add(doclabel22);
        
        doclabel23 = new JLabel();
        doclabel23.setText("Dr. Alif");
        doclabel23.setForeground(Color.blue);
        doclabel23.setBounds(570, 420, 150, 30);
        doctorsPanel.add(doclabel23);

        
        doclabel24 = new JLabel();
        doclabel24.setText("Dr. Mannan");
        doclabel24.setForeground(Color.blue);
        doclabel24.setBounds(820, 420, 150, 30);
        doctorsPanel.add(doclabel24);
        
//-----------------------------------bottom----------------------------------------------------  
        
        //doctor degree
        doclabel25 = new JLabel();
        doclabel25.setText("DO (Osteopathic Medicine)");
        doclabel25.setForeground(customColor1);
        doclabel25.setBounds(40, 435, 200, 30);
        doctorsPanel.add(doclabel25);
        
        doclabel26 = new JLabel();
        doclabel26.setText("DClinSurg (Surgery)");
        doclabel26.setForeground(customColor1);
        doclabel26.setBounds(300, 435, 150, 30);
        doctorsPanel.add(doclabel26);
        
        doclabel27 = new JLabel();
        doclabel27.setText("DS, DSurg (Surgery)");
        doclabel27.setForeground(customColor1);
        doclabel27.setBounds(540, 435, 150, 30);
        doctorsPanel.add(doclabel27);
        
        doclabel28 = new JLabel();
        doclabel28.setText("DPM (Podiatric Medicine)");
        doclabel28.setForeground(customColor1);
        doclabel28.setBounds(774, 435, 250, 30);
        doctorsPanel.add(doclabel28);
        
        //Buttons
        b6 = new JButton("Get Serial");
        b6.setBounds(67, 465, 100, 22);
        b6.setOpaque(true);
        b6.setBackground(Color.BLUE);
        b6.setForeground(Color.white);
        b6.setCursor(cursor);
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Serial s = new Serial();
        s.setVisible(true);
        s.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        s.setBounds(550, 200, 500, 400);
        s.setTitle("Serial maker");
        s.setResizable(false);
            }
        });
        doctorsPanel.add(b6);
        
        b7 = new JButton("Get Serial");
        b7.setBounds(306, 465, 100, 22);
        b7.setOpaque(true);
        b7.setBackground(Color.BLUE);
        b7.setForeground(Color.white);
        b7.setCursor(cursor);
        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Serial s = new Serial();
        s.setVisible(true);
        s.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        s.setBounds(550, 200, 500, 400);
        s.setTitle("Serial maker");
        s.setResizable(false);
            }
        });
        doctorsPanel.add(b7);
        
        b8 = new JButton("Get Serial");
        b8.setBounds(550, 465, 100, 22);
        b8.setOpaque(true);
        b8.setBackground(Color.BLUE);
        b8.setForeground(Color.white);
        b8.setCursor(cursor);
        b8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Serial s = new Serial();
        s.setVisible(true);
        s.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        s.setBounds(550, 200, 500, 400);
        s.setTitle("Serial maker");
        s.setResizable(false);
            }
        });
        doctorsPanel.add(b8);
        
        b9 = new JButton("Get Serial");
        b9.setBounds(795, 465, 100, 22);
        b9.setOpaque(true);
        b9.setBackground(Color.BLUE);
        b9.setForeground(Color.white);
        b9.setCursor(cursor);
        b9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Serial s = new Serial();
        s.setVisible(true);
        s.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        s.setBounds(550, 200, 500, 400);
        s.setTitle("Serial maker");
        s.setResizable(false);
            }
        });
        doctorsPanel.add(b9);
        
        
//--------------------------------------Appointment---------------------------------------------        
        
//        appointmentsPanel

        applabel1 = new JLabel("Appoinments");
        applabel1.setBounds(400, 5, 300, 30);
        applabel1.setFont(f2); 
        applabel1.setForeground(customColor);
        appointmentsPanel.add(applabel1);
        
        applabel2 = new JLabel("You can see  your appoinments");
        applabel2.setBounds(330, 45, 500, 30);
        applabel2.setFont(f1);
        applabel2.setForeground(customColor1);
        appointmentsPanel.add(applabel2);
        
        
        //profile image
        applabel3 = new JLabel(icon3);
        applabel3.setBounds(450, 140, icon3.getIconWidth(), icon3.getIconHeight());
        appointmentsPanel.add(applabel3);
        
        applabel4 = new JLabel("Appointment status : Yes");
        applabel4.setBounds(5, 120, 500, 30);
        applabel4.setFont(f4);
        applabel4.setForeground(customColor1);
        appointmentsPanel.add(applabel4);
        
        applabel5 = new JLabel("Dr. himel");
        applabel5.setBounds(468, 245, 150, 30);
        applabel5.setFont(f4);
        applabel5.setForeground(customColor1);
        appointmentsPanel.add(applabel5);
        
        applabel6 = new JLabel("Dcotor Type ");
        applabel6.setBounds(320, 300, 150, 30);
        applabel6.setFont(f4);
        applabel6.setForeground(customColor1);
        appointmentsPanel.add(applabel6);
        
        applabel7 = new JLabel("Patient name");
        applabel7.setBounds(320, 340, 150, 30);
        applabel7.setFont(f4);
        applabel7.setForeground(customColor1);
        appointmentsPanel.add(applabel7);
        
        applabel8 = new JLabel("Patient age");
        applabel8.setBounds(320, 380, 150, 30);
        applabel8.setFont(f4);
        applabel8.setForeground(customColor1);
        appointmentsPanel.add(applabel8);
        
        applabel9 = new JLabel("Patient no.");
        applabel9.setBounds(320, 420, 150, 30);
        applabel9.setFont(f4);
        applabel9.setForeground(customColor1);
        appointmentsPanel.add(applabel9);
        
        applabel10 = new JLabel("Apooinment date");
        applabel10.setBounds(320, 460, 150, 30);
        applabel10.setFont(f4);
        applabel10.setForeground(customColor1);
        appointmentsPanel.add(applabel10);
        
        //textfield
        
        tf = new JTextField("Medicine");
        tf.setCursor(cursor2);
        tf.setEditable(false);
        tf.setHorizontalAlignment(JTextField.CENTER);
        tf.setBounds(490, 305, 200, 20);
        appointmentsPanel.add(tf);
        
        tf2 = new JTextField("Masudul Alam");
        tf2.setEditable(false);
        tf2.setCursor(cursor2);
        tf2.setHorizontalAlignment(JTextField.CENTER);
        tf2.setBounds(490, 346, 200, 20);
        appointmentsPanel.add(tf2);
        
        tf3 = new JTextField("24");
        tf3.setEditable(false);
        tf3.setCursor(cursor2);
        tf3.setHorizontalAlignment(JTextField.CENTER);
        tf3.setBounds(490, 386, 200, 20);
        appointmentsPanel.add(tf3);
        
        tf4 = new JTextField("01876039841");
        tf4.setEditable(false);
        tf4.setCursor(cursor2);
        tf4.setHorizontalAlignment(JTextField.CENTER);
        tf4.setBounds(490, 426, 200, 20);
        appointmentsPanel.add(tf4);
        
        tf5 = new JTextField("10-11-2023");
        tf5.setEditable(false);
        tf5.setCursor(cursor2);
        tf5.setHorizontalAlignment(JTextField.CENTER);
        tf5.setBounds(490, 466, 200, 20);
        appointmentsPanel.add(tf5);
        
        //buttons
        b10 = new JButton("Doctors");
        b10.setBounds(30, 160, 100, 25);
        b10.setOpaque(true);
        b10.setBackground(Color.blue);
        b10.setCursor(cursor);
        b10.setForeground(Color.WHITE);
        b10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                cardLayout.show(mainPanel, "Doctors");
            }
        });
        appointmentsPanel.add(b10);
        
        b11 = new JButton("Home");
        b11.setBounds(30, 200, 100, 25);
        b11.setOpaque(true);
        b11.setBackground(Color.blue);
        b11.setCursor(cursor);
        b11.setForeground(Color.WHITE);
        b11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                cardLayout.show(mainPanel, "Home");
            }
        });
        appointmentsPanel.add(b11);
        
        b12 = new JButton("History");
        b12.setBounds(30, 240, 100, 25);
        b12.setOpaque(true);
        b12.setBackground(Color.blue);
        b12.setCursor(cursor);
        b12.setForeground(Color.WHITE);
        b12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
               CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                cardLayout.show(mainPanel, "History");
            }
        });
        appointmentsPanel.add(b12);

        appointmentsItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                cardLayout.show(mainPanel, "Appointments");

                String[] appointmentData = readDataFromFile();
                if (appointmentData != null && appointmentData.length == 4) {
                    tf2.setText(appointmentData[0]); 
                    tf3.setText(appointmentData[1]); 
                    tf4.setText(appointmentData[2]); 
                    tf5.setText(appointmentData[3]); 
                }
            }
        });

//-------------------------------------History--------------------------------------------------------------
    
        applabel10 = new JLabel();
        applabel10.setText("Clinic Visited History");
        applabel10.setFont(f1);
        applabel10.setForeground(customColor);
        applabel10.setBounds(400, 5, 400, 30);
        historyPanel.add(applabel10);
        
        applabel11 = new JLabel();
        applabel11.setText("Here You will see the visited doctors history");
        applabel11.setFont(f3);
        applabel11.setForeground(customColor);
        applabel11.setBounds(315, 45, 500, 30);
        historyPanel.add(applabel11);
        
        applabel12 = new JLabel();
        applabel12.setText("Select date Here");
        applabel12.setFont(f3);
        applabel12.setForeground(customColor);
        applabel12.setBounds(380, 130, 200, 30);
        historyPanel.add(applabel12);
        
        
        //combobox
        box1 = new JComboBox(cb);
        box1.setSelectedItem("select");
        box1.setToolTipText("select date to see your visited details");
        box1.setBounds(540, 132, 150, 30);
        box1.setForeground(customColor1);
        box1.setCursor(cursor);
        historyPanel.add(box1);
        
        //jlabels
        patientNameLabel = new JLabel("Patient Name");
        patientNameLabel.setFont(f4);
        patientNameLabel.setBounds(350, 210, 150, 30);
        historyPanel.add(patientNameLabel);

        patientAgeLabel = new JLabel("Patient Age");
        patientAgeLabel.setFont(f4);
        patientAgeLabel.setBounds(350, 250, 150, 30);
        historyPanel.add(patientAgeLabel);

        patientDiseaseLabel = new JLabel("Patient Disease");
        patientDiseaseLabel.setFont(f4);
        patientDiseaseLabel.setBounds(350, 290, 150, 30);
        historyPanel.add(patientDiseaseLabel);

        medicinesLabel = new JLabel("Medicines");
        medicinesLabel.setFont(f4);
        medicinesLabel.setBounds(350, 330, 150, 30);
        historyPanel.add(medicinesLabel);
        
        
        //jtextfields
        patientNameTextField = new JTextField();
        patientNameTextField.setEditable(false);
        patientNameTextField.setBounds(520, 212, 200, 25);
        historyPanel.add(patientNameTextField);

        patientAgeTextField = new JTextField();
        patientAgeTextField.setEditable(false);
        patientAgeTextField.setBounds(520, 252, 200, 25);
        historyPanel.add(patientAgeTextField);

        patientDiseaseTextField = new JTextField();
        patientDiseaseTextField.setEditable(false);
        patientDiseaseTextField.setBounds(520, 292, 200, 25);
        historyPanel.add(patientDiseaseTextField);
        
        //textarea
        medicinesTextArea = new JTextArea();
        medicinesTextArea.setEditable(false);
        medicinesTextArea.setLineWrap(true);
        medicinesTextArea.setWrapStyleWord(true);
        medicinesTextArea.setOpaque(true);
        medicinesTextArea.setBackground(Color.BLUE);
        medicinesTextArea.setForeground(Color.white);
        medicinesTextArea.setBounds(520, 332, 200, 100);
        historyPanel.add(medicinesTextArea);


        box1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedDate = (String) box1.getSelectedItem();

                
                if ("1-9-2023".equals(selectedDate)) {
                   
                    patientNameTextField.setText("Himel");
                    patientNameTextField.setHorizontalAlignment(JTextField.CENTER);
                    patientAgeTextField.setText("24");
                    patientAgeTextField.setHorizontalAlignment(JTextField.CENTER);
                    patientDiseaseTextField.setText("Toothache");
                    patientDiseaseTextField.setHorizontalAlignment(JTextField.CENTER);
                    medicinesTextArea.setText("1. Painkiller\n2. Antibiotics");
                }
                else if ("12-8-2023".equals(selectedDate)) {
                    
                    patientNameTextField.setText("Abdullah");
                    patientNameTextField.setHorizontalAlignment(JTextField.CENTER);
                    patientAgeTextField.setText("22");
                    patientAgeTextField.setHorizontalAlignment(JTextField.CENTER);
                    patientDiseaseTextField.setText("Cavity");
                    patientDiseaseTextField.setHorizontalAlignment(JTextField.CENTER);
                    medicinesTextArea.setText("1. Filling\n2. Painkiller");
                }
                else if("3-6-2023".equals(selectedDate)){
                
                    patientNameTextField.setText("Faysal");
                    patientNameTextField.setHorizontalAlignment(JTextField.CENTER);
                    patientAgeTextField.setText("23");
                    patientAgeTextField.setHorizontalAlignment(JTextField.CENTER);
                    patientDiseaseTextField.setText("Cavity");
                    patientDiseaseTextField.setHorizontalAlignment(JTextField.CENTER);
                    medicinesTextArea.setText("1. Filling\n2. Painkiller");
                    
                } 
                
                else if("15-5-2023".equals(selectedDate)){
                
                    patientNameTextField.setText("Ohi");
                    patientNameTextField.setHorizontalAlignment(JTextField.CENTER);
                    patientAgeTextField.setText("25");
                    patientAgeTextField.setHorizontalAlignment(JTextField.CENTER);
                    patientDiseaseTextField.setText("Cavity");
                    patientDiseaseTextField.setHorizontalAlignment(JTextField.CENTER);
                    medicinesTextArea.setText("1. Filling\n2. Painkiller");
                }
                else {
                   
                    patientNameTextField.setText("");
                    patientAgeTextField.setText("");
                    patientDiseaseTextField.setText("");
                    medicinesTextArea.setText("");
                }
            }
        });
        
        

    }
    // Define a method to read data from the file
private String[] readDataFromFile() {
    String[] data = new String[4]; // Array to store the data: [0] name, [1] age, [2] phone number, [3] appointment date
    try (BufferedReader reader = new BufferedReader(new FileReader("serial_data.txt"))) {
        for (int i = 0; i < data.length; i++) {
            data[i] = reader.readLine();
        }
    } catch (IOException e) {
        e.printStackTrace(); 
    }
    return data;
}




    public static void main(String[] args) {
        MainFrame fr = new MainFrame();
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setBounds(300, 100, 1000, 600);
        fr.setResizable(false);
        fr.setTitle("Safe Plus Dental Clinic");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

  
}
