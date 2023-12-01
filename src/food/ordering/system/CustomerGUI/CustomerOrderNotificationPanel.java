/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package food.ordering.system.CustomerGUI;

import food.ordering.system.AdminGUI.Notification;
import food.ordering.system.AdminGUI.ReadFiles;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import textFiles.TextFilePaths;

/**
 *
 * @author LENOVO
 */
public class CustomerOrderNotificationPanel extends javax.swing.JPanel {
    private Customer customer;
    private List<Order> orders;
    private int orderID;
    private String updateDescription;
    private LocalDateTime dateTime;
    private List<Notification> allNotifications;
    private final OrderManager manager = new OrderManager();
    
    TextFilePaths path = new TextFilePaths();
    String notificationTextFile = path.getNotificationsTextFile();
    
    public CustomerOrderNotificationPanel(Customer customer, int orderID, String updateDescription, LocalDateTime dateTime) {
        initComponents();
        this.updateDescription = updateDescription;
        this.dateTime = dateTime;
        this.orderID = orderID;
        this.customer = customer;
        
        ReadFiles reader = new ReadFiles();
        allNotifications = reader.readNotifications();
        
        statusLabel.setText(updateDescription);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy, HH:mm");
        String formattedDateTime = dateTime.format(formatter);
        dateTimeLabel.setText(formattedDateTime);
        receivedButton.setVisible(false);
        takeAwayButton.setVisible(false);
        dineInButton.setVisible(false);
        cancelButton.setVisible(false);
        
        orders = manager.getOrders();
        checkOrderStatus();
    }
    
    private void checkOrderStatus() {
        switch (updateDescription) {
            case "Your order is processing!" -> {
                takeAwayButton.setVisible(false);
                dineInButton.setVisible(false);
                receivedButton.setVisible(false);
                cancelButton.setVisible(true);
            }
            case "Your order is preparing!", "A runner accepted your order!", "Your order is on the way." -> {
                receivedButton.setVisible(false);
                takeAwayButton.setVisible(false);
                dineInButton.setVisible(false);
                cancelButton.setVisible(false);
            }
            case "No runners are available! Please choose to dine in or take away." -> {
                receivedButton.setVisible(false);
                takeAwayButton.setVisible(true);
                dineInButton.setVisible(true);
                cancelButton.setVisible(false);
            }
            case "Order arrived! Click to receive order." -> {
                receivedButton.setVisible(true);
                takeAwayButton.setVisible(false);
                dineInButton.setVisible(false);
                cancelButton.setVisible(false);
            }
            default -> {
                System.out.println("Customer Notif Order Status Error!");
                receivedButton.setVisible(false);
                takeAwayButton.setVisible(false);
                dineInButton.setVisible(false);
                cancelButton.setVisible(false);
            }
        }
    }
    
    private List<Notification> getOrderNotifications() {
        List<Notification> notifs = new ArrayList<>();
        
        for (Notification item : allNotifications) {
            if (item.getUserType().name().equals("CUSTOMER") && item.getUserID() == customer.getCustomerID() && item.getTransactionID() == orderID) {
                notifs.add(item);
            }
        }
        return notifs;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        dateTimeLabel = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();
        takeAwayButton = new javax.swing.JButton();
        dineInButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        receivedButton = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));

        dateTimeLabel.setText("Date & Time");

        statusLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        statusLabel.setText("-");

        takeAwayButton.setText("Take Away");
        takeAwayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                takeAwayButtonActionPerformed(evt);
            }
        });

        dineInButton.setText("Dine In");
        dineInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dineInButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        receivedButton.setText("Received");
        receivedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receivedButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(receivedButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(takeAwayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dineInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(statusLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateTimeLabel)
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(takeAwayButton)
                    .addComponent(dineInButton)
                    .addComponent(cancelButton)
                    .addComponent(receivedButton))
                .addGap(41, 41, 41))
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

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        int confirmationResult = JOptionPane.showConfirmDialog(this, "Proceed to cancel order?", "Cancel Confirmation", JOptionPane.YES_NO_OPTION);        

        if (confirmationResult == JOptionPane.YES_OPTION) {
            Order selectedOrder = manager.findOrder(orderID);
            orders.removeIf(item -> item.getOrderID() == selectedOrder.getOrderID());
            manager.writeOrdersToFile();
        }
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void receivedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receivedButtonActionPerformed
        int confirmationResult = JOptionPane.showConfirmDialog(this, "Order received?", "Order Confirmation", JOptionPane.YES_NO_OPTION);        

        if (confirmationResult == JOptionPane.YES_OPTION) {
            List<Notification> customerNotifs = getOrderNotifications();
                allNotifications.removeAll(customerNotifs);

                try (PrintWriter pw = new PrintWriter(new FileWriter(notificationTextFile, false))) {
                    for (Notification notif : allNotifications) {
                        pw.println(notif.toString());                
                    }
                } catch (IOException ex) {
                    Logger.getLogger(CustomerOrderNotificationPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }//GEN-LAST:event_receivedButtonActionPerformed

    private void takeAwayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_takeAwayButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_takeAwayButtonActionPerformed

    private void dineInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dineInButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dineInButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel dateTimeLabel;
    private javax.swing.JButton dineInButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton receivedButton;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JButton takeAwayButton;
    // End of variables declaration//GEN-END:variables
}
