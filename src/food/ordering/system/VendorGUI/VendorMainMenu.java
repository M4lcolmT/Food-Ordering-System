/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package food.ordering.system.VendorGUI;

import food.ordering.system.CustomerGUI.Order;
import food.ordering.system.CustomerGUI.OrderManager;
import food.ordering.system.CustomerLogin;
import food.ordering.system.VendorLogin;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author LENOVO
 */
public class VendorMainMenu extends javax.swing.JFrame {
    private Vendor vendor;
    private List<Order> allOrders;

    public VendorMainMenu(Vendor vendor) {
        initComponents();
        this.vendor = vendor;
        
        OrderManager manager = new OrderManager();
        allOrders = manager.getOrders();
    }
    
    private List<Order> getVendorOrders() {
        List<Order> vendorOrders = new ArrayList<>();
        
        for (Order item : allOrders) {
            if (item.getVendor().getVendorID() == vendor.getVendorID()) {
                vendorOrders.add(item);
            }
        }
        return vendorOrders;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        foodMenuButton = new javax.swing.JButton();
        revenueDashboardButton = new javax.swing.JButton();
        orderHistoryButton = new javax.swing.JButton();
        notificationsButton = new javax.swing.JButton();
        profileButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        logOutButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jScrollPane1.setBackground(null);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 400));

        foodMenuButton.setBackground(null);
        foodMenuButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        foodMenuButton.setText("Menu");
        foodMenuButton.setPreferredSize(new java.awt.Dimension(150, 25));
        foodMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foodMenuButtonActionPerformed(evt);
            }
        });

        revenueDashboardButton.setBackground(null);
        revenueDashboardButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        revenueDashboardButton.setText("Revenue Dashboard");
        revenueDashboardButton.setPreferredSize(new java.awt.Dimension(150, 25));
        revenueDashboardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                revenueDashboardButtonActionPerformed(evt);
            }
        });

        orderHistoryButton.setBackground(null);
        orderHistoryButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        orderHistoryButton.setText("Order History");
        orderHistoryButton.setPreferredSize(new java.awt.Dimension(150, 25));
        orderHistoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderHistoryButtonActionPerformed(evt);
            }
        });

        notificationsButton.setBackground(null);
        notificationsButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        notificationsButton.setText("Notifications");
        notificationsButton.setPreferredSize(new java.awt.Dimension(150, 25));
        notificationsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notificationsButtonActionPerformed(evt);
            }
        });

        profileButton.setBackground(null);
        profileButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        profileButton.setText("Profile");
        profileButton.setPreferredSize(new java.awt.Dimension(100, 25));
        profileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        jLabel1.setText("Vendor Main Menu");

        logOutButton.setBackground(null);
        logOutButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        logOutButton.setText("Log Out");
        logOutButton.setPreferredSize(new java.awt.Dimension(150, 25));
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButtonActionPerformed(evt);
            }
        });

        jButton1.setBackground(null);
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("View Orders");
        jButton1.setPreferredSize(new java.awt.Dimension(150, 25));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(profileButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(notificationsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(revenueDashboardButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(orderHistoryButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(foodMenuButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(logOutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(jLabel1)))
                .addContainerGap(258, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(profileButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(foodMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(notificationsButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(revenueDashboardButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(orderHistoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(logOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
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

    private void orderHistoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderHistoryButtonActionPerformed
        VendorOrderHistory h = new VendorOrderHistory(vendor);
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_orderHistoryButtonActionPerformed

    private void revenueDashboardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_revenueDashboardButtonActionPerformed
        RevenueDashboard dashboard = new RevenueDashboard(vendor);
        dashboard.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_revenueDashboardButtonActionPerformed

    private void profileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileButtonActionPerformed
        VendorUserProfile page = new VendorUserProfile(vendor);
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_profileButtonActionPerformed

    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutButtonActionPerformed
        int confirmationResult = JOptionPane.showConfirmDialog(this, "Proceed to log out", "Log Out Confirmation", JOptionPane.YES_NO_OPTION);        

        if (confirmationResult == JOptionPane.YES_OPTION) {
            VendorLogin page = new VendorLogin();
            page.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_logOutButtonActionPerformed

    private void foodMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_foodMenuButtonActionPerformed
        FoodItemMenu page = new FoodItemMenu(vendor);
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_foodMenuButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        List<Order> vendorOrders = getVendorOrders();
        
        if (vendorOrders.isEmpty()) {
            JOptionPane.showMessageDialog(this, "You have no orders.");
        } else {
            ViewOrders page = new ViewOrders(vendor, vendorOrders);
            page.setVisible(true);
            this.dispose();
            allOrders.clear();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void notificationsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notificationsButtonActionPerformed
        VendorNotification page = new VendorNotification(vendor);
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_notificationsButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton foodMenuButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton logOutButton;
    private javax.swing.JButton notificationsButton;
    private javax.swing.JButton orderHistoryButton;
    private javax.swing.JButton profileButton;
    private javax.swing.JButton revenueDashboardButton;
    // End of variables declaration//GEN-END:variables
}
