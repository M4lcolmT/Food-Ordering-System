/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package food.ordering.system.CustomerGUI;

import food.ordering.system.OrderManager;
import food.ordering.system.Order;
import food.ordering.system.VendorGUI.*;
import food.ordering.system.ReadFiles;
import food.ordering.system.Review;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jiasi
 */
public class VendorReviews extends javax.swing.JFrame {
    private Vendor vendor;
    private List<Review> allReviews;
    private OrderManager manager = new OrderManager();
    private Menu menu;
    
    public VendorReviews(Menu menu, Vendor vendor) {
        initComponents();
        this.menu = menu;
        this.vendor = vendor;
        
        vendorNameLabel.setText(vendor.getName()+" reviews");
        ReadFiles reader = new ReadFiles();
        allReviews = reader.readReviews();
        loadReviews();
    }
    
    // Load the reviews from the text file and into the jTable
    private void loadReviews() {
        DefaultTableModel model = (DefaultTableModel) vendorReviewTable.getModel();

        for (Review i : allReviews) {
            int vendorID = i.getUserID();
            Review.UserType userType = i.getUserType();
            int orderID = i.getTypeID();
            String content = i.getReview();
            int rating = i.getRating();
            if (vendor.getVendorID() == vendorID && userType.name().equals("VENDOR")) {
                Order selectedOrder = manager.findOrder(orderID);
                LocalDateTime dateTime = selectedOrder.getDateTime();
                String formattedDateTime = dateTime.format(DateTimeFormatter.ofPattern("HH:MM, dd MMMM yyyy"));
             
                Object[] rowData = {selectedOrder.getCustomer().getName(), content, rating, formattedDateTime};
                model.addRow(rowData);
            } else {
                System.out.println("Skipping unmatched vendor ID reviews");
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        vendorNameLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        vendorReviewTable = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        vendorNameLabel.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        vendorNameLabel.setText("-");

        vendorReviewTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer Name", "Feedback", "Rating", "Time/Date"
            }
        ));
        jScrollPane1.setViewportView(vendorReviewTable);
        if (vendorReviewTable.getColumnModel().getColumnCount() > 0) {
            vendorReviewTable.getColumnModel().getColumn(1).setPreferredWidth(150);
            vendorReviewTable.getColumnModel().getColumn(2).setPreferredWidth(5);
            vendorReviewTable.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vendorNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vendorNameLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
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

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel10MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel vendorNameLabel;
    private javax.swing.JTable vendorReviewTable;
    // End of variables declaration//GEN-END:variables
}
