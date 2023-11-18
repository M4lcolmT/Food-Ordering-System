/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package food.ordering.system.CustomerGUI;

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
public class CustomerUserProfile extends javax.swing.JFrame {
    private Customer customer;
    private List<Integer> requestIDs;
    TextFilePaths path = new TextFilePaths();
    String userRequestTextFile  = path.getUserCRUDrequestTextFile();
    
    public CustomerUserProfile(Customer customer) {
        initComponents();
        this.customer = customer;
        
        nameField.setText(customer.getName());
        emailField.setText(customer.getEmail());
        phoneNumberField.setText(customer.getPhoneNumber());
        cityField.setText(customer.getCity());
        streetAddressField.setText(customer.getStreetAddress());
        
        ReadFiles reader = new ReadFiles();
        requestIDs = reader.processAllUserRequestID(userRequestTextFile);
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
    
    private boolean saveRequest(String name, String phoneNumber, String email, String password, String streetAddress, String city) {
        int userRequestID = checkMaxID(requestIDs);
        CustomerRequest newRequest = new CustomerRequest(userRequestID, customer.getCustomerID(),
 UserRequest.UserType.CUSTOMER, UserRequest.RequestType.UPDATEPROFILE, 
        name, phoneNumber,
        email, password, streetAddress, city);
        
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
        streetAddressField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        phoneNumberField = new javax.swing.JTextField();
        nameField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();

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
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("City");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 70, -1, -1));
        jPanel2.add(cityField, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 92, 218, -1));

        streetAddressField.setPreferredSize(new java.awt.Dimension(200, 22));
        jPanel2.add(streetAddressField, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 36, 218, -1));

        jLabel8.setText("Street Address");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 14, -1, -1));

        cancelButton.setText("Cancel");
        cancelButton.setPreferredSize(new java.awt.Dimension(100, 25));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        jPanel2.add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 143, -1, -1));

        jLabel2.setText("Name");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 16, -1, -1));

        saveButton.setText("Save");
        saveButton.setPreferredSize(new java.awt.Dimension(100, 25));
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        jPanel2.add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 143, -1, -1));
        jPanel2.add(phoneNumberField, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 94, 200, -1));
        jPanel2.add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 38, 200, -1));

        jLabel3.setText("Phone Number");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 72, -1, -1));

        jLabel4.setText("Email");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 128, -1, -1));
        jPanel2.add(emailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 146, 200, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(changePassword)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changePassword))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
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
        String streetAddress = streetAddressField.getText();
        
        if (isEmpty(name) || isEmpty(phoneNumber) || isEmpty(email) || isEmpty(streetAddress) || isEmpty(city))  {
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
            if (saveRequest(name, phoneNumber, email, customer.getPassword(), streetAddress, city)) {
                JOptionPane.showMessageDialog(this, "Successfully sent user profile changes request to admin!");
                CustomerMainMenu menu = new CustomerMainMenu(customer);
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
        CustomerChangePassword page = new CustomerChangePassword(customer);
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_changePasswordMouseClicked

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        int confirmationResult = JOptionPane.showConfirmDialog(this, "Unsaved changes, proceed to cancel?", "Cancel Confirmation", JOptionPane.YES_NO_OPTION);        

        if (confirmationResult == JOptionPane.YES_OPTION) {
            CustomerMainMenu menu = new CustomerMainMenu(customer);
            menu.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_cancelButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel changePassword;
    private javax.swing.JTextField cityField;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField phoneNumberField;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField streetAddressField;
    // End of variables declaration//GEN-END:variables
}
