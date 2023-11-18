/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package food.ordering.system.CustomerGUI;

import food.ordering.system.VendorGUI.FoodItem;
import food.ordering.system.VendorGUI.Vendor;
import java.time.LocalDateTime;
import java.util.List;
import java.util.StringJoiner;

/**
 *
 * @author LENOVO
 */
public class Order {
    private int orderID;
    private Customer customer;
    private Vendor vendor;
    private List<FoodItem> orderBasket;
    private double totalPrice;
    private boolean runnerAvailability;
    private int runnerID;
    private OrderStatus status;
    private LocalDateTime dateTime;
    
    public enum OrderStatus {
        PENDING,
        CONFIRMED,
        PREPARING,
        OUT_FOR_DELIVERY,
        DELIVERED,
        CANCELED
    }
    
    public Order(int orderID, Customer customer, Vendor vendor, List<FoodItem> orderBasket, double totalPrice, OrderStatus status, boolean runnerAvailability, int runnerID, LocalDateTime dateTime) {
        this.orderID = orderID;
        this.customer = customer;
        this.vendor = vendor;
        this.orderBasket = orderBasket;
        this.totalPrice = totalPrice;
        this.status = status;
        this.runnerAvailability = false;
        this.runnerID = runnerID;
        this.dateTime = dateTime;
    }
    
    public int getOrderID() {
        return orderID;
    }
    
    public Customer getCustomer() {
        return customer;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public List<FoodItem> getOrderBasket() {
        return orderBasket;
    }
    
    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public boolean isRunnerAvailability() {
        return runnerAvailability;
    }

    public void setRunnerAvailability(boolean runnerAvailability) {
        this.runnerAvailability = runnerAvailability;
    }

    public int getRunnerID() {
        return runnerID;
    }
    
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
    
    @Override
    public String toString() {
        String delimiter = ";";
        return orderID + delimiter + customer.getCustomerID() + delimiter + vendor.getVendorID() + delimiter + serializeOrderBasket() + delimiter + totalPrice + delimiter + status + delimiter + runnerAvailability + delimiter + runnerID +  delimiter + dateTime;
    }

    // Serialize the order basket to a string
    private String serializeOrderBasket() {
        // Convert the list of FoodItems to a string format, e.g., [item1, item2, item3]
        StringJoiner joiner = new StringJoiner("|");
        for (FoodItem item : orderBasket) {
            joiner.add(item.toString());
        }
        return joiner.toString();
    }
}
