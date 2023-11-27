/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package food.ordering.system.AdminGUI;

import food.ordering.system.RunnerGUI.Runner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import textFiles.TextFilePaths;

/**
 *
 * @author jiasi
 */
public class CRUDRunner extends javax.swing.JFrame {
    private Admin admin;
    List<Runner> runners;
    private int selectedRow = -1; // Instance variable to store the selected row
    private boolean editMode = false;
    private List<Integer> notificationIDs;
    
    TextFilePaths path = new TextFilePaths();
    String runnerTextFile = path.getRunnerTextFile();
    
    public CRUDRunner(Admin admin) {
        initComponents();
        this.admin = admin;
        
        ReadFiles reader = new ReadFiles();
        runners = reader.readRunners();
        notificationIDs = reader.readNotificationID();
        loadRunners();
    }

    //Load runners into the table
    private void loadRunners() {
        DefaultTableModel model = (DefaultTableModel) runnerTable.getModel();
        
        List<Runner> filteredRunners = runners.stream()
                .collect(Collectors.toList());
        // Sort the filtered items by ID
        filteredRunners.sort(Comparator.comparingInt(Runner::getRunnerID));

        // Clear existing rows
        model.setRowCount(0);
        
        for (Runner runner : filteredRunners) {
            Object[] rowData = { runner.getRunnerID(),runner.getName(), runner.getPhoneNumber(), runner.getEmail()
                    , runner.getPassword(), runner.getCity(), runner.getPlateNumber(), runner.getVehicleModel()};
            model.addRow(rowData);
        }
        
     
    }
     private Runner getRunner(int id) {
        for (Runner item : runners) {
            if (id == item.getRunnerID()) {
                return item;
            }
        }
        return null;
    }
     
    public int checkMaxID() {
        int maxID = 0;
        for (Runner item : runners) {
                if (item.getRunnerID() > maxID) {
                    maxID = item.getRunnerID();
                }
            }
        
        // Increment the maximum ID
        return maxID + 1;
    }
    
    private void writeToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(runnerTextFile))) {
            // Write each food item to the file
            for (Runner foodItem : runners) {
                writer.println(foodItem.toString());
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately (e.g., show an error message)
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        vehicleModelField = new javax.swing.JTextField();
        vehiclePlateField = new javax.swing.JTextField();
        nameField = new javax.swing.JTextField();
        phoneNumberField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        addressField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        passwordField = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        add = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        runnerTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Manage Runner Details");

        jLabel2.setText("Name:");

        jLabel3.setText("Phone Number:");

        jLabel4.setText("Vehicle Model:");

        jLabel5.setText("Vehicle Plate Number:");

        jLabel6.setText("Email:");

        jLabel7.setText("Address:");

        jLabel8.setText("Password:");

        jButton4.setText("Generate");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nameField)
                    .addComponent(vehiclePlateField)
                    .addComponent(vehicleModelField)
                    .addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addressField, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                            .addComponent(emailField)
                            .addComponent(phoneNumberField)))
                    .addComponent(jButton4))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vehiclePlateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vehicleModelField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addContainerGap(8, Short.MAX_VALUE))
        );

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

        runnerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Phone Num", "Email", "Password", "Address", "Vehicle Num", "Vehicle Model"
            }
        ));
        jScrollPane1.setViewportView(runnerTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(add)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(delete)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add)
                    .addComponent(edit)
                    .addComponent(delete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        int runnerID = checkMaxID();
        String name = nameField.getText();
        String phoneNumber = phoneNumberField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String address = addressField.getText();
        String vehicleNum = vehiclePlateField.getText();
        String vehicleModel = vehicleModelField.getText();
        
        Runner item = new Runner(runnerID, true, name, phoneNumber, email, password, address, vehicleNum, vehicleModel);
        runners.add(item);
        writeToFile();
        JOptionPane.showMessageDialog(this, "Successfully added Runner Details", "Success", JOptionPane.INFORMATION_MESSAGE);
        // Refresh the table with updated data
        ReadFiles reader = new ReadFiles();
        runners = reader.readRunners();
        loadRunners();
        nameField.setText("");
        phoneNumberField.setText("");
        emailField.setText("");
        passwordField.setText("");
        addressField.setText("");
        vehiclePlateField.setText("");
        vehicleModelField.setText("");
    }//GEN-LAST:event_addActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        DefaultTableModel model = (DefaultTableModel) runnerTable.getModel();
        if (!editMode) {
        // Enter edit mode
            selectedRow = runnerTable.getSelectedRow();
            if (selectedRow != -1) {
                // Get the current data from the selected row
                String name = (String) model.getValueAt(selectedRow, 1);
                String phoneNumber = (String) model.getValueAt(selectedRow, 2);
                String email = (String) model.getValueAt(selectedRow, 3);
                String password = (String) model.getValueAt(selectedRow, 4);
                String address = (String) model.getValueAt(selectedRow, 5);
                String vehicleNum = (String) model.getValueAt(selectedRow, 6);
                String vehicleModel = (String) model.getValueAt(selectedRow, 7);
                // Set the current data in the text fields
                nameField.setText(name);
                phoneNumberField.setText(phoneNumber);
                emailField.setText(email);
                passwordField.setText(password);
                addressField.setText(address);
                vehiclePlateField.setText(vehicleNum);
                vehicleModelField.setText(vehicleModel);

                editMode = true; // Switch to edit mode
            } else {
                JOptionPane.showMessageDialog(this, "Please select a Runner Details to edit", "Empty input", JOptionPane.ERROR_MESSAGE);
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
                String newVehiclePlate = vehiclePlateField.getText();
                String newVehicleModel = vehicleModelField.getText();

                // Check if changes have been made
                if (!newName.equals(model.getValueAt(selectedRow, 1)) ||
                        !newPhoneNumber.equals(model.getValueAt(selectedRow, 2)) ||
                        !newEmail.equals (model.getValueAt(selectedRow, 3)) ||
                        !newPassword.equals(model.getValueAt(selectedRow, 4)) ||
                        !newAddress.equals(model.getValueAt(selectedRow, 5)) ||
                        !newVehiclePlate.equals(model.getValueAt(selectedRow, 6)) ||
                        !newVehicleModel.equals(model.getValueAt(selectedRow, 6))) {
                        
                    
                    int runnerID = (int) model.getValueAt(selectedRow, 0);
                    Runner selectedRunner = getRunner(runnerID);
                    selectedRunner.setName(newName);
                    selectedRunner.setPhoneNumber(newPhoneNumber);
                    selectedRunner.setEmail(newEmail);
                    selectedRunner.setPassword(newPassword);
                    selectedRunner.setCity(newAddress);
                    selectedRunner.setPlateNumber(newVehiclePlate);
                    selectedRunner.setVehicleModel(newVehicleModel);
                    // Remove the old food item
                    runners.removeIf(item -> item.getRunnerID() == selectedRunner.getRunnerID());
                    // Add the updated food item
                    runners.add(selectedRunner);
                    // Write the updated list back to the file
                    writeToFile();
                    JOptionPane.showMessageDialog(this, "Successfully edited Runner Details", "Success", JOptionPane.INFORMATION_MESSAGE);
                    // Refresh the table with updated data
                    ReadFiles reader = new ReadFiles();
                    runners = reader.readRunners();
                    loadRunners();
                    nameField.setText("");
                    phoneNumberField.setText("");
                    emailField.setText("");
                    passwordField.setText("");
                    addressField.setText("");
                    vehiclePlateField.setText("");
                    vehicleModelField.setText("");
                    editMode = false; // Switch back to view mode
                } else {
                    // No changes were made
                    JOptionPane.showMessageDialog(this, "No changes made", "No Changes", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select a Customer Details to edit", "Empty input", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_editActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        DefaultTableModel model = (DefaultTableModel) runnerTable.getModel();
        selectedRow = runnerTable.getSelectedRow();
        if (selectedRow != -1) {
            int confirmationResult = JOptionPane.showConfirmDialog(this, "Proceed to delete Runner Details?", "Delete Confirmation", JOptionPane.YES_NO_OPTION);        
            if (confirmationResult == JOptionPane.YES_OPTION) {
                int runnerID = (int) model.getValueAt(selectedRow, 0);
                Runner selectedRunner = getRunner(runnerID);
                runners.removeIf(item -> item.getRunnerID() == selectedRunner.getRunnerID());
                writeToFile();
                ReadFiles reader = new ReadFiles();
                runners = reader.readRunners();
                loadRunners();
            } else {
                JOptionPane.showMessageDialog(this, "Action cancelled.", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
            }
        }
             
    }//GEN-LAST:event_deleteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JTextField addressField;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JTextField emailField;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField passwordField;
    private javax.swing.JTextField phoneNumberField;
    private javax.swing.JTable runnerTable;
    private javax.swing.JTextField vehicleModelField;
    private javax.swing.JTextField vehiclePlateField;
    // End of variables declaration//GEN-END:variables
}
