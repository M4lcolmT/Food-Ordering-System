/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package food.ordering.system.CustomerGUI;

import food.ordering.system.User;

/**
 *
 * @author LENOVO
 */
public class Customer extends User{
    private static int nextCustomerID = 1;
    private int customerID;
    private String city;
    private String streetAddress;

    public Customer (int customerID, String name, String phoneNumber, String email, String password, String streetAddress, String city){
        super(name, phoneNumber, email, password);
        this.customerID = nextCustomerID++;
        this.streetAddress = streetAddress;
        this.city = city;
    }
    
    public static int getNextCustomerID() {
        return nextCustomerID;
    }

    public static void setNextCustomerID(int nextCustomerID) {
        Customer.nextCustomerID = nextCustomerID;
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
