/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package food.ordering.system.CustomerGUI;

import food.ordering.system.AdminGUI.Notification;
import food.ordering.system.AdminGUI.OrderNotification;
import food.ordering.system.AdminGUI.ReadFiles;
import food.ordering.system.AdminGUI.UserProfileNotification;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jiasi
 */
public class CustomerNotification extends javax.swing.JFrame {
    private Customer customer;
    private List<Notification> allNotifications;
    private List<Notification> custNotifications;
    
    public CustomerNotification(Customer customer) {
        initComponents();
        this.customer = customer;
        
        ReadFiles reader = new ReadFiles();
        allNotifications = reader.readNotifications();
        custNotifications = getNotifications();
        populateInnerPanel();
    }
    
    private List<Notification> getNotifications() {
        List<Notification> notifs = new ArrayList<>();
        
        for (Notification item : allNotifications) {
            if (item.getUserType().name().equals("CUSTOMER") && item.getUserID() == customer.getCustomerID()) {
                notifs.add(item);
            }
        }
        return notifs;
    }
    
    private void populateInnerPanel() {
        innerScrollPanel.removeAll();
        for (Notification item : custNotifications) {
            String notifType = item.getNotifType().name();
            switch(notifType) {
                case "ORDER":
                    OrderNotification orderPanel = new OrderNotification(item.getTypeID());
                    innerScrollPanel.add(orderPanel);
                    break;
                case "USERPROFILE":
                    UserProfileNotification userProfilePanel = new UserProfileNotification(item.getTypeID());
                    innerScrollPanel.add(userProfilePanel);
                    break;
                case "TOPUP":
                    TransactionNotification transactionPanel = new TransactionNotification(customer, item.getTypeID());
                    innerScrollPanel.add(transactionPanel);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(305, 305, 305)
                        .addComponent(backButton)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
        // TODO add your handling code here:
    }//GEN-LAST:event_backButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JPanel innerScrollPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
