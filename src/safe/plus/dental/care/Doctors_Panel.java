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
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.Timer;

public class Doctors_Panel extends JFrame implements ActionListener {

    private Container c;
    private JLabel label1, nameLabel, ageLabel, phoneLabel, medicineLabel, diseaseLabel, notificationLabel;
    private JTextField nameField, ageField, phoneField;
    private JTextArea medicineTextArea, diseaseTextArea, notificationTextArea;
    private JButton confirmbutton, clearbutton, optionbutton,refreshbutton,logbutton;
    private Font f, f2, f3;
    private Cursor cursor;
    private ImageIcon icon, icon2,icon3,icon4;
    private String lastPatientInfo = ""; 
    private JScrollPane medicineScrollPane,diseaseScrollPane,notificationScrollPane;

    Doctors_Panel() {
        initcomponent();
        setPatientInfoFromTextFile();

        // Create a timer to periodically check for updates
        Timer timer = new Timer(5000, new ActionListener() { // Adjust the interval as needed
            public void actionPerformed(ActionEvent e) {
                updatePatientInfoFromTextFile();
            }
        });
        timer.start();
    }

    public void initcomponent() {
        c = this.getContentPane();
        c.setLayout(null);

        // icon and image
        icon = new ImageIcon(getClass().getResource("doctor.png"));
        this.setIconImage(icon.getImage());

        icon2 = new ImageIcon(getClass().getResource("menu.png"));
        icon3 = new ImageIcon(getClass().getResource("reload.png"));
        icon4 = new ImageIcon(getClass().getResource("power-button.png"));

        // Fonts
        f = new Font("Arial", Font.CENTER_BASELINE, 22);
        f2 = new Font("Arial", Font.CENTER_BASELINE, 15);
        f3 = new Font("Arial", Font.HANGING_BASELINE, 13);

        // cursor
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // custom color
        Color customColor = new Color(0, 0, 128);

        label1 = new JLabel();
        label1.setBounds(320, 5, 400, 50);
        label1.setText("Doctor's Control Panel");
        label1.setFont(f);
        label1.setForeground(customColor);
        c.add(label1);

        nameLabel = new JLabel("Patient Name:");
        nameLabel.setBounds(100, 80, 150, 30);
        nameLabel.setFont(f2);
        c.add(nameLabel);

        ageLabel = new JLabel("Patient Age:");
        ageLabel.setBounds(100, 120, 150, 30);
        ageLabel.setFont(f2);
        c.add(ageLabel);

        phoneLabel = new JLabel("Patient Phone:");
        phoneLabel.setBounds(100, 160, 150, 30);
        phoneLabel.setFont(f2);
        c.add(phoneLabel);

        medicineLabel = new JLabel("Disease:");
        medicineLabel.setBounds(100, 200, 150, 30);
        medicineLabel.setFont(f2);
        c.add(medicineLabel);

        diseaseLabel = new JLabel("Medicine:");
        diseaseLabel.setBounds(100, 280, 150, 30);
        diseaseLabel.setFont(f2);
        c.add(diseaseLabel);
 
         
        nameField = new JTextField();
        nameField.setBounds(260, 80, 200, 30);
        nameField.setHorizontalAlignment(JTextField.CENTER);
        c.add(nameField);

        ageField = new JTextField();
        ageField.setBounds(260, 120, 200, 30);
        ageField.setHorizontalAlignment(JTextField.CENTER);
        c.add(ageField);

        phoneField = new JTextField();
        phoneField.setBounds(260, 160, 200, 30);
        phoneField.setHorizontalAlignment(JTextField.CENTER);
        c.add(phoneField);

        // custom color
        Color customColor1 = new Color(0, 0, 102);

        // Notification Label
        notificationLabel = new JLabel("Patient prescription details here");
        notificationLabel.setFont(f3);
        notificationLabel.setForeground(customColor1);
        notificationLabel.setBounds(600, 110, 300, 30);
        c.add(notificationLabel);

        medicineTextArea = new JTextArea();
        medicineTextArea.setOpaque(true);
        medicineTextArea.setBackground(Color.blue);
        medicineTextArea.setForeground(Color.white);
        medicineTextArea.setFont(f3);
        medicineTextArea.setBounds(260, 200, 200, 60);
        c.add(medicineTextArea);

        diseaseTextArea = new JTextArea();
        diseaseTextArea.setOpaque(true);
        diseaseTextArea.setFont(f3);
        diseaseTextArea.setBackground(Color.blue);
        diseaseTextArea.setForeground(Color.white);
        diseaseTextArea.setBounds(260, 280, 200, 100);
        c.add(diseaseTextArea);

        // Notification Text Area
        notificationTextArea = new JTextArea();
        notificationTextArea.setOpaque(true);
        notificationTextArea.setBackground(Color.blue);
        notificationTextArea.setForeground(Color.white);
        notificationTextArea.setBounds(600, 140, 180, 150);
        notificationTextArea.setEditable(false);
        c.add(notificationTextArea);

        // Buttons
        confirmbutton = new JButton("Submit");
        confirmbutton.setOpaque(true);
        confirmbutton.setBackground(Color.blue);
        confirmbutton.setForeground(Color.white);
        confirmbutton.setCursor(cursor);
        confirmbutton.setBounds(310, 400, 100, 31);
        c.add(confirmbutton);

        clearbutton = new JButton("Clear");
        clearbutton.setOpaque(true);
        clearbutton.setBackground(Color.blue);
        clearbutton.setForeground(Color.white);
        clearbutton.setCursor(cursor);
        clearbutton.setBounds(644, 300, 100, 31);
        c.add(clearbutton);

        optionbutton = new JButton(icon2);
        optionbutton.setOpaque(true);
        optionbutton.setBackground(Color.blue);
        optionbutton.setForeground(Color.white);
        optionbutton.setCursor(cursor);
        optionbutton.setBounds(10, 10, 30, 28);
        optionbutton.setBorder(null);
        c.add(optionbutton);
        
        refreshbutton = new JButton(icon3);
        refreshbutton.setCursor(cursor);
        refreshbutton.setOpaque(true);
        refreshbutton.setBackground(Color.blue);
        refreshbutton.setToolTipText("Click to Refresh");
        refreshbutton.setBounds(50, 10, 30, 28);
        refreshbutton.addActionListener(this);
        c.add(refreshbutton);
        
        logbutton = new JButton(icon4);
        logbutton.setCursor(cursor);
        logbutton.setOpaque(true);
        logbutton.setBackground(Color.blue);
        logbutton.setToolTipText("Click to log out");
        logbutton.setBounds(800, 5, 30, 28);
        logbutton.addActionListener(this);
        c.add(logbutton);

        // scroll bars
        medicineScrollPane = new JScrollPane(medicineTextArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        medicineScrollPane.setBounds(260, 200, 200, 60);
        c.add(medicineScrollPane);

        diseaseScrollPane = new JScrollPane(diseaseTextArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        diseaseScrollPane.setBounds(260, 280, 200, 100);
        c.add(diseaseScrollPane);

        notificationScrollPane = new JScrollPane(notificationTextArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        notificationScrollPane.setBounds(600, 140, 180, 150);
        c.add(notificationScrollPane);

        confirmbutton.addActionListener(this);
        clearbutton.addActionListener(this);
        optionbutton.addActionListener(this);
        logbutton.addActionListener(this);
    }

   private void updatePatientInfoFromTextFile() {
    try (BufferedReader reader = new BufferedReader(new FileReader("serial_data.txt"))) {
        String line;
        StringBuilder patientInfo = new StringBuilder();
        int lineNumber = 1;
        boolean appointmentAccepted = false;

        while ((line = reader.readLine()) != null) {
            if (lineNumber <= 3) {
                patientInfo.append(line).append("\n");
            } else if (lineNumber == 4 && "Appointment accepted".equals(line)) {
                // Set a flag to indicate that the appointment is accepted
                appointmentAccepted = true;
            } else if (lineNumber == 4 && "Appointment has been canceled".equals(line)) {
                // Set the flag to indicate that the appointment is canceled
                appointmentAccepted = false;
            }
            lineNumber++;
        }

        if (appointmentAccepted) {
            String updatedPatientInfo = patientInfo.toString();
            if (!updatedPatientInfo.equals(lastPatientInfo)) {
                lastPatientInfo = updatedPatientInfo;
                // Update the fields with the new patient info
                String[] infoLines = updatedPatientInfo.split("\n");
                if (infoLines.length >= 3) {
                    nameField.setText(infoLines[0].trim());
                    ageField.setText(infoLines[1].trim());
                    phoneField.setText(infoLines[2].trim());
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "An error occurred while reading patient data.");
    }
}



    private void setPatientInfoFromTextFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("serial_data.txt"))) {
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                switch (lineNumber) {
                    case 1:
                        nameField.setText(line);
                        break;
                    case 2:
                        ageField.setText(line);
                        break;
                    case 3:
                        phoneField.setText(line);
                        break;
                    case 4:
                        if (line.equals("Appointment accepted")) {
                            // The appointment is accepted, you can update the fields as needed.
                            // Add your logic here.
                        }
                        break;
                    default:
                        break;
                }
                lineNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred while reading patient data.");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
                //nameField ageField phoneField
        if (e.getSource() == confirmbutton) {
            String a = nameField.getText();
            String b = ageField.getText();
            String z = phoneField.getText();
            String c = diseaseTextArea.getText();
            String d = medicineTextArea.getText();

            if (c.isEmpty() || d.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill out all the required fields.");
            } else {
                notificationTextArea.setText("  " + nameField.getText() + "\n\n" + "  " + ageField.getText() + "\n\n"
                        + " " + phoneField.getText() + "\n\n" + "  " + d + "\n\n" + "  " + c);
              
                
            
            }

        } else if (e.getSource() == clearbutton) {

            notificationTextArea.setText("");
        } else if (e.getSource() == optionbutton) {
            
            
            Option_menu om = new Option_menu();
            om.setVisible(true);
            om.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            om.setBounds(550, 150, 600, 450);
            om.setTitle("Doctor's Option Menu");
            om.setResizable(false);
            
          
        }
        else if(e.getSource()==refreshbutton){
            
        dispose();
        Doctors_Panel p = new Doctors_Panel();
        p.setVisible(true);
        p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p.setBounds(400, 100, 850, 550);
        p.setTitle("Doctor's Panel");
        p.setResizable(false);
        }
        else if (e.getSource()==logbutton){
            
            dispose();
            
            Doctors_login ln = new Doctors_login();
            ln.setVisible(true);
            ln.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ln.setBounds(400, 100, 850, 550);
            ln.setTitle(" Doctors Log in");
            ln.setResizable(false);
        }
    }

    public static void main(String[] args) {
        Doctors_Panel p = new Doctors_Panel();
        p.setVisible(true);
        p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p.setBounds(400, 100, 850, 550);
        p.setTitle("Doctor's Panel");
        p.setResizable(false);
    }
}
