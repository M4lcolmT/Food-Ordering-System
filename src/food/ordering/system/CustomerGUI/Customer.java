/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package food.ordering.system.CustomerGUI;

import food.ordering.system.CustomerGUI.Order.OrderStatus;
import food.ordering.system.CustomerGUI.Order.OrderType;
import food.ordering.system.User;
import food.ordering.system.VendorGUI.FoodItem;
import food.ordering.system.VendorGUI.Vendor;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import textFiles.TextFilePaths;

/**
 *
 * @author LENOVO
 */
public class Customer extends User{
    private int customerID;
    private String city;
    private String streetAddress;
    private List<Order> orders = new ArrayList<>();
    
    TextFilePaths filePaths = new TextFilePaths();
    String orderTextFilePath = filePaths.getOrderTextFile();
 
    public Customer (int customerID, String name, String phoneNumber, String email, String password, String streetAddress, String city){
        super(name, phoneNumber, email, password);
        this.customerID = customerID;
        this.streetAddress = streetAddress;
        this.city = city;
    }
    
    public List<Order> getOrders() {
        return orders;
    }
    
    public int checkMaxID(List<Order> orders) {
        int maxID = 0;
        for (Order order : orders) {
            if (order.getOrderID() > maxID) {
                maxID = order.getOrderID();
            }
        }
        // Increment the maximum ID
        return maxID + 1;
    }
    
    // Create a new order instance
    public void placeOrder(OrderType orderType, List<Order> orders, Vendor vendor, List<FoodItem> orderBasket, double totalPrice, OrderStatus status, boolean runnerAvailability, int runnerID) {
        LocalDateTime originalDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
        String formattedDateTimeStr = originalDateTime.format(formatter);
        LocalDateTime parsedDateTime = LocalDateTime.parse(formattedDateTimeStr, formatter);
        
        int newOrderID = checkMaxID(orders);
        Order newOrder = new Order(newOrderID, orderType, this, vendor, orderBasket, totalPrice, status, runnerAvailability, runnerID, parsedDateTime);

        orders.add(newOrder);
        saveOrder(newOrder);
    }
    
    // Save order into text file
    private void saveOrder(Order newOrder) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(orderTextFilePath, true))) {
            pw.println(newOrder.toString());
        } catch (IOException ex) {
            System.out.println("Failed to save!");
        }
    }

    public int getCustomerID() {
        return customerID;
    }
    
    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }
    
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        String delimiter = ";";
        return customerID + delimiter + super.toString() + delimiter + streetAddress + delimiter + city;
    }
}
