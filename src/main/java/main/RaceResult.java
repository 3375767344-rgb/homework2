package main;

public interface RaceResult {
    public void recordResult(Driver driver, int position, int points);
    public java.util.List<Driver> getResults(); 
    public int getDriverPoints(Driver driver);
    public String getRaceName();
    public String getLocation();
}
