/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package food.ordering.system.VendorGUI;

import food.ordering.system.AdminGUI.Notification;
import food.ordering.system.AdminGUI.ReadFiles;
import food.ordering.system.AdminGUI.UserProfileNotificationPanel;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import textFiles.TextFilePaths;


public class VendorNotification extends javax.swing.JFrame {
    private Vendor vendor;
    private List<Notification> allNotifications;
    private List<Notification> vendNotifications;
    
    TextFilePaths path = new TextFilePaths();
    String notificationTextFile = path.getNotificationsTextFile();
    
    public VendorNotification(Vendor vendor) {
        initComponents();
        this.vendor = vendor;
        
        ReadFiles reader = new ReadFiles();
        allNotifications = reader.readNotifications();
        vendNotifications = getNotifications();
        populateInnerPanel();
    }
    
    private List<Notification> getNotifications() {
        List<Notification> notifs = new ArrayList<>();
        
        for (Notification item : allNotifications) {
            if (item.getUserType().name().equals("VENDOR") && item.getUserID() == vendor.getVendorID()) {
                notifs.add(item);
            }
        }
        return notifs;
    }
    
    private void populateInnerPanel() {
        innerScrollPanel.removeAll();
        for (Notification item : vendNotifications) {
            String notifType = item.getNotifType().name();
            String updateDesc = item.getUpdateDescription();
            LocalDateTime dateTime = item.getDateTime();
            switch(notifType) {
                case "ORDER":
                    VendorOrderNotificationPanel orderPanel = new VendorOrderNotificationPanel(this, vendor, item.getTransactionID(), updateDesc, dateTime);
                    innerScrollPanel.add(orderPanel);
                    break;
                case "USERPROFILE":
                    UserProfileNotificationPanel userProfilePanel = new UserProfileNotificationPanel(updateDesc, dateTime);
                    innerScrollPanel.add(userProfilePanel);
                    break;
                default:
                    System.out.println("Invalid Notif Type.");
                    break;
            }
        }
        // Repaint and revalidate innerPanel to reflect the changes
        innerScrollPanel.revalidate();
        innerScrollPanel.repaint();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        innerScrollPanel = new javax.swing.JPanel();
        clearNotifButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Notifications");

        innerScrollPanel.setLayout(new javax.swing.BoxLayout(innerScrollPanel, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(innerScrollPanel);

        clearNotifButton.setText("Clear Notifications");
        clearNotifButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearNotifButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(clearNotifButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(305, 305, 305)
                        .addComponent(backButton)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearNotifButton)
                    .addComponent(jLabel1))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(backButton)
                .addGap(14, 14, 14))
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

    private void clearNotifButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearNotifButtonActionPerformed
        int confirmationResult = JOptionPane.showConfirmDialog(this, "Proceed to clear all notifications?", "Delete Confirmation", JOptionPane.YES_NO_OPTION);        

        if (confirmationResult == JOptionPane.YES_OPTION) {
            try {
                List<Notification> customerNotifs = getNotifications();
                allNotifications.removeAll(customerNotifs);
                vendNotifications.clear();

                try (PrintWriter pw = new PrintWriter(new FileWriter(notificationTextFile, false))) {
                    for (Notification notif : allNotifications) {
                        pw.println(notif.toString());                
                    }
                }

                populateInnerPanel();
            } catch (IOException ex) {
                System.out.println("Failed to clear and save notifications: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_clearNotifButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton clearNotifButton;
    private javax.swing.JPanel innerScrollPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
