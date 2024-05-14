package DeliveryManagement.entity;


import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String mobile;
    private GeoLocation location;
    private List<Order> orders;

    public Customer(String name,String mobile, GeoLocation location) {
        this.name = name;
        this.mobile=mobile;
        this.location = location;
        this.orders = new ArrayList<>();
    }

    // Getters
    public String getName() {
        return name;
    }

    public GeoLocation getLocation() {
        return location;
    }

    public List<Order> getOrders() {
        return orders;
    }
    public String getMobile() {
        return mobile;
    }


}