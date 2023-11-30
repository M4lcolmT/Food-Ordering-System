/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package food.ordering.system.AdminGUI;

import food.ordering.system.RunnerGUI.Runner;
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
 * @author jiasi
 */
public class CRUDRunner extends javax.swing.JFrame {
    private Admin admin;
    List<Runner> runners;
    public int userRequestRunnerID = 0;
    private List<Notification> notifications;
    
    TextFilePaths path = new TextFilePaths();
    String runnerTextFile = path.getRunnerTextFile();
    String notificationTextFile = path.getNotificationsTextFile();

    public CRUDRunner(Admin admin) {
        initComponents();
        this.admin = admin;
        
        ReadFiles reader = new ReadFiles();
        runners = reader.readRunners();
        notifications = reader.readNotifications();
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
    
    private void writeRunnerToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(runnerTextFile))) {
            for (Runner foodItem : runners) {
                writer.println(foodItem.toString());
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately (e.g., show an error message)
        }
    }
    
    // Write runner, prompt message, refresh runner table
    private void createNewRunners() {
        writeRunnerToFile();
        // Refresh the table with updated data
        ReadFiles reader = new ReadFiles();
        runners = reader.readRunners();
        loadRunners();
        nameField.setText("");
        phoneNumberField.setText("");
        emailField.setText("");
        passwordField.setText("");
        cityComboBox.setSelectedIndex(0);
        vehiclePlateField.setText("");
        vehicleModelField.setText("");
    }
    
    private boolean isEmpty(String str) {
        return str.trim().isEmpty();
    }
    
    public int getUserRequestRunnerID() {
        DefaultTableModel model = (DefaultTableModel) runnerTable.getModel();
        int rowCount = model.getRowCount();

        for (int i = 0; i < rowCount; i++) {
            int runnerId = (int) model.getValueAt(i, 0);
            if (runnerId == userRequestRunnerID) {
                return runnerId; // Return the customer ID if ID matches
            }
        }
        return -1; // Return -1 if no matching ID is found
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
        jLabel8 = new javax.swing.JLabel();
        passwordField = new javax.swing.JTextField();
        cityComboBox = new javax.swing.JComboBox<>();
        add = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        runnerTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Manage Runner Details");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Name:");

        jLabel3.setText("Phone Number:");

        jLabel4.setText("Vehicle Model:");

        jLabel5.setText("Vehicle Plate Number:");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Email:");

        jLabel7.setText("City:");

        jLabel8.setText("Password:");

        cityComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select City", "Shah Alam", "Petaling Jaya", "Subang Jaya", "Klang", "Puchong", "Ampang", "Kajang", "Cyberjaya", "Seri Kembangan", "Hulu Langat", "Bukit Jalil" }));
        cityComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cityComboBoxItemStateChanged(evt);
            }
        });

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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(emailField, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addComponent(phoneNumberField)
                    .addComponent(cityComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(41, Short.MAX_VALUE))
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
                    .addComponent(jLabel7)
                    .addComponent(jLabel4)
                    .addComponent(cityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
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
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(add)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(edit)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(delete))))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
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
        String vehicleNum = vehiclePlateField.getText();
        String vehicleModel = vehicleModelField.getText();
        String city = String.valueOf(cityComboBox.getSelectedItem());

        if (!name.equals("") ||
                        !phoneNumber.equals("") ||
                        !email.equals ("") ||
                        !password.equals("") ||
                        !city.equals("Select City") ||
                        !vehicleNum.equals("") ||
                        !vehicleModel.equals("")) {
            Runner item = new Runner(runnerID, true, name, phoneNumber, email, password, city, vehicleNum, vehicleModel);
            runners.add(item);
            JOptionPane.showMessageDialog(this, "Successfully added the new Runner!", "Success", JOptionPane.INFORMATION_MESSAGE);
            createNewRunners();
            userRequestRunnerID = 0;
        } else {
            JOptionPane.showMessageDialog(this, "Proceed to Manage User Requests page to add new users.", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_addActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // Get the updated data from the text fields
        String newName = nameField.getText();
        String newPhoneNumber = phoneNumberField.getText();
        String newEmail = emailField.getText();
        String newPassword = passwordField.getText();
        String newCity = String.valueOf(cityComboBox.getSelectedItem());
        String newVehiclePlate = vehiclePlateField.getText();
        String newVehicleModel = vehicleModelField.getText();

        // Prompt admin to go to manage user request page to edit user profile
        if (!newName.equals("") ||
                !newPhoneNumber.equals("") ||
                !newEmail.equals ("") ||
                !newPassword.equals("") ||
                !newCity.equals("") ||
                !newVehiclePlate.equals("") ||
                !newVehicleModel.equals("")) {
            int id = getUserRequestRunnerID();
            if (id!=-1) {
                Runner selectedRunner = getRunner(id);
                selectedRunner.setName(newName);
                selectedRunner.setPhoneNumber(newPhoneNumber);
                selectedRunner.setEmail(newEmail);
                selectedRunner.setPassword(newPassword);
                selectedRunner.setCity(newCity);
                selectedRunner.setPlateNumber(newVehiclePlate);
                selectedRunner.setVehicleModel(newVehicleModel);
                createNewRunners();
                Notification newNotif = new Notification(checkMaxNotificationID(), Notification.NotifType.USERPROFILE, selectedRunner.getRunnerID(), Notification.NotifUserType.RUNNER, 0, "Your profile is updated!", LocalDateTime.now());
                notifications.add(newNotif);
                writeNotificationToFile();
                JOptionPane.showMessageDialog(this, "Successfully edited Runner Details", "Success", JOptionPane.INFORMATION_MESSAGE);
                userRequestRunnerID = 0;
            } else {
                JOptionPane.showMessageDialog(this, "New user found, please select the add button instead.", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Proceed to Manage User Requests page to edit user profile details.", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_editActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        int id = getUserRequestRunnerID();
        if (id!=-1) {
            Runner selectedRunner = getRunner(id);
            runners.removeIf(item -> item.getRunnerID() == selectedRunner.getRunnerID());
            createNewRunners();
            userRequestRunnerID = 0;
        } else {
            JOptionPane.showMessageDialog(this, "Proceed to Manage User Requests page to delete users.", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void cityComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cityComboBoxItemStateChanged
        
    }//GEN-LAST:event_cityComboBoxItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        AdminMainMenu page = new AdminMainMenu(admin);
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    public javax.swing.JComboBox<String> cityComboBox;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    public javax.swing.JTextField emailField;
    private javax.swing.JButton jButton1;
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
    public javax.swing.JTextField nameField;
    public javax.swing.JTextField passwordField;
    public javax.swing.JTextField phoneNumberField;
    private javax.swing.JTable runnerTable;
    public javax.swing.JTextField vehicleModelField;
    public javax.swing.JTextField vehiclePlateField;
    // End of variables declaration//GEN-END:variables
}
