package com.oopCW;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Swing extends JFrame {

//

    public Swing () throws HeadlessException {
        this.setTitle ("championship");

        this.setResizable (true);
        this.setSize (1000,1000);
        JLabel topicLabel = new JLabel ("WELCOME TO CHAMPIONSHIP MANAGER");
        topicLabel.setText ("fuck me");

        ImageIcon carImage = new ImageIcon ("formula1.jpg");

        topicLabel.setHorizontalTextPosition ( JLabel.CENTER);


        topicLabel.setIcon (carImage);
        this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
//        topicLabel.setText ("WELCOME TO CHAMPIONSHIP MANAGER");

//        topic.setBounds (0, 25 , 100, 20);


//        this.add (carImage);

        this.add (topicLabel);

        this.setVisible (true);
        this.getContentPane ().setBackground (Color.green);

//        addWindowListener (new WindowAdapter () {
//            public void windowClosing (WindowEvent e) {
////                Main.menu (Main.scanner);
//                Main.formula1ChampionshipManager.displayADriverStatistics ();
//
//            }
//
//        });

    }
}
