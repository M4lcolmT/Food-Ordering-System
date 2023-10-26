/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package food.ordering.system.CustomerGUI;

import food.ordering.system.VendorGUI.FoodItem;

/**
 *
 * @author LENOVO
 */
public class FoodItemPanel extends javax.swing.JPanel {
    FoodItem foodItem;
    
    public FoodItemPanel(FoodItem foodItem) {
        initComponents();
        this.foodItem = foodItem;
        
        itemName.setText(foodItem.getItemName());
        itemDescription.setText(foodItem.getItemDescription());
        itemPrice.setText("RM"+Double.toString((double)foodItem.getItemPrice()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        itemName = new javax.swing.JLabel();
        itemDescription = new javax.swing.JLabel();
        itemPrice = new javax.swing.JLabel();
        addItemButton = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(650, 100));
        setMinimumSize(new java.awt.Dimension(650, 100));
        setPreferredSize(new java.awt.Dimension(650, 100));

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(650, 100));
        jPanel1.setMinimumSize(new java.awt.Dimension(650, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(650, 100));

        jLabel1.setText("IMG");

        itemName.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        itemName.setText("Cheese Burger");

        itemDescription.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        itemDescription.setText("asasasdsadsadasdsadsadsadsadsadsadsadsadsadsadsadsadsadsadsadsadsadsadsadsa");
        itemDescription.setMaximumSize(new java.awt.Dimension(375, 14));
        itemDescription.setPreferredSize(new java.awt.Dimension(375, 14));

        itemPrice.setText("RM12.50");

        addItemButton.setText("Add");
        addItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(itemDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(itemPrice)
                .addGap(18, 18, 18)
                .addComponent(addItemButton)
                .addGap(38, 38, 38))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(addItemButton)
                            .addComponent(itemPrice)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(itemName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(itemDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemButtonActionPerformed
        System.out.println("Clicked!");
    }//GEN-LAST:event_addItemButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addItemButton;
    private javax.swing.JLabel itemDescription;
    private javax.swing.JLabel itemName;
    private javax.swing.JLabel itemPrice;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
