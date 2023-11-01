package safe.plus.dental.care;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Option_menu extends JFrame implements ActionListener {

    private Container c;
    private JButton viewAppointmentsButton, cancelButton, acceptButton,refreshbutton;
    private JTextArea appointmentDataTextArea;
    private JLabel label;
    private Cursor cursor;
    private Font f;
    private ImageIcon icon, icon2;

    Option_menu() {
        initComponent();
    }

    private void initComponent() {
        c = this.getContentPane();
        c.setLayout(null);

        //cursor
        cursor = new Cursor(Cursor.HAND_CURSOR);

        //icon
        icon = new ImageIcon(getClass().getResource("close.png"));
        icon2 = new ImageIcon(getClass().getResource("verified.png"));

        //font
        f = new Font("Arial", Font.CENTER_BASELINE, 18);

        //
        Color customColor = new Color(0, 0, 128);

        //jlabel
        label = new JLabel("Appointment Control Panel");
        label.setBounds(191, -10, 250, 50);
        label.setForeground(customColor);
        label.setFont(f);

        viewAppointmentsButton = new JButton("View Appointments");
        viewAppointmentsButton.setCursor(cursor);
        viewAppointmentsButton.setOpaque(true);
        viewAppointmentsButton.setBackground(Color.blue);
        viewAppointmentsButton.setForeground(Color.white);
        viewAppointmentsButton.setBounds(230, 105, 150, 30);
        viewAppointmentsButton.addActionListener(this);

        acceptButton = new JButton(icon2);
        acceptButton.setCursor(cursor);
        acceptButton.setOpaque(true);
        acceptButton.setBackground(Color.blue);
        acceptButton.setToolTipText("Click to close the menu");
        acceptButton.setBounds(315, 325, 40, 40);
        acceptButton.addActionListener(this);

        cancelButton = new JButton(icon);
        cancelButton.setCursor(cursor);
        cancelButton.setOpaque(true);
        cancelButton.setBackground(Color.blue);
        cancelButton.setBounds(255, 325, 40, 40);
        cancelButton.addActionListener(this);

      
        
        appointmentDataTextArea = new JTextArea();
        appointmentDataTextArea.setBounds(125, 150, 350, 160);
        appointmentDataTextArea.setEditable(false);

        c.add(viewAppointmentsButton);
        c.add(cancelButton);
        c.add(appointmentDataTextArea);
        c.add(acceptButton);
        c.add(label);

    }

    private void displayAppointmentData() {
        StringBuilder appointmentData = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("serial_data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                appointmentData.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            appointmentData.append("An error occurred while reading the data.");
        }

        appointmentDataTextArea.setText(appointmentData.toString());
    }

    private void appendToAppointmentData(String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("serial_data.txt", true))) {
            writer.write(data);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
            appointmentDataTextArea.setText("An error occurred while adding data.");
        }
    }

    private void deleteAppointmentData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("serial_data.txt", false))) {
            writer.write("");
            writer.flush();
            appointmentDataTextArea.setText("Appointment has been canceled");
        } catch (IOException e) {
            e.printStackTrace();
            appointmentDataTextArea.setText("An error occurred while deleting the data.");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewAppointmentsButton) {
            displayAppointmentData();
        } else if (e.getSource() == cancelButton) {
            deleteAppointmentData();
            
        } else if (e.getSource() == acceptButton) {
            // Show "Appointment accepted" message in the textarea
          
            dispose();
         
        }
     
    }

    public static void main(String[] args) {
        Option_menu om = new Option_menu();
        om.setVisible(true);
        om.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        om.setBounds(550, 200, 600, 450);
        om.setTitle("Appointment Control Panel");
        om.setResizable(false);
    }
}
