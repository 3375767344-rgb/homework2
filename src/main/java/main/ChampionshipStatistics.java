package main;

import java.util.*;

public class ChampionshipStatistics {
    public static double calculateAveragePointsPerDriver() {
        int totalPoints = ChampionshipManager.getTotalChampionshipPoints();
        int numDrivers = ChampionshipManager.getTotalDrivers();
        if (numDrivers == 0) {
            return 0;
        } else {
            return (double) totalPoints / numDrivers;
        }
    }

    public static String findMostSuccessfulCountry() {
        Map<String, Integer> countryPoints = new HashMap<>();
        for (Driver driver : ChampionshipManager.getInstance().getDrivers()) {
            String country = driver.getCountry();
            int points = driver.getPoints();
            countryPoints.put(country, countryPoints.getOrDefault(country, 0) + points);
        }
        return countryPoints.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No country");
    }

    public static int countTotalRaces() {
        return ChampionshipManager.getTotalRaces();
    }
}