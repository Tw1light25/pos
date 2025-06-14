/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.schoolproject.pos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author BIGMAN
 */
public class editEntry extends javax.swing.JFrame {
    /**
     * Creates new form editEntry
     */
    
    private int rowIndex;       
    private JTable table;

    public editEntry(JTable table, int rowIndex){
        initComponents();
        
        this.table = table;
        this.rowIndex = rowIndex;
                
        String currentItem = table.getValueAt(rowIndex, 3).toString(); 
        String currentQty = table.getValueAt(rowIndex, 4).toString();  

        itemEdit.setSelectedItem(currentItem);
        qtyEdit.setSelectedItem(currentQty);

        saveBtn.addActionListener(e -> {
            String newItem = itemEdit.getSelectedItem().toString();
            String newQty = qtyEdit.getSelectedItem().toString();

            table.setValueAt(newItem, rowIndex, 3);
            table.setValueAt(newQty, rowIndex, 4);

            
            this.dispose();
        });
    }
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        itemEdit = new javax.swing.JComboBox<>();
        qtyEdit = new javax.swing.JComboBox<>();
        saveBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        itemEdit.setFont(new java.awt.Font("Microsoft PhagsPa", 0, 36)); // NOI18N
        itemEdit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gallon", "Round Gallon" }));

        qtyEdit.setFont(new java.awt.Font("MS UI Gothic", 0, 36)); // NOI18N
        qtyEdit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        saveBtn.setText("SAVE");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        cancelBtn.setText("CANCEL");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(saveBtn)
                    .addComponent(itemEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(qtyEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cancelBtn)))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qtyEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(105, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
    try {
    // Read all lines from CSV
        BufferedReader br = new BufferedReader(new FileReader("sales.csv"));
        ArrayList<String> lines = new ArrayList<>();
        String line;
    while ((line = br.readLine()) != null) {
        lines.add(line);
    }
    br.close();

    // Check if rowIndex is valid (skip header row at index 0)
        if (rowIndex <= 0 || rowIndex >= lines.size()) return;

    // Get the selected row data
    String[] data = lines.get(rowIndex).split(",");

    // Replace item and quantity (assuming index 3 = item, 4 = qty)
    data[3] = itemEdit.getSelectedItem().toString();
    data[4] = String.valueOf(qtyEdit.getSelectedIndex() + 1);

    // Update line in the list
    lines.set(rowIndex, String.join(",", data));

    // Write everything back to file (overwrite)
    BufferedWriter bw = new BufferedWriter(new FileWriter("sales.csv"));
    for (String ln : lines) {
        bw.write(ln);
        bw.newLine();
    }
    bw.close();

    dispose(); // close the form
    } catch (Exception e) {
    e.printStackTrace();
    }


    }//GEN-LAST:event_saveBtnActionPerformed
    
   
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(editEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editEntry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new editEntry().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JComboBox<String> itemEdit;
    private javax.swing.JComboBox<String> qtyEdit;
    private javax.swing.JButton saveBtn;
    // End of variables declaration//GEN-END:variables
}
