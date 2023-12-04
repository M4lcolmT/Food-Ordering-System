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
        
        creditBalanceLabel.setText("RM"+Double.toString(customer.getCredit()));
        OrderManager orderManager = new OrderManager();
        allOrders = orderManager.getOrders();
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
        orderHistoryButton = new javax.swing.JButton();
        profileButton = new javax.swing.JButton();
        logOutButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        creditBalanceLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 400));

        orderFoodButton.setBackground(new java.awt.Color(255, 255, 254));
        orderFoodButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        orderFoodButton.setText("Order Food");
        orderFoodButton.setPreferredSize(new java.awt.Dimension(150, 25));
        orderFoodButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderFoodButtonActionPerformed(evt);
            }
        });

        topUpButton.setBackground(new java.awt.Color(255, 255, 254));
        topUpButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        topUpButton.setText("Top Up");
        topUpButton.setPreferredSize(new java.awt.Dimension(150, 25));
        topUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topUpButtonActionPerformed(evt);
            }
        });

        notificationButton.setBackground(new java.awt.Color(255, 255, 254));
        notificationButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        notificationButton.setText("Notifications");
        notificationButton.setPreferredSize(new java.awt.Dimension(150, 25));
        notificationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notificationButtonActionPerformed(evt);
            }
        });

        orderHistoryButton.setBackground(new java.awt.Color(255, 255, 254));
        orderHistoryButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        orderHistoryButton.setText("Order History");
        orderHistoryButton.setPreferredSize(new java.awt.Dimension(150, 25));
        orderHistoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderHistoryButtonActionPerformed(evt);
            }
        });

        profileButton.setBackground(new java.awt.Color(255, 255, 254));
        profileButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        profileButton.setText("Profile");
        profileButton.setPreferredSize(new java.awt.Dimension(75, 25));
        profileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileButtonActionPerformed(evt);
            }
        });

        logOutButton.setBackground(new java.awt.Color(255, 255, 254));
        logOutButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        logOutButton.setText("Log Out");
        logOutButton.setPreferredSize(new java.awt.Dimension(150, 25));
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        jLabel1.setText("Customer Main Menu");

        creditBalanceLabel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        creditBalanceLabel.setText("-");

        jLabel3.setFont(new java.awt.Font("SansSerif", 2, 13)); // NOI18N
        jLabel3.setText("Current credit balance:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(orderFoodButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(topUpButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(orderHistoryButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(notificationButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(logOutButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 240, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(creditBalanceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(profileButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(profileButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(creditBalanceLabel)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(orderFoodButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(topUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(notificationButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(orderHistoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(logOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void orderFoodButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderFoodButtonActionPerformed
        OrderMenu orderMenu = new OrderMenu(customer);
        orderMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_orderFoodButtonActionPerformed

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

    private void notificationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notificationButtonActionPerformed
        CustomerNotification page = new CustomerNotification(customer);
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_notificationButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel creditBalanceLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logOutButton;
    private javax.swing.JButton notificationButton;
    private javax.swing.JButton orderFoodButton;
    private javax.swing.JButton orderHistoryButton;
    private javax.swing.JButton profileButton;
    private javax.swing.JButton topUpButton;
    // End of variables declaration//GEN-END:variables
}
