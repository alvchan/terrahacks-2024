import javax.swing.JFrame;
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.*;      
import java.awt.event.*; 
import javax.swing.*;    
import java.awt.Dimension;
import javax.swing.BorderFactory;
import java.awt.Desktop;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.Toolkit;
import java.awt.Dimension;


public class Gui extends JFrame implements ActionListener{
   
   JFrame frame = new JFrame("Arctic Tracker");
   public Gui()  
   {   
      
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      Dimension frameSize = getSize();
      int x = ((screenSize.width - frameSize.width) / 4)+200;
      int y = (screenSize.height - frameSize.height) / 4;
      frame.setLocation(x, y);
      frame.setSize(520, 720);
      //frame.add(new Drawing());
      int fontSize = (int) screenSize.width / 50;
      frame.setResizable(true);
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLayout(new GridLayout(3, 1, 15, 15));
      frame.getContentPane().setBackground(new Color(108,146,219));

      

      //Title label
      JLabel label1 = new JLabel("Arctic", SwingConstants.CENTER);
      label1.setFont(new Font("Arial", Font.BOLD, fontSize));
      label1.setVerticalAlignment(SwingConstants.BOTTOM);
      JLabel label2 = new JLabel("Tracker", SwingConstants.CENTER);
      label2.setFont(new Font("Arial", Font.BOLD, fontSize));
      label2.setVerticalAlignment(SwingConstants.TOP);
      //Stats button
      JButton stats = new JButton("Stats");
      stats.setForeground(new Color(85,145,169));
      stats.setFocusPainted(false);
      stats.setBackground(new Color(11,78,120));
      stats.addActionListener(this);
      stats.setActionCommand("stats");
      stats.setFont(new Font("Arial", Font.PLAIN, fontSize));
      //Ice cap
      JButton icecap = new JButton("Ice Cap");
      icecap.setForeground(new Color(85,145,169));
      icecap.setFocusPainted(false);
      icecap.setBackground(new Color(11,78,120));
      icecap.addActionListener(this);
      icecap.setActionCommand("icecap");
      icecap.setFont(new Font("Arial", Font.PLAIN, fontSize));
      JPanel buttons = new JPanel();
      buttons.setLayout(new GridLayout(1,2));
      buttons.setBackground(new Color(108,146,219));
      buttons.add(stats);
      buttons.add(icecap);
      frame.add(label1);   
      frame.add(label2);
      frame.add(buttons);
      
      
      
    
   }   
      
   

   public static void main (String[] args)
   {
      new Gui();     
   }

   @Override
   public void actionPerformed(ActionEvent e) {
       // TODO Auto-generated method stub
       if (e.getActionCommand().equals("stats")){
         frame.dispose();
         Stats s1 = new Stats();
         Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
         Dimension frameSize = getSize();
         int x = ((screenSize.width - frameSize.width) / 4)+200;
         int y = (screenSize.height - frameSize.height) / 4;
         s1.setLocation(x, y);
         s1.setSize(640, 480);
         
         
         s1.setResizable(true);
         s1.setVisible(true);
         s1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         s1.setLayout(new GridLayout(1, 2, 15, 15));
         s1.getContentPane().setBackground(new Color(108,146,219));
       }
       if (e.getActionCommand().equals("icecap")){
         frame.dispose();
         IceCap i1 = new IceCap();
         Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
         Dimension frameSize = getSize();
         int x = ((screenSize.width - frameSize.width) / 4)+200;
         int y = (screenSize.height - frameSize.height) / 4;
         i1.setLocation(x, y);
         i1.setSize(640, 480);
         
         
         i1.setResizable(true);
         i1.setVisible(true);
         i1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         i1.setLayout(new GridLayout(1, 2, 15, 15));
         i1.getContentPane().setBackground(new Color(108,146,219));
       }
   }
}
