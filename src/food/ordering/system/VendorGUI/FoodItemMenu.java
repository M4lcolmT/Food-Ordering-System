package food.ordering.system.VendorGUI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
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
public class FoodItemMenu extends javax.swing.JFrame {
    private Vendor vendor;
    private List<FoodItem> allFoodItems;
    private int selectedRow = -1; // Instance variable to store the selected row
    private boolean editMode = false;
    
    TextFilePaths path = new TextFilePaths();
    String vendorMenuFilePath = path.getVendorMenuTextFile();

    public FoodItemMenu(Vendor vendor) {
        initComponents();
        this.vendor = vendor;
        
        allFoodItems = readVendorFoodItems();
        loadFoodItems();
    }

    private List<FoodItem> readVendorFoodItems() { 
        List<FoodItem> items = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(vendorMenuFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length == 7) {
                    int menuVendorID = Integer.parseInt(parts[0]); 
                    int itemID = Integer.parseInt(parts[1]);
                    String itemName = parts[2];
                    String itemCategory = parts[3];
                    double itemPrice = Double.parseDouble(parts[4]);
                    String itemDescription = parts[5];
                    double itemCost = Double.parseDouble(parts[6]); 

                    FoodItem item = new FoodItem(menuVendorID, itemID, itemName, itemCategory, itemPrice, itemDescription, itemCost);
                    items.add(item);
                } else {
                    System.out.println("Skipping a line with an incorrect number of parts");
                }
            }
        } catch (IOException e) {
            // Handle the exception, e.g., log or display an error message
            e.printStackTrace();
        }
        return items;
    }
    
    private void loadFoodItems() {
        DefaultTableModel model = (DefaultTableModel) foodItemTable.getModel();

        // Filter and sort the data
        List<FoodItem> filteredItems = allFoodItems.stream()
                .filter(item -> item.getVendorID() == vendor.getVendorID())
                .collect(Collectors.toList());

        // Sort the filtered items by ID
        Collections.sort(filteredItems, Comparator.comparingInt(FoodItem::getItemID));

        // Clear existing rows
        model.setRowCount(0);

        // Add sorted rows to the model
        for (FoodItem item : filteredItems) {
            Object[] rowData = {item.getItemID(), item.getItemName(), item.getItemCategory(),
                    item.getItemPrice(), item.getItemDescription(), item.getItemCost()};
            model.addRow(rowData);
        }
    }

    public int checkMaxID() {
        int maxID = 0;
        for (FoodItem item : allFoodItems) {
            if (item.getVendorID() == vendor.getVendorID()) {
                if (item.getItemID() > maxID) {
                    maxID = item.getItemID();
                }
            }
        }
        // Increment the maximum ID
        return maxID + 1;
    }
    
    private FoodItem getFoodItem(int id) {
        for (FoodItem item : allFoodItems) {
            if (id == item.getItemID() && item.getVendorID() == vendor.getVendorID()) {
                return item;
            }
        }
        return null;
    }

    private void writeToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(vendorMenuFilePath))) {
            // Write each food item to the file
            for (FoodItem foodItem : allFoodItems) {
                writer.println(foodItem.toString());
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately (e.g., show an error message)
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        foodItemTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        deleteButton = new javax.swing.JButton();
        nameField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        categoryField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        priceField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        descriptionField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        costField = new javax.swing.JTextField();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 500));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Food Item Menu");

        foodItemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Food Name", "Food Category", "Food Price", "Food Description", "Food Cost"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(foodItemTable);
        if (foodItemTable.getColumnModel().getColumnCount() > 0) {
            foodItemTable.getColumnModel().getColumn(0).setPreferredWidth(5);
        }

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addButton.setText("Add");
        addButton.setPreferredSize(new java.awt.Dimension(75, 23));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        jPanel3.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, -1, -1));

        editButton.setText("Edit");
        editButton.setPreferredSize(new java.awt.Dimension(75, 23));
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
        jPanel3.add(editButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, -1, -1));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Food Name:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 16, -1, -1));

        deleteButton.setText("Delete");
        deleteButton.setPreferredSize(new java.awt.Dimension(75, 23));
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        jPanel3.add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, -1, -1));

        nameField.setPreferredSize(new java.awt.Dimension(150, 22));
        jPanel3.add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 13, 200, -1));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Food Category:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 44, -1, -1));

        categoryField.setPreferredSize(new java.awt.Dimension(150, 22));
        jPanel3.add(categoryField, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 41, 200, -1));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Food Price:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, -1, -1));
        jPanel3.add(priceField, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 207, -1));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Food Description:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 72, -1, -1));

        descriptionField.setPreferredSize(new java.awt.Dimension(150, 22));
        jPanel3.add(descriptionField, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 69, 200, -1));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel7.setText("Food Cost:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        costField.setPreferredSize(new java.awt.Dimension(100, 22));
        jPanel3.add(costField, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 207, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(79, 79, 79)
                            .addComponent(jLabel2))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(277, 277, 277)
                            .addComponent(jLabel1))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(37, 37, 37)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) foodItemTable.getModel();
        if (!editMode) {
        // Enter edit mode
            selectedRow = foodItemTable.getSelectedRow();
            if (selectedRow != -1) {
                // Get the current data from the selected row
                String name = (String) model.getValueAt(selectedRow, 1);
                String category = (String) model.getValueAt(selectedRow, 2);
                double price = (double) model.getValueAt(selectedRow, 3);
                String description = (String) model.getValueAt(selectedRow, 4);
                double cost = (double) model.getValueAt(selectedRow, 5);

                // Set the current data in the text fields
                nameField.setText(name);
                categoryField.setText(category);
                priceField.setText(Double.toString(price));
                descriptionField.setText(description);
                costField.setText(Double.toString(cost));

                editMode = true; // Switch to edit mode
            } else {
                JOptionPane.showMessageDialog(this, "Please select a food item to edit", "Empty input", JOptionPane.ERROR_MESSAGE);
            }
        } else {
        // Save changes
            if (selectedRow != -1) {
                // Get the updated data from the text fields
                String newName = nameField.getText();
                String newCategory = categoryField.getText();
                double newPrice = Double.parseDouble(priceField.getText());
                String newDescription = descriptionField.getText();
                double newCost = Double.parseDouble(costField.getText());

                // Check if changes have been made
                if (!newName.equals(model.getValueAt(selectedRow, 1)) ||
                        !newCategory.equals(model.getValueAt(selectedRow, 2)) ||
                        newPrice != (double) model.getValueAt(selectedRow, 3) ||
                        !newDescription.equals(model.getValueAt(selectedRow, 4)) ||
                        newCost != (double) model.getValueAt(selectedRow, 5)) {
                    
                    int itemID = (int) model.getValueAt(selectedRow, 0);
                    FoodItem selectedFoodItem = getFoodItem(itemID);
                    int vendorid = vendor.getVendorID();
                    selectedFoodItem.setVendorID(vendorid);
                    selectedFoodItem.setItemName(newName);
                    selectedFoodItem.setItemCategory(newCategory);
                    selectedFoodItem.setItemPrice(newPrice);
                    selectedFoodItem.setItemDescription(newDescription);
                    selectedFoodItem.setItemCost(newCost);
                    // Remove the old food item
                    allFoodItems.removeIf(item -> item.getItemID() == selectedFoodItem.getItemID() && item.getVendorID() == vendor.getVendorID());
                    // Add the updated food item
                    allFoodItems.add(selectedFoodItem);
                    // Write the updated list back to the file
                    writeToFile();
                    JOptionPane.showMessageDialog(this, "Successfully edited food item", "Success", JOptionPane.INFORMATION_MESSAGE);
                    // Refresh the table with updated data
                    readVendorFoodItems();
                    loadFoodItems();
                    nameField.setText("");
                    categoryField.setText("");
                    priceField.setText("");
                    descriptionField.setText("");
                    costField.setText("");
                    editMode = false; // Switch back to view mode
                } else {
                    // No changes were made
                    JOptionPane.showMessageDialog(this, "No changes made", "No Changes", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select a food item to edit", "Empty input", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        int vendorID = vendor.getVendorID();
        int itemID = checkMaxID();
        String name = nameField.getText();
        String category = categoryField.getText();
        double price = Double.parseDouble(priceField.getText());
        String description = descriptionField.getText();
        double cost = Double.parseDouble(costField.getText());
        
        FoodItem item = new FoodItem(vendorID, itemID, name, category, price, description, cost);
        allFoodItems.add(item);
        writeToFile();
        JOptionPane.showMessageDialog(this, "Successfully added food item", "Success", JOptionPane.INFORMATION_MESSAGE);
        // Refresh the table with updated data
        readVendorFoodItems();
        loadFoodItems();
        nameField.setText("");
        categoryField.setText("");
        priceField.setText("");
        descriptionField.setText("");
        costField.setText("");
    }//GEN-LAST:event_addButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) foodItemTable.getModel();
        selectedRow = foodItemTable.getSelectedRow();
        if (selectedRow != -1) {
            int confirmationResult = JOptionPane.showConfirmDialog(this, "Proceed to delete food item?", "Delete Confirmation", JOptionPane.YES_NO_OPTION);        
            if (confirmationResult == JOptionPane.YES_OPTION) {
                int itemID = (int) model.getValueAt(selectedRow, 0);
                FoodItem selectedFoodItem = getFoodItem(itemID);
                allFoodItems.removeIf(item -> item.getItemID() == selectedFoodItem.getItemID() && item.getVendorID() == vendor.getVendorID());
                writeToFile();
                readVendorFoodItems();
                loadFoodItems();
            } else {
                JOptionPane.showMessageDialog(this, "Action cancelled.", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTextField categoryField;
    private javax.swing.JTextField costField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField descriptionField;
    private javax.swing.JButton editButton;
    private javax.swing.JTable foodItemTable;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField priceField;
    // End of variables declaration//GEN-END:variables

}
