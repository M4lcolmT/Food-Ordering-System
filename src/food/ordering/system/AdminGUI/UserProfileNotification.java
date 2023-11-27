/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package food.ordering.system.AdminGUI;

import food.ordering.system.CustomerGUI.CustomerRequest;
import food.ordering.system.CustomerGUI.Order;
import food.ordering.system.CustomerGUI.OrderManager;
import food.ordering.system.RunnerGUI.RunnerRequest;
import food.ordering.system.VendorGUI.VendorRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import textFiles.TextFilePaths;

/**
 *
 * @author LENOVO
 */
public class UserProfileNotification extends javax.swing.JPanel {
    private int userProfileRequestID;
    private UserRequest userRequest;
    private List<CustomerRequest> customerRequests = new ArrayList<>();
    private List<VendorRequest> vendorRequests = new ArrayList<>();
    private List<RunnerRequest> runnerRequests = new ArrayList<>();
    
    public UserProfileNotification(int userProfileRequestID) {
        initComponents();
        this.userProfileRequestID = userProfileRequestID;
        
        ReadFiles reader = new ReadFiles();
        reader.readUserRequests(customerRequests, vendorRequests, runnerRequests);
        userRequest = findUserRequest();
        
        if (userRequest.getRequestType().name().equals("CHANGEPASSWORD")) {
            updateLabel.setText("Your password is changed!");
        } else if (userRequest.getRequestType().name().equals("UPDATEPROFILE")){
            updateLabel.setText("Your profile is updated!");
        }
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy, HH:mm");
        String formattedDateTime = dateTime.format(formatter);
        dateTimeLabel.setText(formattedDateTime);
    }
    
    private UserRequest findUserRequest() {
        for (UserRequest item : customerRequests) {
            if (item.getUserRequestID() == userProfileRequestID) {
                return item;
            }
        }
        return null;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        updateLabel = new javax.swing.JLabel();
        dateTimeLabel = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));

        updateLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        updateLabel.setText("Your profile is updated!");

        dateTimeLabel.setText("Date & Time");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updateLabel)
                    .addComponent(dateTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(376, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(updateLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateTimeLabel)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dateTimeLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel updateLabel;
    // End of variables declaration//GEN-END:variables
}
