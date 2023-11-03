/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package food.ordering.system.CustomerGUI;

import food.ordering.system.CustomerGUI.Order.OrderStatus;
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
    
    public void setOrders(List<Order> allOrders) {
        this.orders =  allOrders;
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
    
    public void placeOrder(List<Order> orders, Vendor vendor, List<FoodItem> orderBasket, OrderStatus status) {
        double totalPrice = calculateTotalPrice(orderBasket);
        LocalDateTime originalDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
        String formattedDateTimeStr = originalDateTime.format(formatter);
        LocalDateTime parsedDateTime = LocalDateTime.parse(formattedDateTimeStr, formatter);
        
        int newOrderID = checkMaxID(orders);
        Order newOrder = new Order(newOrderID, this, vendor, orderBasket, totalPrice, status, false, 0, parsedDateTime);
        
        orders.add(newOrder);
        saveOrder(newOrder);
    }

    private double calculateTotalPrice(List<FoodItem> orderBasket) {
        double totalPrice = 0.0;
        for (FoodItem item : orderBasket) {
            totalPrice += item.getItemPrice();
        }
        return totalPrice;
    }

    private boolean saveOrder(Order newOrder) {
        boolean success = false;
        try (PrintWriter pw = new PrintWriter(new FileWriter(orderTextFilePath, true))) {
            pw.println(newOrder.toString());
            success = true;
        } catch (IOException ex) {
            success = false;
        }
        return success;
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
}
