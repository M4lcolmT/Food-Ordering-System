/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package food.ordering.system.VendorGUI;
import food.ordering.system.User;

/**
 *
 * @author LENOVO
 */
public class Vendor extends User{
    private int vendorID;
    private double rating;
    private String category;
    private String city;
    private String description;
    private String operationHours;
    private String operationDays;
    
    public Vendor(int vendorID, String name, String phoneNumber, String email, String password, double rating, String category, String city, String description, String operationHours, String operationDays) {
        super(name, phoneNumber, email, password);
        this.vendorID = vendorID;
        this.rating = rating;
        this.category = category;
        this.city = city;
        this.description = description;
        this.operationHours = operationHours;
        this.operationDays = operationDays;
    }
    
    public int getVendorID() {
        return vendorID;
    }
    
    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOperationHours() {
        return operationHours;
    }

    public void setOperationHours(String operationHours) {
        this.operationHours = operationHours;
    }

    public String getOperationDays() {
        return operationDays;
    }

    public void setOperationDays(String operationDays) {
        this.operationDays = operationDays;
    }
}
