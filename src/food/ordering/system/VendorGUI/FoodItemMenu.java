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
            e.printStackTrace(); 
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
        jLabel3 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        categoryField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        priceField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        descriptionField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        costField = new javax.swing.JTextField();
        editButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        viewButton = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

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

        jLabel1.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
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

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Food Name:");

        nameField.setPreferredSize(new java.awt.Dimension(150, 25));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Food Category:");

        categoryField.setPreferredSize(new java.awt.Dimension(150, 25));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Food Price:");

        priceField.setPreferredSize(new java.awt.Dimension(150, 25));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Food Description:");

        descriptionField.setPreferredSize(new java.awt.Dimension(150, 25));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel7.setText("Food Cost:");

        costField.setPreferredSize(new java.awt.Dimension(150, 25));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(descriptionField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(categoryField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(nameField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(costField, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(priceField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(categoryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(descriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(costField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addGap(10, 10, 10))
        );

        editButton.setBackground(new java.awt.Color(255, 255, 254));
        editButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        editButton.setText("Edit");
        editButton.setPreferredSize(new java.awt.Dimension(75, 25));
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        addButton.setBackground(new java.awt.Color(255, 255, 254));
        addButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addButton.setText("Add");
        addButton.setPreferredSize(new java.awt.Dimension(75, 25));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        deleteButton.setBackground(new java.awt.Color(255, 255, 254));
        deleteButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        deleteButton.setText("Delete");
        deleteButton.setPreferredSize(new java.awt.Dimension(75, 25));
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        viewButton.setBackground(new java.awt.Color(255, 255, 254));
        viewButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        viewButton.setText("View");
        viewButton.setPreferredSize(new java.awt.Dimension(75, 25));
        viewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewButtonActionPerformed(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabel2))
                            .addComponent(jLabel12))
                        .addGap(183, 183, 183)
                        .addComponent(jLabel1))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(viewButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 13, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
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
        String newName = nameField.getText();
        String newCategory = categoryField.getText();
        String newPrice = priceField.getText();
        String newDescription = descriptionField.getText();
        String newCost = costField.getText();
        double parsedPrice = Double.parseDouble(newPrice);
        double parsedCost = Double.parseDouble(newCost);

        if (!newName.equals(model.getValueAt(selectedRow, 1)) ||
                !newCategory.equals(model.getValueAt(selectedRow, 2)) ||
                parsedPrice != (double) model.getValueAt(selectedRow, 3) ||
                !newDescription.equals(model.getValueAt(selectedRow, 4)) ||
                parsedCost != (double) model.getValueAt(selectedRow, 5)) {

            int itemID = (int) model.getValueAt(selectedRow, 0);
            FoodItem selectedFoodItem = getFoodItem(itemID);
            int vendorid = vendor.getVendorID();
            selectedFoodItem.setVendorID(vendorid);
            selectedFoodItem.setItemName(newName);
            selectedFoodItem.setItemCategory(newCategory);
            selectedFoodItem.setItemPrice(parsedPrice);
            selectedFoodItem.setItemDescription(newDescription);
            selectedFoodItem.setItemCost(parsedCost);
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

    private void viewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) foodItemTable.getModel();

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
        } else {
            JOptionPane.showMessageDialog(this, "Please select a food item to edit", "Empty input", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_viewButtonActionPerformed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        VendorMainMenu page = new VendorMainMenu(vendor);
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

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
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JButton viewButton;
    // End of variables declaration//GEN-END:variables

}
