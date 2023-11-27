/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package food.ordering.system.CustomerGUI;

import food.ordering.system.VendorGUI.FoodItem;
import food.ordering.system.VendorGUI.Vendor;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import textFiles.TextFilePaths;

/**
 *
 * @author LENOVO
 */
public class Order {
    private int orderID;
    private OrderType orderType;
    private Customer customer;
    private Vendor vendor;
    private List<FoodItem> orderBasket;
    private double totalPrice;
    private OrderStatus status;
    private LocalDateTime dateTime;
    
    TextFilePaths path = new TextFilePaths();
    String orderTextFilePath = path.getOrderTextFile();
    
    public enum OrderType  {
        DELIVERY,
        TAKEAWAY,
        DINEIN
    }
    
    public enum OrderStatus {
        PENDING,
        CONFIRMED,
        PREPARING,
        READY_FOR_PICKUP,
        OUT_FOR_DELIVERY,
        DELIVERED,
        CANCELLED
    }
    
    public Order(int orderID, OrderType orderType, Customer customer, Vendor vendor, List<FoodItem> orderBasket, double totalPrice, OrderStatus status, LocalDateTime dateTime) {
        this.orderID = orderID;
        this.orderType = orderType;
        this.customer = customer;
        this.vendor = vendor;
        this.orderBasket = orderBasket;
        this.totalPrice = totalPrice;
        this.status = status;
        this.dateTime = dateTime;
    }
    
    public int getOrderID() {
        return orderID;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
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
    
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
    
    public void updateOrderStatus(Order specificOrder, List<Order> orders, OrderStatus orderStatus) {
        int orderid = specificOrder.getOrderID();
        for (Order item : orders) {
            if (orderid == item.getOrderID()) {
                // Update the order status
                item.setStatus(orderStatus);
            }
        }

        // Filter and sort the data
        List<Order> filteredItems = orders.stream()
                .collect(Collectors.toList());

        // Sort the filtered items by ID
        Collections.sort(filteredItems, Comparator.comparingInt(Order::getOrderID));

        // Update the file with the new order status
        try (PrintWriter writer = new PrintWriter(new FileWriter(orderTextFilePath))) {
            // Write each food item to the file
            for (Order orderItem : filteredItems) {
                writer.println(orderItem.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    @Override
    public String toString() {
        String delimiter = ";";
        return orderID + delimiter + orderType + delimiter + customer.getCustomerID() + delimiter + vendor.getVendorID() + delimiter + serializeOrderBasket() + delimiter + totalPrice + delimiter + status + delimiter + dateTime;
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
