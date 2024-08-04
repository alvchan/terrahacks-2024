
import java.util.*;
import java.awt.* ;
import java.awt.event.*;
import javax.swing.*;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;

public class Stats extends JFrame{
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = getSize();
    public int fontSize = (int) screenSize.width / 50;
    Tracker t1;
    public Stats(){
        t1 = new Tracker();
        HashMap<String, Long> values = t1.value();
        ArrayList<String> apps = new ArrayList<String>();
        for (String s : values.keySet()){
            apps.add(s);
        }
        //Create labels
        JLabel label1 = new JLabel("1. " + apps.get(0));
        label1.setFont(new Font("Arial", Font.PLAIN, fontSize));
        label1.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel label2 = new JLabel("2. " + apps.get(1));
        label2.setFont(new Font("Arial", Font.PLAIN, fontSize));
        label2.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel label3 = new JLabel("3. " + apps.get(2));
        label3.setFont(new Font("Arial", Font.PLAIN, fontSize));
        label3.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel label4 = new JLabel("4. " + apps.get(3));
        label4.setFont(new Font("Arial", Font.PLAIN, fontSize));
        label4.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel label5 = new JLabel("5. " + apps.get(4));
        label5.setFont(new Font("Arial", Font.PLAIN, fontSize));
        label5.setBorder(BorderFactory.createLineBorder(Color.black));
        //Create Panel
        JPanel appList = new JPanel();
        appList.setBackground(new Color(108,146,219));
        appList.setLayout(new GridLayout(5, 1, 10, 10));
        appList.add(label1);
        appList.add(label2);
        appList.add(label3);
        appList.add(label4);
        appList.add(label5);
        add(appList);

        //Create other labels
        JLabel label6 = new JLabel("" + values.get(apps.get(0)));
        label6.setFont(new Font("Arial", Font.PLAIN, fontSize));
        label6.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel label7 = new JLabel("" + values.get(apps.get(1)));
        label7.setFont(new Font("Arial", Font.PLAIN, fontSize));
        label7.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel label8 = new JLabel("" + values.get(apps.get(2)));
        label8.setFont(new Font("Arial", Font.PLAIN, fontSize));
        label8.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel label9 = new JLabel("" + values.get(apps.get(3)));
        label9.setFont(new Font("Arial", Font.PLAIN, fontSize));
        label9.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel label10 = new JLabel("" + values.get(apps.get(4)));
        label10.setFont(new Font("Arial", Font.PLAIN, fontSize));
        label10.setBorder(BorderFactory.createLineBorder(Color.black));
        //Create back button
        JButton backButton = new JButtion("Back");
        backButton.setFont(new Font("Arial", Font.PLAIN, fontSize));
        label10.setBorder(BorderFactory.createLineBorder(Color.black));
        JPanel numAndBack = new JPanel();
        numAndBack.setLayout(new GridLayout(2, 1));
        numAndBack.add(label10);
        numAndBack.add(backButton);
        JPanel numList = new JPanel();
        numList.setBackground(new Color(108,146,219));
        numList.setLayout(new GridLayout(5, 1, 10, 10));
        numList.add(label6);
        numList.add(label7);
        numList.add(label8);
        numList.add(label9);
        numList.add(numAndBack);
        add(numList);
    }

    

}
