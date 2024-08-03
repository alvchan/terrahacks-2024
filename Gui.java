import java.awt.*;      
import java.awt.event.*; 
import javax.swing.*;
import java.util.*;
import java.util.concurrent.Flow;
import java.io.*;

public class Gui extends JFrame{
   
   
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
      frame.setLayout(new FlowLayout());
      frame.getContentPane().setBackground(new Color(108,146,219));
      JPanel btns = new JPanel();
      btns.setLayout(new FlowLayout());
      btns.setBackground(new Color(108,146,219));
      JButton stats = new JButton("stats");
      stats.setForeground(new Color(85,145,169));
      stats.setFocusPainted(false);
      stats.setBackground(new Color(11,78,120));
      btns.add(stats);
      JButton icecap = new JButton("Ice Cap");
      icecap.setForeground(new Color(85,145,169));
      icecap.setFocusPainted(false);
      icecap.setBackground(new Color(11,78,120));
      btns.add(icecap);
      
      frame.add(btns);
      
      
      
    
   }   
      
   

   public static void main (String[] args)
   {
      new Gui();     
   }

   public class Drawing extends JComponent{ 
      public Drawing(){}
      
      public void paint(Graphics g){ 
         
      
         
         g.fillOval(470, 320, 50, 50);
         g.fillOval(510, 310, 50, 50);
         
         // title 
         g.setColor(Color.BLACK);
         Font largeSerifFont = new Font("Sans Serif", Font.BOLD, 60);
         g.setFont(largeSerifFont);
         g.drawString("ARCTIC", 230, 630);
         g.drawString("TRACKER", 200, 680);
      }
   }
   
}
