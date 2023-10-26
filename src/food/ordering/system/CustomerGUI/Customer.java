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
    private String address;
    
    public Customer (int customerID, String name, String phoneNumber, String email, String password, String address){
        super(name, phoneNumber, email, password);
        this.customerID = nextCustomerID++;
        this.address = address;
    }
    
    public int getCustomerID() {
        return customerID;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
