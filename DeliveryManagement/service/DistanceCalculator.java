package DeliveryManagement.service;

import DeliveryManagement.entity.GeoLocation;

import java.util.HashMap;
import java.util.Map;

public class DistanceCalculator {
    public static Map<String, Double> calculateDistances(Map<String, GeoLocation> locations) {
        Map<String, Double> distances = new HashMap<>();
        for (String loc1 : locations.keySet()) {
            GeoLocation geo1 = locations.get(loc1);
            for (String loc2 : locations.keySet()) {
                if (!loc1.equals(loc2)) {
                    GeoLocation geo2 = locations.get(loc2);
                    double distance = geo1.calculateDistance(geo2);
                    distances.put(loc1 + "-" + loc2, distance);
                }
            }
        }
        return distances;
    }
}