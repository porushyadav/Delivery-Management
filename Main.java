import DeliveryManagement.DataManager;
import DeliveryManagement.entity.*;
import DeliveryManagement.exceptionUtil.NotFoundException;
import DeliveryManagement.model.Graph;
import DeliveryManagement.service.*;

import java.util.*;


public class Main {
    public static void main(String[] args) throws NotFoundException {
        // Create an instance of DataManager
        DataManager dataManager = new DataManager();
        CustomerManager customerManager = new CustomerManager();
        RestaurantManager restaurantManager = new RestaurantManager();
        OrderManager orderManager = new OrderManager();

        Scanner scanner = new Scanner(System.in);

        int totalCustomers = 2;
        while (totalCustomers > 0) {
            System.out.println("Enter Mobile Number / Login");
            String mobile = scanner.next();
            Customer customer = customerManager.findByMobile(mobile);
            if (customer == null) {
                System.out.println("Customer Not Found");
                throw new NotFoundException("Customer Not Found");
            }

            System.out.println("Select Dishes from Restaurant (Enter 'done' to finish)");

            // Get the restaurant name from the user
            System.out.print("Restaurant: ");
            String restaurantName = scanner.next();
            Restaurant restaurant = restaurantManager.findByName(restaurantName);
            if (restaurant == null) {
                System.out.println("Restaurant Not Found");
                throw new NotFoundException("Restaurant Not Found");
            }

            // List to store selected dishes
            List<Dish> selectedDishes = new ArrayList<>();

            // Loop to allow user to select multiple dishes
            while (true) {
                System.out.print("Dish: ");
                String dishName = scanner.next();
                //Selection Completed
                if (dishName.equals("done")) {
                    break;
                }

                Dish dish = restaurantManager.findDishByName(restaurant, dishName);
                if (dish == null) {
                    System.out.println("Dish Not Found");
                    throw new NotFoundException("Dish Not Found");
                }

                selectedDishes.add(dish);
            }

            orderManager.placeOrder(selectedDishes, restaurant, customer);
            System.out.println("Order placed for selected dishes.");
            totalCustomers--;
        }


        orderManager.startPreparation();

    }

    }
