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
    private static int nextVendorID = 1;
    private int vendorID;
    private double rating;
    private String category;
    private String address;
    
    public Vendor(int vendorID, String name, String phoneNumber, String email, String password, double rating, String category, String address) {
        super(name, phoneNumber, email, password);
        this.vendorID = nextVendorID++;
        this.rating = rating;
        this.category = category;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
