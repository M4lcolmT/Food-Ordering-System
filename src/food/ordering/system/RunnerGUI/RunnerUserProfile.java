/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package food.ordering.system.RunnerGUI;

import food.ordering.system.AdminGUI.ReadFiles;
import food.ordering.system.AdminGUI.UserRequest;
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
public class RunnerUserProfile extends javax.swing.JFrame {
    private Runner runner;
    private List<Integer> requestIDs;
    TextFilePaths path = new TextFilePaths();
    String userRequestTextFile  = path.getUserCRUDrequestTextFile();
    
    public RunnerUserProfile(Runner runner) {
        initComponents();
        this.runner = runner;
        
        nameField.setText(runner.getName());
        emailField.setText(runner.getEmail());
        phoneNumberField.setText(runner.getPhoneNumber());
        cityField.setText(runner.getCity());
        plateNumberField.setText(runner.getPlateNumber());
        vehicleModelField.setText(runner.getVehicleModel());
        
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
    
    private boolean saveRequest(String name, String phoneNumber, String email, String password, String city, String plateNumber, String vehicleModel) {
        int userRequestID = checkMaxID(requestIDs);
        RunnerRequest newRequest = new RunnerRequest(userRequestID, runner.getRunnerID(),
        UserRequest.UserType.RUNNER, UserRequest.RequestType.UPDATEPROFILE, 
        name, phoneNumber,
        email, password, city, plateNumber, vehicleModel);
        
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
        changePassword = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cityField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        phoneNumberField = new javax.swing.JTextField();
        nameField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        plateNumberField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        vehicleModelField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(674, 350));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Edit User Profile");

        changePassword.setFont(new java.awt.Font("Segoe UI", 2, 13)); // NOI18N
        changePassword.setForeground(new java.awt.Color(51, 153, 255));
        changePassword.setText("Change password");
        changePassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changePasswordMouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setText("City");

        jLabel2.setText("Name");

        jLabel3.setText("Phone Number");

        jLabel4.setText("Email");

        jLabel6.setText("Vehicle Plate Number");

        jLabel7.setText("Vehicle Model");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(phoneNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(cityField)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(vehicleModelField)
                            .addComponent(plateNumberField))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(6, 6, 6)
                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(4, 4, 4)
                        .addComponent(cityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(plateNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vehicleModelField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        saveButton.setText("Save");
        saveButton.setPreferredSize(new java.awt.Dimension(100, 25));
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.setPreferredSize(new java.awt.Dimension(100, 25));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(changePassword))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changePassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        String name = nameField.getText();
        String phoneNumber = phoneNumberField.getText();
        String email = emailField.getText();
        String city = cityField.getText();
        String plateNumber = plateNumberField.getText();
        String vehicalModel = vehicleModelField.getText();
        
        if (isEmpty(name) || isEmpty(phoneNumber) || isEmpty(email) || isEmpty(city) || isEmpty(plateNumber) || isEmpty(vehicalModel))  {
           JOptionPane.showMessageDialog(this, "Please fill in all inputs.", "Input Error", JOptionPane.ERROR_MESSAGE);
           return;
        }
        
        if (phoneNumber.length() != 10) {
           JOptionPane.showMessageDialog(this, "Phone number must be 10 digits.", "Input Error", JOptionPane.ERROR_MESSAGE);
           return;
        }
        
        if (!email.contains("@gmail.com")) {
           JOptionPane.showMessageDialog(this, "Enter a valid email address.", "Input Error", JOptionPane.ERROR_MESSAGE);
           return;
        }
        
        int confirmationResult = JOptionPane.showConfirmDialog(this, "Proceed with the new changes?", "Edit Confirmation", JOptionPane.YES_NO_OPTION);        

        if (confirmationResult == JOptionPane.YES_OPTION) {
            if (saveRequest(name, phoneNumber, email, runner.getPassword(), city, plateNumber, vehicalModel)) {
                JOptionPane.showMessageDialog(this, "Successfully sent user profile changes request to admin!");
                RunnerMainMenu menu = new RunnerMainMenu(runner);
                menu.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to send user profile changes request to admin, please revalidate your inputs", "Validation Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "User edit process is cancelled", "Changes Cancelled", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void changePasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changePasswordMouseClicked
        RunnerChangePassword page = new RunnerChangePassword(runner);
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_changePasswordMouseClicked

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        int confirmationResult = JOptionPane.showConfirmDialog(this, "Unsaved changes, proceed to cancel?", "Cancel Confirmation", JOptionPane.YES_NO_OPTION);        

        if (confirmationResult == JOptionPane.YES_OPTION) {
            RunnerMainMenu menu = new RunnerMainMenu(runner);
            menu.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        RunnerMainMenu page = new RunnerMainMenu(runner);
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel changePassword;
    private javax.swing.JTextField cityField;
    private javax.swing.JTextField emailField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField phoneNumberField;
    private javax.swing.JTextField plateNumberField;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField vehicleModelField;
    // End of variables declaration//GEN-END:variables
}
