package safe.plus.dental.care;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.Timer;

public class Start extends JFrame implements ActionListener {

    private Container c;
    private JProgressBar jbar;
    private JWindow j;
    private ImageIcon icon;
    private JLabel imglabel,textlabel;
    private JPanel wpanel;
    private Font f1;
    private JButton nextbutton;
    private Cursor cursor;
    private Timer timer;
    

    Start() {
        initComponents();
        window();
    }

    public void initComponents() {
        c = this.getContentPane();
        c.setLayout(null);
        
        

        // ImageIcon
        icon = new ImageIcon(getClass().getResource("logo.png"));
        this.setIconImage(icon.getImage());

        // Scale the image to the label size
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(icon.getIconWidth(), icon.getIconHeight(), Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaledImg);
        
        
        //fonts
        f1= new Font("Calibri",Font.ROMAN_BASELINE+Font.ITALIC,30);
        
        
        //Cursor
        cursor = new Cursor(Cursor.HAND_CURSOR);
        
        
        // JLabel
        imglabel = new JLabel(icon);
        imglabel.setBounds(210, 0, icon.getIconWidth(), icon.getIconHeight());
        c.add(imglabel);
        
        
        textlabel = new JLabel("Welcome to Safe Plus Dental Clinic");
        textlabel.setForeground(Color.blue);
        textlabel.setBounds(215, 300, 500, 40);
        textlabel.setFont(f1);
        c.add(textlabel);
        
        //jbutton
        nextbutton = new JButton("Next");
        nextbutton.setBounds(380, 350, 100, 30);
        nextbutton.setOpaque(true);
        nextbutton.setBackground(Color.blue);
        nextbutton.setForeground(Color.white);
        nextbutton.setCursor(cursor);
        c.add(nextbutton);
        
        nextbutton.addActionListener(this);
        
    }
    
    public void window(){
         j = new JWindow();
         j.setVisible(true);
         j.setSize(500,400);
         j.setLocationRelativeTo(null);
         
        wpanel = new JPanel();
        j.add(wpanel);
        wpanel.setBorder(BorderFactory.createLineBorder(Color.black));
        
        JLabel imageLabel = new JLabel(icon);
        wpanel.add(imageLabel);
        
        jbar = new JProgressBar(0,100);
        jbar.setBackground(Color.black);
        jbar.setOpaque(true);
        jbar.setForeground(Color.blue);
        j.add(BorderLayout.PAGE_END,jbar);
        
        timer = new Timer(100,new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e) {
             
                 int x = jbar.getValue();
                 
                 if(x==100){
                 j.dispose();
                 
                    Start.this.setVisible(true);
                    timer.stop();
                 }
                 else{
                 jbar.setValue(x+10);
                     
                 }
                 
             }
        
            
        });
        timer.start();
        
    }
//    ---------------------------ActionListener------------------------------------------
     @Override
    public void actionPerformed(ActionEvent e) {
    
        if(e.getSource()==nextbutton){
        
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
        Start sfdc = new Start();
//        sfdc.setVisible(true);
        sfdc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sfdc.setBounds(400, 100, 850, 550);
        sfdc.setTitle("Safe Plus Dental Clinic");
        sfdc.setResizable(false);
    }

   
}
