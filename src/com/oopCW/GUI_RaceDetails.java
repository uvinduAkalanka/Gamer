package com.oopCW;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class GUI_RaceDetails extends JFrame implements ActionListener {
    JButton back1Btn, exitBtn;
    public GUI_RaceDetails () {
        setBounds(100, 40, 1200, 800);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        getContentPane ().setBackground (new Color (91, 83, 83));
        setTitle ("ALL RACES DETAILS");
        setResizable (false);
        setLayout(null);

        JLabel l1 = new JLabel ("ALL THE RACES GENERATED IN THE SEASON ACCORDING TO CREATED DATE");
        l1.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 5));
        l1.setFont (new Font ("Andale Mono", Font.PLAIN, 25));
        l1.setForeground (new Color (208, 228, 248));
        l1.setBounds(100, 25, 1000, 45);
        add(l1);

        Set<String> dates = new HashSet<> ();
        Formula1ChampionshipManager.raceStatistics.forEach (race->{
            dates.add (((Formula1Driver) race).getRaceDate ());
        });
        List<String> datesFromSavedObjects = new ArrayList<> (dates);


        JTable table = new JTable ();
        Object[] columns = {"RACE OF THE DATE"};
        table.setBounds (200,100,200,600);
        DefaultTableModel model = new DefaultTableModel ();

        model.setColumnIdentifiers (columns);
        table.setModel (model);
        table.setFont (new Font ("Tahoma", Font.PLAIN, 17));

        table.getTableHeader ().setForeground(new Color(255, 255, 255));
        table.getTableHeader ().setBackground (new Color(40, 205, 255));
        table.getTableHeader ().setFont(new Font("Andale Mono", Font.PLAIN,18));
        table.setRowHeight (35);
        table.setRowMargin (10);//444444444444444
        table.setIntercellSpacing(new Dimension(680,10));

        table.setAutoCreateColumnsFromModel (true);

        JScrollPane pane = new JScrollPane (table);
        pane.setForeground (Color.RED);
        pane.setBackground (Color.WHITE);
        pane.setBounds (200, 100, 800, 450);

        sortDates (datesFromSavedObjects);

        Object[] row = new Object[1];

        datesFromSavedObjects.forEach (date->{
            row[0] = date;
            model.addRow (row);

        });
        add (pane);

        back1Btn = new JButton("BACK");
        back1Btn.setBounds(470, 640, 100, 30);
        back1Btn.setFont (new Font ("ALGERIAN", Font.PLAIN, 25));
        back1Btn.setBackground(new Color(0, 255, 215));
        back1Btn.setForeground(Color.WHITE);
        back1Btn.addActionListener(this);
        add(back1Btn);

        exitBtn= new JButton("EXIT");
        exitBtn.setFont (new Font ("ALGERIAN", Font.PLAIN, 25));
        exitBtn.setBounds(600, 640, 100, 30);
        exitBtn.setForeground (Color.WHITE);
        exitBtn.setBackground(new Color(176, 15, 15));
        exitBtn.addActionListener(this);
        add(exitBtn);

        setVisible (true);
    }

    public static void sortDates (List<String> dateList) {
        dateList.sort (new Comparator<String> () {
            DateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");

            @Override
            public int compare (String date_1, String date_2) {
                try {
                    return dateFormat.parse (date_1).compareTo (dateFormat.parse (date_2));
                } catch (ParseException e) {
                    e.printStackTrace ();
                }
                return 0;
            }
        });
    }
    @Override
    public void actionPerformed (ActionEvent e) {
        if (e.getSource () == back1Btn) {
            this.setVisible (false);
            new GUI_Main ();
        } else if (e.getSource () == exitBtn) {
            System.exit (0);
        }
    }
}

