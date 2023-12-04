/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package food.ordering.system.CustomerGUI;

import food.ordering.system.UserRequest;

/**
 *
 * @author LENOVO
 */
public class CustomerRequest extends UserRequest{
    private String city;
    
    public CustomerRequest(int userRequestID, int userID, UserType userType, RequestType requestType, String name, String phoneNumber, String email, String password, String address, String city) {
        super(userRequestID, userID, userType, requestType, name, phoneNumber, email, password, address);
        this.city = city;
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
        return super.toString() + delimiter + city;
    }
    
}
