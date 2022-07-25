package com.oopCW;

//################################ done with commenting also#######################

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class GUI_RandomRace extends JFrame implements ActionListener {
    private String randomDate;
    JButton back1Btn,exitBtn;
    public GUI_RandomRace () {

        setBounds(100, 40, 1200, 800);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        getContentPane ().setBackground (new Color (91, 83, 83));
        setTitle ("RANDOM RACE");
        setLayout(null);

        JLabel l1 = new JLabel ("       THE RANDOMLY GENERATED RACE DETAILS");
        l1.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 5));
        l1.setFont (new Font ("Andale Mono", Font.PLAIN, 25));
        l1.setForeground (new Color (208, 228, 248));
        l1.setBounds(250, 20, 700, 40);
        add(l1);

        randomDate = Formula1ChampionshipManager.dateGenerator ();
        Random random = new Random ();

        int randomNumber ;
        Set<Integer> positionSet = new HashSet<> ();//hasSet for get the numbers without duplication

        while (positionSet.size () < Formula1ChampionshipManager.driverStatistics.size ()) {//set the hasSet size to be equal to the drivers of the driverStatistics array
            randomNumber = random.nextInt (Formula1ChampionshipManager.driverStatistics.size ()) + 1;//getting numbers starting from 1 to the array size
            positionSet.add (randomNumber);
        }

        List<Integer> shufflingList = new ArrayList<> (positionSet);//HasSET not gives the random oder of the number so get that hasSET to array list

        Collections.shuffle (shufflingList);//then the arraylist shuffle to get random places

//        System.out.println ("shuffle list");

//        System.out.println ("name of the players");
//        Formula1ChampionshipManager.driverStatistics.forEach (d->{
//            System.out.println (d.getDriverName ());
//        });

        AtomicInteger i = new AtomicInteger ();
        for (Driver position : Formula1ChampionshipManager.driverStatistics) {

//            update the raceStatic arraylist to get the dame of the driver and won position with the date
            Formula1Driver formula1Driver = new Formula1Driver (position.getDriverName (), position.getDriverTeam (),
                    position.getDriverLocation (), 0, 0, 0, 0, 0,
                    randomDate, shufflingList.get (i.intValue ()));
            Formula1ChampionshipManager.raceStatistics.add (formula1Driver);

//            this switch is for add other details to the main object array(driverStatistics array) of all the details that are contained
            switch (shufflingList.get (i.intValue ())) {
                case 1 -> {
                    Formula1ChampionshipManager.pointOfTheRace = 25;
                    ((Formula1Driver) position).setOwnedPoints (((Formula1Driver) position).getOwnedPoints () + Formula1ChampionshipManager.pointOfTheRace);
                    ((Formula1Driver) position).setFirstPlaces (((Formula1Driver) position).getFirstPlaces () + 1);
                    ((Formula1Driver) position).setParticipatedRaces (((Formula1Driver) position).getParticipatedRaces () + 1);
                }
                case 2 -> {
                    Formula1ChampionshipManager.pointOfTheRace = 18;
                    ((Formula1Driver) position).setOwnedPoints (((Formula1Driver) position).getOwnedPoints () + Formula1ChampionshipManager.pointOfTheRace);
                    ((Formula1Driver) position).setSecondPlaces (((Formula1Driver) position).getSecondPlaces () + 1);
                    ((Formula1Driver) position).setParticipatedRaces (((Formula1Driver) position).getParticipatedRaces () + 1);
                }
                case 3 -> {
                    Formula1ChampionshipManager.pointOfTheRace = 15;
                    ((Formula1Driver) position).setOwnedPoints (((Formula1Driver) position).getOwnedPoints () + Formula1ChampionshipManager.pointOfTheRace);
                    ((Formula1Driver) position).setThirdPlaces (((Formula1Driver) position).getThirdPlaces () + 1);
                    ((Formula1Driver) position).setParticipatedRaces (((Formula1Driver) position).getParticipatedRaces () + 1);
                }
                case 4 -> {
                    Formula1ChampionshipManager.pointOfTheRace = 12;
                    ((Formula1Driver) position).setOwnedPoints (((Formula1Driver) position).getOwnedPoints () + Formula1ChampionshipManager.pointOfTheRace);
                    ((Formula1Driver) position).setParticipatedRaces (((Formula1Driver) position).getParticipatedRaces () + 1);
                }
                case 5 -> {
                    Formula1ChampionshipManager.pointOfTheRace = 10;
                    ((Formula1Driver) position).setOwnedPoints (((Formula1Driver) position).getOwnedPoints () + Formula1ChampionshipManager.pointOfTheRace);
                    ((Formula1Driver) position).setParticipatedRaces (((Formula1Driver) position).getParticipatedRaces () + 1);
                }
                case 6 -> {
                    Formula1ChampionshipManager.pointOfTheRace = 8;
                    ((Formula1Driver) position).setOwnedPoints (((Formula1Driver) position).getOwnedPoints () + Formula1ChampionshipManager.pointOfTheRace);
                    ((Formula1Driver) position).setParticipatedRaces (((Formula1Driver) position).getParticipatedRaces () + 1);
                }
                case 7 -> {
                    Formula1ChampionshipManager.pointOfTheRace = 6;
                    ((Formula1Driver) position).setOwnedPoints (((Formula1Driver) position).getOwnedPoints () + Formula1ChampionshipManager.pointOfTheRace);
                    ((Formula1Driver) position).setParticipatedRaces (((Formula1Driver) position).getParticipatedRaces () + 1);
                }
                case 8 -> {
                    Formula1ChampionshipManager.pointOfTheRace = 4;
                    ((Formula1Driver) position).setOwnedPoints (((Formula1Driver) position).getOwnedPoints () + Formula1ChampionshipManager.pointOfTheRace);
                    ((Formula1Driver) position).setParticipatedRaces (((Formula1Driver) position).getParticipatedRaces () + 1);
                }
                case 9 -> {
                    Formula1ChampionshipManager.pointOfTheRace = 2;
                    ((Formula1Driver) position).setOwnedPoints (((Formula1Driver) position).getOwnedPoints () + Formula1ChampionshipManager.pointOfTheRace);
                    ((Formula1Driver) position).setParticipatedRaces (((Formula1Driver) position).getParticipatedRaces () + 1);
                }
                case 10 -> {
                    Formula1ChampionshipManager.pointOfTheRace = 1;
                    ((Formula1Driver) position).setOwnedPoints (((Formula1Driver) position).getOwnedPoints () + Formula1ChampionshipManager.pointOfTheRace);
                    ((Formula1Driver) position).setParticipatedRaces (((Formula1Driver) position).getParticipatedRaces () + 1);
                }
                default -> {
                    Formula1ChampionshipManager.pointOfTheRace = 0;
                    ((Formula1Driver) position).setParticipatedRaces (((Formula1Driver) position).getParticipatedRaces () + 1);
                }
            }
            i.getAndIncrement ();
        }

        JTable table = new JTable ();
        Object[] columns = {"DRIVER NAME", "RANDOM PLACE"};
        table.getTableHeader ().setForeground(new Color(255, 255, 255));
        table.getTableHeader ().setBackground (new Color(40, 205, 255));
        table.getTableHeader ().setFont(new Font("Andale Mono", Font.PLAIN,18));
        table.setRowHeight (30);
        table.setRowMargin (10);//444444444444444
        table.setIntercellSpacing(new Dimension(300,0));
        table.setBounds (200,100,350,600);

        DefaultTableModel model = new DefaultTableModel ();

        model.setColumnIdentifiers (columns);
        table.setModel (model);
        table.setBackground (Color.white);
        table.setForeground (Color.black);
        table.setSelectionBackground (Color.red);
        table.setGridColor (Color.red);
        table.setSelectionForeground (Color.white);
        table.setFont (new Font ("Tahoma", Font.PLAIN, 17));
        table.setRowHeight (30);
        table.setAutoCreateColumnsFromModel (true);

        JScrollPane pane = new JScrollPane (table);
        pane.setForeground (Color.RED);
        pane.setBackground (Color.WHITE);
        pane.setBounds (200, 100, 800, 450);

        AtomicInteger ii = new AtomicInteger ();

        Object[] row = new Object[2];
        Formula1ChampionshipManager.driverStatistics.forEach (driverName->{
//            adding randomly generated race details to the table to display
            row[0] = driverName.getDriverName ();

            row[1] = shufflingList.get (ii.intValue ());
            model.addRow (row);
            ii.getAndIncrement ();
        });
        add (pane);

        JLabel l2 = new JLabel("THE RANDOMLY GENERATED RACE DETAILS HAVE BEEN ADDED AUTOMATICALLY TO THE SYSTEM");
        l2.setFont (new Font ("Andale Mono", Font.PLAIN, 20));
        l2.setForeground (new Color (181, 255, 0));
        l2.setBounds(100, 580, 1000, 30);
        add(l2);

        back1Btn = new JButton("BACK");
        back1Btn.setFont (new Font ("ALGERIAN", Font.PLAIN, 20));
        back1Btn.setBounds(450, 640, 100, 30);
        back1Btn.setBackground(new Color(30, 144, 255));
        back1Btn.setForeground(Color.WHITE);
        back1Btn.addActionListener(this);
        add(back1Btn);

        exitBtn= new JButton("EXIT");
        exitBtn.setFont (new Font ("ALGERIAN", Font.PLAIN, 20));
        exitBtn.setBounds(580, 640, 100, 30);
        exitBtn.setForeground (Color.WHITE);
        exitBtn.setBackground(new Color(176, 15, 15));
        exitBtn.addActionListener(this);
        add(exitBtn);

        setVisible (true);
        Main.formula1ChampionshipManager.saveData ();
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
