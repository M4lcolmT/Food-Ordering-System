/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package food.ordering.system.RunnerGUI;

import food.ordering.system.AdminGUI.ReadFiles;
import food.ordering.system.CustomerGUI.Order;
import food.ordering.system.CustomerGUI.OrderManager;
import food.ordering.system.Review;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jiasi
 */
public class TaskHistory extends javax.swing.JFrame {
    private Runner runner;
    private List<Task> allTasks;
    private List<Review> allReviews;
    private final OrderManager manager = new OrderManager();

    public TaskHistory(Runner runner) {
        initComponents();
        this.runner = runner;
        
        ratingLabel.setText(Double.toString(runner.getRatings()));
        ReadFiles reader = new ReadFiles();
        allTasks = reader.readTasks();
        allReviews = reader.readReviews();
        loadReviews();
    }

    private Task getTask(int id) {
        for (Task i : allTasks) {
            if (id == i.getTaskID()) {
                return i;
            }
        }
        return null;
    }
    
    private void loadReviews() {
        DefaultTableModel model = (DefaultTableModel) taskTable.getModel();

        for (Review i : allReviews) {
            int runnerID = i.getUserID();
            Review.UserType userType = i.getUserType();
            int taskID = i.getTypeID();
            String content = i.getReview();
            int rating = i.getRating();
            if (runner.getRunnerID() == runnerID && userType.name().equals("RUNNER")) {
                Task selectedTask = getTask(taskID);
                Order selectedOrder = manager.findOrder(selectedTask.getOrderID());
                LocalDateTime dateTime = selectedTask.getDate();
                String formattedDateTime = dateTime.format(DateTimeFormatter.ofPattern("HH:MM, dd MMMM yyyy"));
                Object[] rowData = {taskID, selectedOrder.getCustomer().getStreetAddress()+", "+selectedOrder.getCustomer().getCity(), "RM"+selectedTask.getDeliveryFee(), content, rating, formattedDateTime};
                model.addRow(rowData);
            } else {
                System.out.println("Skipping unmatched runner ID reviews");
            }
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taskTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        ratingLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("History");

        taskTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Task ID", "Address", "Income", "Feedback", "Rating", "Time/Date"
            }
        ));
        jScrollPane1.setViewportView(taskTable);
        if (taskTable.getColumnModel().getColumnCount() > 0) {
            taskTable.getColumnModel().getColumn(0).setPreferredWidth(5);
            taskTable.getColumnModel().getColumn(2).setPreferredWidth(5);
            taskTable.getColumnModel().getColumn(4).setPreferredWidth(5);
            taskTable.getColumnModel().getColumn(5).setPreferredWidth(100);
        }

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        ratingLabel.setText("-");

        jLabel3.setText("Your Overall Rating");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(166, 166, 166)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ratingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(313, 313, 313)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ratingLabel)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(25, Short.MAX_VALUE))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        RunnerMainMenu page = new RunnerMainMenu(runner);
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel ratingLabel;
    private javax.swing.JTable taskTable;
    // End of variables declaration//GEN-END:variables
}
