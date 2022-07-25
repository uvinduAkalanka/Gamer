package com.oopCW;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//################################ finalized with commenting also##################

public class GUI_Main extends JFrame implements ActionListener {
    JButton driverStatsBtn,generateRaceBtn,randomRacePositionBtn,displayRacesBtn,racerStatisticsBtn,exitBtn;

    GUI_Main () {
//     taken the idea from bellow link  for  All the tables are in the GUI series
//        https://www.youtube.com/watch?v=GAl1FSKvoFY

        setBounds (100, 40, 1200, 800);
        getContentPane ().setBackground (new Color (0, 0, 0));
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setTitle ("GUI MAIN MENU");
        setResizable (false);
        setLayout (null);

        ImageIcon il = new ImageIcon (ClassLoader.getSystemResource ("com/oopCW/images/X.jpg"));//image of the menu
        // taken idea from https://stackoverflow.com/questions/46960004/using-javax-swing-imageicon-to-display-a-jpg-i-saved-in-the-directory

        JLabel l1 = new JLabel (il);
        l1.setBounds (-100, -200, 700, 800);
        add (l1);

        JLabel welcomeLabel = new JLabel (" WELCOME TO FORMULA 1 CHAMPIONSHIP ");
        welcomeLabel.setFont (new Font ("Andale Mono",Font.BOLD,25));
        welcomeLabel.setForeground (new Color (224, 160, 116));
        welcomeLabel.setBackground (new Color (100, 200, 254));

        welcomeLabel.setBorder(new CompoundBorder ( // sets two borders
                BorderFactory.createMatteBorder(10, 10, 10, 10, new Color (100, 200, 254)), // outer border
                BorderFactory.createEmptyBorder(20, 0, 20, 10))); // inner invisible border as the margin

        welcomeLabel.setBounds (550, 40, 600, 55);
        welcomeLabel.setPreferredSize (new Dimension (300, 100));
        add (welcomeLabel);

        driverStatsBtn = new JButton ("DISPLAY DRIVERS STATISTICS");
        driverStatsBtn.setBounds(600, 170, 500, 30);
        hoverEffect (driverStatsBtn);

        generateRaceBtn = new JButton ("GENERATE RANDOM RACE");
        generateRaceBtn.setBounds(600, 250, 500, 30);
        hoverEffect (generateRaceBtn);

        randomRacePositionBtn = new JButton ("RANDOM RACE WITH RANDOM POSITION");
        randomRacePositionBtn.setBounds(600, 330, 500, 30);
        hoverEffect (randomRacePositionBtn);

        displayRacesBtn = new JButton ("DISPLAY ALL RACES WITH DATES");
        displayRacesBtn.setBounds(600, 410, 500, 30);
        hoverEffect (displayRacesBtn);

        racerStatisticsBtn = new JButton ("RACER STATISTICS IN ALL RACES");
        racerStatisticsBtn.setBounds(600, 490, 500, 30);
        hoverEffect (racerStatisticsBtn);

        exitBtn = new JButton("EXIT ");
        exitBtn.setBounds(750, 620, 200, 30);
        hoverEffect (exitBtn);
        exitBtn.setBackground(new Color(176, 15, 15));

        //this to lock  displayRacesBtn and racerStatisticsBtn if not still assign a driver and the team to the system
        if (Formula1ChampionshipManager.raceStatistics.isEmpty ()){
            displayRacesBtn.setEnabled (false);
            racerStatisticsBtn.setEnabled (false);
        }

        setVisible (true);
    }

    @Override
    public void actionPerformed (ActionEvent e) {
        if (e.getSource () == driverStatsBtn) {
            this.setVisible (false);
            new GUI_DriversStats ();
        } else if (e.getSource () == generateRaceBtn) {
            this.setVisible (false);
            new GUI_RandomRace ();
        } else if (e.getSource () == randomRacePositionBtn) {
            this.setVisible (false);
            new GUI_RandomRaceAndPosition ();
        } else if (e.getSource () == displayRacesBtn) {

            this.setVisible (false);
            new GUI_RaceDetails ();
        } else if (e.getSource () == racerStatisticsBtn) {
            this.setVisible (false);
            new GUI_NameChecker ();
        } else if (e.getSource () == exitBtn) {
            System.exit (0);
        }
    }

    /**
     * this method is to get the hover effect
     * @param button get the j button to get the hover effect
     * for hover effect idea taken from bellow link
     * https://stackoverflow.com/questions/45773950/creating-a-button-with-a-round-background-color-java
     */
    public  void hoverEffect (JButton button) {
        button.setUI(new BasicButtonUI () {
            @Override
            public void update(Graphics graphics, JComponent component) {
                if (component.isOpaque()) {
                    Color colorFill = component.getBackground();

                    AbstractButton abstractButton = (AbstractButton) component;
                    ButtonModel buttonModel = abstractButton.getModel();

                    if (buttonModel.isPressed()) {
                        colorFill = colorFill.darker ();

                    } else if (buttonModel.isRollover()) {
                        colorFill = colorFill.brighter();
                    }

                    graphics.setColor(colorFill);
                    graphics.fillRoundRect(0, 0, component.getWidth(),component.getHeight(), 20, 20);
                }
                paint(graphics, component);
            }
        });

        button.setFont (new Font ("ALGERIAN", Font.PLAIN, 25));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(30, 144, 254));
        button.addActionListener (this);
        add (button);


    }
}
