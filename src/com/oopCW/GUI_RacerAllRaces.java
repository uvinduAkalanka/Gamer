package com.oopCW;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_RacerAllRaces extends JFrame implements ActionListener {
    JButton checkAgainBtn,back1Btn, exitBtn;
    public GUI_RacerAllRaces (String name) {
        setBounds(100, 40, 1200, 800);
        getContentPane ().setBackground (new Color (91, 83, 83));
        setTitle ("DRIVER'S RACES");
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setResizable (false);
        setLayout(null);

        JLabel l1 = new JLabel("ALL THE RACES PARTICIPATED BY DRIVER -"+name.toUpperCase ());
        l1.setForeground (new Color (208, 228, 248));
        l1.setFont(new Font("Andale Mono", Font.PLAIN,25));
        l1.setBounds(300, 20, 700, 30);
        add(l1);

        JTable table = new JTable ();
        Object[] columns = {"RACE OF THE DATE","WON POSITION "};
        table.getTableHeader ().setForeground(new Color(255, 255, 255));
        table.getTableHeader ().setBackground (new Color(40, 205, 255));
        table.getTableHeader ().setFont(new Font("Andale Mono", Font.PLAIN,25));

        table.setBounds (200,100,200,600);
        DefaultTableModel model = new DefaultTableModel ();

        model.setColumnIdentifiers (columns);
        table.setModel (model);
        table.setBackground (new Color(255, 255, 255, 136));
        table.setForeground (Color.black);
        table.setSelectionBackground (Color.red);
        table.setGridColor (new Color(73, 2, 182));
        table.setSelectionForeground (Color.white);
        table.setFont (new Font ("Tahoma", Font.PLAIN, 17));
        table.setRowHeight (30);
        table.setRowMargin (10);//444444444444444
        table.setIntercellSpacing(new Dimension(250,0));
        table.setAutoCreateColumnsFromModel (true);

        JScrollPane pane = new JScrollPane (table);
        pane.setForeground (Color.RED);
        pane.setBackground (Color.WHITE);
        pane.setBounds (200, 100, 800, 450);

        Object[] row = new Object[2];
//        from this code block it loops trough race details array and catches the objects that equals to the name from user input
        // then get the date nd race position to the table
        Formula1ChampionshipManager.raceStatistics.forEach (driverName ->{
            if (driverName.getDriverName ().equals (name)) {
                row[0] = ((Formula1Driver) driverName).getRaceDate ();
                row[1] = "   "+((Formula1Driver) driverName).getRacePosition ();
                model.addRow (row);
            }
        });
        add (pane);

        checkAgainBtn = new JButton("CHECK ANOTHER DRIVER");
        checkAgainBtn.setBounds(200, 640, 265, 30);
        checkAgainBtn.setForeground(Color.WHITE);
        checkAgainBtn.setFont (new Font ("ALGERIAN", Font.PLAIN, 20));

        checkAgainBtn.setBackground(new Color(0, 255, 215));
        checkAgainBtn.addActionListener(this);
        add(checkAgainBtn);

        back1Btn = new JButton("BACK MAIN MENU");
        back1Btn.setBounds(650, 640, 200, 30);
        back1Btn.setBackground(new Color(30, 144, 255));
        back1Btn.setForeground(Color.WHITE);
        back1Btn.setFont (new Font ("ALGERIAN", Font.PLAIN, 20));

        back1Btn.addActionListener(this);
        add(back1Btn);

        exitBtn= new JButton("EXIT");
        exitBtn.setBounds(900, 640, 100, 30);
        exitBtn.setBackground(new Color(176, 15, 15));
        exitBtn.setForeground(Color.WHITE);
        exitBtn.addActionListener(this);
        exitBtn.setFont (new Font ("ALGERIAN", Font.PLAIN, 20));
        add(exitBtn);

        setVisible (true);
    }

    @Override
    public void actionPerformed (ActionEvent e) {
        if (e.getSource () == checkAgainBtn) {
            setVisible (false);
            new GUI_NameChecker ();
        } else if (e.getSource () == exitBtn) {
            System.exit (0);
        }else if (e.getSource () == back1Btn) {
            this.setVisible (false);
            new GUI_Main ();
        }
    }
}
