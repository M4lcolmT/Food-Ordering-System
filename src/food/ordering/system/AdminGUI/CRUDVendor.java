/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package food.ordering.system.AdminGUI;


import food.ordering.system.Notification;
import food.ordering.system.ReadFiles;
import food.ordering.system.VendorGUI.Vendor;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import textFiles.TextFilePaths;

/**
 *
 * @author LENOVO
 */
public class CRUDVendor extends javax.swing.JFrame {
    private Admin admin;
    List<Vendor> vendors;
    public int userRequestVendorID = 0;
    private List<Notification> notifications;
    
    TextFilePaths path = new TextFilePaths();
    String vendorTextFile = path.getVendorTextFile();
    String notificationTextFile = path.getNotificationsTextFile();

    public CRUDVendor(Admin admin) {
        initComponents();
        this.admin = admin;
        
        ReadFiles reader = new ReadFiles();
        vendors = reader.readVendors();
        notifications = reader.readNotifications();
        loadVendors();
    }
    
    //Load vendors into the table
    private void loadVendors() {
        DefaultTableModel model = (DefaultTableModel) vendorTable.getModel();
        
        List<Vendor> filteredVendors = vendors.stream()
                .collect(Collectors.toList());
        // Sort the filtered items by ID
        filteredVendors.sort(Comparator.comparingInt(Vendor::getVendorID));

        // Clear existing rows
        model.setRowCount(0);
        
        for (Vendor vendor : filteredVendors) {
            Object[] rowData = { vendor.getVendorID(),vendor.getName(), vendor.getPhoneNumber(), vendor.getEmail()
                    , vendor.getPassword(), vendor.getDescription(), vendor.getOperationHours(), vendor.getOperationDays(), vendor.getCategory()};
            model.addRow(rowData);
        }
    }
    
    private Vendor getVendor(int id) {
        for (Vendor item : vendors) {
            if (id == item.getVendorID()) {
                return item;
            }
        }
        return null;
    }
    
    // Check max id in vendor text file to create new vendors
    public int checkMaxID() {
        int maxID = 0;
        for (Vendor item : vendors) {
                if (item.getVendorID() > maxID) {
                    maxID = item.getVendorID();
                }
            }
        
        // Increment the maximum ID
        return maxID + 1;
    }
    
    private void writeNotificationToFile() {        
        try (PrintWriter writer = new PrintWriter(new FileWriter(notificationTextFile))) {
            for (Notification item : notifications) {
                writer.println(item.toString());
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately (e.g., show an error message)
        }
    }
    
    private void writeVendorToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(vendorTextFile))) {
            for (Vendor item : vendors) {
                writer.println(item.toString());
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately (e.g., show an error message)
        }
    }
    
    // Write vendor and refresh vendor table
    private void createNewVendors() {
        writeVendorToFile();
        // Refresh the table with updated data
        ReadFiles reader = new ReadFiles();
        vendors = reader.readVendors();
        loadVendors();
        nameField.setText("");
        phoneNumberField.setText("");
        emailField.setText("");
        passwordField.setText("");
        descriptionField.setText("");
        categoryComboBox.setSelectedIndex(0);
    }
    
    private boolean isEmpty(String str) {
        return str.trim().isEmpty();
    }
    
    public int getUserRequestVendorID() {
        DefaultTableModel model = (DefaultTableModel) vendorTable.getModel();
        int rowCount = model.getRowCount();

        for (int i = 0; i < rowCount; i++) {
            int vendorid = (int) model.getValueAt(i, 0);
            if (vendorid == userRequestVendorID) {
                return vendorid; // Return the customer ID if ID matches
            }
        }
        return -1; // Return -1 if no matching ID is found
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        phoneNumberField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        descriptionField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        startHourComboBox = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        endHourComboBox = new javax.swing.JComboBox<>();
        endDayComboBox = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        startDayComboBox = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        passwordField = new javax.swing.JTextField();
        categoryComboBox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        vendorTable = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 500));

        jLabel1.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        jLabel1.setText("Manage Vendor Details");

        add.setBackground(new java.awt.Color(255, 255, 254));
        add.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        edit.setBackground(new java.awt.Color(255, 255, 254));
        edit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(255, 255, 254));
        delete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Name:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 9, -1, -1));
        jPanel2.add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 6, 177, -1));
        jPanel2.add(phoneNumberField, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 40, 177, -1));

        jLabel3.setText("Phone Number: ");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 43, -1, -1));
        jPanel2.add(descriptionField, new org.netbeans.lib.awtextra.AbsoluteConstraints(386, 6, 266, -1));

        jLabel4.setText("Description:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(317, 9, -1, -1));
        jPanel2.add(emailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 74, 177, -1));

        jLabel6.setText("Email:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 77, -1, -1));

        jLabel7.setText("Operating hours:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 43, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("to");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(511, 40, -1, -1));

        startHourComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "9:00am", "10:00am", "11:00am", "12:00pm", "1:00pm", "2:00pm", "3:00pm", "4:00pm", "5:00pm", "6:00pm", "7:00pm", "8:00pm", "9:00pm", "10:00pm", "11:00pm", "12:00am", "1:00am", "2:00am", "3:00am", "4:00am", "5:00am", "6:00am", "7:00am", "8:00am" }));
        startHourComboBox.setMinimumSize(new java.awt.Dimension(11, 22));
        startHourComboBox.setPreferredSize(new java.awt.Dimension(120, 22));
        startHourComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startHourComboBoxActionPerformed(evt);
            }
        });
        jPanel2.add(startHourComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(386, 40, 113, -1));

        jLabel9.setText("Operating days:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 77, -1, -1));

        endHourComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10:00pm", "11:00pm", "12:00am", "1:00am", "2:00am", "3:00am", "4:00am", "5:00am", "6:00am", "7:00am", "8:00am", "9:00am", "10:00am", "11:00am", "12:00pm", "1:00pm", "2:00pm", "3:00pm", "4:00pm", "5:00pm", "6:00pm", "7:00pm", "8:00pm", "9:00pm" }));
        endHourComboBox.setMinimumSize(new java.awt.Dimension(11, 22));
        endHourComboBox.setPreferredSize(new java.awt.Dimension(120, 22));
        jPanel2.add(endHourComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 40, 115, -1));

        endDayComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday" }));
        endDayComboBox.setMinimumSize(new java.awt.Dimension(11, 22));
        endDayComboBox.setPreferredSize(new java.awt.Dimension(120, 22));
        jPanel2.add(endDayComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 74, 115, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("to");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 74, -1, -1));

        startDayComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" }));
        startDayComboBox.setMinimumSize(new java.awt.Dimension(11, 22));
        startDayComboBox.setPreferredSize(new java.awt.Dimension(120, 22));
        jPanel2.add(startDayComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 74, 113, -1));

        jLabel11.setText("Password:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 111, -1, -1));
        jPanel2.add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 108, 177, -1));

        categoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Category", "Non-Halal", "Fast Food", "Western", "Korean", "Chinese", "Malay" }));
        jPanel2.add(categoryComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 108, 265, -1));

        jLabel5.setText("Category:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(329, 111, -1, -1));

        vendorTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Phone No.", "Email", "Password", "Decscription", "Hours", "Days", "Category"
            }
        ));
        jScrollPane1.setViewportView(vendorTable);
        if (vendorTable.getColumnModel().getColumnCount() > 0) {
            vendorTable.getColumnModel().getColumn(0).setPreferredWidth(5);
        }

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(add)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(delete))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add)
                    .addComponent(edit)
                    .addComponent(delete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // Get the updated data from the text fields
        String newName = nameField.getText();
        String newPhoneNumber = phoneNumberField.getText();
        String newEmail = emailField.getText();
        String newPassword = passwordField.getText();
        String newDescription = descriptionField.getText();
        String startHour = String.valueOf(startHourComboBox.getSelectedItem());
        String endHour = String.valueOf(endHourComboBox.getSelectedItem());
        String newOperationHours = startHour+"-"+endHour;
        String startDay = String.valueOf(startDayComboBox.getSelectedItem());
        String endDay = String.valueOf(endDayComboBox.getSelectedItem());
        String newOperationDays = startDay+"-"+endDay; 
        String newCategory = String.valueOf(categoryComboBox.getSelectedItem());

        // Prompt admin to go to manage user request page to edit user profile
        if (!newName.equals("") ||
                !newPhoneNumber.equals("") ||
                !newEmail.equals ("") ||
                !newPassword.equals("") ||
                !newDescription.equals("") ||
                !newOperationHours.equals("") ||
                !newOperationDays.equals("") ||
                !newCategory.equals("")){
            
            int id = getUserRequestVendorID();
            if (id!=-1) { // Check if the selected user is an existing user
                Vendor selectedVendor = getVendor(id);
                selectedVendor.setName(newName);
                selectedVendor.setPhoneNumber(newPhoneNumber);
                selectedVendor.setEmail(newEmail);
                selectedVendor.setPassword(newPassword);
                selectedVendor.setDescription(newDescription);
                selectedVendor.setOperationHours(newOperationHours);
                selectedVendor.setCategory(newCategory);
                createNewVendors();
                Notification newNotif = new Notification(Notification.NotifType.USERPROFILE, selectedVendor.getVendorID(), Notification.NotifUserType.VENDOR, 0, "Your profile is updated!", LocalDateTime.now());
                notifications.add(newNotif);
                writeNotificationToFile();
                JOptionPane.showMessageDialog(this, "Successfully edited Vendor Details", "Success", JOptionPane.INFORMATION_MESSAGE);
                userRequestVendorID = 0;
            } else {
                JOptionPane.showMessageDialog(this, "New user found, please select the add button instead.", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Proceed to Manage User Requests page to edit user profile details.", "Error", JOptionPane.INFORMATION_MESSAGE);
        }        
    }//GEN-LAST:event_editActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        int vendorID = checkMaxID();
        String name = nameField.getText();
        String phoneNumber = phoneNumberField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String category = String.valueOf(categoryComboBox.getSelectedItem());
        String description = descriptionField.getText();
        String startHour = String.valueOf(startHourComboBox.getSelectedItem());
        String endHour = String.valueOf(endHourComboBox.getSelectedItem());
        String newOperationHours = startHour+"-"+endHour;
        String startDay = String.valueOf(startDayComboBox.getSelectedItem());
        String endDay = String.valueOf(endDayComboBox.getSelectedItem());
        String newOperationDays = startDay+"-"+endDay;
        
        if (!name.equals("") ||
                        !phoneNumber.equals("") ||
                        !email.equals ("") ||
                        !password.equals("") ||
                        !category.equals("Select Category") ||
                        !description.equals("")) {
            Vendor item = new Vendor(vendorID, name, phoneNumber, email, password, 0, category, "Bukit Jalil", description, newOperationHours, newOperationDays);
            vendors.add(item);
            JOptionPane.showMessageDialog(this, "Successfully added the new Vendor!", "Success", JOptionPane.INFORMATION_MESSAGE);
            createNewVendors();
            userRequestVendorID = 0;
        } else {
            JOptionPane.showMessageDialog(this, "Proceed to Manage User Requests page to add new users.", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_addActionPerformed

    private void startHourComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startHourComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startHourComboBoxActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        int id = getUserRequestVendorID();
        if (id!=-1) {
            Vendor selectedVendor = getVendor(id);
            vendors.removeIf(item -> item.getVendorID() == selectedVendor.getVendorID());
            createNewVendors();
            userRequestVendorID = 0;
        } else {
            JOptionPane.showMessageDialog(this, "Proceed to Manage User Requests page to delete users.", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        AdminMainMenu page = new AdminMainMenu(admin);
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel13MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    public javax.swing.JComboBox<String> categoryComboBox;
    private javax.swing.JButton delete;
    public javax.swing.JTextField descriptionField;
    private javax.swing.JButton edit;
    public javax.swing.JTextField emailField;
    public javax.swing.JComboBox<String> endDayComboBox;
    public javax.swing.JComboBox<String> endHourComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField nameField;
    public javax.swing.JTextField passwordField;
    public javax.swing.JTextField phoneNumberField;
    public javax.swing.JComboBox<String> startDayComboBox;
    public javax.swing.JComboBox<String> startHourComboBox;
    private javax.swing.JTable vendorTable;
    // End of variables declaration//GEN-END:variables

}
