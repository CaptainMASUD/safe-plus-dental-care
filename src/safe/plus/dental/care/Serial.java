package safe.plus.dental.care;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Serial extends JFrame implements ActionListener {

    private Container c;
    private JLabel nlabel, agelabel, phnlabel, appdate, hlabel, hlabel2;
    private Font f, f1, f2, f3, f4;
    private JTextField nf, af, pf;
    private JComboBox box;
    private JButton b1;
    private Cursor cursor;
    private ImageIcon icon4;
    private String[] sc = {"1-12-2023", "5-12-2023", "8-12-2023", "None"};

    Serial() {
        initcomponent();
    }

    public void initcomponent() {
        c = this.getContentPane();
        c.setLayout(null);

        //icon and image
        icon4 = new ImageIcon(getClass().getResource("morning-routine.png"));
        this.setIconImage(icon4.getImage());
        
        // font
        f = new Font("Arial", Font.CENTER_BASELINE, 15);
        f2 = new Font("Arial", Font.CENTER_BASELINE, 14);
        f3 = new Font("Arial", Font.CENTER_BASELINE, 13);
        f4 = new Font("Arial", Font.CENTER_BASELINE, 18);

        // custom color
        Color customColor1 = new Color(0, 0, 102);

        //cursor
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // jlabel
        hlabel = new JLabel();
        hlabel.setFont(f4);
        hlabel.setForeground(Color.BLUE);
        hlabel.setBounds(190, 5, 200, 30);
        hlabel.setText("Fill up the form");
        c.add(hlabel);

        nlabel = new JLabel();
        nlabel.setForeground(customColor1);
        nlabel.setText("Patient name");
        nlabel.setFont(f);
        nlabel.setBounds(50, 80, 150, 30);
        c.add(nlabel);

        agelabel = new JLabel();
        agelabel.setForeground(customColor1);
        agelabel.setText("Patient age");
        agelabel.setFont(f);
        agelabel.setBounds(50, 130, 150, 30);
        c.add(agelabel);

        phnlabel = new JLabel();
        phnlabel.setForeground(customColor1);
        phnlabel.setText("Phone number");
        phnlabel.setFont(f);
        phnlabel.setBounds(50, 180, 150, 30);
        c.add(phnlabel);

        appdate = new JLabel();
        appdate.setForeground(customColor1);
        appdate.setText("Appointment date");
        appdate.setFont(f);
        appdate.setBounds(50, 230, 150, 30);
        c.add(appdate);

        nf = new JTextField();
        nf.setFont(f3);
        nf.setHorizontalAlignment(SwingConstants.CENTER); // Center-align text
        nf.setBounds(200, 80, 225, 30);
        c.add(nf);

        af = new JTextField();
        af.setFont(f3);
        af.setHorizontalAlignment(SwingConstants.CENTER); // Center-align text
        af.setBounds(200, 130, 225, 30);
        c.add(af);

        pf = new JTextField();
        pf.setFont(f3);
        pf.setHorizontalAlignment(SwingConstants.CENTER); // Center-align text
        pf.setBounds(200, 180, 225, 30);
        c.add(pf);

        box = new JComboBox(sc);
        box.setFont(f2);
        box.setSelectedItem("None");
        box.setRenderer(new DefaultListCellRenderer() {
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                setHorizontalAlignment(SwingConstants.CENTER);
                return this;
            }
        });
        box.setBounds(200, 230, 225, 30);
        c.add(box);

        b1 = new JButton();
        b1.setText("Submit");
        b1.setOpaque(true);
        b1.setBackground(Color.blue);
        b1.setForeground(Color.white);
        b1.setCursor(cursor);
        b1.setBounds(265, 280, 100, 30);
        c.add(b1);

        b1.addActionListener(this);
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        String s = nf.getText();
        String p = af.getText();
        String z = pf.getText();
        String selectedDate = (String) box.getSelectedItem();

        if (s.isEmpty() || p.isEmpty() || z.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill out the full form properly", "Blank box error", JOptionPane.ERROR_MESSAGE);
        } else if (selectedDate.equals("None")) {
            JOptionPane.showMessageDialog(null, "Please select an appointment date", "Appointment date error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                FileWriter writer = new FileWriter("serial_data.txt", false); // Use 'false' to overwrite the file

                BufferedWriter bw = new BufferedWriter(writer);

                String userData = s + "\n"
                        + p + "\n"
                        + z + "\n"
                        + selectedDate + "\n\n";

                bw.write(userData);

                bw.close();

                JOptionPane.showMessageDialog(null, "Appointment successful");
                dispose();
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "An error occurred while saving the data", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    public static void main(String[] args) {

        Serial s = new Serial();
        s.setVisible(true);
        s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        s.setBounds(550, 200, 500, 400);
        s.setTitle("Serial maker");
        s.setResizable(false);
    }
}
