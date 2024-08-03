import java.awt.*;      
import java.awt.event.*; 
import javax.swing.*;
import java.util.*;
import java.util.concurrent.Flow;
import java.io.*;

public class Gui extends JFrame implements ActionListener{
   
   
   public Gui()  
   {   
      JFrame frame = new JFrame("Arctic Tracker");
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      Dimension frameSize = getSize();
      int x = ((screenSize.width - frameSize.width) / 4)+200;
      int y = (screenSize.height - frameSize.height) / 4;
      frame.setLocation(x, y);
      frame.setSize(720, 960);
      //frame.add(new Drawing());
      
      frame.setResizable(false);
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLayout(new GridLayout(3, 1, 15, 15));
      frame.getContentPane().setBackground(new Color(108,146,219));

      

      //Title label
      JLabel label1 = new JLabel("Arctic", SwingConstants.CENTER);
      label1.setFont(new Font("Arial", Font.BOLD, 80));
      label1.setVerticalAlignment(SwingConstants.BOTTOM);
      JLabel label2 = new JLabel("Tracker", SwingConstants.CENTER);
      label2.setFont(new Font("Arial", Font.BOLD, 80));
      label2.setVerticalAlignment(SwingConstants.TOP);
      //Stats button
      JButton stats = new JButton("Stats");
      stats.setForeground(new Color(85,145,169));
      stats.setFocusPainted(false);
      stats.setBackground(new Color(11,78,120));
      stats.addActionListener(this);
      stats.setActionCommand("stats");
      stats.setFont(new Font("Arial", Font.PLAIN, 70));
      //Ice cap
      JButton icecap = new JButton("Ice Cap");
      icecap.setForeground(new Color(85,145,169));
      icecap.setFocusPainted(false);
      icecap.setBackground(new Color(11,78,120));
      icecap.addActionListener(this);
      icecap.setActionCommand("icecap");
      icecap.setFont(new Font("Arial", Font.PLAIN, 70));
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
         //make an instance of stats class here
         System.out.println("test");
       }
       if (e.getActionCommand().equals("icecap")){
         //make an instance of icecap class here
         System.out.println("test2");
       }
   }
}