/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package food.ordering.system.CustomerGUI;

import food.ordering.system.VendorGUI.FoodItem;
import food.ordering.system.VendorGUI.Vendor;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class Order {
    private static int nextOrderID = 1;
    private int orderID;
    private Customer customer;
    private Vendor vendor;
    private List<FoodItem> orderBasket;
    private double totalPrice;
    private boolean runnerAvailability;
    private int runnerID;
    private OrderStatus status;
    private LocalDateTime orderTime;
    
    public enum OrderStatus {
        PENDING,
        CONFIRMED,
        PREPARING,
        OUT_FOR_DELIVERY,
        DELIVERED,
        CANCELED
    }
    
    public Order(int orderID, Customer customer, Vendor vendor, List<FoodItem> orderBasket, double totalPrice, OrderStatus status, boolean runnerAvailability, int runnerID) {
        this.orderID = nextOrderID++;
        this.customer = customer;
        this.vendor = vendor;
        this.orderBasket = orderBasket;
        this.totalPrice = totalPrice;
        this.status = status;
        this.runnerAvailability = false;
        this.runnerID = runnerID;
        this.orderTime = LocalDateTime.now();
    }

    public static int getNextOrderID() {
        return nextOrderID;
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
    
    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }
    
    @Override
    public String toString() {
        return "Order{" + "orderID=" + orderID + ", customer=" + customer + ", vendor=" + vendor + ", orderBasket=" + orderBasket + ", totalPrice=" + totalPrice + ", runnerAvailability=" + runnerAvailability + ", runnerID=" + runnerID + ", status=" + status + ", orderTime=" + orderTime + '}';
    }
    
}
