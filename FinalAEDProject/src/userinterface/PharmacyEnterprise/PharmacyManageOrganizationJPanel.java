/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.PharmacyEnterprise;

import Business.Organization.Organization;
import Business.Organization.Organization.Type;
import Business.Organization.OrganizationDirectory;
import java.awt.CardLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vignesh Murali
 */
public class PharmacyManageOrganizationJPanel extends javax.swing.JPanel {
    private OrganizationDirectory directory;
    private JPanel userProcessContainer;
    /**
     * Creates new form PharmacyManageOrganizationJPanel
     */


    PharmacyManageOrganizationJPanel(JPanel userProcessContainer, OrganizationDirectory directory) {
         initComponents();
        this.directory=directory;
        this.userProcessContainer=userProcessContainer;
        
        populateTable();
        populateCombo();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        organizationJTable = new javax.swing.JTable();
        addJButton = new javax.swing.JButton();
        organizationJComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        orgNametxtbox = new javax.swing.JTextField();
        delBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        organizationJTable.setBackground(new java.awt.Color(36, 47, 65));
        organizationJTable.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        organizationJTable.setForeground(new java.awt.Color(255, 255, 255));
        organizationJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(organizationJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 320, 480, 92));

        addJButton.setBackground(new java.awt.Color(36, 47, 65));
        addJButton.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        addJButton.setForeground(new java.awt.Color(255, 255, 255));
        addJButton.setText("Add Pharmacy");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });
        add(addJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 530, 210, 40));

        organizationJComboBox.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        organizationJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(organizationJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 430, 190, -1));

        jLabel1.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setText("Manage Pharmacy Organizations");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, -1, -1));

        backJButton.setBackground(new java.awt.Color(36, 47, 65));
        backJButton.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        backJButton.setForeground(new java.awt.Color(255, 255, 255));
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 317, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel2.setText("Name");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 480, -1, -1));

        orgNametxtbox.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        add(orgNametxtbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 480, 190, -1));

        delBtn.setBackground(new java.awt.Color(36, 47, 65));
        delBtn.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        delBtn.setForeground(new java.awt.Color(255, 255, 255));
        delBtn.setText("Delete Pharmacy");
        delBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delBtnActionPerformed(evt);
            }
        });
        add(delBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 670, 220, 50));

        updateBtn.setBackground(new java.awt.Color(36, 47, 65));
        updateBtn.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        updateBtn.setForeground(new java.awt.Color(255, 255, 255));
        updateBtn.setText("Update Pharmacy");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });
        add(updateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 590, 210, 50));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utility/tablets_capsules_multi-colored_drug_48978_1920x1080.jpg"))); // NOI18N
        jLabel6.setText("jLabel3");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 2500, 250));

        jLabel3.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel3.setText("Organization Type");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 430, -1, -1));
    }// </editor-fold>//GEN-END:initComponents
 private void populateCombo(){
        organizationJComboBox.removeAllItems();
       // for (Type type : Organization.Type.values()){
         //   if (!type.getValue().equals(Type.Admin.getValue()))
                organizationJComboBox.addItem(Organization.Type.PharmacyOrganization);
                
        //}
    }

    private void populateTable(){
        DefaultTableModel model = (DefaultTableModel) organizationJTable.getModel();
        
        model.setRowCount(0);
        
        for (Organization organization : directory.getOrganizationList()){
            Object[] row = new Object[2];
            row[0] = organization.getOrganizationID();
            row[1] = organization;
            
            model.addRow(row);
        }
    }
    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed
               ArrayList<String> checkEnter = new ArrayList<>();  
        for(Organization e : directory.getOrganizationList())
        {
            checkEnter.add(e.getName());
        }
        
        if(checkEnter.contains(orgNametxtbox.getText()))
        {
            JOptionPane.showMessageDialog(null,"Organization exists already.");
            
            return;
        }
        if(organizationJComboBox.getSelectedItem()==null)
        {
             JOptionPane.showMessageDialog(null, "There is no organization");
            return;
            
        }
        if(orgNametxtbox.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please enter a name to proceed");
            return;
        }
        Type type = (Type) organizationJComboBox.getSelectedItem();
        String name = orgNametxtbox.getText();
        directory.createOrganization(type,name);
        populateTable();
    }//GEN-LAST:event_addJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void delBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = organizationJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select the patient to delete the account", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            Organization e = (Organization) organizationJTable.getValueAt(selectedRow, 1);

            directory.getOrganizationList().remove(e);

            JOptionPane.showMessageDialog(null, "Hospital is removed");
            populateTable();
        }
    }//GEN-LAST:event_delBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = organizationJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select the patient to delete the account", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            Organization e = (Organization) organizationJTable.getValueAt(selectedRow, 1);
            updateOrganizationJPanel manageOrganizationJPanel = new updateOrganizationJPanel(userProcessContainer, directory,e);
            userProcessContainer.add("HospitalManageOrganizationJPanel", manageOrganizationJPanel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
    }//GEN-LAST:event_updateBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JButton delBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField orgNametxtbox;
    private javax.swing.JComboBox organizationJComboBox;
    private javax.swing.JTable organizationJTable;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}