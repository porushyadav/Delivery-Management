package DeliveryManagement.service;

import DeliveryManagement.entity.*;
import DeliveryManagement.model.OrderStatus;
import DeliveryManagement.util.CommonUtil;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    private List<Order> orders;
    private DeliveryPartnerManager deliveryPartnerManager;

    public OrderManager() {
        this.orders = new ArrayList<>();
        this.deliveryPartnerManager = deliveryPartnerManager;
    }

    // Method to place an order with a list of dishes
    public void placeOrder(List<Dish> dishes, Restaurant restaurant, Customer customer) {
        Order order = new Order(dishes, restaurant, null, customer);
        orders.add(order);
    }



    public void startPreparation() {
        List<Order> confirmedOrders = new ArrayList<>();

        // Find all confirmed orders
        for (Order order : orders) {
            if (order.getStatus() == OrderStatus.CONFIRMED) {
                confirmedOrders.add(order);
            }
        }
         if(CommonUtil.isEmpty(confirmedOrders))
             return;

        // Start preparing dishes for confirmed orders...
        // For simplicity, let's assume the preparation time is the maximum preparation time among all dishes
        confirmedOrders.parallelStream().forEach(order -> {
            int maxPrepTime = order.getDishes().stream()
                    .mapToInt(Dish::getPrepTime)
                    .max()
                    .orElse(0);

            // Simulate order preparation time (in milliseconds)
            long preparationTimeMillis = maxPrepTime * 60 * 1000; // Convert minutes to milliseconds
            try {
                Thread.sleep(preparationTimeMillis); // Simulate preparation time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Once preparation is completed, assign delivery partner
            deliveryPartnerManager.assignOrder(order, order.getRestaurant());
        });
    }
}
