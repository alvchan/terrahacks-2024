
import java.util.*;
import java.awt.* ;
import java.awt.event.*;
import javax.swing.*;

import MainMenu.Drawing;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;

public class Stats extends JFrame{
    public Stats(){
        
        //Create labels
        JLabel label1 = new JLabel("test1");
        label1.setFont(new Font("Arial", Font.PLAIN, 70));
        JLabel label2 = new JLabel("test2");
        label2.setFont(new Font("Arial", Font.PLAIN, 70));
        JLabel label3 = new JLabel("test3");
        label3.setFont(new Font("Arial", Font.PLAIN, 70));
        JLabel label4 = new JLabel("test4");
        label4.setFont(new Font("Arial", Font.PLAIN, 70));
        JLabel label5 = new JLabel("test5");
        label5.setFont(new Font("Arial", Font.PLAIN, 70));
        //Create Panel
        JPanel appList = new JPanel();
        JPanel graph = new JPanel();

        appList.setBackground(new Color(108,146,219));
        appList.setLayout(new GridLayout(5, 1, 10, 10));
        appList.add(label1);
        appList.add(label2);
        appList.add(label3);
        appList.add(label4);
        appList.add(label5);
        add(appList);

        add(graph);
    }
    
    

}
