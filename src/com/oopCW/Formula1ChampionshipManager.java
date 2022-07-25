package com.oopCW;

// ##########################finalized with commenting also#############################

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Formula1ChampionshipManager implements ChampionshipManager{
    public static List<Driver> driverStatistics = new ArrayList<> ();//main object array to save races details

    public static List<String> dateOfRace = new ArrayList<> ();
    public static List<Driver> raceStatistics = new ArrayList<> ();//driver with positions


    private static final File file = new File ("storeData.txt");//file to save nd  load data for the system
    private static String dateOf;//static remove
    private static int driverPosition;//static remove
    public static int pointOfTheRace;

    public Formula1ChampionshipManager () {
    }

    /**
     *Creating the driver with his details
     * @param formula1Driver get created object to save into the object array
     */
    @Override
    public void createDriver (Formula1Driver formula1Driver) {
        driverStatistics.add (formula1Driver);
        System.out.println ("congratulations!! successfully registered as team number " + driverStatistics.size () + " in the season");
    }

    @Override
    public String toString () {
        return "Formula1ChampionshipManager{}";
    }

    @Override
    public void deleteDriver () {
        isEmpty ();//checking the array is null if so there is no drivers in the list so can not delete

        System.out.println ("   NOW YOU CAN DELETE A DRIVER FROM THE LIST");
        System.out.println ("   THIS IS THE DRIVER LIST OF THE TOURNAMENT");
        String alignToLeft = "| %-30s  %-21s %n";
        System.out.format ("-------------------------------------------------%n");
        System.out.format ("    DIVER NAME                 BELONG TEAM%n");
        System.out.format ("-------------------------------------------------%n");
        //print the available drivers names to pick one of them and delete is easy foe the user
        driverStatistics.forEach (driver -> System.out.format (alignToLeft, driver.getDriverName ().toUpperCase(Locale.ROOT) , driver.getDriverTeam ().toUpperCase(Locale.ROOT)));


        boolean x = false;
        //validating user inputs of name ,entered name is not in the saved list give the user to ability enter name again
        System.out.print ("\nEnter a driver's name to delete the driver and his team from the list : ");
        do {
            String name = Main.scanner.nextLine ().toLowerCase(Locale.ROOT);
            for (Driver driver : driverStatistics) {
                if (name.equals (driver.getDriverName ())) {
                    driverStatistics.remove (driver);
                    x = true;
                    break;
                }
            }
            if (!x) {
                System.out.println ("Entered driver is not registered in the formula 1 championship");
                System.out.print ("please try a gain with a existing driver : ");

            }
        } while (!x);
        saveData ();//saving the deletion
        System.out.println ("\n!!!SUCCESSFULLY DRIVER AND THE TEAM HAS BEEN DELETED!!!!\n");
        System.out.print ("Do you want to delete another  driver? \nThen press \"y\" or press \"n\" to navigate main menu : ");

        // this is navigator guide to run through program
        //bellow code clock helps to delete a driver again or go to main menu
        if (navigate (Main.scanner).equals ("y")) {
            deleteDriver ();
        } else {
            Main.menu (Main.scanner);
        }
    }


    @Override
    public void changTheDriverForAnExistingTeam () {
        isEmpty ();
        String alignToLeft = " %-30s  %-21s %n";
        System.out.println ("\n     THIS IS THE REGISTERED TEAM LIST OF THE TOURNAMENT");
        System.out.format ("------------------------------------------------------------------------%n");
        driverStatistics.forEach (driver -> System.out.format (alignToLeft,("* Team name - " + driver.getDriverTeam ().toUpperCase(Locale.ROOT)) , ("\t\tcurrent driver name ( " + driver.getDriverName ().toUpperCase ()+" )")));
        System.out.println ("------------------------------------------------------------------------\n");

        System.out.print ("please enter a team name to update the driver: ");

        //validating user inputs of name ,entered name is not in the saved list give the user to ability enter name again
        //if entered team name is correct program go ahead to replace the driver
        boolean x = false;//WHILE LOOP CONTROLLER ,LOOP WILL BE LOOPING TILL A USER ENTERS A MATCHING TEAM NAME
        do {
            String team = Main.scanner.nextLine ().toLowerCase(Locale.ROOT);
            for (Driver driver : driverStatistics) {
                if (team.equals (driver.getDriverTeam ())) {
                    Main.reEnter = "Please enter the new driver's name again";
                    Main.driverInformationCollector (Main.scanner, "Please enter the new driver name for the team( " + driver.getDriverTeam ().toUpperCase(Locale.ROOT)+" ) : ",Main.validatorString);
                    driver.setDriverName (Main.enterData);
                    //A NEW DRIVER'S STATISTICS ARE ALWAYS ZERO WHEN NEWLY ENTERED
                    ((Formula1Driver) driver).setParticipatedRaces (0);
                    ((Formula1Driver) driver).setFirstPlaces (0);
                    ((Formula1Driver) driver).setSecondPlaces (0);
                    ((Formula1Driver) driver).setThirdPlaces (0);
                    ((Formula1Driver) driver).setParticipatedRaces (0);
                    ((Formula1Driver) driver).setOwnedPoints (0);
                    System.out.println ("\nSUCCESSFULLY UPGRADED  THE NEW  DRIVER " + Main.enterData.toUpperCase (Locale.ROOT) + " FOR THE TEAM " + driver.getDriverTeam ().toUpperCase (Locale.ROOT) );
                    saveData ();
                    x = true;
                    break;
                }
            }
            if (!x) { //THIS IS THE USER GUIDELINES TO USER  IF THEY ENTERED WRONG NAME WHICH IS NOT IN THE LIST OF TEAMS
                System.out.println ("entered team is not registered in the formula 1 championship");
                System.out.print ("please try a gain with a existing team : ");

            }
        } while (!x);

//        this is navigator guide to run through program
        System.out.print ("\nDo you want to change another team's driver? \nThen press \"y\" or press \"n\" to navigate main menu : ");
        if (navigate (Main.scanner).equals ("y")) {
            changTheDriverForAnExistingTeam ();
        } else {
            Main.menu (Main.scanner);
        }
    }

    @Override
    public void displayADriverStatistics () {
        String name = Main.scanner.nextLine ().toLowerCase(Locale.ROOT);
        //this is for  catch the driver name to show the statistics used java API Stream functional programming
        Optional<Driver> selectedDriver = driverStatistics.stream ().filter (driver -> driver.getDriverName ().matches (name)).findFirst ();

        //checking the entered driver is available in the list
        // if empty then restart the method
        if (selectedDriver.isEmpty ()) {
            System.out.print ("please enter driver name correctly again to display the statistics of the driver : ");
            displayADriverStatistics ();
        }

        for (Driver driver : driverStatistics) {
            if (name.equals (driver.getDriverName ())) {
                System.out.println ("---------------------------------------------------");
                System.out.println ("Statistics fo the driver  - ( " + name.toUpperCase (Locale.ROOT)+" )");
                System.out.println ("---------------------------------------------------");
                System.out.println ("Drivers team              -      " + driver.getDriverTeam ().toUpperCase(Locale.ROOT));
                System.out.println ("Driver's location         -      "+ driver.getDriverLocation ().toUpperCase(Locale.ROOT));
                System.out.println ("Driver's won first places -      " + ((Formula1Driver) driver).getFirstPlaces ());
                System.out.println ("Driver's won second places-      " + ((Formula1Driver) driver).getSecondPlaces ());
                System.out.println ("Driver's won third places -      " + ((Formula1Driver) driver).getThirdPlaces ());
                System.out.println ("Participated races        -      " + ((Formula1Driver) driver).getParticipatedRaces ());
                System.out.println ("Current Points            -      " + ((Formula1Driver) driver).getOwnedPoints ());

            }
        }
        //        this is navigator guide to run through program
        System.out.print ("\nDo you want display the statistics of the another driver ? \nThen press \"y\" or press \"n\" to navigate main menu : ");
        if (navigate (Main.scanner).equals ("y")) {
            System.out.print ("Please select one of above drivers to display his statistics : ");
            displayADriverStatistics ();
        } else {
            Main.menu (Main.scanner);
        }
    }

    @Override
    public void displayFormula1DriverTable () {
        isEmpty ();//is object array is empty no need to execute bottom part

        // this is done with wild card characters with aliases of java taken by stackoverflow(only the wild card characters and aliases)
        System.out.println ("                                                       FORMULA 1 DRIVER TABLE");
        String alignToLeft = "| %-21s | %-21s |%-16s |%-13d |%-14d |%-14d |%-21d |%-15d |%n";//https://stackoverflow.com/questions/12684368/how-to-left-align-a-fixed-width-string
        System.out.format ("_________________________________________________________________________________________________________________________________________________________%n");
        System.out.format("|       Driver name     |          Team         |      Location   | First Places | Second places |  Third paces  |  Participated races  |  Total points  |%n");
        System.out.format("|_______________________|_______________________|_________________|______________|_______________|_______________|______________________|________________|%n");

//        Comparator<Formula1Driver> sorter = (value1, value2) -> {
//            if (value1.getOwnedPoints () > value2.getOwnedPoints ()) {
//                return 1;
//            } else if (value1.getOwnedPoints () == value2.getOwnedPoints ()) {
//                if (value1.getFirstPlaces () > value2.getFirstPlaces ()) {
//                    return 1;
//                } else if (value1.getFirstPlaces () < value2.getFirstPlaces ()) {
//                    return -1;
//                } else {
//                    return 0;
//                }
//            } else {
//                return -1;
//            }
//        };
//        Collections.sort (driverStatistics, sorter);
//        Collections.sort (driverStatistics);

//        Collections.sort (driverStatistics, point1, point2)->{}


        Formula1Driver.positionChanger1 = 1;//descending oder adjustment
        Formula1Driver.positionChanger2 = -1;//descending oder adjustment
        driverStatistics.sort (Collections.reverseOrder ());//sorting with positionChanger variables placed as descending oder
        driverStatistics.forEach (driver->{
            System.out.format (alignToLeft, driver.getDriverName (), driver.getDriverTeam (),
                    driver.getDriverLocation (),((Formula1Driver) driver).getFirstPlaces (),
                    ((Formula1Driver) driver).getSecondPlaces (),+((Formula1Driver) driver).getThirdPlaces (),
                    ((Formula1Driver) driver).getParticipatedRaces (),((Formula1Driver) driver).getOwnedPoints ());
        });
        System.out.println ("|_______________________|_______________________|_________________|______________|_______________|_______________|______________________|________________|");

        //        this is navigator guide to run through program
        System.out.print ("\nDo you want navigate main menu ? \nThen press \"y\" or press \"n\" to exit the program : ");
        if (navigate (Main.scanner).equals ("y")) {
            Main.menu (Main.scanner);
        } else {
            System.out.println ("SAD TO SEE YOU LEAVE GOOD BYE !!!");
            System.exit (1);
        }
    }

    /**
     *this method is to get the drivers position in a race with validating the user inputs
     * assign the points according to the position they achieved
     */
    public void integerCheckerGetter () {
        Scanner input = new Scanner (System.in);
        try {
            driverPosition = input.nextInt ();
//            if part i for get the user inputs correctly user is avoided to add a number more than the racers count in the list,
//            and also it is avoided getting zero or negative numbers
            if (driverPosition > driverStatistics.size () || driverPosition<=0) {
                System.out.println (driverStatistics.size () + " ERROR(driver/s only in the race so it can not be " + driverPosition+
                        " or you entered negative integer)");
                System.out.print ("please re enter the position : ");
                integerCheckerGetter ();
            }
        } catch (Exception e) {
            System.out.print ("please enter the position in numbers to continue : ");
            integerCheckerGetter ();
        }
//        this switch is introduced to auto update points according to entered positions of the racers
        switch (driverPosition) {
            case 1->{pointOfTheRace=25;}
            case 2->{pointOfTheRace=18;}
            case 3->{pointOfTheRace=15;}
            case 4->{pointOfTheRace=12;}
            case 5->{pointOfTheRace=10;}
            case 6->{pointOfTheRace=8;}
            case 7->{pointOfTheRace=6;}
            case 8->{pointOfTheRace=4;}
            case 9->{pointOfTheRace=2;}
            case 10-> {pointOfTheRace = 1;}
            default-> pointOfTheRace = 0;
        }
    }

    @Override
    public void addCompletedRace () {
        isEmpty ();//if they are is not any registered team can not proceed this method
//        int arrayFeeder = 0;
//        AtomicInteger arrayFeeder = new AtomicInteger ();//atomic integer for use during the API Stream
////        System.out.println ("lineeeeeeeeeeeeeee 280");

        AtomicBoolean dataChecker = new AtomicBoolean (false);//atomic boolean for use during the API Stream
        AtomicBoolean driverNamePrinter = new AtomicBoolean (false);
        driverStatistics.forEach (driver -> {
            if (!dataChecker.get ()) {
                System.out.println ("YOU ARE READY TO ADD A RACE TO FORMULA 1 HISTORY");
                System.out.print ("Please enter the date of the race in format (YYYY-MM-DD) : ");
                dateOf = Main.scanner.nextLine ();
                // this is done with wild card characters with aliases of java taken by stackoverflow(only the wild card characters and aliases)
                // date validation
                if ((dateOf == null) || (dateOf.equals ("")) ||
                        (!dateOf.matches ("^(19|20)\\d\\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$"))) {//https://stackoverflow.com/questions/15491894/regex-to-validate-date-formats-dd-mm-yyyy-dd-mm-yyyy-dd-mm-yyyy-dd-mmm-yyyy
                    System.out.print ("!!!invalid input.Please enter again the data in given format : ");
                    addCompletedRace ();
                } else {
                    dateOfRace.add (dateOf);
                }
                dataChecker.set (true);
            }
//            show the available driver list in the tournament then it is easy to user add the positions
            if (!driverNamePrinter.get ()) {
                System.out.println ("    THIS IS THE DRIVERS LIST IN THE TOURNAMENT ");
                System.out.println ("--------------------------------------------------");
                AtomicInteger i = new AtomicInteger ();
                driverStatistics.forEach (driver1 -> {
                    i.getAndIncrement ();
                    System.out.println (i + "). " + driver1.getDriverName ());
                });
                System.out.println ("Now please add the positions of the drivers");
                driverNamePrinter.set (true);
            }
            System.out.print ("please enter the position of driver mr." + driver.getDriverName () + " : ");
            integerCheckerGetter ();//get the validated output

//              saving object to track date and the position of the of a participated race
//            this is for display driver with his position
            Formula1Driver formula1Driver = new Formula1Driver (driver.getDriverName (), driver.getDriverName (),driver.getDriverLocation (), 0, 0, 0, 0, 0,dateOf,driverPosition);
            raceStatistics.add (formula1Driver);

//            updating the rst for the system

            ((Formula1Driver) driver).setOwnedPoints (((Formula1Driver) driver).getOwnedPoints () + pointOfTheRace);//added points of the race
//            System.out.println ("lineeeeeeeeeeeeeeeeeee 317 "+((Formula1Driver) driver).getParticipatedRaces ());
            ((Formula1Driver) driver).setParticipatedRaces (((Formula1Driver) driver).getParticipatedRaces () + 1);//added points of the race
//            System.out.println ("lineeeeeeeeeeeeeeeeeee 317 "+((Formula1Driver) driver).getParticipatedRaces ());
            switch (driverPosition) {
                case 1 -> ((Formula1Driver) driver).setFirstPlaces (((Formula1Driver) driver).getFirstPlaces () + 1);//added points of the race
                case 2 -> ((Formula1Driver) driver).setSecondPlaces (((Formula1Driver) driver).getSecondPlaces () + 1);//added points of the race
                case 3 -> ((Formula1Driver) driver).setThirdPlaces (((Formula1Driver) driver).getThirdPlaces () + 1);//added points of the race
            }
        });
        System.out.println ("\n Successfully added all the drivers positions to the system\nANd successfully updated the driver table");
        saveData ();
        Main.menu (Main.scanner);
    }

    @Override
    public void saveData ()  {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream (file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream (fileOutputStream);
            objectOutputStream.writeObject (driverStatistics);
            objectOutputStream.writeObject (raceStatistics);
            objectOutputStream.close ();
            fileOutputStream.close ();
            System.out.println ("All the entered data has been successfully saved !");
        } catch (IOException e) {
            e.printStackTrace ();
        }

    }

    @Override
    public void loadData () {
        try {
            FileInputStream fileInputStream = new FileInputStream (file);
            ObjectInputStream objectInputStream = new ObjectInputStream (fileInputStream);
            driverStatistics = (List<Driver>) objectInputStream.readObject ();
            raceStatistics = (List<Driver>) objectInputStream.readObject ();
            fileInputStream.close ();
            objectInputStream.close ();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace ();
        }
    }

    /**
     *  this is navigator guide to run through program
     * @param scanner universal one scanner for all the system
     * @return returning what to execute  next
     */
    public String navigate (Scanner scanner) {
        boolean repeater=false;
        String choice;
        do {
            choice = scanner.nextLine ().toLowerCase (Locale.ROOT);
            if (choice.equals ("y")) {
                return "y";
            } else if (choice.equals ("n")) {
                return "n";
            } else {
                repeater = true;
                System.out.print ("input invalid !!!!! please enter your choice again : ");
            }
        } while (repeater);
        return choice;
    }

    /**
     * this method is checking the array is empty or not  if it is empty  is restricting the access for the particular section.
     * after updated the drivers then this will be unlocked
     */
    private void isEmpty() {
        if (driverStatistics.isEmpty ()) {
            System.out.println ("NO TEAM HAS BEEN REGISTER YET !! SO THIS OPTION IS LOCKED");
            System.out.print ("Do you want to add a driver and team ? Then enter \"y\" or enter \"n\" for navigate to main menu : " );
            if (navigate (Main.scanner).equals ("y")) {
                Main.createANewDriver (Main.scanner);
            } else {
                Main.menu (Main.scanner);
            }
        }
    }

    /**
     * this is random date generator
     * @return the final fixed randomly generated date
     */
    public static String dateGenerator () {
        String month;
        String day  ;
        Random random = new Random ();
        month = String.valueOf (random.nextInt (12) + 1);
        day = String.valueOf (random.nextInt (30) + 1);

        // a date or month comes with one digit then it will be added zero because to use in comparator
        if (Integer.parseInt (month )< 10) {
            month = "0" + month;
        }
        if (Integer.parseInt (day) < 10) {
            day = "0" + day;
        }
        return "2021-" + month + "-" + day;
    }

}
