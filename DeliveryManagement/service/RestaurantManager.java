package DeliveryManagement.service;

import DeliveryManagement.entity.Customer;
import DeliveryManagement.entity.Dish;
import DeliveryManagement.entity.GeoLocation;
import DeliveryManagement.entity.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantManager {

    private List<Restaurant> restaurants;

    public RestaurantManager() {
        this.restaurants = new ArrayList<>();
    }

    // Method to add a restaurant to the list of restaurants
    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    // Method to add details to all available restaurants and dishes
    public void addPredefinedRestaurants() {
        // Restaurant 1 details
        GeoLocation location1 = new GeoLocation("Location 1", 40.730610, -73.935242);
        Restaurant restaurant1 = new Restaurant("Restaurant 1", location1, 20);
        restaurant1.addDish(new Dish("Dish 1", 10.0, 15,true));
        restaurant1.addDish(new Dish("Dish 2", 15.0, 20,true));
        restaurant1.addDish(new Dish("Dish 3", 20.0, 20,true));
        restaurant1.addDish(new Dish("Dish 4", 25.0, 20,false));


        // Restaurant 2 details
        GeoLocation location2 = new GeoLocation("Location 2", 34.052235, -118.243683);
        Restaurant restaurant2 = new Restaurant("Restaurant 2", location2, 25);
        restaurant2.addDish(new Dish("Dish 3", 12.0, 18,true));
        restaurant2.addDish(new Dish("Dish 4", 18.0, 22,true));
        addRestaurant(restaurant1);
        addRestaurant(restaurant2);

    }

    // Method to get all available restaurants
    public List<Restaurant> getAllRestaurants() {
        return restaurants;
    }

    public Restaurant findByName(String restaurantName) {
        Restaurant restaurant = restaurants.stream()
                .filter(res -> res.getName().equals(restaurantName)).findFirst()
                .orElse(null);

        return restaurant;
    }

    public Dish findDishByName(Restaurant restaurant, String dishName) {

        // If restaurant is found, search for the dish within its menu
        for (Dish dish : restaurant.getMenu()) {
            if (dish.getName().equalsIgnoreCase(dishName)) {
                return dish;
            }
        }
        return null; // Return null if dish is not found
    }
}
