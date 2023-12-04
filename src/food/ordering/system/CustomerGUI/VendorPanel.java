/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package food.ordering.system.CustomerGUI;

import food.ordering.system.Location;
import food.ordering.system.VendorGUI.FoodItem;
import food.ordering.system.VendorGUI.Vendor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class VendorPanel extends javax.swing.JPanel {
    private Vendor vendor;
    private Customer customer;
    private OrderMenu orderMenu;
    
    public VendorPanel(OrderMenu orderMenu, Vendor vendor, Customer customer) {
        initComponents();
        this.vendor = vendor;
        this.customer = customer;
        this.orderMenu = orderMenu;
        
        vendorName.setText(vendor.getName());
        vendorRating.setText(Double.toString((double) vendor.getRating()));
        vendorCategory.setText(vendor.getCategory());
        vendorAddress.setText(vendor.getCity());
        
        calculateDistance(customer.getCity().trim().toLowerCase(), vendor.getCity().trim().toLowerCase());
    }
    
    
    private void calculateDistance(String customerAddress, String vendorAddress) {
        Location customerLocation = Location.locationMap.get(customerAddress);
        Location vendorLocation = Location.locationMap.get(vendorAddress);

        if (customerLocation != null && vendorLocation != null) {
            double vendorDistance = Location.calculateDistance(customerLocation,vendorLocation);

            distance.setText(Double.toString((double)vendorDistance)+"km");
        } else {
            System.out.println("Unknown location");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     **/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        vendorName = new javax.swing.JLabel();
        star = new javax.swing.JLabel();
        vendorCategory = new javax.swing.JLabel();
        distance = new javax.swing.JLabel();
        vendorAddress = new javax.swing.JLabel();
        orderButton = new javax.swing.JButton();
        vendorRating = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(236, 236, 236), 1, true));
        jPanel1.setMaximumSize(new java.awt.Dimension(500, 100));
        jPanel1.setMinimumSize(new java.awt.Dimension(500, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 100));

        vendorName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        vendorName.setForeground(new java.awt.Color(51, 51, 51));
        vendorName.setText("Restaurant Name");

        star.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        star.setForeground(new java.awt.Color(51, 51, 51));
        star.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        star.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/star.png"))); // NOI18N

        vendorCategory.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        vendorCategory.setForeground(new java.awt.Color(51, 51, 51));
        vendorCategory.setText("Category");

        distance.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        distance.setForeground(new java.awt.Color(51, 51, 51));
        distance.setText("Distance from user");

        vendorAddress.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        vendorAddress.setForeground(new java.awt.Color(51, 51, 51));
        vendorAddress.setText("Location");

        orderButton.setBackground(new java.awt.Color(163, 213, 240));
        orderButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        orderButton.setForeground(new java.awt.Color(255, 255, 255));
        orderButton.setText("Order");
        orderButton.setPreferredSize(new java.awt.Dimension(72, 25));
        orderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderButtonActionPerformed(evt);
            }
        });

        vendorRating.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        vendorRating.setForeground(new java.awt.Color(51, 51, 51));
        vendorRating.setText("-");
        vendorRating.setPreferredSize(new java.awt.Dimension(15, 16));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(vendorAddress)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(star, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(vendorRating, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(distance)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(vendorCategory)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 252, Short.MAX_VALUE)
                                .addComponent(orderButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(vendorName)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(vendorName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(star, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vendorCategory)
                    .addComponent(orderButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vendorRating, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vendorAddress)
                    .addComponent(distance))
                .addGap(11, 11, 11))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void orderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderButtonActionPerformed
        List<FoodItem> basket = new ArrayList<>();
        Menu vendorMenu = new Menu(vendor, customer, basket);
        vendorMenu.setVisible(true);
        orderMenu.dispose();
    }//GEN-LAST:event_orderButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel distance;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton orderButton;
    private javax.swing.JLabel star;
    private javax.swing.JLabel vendorAddress;
    private javax.swing.JLabel vendorCategory;
    private javax.swing.JLabel vendorName;
    private javax.swing.JLabel vendorRating;
    // End of variables declaration//GEN-END:variables
}
