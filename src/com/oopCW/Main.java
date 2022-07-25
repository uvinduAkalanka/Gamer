package com.oopCW;

import java.util.Locale;
import java.util.Scanner;
//###################### finalized with comments also ##################

public class Main {
    //one universal scanner t get all user input in the program
    public static Scanner scanner = new Scanner (System.in);
    public static  Formula1ChampionshipManager formula1ChampionshipManager = new Formula1ChampionshipManager ();

    public static boolean repeater;
    public static String driverName;
    public static String driverTeam;
    private static String driverLocation;
    public static String reEnter;
    public static String enterData;
    public static String detail;

    // checking  the inputs using wild card characters
    public static String validatorString = "[a-zA-Z. ]*";
    public static String validate = "[0-9]*";

    public static void main(String[] args) {
        formula1ChampionshipManager.loadData ();menu (scanner);
    }
    public static void menu (Scanner scanner) {
//        Formula1ChampionshipManager.raceStatistics.forEach (driver -> {
//            System.out.println ("driver name "+driver.getDriverName ());
//            System.out.println ("position " + ((Formula1Driver) driver).getRacePosition ());
//            System.out.println (" date " + ((Formula1Driver) driver).getRaceDate ());
//        });
//
//        System.out.println (Formula1Driver.fistPlaceDescending);
//        System.out.println (!Formula1Driver.fistPlaceDescending);
//
//        System.out.println (Formula1ChampionshipManager.raceStatistics.size ());



        System.out.println ("\n########################################################          ||||||||||||||||||||||||||             |||||        ");
        System.out.println ("                     ChampionshipManager                          ||||||||||||||||||||||||||           |||||||          ");
        System.out.println ("########################################################          ||||                                ||| ||||          ");
        System.out.println ("\tHello drivers welcome to driver's menu                        ||||                              |||   ||||            ");
        System.out.println ("please carefully follow the instruction bellow                    ||||                                    ||||          ");
        System.out.println ("                                                                  ||||                                    ||||          ");
        System.out.println ("*\t A. Create a new driver                            *          ||||                                    ||||           ");
        System.out.println ("*\t B. Delete a driver                                *          ||||                                    ||||           ");
        System.out.println ("*\t C. Change the driver for an existing  team        *          ||||||||||||||||||||||||||              ||||           ");
        System.out.println ("*\t D. Display the statistics for a driver            *          ||||||||||||||||||||||||||              ||||           ");
        System.out.println ("*\t E. Display the Formula 1 Driver Table             *          ||||                                    ||||           ");
        System.out.println ("*\t F. Add a race completed race                      *          ||||                                    ||||           ");
        System.out.println ("*\t G. Saving in a file                               *          ||||                                    ||||           ");
        System.out.println ("*\t Q. Exit                                           *          ||||                               ||||||||||||||      ");
        System.out.println ("########################################################          ||||                               ||||||||||||||   \n");

        while (!repeater) {// boolean repeater is the while switch case controller
            System.out.print ("please enter our choice : ");
            String choice = scanner.nextLine ().toLowerCase (Locale.ROOT);
            switch (choice) {
                case "a"->{System.out.println ("you are ready to create a drive and team");createANewDriver(scanner);repeater = true;}
                case "b"->{formula1ChampionshipManager.deleteDriver();repeater=true;}
                case "c"->{formula1ChampionshipManager.changTheDriverForAnExistingTeam ();repeater=true;}
                case "d"->{

                    if (Formula1ChampionshipManager.driverStatistics.isEmpty ()) {
                        System.out.println ("NO TEAM HAS BEEN REGISTER YET !! SO CHANGE THE DRIVER OPTION LOCKED");
                        System.out.print ("Do you want to add a driver and team ? Then enter \"y\" or enter \"n\" for navigate to main menu : " );
                        if (formula1ChampionshipManager.navigate (scanner).equals ("y")) {
                            createANewDriver (scanner);

                        } else {
                            Main.menu (scanner);
                        }
                    }
                    System.out.println ("This is the driver list available in the championship to display the statistics");

                    String alignToLeft = "* %-30s  %-21s %n";//https://stackoverflow.com/questions/12684368/how-to-left-align-a-fixed-width-string
                    System.out.format ("-------------------------------------------------%n");
                    System.out.format ("DIVER NAME                     BELONG TEAM%n");
                    System.out.format ("-------------------------------------------------%n");

                    Formula1ChampionshipManager.driverStatistics.forEach (driver ->
                            System.out.format (alignToLeft, driver.getDriverName ().toUpperCase (Locale.ROOT)
                                    , driver.getDriverTeam ().toUpperCase (Locale.ROOT)));
                    System.out.print ("\nPlease select one of above drivers to display his statistics : ");
                    formula1ChampionshipManager.displayADriverStatistics ();
                    repeater = true;
                }
                case "e"->{formula1ChampionshipManager.displayFormula1DriverTable();repeater=true;}
                case "f"->{
                    formula1ChampionshipManager.addCompletedRace ();
                    repeater = true;
                }
                case "g"->{
                    if (Formula1ChampionshipManager.driverStatistics.isEmpty ()) {
                        System.out.println ("\nNO TEAM HAS BEEN REGISTER YET !! SO LAUNCHING THE GUI IS LOCKED");
                        System.out.print ("\nDo you want add a driver and a team  ? \nThen press \"y\" or press \"n\" for navigate to main menu : ");
                        if (formula1ChampionshipManager.navigate (scanner).equals ("y")) {
                            createANewDriver (scanner);
                        } else {

                            menu (scanner);
                        }
                    }
                    new GUI_Main ();}
                case "q"->{
                    formula1ChampionshipManager.saveData ();
                    System.out.println ("SAD TO SEE YOU LEAVE GOOD BYE !!!");
                    System.exit (1);
                }
                default -> System.out.println ("\nplease read the instruction and try a again \n");
            }
        }
    }

    /**
     * this method for validate the inputs as required to the system
     * @param scanner get the input
     * @param wordChanger this to indicate user what to input like name,team,location
     * @param validator this is for validate surer input either integer or string according to the format
     */

    public static void driverInformationCollector (Scanner scanner, String wordChanger,String validator) {
        System.out.print ("Please enter "+wordChanger);
        detail = scanner.nextLine ();

        //wrong input  catcher
        if (detail == null || !detail.matches (validator)|| detail.equals ("")) {
            System.out.println ("please enter your name correctly with out numbers");
//            System.out.print ("Please enter the "+wordChanger+" again");
            driverInformationCollector (scanner, reEnter,validator);
        }
        enterData = detail.toLowerCase(Locale.ROOT);
    }

   public static void createANewDriver (Scanner scanner)  {
        validate = validatorString;
        reEnter = "team name gain : ";
        driverInformationCollector (scanner, "driver's team name : ",validate);
//        AtomicBoolean teamChecker = new AtomicBoolean (false);
       //one team can be entered one time because only  one driver for one team (check the ream is available)
        Formula1ChampionshipManager.driverStatistics.forEach (team->{
            if (team.getDriverTeam ().equals (detail)) {
                System.out.println ("!!!!!!Dear customer you entered team is already in the championship");
                System.out.println ("please retry with a new team !");
                createANewDriver (scanner);
            }
        });

        driverTeam=enterData;
        //reEnter is using for display one more time if user inputs wrong data
        reEnter = "drivers name again : ";
        driverInformationCollector (scanner, "driver's name :",validate);
        driverName=enterData;

        reEnter = " location again : ";
        driverInformationCollector (scanner, "driver's location : ",validate);
        driverLocation=enterData;
//        validate = validatorNumber;
//        reEnter = "driver's won first places again : ";
//        driverInformationCollector (scanner,"driver's won first places",validate);

//        reEnter = "driver's won second places again : ";
//        driverInformationCollector (scanner, "driver's second first places", validate);
//
//        reEnter = "driver's won third places again : ";
//        driverInformationCollector (scanner, "driver's third first places", validate);

//        System.out.println (driverName);
//        System.out.println (driverTeam);
//        System.out.println (driverLocation);
       //Every time creates new object to save the new entered driver details to the object array
        Formula1Driver formula1Driver = new Formula1Driver (driverName, driverTeam, driverLocation, 0, 0, 0, 0, 0,"",0);
        formula1ChampionshipManager.createDriver (formula1Driver);//saving method

        System.out.println ("do you want to add another driver and the team to the season ? :");
        System.out.print ("if it is yes ? then press \"y\" or enter \"n\" to navigate main menu : ");
        boolean repeater = false;
        do {
            String choice = scanner.nextLine ().toLowerCase (Locale.ROOT);
            if (choice.equals ("y")) {
                createANewDriver (scanner);
            } else if (choice.equals ("n")) {
                formula1ChampionshipManager.saveData ();

                menu (scanner);
            } else {
                repeater = true;
                System.out.print ("input invalid !!!!! please enter your choice again : ");
            }
        } while (repeater);
    }

}
