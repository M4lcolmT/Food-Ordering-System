/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package food.ordering.system.AdminGUI;

import food.ordering.system.CustomerGUI.CustomerRequest;
import food.ordering.system.RunnerGUI.RunnerRequest;
import food.ordering.system.VendorGUI.VendorRequest;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class ManageUserRequest extends javax.swing.JFrame {
    private Admin admin;
    private List<UserRequest> allRequests = new ArrayList<>();
    private List<CustomerRequest> customerRequests = new ArrayList<>();
    private List<VendorRequest> vendorRequests = new ArrayList<>();
    private List<RunnerRequest> runnerRequests = new ArrayList<>();
    
    TextFilePaths filePaths = new TextFilePaths();
    String userRequestsTextFilePath = filePaths.getUserCRUDrequestTextFile();
    
    public ManageUserRequest(Admin admin) {
        initComponents();
        this.admin = admin;
        
        //Load all the request and add into the main request list
        ReadFiles reader = new ReadFiles();
        reader.readUserRequests(customerRequests, vendorRequests, runnerRequests);
        allRequests.addAll(customerRequests);
        allRequests.addAll(vendorRequests);
        allRequests.addAll(runnerRequests);
        updateTable();
    }
    
    private void updateTable() {
        DefaultTableModel model = (DefaultTableModel) userRequestTable.getModel();
        model.setRowCount(0);

        boolean noCheckBoxSelected = !runnerCheckBox.isSelected() && !customerCheckBox.isSelected() && !vendorCheckBox.isSelected();

        List<UserRequest> filteredItems;

        if (noCheckBoxSelected) {
            filteredItems = allRequests;
        } else {
            filteredItems = new ArrayList<>();

            if (runnerCheckBox.isSelected()) {
                filteredItems.addAll(runnerRequests);
            }

            if (customerCheckBox.isSelected()) {
                filteredItems.addAll(customerRequests);
            }

            if (vendorCheckBox.isSelected()) {
                filteredItems.addAll(vendorRequests);
            }
        }

        // Sort the filtered items by ID
        List<UserRequest> sortedItems = filteredItems.stream()
                .sorted(Comparator.comparingInt(UserRequest::getUserRequestID))
                .collect(Collectors.toList());

        // Add the sorted items to the table
        sortedItems.forEach(item -> model.addRow(orderToRow(item)));
    }


    private Object[] orderToRow(UserRequest request) {
        return new Object[]{request.getUserRequestID(), request.getRequestType(), request.getUserID(), request.getUserType(), request.getName()};
    }
    
    private CustomerRequest findCustomerRequest(int requestID){
        for (CustomerRequest i : customerRequests) {
            if (i.getUserRequestID() == requestID) {
                return i;
            }
        }
        return null;
    }
    
    private VendorRequest findVendorRequest(int requestID){
        for (VendorRequest i : vendorRequests) {
            if (i.getUserRequestID() == requestID) {
                return i;
            }
        }
        return null;
    }
    
    private RunnerRequest findRunnerRequest(int requestID){
        for (RunnerRequest i : runnerRequests) {
            if (i.getUserRequestID() == requestID) {
                return i;
            }
        }
        return null;
    }
    
    private void writeRequests() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(userRequestsTextFilePath))) {
            for (UserRequest item : allRequests) {
                writer.println(item.toFormmatedString());
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
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        userRequestTable = new javax.swing.JTable();
        runnerCheckBox = new javax.swing.JCheckBox();
        customerCheckBox = new javax.swing.JCheckBox();
        vendorCheckBox = new javax.swing.JCheckBox();
        processButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 400));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Manage Request");

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        userRequestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request ID", "Request Type", "User ID", "User Type", "User Name"
            }
        ));
        jScrollPane2.setViewportView(userRequestTable);

        runnerCheckBox.setBackground(new java.awt.Color(255, 255, 255));
        runnerCheckBox.setText("Runner");
        runnerCheckBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                runnerCheckBoxItemStateChanged(evt);
            }
        });

        customerCheckBox.setBackground(new java.awt.Color(255, 255, 255));
        customerCheckBox.setText("Customer");
        customerCheckBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                customerCheckBoxItemStateChanged(evt);
            }
        });

        vendorCheckBox.setBackground(new java.awt.Color(255, 255, 255));
        vendorCheckBox.setText("Vendor");
        vendorCheckBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                vendorCheckBoxItemStateChanged(evt);
            }
        });

        processButton.setText("Process Request");
        processButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(vendorCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(customerCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(runnerCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(processButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(runnerCheckBox)
                    .addComponent(customerCheckBox)
                    .addComponent(vendorCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(processButton))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        AdminMainMenu menu = new AdminMainMenu(admin);
        menu.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void runnerCheckBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_runnerCheckBoxItemStateChanged
        updateTable();
    }//GEN-LAST:event_runnerCheckBoxItemStateChanged

    private void customerCheckBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_customerCheckBoxItemStateChanged
        updateTable();
    }//GEN-LAST:event_customerCheckBoxItemStateChanged

    private void vendorCheckBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_vendorCheckBoxItemStateChanged
        updateTable();
    }//GEN-LAST:event_vendorCheckBoxItemStateChanged

    private void processButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) userRequestTable.getModel();
        
        int selectedRow = userRequestTable.getSelectedRow();
        if (selectedRow != -1) {
            int requestID = (int) model.getValueAt(selectedRow, 0);
            UserRequest.UserType userType = (UserRequest.UserType) model.getValueAt(selectedRow, 3);
            switch (userType.name()) {
                case "CUSTOMER":
                    CustomerRequest selectedCustomerRequest = findCustomerRequest(requestID);
                    CRUDCustomer customerPage = new CRUDCustomer(admin);
                    customerPage.nameField.setText(selectedCustomerRequest.getName());
                    customerPage.phoneNumberField.setText(selectedCustomerRequest.getPhoneNumber());
                    customerPage.emailField.setText(selectedCustomerRequest.getEmail());
                    customerPage.passwordField.setText(selectedCustomerRequest.getPassword());
                    customerPage.addressField.setText(selectedCustomerRequest.getAddress());
                    String city = selectedCustomerRequest.getCity().trim().toLowerCase();
                    for (int i = 0; i < customerPage.cityComboBox.getItemCount(); i++) {
                        if (city.equals(customerPage.cityComboBox.getItemAt(i).trim().toLowerCase())) {
                            customerPage.cityComboBox.setSelectedIndex(i);
                            break;
                        }
                    }
                    customerPage.userRequestCustomerID = selectedCustomerRequest.getUserID();
                    customerPage.setVisible(true);
                    this.dispose();
                    allRequests.remove(selectedCustomerRequest);
                    writeRequests();
                    break;
                case "VENDOR":
                    VendorRequest selectedVendorRequest = findVendorRequest(requestID);
                    CRUDVendor vendorPage = new CRUDVendor(admin);
                    vendorPage.nameField.setText(selectedVendorRequest.getName());
                    vendorPage.phoneNumberField.setText(selectedVendorRequest.getPhoneNumber());
                    vendorPage.emailField.setText(selectedVendorRequest.getEmail());
                    vendorPage.passwordField.setText(selectedVendorRequest.getPassword());
                    vendorPage.descriptionField.setText(selectedVendorRequest.getDescription());
                    vendorPage.categoryComboBox.setSelectedItem(selectedVendorRequest.getCategory());

                    String[] hourParts = selectedVendorRequest.getOperationHours().split("-");
                    for (int i = 0; i < vendorPage.startHourComboBox.getItemCount(); i++) {
                        if (hourParts[0].equals(vendorPage.startHourComboBox.getItemAt(i))) {
                            vendorPage.startHourComboBox.setSelectedIndex(i);
                            break;
                        }
                    }
                    for (int i = 0; i < vendorPage.endHourComboBox.getItemCount(); i++) {
                        if (hourParts[1].equals(vendorPage.endHourComboBox.getItemAt(i))) {
                            vendorPage.endHourComboBox.setSelectedIndex(i);
                            break;
                        }
                    }

                    String[] dayParts = selectedVendorRequest.getOperationDays().split("-");
                    for (int i = 0; i < vendorPage.startDayComboBox.getItemCount(); i++) {
                        if (dayParts[0].equals(vendorPage.startDayComboBox.getItemAt(i))) {
                            vendorPage.startDayComboBox.setSelectedIndex(i);
                            break;
                        }
                    }
                    for (int i = 0; i < vendorPage.endDayComboBox.getItemCount(); i++) {
                        if (dayParts[1].equals(vendorPage.endDayComboBox.getItemAt(i))) {
                            vendorPage.endDayComboBox.setSelectedIndex(i);
                            break;
                        }
                    }
                    vendorPage.userRequestVendorID = selectedVendorRequest.getUserID();
                    vendorPage.setVisible(true);
                    this.dispose();
                    allRequests.remove(selectedVendorRequest);
                    writeRequests();
                    break;
                case "RUNNER":
                    RunnerRequest selectedRunnerRequest = findRunnerRequest(requestID);
                    CRUDRunner runnerPage = new CRUDRunner(admin);
                    runnerPage.nameField.setText(selectedRunnerRequest.getName());
                    runnerPage.phoneNumberField.setText(selectedRunnerRequest.getPhoneNumber());
                    runnerPage.emailField.setText(selectedRunnerRequest.getEmail());
                    runnerPage.passwordField.setText(selectedRunnerRequest.getPassword());
                    String runnerCity = selectedRunnerRequest.getAddress().trim().toLowerCase();
                    for (int i = 0; i < runnerPage.cityComboBox.getItemCount(); i++) {
                        if (runnerCity.equals(runnerPage.cityComboBox.getItemAt(i).trim().toLowerCase())) {
                            runnerPage.cityComboBox.setSelectedIndex(i);
                            break;
                        }
                    }
                runnerPage.vehiclePlateField.setText(selectedRunnerRequest.getPlateNumber());
                runnerPage.vehicleModelField.setText(selectedRunnerRequest.getVehicleModel());
                    runnerPage.userRequestRunnerID = selectedRunnerRequest.getUserID();
                    runnerPage.setVisible(true);
                    this.dispose();
                    allRequests.remove(selectedRunnerRequest);
                    writeRequests();
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a customer to edit.", "Manage Customer", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_processButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox customerCheckBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton processButton;
    private javax.swing.JCheckBox runnerCheckBox;
    private javax.swing.JTable userRequestTable;
    private javax.swing.JCheckBox vendorCheckBox;
    // End of variables declaration//GEN-END:variables
}
