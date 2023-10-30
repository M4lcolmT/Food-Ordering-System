/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package food.ordering.system.VendorGUI;

import food.ordering.system.Review;

/**
 *
 * @author LENOVO
 */
public class vendorReview extends Review{
    private int vendorID;
    
    public vendorReview(int vendorID, String review, double rating) {
        super(review, rating);
        this.vendorID = vendorID;
    }
    
    public int getVendorID() {
        return vendorID;
    }
}
