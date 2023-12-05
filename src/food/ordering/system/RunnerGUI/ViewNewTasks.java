package food.ordering.system.RunnerGUI;

import food.ordering.system.Notification;
import food.ordering.system.ReadFiles;
import food.ordering.system.CustomerGUI.Customer;
import food.ordering.system.Order;
import food.ordering.system.OrderManager;
import food.ordering.system.Location;
import food.ordering.system.VendorGUI.Vendor;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import textFiles.TextFilePaths;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
public class ViewNewTasks extends javax.swing.JFrame {
    private Runner runner;
    private List<Order> orders;
    private List<Task> allTasks;
    private List<Task> runnerTasks;
    private List<Runner> runners;
    private List<Notification> notifications;
    private final OrderManager manager = new OrderManager();


    TextFilePaths path = new TextFilePaths();
    String taskTextFilePath = path.getRunnerTasksTextFile();
    
    public ViewNewTasks(Runner runner) {
        initComponents();
        this.runner = runner;
        
        ReadFiles reader = new ReadFiles();
        allTasks = reader.readTasks();
        runnerTasks = getRunnerTask(runner.getRunnerID());
        runners = reader.readRunners();
        notifications = reader.readNotifications();
        
        orders = manager.getOrders();
        loadTasks();
    }
    
    private LocalDateTime getDateTime() {
        LocalDateTime originalDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
        String formattedDateTimeStr = originalDateTime.format(formatter);
        LocalDateTime parsedDateTime = LocalDateTime.parse(formattedDateTimeStr, formatter);
        return parsedDateTime;
    }
    
    private List<Task> getRunnerTask(int id) {
        List<Task> runnertasks = new ArrayList<>();
        
        for (Task item : allTasks) {
            if (id == item.getRunnerID()) {
                runnertasks.add(item);
            }
        }
        return runnertasks;
    }
    
    private Task getTask(int id) {
        for (Task i : runnerTasks) {
            if (id == i.getTaskID()) {
                return i;
            }
        }
        return null;
    }
    
    private double calculateDistance(String customerCity, String vendorCity) {
        double distance = 0;
        
        Location customerLocation = Location.locationMap.get(customerCity);
        Location vendorLocation = Location.locationMap.get(vendorCity);

        if (customerLocation != null && vendorLocation != null) {
            distance = Location.calculateDistance(customerLocation,vendorLocation);
        } else {
            System.out.println("Unknown location");
        }
        return distance;
    }
    
    //Load tasks into the table
    private void loadTasks() {
        DefaultTableModel model = (DefaultTableModel) tasksTable.getModel();
        
        List<Task> filteredTasks = runnerTasks.stream()
                .collect(Collectors.toList());
        // Sort the filtered items by ID
        filteredTasks.sort(Comparator.comparingInt(Task::getTaskID));

        // Clear existing rows
        model.setRowCount(0);
        
        for (Task task : filteredTasks) {
            if (task.getTaskStatus() != Task.TaskStatus.DECLINED) {
                Order order = manager.findOrder(task.getOrderID());
                Customer orderCustomer = order.getCustomer();
                Vendor orderVendor = order.getVendor();
                double distance = calculateDistance(orderCustomer.getCity().trim().toLowerCase(), orderVendor.getCity().trim().toLowerCase());
                Object[] rowData = { task.getTaskID(), orderVendor.getName(), distance+"km", orderCustomer.getName(), orderCustomer.getCity(), task.getTaskStatus()};
                model.addRow(rowData);
            }
        }
    }
    
    //Check runner avaliability
    private Runner checkRunner() {
        for (Runner item : runners) {
            if (item.getRunnerID() != runner.getRunnerID() && item.isRunnerAvailability() == true) {
                System.out.println("id:"+item.getRunnerID());
                return item;
            }
        }
        return null;
    }
    
    private int checkMaxNotificationID() {
        int maxID = 0;
        for (Notification notification : notifications) {
            if (notification.getNotificationID() > maxID) {
                maxID = notification.getNotificationID();
            }
        }
        // Increment the maximum ID
        return maxID + 1;
    }
    
    private int checkMaxTaskID() {
        int maxID = 0;
        for (Task task : allTasks) {
            if (task.getTaskID() > maxID) {
                maxID = task.getTaskID();
            }
        }
        // Increment the maximum ID
        return maxID + 1;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tasksTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        acceptButton = new javax.swing.JButton();
        rejectButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        manageButton = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 500));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tasksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID ", "Vendor Name", "Distance", "Customer Name", "Customer Location", "Status"
            }
        ));
        jScrollPane1.setViewportView(tasksTable);
        if (tasksTable.getColumnModel().getColumnCount() > 0) {
            tasksTable.getColumnModel().getColumn(0).setPreferredWidth(5);
        }

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        acceptButton.setBackground(new java.awt.Color(68, 179, 68));
        acceptButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        acceptButton.setForeground(new java.awt.Color(255, 255, 255));
        acceptButton.setText("Accept");
        acceptButton.setPreferredSize(new java.awt.Dimension(100, 25));
        acceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptButtonActionPerformed(evt);
            }
        });

        rejectButton.setBackground(new java.awt.Color(255, 51, 51));
        rejectButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rejectButton.setForeground(new java.awt.Color(255, 255, 255));
        rejectButton.setText("Reject");
        rejectButton.setPreferredSize(new java.awt.Dimension(100, 25));
        rejectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejectButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("New Task List");

        manageButton.setBackground(new java.awt.Color(26, 115, 232));
        manageButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        manageButton.setForeground(new java.awt.Color(255, 255, 255));
        manageButton.setText("Manage");
        manageButton.setPreferredSize(new java.awt.Dimension(100, 25));
        manageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(jLabel1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(acceptButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(rejectButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(manageButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(acceptButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rejectButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(manageButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 42, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2)
                        .addGap(96, 96, 96))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(664, 664, 664))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void rejectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejectButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) tasksTable.getModel();
        int selectedRow = tasksTable.getSelectedRow();
        int id = (int) model.getValueAt(selectedRow, 0);
        Task selectedTask = getTask(id);
        Order selectedOrder = manager.findOrder(selectedTask.getOrderID());
        
        if (selectedRow != -1) {
            Runner availableRunner = checkRunner();
            // Check for another available runner
            if (availableRunner != null) { 
                // Send notification to the newly available runner
                Notification runnerNotif = new Notification(checkMaxNotificationID(), Notification.NotifType.ORDER, availableRunner.getRunnerID(), Notification.NotifUserType.RUNNER, selectedTask.getOrderID(), "New task!", getDateTime());
                runnerNotif.saveNotification(runnerNotif);
                // Change the task status to rejected
                selectedTask.updateTaskStatus(selectedTask, allTasks, Task.TaskStatus.DECLINED);
                ReadFiles reader = new ReadFiles();
                allTasks = reader.readTasks();
                runnerTasks = getRunnerTask(runner.getRunnerID());
                loadTasks();
                // Create a new task for the newly available runner
                Task newTask = new Task(checkMaxTaskID(), availableRunner.getRunnerID(), selectedTask.getOrderID(), Task.TaskStatus.PENDING, selectedTask.getDeliveryFee(), getDateTime());
                newTask.createTask(newTask);
            } else {
                // Send a notification to prompt the customer notification to choose dine-in/take-away
                Notification customerNotif = new Notification(checkMaxNotificationID(), Notification.NotifType.ORDER, selectedOrder.getCustomer().getCustomerID(), Notification.NotifUserType.CUSTOMER, selectedOrder.getOrderID(), "No runners are available! Please choose to dine in or take away.", getDateTime());
                customerNotif.saveNotification(customerNotif);
                // Change the task status to rejected
                selectedTask.updateTaskStatus(selectedTask, allTasks, Task.TaskStatus.DECLINED);
                ReadFiles reader = new ReadFiles();
                allTasks = reader.readTasks();
                runnerTasks = getRunnerTask(runner.getRunnerID());
                loadTasks();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to reject.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_rejectButtonActionPerformed

    private void acceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) tasksTable.getModel();
        int selectedRow = tasksTable.getSelectedRow();
        int id = (int) model.getValueAt(selectedRow, 0);
        Task selectedTask = getTask(id);
        Order selectedOrder = manager.findOrder(selectedTask.getOrderID());
        
        if (selectedRow != -1) {
            // Send notification to the customer that their order is accepted
            Notification customerNotif = new Notification(checkMaxNotificationID(), Notification.NotifType.ORDER, selectedOrder.getCustomer().getCustomerID(), Notification.NotifUserType.CUSTOMER, selectedOrder.getOrderID(), "A runner accepted your order!", getDateTime());
            customerNotif.saveNotification(customerNotif);
            // Change the task status to accepted
            selectedTask.updateTaskStatus(selectedTask, allTasks, Task.TaskStatus.ACCEPTED);
            runner.updateRunnerStatus(runner, runners, false);
            ReadFiles reader = new ReadFiles();
            allTasks = reader.readTasks();
            runnerTasks = getRunnerTask(runner.getRunnerID());
            loadTasks();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to accept.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_acceptButtonActionPerformed

    private void manageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) tasksTable.getModel();
        int selectedRow = tasksTable.getSelectedRow();
        
        if (selectedRow != -1) {
            int id = (int) model.getValueAt(selectedRow, 0);
            Task.TaskStatus status = (Task.TaskStatus) model.getValueAt(selectedRow, 5);
            Task selectedTask = getTask(id);
            if (status.name().equals("ACCEPTED") || status.name().equals("PICKED_UP") || status.name().equals("ON_THE_WAY")) {
                ManageTaskPage page = new ManageTaskPage(runner, selectedTask);
                page.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Please accept to task to manage.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to manage.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_manageButtonActionPerformed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        RunnerMainMenu page = new RunnerMainMenu(runner);
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton manageButton;
    private javax.swing.JButton rejectButton;
    private javax.swing.JTable tasksTable;
    // End of variables declaration//GEN-END:variables

}
