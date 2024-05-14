package DeliveryManagement.entity;


import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private GeoLocation location;
    private int prepTime; // in minutes
    private List<Dish> menu;

    public Restaurant(String name, GeoLocation location, int prepTime) {
        this.name = name;
        this.location = location;
        this.prepTime = prepTime;
        this.menu = new ArrayList<>();
    }

    // Getters
    public String getName() {
        return name;
    }

    public GeoLocation getLocation() {
        return location;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public List<Dish> getMenu() {
        return menu;
    }

    // Method to add a dish to the menu
    public void addDish(Dish dish) {
        menu.add(dish);
    }
}