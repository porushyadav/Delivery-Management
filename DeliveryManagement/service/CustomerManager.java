package DeliveryManagement.service;

import DeliveryManagement.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerManager {
    private List<Customer> customers;
    private OrderManager orderManager;

    public CustomerManager() {
        this.customers = new ArrayList<>();
        this.orderManager=new OrderManager();
    }

    // Method to add a customer to the list of customers
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    // Method to add predefined users
    public void addPredefinedCustomers() {
        // Customer 1 details
        GeoLocation location1 = new GeoLocation("Location 1", 40.7128, -74.0060);
        Customer customer1 = new Customer("Customer 1","7500990871", location1);
        addCustomer(customer1);

        // Customer 2 details
        GeoLocation location2 = new GeoLocation("Location 2", 34.0522, -118.2437);
        Customer customer2 = new Customer("Customer 2","7500990872", location2);
        addCustomer(customer2);

        // Customer 3 details
        GeoLocation location3 = new GeoLocation("Location 3", 51.5074, -0.1278);
        Customer customer3 = new Customer("Customer 3","7500990873", location3);
        addCustomer(customer3);

        // Customer 4 details
        GeoLocation location4 = new GeoLocation("Location 4", 35.6895, 139.6917);
        Customer customer4 = new Customer("Customer 4","7500990874", location4);
        addCustomer(customer4);

        // Customer 5 details
        GeoLocation location5 = new GeoLocation("Location 5", 48.8566, 2.3522);
        Customer customer5 = new Customer("Customer 5","7500990875", location5);
        addCustomer(customer5);
    }

    // Method to get all available customers
    public List<Customer> getAllCustomers() {
        return customers;
    }
    public Customer findByMobile(String mobile) {
       Customer user = customers.stream()
                .filter(customer -> customer.getMobile().equals(mobile)).findFirst()
               .orElse(null);

        return user;
    }


}