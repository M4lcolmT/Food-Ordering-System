/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package food.ordering.system.VendorGUI;

import food.ordering.system.ReadFiles;
import food.ordering.system.UserRequest;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.swing.JOptionPane;
import textFiles.TextFilePaths;

/**
 *
 * @author LENOVO
 */
public class VendorChangePassword extends javax.swing.JFrame {
    private Vendor vendor;
    private List<Integer> requestIDs;
    TextFilePaths path = new TextFilePaths();
    String userRequestTextFile  = path.getUserCRUDrequestTextFile();
    
    public VendorChangePassword(Vendor vendor) {
        initComponents();
        this.vendor = vendor;
        
        ReadFiles reader = new ReadFiles();
        requestIDs = reader.readUserRequestID();
    }

    private boolean isEmpty(String s) {
        return s == null || s.trim().isEmpty();
    }
    
    public int checkMaxID(List<Integer> requests) {
        int maxID = 0;
        for (Integer id : requests) {
            if (id > maxID) {
                maxID = id;
            }
        }
        // Increment the maximum ID
        return maxID + 1;
    }
    
    private boolean saveRequest(String password) {
        int userRequestID = checkMaxID(requestIDs);
        VendorRequest newRequest = new VendorRequest(userRequestID, vendor.getVendorID(),
        UserRequest.UserType.CUSTOMER, UserRequest.RequestType.CHANGEPASSWORD,
        vendor.getName(), vendor.getPhoneNumber(), vendor.getEmail(), password, 
        vendor.getCity(), vendor.getCategory(), vendor.getDescription(), 
        vendor.getOperationHours(), vendor.getOperationDays());
        
        try (PrintWriter pw = new PrintWriter(new FileWriter(userRequestTextFile, true))) {
            pw.println(newRequest.toString());
        } catch (IOException ex) {
            System.out.println("Error!");
            return false;
        }
        return true;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        passwordField = new javax.swing.JPasswordField();
        confirmPasswordField = new javax.swing.JPasswordField();
        resetButton = new javax.swing.JButton();
        passwordLabel = new javax.swing.JLabel();
        confirmPasswordLabel = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 102));
        jLabel1.setText("Change Password");

        jLabel2.setText("Enter a new password below to change your password.");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        passwordField.setPreferredSize(new java.awt.Dimension(200, 22));
        jPanel2.add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 208, -1));
        jPanel2.add(confirmPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 208, -1));

        resetButton.setBackground(new java.awt.Color(255, 255, 254));
        resetButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        resetButton.setText("Reset Password");
        resetButton.setPreferredSize(new java.awt.Dimension(118, 25));
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });
        jPanel2.add(resetButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, -1));

        passwordLabel.setForeground(new java.awt.Color(102, 102, 102));
        passwordLabel.setText("Password");
        jPanel2.add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        confirmPasswordLabel.setForeground(new java.awt.Color(102, 102, 102));
        confirmPasswordLabel.setText("Confirm Password");
        jPanel2.add(confirmPasswordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
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
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel1))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel12))
                .addContainerGap(28, Short.MAX_VALUE))
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

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();
        
        if (!confirmPassword.equals(password) || isEmpty(password) || isEmpty(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Password entered does not match.", "Invalid Password", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (password.equals(vendor.getPassword())) {
            JOptionPane.showMessageDialog(this, "Please enter a new password.", "Invalid Password", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int confirmationResult = JOptionPane.showConfirmDialog(this, "Proceed to reset password?", "Reset Password Confirmation", JOptionPane.YES_NO_OPTION);        

        if (confirmationResult == JOptionPane.YES_OPTION) {
            if (saveRequest(password)) {
                JOptionPane.showMessageDialog(this, "Successfully sent password reset request to admin!");
                VendorMainMenu menu = new VendorMainMenu(vendor);
                menu.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to send password reset request to admin, please revalidate your inputs", "Validation Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "User edit process is cancelled", "Changes Cancelled", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_resetButtonActionPerformed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        VendorMainMenu page = new VendorMainMenu(vendor);
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField confirmPasswordField;
    private javax.swing.JLabel confirmPasswordLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JButton resetButton;
    // End of variables declaration//GEN-END:variables
}
