package DeliveryManagement.entity;

import java.util.List;

public class BestRoute {

    private List<Object> route;
    private double totalDistance;

    public BestRoute(List<Object> route, double totalDistance) {
        this.route = route;
        this.totalDistance = totalDistance;
    }

    public List<Object> getRoute() {
        return route;
    }

    public double getTotalDistance() {
        return totalDistance;
    }
}
