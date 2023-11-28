/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package food.ordering.system.CustomerGUI;

import food.ordering.system.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class Customer extends User{
    private int customerID;
    private String city;
    private String streetAddress;
    private List<Order> orders = new ArrayList<>();
 
    public Customer (int customerID, String name, String phoneNumber, String email, String password, String streetAddress, String city){
        super(name, phoneNumber, email, password);
        this.customerID = customerID;
        this.streetAddress = streetAddress;
        this.city = city;
    }
    
    public List<Order> getOrders() {
        return orders;
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
