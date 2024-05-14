package DeliveryManagement.entity;

public class Dish {
    private String name;
    private double price; // Price of the dish in USD
    private int prepTime; // Preparation time for the dish in minutes
    private boolean available; // Availability of the dish

    public Dish(String name, double price, int prepTime, boolean available) {
        this.name = name;
        this.price = price;
        this.prepTime = prepTime;
        this.available = available;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public boolean isAvailable() {
        return available;
    }
}