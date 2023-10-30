/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package food.ordering.system.VendorGUI;

/**
 *
 * @author LENOVO
 */
public class FoodItem {
    private int vendorID;
    private static int nextItemID = 1;
    private int itemID;
    private String itemName;
    private String itemCategory;
    private double itemPrice;
    private String itemDescription;
    
    public FoodItem(int vendorID, int itemID, String itemName, String itemCategory, double itemPrice, String itemDescription) {
        this.vendorID = vendorID;
        this.itemID = nextItemID++;
        this.itemName = itemName;
        this.itemCategory = itemCategory;
        this.itemPrice = itemPrice;
        this.itemDescription = itemDescription;
    }

    public int getItemID() {
        return itemID;
    }
    
    public int getVendorID() {
        return vendorID;
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
    
    @Override
    public String toString() {
        return "FoodItem{" + "vendorID=" + vendorID + ", itemID=" + itemID + ", itemName=" + itemName + ", itemCategory=" + itemCategory + ", itemPrice=" + itemPrice + ", itemDescription=" + itemDescription + '}';
    }
}
