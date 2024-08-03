import java.awt.*;      
import java.awt.event.*; 
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Gui extends JFrame implements ActionListener{
   
   JButton day1 = new JButton("1");
   public Gui()  
   {   
      JFrame frame = new JFrame("Arctic Tracker");
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      Dimension frameSize = getSize();
      int x = ((screenSize.width - frameSize.width) / 4)+200;
      int y = (screenSize.height - frameSize.height) / 4;
      frame.setLocation(x, y);
      frame.setSize(720, 960);
      frame.add(new Drawing());
      frame.setResizable(false);
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLayout(null);
      frame.getContentPane().setBackground(new Color(108,146,219));
      /* some sort of button thing
      day1.setForeground(new Color(85,145,169));
      day1.setFocusPainted(false);
      day1.setBackground(new Color(11,78,120));
      day1.setVisible(true);
      day1.setActionCommand("day1");
      day1.addActionListener( this );
      add(day1);
      */
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
   public void actionPerformed(ActionEvent evt){
      if (evt.getActionCommand().equals("day1")){
         dispose();
         day1();
         repaint();
      }
   }
}
