package com.oopCW;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

public class GUI_NameChecker extends JFrame implements ActionListener {
    JTextField getNameTF;
    JButton searchBtn,backBtn,exitBtn;
    private static boolean isNameWrong = false;

    public GUI_NameChecker () {
        setBounds(100, 40, 1200, 800);
        getContentPane ().setBackground (new Color (91, 83, 83));
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setResizable (false);
        setLayout(null);

        JLabel l1 = new JLabel ("                           RACER STATISTICS         ");
        l1.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 5));
        l1.setFont (new Font ("Andale Mono", Font.PLAIN, 25));
        l1.setForeground (new Color (208, 228, 248));
        l1.setBounds(270, 20, 700, 45);
        add(l1);

        JLabel l2 = new JLabel("AVAILABLE DRIVER LIST");
        l2.setForeground(new Color(175, 15, 15));
        l2.setFont(new Font("Andale Mono", Font.PLAIN,22));
        l2.setBounds(80, 85, 700, 30);

        JTable table = new JTable ();
        Object[] columns = {"AVAILABLE DRIVER LIST"};
        table.setBounds (200,100,200,600);
        DefaultTableModel model = new DefaultTableModel ();

        model.setColumnIdentifiers (columns);
        table.setModel (model);

        table.getTableHeader ().setForeground(new Color(255, 255, 255));
        table.getTableHeader ().setBackground (new Color(40, 205, 255));
        table.getTableHeader ().setFont(new Font("Andale Mono", Font.PLAIN,18));
        table.setRowHeight (35);
        table.setRowMargin (10);//444444444444444
        table.setIntercellSpacing(new Dimension(250,10));

        table.setForeground (Color.black);
        table.setSelectionBackground (Color.red);
        table.setGridColor (Color.red);
        table.setSelectionForeground (Color.white);
        table.setFont (new Font ("Tahoma", Font.PLAIN, 17));
        table.setRowHeight (30);
        table.setAutoCreateColumnsFromModel (true);

        JScrollPane pane = new JScrollPane (table);
        pane.setForeground (Color.RED);
        pane.setBackground (new Color(30, 144, 255));
        pane.setBounds (10, 150, 400, 450);

        Object[] row = new Object[1];

        Formula1ChampionshipManager.driverStatistics.forEach (driver->{
            row[0] ="    "+ driver.getDriverName ().toUpperCase(Locale.ROOT);
            model.addRow (row);

        });
        add (pane);

        JLabel l3 = new JLabel ();
        if (!isNameWrong) {
            l3.setText ("ENTER A DRIVE NAME FROM THE LIST TO DISPLAY ALL RACES PARTICIPATED");
            l3.setForeground (new Color (32, 238, 9));
            l3.setBounds(420, 150, 900, 30);
        } else {
            l3.setText ("ENTERED DRIVER NAME IS NOT INT THE LIST PLEASE TRY AGAIN");
            l3.setForeground (new Color (238, 9, 9));
            l3.setBounds(450, 150, 900, 30);
        }
        l3.setFont(new Font("Andale Mono", Font.PLAIN,18));
        add(l3);
//        l1.show (true);
//        l2.show (false);
        getNameTF = new JTextField();
        getNameTF.setBounds(525, 200, 400, 30);
        getNameTF.setFont(new Font("Times New Roman", Font.BOLD, 25));
        add(getNameTF);

        searchBtn = new JButton("SEARCH");
        searchBtn.setBounds(630, 240, 200, 30);
        searchBtn.setBackground(new Color(30, 144, 255));
        searchBtn.setForeground (Color.WHITE);
        searchBtn.addActionListener(this);
        add (searchBtn);

        backBtn = new JButton("BACK ");
        backBtn.setBounds (875, 670, 120, 40);
        backBtn.setFont (new Font ("ALGERIAN", Font.PLAIN, 25));
        backBtn.setForeground (Color.WHITE);
        backBtn.setBackground(new Color(30, 144, 255));
        backBtn.addActionListener (this);
        add (backBtn);

        exitBtn = new JButton("EXIT ");
        exitBtn.setBounds (1015, 670, 120, 40);
        exitBtn.setFont (new Font ("ALGERIAN", Font.PLAIN, 25));
        exitBtn.setBackground(new Color(176, 15, 15));
        exitBtn.setForeground(Color.WHITE);
        exitBtn.addActionListener (this);
        add (exitBtn);

        setVisible (true);
    }

    @Override
    public void actionPerformed (ActionEvent e) {
        String name = getNameTF.getText ().toLowerCase (Locale.ROOT);
        AtomicBoolean isExist = new AtomicBoolean (false);
        if (e.getSource () == searchBtn) {
            Formula1ChampionshipManager.raceStatistics.forEach (driverName->{
                if (driverName.getDriverName ().equals (name)) {
                    isExist.set (true);
                }

            });
            if (!isExist.get ()) {//this will execute when wrong name is entered .user navigates to re enter
//                System.out.println ("eeeeeeeeeeeeeeeeeeeeeeeeeeeee 145");
                isNameWrong = true;
                setVisible (false);
                isExist.getAndSet (false);
                getNameTF.setText (null);
//                System.out.println ("not equals777777777777777777777");
                new GUI_NameChecker ();
            } else {//this will execute when matching name is entered
//                System.out.println ("3333333333333333333333333333 153");
                setVisible (false);
                isNameWrong = false;
                new GUI_RacerAllRaces (name);
                System.out.println ("equals");
            }
        } else if (e.getSource () == backBtn) {
            getNameTF.setText (null);
            isNameWrong = false;
            setVisible (false);
            new GUI_Main ();

        } else if (e.getSource () == exitBtn) {
            System.exit (0);
        }
    }
}
