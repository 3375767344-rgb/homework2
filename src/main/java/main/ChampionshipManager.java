package main;
import java.util.*;

public class ChampionshipManager {
    private static ChampionshipManager instance;
    private List<Driver> drivers;
    private List<RallyRaceResult> races;
    private static int totalDrivers = 0;
    private static int totalRaces = 0;

    private ChampionshipManager() {
        drivers = new ArrayList<>();
        races = new ArrayList<>();
    }
    public static ChampionshipManager getInstance() {
        if (instance == null) {
            instance = new ChampionshipManager();
        }
        return instance;
    }
    public void registerDriver(Driver driver) {
        drivers.add(driver);
        totalDrivers++;
    }
    public void addRaceResult(RallyRaceResult result) {
        races.add(result);
        totalRaces++;
        for (Driver driver : result.getResults()) {
            int points = result.getDriverPoints(driver);
            driver.addPoints(points);
        }
    }

    public List<Driver> getDrivers() {
        return Collections.unmodifiableList(drivers);
    }

    public static List<Driver> getDriverStandings() {
        List<Driver> standings = new ArrayList<>(ChampionshipManager.getInstance().getDrivers());
        standings.sort((d1, d2) -> Integer.compare(d2.getPoints(), d1.getPoints()));
        return standings;
    }

    public static Driver getLeadingDriver(){
        List<Driver> standings = getDriverStandings();
        return standings.isEmpty() ? null : standings.get(0);
    }

    public static List<RallyRaceResult> getRaces() {
        return Collections.unmodifiableList(getInstance().races);  
    }

    public static int getTotalChampionshipPoints(){
        return getInstance().drivers.stream().mapToInt(Driver::getPoints).sum();
    }

    public static int getTotalDrivers() {
        return totalDrivers;
    }

    public static int getTotalRaces() {
        return totalRaces;
    }
}


