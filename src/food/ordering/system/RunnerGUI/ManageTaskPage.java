package food.ordering.system.RunnerGUI;

import food.ordering.system.Notification;
import food.ordering.system.ReadFiles;
import food.ordering.system.CustomerGUI.Order;
import food.ordering.system.CustomerGUI.OrderManager;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author LENOVO
 */
public class ManageTaskPage extends javax.swing.JFrame {
    private Runner runner;
    private Task selectedTask;
    private List<Task> allTasks;
    private List<Order> orders;
    private List<Notification> notifications;
    private List<Runner> runners;
    private final OrderManager manager = new OrderManager();

    public ManageTaskPage(Runner runner, Task selectedTask) {
        initComponents();
        this.runner = runner;
        this.selectedTask = selectedTask;
        
        orders = manager.getOrders();
        
        ReadFiles reader = new ReadFiles();
        allTasks = reader.readTasks();
        runners = reader.readRunners();
        notifications = reader.readNotifications();
        checkTaskStatus();
    }
    
    private void checkTaskStatus() {
        String status = selectedTask.getTaskStatus().name();
        switch (status) {
            case "ACCEPTED":
                pickedUpButton.setVisible(true);
                onTheWayButton.setVisible(false);
                deliveredButton.setVisible(false);
                break;
            case "PICKED_UP":
                pickedUpButton.setVisible(false);
                onTheWayButton.setVisible(true);
                deliveredButton.setVisible(false);
                break;
            case "ON_THE_WAY":
                pickedUpButton.setVisible(false);
                onTheWayButton.setVisible(false);
                deliveredButton.setVisible(true);
                break;
            default:
                System.out.println("Invalid status!");
                break;
        }
    }
    
    public int checkMaxNotificationID() {
        int maxID = 0;
        for (Notification notification : notifications) {
            if (notification.getNotificationID() > maxID) {
                maxID = notification.getNotificationID();
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        onTheWayButton = new javax.swing.JButton();
        pickedUpButton = new javax.swing.JButton();
        deliveredButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(250, 220));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(250, 200));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        onTheWayButton.setText("On the way");
        onTheWayButton.setPreferredSize(new java.awt.Dimension(150, 25));
        onTheWayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onTheWayButtonActionPerformed(evt);
            }
        });

        pickedUpButton.setText("Order Picked Up");
        pickedUpButton.setPreferredSize(new java.awt.Dimension(150, 25));
        pickedUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pickedUpButtonActionPerformed(evt);
            }
        });

        deliveredButton.setText("Order Delivered");
        deliveredButton.setPreferredSize(new java.awt.Dimension(150, 25));
        deliveredButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deliveredButtonActionPerformed(evt);
            }
        });

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(deliveredButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pickedUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(onTheWayButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jButton1)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pickedUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(onTheWayButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deliveredButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Task Status");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jLabel2))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jLabel2)
                        .addContainerGap(16, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(653, 653, 653))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deliveredButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deliveredButtonActionPerformed
        Order selectedOrder = manager.findOrder(selectedTask.getOrderID());
        selectedTask.updateTaskStatus(selectedTask, allTasks, Task.TaskStatus.DELIVERED);
        runner.updateRunnerStatus(runner, runners, true);
        // Send notif to customer
        Notification customerNotif = new Notification(checkMaxNotificationID(), Notification.NotifType.ORDER, selectedOrder.getCustomer().getCustomerID(), Notification.NotifUserType.CUSTOMER, selectedOrder.getOrderID(), "Order arrived! Click to receive order.", getDateTime());
        customerNotif.saveNotification(customerNotif);
        ViewNewTasks page = new ViewNewTasks(runner);
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_deliveredButtonActionPerformed

    private void pickedUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pickedUpButtonActionPerformed
        Order selectedOrder = manager.findOrder(selectedTask.getOrderID());
        
        if (!selectedOrder.getStatus().name().trim().equals("READY_FOR_PICKUP")) {
            JOptionPane.showMessageDialog(this, "The order is not ready.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        selectedTask.updateTaskStatus(selectedTask, allTasks, Task.TaskStatus.PICKED_UP);
        // Send notif to customer
        Notification customerNotif = new Notification(checkMaxNotificationID(), Notification.NotifType.ORDER, selectedOrder.getCustomer().getCustomerID(), Notification.NotifUserType.CUSTOMER, selectedOrder.getOrderID(), "Your order is on the way.", getDateTime());
        customerNotif.saveNotification(customerNotif);
        ViewNewTasks page = new ViewNewTasks(runner);
        page.setVisible(true);
        this.dispose();
        //Set order status to PICKED_UP
        selectedOrder.updateOrderStatus(selectedOrder, orders, Order.OrderStatus.OUT_FOR_DELIVERY);
    }//GEN-LAST:event_pickedUpButtonActionPerformed

    private void onTheWayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onTheWayButtonActionPerformed
        Order selectedOrder = manager.findOrder(selectedTask.getOrderID());
        System.out.println("status"+selectedOrder.getStatus().name().trim());
        selectedTask.updateTaskStatus(selectedTask, allTasks, Task.TaskStatus.ON_THE_WAY);
        // Send notif to customer 
        Notification customerNotif = new Notification(checkMaxNotificationID(), Notification.NotifType.ORDER, selectedOrder.getCustomer().getCustomerID(), Notification.NotifUserType.CUSTOMER, selectedOrder.getOrderID(), "Your order is on the way.", getDateTime());
        customerNotif.saveNotification(customerNotif);
        ViewNewTasks page = new ViewNewTasks(runner);
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_onTheWayButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ViewNewTasks page = new ViewNewTasks(runner);
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deliveredButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton onTheWayButton;
    private javax.swing.JButton pickedUpButton;
    // End of variables declaration//GEN-END:variables

}
