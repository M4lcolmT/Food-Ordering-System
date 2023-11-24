/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package food.ordering.system.CustomerGUI;

import food.ordering.system.CustomerLogin;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class CustomerMainMenu extends javax.swing.JFrame {
    private Customer customer;
    private List<Order> allOrders = new ArrayList<>();

    
    public CustomerMainMenu(Customer customer) {
        initComponents();
        this.customer = customer;
        
        OrderManager orderManager = new OrderManager();
        allOrders = orderManager.getOrders();
        orderNotificationPanel.setVisible(false);
    }

    private List<Order> retrieveCustomerOrders() {
        List<Order> custOrders = new ArrayList<>();
        
        if (allOrders != null) {
            for (Order item : allOrders) {
                if (customer.getCustomerID() == item.getCustomer().getCustomerID()) {
                    custOrders.add(item);
                }
            }
        } else {
            System.out.println("Empty order list.");
        }
        return custOrders;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        orderFoodButton = new javax.swing.JButton();
        topUpButton = new javax.swing.JButton();
        notificationButton = new javax.swing.JButton();
        orderNotificationPanel = new javax.swing.JPanel();
        orderStatusLabel = new javax.swing.JLabel();
        orderETA = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        orderHistoryButton = new javax.swing.JButton();
        profileButton = new javax.swing.JButton();
        logOutButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 400));

        orderFoodButton.setText("Order Food");
        orderFoodButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderFoodButtonActionPerformed(evt);
            }
        });

        topUpButton.setText("Top Up");
        topUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topUpButtonActionPerformed(evt);
            }
        });

        notificationButton.setText("Notifications");

        orderStatusLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        orderStatusLabel.setText("Order is on the way!");

        orderETA.setText("Estimated time for arrival: 5mins");

        jButton4.setText("View");
        jButton4.setPreferredSize(new java.awt.Dimension(72, 30));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout orderNotificationPanelLayout = new javax.swing.GroupLayout(orderNotificationPanel);
        orderNotificationPanel.setLayout(orderNotificationPanelLayout);
        orderNotificationPanelLayout.setHorizontalGroup(
            orderNotificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderNotificationPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(orderNotificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(orderETA)
                    .addComponent(orderStatusLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 378, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        orderNotificationPanelLayout.setVerticalGroup(
            orderNotificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderNotificationPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(orderNotificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(orderNotificationPanelLayout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(orderNotificationPanelLayout.createSequentialGroup()
                        .addComponent(orderStatusLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(orderETA)
                        .addGap(15, 15, 15))))
        );

        orderHistoryButton.setText("Order History");
        orderHistoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderHistoryButtonActionPerformed(evt);
            }
        });

        profileButton.setText("Profile");
        profileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileButtonActionPerformed(evt);
            }
        });

        logOutButton.setText("Log Out");
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Customer Main Menu");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(orderNotificationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(orderFoodButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(topUpButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(orderHistoryButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                            .addComponent(notificationButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(logOutButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(profileButton)
                .addGap(67, 67, 67))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(profileButton))
                .addGap(45, 45, 45)
                .addComponent(orderFoodButton)
                .addGap(18, 18, 18)
                .addComponent(topUpButton)
                .addGap(18, 18, 18)
                .addComponent(notificationButton)
                .addGap(18, 18, 18)
                .addComponent(orderHistoryButton)
                .addGap(18, 18, 18)
                .addComponent(logOutButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(orderNotificationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
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

    private void orderFoodButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderFoodButtonActionPerformed
        OrderMenu orderMenu = new OrderMenu(customer);
        orderMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_orderFoodButtonActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void orderHistoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderHistoryButtonActionPerformed
        List<Order> customerOrders = retrieveCustomerOrders();
        
        if (customerOrders.isEmpty()) {
            JOptionPane.showMessageDialog(this, "You have not placed any orders.");
        } else {
            OrderHistory orderHistory = new OrderHistory(customer, customerOrders);
            orderHistory.setVisible(true);
            this.dispose();
            allOrders.clear();
        }
    }//GEN-LAST:event_orderHistoryButtonActionPerformed

    private void topUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topUpButtonActionPerformed
        TopUpPage topUpPage = new TopUpPage(customer);
        topUpPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_topUpButtonActionPerformed

    private void profileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileButtonActionPerformed
        CustomerUserProfile profile = new CustomerUserProfile(customer);
        profile.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_profileButtonActionPerformed

    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutButtonActionPerformed
        int confirmationResult = JOptionPane.showConfirmDialog(this, "Proceed to log out", "Log Out Confirmation", JOptionPane.YES_NO_OPTION);        

        if (confirmationResult == JOptionPane.YES_OPTION) {
            CustomerLogin page = new CustomerLogin();
            page.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_logOutButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logOutButton;
    private javax.swing.JButton notificationButton;
    private javax.swing.JLabel orderETA;
    private javax.swing.JButton orderFoodButton;
    private javax.swing.JButton orderHistoryButton;
    public javax.swing.JPanel orderNotificationPanel;
    public javax.swing.JLabel orderStatusLabel;
    private javax.swing.JButton profileButton;
    private javax.swing.JButton topUpButton;
    // End of variables declaration//GEN-END:variables
}
