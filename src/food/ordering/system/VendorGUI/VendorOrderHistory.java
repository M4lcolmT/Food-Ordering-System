/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package food.ordering.system.VendorGUI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.table.DefaultTableModel;
import textFiles.TextFilePaths;

/**
 *
 * @author jiasi
 */
public class VendorOrderHistory extends javax.swing.JFrame {
    private Vendor vendor;
    TextFilePaths path = new TextFilePaths();
    String vendorReviewsTextPath = path.getVendorReviewsTextFile();
    
    public VendorOrderHistory(Vendor vendor) {
        initComponents();
        this.vendor = vendor;
        
        loadReviews();
    }
    
    private void loadReviews() {
        DefaultTableModel model = (DefaultTableModel) orderHistoryTable.getModel();

        try(BufferedReader reader = new BufferedReader(new FileReader(vendorReviewsTextPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 5) {
                    int vendorID = Integer.parseInt(parts[0]);
                    if (vendor.getVendorID() == vendorID) {
                        int orderID = Integer.parseInt(parts[1]);
                        String content = parts[2];
                        Double rating = Double.valueOf(parts[3]);
                        LocalDateTime dateTime = LocalDateTime.parse(parts[4], DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                        String formattedDate = dateTime.format(DateTimeFormatter.ofPattern("dd MMMM yyyy"));
                        String formattedTime = dateTime.format(DateTimeFormatter.ofPattern("HH:mm"));

                        Object[] rowData = {formattedDate, formattedTime, orderID, content, rating};
                        model.addRow(rowData);
                    } else {
                        System.out.println("Skipping unmatched vendor ID orders.");
                    }
                } else {
                    System.out.println("Skipping lines with incorrect parts.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        orderHistoryTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Order History");

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        orderHistoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Time", "Order ID", "Content", "Rating"
            }
        ));
        jScrollPane1.setViewportView(orderHistoryTable);
        if (orderHistoryTable.getColumnModel().getColumnCount() > 0) {
            orderHistoryTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            orderHistoryTable.getColumnModel().getColumn(1).setPreferredWidth(20);
            orderHistoryTable.getColumnModel().getColumn(2).setPreferredWidth(5);
            orderHistoryTable.getColumnModel().getColumn(3).setPreferredWidth(150);
            orderHistoryTable.getColumnModel().getColumn(4).setPreferredWidth(5);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addComponent(backButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backButton)
                .addGap(18, 18, 18))
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

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        VendorMainMenu page = new VendorMainMenu(vendor);
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable orderHistoryTable;
    // End of variables declaration//GEN-END:variables
}
