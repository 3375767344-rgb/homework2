package main;

public class Main {
    public static void main(String[] args) {

        // Create some cars
        GravelCar gravelCar1 = new GravelCar("Subaru", "Impreza", 300, 0.5);
        GravelCar gravelCar2 = new GravelCar("Mitsubishi", "Lancer", 320, 0.6);
        AsphaltCar asphaltCar1 = new AsphaltCar("Ford", "Fiesta", 280, 0.4);
        AsphaltCar asphaltCar2 = new AsphaltCar("Porsche", "911", 450, 0.8);

        // Create some drivers
        Driver driver1 = new Driver("Alice", "USA", gravelCar1);
        Driver driver2 = new Driver("Bob", "UK", gravelCar2);
        Driver driver3 = new Driver("Charlie", "France", asphaltCar2);
        Driver driver4 = new Driver("David", "Germany", asphaltCar1);
        
        // Register drivers
        ChampionshipManager m = ChampionshipManager.getInstance();
        m.registerDriver(driver1);
        m.registerDriver(driver2);
        m.registerDriver(driver3);
        m.registerDriver(driver4);

        // register some cars for first race
        driver1.setCar(gravelCar1);
        driver2.setCar(gravelCar2);
        driver3.setCar(asphaltCar2);
        driver4.setCar(asphaltCar1);
        
        //simulate first race
        RallyRaceResult race1 = new RallyRaceResult("Rally of Nations", "Italy");
        race1.recordResult(driver1, 1, 12);
        race1.recordResult(driver2, 2, 15);
        race1.recordResult(driver3, 3, 20);
        race1.recordResult(driver4, 4, 16);
        m.addRaceResult(race1);

        //switch cars for second race
        driver1.setCar(asphaltCar1);
        driver2.setCar(asphaltCar2);
        driver3.setCar(gravelCar1);
        driver4.setCar(gravelCar2);

        //simulate second race
        RallyRaceResult race2 = new RallyRaceResult("Rally of Europe", "Germany");
        race2.recordResult(driver1, 1, 10);
        race2.recordResult(driver2, 2, 12);
        race2.recordResult(driver3, 3, 18);
        race2.recordResult(driver4, 4, 14);
        m.addRaceResult(race2);

        // display leater
        Driver leader = ChampionshipManager.getLeadingDriver();
        System.out.println("\n==== CHAMPIONSHIP LEADER ====");
        System.out.printf("%s with %d points%n", leader.getName(), leader.getPoints());

        // display statistics
        System.out.println("\n==== CHAMPIONSHIP STATISTICS ====");
        System.out.printf("Total Drivers: %d%n", ChampionshipManager.getTotalDrivers());
        System.out.printf("Total Races: %d%n", ChampionshipManager.getTotalRaces());
        System.out.printf("Average Points per Driver: %.2f%n", ChampionshipStatistics.calculateAveragePointsPerDriver());
        System.out.printf("Most Successful Country: %s%n", ChampionshipStatistics.findMostSuccessfulCountry()); 
        System.out.printf("Total Championship Points: %d%n", ChampionshipManager.getTotalChampionshipPoints());


        //display race results
        System.out.println("\n==== RACE RESULTS ====");
        for (RallyRaceResult race : ChampionshipManager.getRaces()) {
            System.out.printf("Race: %s (%s)%n", race.getRaceName(), race.getLocation());
            int pos = 1;
            for (Driver d : race.getResults()) {
                int points = race.getDriverPoints(d);
                System.out.printf("Position %d: %s - %d points%n", pos++, d.getName(), points);
            }
        }

        System.out.println("\n==== CAR PERFORMANCE RATINGS ====");
        RallyCar sampleCar1 = new GravelCar("Subaru", "Impreza", 300, 0.5);
        RallyCar sampleCar2 = new AsphaltCar("Porsche", "911", 450, 0.8);
        System.out.printf("Gravel Car Performance: %.1f%n", sampleCar1.calculatePerformance());
        System.out.printf("Asphalt Car Performance: %.1f%n", sampleCar2.calculatePerformance());
    }
}