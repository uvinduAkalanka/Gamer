package com.oopCW;
//#################################### finalized with commenting also####################
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class GUI_RandomRaceAndPosition extends JFrame implements ActionListener {
    JButton back1Btn,exitBtn;
    private static int iterations = 0;
    private static boolean checkFirstPosition = false;
    private static boolean isItaratedPosition1 = false;
    private static String randomDate ;
    GUI_RandomRaceAndPosition () {
        setBounds(100, 40, 1200, 800);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        getContentPane ().setBackground (new Color (91, 83, 83));
        setTitle ("THE RANDOMLY GENERATED RACE AND POSITION");
        setResizable (false);

        setLayout(null);

        JLabel l1 = new JLabel ("       THE RANDOMLY GENERATED RACE AND POSITION DETAILS");
        l1.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 5));
        l1.setFont (new Font ("Andale Mono", Font.PLAIN, 25));
        l1.setForeground (new Color (208, 228, 248));
        l1.setBounds(175, 20, 850, 45);
        add(l1);
        Random random = new Random ();

        randomDate=Formula1ChampionshipManager.dateGenerator ();//random date creation for the race

        int randomNumber ;
        Set<Integer> positionSet = new HashSet<> ();//hasSet for get the numbers without duplication

        while (positionSet.size () < Formula1ChampionshipManager.driverStatistics.size ()) {//set the hasSet size to be equal to the drivers of the driverStatistics array
            randomNumber = random.nextInt (Formula1ChampionshipManager.driverStatistics.size ()) + 1;//getting numbers starting from 1 to the array size
            positionSet.add (randomNumber);
        }

        List<Integer> shufflingList = new ArrayList<> (positionSet);//get the has set's value to a list to shuffle
        List<Integer> shuffleNew = new ArrayList<> ();

        Collections.shuffle (shufflingList);//shuffle the list
        Collections.shuffle (Formula1ChampionshipManager.driverStatistics);//shuffle the driver object array list to get random oder of drivers

//        System.out.println ("name of the players line 54");
//        Formula1ChampionshipManager.driverStatistics.forEach (d->{
//            System.out.println (d.getDriverName ());
//        });

        int probabilityListener = random.nextInt (100) + 1;//creating random numbers between 1 and 100 to get the probability of winning percentage
//        align the racers according to the wining percentage  from bellow code
        int x = 0;
        if (probabilityListener <= 40) {
            x = 1;
        } else if (probabilityListener <= 70) {
            x = 2;
        }else if (probabilityListener <= 80) {
            x = 3;
        }else if (probabilityListener <= 90) {
            x = 4;
        } else if (probabilityListener <= 92) {
            x = 5;
        }else if (probabilityListener <= 94) {
            x = 6;
        }else if (probabilityListener <= 96) {
            x = 7;
        }else if (probabilityListener <= 98) {
            x = 8;
        }else if (probabilityListener <= 100) {
            x = 9;
        }

        AtomicInteger atomic_i = new AtomicInteger ();
        Formula1ChampionshipManager.driverStatistics.forEach (position->{
            boolean isFirstPlaceAssign = false;
            iterations++;

//            this if block searches weather position one applied or not as probability checking when racers count less than 10
//            if not assign then only execute the if part while main forEach loop is working
            if (!checkFirstPosition) {
                if (iterations == 1 && (probabilityListener <= 40)) {//if randomly generated starting first position in the probability of 1-40 he gets first place
//                    System.out.println ("1111-11 line88");
                    Formula1ChampionshipManager.pointOfTheRace = 25;
                    ((Formula1Driver) position).setOwnedPoints (((Formula1Driver) position).getOwnedPoints () + Formula1ChampionshipManager.pointOfTheRace);
                    ((Formula1Driver) position).setFirstPlaces (((Formula1Driver) position).getFirstPlaces () + 1);
                    ((Formula1Driver) position).setParticipatedRaces (((Formula1Driver) position).getParticipatedRaces () + 1);
                    Formula1Driver formula1Driver = new Formula1Driver (position.getDriverName (), position.getDriverTeam (), position.getDriverLocation (), 0, 0, 0, 0, 0, randomDate, 1);
                    Formula1ChampionshipManager.raceStatistics.add (formula1Driver);

                    checkFirstPosition = true;
                    isFirstPlaceAssign = true;
                    shuffleNew.add (1);
                    return;
                } else if (iterations == 2 && (probabilityListener <= 70)) {//if randomly generated starting second position in the probability of 1-40 he gets first place
                    Formula1ChampionshipManager.pointOfTheRace = 25;
                    ((Formula1Driver) position).setOwnedPoints (((Formula1Driver) position).getOwnedPoints () + Formula1ChampionshipManager.pointOfTheRace);
                    ((Formula1Driver) position).setFirstPlaces (((Formula1Driver) position).getFirstPlaces () + 1);
                    ((Formula1Driver) position).setParticipatedRaces (((Formula1Driver) position).getParticipatedRaces () + 1);
                    Formula1Driver formula1Driver = new Formula1Driver (position.getDriverName (), position.getDriverTeam (), position.getDriverLocation (), 0, 0, 0, 0, 0, randomDate, 1);
                    Formula1ChampionshipManager.raceStatistics.add (formula1Driver);

                    checkFirstPosition = true;
                    isFirstPlaceAssign = true;
                    shuffleNew.add (1);
                    return;
                } else if (iterations == 3 && (probabilityListener <= 80)) {
                    Formula1ChampionshipManager.pointOfTheRace = 25;
                    ((Formula1Driver) position).setOwnedPoints (((Formula1Driver) position).getOwnedPoints () + Formula1ChampionshipManager.pointOfTheRace);
                    ((Formula1Driver) position).setFirstPlaces (((Formula1Driver) position).getFirstPlaces () + 1);
                    ((Formula1Driver) position).setParticipatedRaces (((Formula1Driver) position).getParticipatedRaces () + 1);
                    Formula1Driver formula1Driver = new Formula1Driver (position.getDriverName (), position.getDriverTeam (), position.getDriverLocation (), 0, 0, 0, 0, 0, randomDate, 1);
                    Formula1ChampionshipManager.raceStatistics.add (formula1Driver);

                    checkFirstPosition = true;
                    shuffleNew.add (1);
                    return;
                } else if (iterations == 4 && (probabilityListener <= 90)) {
                    Formula1ChampionshipManager.pointOfTheRace = 25;
                    ((Formula1Driver) position).setOwnedPoints (((Formula1Driver) position).getOwnedPoints () + Formula1ChampionshipManager.pointOfTheRace);
                    ((Formula1Driver) position).setFirstPlaces (((Formula1Driver) position).getFirstPlaces () + 1);
                    ((Formula1Driver) position).setParticipatedRaces (((Formula1Driver) position).getParticipatedRaces () + 1);
                    Formula1Driver formula1Driver = new Formula1Driver (position.getDriverName (), position.getDriverTeam (), position.getDriverLocation (), 0, 0, 0, 0, 0, randomDate, 1);
                    Formula1ChampionshipManager.raceStatistics.add (formula1Driver);

                    checkFirstPosition = true;
                    isFirstPlaceAssign = true;
                    shuffleNew.add (1);
                    return;
                } else if (iterations == 5 && (probabilityListener <= 92)) {
                    Formula1ChampionshipManager.pointOfTheRace = 25;
                    ((Formula1Driver) position).setOwnedPoints (((Formula1Driver) position).getOwnedPoints () + Formula1ChampionshipManager.pointOfTheRace);
                    ((Formula1Driver) position).setFirstPlaces (((Formula1Driver) position).getFirstPlaces () + 1);
                    ((Formula1Driver) position).setParticipatedRaces (((Formula1Driver) position).getParticipatedRaces () + 1);
                    Formula1Driver formula1Driver = new Formula1Driver (position.getDriverName (), position.getDriverTeam (), position.getDriverLocation (), 0, 0, 0, 0, 0, randomDate, 1);
                    Formula1ChampionshipManager.raceStatistics.add (formula1Driver);
                    checkFirstPosition = true;
                    shuffleNew.add (1);
                    return;
                } else if (iterations == 6 && (probabilityListener <= 94)) {
                    Formula1ChampionshipManager.pointOfTheRace = 25;
                    ((Formula1Driver) position).setOwnedPoints (((Formula1Driver) position).getOwnedPoints () + Formula1ChampionshipManager.pointOfTheRace);
                    ((Formula1Driver) position).setFirstPlaces (((Formula1Driver) position).getFirstPlaces () + 1);
                    ((Formula1Driver) position).setParticipatedRaces (((Formula1Driver) position).getParticipatedRaces () + 1);
                    Formula1Driver formula1Driver = new Formula1Driver (position.getDriverName (), position.getDriverTeam (), position.getDriverLocation (), 0, 0, 0, 0, 0, randomDate, 1);
                    Formula1ChampionshipManager.raceStatistics.add (formula1Driver);
                    checkFirstPosition = true;
                    shuffleNew.add (1);
                    return;
                } else if (iterations == 7 && (probabilityListener <= 96)) {
                    Formula1ChampionshipManager.pointOfTheRace = 25;
                    ((Formula1Driver) position).setOwnedPoints (((Formula1Driver) position).getOwnedPoints () + Formula1ChampionshipManager.pointOfTheRace);
                    ((Formula1Driver) position).setFirstPlaces (((Formula1Driver) position).getFirstPlaces () + 1);
                    ((Formula1Driver) position).setParticipatedRaces (((Formula1Driver) position).getParticipatedRaces () + 1);
                    Formula1Driver formula1Driver = new Formula1Driver (position.getDriverName (), position.getDriverTeam (), position.getDriverLocation (), 0, 0, 0, 0, 0, randomDate, 1);
                    Formula1ChampionshipManager.raceStatistics.add (formula1Driver);
                    checkFirstPosition = true;
                    shuffleNew.add (1);
                    return;
                } else if (iterations == 8 && (probabilityListener <= 98)) {
                    Formula1ChampionshipManager.pointOfTheRace = 25;
                    ((Formula1Driver) position).setOwnedPoints (((Formula1Driver) position).getOwnedPoints () + Formula1ChampionshipManager.pointOfTheRace);
                    ((Formula1Driver) position).setFirstPlaces (((Formula1Driver) position).getFirstPlaces () + 1);
                    ((Formula1Driver) position).setParticipatedRaces (((Formula1Driver) position).getParticipatedRaces () + 1);
                    Formula1Driver formula1Driver = new Formula1Driver (position.getDriverName (), position.getDriverTeam (), position.getDriverLocation (), 0, 0, 0, 0, 0, randomDate, 1);
                    Formula1ChampionshipManager.raceStatistics.add (formula1Driver);
                    checkFirstPosition = true;
                    shuffleNew.add (1);
                    return;
                } else if (iterations == 9 && (probabilityListener <= 100)) {
                    Formula1ChampionshipManager.pointOfTheRace = 25;
                    ((Formula1Driver) position).setOwnedPoints (((Formula1Driver) position).getOwnedPoints () + Formula1ChampionshipManager.pointOfTheRace);
                    ((Formula1Driver) position).setFirstPlaces (((Formula1Driver) position).getFirstPlaces () + 1);
                    ((Formula1Driver) position).setParticipatedRaces (((Formula1Driver) position).getParticipatedRaces () + 1);
                    Formula1Driver formula1Driver = new Formula1Driver (position.getDriverName (), position.getDriverTeam (), position.getDriverLocation (), 0, 0, 0, 0, 0, randomDate, 1);
                    Formula1ChampionshipManager.raceStatistics.add (formula1Driver);
                    checkFirstPosition = true;
                    shuffleNew.add (1);
                    return;
                }
            }

//            System.out.println ("this is the 233 list print");
//            shufflingList.forEach (System.out::println);
//            System.out.println ("atomic_i==== "+atomic_i.intValue ()+" lineeeeeeeeeeee 235");
//            System.out.println ("print shufflingList line 236");
//            shufflingList.forEach (System.out::println);
//            System.out.println ();
//
//            System.out.println (atomic_i.intValue ()+"   this is atomic_i.intValue ()   ");
//            System.out.println (shufflingList.size ()-1);
////            System.out.println (shufflingList.get (atomic_i.intValue ()));
//            System.out.println ("above shuffleing list line 269");

            if ( atomic_i. intValue () <shufflingList.size ()-1&& shufflingList.get (atomic_i.intValue ()).equals (1)  && isItaratedPosition1==false ) {
//                System.out.println ("yes im running  273");
                atomic_i.getAndIncrement ();
                isItaratedPosition1 = true;
            }

//            this switch is for adding position for drivers from 2 to driver count
            try {
                switch (shufflingList.get (atomic_i.intValue ())) {
                    case 2 -> {
                        Formula1ChampionshipManager.pointOfTheRace = 18;
                        ((Formula1Driver) position).setOwnedPoints (((Formula1Driver) position).getOwnedPoints () + 18);
                        ((Formula1Driver) position).setSecondPlaces (((Formula1Driver) position).getSecondPlaces () + 1);
                        ((Formula1Driver) position).setParticipatedRaces (((Formula1Driver) position).getParticipatedRaces () + 1);
                        Formula1Driver formula1Driver = new Formula1Driver (position.getDriverName (), position.getDriverTeam (), position.getDriverLocation (), 0, 0, 0, 0, 0, randomDate, 2);
                        Formula1ChampionshipManager.raceStatistics.add (formula1Driver);
                        shuffleNew.add (2);
                    }
                    case 3 -> {
//                        System.out.println ("case  line 257");
                        Formula1ChampionshipManager.pointOfTheRace = 15;
                        ((Formula1Driver) position).setOwnedPoints (((Formula1Driver) position).getOwnedPoints () + 15);
                        ((Formula1Driver) position).setThirdPlaces (((Formula1Driver) position).getThirdPlaces () + 1);
                        ((Formula1Driver) position).setParticipatedRaces (((Formula1Driver) position).getParticipatedRaces () + 1);
                        Formula1Driver formula1Driver = new Formula1Driver (position.getDriverName (), position.getDriverTeam (), position.getDriverLocation (), 0, 0, 0, 0, 0, randomDate, 3);
                        Formula1ChampionshipManager.raceStatistics.add (formula1Driver);
                        shuffleNew.add (3);
                    }
                    case 4 -> {
//                        System.out.println ("case 4 line 267");
                        Formula1ChampionshipManager.pointOfTheRace = 12;
                        ((Formula1Driver) position).setOwnedPoints (((Formula1Driver) position).getOwnedPoints () + 12);
                        ((Formula1Driver) position).setParticipatedRaces (((Formula1Driver) position).getParticipatedRaces () + 1);
                        Formula1Driver formula1Driver = new Formula1Driver (position.getDriverName (), position.getDriverTeam (), position.getDriverLocation (), 0, 0, 0, 0, 0, randomDate, 4);
                        Formula1ChampionshipManager.raceStatistics.add (formula1Driver);
                        shuffleNew.add (4);
                    }
                    case 5 -> {
//                        System.out.println ("case 2 line 276");
                        Formula1ChampionshipManager.pointOfTheRace = 10;
                        ((Formula1Driver) position).setOwnedPoints (((Formula1Driver) position).getOwnedPoints () + 10);
                        ((Formula1Driver) position).setParticipatedRaces (((Formula1Driver) position).getParticipatedRaces () + 1);
                        Formula1Driver formula1Driver = new Formula1Driver (position.getDriverName (), position.getDriverTeam (), position.getDriverLocation (), 0, 0, 0, 0, 0, randomDate, 5);
                        Formula1ChampionshipManager.raceStatistics.add (formula1Driver);
                        shuffleNew.add (5);
                    }
                    case 6 -> {
                        Formula1ChampionshipManager.pointOfTheRace = 8;
                        ((Formula1Driver) position).setOwnedPoints (((Formula1Driver) position).getOwnedPoints () + 8);
                        ((Formula1Driver) position).setParticipatedRaces (((Formula1Driver) position).getParticipatedRaces () + 1);
                        Formula1Driver formula1Driver = new Formula1Driver (position.getDriverName (), position.getDriverTeam (), position.getDriverLocation (), 0, 0, 0, 0, 0, randomDate, 6);
                        Formula1ChampionshipManager.raceStatistics.add (formula1Driver);
                        shuffleNew.add (6);
                    }
                    case 7 -> {
                        Formula1ChampionshipManager.pointOfTheRace = 6;
                        ((Formula1Driver) position).setOwnedPoints (((Formula1Driver) position).getOwnedPoints () + 6);
                        ((Formula1Driver) position).setParticipatedRaces (((Formula1Driver) position).getParticipatedRaces () + 1);
                        Formula1Driver formula1Driver = new Formula1Driver (position.getDriverName (), position.getDriverTeam (), position.getDriverLocation (), 0, 0, 0, 0, 0, randomDate, 7);
                        Formula1ChampionshipManager.raceStatistics.add (formula1Driver);
                        shuffleNew.add (7);
                    }
                    case 8 -> {
                        Formula1ChampionshipManager.pointOfTheRace = 4;
                        ((Formula1Driver) position).setOwnedPoints (((Formula1Driver) position).getOwnedPoints () + 4);
                        ((Formula1Driver) position).setParticipatedRaces (((Formula1Driver) position).getParticipatedRaces () + 1);
                        Formula1Driver formula1Driver = new Formula1Driver (position.getDriverName (), position.getDriverTeam (), position.getDriverLocation (), 0, 0, 0, 0, 0, randomDate, 8);
                        Formula1ChampionshipManager.raceStatistics.add (formula1Driver);
                        shuffleNew.add (8);
                    }
                    case 9 -> {
                        Formula1ChampionshipManager.pointOfTheRace = 2;
                        ((Formula1Driver) position).setOwnedPoints (((Formula1Driver) position).getOwnedPoints () + 2);
                        ((Formula1Driver) position).setParticipatedRaces (((Formula1Driver) position).getParticipatedRaces () + 1);
                        Formula1Driver formula1Driver = new Formula1Driver (position.getDriverName (), position.getDriverTeam (), position.getDriverLocation (), 0, 0, 0, 0, 0, randomDate, 9);
                        Formula1ChampionshipManager.raceStatistics.add (formula1Driver);
                        shuffleNew.add (9);
                    }
                    case 10 -> {
                        Formula1ChampionshipManager.pointOfTheRace = 1;
                        ((Formula1Driver) position).setOwnedPoints (((Formula1Driver) position).getOwnedPoints () + 1);
                        ((Formula1Driver) position).setParticipatedRaces (((Formula1Driver) position).getParticipatedRaces () + 1);
                        Formula1Driver formula1Driver = new Formula1Driver (position.getDriverName (), position.getDriverTeam (), position.getDriverLocation (), 0, 0, 0, 0, 0, randomDate, 10);
                        Formula1ChampionshipManager.raceStatistics.add (formula1Driver);
                        shuffleNew.add (10);
                    }
                    default -> {
                        if (shufflingList.get (atomic_i.intValue ()) > 10) {
                            Formula1ChampionshipManager.pointOfTheRace = 0;
                            ((Formula1Driver) position).setParticipatedRaces (((Formula1Driver) position).getParticipatedRaces () + 1);
                        }
                    }
                }
                atomic_i.getAndIncrement ();
            } catch (Exception ignored) {}
        });
//        System.out.println ("suffle new list 332");
//        shuffleNew.forEach (System.out::println);

//        this is for when racer count is less than 10 then there is no position allocation  done by probability code block from her is going to be added
        if (!shuffleNew.contains (1)) {
            shuffleNew.add (1);
            ((Formula1Driver) Formula1ChampionshipManager.driverStatistics.get (Formula1ChampionshipManager.driverStatistics.size () - 1)).
                    setParticipatedRaces (((Formula1Driver) Formula1ChampionshipManager.driverStatistics.get (Formula1ChampionshipManager.driverStatistics.size () - 1)).getParticipatedRaces () +1);
            ((Formula1Driver) Formula1ChampionshipManager.driverStatistics.get (Formula1ChampionshipManager.driverStatistics.size () - 1)).
                    setOwnedPoints (((Formula1Driver) Formula1ChampionshipManager.driverStatistics.get (Formula1ChampionshipManager.driverStatistics.size () - 1)).getOwnedPoints () + 25);
             ((Formula1Driver) Formula1ChampionshipManager.driverStatistics.get (Formula1ChampionshipManager.driverStatistics.size () - 1)).
                    setFirstPlaces (((Formula1Driver) Formula1ChampionshipManager.driverStatistics.get (Formula1ChampionshipManager.driverStatistics.size () - 1)).getFirstPlaces () + 1);

            Formula1Driver formula1Driver = new Formula1Driver (Formula1ChampionshipManager.driverStatistics.get (Formula1ChampionshipManager.driverStatistics.size () - 1).getDriverName (),
                    Formula1ChampionshipManager.driverStatistics.get (Formula1ChampionshipManager.driverStatistics.size () - 1).getDriverTeam (),
                    Formula1ChampionshipManager.driverStatistics.get (Formula1ChampionshipManager.driverStatistics.size () - 1).getDriverLocation ()
                    , 0, 0, 0, 0, 0, randomDate, 1);

            Formula1ChampionshipManager.raceStatistics.add (formula1Driver);
            shuffleNew.add (1);
        }

        JTable table = new JTable ();
        Object[] columns = {"DRIVER NAME", "RANDOM PLACE"};
        table.setBounds (200,100,200,600);
        DefaultTableModel model = new DefaultTableModel ();

        model.setColumnIdentifiers (columns);
        table.setModel (model);

        table.getTableHeader ().setForeground(new Color(255, 255, 255));
        table.getTableHeader ().setBackground (new Color(40, 205, 255));
        table.getTableHeader ().setFont(new Font("Andale Mono", Font.PLAIN,18));
        table.setRowHeight (30);
        table.setRowMargin (10);//444444444444444
        table.setIntercellSpacing(new Dimension(300,0));

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
            row[0] = driverName.getDriverName ();

            row[1] = shuffleNew.get (ii.intValue ());
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
        back1Btn.setBounds(450, 640, 100, 30);
        back1Btn.setBackground(new Color(30, 144, 255));
        back1Btn.setForeground(Color.WHITE);
        back1Btn.setFont (new Font ("ALGERIAN", Font.PLAIN, 20));

        back1Btn.addActionListener(this);
        add(back1Btn);

        exitBtn= new JButton("EXIT");
        exitBtn.setBounds(580, 640, 100, 30);
        exitBtn.setForeground (Color.WHITE);
        exitBtn.setBackground(new Color(176, 15, 15));
        exitBtn.setFont (new Font ("ALGERIAN", Font.PLAIN, 20));

        exitBtn.addActionListener(this);
        add(exitBtn);

        checkFirstPosition = false;
        iterations = 0;

        Main.formula1ChampionshipManager.saveData ();
        setVisible (true);
    }

    @Override
    public void actionPerformed (ActionEvent e) {
        if (e.getSource () == back1Btn) {
            this.setVisible (false);
            checkFirstPosition = false;
            isItaratedPosition1 = false;
            iterations = 0;
            new GUI_Main ();
        } else if (e.getSource () == exitBtn) {
            System.exit (0);
        }
    }
}
