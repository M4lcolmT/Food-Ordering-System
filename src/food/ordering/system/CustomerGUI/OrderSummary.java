/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package food.ordering.system.CustomerGUI;

import food.ordering.system.AdminGUI.Notification;
import food.ordering.system.AdminGUI.ReadFiles;
import food.ordering.system.CustomerGUI.Order.OrderType;
import food.ordering.system.Location;
import food.ordering.system.RunnerGUI.Runner;
import food.ordering.system.RunnerGUI.Task;
import food.ordering.system.VendorGUI.Vendor;
import food.ordering.system.VendorGUI.FoodItem;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jiasi
 */
public class OrderSummary extends javax.swing.JFrame {
    private Order order;
    private Vendor vendor;
    private Customer customer;
    private final Runner availableRunner;
    private double subtotal;
    private double tax;
    private double distance;
    private double deliveryFee;
    private double totalPrice;
    private double credit;
    private List<FoodItem> orderBasket;
    private final List<Runner> runners;
    private final List<Task> tasks;
    private final List<Notification> notifications;
    private List<Order> orders = new ArrayList<>();
    private OrderType newOrderType;
    private final OrderManager orderManager = new OrderManager();

    DecimalFormat df = new DecimalFormat("#.#");
    
    public OrderSummary(Order order, List<FoodItem> orderBasket) {
        initComponents();
        this.order = order;
        this.orderBasket = orderBasket;
        loadBasketItems(orderBasket);
        
        customer = order.getCustomer();
        vendor = order.getVendor();
        calculateDistance(customer.getCity().trim().toLowerCase(), vendor.getCity().trim().toLowerCase());
        
        nameLabel.setText(customer.getName());
        phoneNumberLabel.setText(customer.getPhoneNumber());
        addressBox.setText(customer.getStreetAddress());
        String customerCity = customer.getCity().trim().toLowerCase();
        for (int i = 0; i < cityComboBox.getItemCount(); i++) {
            if (customerCity.equals(cityComboBox.getItemAt(i).trim().toLowerCase())) {
                cityComboBox.setSelectedIndex(i);
                break;
            }
        }
        
        credit = customer.getCredit();
        subtotal = order.getTotalPrice();
        subtotalLabel.setText("RM"+Double.toString((double)subtotal));
        taxLabel.setText("RM"+Double.toString((double)calculateTax()));
        deliveryFeeLabel.setText("RM"+Double.toString((double)calculateDeliveryFee()));
        totalPriceLabel.setText("RM"+Double.toString((double)calculateTotal()));
        
        ReadFiles reader = new ReadFiles();
        runners = reader.readRunners();
        tasks = reader.readTasks();
        notifications = reader.readNotifications();
        availableRunner = checkRunner();
        orders = orderManager.getOrders();
    }
    
    public void loadBasketItems(List<FoodItem> items) {
        DefaultTableModel model = (DefaultTableModel) orderSummaryTable.getModel();

        if (items.isEmpty()) {
            System.out.println("Items list is empty.");
        } else {
            System.out.println("Items list contains " + items.size() + " items.");
        }

        // Create a set to keep track of unique items
        Set<FoodItem> uniqueItems = new HashSet<>(items);

        for (FoodItem item : uniqueItems) {
            int quantity = calculateQuantity(items, item);
            String itemName = item.getItemName();
            double price = item.getItemPrice();

            Object[] rowData = { quantity, itemName, price };
            model.addRow(rowData);
        }
    }
    
    private int calculateQuantity(List<FoodItem> items, FoodItem targetItem) {
        int count = 0;
        for (FoodItem item : items) {
            if (item.getItemID() == targetItem.getItemID()) {
                count++;
            }
        }
        return count;
    }
    
    private double calculateTax(){
        tax = subtotal * 0.0565;
        return Double.parseDouble(df.format(tax));
    }
    
    private void calculateDistance(String customerCity, String vendorCity) {
        Location customerLocation = Location.locationMap.get(customerCity);
        Location vendorLocation = Location.locationMap.get(vendorCity);

        if (customerLocation != null && vendorLocation != null) {
            distance = Location.calculateDistance(customerLocation,vendorLocation);
        } else {
            System.out.println("Unknown location");
        }
    }
    
    private void updateDeliveryFee() {
        calculateDistance(customer.getCity().trim().toLowerCase(), vendor.getCity().trim().toLowerCase());
        deliveryFee = calculateDeliveryFee();
        deliveryFeeLabel.setText("RM" + Double.toString(deliveryFee));
        totalPriceLabel.setText("RM" + Double.toString(calculateTotal()));
    }
    
    private double calculateDeliveryFee(){
        if (distance >= 3.0 && distance <= 10.0) {
            deliveryFee = 2.5;
        } else if (distance > 10.0 && distance <= 15.0) {
            deliveryFee = 5.0;
        } else if (distance > 15.0 && distance <= 20.0) {
            deliveryFee = 7.5;
        } else {
            deliveryFee = 10.0;
        }
        return deliveryFee;
    }
    
    private double calculateTotal() {
        totalPrice = subtotal + tax + deliveryFee;
        return Double.parseDouble(df.format(totalPrice));
    }
    
    //Check runner avaliability
    private Runner checkRunner() {
        for (Runner item : runners) {
            if (item.isRunnerAvailability() == true) {
                return item;
            }
        }
        return null;
    }
    
    private int checkMaxTaskID() {
        int maxID = 0;
        for (Task task : tasks) {
            if (task.getTaskID() > maxID) {
                maxID = task.getTaskID();
            }
        }
        // Increment the maximum ID
        return maxID + 1;
    }
    
    private int checkMaxNotificationID() {
        int maxID = 0;
        for (Notification notification : notifications) {
            if (notification.getNotificationID() > maxID) {
                maxID = notification.getNotificationID();
            }
        }
        // Increment the maximum ID
        return maxID + 1;
    }
    
    private LocalDateTime getDateTime() {
        LocalDateTime originalDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
        String formattedDateTimeStr = originalDateTime.format(formatter);
        LocalDateTime parsedDateTime = LocalDateTime.parse(formattedDateTimeStr, formatter);
        return parsedDateTime;
    }
    
    private void saveOrder(OrderType orderType) {
        order.setOrderType(orderType);
        order.setDateTime(getDateTime());
        orders.add(order);
        order.saveOrder(orders);
    }
    
    private void placeOrder() {
        Menu menu = new Menu(vendor, customer, orderBasket);
        menu.resetTotalPrice();
        
        if (availableRunner == null) {
            // No delivery fees and recalculate total price
            deliveryFee = 0;
            saveOrder(newOrderType);
        } else {
            saveOrder(newOrderType);
            // New Runner task
            Task newTask;
            newTask = new Task(checkMaxTaskID(), availableRunner.getRunnerID(),order.getOrderID(), Task.TaskStatus.PENDING, deliveryFee, getDateTime());
            newTask.createTask(newTask);
        }
        credit = deductCredit();
        customer.setCredit(credit);
        orderManager.saveUpdatedCustomerInfo(customer);
        orderBasket.clear();
        this.dispose();
        
        CustomerMainMenu mainMenu = new CustomerMainMenu(customer);
        mainMenu.setVisible(true);
        this.dispose();
    }
    
    private boolean checkCustomerCredit() {
        return credit >= calculateTotal();
    }
    
    private double deductCredit() {
        credit = credit - calculateTotal();
        return Double.parseDouble(df.format(credit));
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        subtotalLabel = new javax.swing.JLabel();
        taxLabel = new javax.swing.JLabel();
        deliveryFeeLabel = new javax.swing.JLabel();
        totalPriceLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        orderSummaryTable = new javax.swing.JTable();
        updateItemCount = new javax.swing.JButton();
        confirmButton = new javax.swing.JButton();
        backToMenuButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        phoneNumberLabel = new javax.swing.JLabel();
        addressBox = new javax.swing.JTextField();
        cityComboBox = new javax.swing.JComboBox<>();
        cancelButton = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 400));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Order Summary");

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Subtotal");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Tax");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Delivery Fees");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Total");

        subtotalLabel.setText("RM25");

        taxLabel.setText("RM2");

        deliveryFeeLabel.setText("RM5");

        totalPriceLabel.setText("RM32");

        orderSummaryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Quantity", "Food", "Price"
            }
        ));
        jScrollPane1.setViewportView(orderSummaryTable);
        if (orderSummaryTable.getColumnModel().getColumnCount() > 0) {
            orderSummaryTable.getColumnModel().getColumn(0).setPreferredWidth(10);
            orderSummaryTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            orderSummaryTable.getColumnModel().getColumn(2).setPreferredWidth(10);
        }

        updateItemCount.setText("Edit Item Count");
        updateItemCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateItemCountActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(updateItemCount)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(subtotalLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(taxLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deliveryFeeLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(totalPriceLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(subtotalLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(taxLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(deliveryFeeLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(totalPriceLabel)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(updateItemCount)))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        confirmButton.setText("Confirm");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        backToMenuButton.setText("Back");
        backToMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToMenuButtonActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 2, 13)); // NOI18N
        jLabel15.setText("Phone Number:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 2, 13)); // NOI18N
        jLabel13.setText("Name:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 13)); // NOI18N
        jLabel2.setText("Address:");

        nameLabel.setText("name");

        phoneNumberLabel.setText("01111222223");

        addressBox.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        addressBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressBoxActionPerformed(evt);
            }
        });

        cityComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "City", "Shah Alam", "Petaling Jaya", "Subang Jaya", "Klang", "Puchong", "Ampang", "Kajang", "Cyberjaya", "Seri Kembangan", "Hulu Langat", "Bukit Jalil" }));
        cityComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cityComboBoxItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phoneNumberLabel)
                            .addComponent(nameLabel)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addressBox, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addComponent(cityComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel13)
                .addGap(3, 3, 3)
                .addComponent(nameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addGap(5, 5, 5)
                .addComponent(phoneNumberLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addressBox, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(backToMenuButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(confirmButton, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(backToMenuButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(confirmButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        Object[] options = {"Take Away", "Dine In", "Cancel Order"};
        String newstreetAddress = addressBox.getText();
        String newCity = String.valueOf(cityComboBox.getSelectedItem());
                
        if (newCity.equals("City")){
            JOptionPane.showMessageDialog(this, "Please select a city", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        } 
        
        customer.setStreetAddress(newstreetAddress);
        customer.setCity(newCity);
        orderManager.saveUpdatedCustomerInfo(customer);
        if (checkCustomerCredit()) {
            if (checkRunner() != null) {
                newOrderType = OrderType.DELIVERY;
                placeOrder();
                //Send notif to vendor
                Notification vendorNotif = new Notification(checkMaxNotificationID(), Notification.NotifType.ORDER, vendor.getVendorID(), Notification.NotifUserType.VENDOR, order.getOrderID(), "New order!", getDateTime());
                vendorNotif.saveNotification(vendorNotif);
                //Send notif to runner
                Notification runnerNotif = new Notification(checkMaxNotificationID(), Notification.NotifType.ORDER, availableRunner.getRunnerID(), Notification.NotifUserType.RUNNER, order.getOrderID(), "New task!", getDateTime());
                runnerNotif.saveNotification(runnerNotif);
                //Send notif to customer
                Notification customerNotif = new Notification(checkMaxNotificationID(), Notification.NotifType.ORDER, customer.getCustomerID(), Notification.NotifUserType.CUSTOMER, order.getOrderID(), "Your order is processing!", getDateTime());
                customerNotif.saveNotification(customerNotif);
            } else {
                int result = JOptionPane.showOptionDialog(this, "There is no available runners. Would you like to dine in or take away instead?", "No runners", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                switch (result) {
                    case JOptionPane.YES_OPTION:
                        // User clicked on "Take Away"
                        newOrderType = OrderType.TAKEAWAY;
                        placeOrder();
                        //Send notif to vendor
                        Notification takeAwayNotif = new Notification(checkMaxNotificationID(), Notification.NotifType.ORDER, customer.getCustomerID(), Notification.NotifUserType.VENDOR, order.getOrderID(), "New order!", getDateTime());
                        takeAwayNotif.saveNotification(takeAwayNotif);
                        break;
                    case JOptionPane.NO_OPTION:
                        // User clicked on "Dine In"
                        newOrderType = OrderType.DINEIN;
                        placeOrder();
                        Notification dineInNotif;
                        dineInNotif = new Notification(checkMaxNotificationID(), Notification.NotifType.ORDER, customer.getCustomerID(), Notification.NotifUserType.VENDOR, order.getOrderID(), "New order!", getDateTime());
                        dineInNotif.saveNotification(dineInNotif);
                        break;
                    case JOptionPane.CLOSED_OPTION:
                        // User click the x button to close the dialog
                        break;
                    default:
                        // User selected "Cancel Order"
                        newOrderType = OrderType.DELIVERY; // Pass in placeholder/Temp since cannot be null
                        CustomerMainMenu page = new CustomerMainMenu(customer);
                        page.setVisible(true);
                        this.dispose();
                        break;
                }
            }
        } else {
            // Customer does not have enough credit
            Menu menu = new Menu(order.getVendor(), order.getCustomer(), orderBasket);
            menu.resetTotalPrice();
            double difference = credit - calculateTotal();
            JOptionPane.showMessageDialog(this, "You are short of RM" + df.format(difference) + ". Please top up before placing an order.", "Insufficient credit", JOptionPane.ERROR_MESSAGE);
            TopUpPage page = new TopUpPage(customer);
            page.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_confirmButtonActionPerformed
  
    private void backToMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToMenuButtonActionPerformed
        loadBasketItems(orderBasket);
        Customer orderCustomer = order.getCustomer();
        Vendor orderVendor = order.getVendor();
        
        Menu menu = new Menu(orderVendor, orderCustomer, orderBasket);
        menu.updateItemCount();
        double subtotalDecimal = Double.parseDouble(df.format(subtotal));
        menu.totalPriceLabel.setText(Double.toString(subtotalDecimal));
        menu.setTotalPrice(subtotal);
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backToMenuButtonActionPerformed

    private void updateItemCountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateItemCountActionPerformed
        int selectedRowIndex = orderSummaryTable.getSelectedRow();

        if (selectedRowIndex != -1) {
            DefaultTableModel model = (DefaultTableModel) orderSummaryTable.getModel();
            Integer currentValue = (Integer) model.getValueAt(selectedRowIndex, 0);
            String itemName = (String) model.getValueAt(selectedRowIndex, 1);

            // Input validation loop
            Integer newValue = null;
            boolean validInput = false;

            while (!validInput) {
                try {
                    Object result = JOptionPane.showInputDialog(this, "Edit Item Count:", "Edit", JOptionPane.PLAIN_MESSAGE, null, null, currentValue);

                    if (result == null) {
                        // User canceled the input
                        return;
                    }
                    // Attempt to parse the input as an integer
                    newValue = Integer.valueOf(result.toString());
                    // Input is valid if no exception is thrown
                    validInput = true;
                } catch (NumberFormatException e) {
                    // Input is not a valid integer
                    JOptionPane.showMessageDialog(this, "Please enter a valid integer.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }

            // Update the model with the new value
            if (newValue != null) {
                model.setValueAt(newValue, selectedRowIndex, 0);
                // Update the orderBasket based on the new value
                Iterator<FoodItem> iterator = orderBasket.iterator();
                while (iterator.hasNext()) {
                    FoodItem item = iterator.next();
                    // Check if the item name matches
                    if (itemName.equals(item.getItemName())) {
                        int quantityDifference = newValue - currentValue;
                        if (quantityDifference > 0) {
                            // If the new quantity is greater, add items to the orderBasket
                            for (int i = 0; i < quantityDifference; i++) {
                                orderBasket.add(item);
                            }
                            subtotal = subtotal + quantityDifference * item.getItemPrice();
                            subtotalLabel.setText("RM"+Double.toString((double)subtotal));
                            totalPriceLabel.setText("RM"+Double.toString((double)calculateTotal()));
                        } else if (quantityDifference < 0) {
                            // If the new quantity is less, remove items from the orderBasket
                            for (int i = 0; i < -quantityDifference; i++) {
                                iterator.remove();
                            }
                            subtotal = subtotal - (-quantityDifference) * item.getItemPrice();
                            subtotalLabel.setText("RM"+Double.toString((double)subtotal));
                            totalPriceLabel.setText("RM"+Double.toString((double)calculateTotal()));
                        }
                        break;
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to edit.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_updateItemCountActionPerformed

    private void addressBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressBoxActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        int confirmationResult = JOptionPane.showConfirmDialog(this, "Proceed to cancel order?", "Cancel Confirmation", JOptionPane.YES_NO_OPTION);        

        if (confirmationResult == JOptionPane.YES_OPTION) {
            Menu menu = new Menu(order.getVendor(), order.getCustomer(), orderBasket);
            menu.resetTotalPrice();
            System.out.println("subtotal"+order.getTotalPrice());
            CustomerMainMenu page = new CustomerMainMenu(customer);
            page.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void cityComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cityComboBoxItemStateChanged
        OrderManager ordermanager = new OrderManager();
        String newCity = String.valueOf(cityComboBox.getSelectedItem());
        if (!newCity.equals("City")) {
            customer.setCity(newCity);
            ordermanager.saveUpdatedCustomerInfo(customer);
            updateDeliveryFee();
        }
    }//GEN-LAST:event_cityComboBoxItemStateChanged

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressBox;
    private javax.swing.JButton backToMenuButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox<String> cityComboBox;
    private javax.swing.JButton confirmButton;
    private javax.swing.JLabel deliveryFeeLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTable orderSummaryTable;
    private javax.swing.JLabel phoneNumberLabel;
    private javax.swing.JLabel subtotalLabel;
    private javax.swing.JLabel taxLabel;
    private javax.swing.JLabel totalPriceLabel;
    private javax.swing.JButton updateItemCount;
    // End of variables declaration//GEN-END:variables
}
