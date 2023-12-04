/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package food.ordering.system.CustomerGUI;

import food.ordering.system.CustomerGUI.Order.OrderStatus;
import food.ordering.system.VendorGUI.Vendor;
import food.ordering.system.VendorGUI.FoodItem;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import textFiles.TextFilePaths;

/**
 *
 * @author LENOVO
 */
public class Menu extends javax.swing.JFrame {
    private Vendor vendor;
    private Customer customer;
    private List<FoodItem> menu = new ArrayList<>();
    private List<FoodItem> basket = new ArrayList<>();
    private FoodItem foodItem;
    public static double totalPrice = 0.0;
    public static int basketCount = 0;
    private List<Order> orders;
    private final OrderManager manager = new OrderManager();

    DecimalFormat df = new DecimalFormat("#.#");

    TextFilePaths path = new TextFilePaths();
    String vendorMenuFilePath = path.getVendorMenuTextFile();
    
    public Menu(Vendor vendor, Customer customer, List<FoodItem> basket) {
        initComponents();
        this.vendor = vendor;
        this.customer = customer;
        this.basket = basket;
        
        vendorName.setText(vendor.getName());
        vendorRating.setText(Double.toString(vendor.getRating()));
        readFoodItemsFromFile();
        populateInnerPanel(menu);
        checkEmptyBasket();
        orders = manager.getOrders();
    }
    
    public String showName(){
        return vendor.getName();
    }
    
    private List<FoodItem> readFoodItemsFromFile() {
        menu.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader(vendorMenuFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length == 7) {
                    int vendorID = Integer.parseInt(parts[0]);
                    if (vendorID == vendor.getVendorID()) {
                        int itemID = Integer.parseInt(parts[1]);
                        String itemName = parts[2];
                        String itemCategory = parts[3];
                        Double itemPrice = Double.valueOf(parts[4]);
                        String itemDescription = parts[5];
                        Double itemCost = Double.valueOf(parts[6]);

                        foodItem = new FoodItem(vendorID, itemID, itemName, itemCategory, itemPrice, itemDescription, itemCost);
                        menu.add(foodItem);
                    }
                } else {
                    System.out.println("Skipping a line with an incorrect number of parts: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + vendorMenuFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return menu;
    }
    
    private void populateInnerPanel(List<FoodItem> menu) {
        innerScrollPanel.removeAll();
        for (FoodItem item : menu) {
            FoodItemPanel foodItemPanel = new FoodItemPanel(item, basket, this);
            innerScrollPanel.add(foodItemPanel);
        }
        // Repaint and revalidate innerPanel to reflect the changes
        innerScrollPanel.revalidate();
        innerScrollPanel.repaint();
    }
    
    public void setBasket(List<FoodItem> bask) {
        basket = bask;
    }
    
    public void checkEmptyBasket() {
        basketCount = basket.size();
        if (basketCount != 0) {
            confirmBasket.setVisible(true);
        } else {
            confirmBasket.setVisible(false);
        }
    }
    
    public void updateItemCount() {
        basketCount = basket.size();
        System.out.println("Updated item count: "+basketCount);
        basketItemCount.setText(basketCount + " items");
    }
    
    public void increaseTotalPrice(FoodItem foodItem) {
        double itemPrice = foodItem.getItemPrice();
        totalPrice = totalPrice + itemPrice;
        totalPriceLabel.setText(Double.toString(totalPrice));
    }
    
    public void decreaseTotalPrice(FoodItem foodItem) {
        double itemPrice = foodItem.getItemPrice();
        totalPrice = totalPrice - itemPrice;
        totalPriceLabel.setText(Double.toString(totalPrice));
    }
    
    // When customer reorder, to set the total price from the order chosen
    public void setTotalPrice(double total) {
        totalPrice = total;
    }
    
    public void resetTotalPrice() {
        totalPrice = 0;
    }
    
    private int checkMaxOrderID() {
        int maxID = 0;
        for (Order i : orders) {
            if (i.getOrderID() > maxID) {
                maxID = i.getOrderID();
            }
        }
        // Increment the maximum ID
        return maxID + 1;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        vendorName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        vendorRating = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        innerScrollPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        confirmBasket = new javax.swing.JPanel();
        basketItemCount = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        totalPriceLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 400));

        vendorName.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        vendorName.setText("McDonald's");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel2.setText("Menu");

        vendorRating.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        vendorRating.setText("4.3");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        innerScrollPanel.setMinimumSize(new java.awt.Dimension(0, 0));
        innerScrollPanel.setLayout(new javax.swing.BoxLayout(innerScrollPanel, javax.swing.BoxLayout.PAGE_AXIS));
        jScrollPane1.setViewportView(innerScrollPanel);

        jButton1.setBackground(new java.awt.Color(163, 213, 240));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Reviews");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        confirmBasket.setBackground(new java.awt.Color(163, 213, 240));
        confirmBasket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmBasketMouseClicked(evt);
            }
        });

        basketItemCount.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        basketItemCount.setForeground(new java.awt.Color(255, 255, 255));
        basketItemCount.setText("-");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Basket  .");

        totalPriceLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        totalPriceLabel.setForeground(new java.awt.Color(255, 255, 255));
        totalPriceLabel.setText("-");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("RM");

        javax.swing.GroupLayout confirmBasketLayout = new javax.swing.GroupLayout(confirmBasket);
        confirmBasket.setLayout(confirmBasketLayout);
        confirmBasketLayout.setHorizontalGroup(
            confirmBasketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(confirmBasketLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addComponent(basketItemCount, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 344, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(6, 6, 6)
                .addComponent(totalPriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        confirmBasketLayout.setVerticalGroup(
            confirmBasketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(confirmBasketLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(confirmBasketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(basketItemCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalPriceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/star.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vendorName))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vendorRating))
                    .addComponent(jScrollPane1)
                    .addComponent(confirmBasket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(vendorName)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(vendorRating, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(confirmBasket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmBasketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmBasketMouseClicked
        Order order = new Order(checkMaxOrderID(), Order.OrderType.DELIVERY, customer, vendor, basket, totalPrice, OrderStatus.PENDING, LocalDateTime.now());
        OrderSummary orderSummary = new OrderSummary(order, basket);
        orderSummary.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_confirmBasketMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        VendorReviews page = new VendorReviews(this, vendor);
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        OrderMenu page = new OrderMenu(customer);
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel10MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel basketItemCount;
    private javax.swing.JPanel confirmBasket;
    public javax.swing.JPanel innerScrollPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel totalPriceLabel;
    private javax.swing.JLabel vendorName;
    private javax.swing.JLabel vendorRating;
    // End of variables declaration//GEN-END:variables
}
