/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package food.ordering.system.VendorGUI;

import food.ordering.system.CustomerGUI.Order;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class ViewOrders extends javax.swing.JFrame {
    private Vendor vendor;
    private List<Order> orders;
    private List<Order> filterOrders;
    private List<Order> deliveries = new ArrayList<>();
    private List<Order> takeAways = new ArrayList<>();
    private List<Order> dineIns = new ArrayList<>();
   
    public ViewOrders(Vendor vendor, List<Order> orders) {
        initComponents();
        this.vendor = vendor;
        this.orders = orders;
        
        filterOrders = removeCancelledOrders();
        filterOrders();
        updateTable();
    }
    
    private List<Order> removeCancelledOrders() {
        List<Order> filtOrders = new ArrayList<>();
        
        for (Order item : orders) {
            if (!item.getStatus().name().equals("CANCELLED")) {
                filtOrders.add(item);
            } else {
                System.out.println("Cancelled item!");
            }
        }
        return filtOrders;
    }
    
    private void filterOrders() {
        // Clear existing lists before populating
        deliveries.clear();
        takeAways.clear();
        dineIns.clear();

        for (Order item : filterOrders) {
            switch (item.getOrderType()) {
                case DELIVERY:
                    deliveries.add(item);
                    break;
                case TAKEAWAY:
                    takeAways.add(item);
                    break;
                case DINEIN:
                    dineIns.add(item);
                    break;
                default:
                    System.out.println("Invalid order type: " + item.getOrderType());
                    break;
            }
        }
    }

    private void updateTable() {
        DefaultTableModel model = (DefaultTableModel) orderTable.getModel();
        model.setRowCount(0);

        boolean noCheckBoxSelected = !deliveryCheckbox.isSelected() && !takeawayCheckbox.isSelected() && !dineInCheckbox.isSelected();

        List<Order> filteredItems;

        if (noCheckBoxSelected) {
            filteredItems = filterOrders;
        } else {
            filteredItems = new ArrayList<>();

            if (deliveryCheckbox.isSelected()) {
                filteredItems.addAll(deliveries);
            }

            if (takeawayCheckbox.isSelected()) {
                filteredItems.addAll(takeAways);
            }

            if (dineInCheckbox.isSelected()) {
                filteredItems.addAll(dineIns);
            }
        }

        // Sort the filtered items by ID
        List<Order> sortedItems = filteredItems.stream()
                .sorted(Comparator.comparingInt(Order::getOrderID))
                .collect(Collectors.toList());

        // Add the sorted items to the table
        sortedItems.forEach(item -> model.addRow(orderToRow(item)));
    }


    private Object[] orderToRow(Order order) {
        LocalDateTime dateTime = order.getDateTime();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mm a");
        String date = dateTime.toLocalDate().format(dateFormatter);
        String time = dateTime.toLocalTime().format(timeFormatter); 
        return new Object[]{order.getOrderID(), order.getOrderType(), time, date, order.getStatus()};
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        deliveryCheckbox = new javax.swing.JCheckBox();
        takeawayCheckbox = new javax.swing.JCheckBox();
        dineInCheckbox = new javax.swing.JCheckBox();
        viewButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 400));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("View Orders");

        orderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Order Type", "Time", "Date", "Status"
            }
        ));
        jScrollPane1.setViewportView(orderTable);

        deliveryCheckbox.setText("Delivery");
        deliveryCheckbox.setPreferredSize(new java.awt.Dimension(100, 25));
        deliveryCheckbox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                deliveryCheckboxItemStateChanged(evt);
            }
        });

        takeawayCheckbox.setText("Take Away");
        takeawayCheckbox.setPreferredSize(new java.awt.Dimension(100, 25));
        takeawayCheckbox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                takeawayCheckboxItemStateChanged(evt);
            }
        });

        dineInCheckbox.setText("Dine in");
        dineInCheckbox.setPreferredSize(new java.awt.Dimension(100, 25));
        dineInCheckbox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                dineInCheckboxItemStateChanged(evt);
            }
        });
        dineInCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dineInCheckboxActionPerformed(evt);
            }
        });

        viewButton.setText("View");
        viewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewButtonActionPerformed(evt);
            }
        });

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
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deliveryCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(takeawayCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dineInCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(viewButton)
                .addGap(275, 275, 275))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(deliveryCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(takeawayCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dineInCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewButton)
                    .addComponent(jButton1))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deliveryCheckboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_deliveryCheckboxItemStateChanged
        updateTable();
    }//GEN-LAST:event_deliveryCheckboxItemStateChanged

    private void takeawayCheckboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_takeawayCheckboxItemStateChanged
        updateTable();
    }//GEN-LAST:event_takeawayCheckboxItemStateChanged

    private void dineInCheckboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_dineInCheckboxItemStateChanged
        updateTable();
    }//GEN-LAST:event_dineInCheckboxItemStateChanged

    private void dineInCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dineInCheckboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dineInCheckboxActionPerformed

    private void viewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) orderTable.getModel();
        
        int selectedRow = orderTable.getSelectedRow();
        if (selectedRow != -1) {
            int orderID = (int) model.getValueAt(selectedRow, 0);
            String time = (String) model.getValueAt(selectedRow, 2);
            String date = (String) model.getValueAt(selectedRow, 3);
            Order.OrderStatus status = (Order.OrderStatus) model.getValueAt(selectedRow, 4);
            if (status.name().trim().equals("PENDING")) {
                ManageOrder page = new ManageOrder(vendor, orderID);
                page.orderIDLabel.setText(Integer.toString(orderID));
                page.timeLabel.setText(time);
                page.dateLabel.setText(date);
                page.acceptButton.setVisible(true);
                page.rejectButton.setVisible(true);
                page.readyButton.setVisible(false);
                page.setVisible(true);
                this.dispose();
            } else if (status.name().trim().equals("CONFIRMED")) {
                ManageOrder page = new ManageOrder(vendor, orderID);
                page.orderIDLabel.setText(Integer.toString(orderID));
                page.timeLabel.setText(time);
                page.dateLabel.setText(date);
                page.acceptButton.setVisible(false);
                page.rejectButton.setVisible(false);
                page.readyButton.setVisible(true);
                page.setVisible(true);
                this.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select an order to view.", "View Order", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_viewButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        VendorMainMenu page = new VendorMainMenu(vendor);
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox deliveryCheckbox;
    private javax.swing.JCheckBox dineInCheckbox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable orderTable;
    private javax.swing.JCheckBox takeawayCheckbox;
    private javax.swing.JButton viewButton;
    // End of variables declaration//GEN-END:variables
}
