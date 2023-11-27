/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package food.ordering.system.AdminGUI;


import static food.ordering.system.AdminGUI.CRUDCustomer.generatePassword;
import food.ordering.system.VendorGUI.Vendor;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
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
    private int selectedRow = -1; // Instance variable to store the selected row
    private boolean editMode = false;
    private List<Integer> notificationIDs;
    
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_+=<>?";
    
    TextFilePaths path = new TextFilePaths();
    String vendorTextFile = path.getVendorTextFile();
    
    public CRUDVendor(Admin admin) {
        initComponents();
        this.admin = admin;
        
        ReadFiles reader = new ReadFiles();
        vendors = reader.readVendors();
        notificationIDs = reader.readNotificationID();
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
    
    private void writeToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(vendorTextFile))) {
            // Write each food item to the file
            for (Vendor item : vendors) {
                writer.println(item.toString());
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately (e.g., show an error message)
        }
    }
    
    private boolean isEmpty(String str) {
        return str.trim().isEmpty();
    }
    
    // Password generator
    public static String generatePassword(int length) {
        StringBuilder password = new StringBuilder();
        Random random = new SecureRandom();

        String allCharacters = LOWERCASE + UPPERCASE + DIGITS + SPECIAL_CHARACTERS;

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allCharacters.length());
            char randomChar = allCharacters.charAt(randomIndex);
            password.append(randomChar);
        }

        return password.toString();
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
        generatePasswordButton = new javax.swing.JButton();
        categoryComboBox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        vendorTable = new javax.swing.JTable();

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

        generatePasswordButton.setText("generate");
        generatePasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generatePasswordButtonActionPerformed(evt);
            }
        });

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
                    .addComponent(phoneNumberField)
                    .addComponent(emailField)
                    .addComponent(nameField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(generatePasswordButton)))
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
                    .addComponent(generatePasswordButton)
                    .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        vendorTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Phone Number", "Email", "Password", "Decscription", "Operating hours", "Operating days", "Category"
            }
        ));
        jScrollPane1.setViewportView(vendorTable);

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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jLabel1)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(33, 33, 33))
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
        // Once user is edited, sent notification to customer
        DefaultTableModel model = (DefaultTableModel) vendorTable.getModel();
        if (!editMode) {
        // Enter edit mode
            selectedRow = vendorTable.getSelectedRow();
            if (selectedRow != -1) {
                // Get the current data from the selected row
                String name = (String) model.getValueAt(selectedRow, 1);
                String phoneNumber = (String) model.getValueAt(selectedRow, 2);
                String email = (String) model.getValueAt(selectedRow, 3);
                String password = (String) model.getValueAt(selectedRow, 4);
                String description = (String) model.getValueAt(selectedRow, 5);
                String operationHours = (String) model.getValueAt(selectedRow, 6);
                String operationDays = (String) model.getValueAt(selectedRow, 7);
                String category = (String) model.getValueAt(selectedRow, 8);
                
              
                // Set the current data in the text fields
                nameField.setText(name);
                phoneNumberField.setText(phoneNumber);
                emailField.setText(email);
                passwordField.setText(password);
                descriptionField.setText(description);
                categoryComboBox.setSelectedItem(category);
                
                
                String[] hourParts = operationHours.split("-");
                for (int i = 0; i < startHourComboBox.getItemCount(); i++) {
                    if (hourParts[0].equals(startHourComboBox.getItemAt(i))) {
                        startHourComboBox.setSelectedIndex(i);
                        break;
                    }
                }
                for (int i = 0; i < endHourComboBox.getItemCount(); i++) {
                    if (hourParts[1].equals(endHourComboBox.getItemAt(i))) {
                        endHourComboBox.setSelectedIndex(i);
                        break;
                    }
                }

                String[] dayParts = operationDays.split("-");
                for (int i = 0; i < startDayComboBox.getItemCount(); i++) {
                    if (dayParts[0].equals(startDayComboBox.getItemAt(i))) {
                        startDayComboBox.setSelectedIndex(i);
                        break;
                    }
                }
                for (int i = 0; i < endDayComboBox.getItemCount(); i++) {
                    if (dayParts[1].equals(endDayComboBox.getItemAt(i))) {
                        endDayComboBox.setSelectedIndex(i);
                        break;
                    }
                }
                        editMode = true; // Switch to edit mode
                    } else {
                        JOptionPane.showMessageDialog(this, "Please select a vendor detail to edit", "Empty input", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
        // Save changes
            if (selectedRow != -1) {
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
                

                // Check if changes have been made
                if (!newName.equals(model.getValueAt(selectedRow, 1)) ||
                        !newPhoneNumber.equals(model.getValueAt(selectedRow, 2)) ||
                        !newEmail.equals (model.getValueAt(selectedRow, 3)) ||
                        !newPassword.equals(model.getValueAt(selectedRow, 4)) ||
                        !newDescription.equals(model.getValueAt(selectedRow, 5)) ||
                        !newOperationHours.equals(model.getValueAt(selectedRow, 6)) ||
                        !newOperationDays.equals(model.getValueAt(selectedRow, 7)) ||
                        !newCategory.equals(model.getValueAt(selectedRow,8))){
                        
                    int vendorID = (int) model.getValueAt(selectedRow, 0);
                    Vendor selectedVendor = getVendor(vendorID);
                    selectedVendor.setName(newName);
                    selectedVendor.setPhoneNumber(newPhoneNumber);
                    selectedVendor.setEmail(newEmail);
                    selectedVendor.setPassword(newPassword);
                    selectedVendor.setDescription(newDescription);
                    selectedVendor.setOperationHours(newOperationHours);
                    selectedVendor.setCategory(newCategory);
                    // Remove the old food item
                    vendors.removeIf(item -> item.getVendorID() == selectedVendor.getVendorID());
                    // Add the updated food item
                    vendors.add(selectedVendor);
                    // Write the updated list back to the file
                    writeToFile();
                    JOptionPane.showMessageDialog(this, "Successfully edited Vendor Details", "Success", JOptionPane.INFORMATION_MESSAGE);
                    // Refresh the table with updated data
                    ReadFiles reader = new ReadFiles();
                    vendors = reader.readVendors();
                    loadVendors();
                    nameField.setText("");
                    phoneNumberField.setText("");
                    emailField.setText("");
                    passwordField.setText("");
                    descriptionField.setText("");
                  
                    editMode = false; // Switch back to view mode
                } else {
                    // No changes were made
                    JOptionPane.showMessageDialog(this, "No changes made", "No Changes", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select a Vendor Details to edit", "Empty input", JOptionPane.ERROR_MESSAGE);
            }
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
        
        // Validate input fields
        if (isEmpty(name) || isEmpty(phoneNumber) || isEmpty(email) || isEmpty(password) || category.equals("Select Category")) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return; 
        }
        
        Vendor item = new Vendor(vendorID, name, phoneNumber, email, password, 0, category, "Bukit Jalil", description, newOperationHours, newOperationDays);
        vendors.add(item);
        writeToFile();
        JOptionPane.showMessageDialog(this, "Successfully added Vendor Details", "Success", JOptionPane.INFORMATION_MESSAGE);
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
    }//GEN-LAST:event_addActionPerformed

    private void startHourComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startHourComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startHourComboBoxActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        DefaultTableModel model = (DefaultTableModel) vendorTable.getModel();
        selectedRow = vendorTable.getSelectedRow();
        if (selectedRow != -1) {
            int confirmationResult = JOptionPane.showConfirmDialog(this, "Proceed to delete Vendor Details?", "Delete Confirmation", JOptionPane.YES_NO_OPTION);        
            if (confirmationResult == JOptionPane.YES_OPTION) {
                int vendorID = (int) model.getValueAt(selectedRow, 0);
                Vendor selectedVendor = getVendor(vendorID);
                vendors.removeIf(item -> item.getVendorID() == selectedVendor.getVendorID());
                writeToFile();
                ReadFiles reader = new ReadFiles();
                vendors = reader.readVendors();
                loadVendors();
            } else {
                JOptionPane.showMessageDialog(this, "Action cancelled.", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void generatePasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generatePasswordButtonActionPerformed
        int passwordLength = 9;
        String generatedPassword = generatePassword(passwordLength);
        passwordField.setText(generatedPassword);
    }//GEN-LAST:event_generatePasswordButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JComboBox<String> categoryComboBox;
    private javax.swing.JButton delete;
    private javax.swing.JTextField descriptionField;
    private javax.swing.JButton edit;
    private javax.swing.JTextField emailField;
    private javax.swing.JComboBox<String> endDayComboBox;
    private javax.swing.JComboBox<String> endHourComboBox;
    private javax.swing.JButton generatePasswordButton;
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
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField passwordField;
    private javax.swing.JTextField phoneNumberField;
    private javax.swing.JComboBox<String> startDayComboBox;
    private javax.swing.JComboBox<String> startHourComboBox;
    private javax.swing.JTable vendorTable;
    // End of variables declaration//GEN-END:variables

}
