package DeliveryManagement.entity;

import DeliveryManagement.model.OrderStatus;

import java.util.List;

public class Order {
    private List<Dish> dishes;
    private Restaurant restaurant;
    private DeliveryPartner deliveryPartner;
    private OrderStatus status;
    private Customer customer;

    public Order(List<Dish> dishes, Restaurant restaurant, DeliveryPartner deliveryPartner,Customer customer) {
        this.dishes = dishes;
        this.restaurant = restaurant;
        this.deliveryPartner = deliveryPartner;
        this.status = OrderStatus.CONFIRMED; // Default status is PENDING
        this.customer=customer;
    }

    // Getters and Setters
    public List<Dish> getDishes() {
        return dishes;
    }



    public Restaurant getRestaurant() {
        return restaurant;
    }

    public DeliveryPartner getDeliveryPartner() {
        return deliveryPartner;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
    public Customer getCustomer() {
        return customer;
    }


}

