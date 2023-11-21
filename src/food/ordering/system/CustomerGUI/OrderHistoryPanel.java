/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package food.ordering.system.CustomerGUI;

import food.ordering.system.AdminGUI.ReadFiles;
import food.ordering.system.VendorGUI.FoodItem;
import food.ordering.system.VendorGUI.Vendor;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author jiasi
 */
public class OrderHistoryPanel extends javax.swing.JPanel {

    private Order order;
    private Customer customer;
    
    
    public OrderHistoryPanel(Order order, Customer customer) {
        initComponents();
        this.order = order;
        this.customer = customer;
        Vendor vendor = order.getVendor();       
        
        restoranField.setText(vendor.getName());
        totalPrice.setText(Double.toString(order.getTotalPrice()));
        LocalDateTime dateTime = order.getDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy, HH:mm");
        String formattedDateTime = dateTime.format(formatter);
        dateTimeField.setText(formattedDateTime);
    }
    
    private Order findOrder() {
        OrderManager orderManager = new OrderManager();
        List<Order> orders = orderManager.getOrders();
        
        for (Order orderItem : orders) {  
            if (orderItem.getOrderID() == order.getOrderID()) {
                System.out.println(orderItem.getOrderID());
                return orderItem;  
            } else {
                System.out.println("Order not found!");
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        dateTimeField = new javax.swing.JLabel();
        restoranField = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        totalPrice = new javax.swing.JLabel();
        reorderButton = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(680, 100));

        dateTimeField.setText("Date");

        restoranField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        restoranField.setText("Restauran Kam Lan");

        jLabel2.setText("Total:");

        totalPrice.setText("RM69.69");

        reorderButton.setText("Reorder");
        reorderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reorderButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalPrice)
                        .addGap(18, 18, 18)
                        .addComponent(dateTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(restoranField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
                .addComponent(reorderButton)
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(restoranField)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalPrice)
                    .addComponent(dateTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(reorderButton)
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void reorderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reorderButtonActionPerformed
        Order specificOrder = findOrder();
        Vendor vendor = specificOrder.getVendor(); 
        List<FoodItem> basket = specificOrder.getOrderBasket();
        
        Menu menu = new Menu(vendor, customer, basket);
        menu.setTotalPrice(specificOrder.getTotalPrice());
        menu.setBasket(basket);
        menu.updateItemCount();
        menu.totalPriceLabel.setText(Double.toString(specificOrder.getTotalPrice()));
        menu.setVisible(true);
        
        OrderSummary summary = new OrderSummary(specificOrder, basket);
        summary.loadBasketItems(basket);
    }//GEN-LAST:event_reorderButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dateTimeField;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton reorderButton;
    private javax.swing.JLabel restoranField;
    private javax.swing.JLabel totalPrice;
    // End of variables declaration//GEN-END:variables
}
