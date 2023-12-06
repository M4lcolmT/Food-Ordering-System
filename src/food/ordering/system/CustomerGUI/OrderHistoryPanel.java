/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package food.ordering.system.CustomerGUI;

import food.ordering.system.OrderManager;
import food.ordering.system.Order;
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
    private OrderHistory page;
    private OrderManager manager = new OrderManager();

    public OrderHistoryPanel(OrderHistory page, Order order, Customer customer) {
        initComponents();
        this.page = page;
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        dateTimeField = new javax.swing.JLabel();
        restoranField = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        totalPrice = new javax.swing.JLabel();
        reorderButton = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(236, 236, 236), 1, true));
        jPanel1.setPreferredSize(new java.awt.Dimension(680, 100));

        dateTimeField.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        dateTimeField.setText("Date");

        restoranField.setFont(new java.awt.Font("Ebrima", 1, 16)); // NOI18N
        restoranField.setText("Restauran Kam Lan");

        jLabel2.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        jLabel2.setText("Total:");

        totalPrice.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        totalPrice.setText("RM69.69");

        reorderButton.setBackground(new java.awt.Color(163, 213, 240));
        reorderButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        reorderButton.setForeground(new java.awt.Color(255, 255, 255));
        reorderButton.setText("Reorder");
        reorderButton.setPreferredSize(new java.awt.Dimension(100, 25));
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
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalPrice)
                        .addGap(18, 18, 18)
                        .addComponent(dateTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(restoranField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                .addComponent(reorderButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(restoranField)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalPrice)
                    .addComponent(dateTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(reorderButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        Order specificOrder = manager.findOrder(order.getOrderID());
    
        if (specificOrder != null) {
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
            page.dispose();
        }
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
