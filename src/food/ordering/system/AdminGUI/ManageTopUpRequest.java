package food.ordering.system.AdminGUI;

import food.ordering.system.TopUpRequests;
import food.ordering.system.Notification;
import food.ordering.system.ReadFiles;
import food.ordering.system.CustomerGUI.Customer;
import food.ordering.system.OrderManager;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
public class ManageTopUpRequest extends javax.swing.JFrame {
    private Admin admin;
    private List<TopUpRequests> requests;
    private List<Notification> notifications;
    private List<Customer> allCustomers;
    private OrderManager manager = new OrderManager();
    
    public ManageTopUpRequest(Admin admin) {
        initComponents();
        this.admin = admin;
        
        ReadFiles reader = new ReadFiles();
        requests = reader.readTopUpRequests();
        notifications = reader.readNotifications();
        allCustomers = reader.readCustomers();
        loadTopUpRequests();
    }
    
    private void loadTopUpRequests() {
        DefaultTableModel model = (DefaultTableModel) requestTable.getModel();
        model.setRowCount(0);
        
        for (TopUpRequests i : requests) {
            if (i.getTransactionStatus().name().equals("PENDING")) {
                LocalDateTime dateTime = i.getDateTime();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy, HH:mm");
                String formattedDateTime = dateTime.format(formatter);
                Object[] rowData = {i.getRequestID(), formattedDateTime, i.getCustomerID(), i.getAmount(), i.getTransactionStatus()};
                model.addRow(rowData);
            }
        }
    }
    
    private TopUpRequests findRequest(int id) {
        for (TopUpRequests request : requests) {
            if (id == request.getRequestID()) {
                return request;
            }
        }
        return null;
    }
    
    private Customer findCustomer(int id) {
        for (Customer i : allCustomers) {
            if (i.getCustomerID() == id) {
                return i;
            }
        }
        return null;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        requestTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        processTransactionButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 500));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        jLabel1.setText("Manage Top Up");

        requestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Transaction ID", "Transaction Time", "Customer ID", "Transaction Amount", "Status"
            }
        ));
        jScrollPane1.setViewportView(requestTable);

        processTransactionButton.setBackground(new java.awt.Color(255, 255, 254));
        processTransactionButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        processTransactionButton.setForeground(new java.awt.Color(26, 115, 232));
        processTransactionButton.setText("Process Transaction");
        processTransactionButton.setPreferredSize(new java.awt.Dimension(133, 25));
        processTransactionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processTransactionButtonActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(processTransactionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(processTransactionButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void processTransactionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processTransactionButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) requestTable.getModel();
        int selectedRow = requestTable.getSelectedRow();
        
        if (selectedRow != -1) {
            int transactionID = (int) model.getValueAt(selectedRow, 0);
            int customerID = (int) model.getValueAt(selectedRow, 2);
            int topAmount = (int) model.getValueAt(selectedRow, 3);
            
            Customer selectedCustomer = findCustomer(customerID);
            double credit = selectedCustomer.getCredit();
            selectedCustomer.setCredit(credit+topAmount);
            manager.saveUpdatedCustomerInfo(selectedCustomer);
            
            TopUpRequests selectedRequest = findRequest(transactionID);
            selectedRequest.updateTransactionStatus(selectedRequest, requests);
            
            Notification requestNotif = new Notification(Notification.NotifType.TOPUP, customerID, 
                    Notification.NotifUserType.CUSTOMER, transactionID, "", LocalDateTime.now());
            requestNotif.saveNotification(requestNotif);
            JOptionPane.showMessageDialog(this, "Transaction has been approved.", 
                    "Transaction Success", JOptionPane.INFORMATION_MESSAGE);
            loadTopUpRequests();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to process transaction", 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_processTransactionButtonActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        AdminMainMenu page = new AdminMainMenu(admin);
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JButton processTransactionButton;
    private javax.swing.JTable requestTable;
    // End of variables declaration//GEN-END:variables

}
