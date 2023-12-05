/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package food.ordering.system.CustomerGUI;

import food.ordering.system.OrderManager;
import food.ordering.system.Order;
import food.ordering.system.ReadFiles;
import food.ordering.system.Review;
import food.ordering.system.RunnerGUI.Runner;
import food.ordering.system.RunnerGUI.Task;
import food.ordering.system.VendorGUI.Vendor;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class GiveReview extends javax.swing.JFrame {
    private Customer customer;
    private int orderID;
    private Order order;
    private List<Task> allTasks;
    private List<Review> allReviews;
    private Task selectedTask;
    private List<Runner> allRunners;
    private List<Vendor> allVendors;
    private double vendorRating;
    private double runnerRating;
    private OrderManager manager = new OrderManager();
    
    DecimalFormat df = new DecimalFormat("#.#");
    
    public GiveReview(Customer customer, int orderID) {
        initComponents();
        this.customer = customer;
        this.orderID = orderID;
        
        order = manager.findOrder(orderID);
        ReadFiles reader = new ReadFiles();
        allTasks = reader.readTasks();
        allReviews = reader.readReviews();
        allVendors = reader.readVendors();
        allRunners = reader.readRunners();
        selectedTask = getTask(orderID);
    }
    
    private Task getTask(int id) {
        for (Task i : allTasks) {
            if (id == i.getOrderID()) {
                return i;
            }
        }
        return null;
    }
    
    private Runner findRunner(int id) {
        for (Runner i : allRunners) {
            if (i.getRunnerID() == id) {
                return i;
            }
        }
        return null;
    }
    
    private Vendor findVendor(int id) {
        for (Vendor i : allVendors) {
            if (i.getVendorID() == id) {
                return i;
            }
        }
        return null;
    }
    
    private void getRunnerVendorRatings() {
        int vendorRatingSum = 0;
        int vendorRatingCount = 0;

        int runnerRatingSum = 0;
        int runnerRatingCount = 0;

        for (Review i : allReviews) {
            int userID = i.getUserID();
            Review.UserType userType = i.getUserType();
            int rating = i.getRating();

            if (order.getVendor().getVendorID() == userID && userType == Review.UserType.VENDOR) {
                vendorRatingSum += rating;
                vendorRatingCount++;
            } else if (selectedTask.getRunnerID() == userID && userType == Review.UserType.RUNNER) {
                runnerRatingSum += rating;
                runnerRatingCount++;
            } else {
                System.out.println("Invalid user id and type!");
            }
        }

        // Calculate averages
        vendorRating = (vendorRatingCount > 0) ? (double) vendorRatingSum / vendorRatingCount : 0.0;
        runnerRating = (runnerRatingCount > 0) ? (double) runnerRatingSum / runnerRatingCount : 0.0;
        vendorRating = Double.parseDouble(df.format(vendorRating));
        runnerRating = Double.parseDouble(df.format(runnerRating));
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        runnerRatingField = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        runnerContentField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        sendReviewButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        vendorContentField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        vendorRatingField = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(75, 124, 182));

        jLabel2.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Give Review");

        jPanel2.setBackground(new java.awt.Color(75, 124, 182));

        jLabel4.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Runner review:");

        jLabel5.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Rating:");

        sendReviewButton.setBackground(new java.awt.Color(255, 255, 254));
        sendReviewButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        sendReviewButton.setText("Send");
        sendReviewButton.setPreferredSize(new java.awt.Dimension(72, 25));
        sendReviewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendReviewButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Vendor review:");

        jLabel3.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Rating:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(runnerContentField, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(runnerRatingField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(vendorContentField, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(vendorRatingField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(sendReviewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vendorContentField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vendorRatingField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(runnerContentField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(runnerRatingField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(sendReviewButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        runnerRatingField.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));
        vendorRatingField.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
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

    private void sendReviewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendReviewButtonActionPerformed
        String vendorContent = vendorContentField.getText();
        int vendorrating = (int) vendorRatingField.getValue();
        String runnerContent = runnerContentField.getText();
        int runnerrating = (int) runnerRatingField.getValue();

        Review vendorReview = new Review(order.getVendor().getVendorID(), Review.UserType.VENDOR, orderID, vendorContent, vendorrating);
        vendorReview.saveReview(vendorReview);
        
        Review runnerReview = new Review(selectedTask.getRunnerID(), Review.UserType.RUNNER, selectedTask.getTaskID(), runnerContent, runnerrating);
        runnerReview.saveReview(runnerReview);
        
        getRunnerVendorRatings();
        Runner runner = findRunner(selectedTask.getRunnerID());
        runner.updateRunnerRating(runner, allRunners, vendorRating);
        Vendor vendor = findVendor(order.getVendor().getVendorID());
        vendor.updateVendorRating(vendor, allVendors, vendorRating);
        JOptionPane.showMessageDialog(this, "Thank you for providing your reviews!", "Order Complete", JOptionPane.INFORMATION_MESSAGE);
        CustomerMainMenu page = new CustomerMainMenu(customer);
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_sendReviewButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField runnerContentField;
    private javax.swing.JSpinner runnerRatingField;
    private javax.swing.JButton sendReviewButton;
    private javax.swing.JTextField vendorContentField;
    private javax.swing.JSpinner vendorRatingField;
    // End of variables declaration//GEN-END:variables
}
