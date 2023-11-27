    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package food.ordering.system.AdminGUI;

import food.ordering.system.CustomerGUI.Customer;
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
public class CRUDCustomer extends javax.swing.JFrame {
    private Admin admin;
    private List<Customer> customers;
    private int selectedRow = -1; // Instance variable to store the selected row
    private boolean editMode = false;
    private List<Integer> notificationIDs;
    
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_+=<>?";
    
    TextFilePaths path = new TextFilePaths();
    String customerTextFile = path.getCustomerTextFile();
    
    public CRUDCustomer(Admin admin) {
        initComponents();
        this.admin = admin;
        
        
        ReadFiles reader = new ReadFiles();
        customers = reader.readCustomers();
        notificationIDs = reader.readNotificationID();
        loadCustomers();
    }

    //Load customers into the table
    private void loadCustomers() {
        DefaultTableModel model = (DefaultTableModel) customerTable.getModel();
        
        List<Customer> filteredCustomers = customers.stream()
                .collect(Collectors.toList());
        // Sort the filtered items by ID
        filteredCustomers.sort(Comparator.comparingInt(Customer::getCustomerID));

        // Clear existing rows
        model.setRowCount(0);
        
        for (Customer customer : filteredCustomers) {
            Object[] rowData = { customer.getCustomerID(),customer.getName(), customer.getPhoneNumber(), customer.getEmail()
                    , customer.getPassword(), customer.getStreetAddress(), customer.getCity()};
            model.addRow(rowData);
        }
    }
    
    private Customer getCustomer(int id) {
        for (Customer item : customers) {
            if (id == item.getCustomerID()) {
                return item;
            }
        }
        return null;
    }
    
     public int checkMaxID() {
        int maxID = 0;
        for (Customer item : customers) {
                if (item.getCustomerID() > maxID) {
                    maxID = item.getCustomerID();
                }
            }
        
        // Increment the maximum ID
        return maxID + 1;
    }
    
    private void writeToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(customerTextFile))) {
            // Write each food item to the file
            for (Customer item : customers) {
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
        addButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        phoneNumberField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        addressField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        generatePasswordButton = new javax.swing.JButton();
        passwordField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cityComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        customerTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 500));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Manage Customer Details");

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Name:");

        jLabel3.setText("Phone Number:");

        jLabel4.setText("Email:");

        jLabel5.setText("Address:");

        jLabel11.setText("Password:");

        generatePasswordButton.setText("generate");
        generatePasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generatePasswordButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("City:");

        cityComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select City", "Shah Alam", "Petaling Jaya", "Subang Jaya", "Klang", "Puchong", "Ampang", "Kajang", "Cyberjaya", "Seri Kembangan", "Hulu Langat", "Bukit Jalil" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(phoneNumberField)
                    .addComponent(nameField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(generatePasswordButton, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addressField)
                    .addComponent(emailField, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                    .addComponent(cityComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(phoneNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(cityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(generatePasswordButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        customerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Phone Number", "Email", "Password", "Address", "City"
            }
        ));
        jScrollPane1.setViewportView(customerTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addButton)
                        .addGap(51, 51, 51)
                        .addComponent(editButton)
                        .addGap(59, 59, 59)
                        .addComponent(deleteButton))
                    .addComponent(jLabel1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(editButton)
                    .addComponent(deleteButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // Once user is edited, sent notification to customer
        DefaultTableModel model = (DefaultTableModel) customerTable.getModel();
        if (!editMode) {
        // Enter edit mode
            selectedRow = customerTable.getSelectedRow();
            if (selectedRow != -1) {
                // Get the current data from the selected row
                String name = (String) model.getValueAt(selectedRow, 1);
                String phoneNumber = (String) model.getValueAt(selectedRow, 2);
                String email = (String) model.getValueAt(selectedRow, 3);
                String password = (String) model.getValueAt(selectedRow, 4);
                String address = (String) model.getValueAt(selectedRow, 5);
                String city = (String) model.getValueAt(selectedRow, 6);
                // Set the current data in the text fields
                nameField.setText(name);
                phoneNumberField.setText(phoneNumber);
                emailField.setText(email);
                passwordField.setText(password);
                addressField.setText(address);
                String customerCity = city.trim().toLowerCase();
                for (int i = 0; i < cityComboBox.getItemCount(); i++) {
                    if (customerCity.equals(cityComboBox.getItemAt(i).trim().toLowerCase())) {
                        cityComboBox.setSelectedIndex(i);
                        break;
                    }
                }
                editMode = true; // Switch to edit mode
            } else {
                JOptionPane.showMessageDialog(this, "Please select a food item to edit", "Empty input", JOptionPane.ERROR_MESSAGE);
            }
        } else {
        // Save changes
            if (selectedRow != -1) {
                // Get the updated data from the text fields
                String newName = nameField.getText();
                String newPhoneNumber = phoneNumberField.getText();
                String newEmail = emailField.getText();
                String newPassword = passwordField.getText();
                String newAddress = addressField.getText();
                String newCity = String.valueOf(cityComboBox.getSelectedItem());

                // Check if changes have been made
                if (!newName.equals(model.getValueAt(selectedRow, 1)) ||
                        !newPhoneNumber.equals(model.getValueAt(selectedRow, 2)) ||
                        !newEmail.equals (model.getValueAt(selectedRow, 3)) ||
                        !newPassword.equals(model.getValueAt(selectedRow, 4)) ||
                        !newAddress.equals(model.getValueAt(selectedRow, 5)) ||
                        !newCity.equals(model.getValueAt(selectedRow, 6))) {
                        
                    
                    int customerID = (int) model.getValueAt(selectedRow, 0);
                    Customer selectedVendor = getCustomer(customerID);
                    selectedVendor.setName(newName);
                    selectedVendor.setPhoneNumber(newPhoneNumber);
                    selectedVendor.setEmail(newEmail);
                    selectedVendor.setPassword(newPassword);
                    selectedVendor.setStreetAddress(newAddress);
                    selectedVendor.setCity(newCity);
                    // Remove the old food item
                    customers.removeIf(item -> item.getCustomerID() == selectedVendor.getCustomerID());
                    // Add the updated food item
                    customers.add(selectedVendor);
                    // Write the updated list back to the file
                    writeToFile();
                    JOptionPane.showMessageDialog(this, "Successfully edited Customer Details", "Success", JOptionPane.INFORMATION_MESSAGE);
                    // Refresh the table with updated data
                    ReadFiles reader = new ReadFiles();
                    customers = reader.readCustomers();
                    loadCustomers();
                    nameField.setText("");
                    phoneNumberField.setText("");
                    emailField.setText("");
                    passwordField.setText("");
                    addressField.setText("");
                    cityComboBox.setSelectedIndex(0);
                    editMode = false; // Switch back to view mode
                } else {
                    // No changes were made
                    JOptionPane.showMessageDialog(this, "No changes made", "No Changes", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select a Customer Details to edit", "Empty input", JOptionPane.ERROR_MESSAGE);
            }
        }
                             
        
    }//GEN-LAST:event_editButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        int customerID = checkMaxID();
        String name = nameField.getText();
        String phoneNumber = phoneNumberField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String address = addressField.getText();
        String city = String.valueOf(cityComboBox.getSelectedItem());

        // Validate input fields
        if (isEmpty(name) || isEmpty(phoneNumber) || isEmpty(email) || isEmpty(password) || isEmpty(address) || city.equals("Select City")) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return; 
        }

        Customer item = new Customer(customerID, name, phoneNumber, email, password, address, city);
        customers.add(item);
        writeToFile();
        JOptionPane.showMessageDialog(this, "Successfully added Customer Details", "Success", JOptionPane.INFORMATION_MESSAGE);
        // Refresh the table with updated data
        ReadFiles reader = new ReadFiles();
        customers = reader.readCustomers();
        loadCustomers();
        nameField.setText("");
        phoneNumberField.setText("");
        emailField.setText("");
        passwordField.setText("");
        addressField.setText("");
        cityComboBox.setSelectedIndex(0);
    }//GEN-LAST:event_addButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) customerTable.getModel();
        selectedRow = customerTable.getSelectedRow();
        if (selectedRow != -1) {
            int confirmationResult = JOptionPane.showConfirmDialog(this, "Proceed to delete Customer Details?", "Delete Confirmation", JOptionPane.YES_NO_OPTION);        
            if (confirmationResult == JOptionPane.YES_OPTION) {
                int customerID = (int) model.getValueAt(selectedRow, 0);
                Customer selectedVendor = getCustomer(customerID);
                customers.removeIf(item -> item.getCustomerID() == selectedVendor.getCustomerID());
                writeToFile();
                ReadFiles reader = new ReadFiles();
                customers = reader.readCustomers();
                loadCustomers();
            } else {
                JOptionPane.showMessageDialog(this, "Action cancelled.", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void generatePasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generatePasswordButtonActionPerformed
        int passwordLength = 9;
        String generatedPassword = generatePassword(passwordLength);
        passwordField.setText(generatedPassword);
    }//GEN-LAST:event_generatePasswordButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTextField addressField;
    private javax.swing.JComboBox<String> cityComboBox;
    private javax.swing.JTable customerTable;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JTextField emailField;
    private javax.swing.JButton generatePasswordButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField passwordField;
    private javax.swing.JTextField phoneNumberField;
    // End of variables declaration//GEN-END:variables
}

