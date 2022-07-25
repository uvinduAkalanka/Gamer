package com.oopCW;
//############################### finalized with commenting also##############################
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

public class GUI_DriversStats extends JFrame implements ActionListener {
    JButton ascendingBtn,firstPlacesBtn,backBtn,exitBtn;
    static String displayTitle1="DESCENDING  oder of points";

    public GUI_DriversStats () {

        setBounds (100, 40, 1320, 800);
        getContentPane ().setBackground (new Color (91, 83, 83));
        setTitle ("ALL DRIVERS STATISTIC");
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setResizable (false);

        setLayout (null);

        JTable table = new JTable ();
//        creating columns of the table
        Object[] columns = {"Driver name", "Driver team", "Driver Location", "First Places", " Second places", " Third paces", "Participated races", "Total points"};
        table.getTableHeader ().setForeground(new Color(255, 255, 255));
        table.getTableHeader ().setBackground (new Color(40, 205, 255));
        table.getTableHeader ().setFont(new Font("Andale Mono", Font.PLAIN,18));
        table.setBounds (0,150,600,600);
        table.setRowHeight (30);
        table.setRowMargin (10);//444444444444444
        table.setIntercellSpacing(new Dimension(90,0));

        DefaultTableModel model = new DefaultTableModel ();

        JLabel statsLabel = new JLabel ("          REGISTERED ALL DRIVERS STATISTICS ");
        statsLabel.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 5));
        statsLabel.setFont (new Font ("Andale Mono", Font.PLAIN,25));
        statsLabel.setForeground (new Color (208, 228, 248));
        statsLabel.setBackground (new Color (100, 200, 254));
        statsLabel.setBounds (290, 40, 650, 45);
        add (statsLabel);

        JLabel descendingLabel = new JLabel ();
        descendingLabel.setText ("All drivers statistics in "+ displayTitle1);
        descendingLabel.setFont (new Font ("Andale Mono", Font.PLAIN,25));
        descendingLabel.setForeground (new Color (208, 228, 248));
        descendingLabel.setBackground (new Color (100, 200, 254));
        descendingLabel.setBounds (290, 100, 700, 45);
        add (descendingLabel);

        model.setColumnIdentifiers (columns);
        table.setModel (model);
        table.setBackground (Color.white);
        table.setForeground (Color.black);
        table.setSelectionBackground (Color.red);
        table.setGridColor (Color.red);
        table.setSelectionForeground (Color.white);
        table.setFont (new Font ("Tahoma", Font.PLAIN, 17));
        table.setRowHeight (30);
        table.getColumn("Driver name").setPreferredWidth(150);
        table.getColumn("Driver team").setPreferredWidth(150);
        table.getColumn("Driver Location").setPreferredWidth(150);
        table.getColumn("Participated races").setPreferredWidth(100);

        table.setAutoCreateColumnsFromModel (true);

        JScrollPane pane = new JScrollPane (table);
        pane.setForeground (Color.RED);
        pane.setBackground (Color.WHITE);
        pane.setBounds (10, 150, 1280, 450);

        AtomicInteger i = new AtomicInteger ();

        Object[] row = new Object[8];
//        System.out.println ("lineeeeeeeeee82"+Formula1Driver.disOrAscending);

//        if block for choose ascending oder or descending oder as button checked
        if (!Formula1Driver.disOrAscending) {
//            System.out.println ("disOrAscending = "+Formula1Driver.disOrAscending);
//
            Formula1Driver.positionChanger1 = 1;//those positionChangers for return the values for descending oder
            Formula1Driver.positionChanger2 = -1;
        } else {
//            System.out.println ("else parttttttt 89");
//            those positionChangers for return the values for ascending oder
            Formula1Driver.positionChanger1 = -1;
            Formula1Driver.positionChanger2 = 1;
        }
//        System.out.println ("lineeeeeeeeeeeee 95");
        Formula1ChampionshipManager.driverStatistics.sort (Collections.reverseOrder ());
        Formula1ChampionshipManager.driverStatistics.forEach (driver -> {

            row[0] = driver.getDriverName ().toUpperCase(Locale.ROOT);
            row[1] = driver.getDriverTeam ().toUpperCase(Locale.ROOT);
            row[2] = driver.getDriverLocation ().toUpperCase(Locale.ROOT);
            row[3] = ((Formula1Driver) driver).getFirstPlaces ();
            row[4] = ((Formula1Driver) driver).getSecondPlaces ();
            row[5] = ((Formula1Driver) driver).getThirdPlaces ();
            row[6] = ((Formula1Driver) driver).getParticipatedRaces ();
            row[7] = ((Formula1Driver) driver).getOwnedPoints ();

            model.addRow (row);
        });
        add (pane);

        ascendingBtn = new JButton("Sort Table in ascending oder of points");
        ascendingBtn.setBounds (25, 670, 400, 45);
        ascendingBtn.setFont (new Font ("ALGERIAN", Font.PLAIN, 17));
        ascendingBtn.setBackground(new Color(30, 144, 255));
        ascendingBtn.setForeground(Color.WHITE);
        ascendingBtn.addActionListener (this);
        add (ascendingBtn);

        firstPlacesBtn = new JButton("Sort table in descending oder of 1'st places");
        firstPlacesBtn.setBounds (445, 670, 418, 45);
        firstPlacesBtn.setFont (new Font ("ALGERIAN", Font.PLAIN, 16));
        firstPlacesBtn.setBackground(new Color(30, 144, 255));
        firstPlacesBtn.setForeground(Color.WHITE);
        firstPlacesBtn.addActionListener (this);
        add (firstPlacesBtn);

        backBtn = new JButton("BACK ");
        backBtn.setFont (new Font ("ALGERIAN", Font.PLAIN, 20));

        backBtn.setBounds(925, 670, 100, 45);
        backBtn.setBackground(new Color(0, 255, 215));

        backBtn.setForeground(Color.WHITE);
        backBtn.addActionListener (this);
        add (backBtn);

        exitBtn = new JButton("EXIT ");
        exitBtn.setBounds (1045, 670, 100, 45);
        exitBtn.setFont (new Font ("ALGERIAN", Font.PLAIN, 20));
        exitBtn.setBackground(new Color(176, 15, 15));
        exitBtn.setForeground(Color.WHITE);
        exitBtn.addActionListener (this);
        add (exitBtn);

        setVisible (true);
    }

    @Override
    public void actionPerformed (ActionEvent e) {
        if (e.getSource () == ascendingBtn) {//if ascending button pressed reload the current jFrame with the requirement
            Formula1Driver.disOrAscending = true;
            displayTitle1 = "ASCENDING  oder of points";
            Formula1Driver.fistPlaceDescending =false;
            this.setVisible (false);
            new GUI_DriversStats ();
        } else if (e.getSource () == exitBtn) {
            System.exit (0);
        } else if (e.getSource () == firstPlacesBtn) {//if first button pressed reload the current jFrame with the requirement
            displayTitle1 = "DESCENDING oder of the first places ";
            Formula1Driver.fistPlaceDescending = true;
            this.setVisible (false);
            new GUI_DriversStats ();
        } else if (e.getSource () == backBtn) {
            Formula1Driver.disOrAscending = false;
            Formula1Driver.fistPlaceDescending =false;
            this.setVisible (false);
            new GUI_Main ();
        }
    }
}
