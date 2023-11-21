/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package food.ordering.system.VendorGUI;

import java.util.Objects;
import textFiles.TextFilePaths;

/**
 *
 * @author LENOVO
 */
public class FoodItem {
    private int vendorID;
    private int itemID;
    private String itemName;
    private String itemCategory;
    private double itemPrice;
    private String itemDescription;
    private double itemCost;
    
    public FoodItem(int vendorID, int itemID, String itemName, String itemCategory, double itemPrice, String itemDescription, double itemCost) {
        this.vendorID = vendorID;
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemCategory = itemCategory;
        this.itemPrice = itemPrice;
        this.itemDescription = itemDescription;
        this.itemCost = itemCost;
    }

    public int getItemID() {
        return itemID;
    }
    
    public int getVendorID() {
        return vendorID;
    }
    
    public void setVendorID(int vendorID) {
        this.vendorID = vendorID;
    }
    
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public double getItemCost() {
        return itemCost;
    }

    public void setItemCost(double itemCost) {
        this.itemCost = itemCost;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FoodItem foodItem = (FoodItem) obj;
        return Objects.equals(itemName, foodItem.itemName) && Double.compare(foodItem.itemPrice, itemPrice) == 0;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(itemName, itemPrice);
    }
    
    @Override
    public String toString() {
        return vendorID + "=" + itemID + "=" + itemName + "=" + itemCategory + "=" + itemPrice + "=" + itemDescription + "=" + itemCost;
    }
}
