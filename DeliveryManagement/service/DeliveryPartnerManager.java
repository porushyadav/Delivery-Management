package DeliveryManagement.service;

import DeliveryManagement.entity.DeliveryPartner;
import DeliveryManagement.entity.GeoLocation;
import DeliveryManagement.entity.Order;
import DeliveryManagement.entity.Restaurant;
import DeliveryManagement.model.OrderStatus;

import java.util.ArrayList;
import java.util.List;

public class DeliveryPartnerManager {
    private List<DeliveryPartner> deliveryPartners;

    public DeliveryPartnerManager() {
        this.deliveryPartners = new ArrayList<>();
    }

    // Method to add a delivery partner to the list of delivery partners
    public void addDeliveryPartner(DeliveryPartner deliveryPartner) {
        deliveryPartners.add(deliveryPartner);
    }

    // Method to add predefined delivery partners
    public void addPredefinedDeliveryPartners() {
        // Delivery partner 1 details
        GeoLocation dp1Location = new GeoLocation("Location 1", 40.730610, -73.935242);
        DeliveryPartner dp1 = new DeliveryPartner("Delivery Partner 1", dp1Location);
        addDeliveryPartner(dp1);

        // Delivery partner 2 details
        GeoLocation dp2Location = new GeoLocation("Location 2", 34.052235, -118.243683);
        DeliveryPartner dp2 = new DeliveryPartner("Delivery Partner 2", dp2Location);
        addDeliveryPartner(dp2);

        // Add details for more delivery partners if needed
    }


    // Method to get all available delivery partners
    public List<DeliveryPartner> getAllDeliveryPartners() {
        return deliveryPartners;
    }


    public void assignOrder(Order order, Restaurant restaurant) {
        DeliveryPartner closestDeliveryPartner = null;
        double minDistance = Double.MAX_VALUE;

        // Find the closest delivery partner to the restaurant
        for (DeliveryPartner deliveryPartner : deliveryPartners) {
//            double distance = GeoLocation.calculateDistance(restaurant.getLocation());
            double distance=0;
            if (distance < minDistance && canAcceptOrder(deliveryPartner)) {
                closestDeliveryPartner = deliveryPartner;
                minDistance = distance;
            }
        }

        // Assign the order to the closest delivery partner
        if (closestDeliveryPartner != null) {
            assignOrder(order, closestDeliveryPartner);
            System.out.println("Order assigned to delivery partner: " + closestDeliveryPartner.getName());
        } else {
            System.out.println("No available delivery partners to assign the order.");
        }
    }

    public void assignOrder(Order order, DeliveryPartner deliveryPartner) {
        // Check if the delivery partner can accept more orders
        if (canAcceptOrder(deliveryPartner)) {
            // Add the order to the list of assigned orders
            deliveryPartner.getAssignedOrders().add(order);
            // Increment the number of orders assigned to the delivery partner
            deliveryPartner.setNumberOfOrders(1);
            // Optionally, you may update the status of the order to reflect that it has been assigned to this delivery partner
            order.setStatus(OrderStatus.ASSIGNED);
            System.out.println("Order assigned to delivery partner: " + deliveryPartner.getName());
        } else {
            System.out.println("Delivery partner " + deliveryPartner.getName() + " cannot accept more orders at the moment.");
        }
    }


    // Method to deliver an order
    public void deliverOrder(Order order) {
        for (DeliveryPartner deliveryPartner : deliveryPartners) {
            if (deliveryPartner.getAssignedOrders().contains(order)) {
                deliverOrder(order);
                return; // Exit loop after delivering the order
            }
        }
        System.out.println("Order not found or already delivered.");
    }

    public boolean canAcceptOrder(DeliveryPartner deliveryPartner) {
        // Check if the number of orders assigned to the delivery partner is less than their capacity
        return deliveryPartner.getNumberOfOrders() < deliveryPartner.getCapacity();
    }

}