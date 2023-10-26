/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package food.ordering.system.CustomerGUI;

import food.ordering.system.VendorGUI.FoodItem;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class Order {
    private static int nextOrderID = 1;
    private int orderID;
    private int customerID;
    private int vendorID;
    private List<FoodItem> orderBasket;
    private boolean runnerAvailability;
    private int runnerID;
    private OrderStatus status;
    
    public enum OrderStatus {
    PENDING,
    CONFIRMED,
    PREPARING,
    OUT_FOR_DELIVERY,
    DELIVERED,
    CANCELED
    }
    
    public Order(int orderID, int customerID, int vendorID, List<FoodItem> orderBasket, OrderStatus status, boolean runnerAvailability, int runnerID) {
        this.orderID = nextOrderID++;
        this.customerID = customerID;
        this.vendorID = vendorID;
        this.orderBasket = new ArrayList<>();
        this.status = status;
        this.runnerAvailability = false;
        this.runnerID = runnerID;
    }

    public static int getNextOrderID() {
        return nextOrderID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getVendorID() {
        return vendorID;
    }

    public void setVendorID(int vendorID) {
        this.vendorID = vendorID;
    }

    public List<FoodItem> getOrderBasket() {
        return orderBasket;
    }

    public void setOrderBasket(List<FoodItem> orderBasket) {
        this.orderBasket = orderBasket;
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

    public void setRunnerID(int runnerID) {
        this.runnerID = runnerID;
    }
}
