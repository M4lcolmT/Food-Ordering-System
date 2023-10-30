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
    private static List<FoodItem> basket = new ArrayList<>();
    private static double totalPrice = 0.0;

    DecimalFormat df = new DecimalFormat("#.#");

    TextFilePaths path = new TextFilePaths();
    String vendorMenuFilePath = path.getVendorMenuTextFile();
    
    public Menu(Vendor vendor, Customer customer, List<FoodItem> basket) {
        initComponents();
        this.vendor = vendor;
        this.customer = customer;
        this.basket = basket;
        
        vendorName.setText(vendor.getName());
        vendorRating.setText(vendor.getRating()+" Ratings");
        readFoodItemsFromFile();
        populateInnerPanel(menu);
    }
    
    public void populateInnerPanel(List<FoodItem> menu) {
        innerScrollPanel.removeAll();
        for (FoodItem foodItem : menu) {
            FoodItemPanel foodItemPanel = new FoodItemPanel(foodItem, basket, this);
            innerScrollPanel.add(foodItemPanel);
        }
        // Repaint and revalidate innerPanel to reflect the changes
        innerScrollPanel.revalidate();
        innerScrollPanel.repaint();
    }
    
    public List<FoodItem> readFoodItemsFromFile() {
        menu.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader(vendorMenuFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 6) {
                    int vendorID = Integer.parseInt(parts[0]);
                    if (vendorID == vendor.getVendorID()) {
                        int itemID = Integer.parseInt(parts[1]);
                        String itemName = parts[2];
                        String itemCategory = parts[3];
                        Double itemPrice = Double.valueOf(parts[4]);
                        String itemDescription = parts[5];

                        FoodItem foodItem = new FoodItem(vendorID, itemID, itemName, itemCategory, itemPrice, itemDescription);
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
    
    public void updateItemCount() {
        int itemCount = basket.size();
        basketItemCount.setText(itemCount + " items");
    }
    
    public void updateTotalPrice(FoodItem foodItem) {
        double itemPrice = foodItem.getItemPrice();
        totalPrice = totalPrice + itemPrice;
        totalPriceLabel.setText(Double.toString(totalPrice));
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 400));

        vendorName.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        vendorName.setText("McDonald's");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel2.setText("Menu");

        vendorRating.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        vendorRating.setText("4.3 Rating");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        innerScrollPanel.setMinimumSize(new java.awt.Dimension(0, 0));
        innerScrollPanel.setLayout(new javax.swing.BoxLayout(innerScrollPanel, javax.swing.BoxLayout.PAGE_AXIS));
        jScrollPane1.setViewportView(innerScrollPanel);

        jButton1.setText("Reviews");

        confirmBasket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmBasketMouseClicked(evt);
            }
        });

        basketItemCount.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Basket  .");

        totalPriceLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        totalPriceLabel.setText("-");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("RM");

        javax.swing.GroupLayout confirmBasketLayout = new javax.swing.GroupLayout(confirmBasket);
        confirmBasket.setLayout(confirmBasketLayout);
        confirmBasketLayout.setHorizontalGroup(
            confirmBasketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(confirmBasketLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(basketItemCount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalPriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        confirmBasketLayout.setVerticalGroup(
            confirmBasketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(confirmBasketLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(confirmBasketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(basketItemCount)
                    .addComponent(totalPriceLabel)
                    .addComponent(jLabel3))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(vendorName)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(vendorRating))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
                    .addComponent(confirmBasket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(vendorName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(vendorRating)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(confirmBasket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
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
        Order order = new Order(0, customer, vendor, basket, totalPrice, OrderStatus.PENDING, false, 0);
        OrderSummary orderSummary = new OrderSummary(order, basket);
        orderSummary.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_confirmBasketMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel basketItemCount;
    private javax.swing.JPanel confirmBasket;
    private javax.swing.JPanel innerScrollPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel totalPriceLabel;
    private javax.swing.JLabel vendorName;
    private javax.swing.JLabel vendorRating;
    // End of variables declaration//GEN-END:variables
}
