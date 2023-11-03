/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package food.ordering.system.CustomerGUI;

/**
 *
 * @author LENOVO
 */
import food.ordering.system.VendorGUI.FoodItem;
import java.util.ArrayList;
import java.util.List;

public class BasketManager {
    private static BasketManager instance;
    private List<FoodItem> basket;

    private BasketManager() {
        basket = new ArrayList<>();
    }

    public static BasketManager getInstance() {
        if (instance == null) {
            instance = new BasketManager();
        }
        return instance;
    }

    public List<FoodItem> getBasket() {
        return basket;
    }

    public void addToBasket(FoodItem item) {
        basket.add(item);
    }

    public void removeFromBasket(FoodItem item) {
        basket.remove(item);
    }

    public int calculateQuantity(FoodItem targetItem) {
        int count = 0;
        for (FoodItem item : basket) {
            if (item.getItemID() == targetItem.getItemID()) {
                count++;
            }
        }
        return count;
    }
}

