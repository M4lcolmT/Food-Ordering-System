/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package food.ordering.system.VendorGUI;


/**
 *
 * @author LENOVO
 */
public class MainMenu extends javax.swing.JFrame {
    private Vendor vendor;

    public MainMenu(Vendor vendor) {
        initComponents();
        this.vendor = vendor;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        foodMenuButton = new javax.swing.JButton();
        revenueDashboardButton = new javax.swing.JButton();
        orderHistoryButton = new javax.swing.JButton();
        notificationsButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 400));

        foodMenuButton.setText("Menu");

        revenueDashboardButton.setText("Revenue Dashboard");

        orderHistoryButton.setText("Order History");
        orderHistoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderHistoryButtonActionPerformed(evt);
            }
        });

        notificationsButton.setText("Notifications");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(foodMenuButton)
                .addGap(40, 40, 40)
                .addComponent(notificationsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(revenueDashboardButton)
                .addGap(34, 34, 34)
                .addComponent(orderHistoryButton)
                .addGap(90, 90, 90))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(foodMenuButton)
                    .addComponent(revenueDashboardButton)
                    .addComponent(orderHistoryButton)
                    .addComponent(notificationsButton))
                .addContainerGap(191, Short.MAX_VALUE))
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

    private void orderHistoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderHistoryButtonActionPerformed
        VendorOrderHistory h = new VendorOrderHistory(vendor);
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_orderHistoryButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton foodMenuButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton notificationsButton;
    private javax.swing.JButton orderHistoryButton;
    private javax.swing.JButton revenueDashboardButton;
    // End of variables declaration//GEN-END:variables
}
