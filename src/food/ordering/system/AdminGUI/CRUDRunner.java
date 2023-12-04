/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package food.ordering.system.AdminGUI;

import food.ordering.system.Notification;
import food.ordering.system.ReadFiles;
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
        delete = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        add = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        runnerTable = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        jLabel1.setText("Manage Runner Details");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Name:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        jLabel3.setText("Phone Number:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 16, -1, 20));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Model:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 81, -1));

        jLabel5.setText("Plate Number:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Email:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 46, 45, 30));

        jLabel7.setText("City:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 86, -1, 30));
        jPanel2.add(vehicleModelField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 159, -1));
        jPanel2.add(vehiclePlateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 159, -1));
        jPanel2.add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 159, -1));
        jPanel2.add(phoneNumberField, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 13, 218, -1));
        jPanel2.add(emailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 53, 218, -1));

        jLabel8.setText("Password:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));
        jPanel2.add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 159, -1));

        cityComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select City", "Shah Alam", "Petaling Jaya", "Subang Jaya", "Klang", "Puchong", "Ampang", "Kajang", "Cyberjaya", "Seri Kembangan", "Hulu Langat", "Bukit Jalil" }));
        cityComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cityComboBoxItemStateChanged(evt);
            }
        });
        jPanel2.add(cityComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 93, 218, -1));

        delete.setBackground(new java.awt.Color(255, 255, 254));
        delete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel2.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(541, 133, -1, -1));

        edit.setBackground(new java.awt.Color(255, 255, 254));
        edit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        jPanel2.add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 133, -1, -1));

        add.setBackground(new java.awt.Color(255, 255, 254));
        add.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel2.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(373, 133, -1, -1));

        runnerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Phone Num", "Email", "Password", "Address", "Vehicle Num", "Vehicle Model"
            }
        ));
        jScrollPane1.setViewportView(runnerTable);
        if (runnerTable.getColumnModel().getColumnCount() > 0) {
            runnerTable.getColumnModel().getColumn(0).setPreferredWidth(5);
        }

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
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
            Runner item = new Runner(runnerID, true, name, phoneNumber, email, password, city, vehicleNum, vehicleModel, 0);
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

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        AdminMainMenu page = new AdminMainMenu(admin);
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    public javax.swing.JComboBox<String> cityComboBox;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    public javax.swing.JTextField emailField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
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
