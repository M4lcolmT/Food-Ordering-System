/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package food.ordering.system.VendorGUI;

import food.ordering.system.Notification;
import food.ordering.system.ReadFiles;
import food.ordering.system.CustomerGUI.Customer;
import food.ordering.system.CustomerGUI.Order;
import food.ordering.system.CustomerGUI.Order.OrderStatus;
import food.ordering.system.CustomerGUI.OrderManager;
import food.ordering.system.RunnerGUI.Runner;
import food.ordering.system.RunnerGUI.Task;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class ManageOrder extends javax.swing.JFrame {
    private Vendor vendor;
    private Order specificOrder;
    private int orderID;
    private OrderStatus orderStatus;
    private List<Order> allOrders;
    private List<Runner> runners;
    private List<Task> allTasks;
    private List<Notification> notifications;
    private final OrderManager manager = new OrderManager();
    
    DecimalFormat df = new DecimalFormat("#.#");

    public ManageOrder(Vendor vendor, int orderID) {
        initComponents();
        this.vendor = vendor;
        this.orderID = orderID;
        
        allOrders = manager.getOrders();
        specificOrder = manager.findOrder(orderID);
        loadOrder();
        
        ReadFiles reader = new ReadFiles();
        notifications = reader.readNotifications();
        runners = reader.readRunners();
        allTasks = reader.readTasks();
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
    
    private LocalDateTime getDateTime() {
        LocalDateTime originalDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
        String formattedDateTimeStr = originalDateTime.format(formatter);
        LocalDateTime parsedDateTime = LocalDateTime.parse(formattedDateTimeStr, formatter);
        return parsedDateTime;
    }
    
    private void refundCredit() {
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
        jLabel12 = new javax.swing.JLabel();

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

        jLabel1.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
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

        orderIDLabel.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        orderIDLabel.setText("-");

        acceptButton.setBackground(new java.awt.Color(255, 255, 254));
        acceptButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        acceptButton.setForeground(new java.awt.Color(102, 255, 102));
        acceptButton.setText("Accept");
        acceptButton.setPreferredSize(new java.awt.Dimension(100, 25));
        acceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptButtonActionPerformed(evt);
            }
        });

        rejectButton.setBackground(new java.awt.Color(255, 255, 254));
        rejectButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rejectButton.setForeground(new java.awt.Color(255, 51, 51));
        rejectButton.setText("Reject");
        rejectButton.setPreferredSize(new java.awt.Dimension(100, 25));
        rejectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejectButtonActionPerformed(evt);
            }
        });

        readyButton.setBackground(new java.awt.Color(255, 255, 254));
        readyButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        readyButton.setForeground(new java.awt.Color(26, 115, 232));
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

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(orderIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(acceptButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rejectButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(readyButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(dateLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(timeLabel))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(orderIDLabel))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(acceptButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rejectButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(readyButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void acceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptButtonActionPerformed
        int confirmationResult = JOptionPane.showConfirmDialog(this, "Proceed to accept order?", "Accept Confirmation", JOptionPane.YES_NO_OPTION);        

        if (confirmationResult == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, "Order is accepted, proceed to prepare.", "Accept Order", JOptionPane.INFORMATION_MESSAGE);
            //Save updated order status
            specificOrder.updateOrderStatus(specificOrder, allOrders, OrderStatus.PREPARING);
            //Send notif to customer
            Notification newNotif = new Notification(checkMaxID(), Notification.NotifType.ORDER, specificOrder.getCustomer().getCustomerID(), Notification.NotifUserType.CUSTOMER, specificOrder.getOrderID(), "Your order is preparing!", getDateTime());
            newNotif.saveNotification(newNotif);
            //Set button visibility
            acceptButton.setVisible(false);
            rejectButton.setVisible(false);
            readyButton.setVisible(true);
        }
    }//GEN-LAST:event_acceptButtonActionPerformed

    private void rejectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejectButtonActionPerformed
        Task selectedTask = findTask(orderID);
        int confirmationResult = JOptionPane.showConfirmDialog(this, "Proceed to reject order?", "Reject Confirmation", JOptionPane.YES_NO_OPTION);        

        if (confirmationResult == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, "Order is rejected.", "Reject Order", JOptionPane.INFORMATION_MESSAGE);
            //Refund credit to customer
            refundCredit();
            //Delete task from runner
            allTasks.removeIf(item -> item.getTaskID() == selectedTask.getTaskID());
            manager.writeTasksToFile(allTasks);
            //Save updated order status
            specificOrder.updateOrderStatus(specificOrder, allOrders, OrderStatus.CANCELLED);
            //Sent notif to customer
            Notification newNotif = new Notification(checkMaxID(), Notification.NotifType.ORDER, specificOrder.getCustomer().getCustomerID(), Notification.NotifUserType.CUSTOMER, specificOrder.getOrderID(), "Your order is cancelled", getDateTime());
            newNotif.saveNotification(newNotif);
            ViewOrders page = new ViewOrders(vendor, allOrders);
            page.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_rejectButtonActionPerformed

    private void readyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readyButtonActionPerformed
        JOptionPane.showMessageDialog(this, "Order is ready.", "Finisihed Order", JOptionPane.INFORMATION_MESSAGE);
        specificOrder.updateOrderStatus(specificOrder, allOrders, OrderStatus.READY_FOR_PICKUP);
        //Sent notif to customer
        Notification newNotif = new Notification(checkMaxID(), Notification.NotifType.ORDER, specificOrder.getCustomer().getCustomerID(), Notification.NotifUserType.CUSTOMER, specificOrder.getOrderID(), "Your order is ready, waiting for pick up!", getDateTime());
        newNotif.saveNotification(newNotif);
        ViewOrders page = new ViewOrders(vendor, allOrders);
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_readyButtonActionPerformed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        ViewOrders page = new ViewOrders(vendor, allOrders);
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton acceptButton;
    public javax.swing.JLabel dateLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    public javax.swing.JLabel orderIDLabel;
    private javax.swing.JTable orderTable;
    public javax.swing.JButton readyButton;
    public javax.swing.JButton rejectButton;
    public javax.swing.JLabel timeLabel;
    // End of variables declaration//GEN-END:variables
}
