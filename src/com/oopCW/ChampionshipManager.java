package com.oopCW;
import java.io.IOException;

public interface ChampionshipManager {
    void createDriver (Formula1Driver formula1Driver);

    void deleteDriver ();

    void changTheDriverForAnExistingTeam ();

    void displayADriverStatistics ();

    void displayFormula1DriverTable ();

    void addCompletedRace ();

    void saveData () throws IOException;

    void loadData ();
}
