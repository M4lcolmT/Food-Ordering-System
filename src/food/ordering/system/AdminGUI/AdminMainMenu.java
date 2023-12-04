/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package food.ordering.system.AdminGUI;

import food.ordering.system.AdminLogin;
import javax.swing.JOptionPane;

/**
 *
 * @author jiasi
 */
public class AdminMainMenu extends javax.swing.JFrame {
    private Admin admin;
    
    public AdminMainMenu(Admin admin) {
        initComponents();
        this.admin = admin;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        crudCustomerButton = new javax.swing.JButton();
        crudRunnerButton = new javax.swing.JButton();
        crudVendorButton = new javax.swing.JButton();
        manageUserRequestButton = new javax.swing.JButton();
        manageTopUpRequestButton = new javax.swing.JButton();
        logOutButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        crudCustomerButton.setBackground(new java.awt.Color(255, 255, 254));
        crudCustomerButton.setText("Manage Customers");
        crudCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crudCustomerButtonActionPerformed(evt);
            }
        });

        crudRunnerButton.setBackground(new java.awt.Color(255, 255, 254));
        crudRunnerButton.setText("Manage Runners");
        crudRunnerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crudRunnerButtonActionPerformed(evt);
            }
        });

        crudVendorButton.setBackground(new java.awt.Color(255, 255, 254));
        crudVendorButton.setText("Manage Vendors");
        crudVendorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crudVendorButtonActionPerformed(evt);
            }
        });

        manageUserRequestButton.setBackground(new java.awt.Color(255, 255, 254));
        manageUserRequestButton.setText("Manage User Request");
        manageUserRequestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageUserRequestButtonActionPerformed(evt);
            }
        });

        manageTopUpRequestButton.setBackground(new java.awt.Color(255, 255, 254));
        manageTopUpRequestButton.setText("Manage Top Up ");
        manageTopUpRequestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageTopUpRequestButtonActionPerformed(evt);
            }
        });

        logOutButton.setBackground(new java.awt.Color(255, 255, 254));
        logOutButton.setText("Log Out");
        logOutButton.setPreferredSize(new java.awt.Dimension(119, 23));
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        jLabel1.setText("Admin Main Menu");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(manageTopUpRequestButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(crudVendorButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(manageUserRequestButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(crudRunnerButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(crudCustomerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(logOutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel1)))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(crudCustomerButton)
                .addGap(18, 18, 18)
                .addComponent(crudVendorButton)
                .addGap(18, 18, 18)
                .addComponent(crudRunnerButton)
                .addGap(18, 18, 18)
                .addComponent(manageUserRequestButton)
                .addGap(18, 18, 18)
                .addComponent(manageTopUpRequestButton)
                .addGap(18, 18, 18)
                .addComponent(logOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
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

    private void crudRunnerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crudRunnerButtonActionPerformed
        CRUDRunner page = new CRUDRunner(admin);
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_crudRunnerButtonActionPerformed

    private void manageTopUpRequestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageTopUpRequestButtonActionPerformed
        ManageTopUpRequest page = new ManageTopUpRequest(admin);
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_manageTopUpRequestButtonActionPerformed

    private void crudCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crudCustomerButtonActionPerformed
        CRUDCustomer page = new CRUDCustomer(admin);
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_crudCustomerButtonActionPerformed

    private void crudVendorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crudVendorButtonActionPerformed
        CRUDVendor page = new CRUDVendor(admin);
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_crudVendorButtonActionPerformed

    private void manageUserRequestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageUserRequestButtonActionPerformed
        ManageUserRequest page = new ManageUserRequest(admin);
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_manageUserRequestButtonActionPerformed

    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutButtonActionPerformed
        int confirmationResult = JOptionPane.showConfirmDialog(this, "Proceed to log out", "Log Out Confirmation", JOptionPane.YES_NO_OPTION);        

        if (confirmationResult == JOptionPane.YES_OPTION) {
            AdminLogin page = new AdminLogin();
            page.setVisible(true);
            this.dispose();
        }    
    }//GEN-LAST:event_logOutButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton crudCustomerButton;
    private javax.swing.JButton crudRunnerButton;
    private javax.swing.JButton crudVendorButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton logOutButton;
    private javax.swing.JButton manageTopUpRequestButton;
    private javax.swing.JButton manageUserRequestButton;
    // End of variables declaration//GEN-END:variables
}
