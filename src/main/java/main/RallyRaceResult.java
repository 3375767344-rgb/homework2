package main;
import java.util.*;


public class RallyRaceResult implements RaceResult {
    private String raceName;
    private String location;
    private Map<Driver, Integer> driverPoints;

    public RallyRaceResult(String raceName, String location) {
        this.raceName = raceName;
        this.location = location;
        this.driverPoints = new HashMap<>();
    }

    @Override
    public void recordResult(Driver driver, int position, int points) {
        driverPoints.put(driver, points);
    }
    

    @Override
    public String getRaceName() {
        return raceName;
    }
    
    @Override
    public String getLocation(){
        return location;
    }
    
    @Override
    public int getDriverPoints(Driver driver) {
        return driverPoints.getOrDefault(driver, 0);
    }

    @Override
    public List<Driver> getResults() {
        return Collections.unmodifiableList(new ArrayList<>(driverPoints.keySet()));
    }
}