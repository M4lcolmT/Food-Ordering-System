/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package food.ordering.system;

import food.ordering.system.CustomerGUI.Customer;
import food.ordering.system.VendorGUI.FoodItem;
import food.ordering.system.VendorGUI.Vendor;
import food.ordering.system.VendorGUI.vendorReview;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class test {
    private Vendor vendor;
    
    
    public test(Vendor vendor){
        this.vendor = vendor;
    }
    
    public List<vendorReview> readReviewsFromFile(String filePath) {
        List<vendorReview> vendorReviews = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 3) {
                    int vendorID = parts[0];
                    String review = parts[1];
                    double ratings = parts[2];
                    if (vendor.getVendorID() == vendorID) {
                        vendorReview vendorReview = new vendorReview(vendorID, review, ratings);
                        vendorReviews.add(vendorReview);
                    }

                    
                } else {
                    System.out.println("Skipping a line with an incorrect number of parts");
                }
            }
        } catch (IOException e) {
            // Handle the exception, e.g., log or display an error message
            e.printStackTrace();
        }
        return vendorReviews;
    }
    
    private void loadBasketItems(List<vendorReview> reviews) {
        DefaultTableModel model = (DefaultTableModel) reviewTable.getModel();

        for (vendorReview review: reviews) {
            Object[] rowData = {review, rating };
            model.addRow(rowData);
        }
    }
}
