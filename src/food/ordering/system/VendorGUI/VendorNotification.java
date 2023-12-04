/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package food.ordering.system.VendorGUI;

import food.ordering.system.Notification;
import food.ordering.system.ReadFiles;
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
                    VendorOrderNotificationPanel orderPanel = new VendorOrderNotificationPanel(this, vendor, item.getTypeID(), updateDesc, dateTime);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        innerScrollPanel = new javax.swing.JPanel();
        clearNotifButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        innerScrollPanel.setLayout(new javax.swing.BoxLayout(innerScrollPanel, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(innerScrollPanel);

        clearNotifButton.setBackground(new java.awt.Color(255, 255, 254));
        clearNotifButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        clearNotifButton.setText("Clear Notifications");
        clearNotifButton.setPreferredSize(new java.awt.Dimension(135, 25));
        clearNotifButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearNotifButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        jLabel1.setText("Notifications");

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        jLabel12.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
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
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(322, 322, 322)
                        .addComponent(clearNotifButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(clearNotifButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
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

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        VendorMainMenu page = new VendorMainMenu(vendor);
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearNotifButton;
    private javax.swing.JPanel innerScrollPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
