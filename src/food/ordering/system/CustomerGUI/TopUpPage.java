/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package food.ordering.system.CustomerGUI;

import food.ordering.system.AdminGUI.ReadFiles;
import food.ordering.system.AdminGUI.TopUpRequests;
import food.ordering.system.AdminGUI.TopUpRequests.TransactionStatus;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import textFiles.TextFilePaths;

/**
 *
 * @author LENOVO
 */
public class TopUpPage extends javax.swing.JFrame {
    
    private Customer customer;
    private int topUpAmount = 0;
    List<TopUpRequests> requests = new ArrayList<>();
    private LocalDateTime dateTime;
    
    TextFilePaths path = new TextFilePaths();
    String topUpRequestsTextFilePath = path.getTopUpRequestsTextFile();
    
    public TopUpPage(Customer customer) {
        initComponents();
        this.customer = customer;  
        
        ReadFiles reader = new ReadFiles();
        requests = reader.readTopUpRequests();
        
        LocalDateTime originalDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
        String formattedDateTimeStr = originalDateTime.format(formatter);
        dateTime = LocalDateTime.parse(formattedDateTimeStr, formatter);
    }
    
    private int setAmount (int amount) {
        topUpAmount = amount;
        return topUpAmount;
    }
    
    public int checkMaxID(List<TopUpRequests> requests) {
        int maxID = 0;
        for (TopUpRequests request : requests) {
            if (request.getRequestID() > maxID) {
                maxID = request.getRequestID();
            }
        }
        // Increment the maximum ID
        return maxID + 1;
    }
    
    private boolean saveRequest(int amount, String bankType, long cardNumber, YearMonth monthYear, int cvv, String remarks) {
        int requestID = checkMaxID(requests);
        
        TopUpRequests newRequest = new TopUpRequests(requestID, customer.getCustomerID(),
        amount, bankType, cardNumber, monthYear, cvv, remarks, dateTime, TransactionStatus.PENDING);
        
        try (PrintWriter pw = new PrintWriter(new FileWriter(topUpRequestsTextFilePath, true))) {
            pw.println(newRequest.toString());
        } catch (IOException ex) {
            System.out.println("Error!");
            return false;
        }
        return true;
    }
    
    private boolean isEmpty(String s) {
        return s == null || s.trim().isEmpty();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        reloadButton = new javax.swing.JButton();
        cvvField = new javax.swing.JTextField();
        cardNumberField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        banks = new javax.swing.JComboBox<>();
        cancelButton = new javax.swing.JButton();
        remarksField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        monthYearField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        fiftyButton = new javax.swing.JButton();
        hundredButton = new javax.swing.JButton();
        fourHundredButton = new javax.swing.JButton();
        twoHundredButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        amountUpdateField = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();

        jButton5.setText("Reload");

        jTextField5.setText("Remarks");

        jTextField4.setText("CVV");

        jTextField3.setText("MM/YY");

        jTextField2.setText("Card Number");

        jTextField1.setText("jTextField1");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton4.setText("RM 200");

        jButton1.setText("RM 50");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("RM 100");

        jButton3.setText("RM 400");

        jLabel2.setText("Enter Amount to Top Up");

        jLabel1.setText("Top Up Page");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        reloadButton.setText("Reload");
        reloadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadButtonActionPerformed(evt);
            }
        });

        cvvField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cvvFieldActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Top Up Page");

        banks.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Bank", "Maybank", "CIMB", "Public", "RHB", "Hong Leong" }));

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Remarks");

        monthYearField.setText("MM/YY");

        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Expiry Date");

        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("CVV");

        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Card Number");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fiftyButton.setText("RM 50");
        fiftyButton.setPreferredSize(new java.awt.Dimension(90, 25));
        fiftyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiftyButtonActionPerformed(evt);
            }
        });
        jPanel2.add(fiftyButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, -1, -1));

        hundredButton.setText("RM 100");
        hundredButton.setPreferredSize(new java.awt.Dimension(90, 25));
        hundredButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hundredButtonActionPerformed(evt);
            }
        });
        jPanel2.add(hundredButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        fourHundredButton.setText("RM 400");
        fourHundredButton.setPreferredSize(new java.awt.Dimension(90, 25));
        fourHundredButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fourHundredButtonActionPerformed(evt);
            }
        });
        jPanel2.add(fourHundredButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, -1, -1));

        twoHundredButton.setText("RM 200");
        twoHundredButton.setPreferredSize(new java.awt.Dimension(90, 25));
        twoHundredButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twoHundredButtonActionPerformed(evt);
            }
        });
        jPanel2.add(twoHundredButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, -1));

        jLabel3.setText("Enter Amount to Top Up");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        amountUpdateField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel2.add(amountUpdateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, -1, -1));

        jButton6.setText("Back");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(214, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(reloadButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cancelButton))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(116, 116, 116))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(banks, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(monthYearField)
                                .addGap(12, 12, 12)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cardNumberField)
                            .addComponent(cvvField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(remarksField)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 208, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel4)
                .addGap(24, 24, 24)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cardNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(banks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cvvField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monthYearField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(remarksField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reloadButton)
                    .addComponent(cancelButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addGap(19, 19, 19))
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

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void reloadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadButtonActionPerformed
        String bankType = banks.getSelectedItem().toString();
        String cardNumberText = cardNumberField.getText();
        String cvvText = cvvField.getText();
        String mmYyText = monthYearField.getText();
        String remarksText = remarksField.getText();

        if (topUpAmount == 0) {
            JOptionPane.showMessageDialog(this, "Please select your top up amount", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (bankType.equals("Select Bank") || isEmpty(cardNumberText) || isEmpty(cvvText) || isEmpty(mmYyText) || isEmpty(remarksText)) {
            JOptionPane.showMessageDialog(this, "All fields must be filled", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validate card number length
        if (cardNumberText.length() != 16) {
            JOptionPane.showMessageDialog(this, "Invalid card number format, Card number must be 16 digits", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validate CVV length
        if (cvvText.length() != 3) {
            JOptionPane.showMessageDialog(this, "Invalid CVV format, CVV must be 3 digits", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validate MM/YY format
        try {
            YearMonth.parse(mmYyText, java.time.format.DateTimeFormatter.ofPattern("MM/yy"));
        } catch (java.time.format.DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Expiry date must be in MM/YY format", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Long cardNumber = Long.valueOf(cardNumberText); 
        int cvv = Integer.parseInt(cvvText);
        YearMonth monthYear = YearMonth.parse(mmYyText, java.time.format.DateTimeFormatter.ofPattern("MM/yy"));
        int confirmationResult = JOptionPane.showConfirmDialog(this, "Proceed with top up?", "Top Up Confirmation", JOptionPane.YES_NO_OPTION);        

        if (confirmationResult == JOptionPane.YES_OPTION) {
            if (saveRequest(topUpAmount, bankType, cardNumber, monthYear, cvv, remarksText)) {
                JOptionPane.showMessageDialog(this, "Successfully sent top-up request to admin!");
                CustomerMainMenu menu = new CustomerMainMenu(customer);
                menu.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to send top-up request to admin, please revalidate your inputs", "Validation Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Top-up request cancelled", "Top Up Cancelled", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_reloadButtonActionPerformed

    private void hundredButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hundredButtonActionPerformed
        setAmount(100);
        amountUpdateField.setText("RM100");
    }//GEN-LAST:event_hundredButtonActionPerformed

    private void twoHundredButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_twoHundredButtonActionPerformed
        setAmount(200);
        amountUpdateField.setText("RM200");
    }//GEN-LAST:event_twoHundredButtonActionPerformed

    private void fourHundredButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fourHundredButtonActionPerformed
        setAmount(400);
        amountUpdateField.setText("RM400");
    }//GEN-LAST:event_fourHundredButtonActionPerformed

    private void fiftyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiftyButtonActionPerformed
        setAmount(50);
        amountUpdateField.setText("RM50");
    }//GEN-LAST:event_fiftyButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        JOptionPane.showMessageDialog(this, "Top-up request cancelled", "Top Up Cancelled", JOptionPane.INFORMATION_MESSAGE);
        CustomerMainMenu mainMenu = new CustomerMainMenu(customer);
        mainMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void cvvFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cvvFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cvvFieldActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        CustomerMainMenu page = new CustomerMainMenu(customer);
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amountUpdateField;
    private javax.swing.JComboBox<String> banks;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField cardNumberField;
    private javax.swing.JTextField cvvField;
    private javax.swing.JButton fiftyButton;
    private javax.swing.JButton fourHundredButton;
    private javax.swing.JButton hundredButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField monthYearField;
    private javax.swing.JButton reloadButton;
    private javax.swing.JTextField remarksField;
    private javax.swing.JButton twoHundredButton;
    // End of variables declaration//GEN-END:variables
}
