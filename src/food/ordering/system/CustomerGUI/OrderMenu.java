/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package food.ordering.system.CustomerGUI;
import food.ordering.system.ReadFiles;
import food.ordering.system.VendorGUI.Vendor;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author LENOVO
 */
public class OrderMenu extends javax.swing.JFrame {
    private Customer customer;
    private String vendorCategory = "";
    List<Vendor> vendors = new ArrayList<>();
    
    public OrderMenu(Customer customer) {
        initComponents();
        this.customer = customer;
        
        customerNameLabel.setText("Hi, "+customer.getName());
        ReadFiles reader = new ReadFiles();
        vendors = reader.readVendors();
        populateVendorInnerPanel();
    }
    
    private void populateVendorInnerPanel() {
        innerScrollPanel.removeAll();

        for (Vendor vendor : vendors) {
            if (vendor.getCategory().equalsIgnoreCase(vendorCategory)) {
                VendorPanel vendorPanel = new VendorPanel(this, vendor, customer);
                innerScrollPanel.add(vendorPanel);
            } else if (vendorCategory.equals("")) {
                VendorPanel vendorPanel = new VendorPanel(this, vendor, customer);
                innerScrollPanel.add(vendorPanel);
            }
        }

        // Repaint and revalidate innerPanel to reflect the changes
        innerScrollPanel.revalidate();
        innerScrollPanel.repaint();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        customerNameLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        nonHalalLabel = new javax.swing.JLabel();
        westernLabel = new javax.swing.JLabel();
        japaneseLabel = new javax.swing.JLabel();
        koreanLabel = new javax.swing.JLabel();
        fastFoodLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        vendorContainer = new javax.swing.JScrollPane();
        innerScrollPanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 400));

        customerNameLabel.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        customerNameLabel.setText("-");

        jPanel2.setBackground(new java.awt.Color(89, 185, 227));

        nonHalalLabel.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        nonHalalLabel.setForeground(new java.awt.Color(255, 255, 255));
        nonHalalLabel.setText("Non-Halal");
        nonHalalLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nonHalalLabelMouseClicked(evt);
            }
        });

        westernLabel.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        westernLabel.setForeground(new java.awt.Color(255, 255, 255));
        westernLabel.setText("Western");
        westernLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                westernLabelMouseClicked(evt);
            }
        });

        japaneseLabel.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        japaneseLabel.setForeground(new java.awt.Color(255, 255, 255));
        japaneseLabel.setText("Japanese");
        japaneseLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                japaneseLabelMouseClicked(evt);
            }
        });

        koreanLabel.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        koreanLabel.setForeground(new java.awt.Color(255, 255, 255));
        koreanLabel.setText("Korean");
        koreanLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                koreanLabelMouseClicked(evt);
            }
        });

        fastFoodLabel.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        fastFoodLabel.setForeground(new java.awt.Color(255, 255, 255));
        fastFoodLabel.setText("Fast Food");
        fastFoodLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fastFoodLabelMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Show All");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(nonHalalLabel)
                .addGap(33, 33, 33)
                .addComponent(westernLabel)
                .addGap(33, 33, 33)
                .addComponent(japaneseLabel)
                .addGap(35, 35, 35)
                .addComponent(koreanLabel)
                .addGap(31, 31, 31)
                .addComponent(fastFoodLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 196, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(17, 17, 17))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nonHalalLabel)
                    .addComponent(westernLabel)
                    .addComponent(japaneseLabel)
                    .addComponent(koreanLabel)
                    .addComponent(fastFoodLabel)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        vendorContainer.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        innerScrollPanel.setLayout(new javax.swing.BoxLayout(innerScrollPanel, javax.swing.BoxLayout.Y_AXIS));
        vendorContainer.setViewportView(innerScrollPanel);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ebrima", 0, 12)); // NOI18N
        jLabel1.setText("What do you want to eat today?");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(vendorContainer))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(customerNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(customerNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vendorContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        CustomerMainMenu page = new CustomerMainMenu(customer);
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void nonHalalLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nonHalalLabelMouseClicked
        vendorCategory = "non-halal";
        populateVendorInnerPanel();
    }//GEN-LAST:event_nonHalalLabelMouseClicked

    private void westernLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_westernLabelMouseClicked
        vendorCategory = "western";
        populateVendorInnerPanel();
    }//GEN-LAST:event_westernLabelMouseClicked

    private void japaneseLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_japaneseLabelMouseClicked
        vendorCategory = "japanese";
        populateVendorInnerPanel();
    }//GEN-LAST:event_japaneseLabelMouseClicked

    private void koreanLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_koreanLabelMouseClicked
        vendorCategory = "korean";
        populateVendorInnerPanel();
    }//GEN-LAST:event_koreanLabelMouseClicked

    private void fastFoodLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fastFoodLabelMouseClicked
        vendorCategory = "fast food";
        populateVendorInnerPanel();
    }//GEN-LAST:event_fastFoodLabelMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        vendorCategory = "";
        populateVendorInnerPanel();
    }//GEN-LAST:event_jLabel2MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel customerNameLabel;
    private javax.swing.JLabel fastFoodLabel;
    private javax.swing.JPanel innerScrollPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel japaneseLabel;
    private javax.swing.JLabel koreanLabel;
    private javax.swing.JLabel nonHalalLabel;
    private javax.swing.JScrollPane vendorContainer;
    private javax.swing.JLabel westernLabel;
    // End of variables declaration//GEN-END:variables
}
