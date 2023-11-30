/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package food.ordering.system.AdminGUI;


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
    
    public int checkMaxNotificationID() {
        int maxID = 0;
        for (Notification i : notifications) {
                if (i.getNotificationID() > maxID) {
                    maxID = i.getNotificationID();
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
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 500));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Manage Vendor Details");

        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        jLabel2.setText("Name:");

        jLabel3.setText("Phone Number: ");

        jLabel4.setText("Description:");

        jLabel6.setText("Email:");

        jLabel7.setText("Operating hours:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("to");

        startHourComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "9:00am", "10:00am", "11:00am", "12:00pm", "1:00pm", "2:00pm", "3:00pm", "4:00pm", "5:00pm", "6:00pm", "7:00pm", "8:00pm", "9:00pm", "10:00pm", "11:00pm", "12:00am", "1:00am", "2:00am", "3:00am", "4:00am", "5:00am", "6:00am", "7:00am", "8:00am" }));
        startHourComboBox.setMinimumSize(new java.awt.Dimension(11, 22));
        startHourComboBox.setPreferredSize(new java.awt.Dimension(120, 22));
        startHourComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startHourComboBoxActionPerformed(evt);
            }
        });

        jLabel9.setText("Operating days:");

        endHourComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10:00pm", "11:00pm", "12:00am", "1:00am", "2:00am", "3:00am", "4:00am", "5:00am", "6:00am", "7:00am", "8:00am", "9:00am", "10:00am", "11:00am", "12:00pm", "1:00pm", "2:00pm", "3:00pm", "4:00pm", "5:00pm", "6:00pm", "7:00pm", "8:00pm", "9:00pm" }));
        endHourComboBox.setMinimumSize(new java.awt.Dimension(11, 22));
        endHourComboBox.setPreferredSize(new java.awt.Dimension(120, 22));

        endDayComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday" }));
        endDayComboBox.setMinimumSize(new java.awt.Dimension(11, 22));
        endDayComboBox.setPreferredSize(new java.awt.Dimension(120, 22));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("to");

        startDayComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" }));
        startDayComboBox.setMinimumSize(new java.awt.Dimension(11, 22));
        startDayComboBox.setPreferredSize(new java.awt.Dimension(120, 22));

        jLabel11.setText("Password:");

        categoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Category", "Non-Halal", "Fast Food", "Western", "Korean", "Chinese", "Malay" }));

        jLabel5.setText("Category:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(phoneNumberField, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(emailField)
                    .addComponent(nameField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(passwordField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(startHourComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel8))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addComponent(startDayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel10)))
                            .addGap(12, 12, 12)
                            .addComponent(endHourComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(descriptionField)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(endDayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(phoneNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(descriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(startHourComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(startDayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(endHourComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(endDayComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        vendorTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Phone Number", "Email", "Password", "Decscription", "Operating hours", "Operating days", "Category"
            }
        ));
        jScrollPane1.setViewportView(vendorTable);

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
                        .addGap(23, 23, 23)
                        .addComponent(add)
                        .addGap(51, 51, 51)
                        .addComponent(edit)
                        .addGap(59, 59, 59)
                        .addComponent(delete))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1)
                                .addComponent(jLabel1)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add)
                    .addComponent(edit)
                    .addComponent(delete))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButton1))
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
                Notification newNotif = new Notification(checkMaxNotificationID(), Notification.NotifType.USERPROFILE, selectedVendor.getVendorID(), Notification.NotifUserType.VENDOR, 0, "Your profile is updated!", LocalDateTime.now());
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        AdminMainMenu page = new AdminMainMenu(admin);
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    public javax.swing.JComboBox<String> categoryComboBox;
    private javax.swing.JButton delete;
    public javax.swing.JTextField descriptionField;
    private javax.swing.JButton edit;
    public javax.swing.JTextField emailField;
    public javax.swing.JComboBox<String> endDayComboBox;
    public javax.swing.JComboBox<String> endHourComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
