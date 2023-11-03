/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package food.ordering.system.VendorGUI;
import food.ordering.system.User;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import textFiles.TextFilePaths;

/**
 *
 * @author LENOVO
 */
public class Vendor extends User{
    private int vendorID;
    private double rating;
    private String category;
    private String address;
    TextFilePaths path = new TextFilePaths();
    String vendorTextFilePath = path.getVendorTextFile();
    List<Vendor> vendors;
    
    public Vendor(int vendorID, String name, String phoneNumber, String email, String password, double rating, String category, String address) {
        super(name, phoneNumber, email, password);
        this.vendorID = vendorID;
        this.rating = rating;
        this.category = category;
        this.address = address;
    }

    public List<Vendor> readVendorsFromFile() {
        vendors.clear();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(vendorTextFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 8) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String phoneNumber = parts[2];
                    String email = parts[3];
                    String password = parts[4];
                    double rating = Double.parseDouble(parts[5]);
                    String category = parts[6];
                    String address = parts[7];

                    Vendor vendor = new Vendor(id, name, phoneNumber, email, password, rating, category, address);
                    vendors.add(vendor);
                } else {
                    System.out.println("Incomplete vendor data!");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return vendors;
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
