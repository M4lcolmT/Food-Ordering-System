/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package food.ordering.system;

import food.ordering.system.CustomerGUI.Customer;
import food.ordering.system.Order.OrderType;
import food.ordering.system.RunnerGUI.Task;
import food.ordering.system.VendorGUI.FoodItem;
import food.ordering.system.VendorGUI.Vendor;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import textFiles.TextFilePaths;

/**
 *
 * @author LENOVO
 */
public class OrderManager {
    private Customer customer;
    private Vendor vendor;
    
    TextFilePaths filePaths = new TextFilePaths();
    String orderTextFilePath = filePaths.getOrderTextFile();
    String customerTextFilePath = filePaths.getCustomerTextFile();
    String vendorTextFilePath = filePaths.getVendorTextFile();
    String tasksTextFilePath = filePaths.getRunnerTasksTextFile();
    
    //Parsing the customer based on the order customer ID
    public Customer parseOrderCustomer(int orderCustomerID) {
        try (BufferedReader reader = new BufferedReader(new FileReader(customerTextFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 8) {
                    int id = Integer.parseInt(parts[0]);
                    if (orderCustomerID == id) {
                        String name = parts[1];
                        String phoneNumber = parts[2];
                        String email = parts[3];
                        String password = parts[4];
                        String streetAddress = parts[5];
                        String city = parts[6];
                        double credit = Double.parseDouble(parts[7]);

                        Customer customerItem = new Customer(id, name, phoneNumber, email, password, streetAddress, city, credit);
                        customer = customerItem;
                    }
                } else {
                    System.out.println("Order Customer: Skipping a line with an incorrect number of parts");
                }
            }
        } catch (IOException e) {
            // Handle the exception, e.g., log or display an error message
            e.printStackTrace();
        }
        return customer;
    }
    
    //Parsing the vendor based on the order's vendorID
    public Vendor parseOrderVendor(int orderVendorID) {
        try (BufferedReader reader = new BufferedReader(new FileReader(vendorTextFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 11) {
                    int id = Integer.parseInt(parts[0]);
                    if (orderVendorID == id) {
                        String name = parts[1];
                        String phoneNumber = parts[2];
                        String email = parts[3];
                        String password = parts[4];
                        double rating = Double.parseDouble(parts[5]);
                        String category = parts[6];
                        String address = parts[7];
                        String description = parts[8];
                        String operationHours = parts[9];
                        String operationDays = parts[10];

                        Vendor vendorItem = new Vendor(id, name, phoneNumber, email, password, rating, category, address, description, operationHours,operationDays);
                        vendor = vendorItem;
                    }
                } else {
                    System.out.println("Order Vendor: Skipping a line with an incorrect number of parts");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vendor;
    }
    
    //Parsing the order basket 
    public List<FoodItem> parseOrderBasket(String orderBasketString) {
        String[] foodItemStrings = orderBasketString.split("\\|");

        List<FoodItem> foodItems = new ArrayList<>();
        for (String foodItemString : foodItemStrings) {
            FoodItem foodItem = deserializeFoodItemString(foodItemString);
            foodItems.add(foodItem);
        }

        return foodItems;
    }

    // Deserialize a custom format string to a FoodItem
    public FoodItem deserializeFoodItemString(String foodItem) {
        // Split the custom format string into attribute parts
        String[] parts = foodItem.split("=");
        int vendorID = Integer.parseInt(parts[0]);
        int itemID = Integer.parseInt(parts[1]);
        String itemName = parts[2];
        String itemCategory = parts[3];
        double itemPrice = Double.parseDouble(parts[4]);
        String itemDescription = parts[5];
        double itemCost = Double.parseDouble(parts[6]);

        return new FoodItem(vendorID, itemID, itemName, itemCategory, itemPrice, itemDescription, itemCost);
    }

    //Parsing date and time
    private LocalDateTime parseDateTime(String data) {
        LocalDateTime formattedDateTime = LocalDateTime.parse(data, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS"));
        return formattedDateTime;
    }
    
    //Returning orders
    public List<Order> getOrders() {
        List<Order> orders = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(orderTextFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 8) {
                    int id = Integer.parseInt(parts[0]);
                    OrderType orderType = OrderType.valueOf(parts[1].toUpperCase());
                    Customer orderCustomer = parseOrderCustomer(Integer.parseInt(parts[2]));
                    Vendor orderVendor = parseOrderVendor(Integer.parseInt(parts[3]));
                    List<FoodItem> basket = parseOrderBasket(parts[4]);
                    double orderTotalPrice = Double.parseDouble(parts[5]);
                    Order.OrderStatus orderStatus = Order.OrderStatus.valueOf(parts[6]);
                    LocalDateTime orderDateTime = parseDateTime(parts[7]);

                    Order newOrder = new Order(id, orderType, orderCustomer, orderVendor, basket, orderTotalPrice, orderStatus, orderDateTime);
                    orders.add(newOrder);
                } else {
                    System.out.println("Order Manager - order: Skipping a line with an incorrect number of parts: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + orderTextFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("orders: "+orders.size());
        return orders;
    }
    
    public Order findOrder(int orderID) {
        for (Order item : getOrders()) {
            if (item.getOrderID() == orderID) {
                return item;
            }
        }
        System.out.println("null order");
        return null;
    }
    
    public void writeTasksToFile(List<Task> tasks) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(tasksTextFilePath))) {
            for (Task item : tasks) {
                writer.println(item.toString());
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately (e.g., show an error message)
        }
    }
    
    public void writeOrdersToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(orderTextFilePath))) {
            for (Order item : getOrders()) {
                writer.println(item.toString());
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately (e.g., show an error message)
        }
    }
    
    public void saveUpdatedCustomerInfo(Customer customer) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(customerTextFilePath));
            for (int i = 0; i < lines.size(); i++) {
                String[] parts = lines.get(i).split(";");
                int id = Integer.parseInt(parts[0]);
                if (id == customer.getCustomerID()) {
                    // Update the address and city for the matching customer
                    lines.set(i, customer.getCustomerID() + ";" + customer.getName() + ";" + customer.getPhoneNumber() + ";" + customer.getEmail() + ";" + customer.getPassword() + ";" + customer.getStreetAddress() + ";" + customer.getCity() + ";" + customer.getCredit());
                    break;
                }
            }
            Files.write(Paths.get(customerTextFilePath), lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


