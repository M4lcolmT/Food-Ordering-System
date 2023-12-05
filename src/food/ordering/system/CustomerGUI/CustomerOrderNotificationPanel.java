/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package food.ordering.system.CustomerGUI;

import food.ordering.system.OrderManager;
import food.ordering.system.Order;
import food.ordering.system.Notification;
import food.ordering.system.ReadFiles;
import food.ordering.system.RunnerGUI.Task;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
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
    private final Customer customer;
    private final List<Order> orders;
    private final int orderID;
    private final String updateDescription;
    private final List<Notification> allNotifications;
    private final List<Task> allTasks;
    private final CustomerNotification custNotifPage;
    private final OrderManager manager = new OrderManager();
    
    DecimalFormat df = new DecimalFormat("#.#");
    TextFilePaths path = new TextFilePaths();
    String notificationTextFile = path.getNotificationsTextFile();
    
    public CustomerOrderNotificationPanel(CustomerNotification custNotifPage, Customer customer, int orderID, String updateDescription, LocalDateTime dateTime) {
        initComponents();
        this.custNotifPage = custNotifPage;
        this.updateDescription = updateDescription;
        this.orderID = orderID;
        this.customer = customer;
        
        ReadFiles reader = new ReadFiles();
        allNotifications = reader.readNotifications();
        allTasks = reader.readTasks();
        
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
            case "Your order is preparing!", "A runner accepted your order!", 
                    "Your order is on the way.", "Your order is ready, waiting for pick up!" -> {
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
            case "Order arrived! Click to receive order.", "Your order is ready for dine in or take away." -> {
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
            if (item.getUserType().name().equals("CUSTOMER") && item.getUserID() == customer.getCustomerID() && item.getTypeID() == orderID) {
                notifs.add(item);
            }
        }
        return notifs;
    }
    
    private void removeOrderNotifs() {
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
    
    private void refundCredit(Order specificOrder) {
        Customer selectedCustomer = specificOrder.getCustomer();
        double credit = selectedCustomer.getCredit();
        double orderPrice = specificOrder.getTotalPrice();
        credit = credit + orderPrice;
        selectedCustomer.setCredit(Double.parseDouble(df.format(credit)));
        manager.saveUpdatedCustomerInfo(selectedCustomer);
    }
    
    private Task findTask(int orderID) {
        for (Task i : allTasks) {
            if (i.getOrderID() == orderID) {
                return i;
            }
        }
        return null;
    }
    
    private LocalDateTime getDateTime() {
        LocalDateTime originalDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
        String formattedDateTimeStr = originalDateTime.format(formatter);
        LocalDateTime parsedDateTime = LocalDateTime.parse(formattedDateTimeStr, formatter);
        return parsedDateTime;
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

        jPanel1.setBackground(new java.awt.Color(163, 213, 240));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 239, 239)));
        jPanel1.setPreferredSize(new java.awt.Dimension(625, 100));

        dateTimeLabel.setText("Date & Time");

        statusLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        statusLabel.setText("-");

        takeAwayButton.setBackground(new java.awt.Color(255, 255, 254));
        takeAwayButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        takeAwayButton.setForeground(new java.awt.Color(163, 213, 240));
        takeAwayButton.setText("Take Away");
        takeAwayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                takeAwayButtonActionPerformed(evt);
            }
        });

        dineInButton.setBackground(new java.awt.Color(255, 255, 254));
        dineInButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dineInButton.setForeground(new java.awt.Color(163, 213, 240));
        dineInButton.setText("Dine In");
        dineInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dineInButtonActionPerformed(evt);
            }
        });

        cancelButton.setBackground(new java.awt.Color(255, 255, 254));
        cancelButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cancelButton.setForeground(new java.awt.Color(163, 213, 240));
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        receivedButton.setBackground(new java.awt.Color(255, 255, 254));
        receivedButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        receivedButton.setForeground(new java.awt.Color(163, 213, 240));
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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(dateTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addComponent(receivedButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(takeAwayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dineInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(statusLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(takeAwayButton)
                        .addComponent(dineInButton)
                        .addComponent(cancelButton)
                        .addComponent(receivedButton))
                    .addComponent(dateTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        Order selectedOrder = manager.findOrder(orderID);
        Task selectedTask = findTask(orderID);
        cancelButton.setEnabled(false);
        int confirmationResult = JOptionPane.showConfirmDialog(this, "Proceed to cancel order?", "Cancel Confirmation", JOptionPane.YES_NO_OPTION);        

        if (confirmationResult == JOptionPane.YES_OPTION) {
            refundCredit(selectedOrder);
            removeOrderNotifs();
            orders.removeIf(item -> item.getOrderID() == selectedOrder.getOrderID());
            manager.writeOrdersToFile();
            allTasks.removeIf(item -> item.getTaskID() == selectedTask.getTaskID());
            manager.writeTasksToFile(allTasks);
        }
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void receivedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receivedButtonActionPerformed
        String hasRunnerDescription = "Order arrived! Click to receive order.";
        String noRunnerDescription = "Your order is ready for dine in or take away.";
        
        Order selectedOrder = manager.findOrder(orderID);
        Customer selectedCustomer = selectedOrder.getCustomer();
        int confirmationResult = JOptionPane.showConfirmDialog(this, "Order received?", "Order Confirmation", JOptionPane.YES_NO_OPTION);        

        if (confirmationResult == JOptionPane.YES_OPTION) {
            if (updateDescription.equals(noRunnerDescription)) {
                GiveReview page = new GiveReview(selectedCustomer, orderID, false);
                page.setVisible(true);
                custNotifPage.dispose();
                removeOrderNotifs();
            } else if (updateDescription.equals(hasRunnerDescription)){
                GiveReview page = new GiveReview(selectedCustomer, orderID, true);
                page.setVisible(true);
                custNotifPage.dispose();
                removeOrderNotifs();
            }
        }
    }//GEN-LAST:event_receivedButtonActionPerformed

    private void takeAwayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_takeAwayButtonActionPerformed
        Order selectedOrder = manager.findOrder(orderID);
        if (selectedOrder.getStatus() == Order.OrderStatus.READY_FOR_PICKUP) {
            Notification newNotif = new Notification(Notification.NotifType.ORDER, selectedOrder.getCustomer().getCustomerID(), Notification.NotifUserType.CUSTOMER, selectedOrder.getOrderID(), "Your order is ready, waiting for pick up!", getDateTime());
            newNotif.saveNotification(newNotif);
        } else {
            JOptionPane.showMessageDialog(this, "Your order is not ready.", "Order still preparing", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_takeAwayButtonActionPerformed

    private void dineInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dineInButtonActionPerformed
        Order selectedOrder = manager.findOrder(orderID);
        if (selectedOrder.getStatus() == Order.OrderStatus.READY_FOR_PICKUP) {
            Notification newNotif = new Notification(Notification.NotifType.ORDER, selectedOrder.getCustomer().getCustomerID(), Notification.NotifUserType.CUSTOMER, selectedOrder.getOrderID(), "Your order is ready, waiting for pick up!", getDateTime());
            newNotif.saveNotification(newNotif);
        } else {
            JOptionPane.showMessageDialog(this, "Your order is not ready.", "Order still preparing", JOptionPane.INFORMATION_MESSAGE);
        }
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
