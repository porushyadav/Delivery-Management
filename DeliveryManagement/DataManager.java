package DeliveryManagement;

import DeliveryManagement.entity.Customer;
import DeliveryManagement.entity.DeliveryPartner;
import DeliveryManagement.entity.Restaurant;
import DeliveryManagement.service.CustomerManager;
import DeliveryManagement.service.DeliveryPartnerManager;
import DeliveryManagement.service.RestaurantManager;

import java.util.List;

public class DataManager {
    private RestaurantManager restaurantManager;
    private CustomerManager customerManager;
    private DeliveryPartnerManager deliveryPartnerManager;

    public DataManager() {
        // Initialize managers in the constructor
        this.restaurantManager = new RestaurantManager();
        this.customerManager = new CustomerManager();
        this.deliveryPartnerManager = new DeliveryPartnerManager();

        // Add predefined details
        addPredefinedDetails();
    }

    // Method to add predefined details to the managers
    private void addPredefinedDetails() {
        restaurantManager.addPredefinedRestaurants();
        customerManager.addPredefinedCustomers();
        deliveryPartnerManager.addPredefinedDeliveryPartners();
    }

    // Method to get the list of predefined restaurants
    public List<Restaurant> getAllRestaurants() {
        return restaurantManager.getAllRestaurants();
    }

    // Method to get the list of predefined customers
    public List<Customer> getAllCustomers() {
        return customerManager.getAllCustomers();
    }

    // Method to get the list of predefined delivery partners
    public List<DeliveryPartner> getAllDeliveryPartners() {
        return deliveryPartnerManager.getAllDeliveryPartners();
    }
}