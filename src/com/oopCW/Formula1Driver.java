package com.oopCW;

//########### finalized with commenting also#######

public class Formula1Driver extends Driver implements Comparable<Formula1Driver>{//
    private int firstPlaces;
    private int secondPlaces;
    private int thirdPlaces;
    private int participatedRaces;
    private int ownedPoints;
    private String raceDate;
    private int racePosition;


    /**
     * those positionChangers for return the values for ascending oder and descending oder from a one comparator
     * positionChanger1 =1(in descending oder of points)
     * positionChanger2 =-1(in ascending oder of points)
     */
    public static int positionChanger1=1 ;
    public static int positionChanger2=-1;

    /**
     * this is for execute ->
     * point descending part or points ascending part(disOrAscending=false)
     * first place ascending  part(disOrAscending=true)
     */
    public static boolean fistPlaceDescending = false;

    public static boolean disOrAscending=false;//this is for get the value 1 or -1 to positionChanger1 and positionChanger2

    public static boolean intOrString = false;
//    public Formula1Driver (String driverName, String driverTeam, String driverLocation,String date,int position) {
//        super (driverName, driverTeam, driverLocation);
//        Formula1ChampionshipManager.setDriverPosition (position);
//        Formula1ChampionshipManager.setDateOf (date);
//
//    }

    /**
     *
     * @param driverName get the driver mame for the constructor
     * @param driverTeam get the team mame for the constructor
     * @param driverLocation get the location for the constructor
     * @param firstPlaces won places as variable names
     * @param secondPlaces won places as variable names
     * @param thirdPlaces won places as variable names
     * @param participatedRaces one driven finished races
     * @param ownedPoints gained points according to the position
     * @param raceDate race held date
     * @param racePosition won position for the particular race
     */

    public Formula1Driver (String driverName, String driverTeam,
            String driverLocation, int firstPlaces, int secondPlaces, int thirdPlaces,
            int participatedRaces, int ownedPoints,String raceDate,int racePosition) {
        super (driverName, driverTeam, driverLocation);
        this.firstPlaces = firstPlaces;
        this.secondPlaces = secondPlaces;
        this.thirdPlaces = thirdPlaces;
        this.participatedRaces = participatedRaces;
        this.ownedPoints = ownedPoints;
        this.raceDate = raceDate;
        this.racePosition = racePosition;
    }

    public String getRaceDate () {
        return raceDate;
    }

    public void setRaceDate (String raceDate) {
        this.raceDate = raceDate;
    }

    public int getRacePosition () {
        return racePosition;
    }

    public void setRacePosition (int racePosition) {
        this.racePosition = racePosition;
    }

    public static boolean isDisOrAscending () {
        return disOrAscending;
    }

    public static void setDisOrAscending (boolean disOrAscending) {
        Formula1Driver.disOrAscending = disOrAscending;
    }

    public int getFirstPlaces () {
        return firstPlaces;
    }

    public int getSecondPlaces () {
        return secondPlaces;
    }

    public int getThirdPlaces () {
        return thirdPlaces;
    }

    public int getParticipatedRaces () {
        return participatedRaces;
    }

    public int getOwnedPoints () {
        return ownedPoints;
    }

    public void setOwnedPoints (int ownedPoints) {
        this.ownedPoints = ownedPoints;
    }

    public void setParticipatedRaces (int participatedRaces) {
        this.participatedRaces = participatedRaces;
    }

    public void setFirstPlaces (int firstPlaces) {
        this.firstPlaces = firstPlaces;
    }

    public void setSecondPlaces (int secondPlaces) {
        this.secondPlaces = secondPlaces;
    }

    public void setThirdPlaces (int thirdPlaces) {
        this.thirdPlaces = thirdPlaces;
    }

    /**
     *
     * @param driverPoints get current value from the object's array's relevant component
     * @return replacement of the position of the array is returned
     */

    @Override

    public int compareTo (Formula1Driver driverPoints) {
//        System.out.println ("fistPlaceDescending 117= "+fistPlaceDescending);
        //fistPlaceDescending== false then execute point descending part or points ascending part
        //fistPlaceDescending== true then execute first place ascending  part
        if (!fistPlaceDescending) {
//            System.out.println ("fistPlaceDescending 119= "+fistPlaceDescending);
//            System.out.println ("im rungingggggggggggggggggggg iffffffffffffffffffff");
            if (ownedPoints > driverPoints.getOwnedPoints ()) {

                 //positionChanger1 =1(in descending oder of points)
                 //positionChanger2 =-1(in ascending oder of points)
                return positionChanger1;

            } else if (ownedPoints == driverPoints.getOwnedPoints ()) {
                return Integer.compare (firstPlaces, driverPoints.firstPlaces);
            } else {
                return positionChanger2;

            }
        } else {// this  part executes when ascending button clicked
//            System.out.println ("im runging elseeeeee");
//            System.out.println ("fistPlaceDescending 142= "+fistPlaceDescending);

            return Integer.compare (firstPlaces, driverPoints.getFirstPlaces ());


        }

//        if (intOrString) {
//            String one = raceDate;
//            String two = driverPoints.getRaceDate ();
//            return one.compareTo (two);
//        }

//        else if (ownedPoints == driverPoints.getOwnedPoints ()) {
//            if (firstPlaces > driverPoints.firstPlaces) {
//                return 1;
//            } else if (firstPlaces < driverPoints.firstPlaces) {
//                return -1;
//            } else {
//                return 0;
//            }
//        } else {
//            return positionChanger2;
//
//        }
//

//        if (firstPlaces > driverPoints.getFirstPlaces ()) {
//            return 1;
//        } else if (firstPlaces == driverPoints.getFirstPlaces ()) {
//            return 0;
//        } else {
//            return -1;
//        }




    }

}
