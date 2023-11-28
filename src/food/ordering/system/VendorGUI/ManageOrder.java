/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package food.ordering.system.VendorGUI;

import food.ordering.system.AdminGUI.Notification;
import food.ordering.system.AdminGUI.ReadFiles;
import food.ordering.system.CustomerGUI.Customer;
import food.ordering.system.CustomerGUI.Order;
import food.ordering.system.CustomerGUI.Order.OrderStatus;
import food.ordering.system.CustomerGUI.OrderManager;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import textFiles.TextFilePaths;

/**
 *
 * @author LENOVO
 */
public class ManageOrder extends javax.swing.JFrame {
    private Vendor vendor;
    private Order specificOrder;
    private int orderID;
    private List<Order> allOrders;
    private OrderStatus orderStatus;
    private List<Notification> notifications;
    
    TextFilePaths path = new TextFilePaths();
    String orderTextFilePath = path.getOrderTextFile();
    String notificationTextFilePath = path.getNotificationsTextFile();
    
    public ManageOrder(Vendor vendor, int orderID) {
        initComponents();
        this.vendor = vendor;
        this.orderID = orderID;
        
        OrderManager manager = new OrderManager();
        allOrders = manager.getOrders();
        specificOrder = findOrder();
        loadOrder();
        readyButton.setVisible(false);
        
        ReadFiles reader = new ReadFiles();
        notifications = reader.readNotifications();
    }
    
    // Check if order is ready for delivery 
    private void readyOrder() {
        
    }    
    
    private Order findOrder() {
        for (Order item : allOrders) {
            if (item.getOrderID() == orderID) {
                return item;
            }
        }
        return null;
    }
        
    private void loadOrder() {
        List<FoodItem> foodItems = specificOrder.getOrderBasket();
        DefaultTableModel model = (DefaultTableModel) orderTable.getModel();
        
        // Filter and sort the data
        List<FoodItem> filteredItems = foodItems.stream()
                .collect(Collectors.toList());

        // Sort the filtered items by ID
        Collections.sort(filteredItems, Comparator.comparingInt(FoodItem::getItemID));

        // Clear existing rows
        model.setRowCount(0);

        // Create a set to keep track of unique items
        Set<FoodItem> uniqueItems = new HashSet<>(filteredItems);

        for (FoodItem item : uniqueItems) {
            int quantity = calculateQuantity(filteredItems, item);
            String itemName = item.getItemName();

            Object[] rowData = { item.getItemID(), quantity, itemName };
            model.addRow(rowData);
        }
    }
    
    private int calculateQuantity(List<FoodItem> items, FoodItem targetItem) {
        int count = 0;
        for (FoodItem item : items) {
            if (item.getItemID() == targetItem.getItemID()) {
                count++;
            }
        }
        return count;
    }
    
    // Check max id in notification text file
    private int checkMaxID() {
        int maxID = 0;
        for (Notification i : notifications) {
            if (i.getNotificationID() > maxID) {
                maxID = i.getNotificationID();
            }
        }
        // Increment the maximum ID
        return maxID + 1;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        orderIDLabel = new javax.swing.JLabel();
        acceptButton = new javax.swing.JButton();
        rejectButton = new javax.swing.JButton();
        readyButton = new javax.swing.JButton();
        dateLabel = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 400));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Manage Order:");

        orderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item ID", "Quantity", "Food Item"
            }
        ));
        jScrollPane1.setViewportView(orderTable);
        if (orderTable.getColumnModel().getColumnCount() > 0) {
            orderTable.getColumnModel().getColumn(2).setPreferredWidth(400);
        }

        orderIDLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        orderIDLabel.setText("-");

        acceptButton.setText("Accept");
        acceptButton.setPreferredSize(new java.awt.Dimension(100, 25));
        acceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptButtonActionPerformed(evt);
            }
        });

        rejectButton.setText("Reject");
        rejectButton.setPreferredSize(new java.awt.Dimension(100, 25));
        rejectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejectButtonActionPerformed(evt);
            }
        });

        readyButton.setText("Ready");
        readyButton.setPreferredSize(new java.awt.Dimension(100, 25));
        readyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readyButtonActionPerformed(evt);
            }
        });

        dateLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        dateLabel.setText("Date");

        timeLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        timeLabel.setText("Time");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(orderIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(acceptButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rejectButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(readyButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(orderIDLabel)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(timeLabel))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(acceptButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rejectButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(readyButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
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

    private void acceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptButtonActionPerformed
        int confirmationResult = JOptionPane.showConfirmDialog(this, "Proceed to accept order?", "Accept Confirmation", JOptionPane.YES_NO_OPTION);        

        if (confirmationResult == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, "Order is accepted, proceed to prepare.", "Accept Order", JOptionPane.INFORMATION_MESSAGE);
            specificOrder.updateOrderStatus(specificOrder, allOrders, OrderStatus.CONFIRMED);
            //Send notif to customer
        }
    }//GEN-LAST:event_acceptButtonActionPerformed

    private void rejectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejectButtonActionPerformed
        Order selectedOrder = findOrder();

        int confirmationResult = JOptionPane.showConfirmDialog(this, "Proceed to reject order?", "Reject Confirmation", JOptionPane.YES_NO_OPTION);        

        if (confirmationResult == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, "Order is rejected.", "Reject Order", JOptionPane.INFORMATION_MESSAGE);
            specificOrder.updateOrderStatus(specificOrder, allOrders, OrderStatus.CANCELLED);
            //Sent notif to customer
            Notification newNotif = new Notification(checkMaxID(), Notification.NotifType.ORDER, orderID, selectedOrder.getCustomer().getCustomerID(), Notification.NotifUserType.CUSTOMER);
            try (PrintWriter pw = new PrintWriter(new FileWriter(notificationTextFilePath, true))) {
                pw.println(newNotif.toString());
            } catch (IOException ex) {
                System.out.println("Failed to save!");
            }
            try (PrintWriter writer = new PrintWriter(new FileWriter(orderTextFilePath))) {
                // Write each order to the file
                for (Order item : allOrders) {
                    writer.println(item.toString());
                }
            } catch (IOException e) {
                e.printStackTrace(); // Handle the exception appropriately (e.g., show an error message)
            }
            ViewOrders page = new ViewOrders(vendor, allOrders);
            page.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_rejectButtonActionPerformed

    private void readyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readyButtonActionPerformed
        JOptionPane.showMessageDialog(this, "Order is ready.", "Finisihed Order", JOptionPane.INFORMATION_MESSAGE);
        specificOrder.updateOrderStatus(specificOrder, allOrders, OrderStatus.READY_FOR_PICKUP);
        //Sent notif to customer
    }//GEN-LAST:event_readyButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptButton;
    public javax.swing.JLabel dateLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    public javax.swing.JLabel orderIDLabel;
    private javax.swing.JTable orderTable;
    private javax.swing.JButton readyButton;
    private javax.swing.JButton rejectButton;
    public javax.swing.JLabel timeLabel;
    // End of variables declaration//GEN-END:variables
}
