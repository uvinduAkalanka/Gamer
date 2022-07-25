package com.oopCW;

//##########################sportclub################

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Driver implements Serializable {
    private String driverName;
    private String driverTeam;
    private String driverLocation;
    private static List<String> dateOfRace = new ArrayList<> ();

    public static void setDateOfRace (List<String> dateOfRace) {
        Driver.dateOfRace = dateOfRace;
    }

    public static List<String> getDateOfRace () {
        return dateOfRace;
    }

    public Driver (String driverName, String driverTeam, String driverLocation) {
        this.driverName = driverName;
        this.driverTeam = driverTeam;
        this.driverLocation = driverLocation;
    }


    public String getDriverName () {
        return driverName;
    }

    public String getDriverTeam () {
        return driverTeam;
    }

    public void setDriverName (String driverName) {
        this.driverName = driverName;
    }

    public String getDriverLocation () {
        return driverLocation;
    }
}
