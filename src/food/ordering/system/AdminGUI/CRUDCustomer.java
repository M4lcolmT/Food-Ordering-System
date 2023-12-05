    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package food.ordering.system.AdminGUI;

import food.ordering.system.Notification;
import food.ordering.system.ReadFiles;
import food.ordering.system.CustomerGUI.Customer;
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
public class CRUDCustomer extends javax.swing.JFrame {
    private Admin admin;
    private List<Customer> customers;
    public int userRequestCustomerID = 0;
    private List<Notification> notifications;
    
    TextFilePaths path = new TextFilePaths();
    String customerTextFile = path.getCustomerTextFile();    
    String notificationTextFile = path.getNotificationsTextFile();

    public CRUDCustomer(Admin admin) {
        initComponents();
        this.admin = admin;
        
        ReadFiles reader = new ReadFiles();
        customers = reader.readCustomers();
        notifications = reader.readNotifications();
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
    
    // Check max id in customer text file to create new customers
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
    
    private void writeCustomerToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(customerTextFile))) {
            for (Customer item : customers) {
                writer.println(item.toString());
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately (e.g., show an error message)
        }
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
    
    // Write customer and refresh customer table
    private void createNewCustomers() {
        writeCustomerToFile();
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
    }
    
    public int getUserRequestCustomerID() {
        DefaultTableModel model = (DefaultTableModel) customerTable.getModel();
        int rowCount = model.getRowCount();

        for (int i = 0; i < rowCount; i++) {
            int customerId = (int) model.getValueAt(i, 0);
            if (customerId == userRequestCustomerID) {
                return customerId; // Return the customer ID if ID matches
            }
        }
        return -1; // Return -1 if no matching ID is found
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
        passwordField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cityComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        customerTable = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 500));

        jLabel1.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        jLabel1.setText("Manage Customer Details");

        addButton.setBackground(new java.awt.Color(255, 255, 254));
        addButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        editButton.setBackground(new java.awt.Color(255, 255, 254));
        editButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        deleteButton.setBackground(new java.awt.Color(255, 255, 254));
        deleteButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Name:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 16, -1, -1));
        jPanel2.add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 13, 200, -1));
        jPanel2.add(phoneNumberField, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 47, 200, -1));

        jLabel3.setText("Phone Number:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 50, -1, -1));
        jPanel2.add(addressField, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 47, 246, -1));
        jPanel2.add(emailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 13, 246, -1));

        jLabel4.setText("Email:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 16, -1, -1));

        jLabel5.setText("Address:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 50, -1, -1));

        jLabel11.setText("Password:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 85, -1, -1));
        jPanel2.add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 81, 200, 25));

        jLabel6.setText("City:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 85, -1, -1));

        cityComboBox.setBackground(new java.awt.Color(255, 255, 254));
        cityComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select City", "Shah Alam", "Petaling Jaya", "Subang Jaya", "Klang", "Puchong", "Ampang", "Kajang", "Cyberjaya", "Seri Kembangan", "Hulu Langat", "Bukit Jalil" }));
        cityComboBox.setPreferredSize(new java.awt.Dimension(120, 25));
        jPanel2.add(cityComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 81, 246, -1));

        customerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Phone Number", "Email", "Password", "Address", "City"
            }
        ));
        jScrollPane1.setViewportView(customerTable);
        if (customerTable.getColumnModel().getColumnCount() > 0) {
            customerTable.getColumnModel().getColumn(0).setPreferredWidth(5);
        }

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addButton)
                        .addGap(18, 18, 18)
                        .addComponent(deleteButton)
                        .addGap(18, 18, 18)
                        .addComponent(editButton))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(editButton)
                    .addComponent(deleteButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
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
        // Get the updated data from the text fields
        String newName = nameField.getText();
        String newPhoneNumber = phoneNumberField.getText();
        String newEmail = emailField.getText();
        String newPassword = passwordField.getText();
        String newAddress = addressField.getText();
        String newCity = String.valueOf(cityComboBox.getSelectedItem());
        
        if (!newName.equals("") ||
                        !newPhoneNumber.equals("") ||
                        !newEmail.equals ("") ||
                        !newPassword.equals("") ||
                        !newAddress.equals("") ||
                        !newCity.equals("Select City")) {
            int id = getUserRequestCustomerID();
            if (id!=-1) { // Check if the selected user is an existing user
                Customer selectedCustomer = getCustomer(id);
                selectedCustomer.setName(newName);
                selectedCustomer.setPhoneNumber(newPhoneNumber);
                selectedCustomer.setEmail(newEmail);
                selectedCustomer.setPassword(newPassword);
                selectedCustomer.setStreetAddress(newAddress);
                selectedCustomer.setCity(newCity);
                createNewCustomers();
                Notification newNotif = new Notification(Notification.NotifType.USERPROFILE, selectedCustomer.getCustomerID(), Notification.NotifUserType.CUSTOMER, 0, "Your profile is updated!", LocalDateTime.now());
                notifications.add(newNotif);
                writeNotificationToFile();
                JOptionPane.showMessageDialog(this, "Successfully edited Customer Details", "Success", JOptionPane.INFORMATION_MESSAGE);
                userRequestCustomerID = 0;
            } else {
                JOptionPane.showMessageDialog(this, "New user found, please select the add button instead.", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Proceed to Manage User Requests page to edit user profile details.", "Error", JOptionPane.INFORMATION_MESSAGE);
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
        
        if (!name.equals("") ||
                        !phoneNumber.equals("") ||
                        !email.equals ("") ||
                        !password.equals("") ||
                        !address.equals("") ||
                        !city.equals("Select City")) {
            Customer item = new Customer(customerID, name, phoneNumber, email, password, address, city, 0);
            customers.add(item);
            JOptionPane.showMessageDialog(this, "Successfully added the new Customer!", "Success", JOptionPane.INFORMATION_MESSAGE);
            createNewCustomers();
            userRequestCustomerID = 0;
        } else {
            JOptionPane.showMessageDialog(this, "Proceed to Manage User Requests page to add new users.", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int id = getUserRequestCustomerID();
        if (id!=-1) {
            Customer selectedCustomer = getCustomer(id);
            customers.removeIf(item -> item.getCustomerID() == selectedCustomer.getCustomerID());
            createNewCustomers();
            userRequestCustomerID = 0;
        } else {
            JOptionPane.showMessageDialog(this, "Proceed to Manage User Requests page to delete users.", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        AdminMainMenu page = new AdminMainMenu(admin);
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    public javax.swing.JTextField addressField;
    public javax.swing.JComboBox<String> cityComboBox;
    private javax.swing.JTable customerTable;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    public javax.swing.JTextField emailField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField nameField;
    public javax.swing.JTextField passwordField;
    public javax.swing.JTextField phoneNumberField;
    // End of variables declaration//GEN-END:variables
}

