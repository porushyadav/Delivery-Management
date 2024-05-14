package DeliveryManagement.entity;

import DeliveryManagement.model.OrderStatus;

import java.util.ArrayList;
import java.util.List;

public class DeliveryPartner {
    private String name;
    private int numberOfOrders;
    private GeoLocation currentLocation; // Current location of the delivery partner
    private List<Order> assignedOrders;
    private int  capacity;


    public DeliveryPartner(String name, GeoLocation currentLocation) {
        this.name = name;
        this.numberOfOrders = 0;
        this.currentLocation = currentLocation;
        this.assignedOrders = new ArrayList<>();
        this.capacity=capacity;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getNumberOfOrders() {
        return numberOfOrders;
    }



    public void setNumberOfOrders(int value) {
        numberOfOrders = numberOfOrders + 1;
    }

    public GeoLocation getCurrentLocation() {
        return currentLocation;
    }

    public int getCapacity() {
        return capacity;
    }

    // Setter for current location
    public void setCurrentLocation(GeoLocation currentLocation) {
        this.currentLocation = currentLocation;
    }

    public List<Order> getAssignedOrders() {
        return assignedOrders;
    }


    // Method to increment order count and assign an order

}
