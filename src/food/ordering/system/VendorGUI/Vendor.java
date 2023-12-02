/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package food.ordering.system.VendorGUI;
import food.ordering.system.User;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import textFiles.TextFilePaths;

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
    
    TextFilePaths path = new TextFilePaths();
    String vendorTextFilePath = path.getVendorTextFile();
    
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
    
    private void saveVendor(List<Vendor> vendors) {
        // Filter and sort the data
        List<Vendor> filteredItems = vendors.stream()
                .collect(Collectors.toList());

        // Sort the filtered items by ID
        Collections.sort(filteredItems, Comparator.comparingInt(Vendor::getVendorID));

        // Update the file with the new runner status
        try (PrintWriter writer = new PrintWriter(new FileWriter(vendorTextFilePath))) {
            // Write each runner item to the file
            for (Vendor vendorItem : filteredItems) {
                writer.println(vendorItem.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void updateVendorRating(Vendor vendor, List<Vendor> vendors, double rating) {
        int vendorId = vendor.getVendorID();

        for (Vendor i : vendors) {
            if (vendorId == i.getVendorID()) {
                vendor.setRating(rating);
            }
        }
        saveVendor(vendors);
    }
    
    @Override
    public String toString() {
        String delimiter = ";";
        return vendorID + delimiter + super.toString() + delimiter + rating + delimiter + category + delimiter + city + delimiter + description + delimiter + operationHours + delimiter + operationDays;
    }
}
