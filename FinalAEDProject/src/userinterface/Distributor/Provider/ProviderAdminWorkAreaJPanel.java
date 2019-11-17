/*
 * AdminWorkAreaJPanel.java
 *
 * Created on October 10, 2008, 8:50 AM
 */
package userinterface.Distributor.Provider;

import Business.Country.OpioidMedication;
import userinterface.Distributor.Supplier.*;
import Business.Pharmacy.Pharmacy;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.NetworkCountry;
import Business.Organization.HospitalOrganization;
import Business.Organization.Organization;

import Business.Organization.ProviderOrganization;
import Business.Organization.SupplierOrganization;
import Business.Supplier.Provider;
import Business.Supplier.Supplier;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.PharmacyWorkRequest;
import Business.WorkQueue.ProviderWorkRequest;
import Business.WorkQueue.WorkQueue;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import utility.Validator;

/**
 *
 * @author sonal
 */
public class ProviderAdminWorkAreaJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    UserAccount account;
    ProviderOrganization organization;
    Enterprise enterprise;
    EcoSystem business;
    NetworkCountry cNetwork;
    //Supplier s;
    Provider provider;

    /**
     * Creates new form AdminWorkAreaJPanel
     */
    public ProviderAdminWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, ProviderOrganization organization, Enterprise enterprise, EcoSystem business, NetworkCountry cNetwork) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.account = account;
        this.business = business;
        this.organization = organization;
        this.cNetwork = cNetwork;
//        for (Supplier supplier : organization.getSupplierList().getSupplierList()) {
//            if(account.getEmployee().getName().equals(supplier.getSupplierName())){
//                s=supplier;
//                System.out.println("supplier name"+s.getSupplierName());
//            }
//        }
//        s=organization.getProvider();
        provider = organization.getProvider();
        System.out.println("busi" + business.getWorkQueue().getWorkRequestList().size());
        if (provider.getWorkQueue() == null) {
            WorkQueue w = new WorkQueue();
            provider.setWorkQueue(w);
        }
        populateCombo();
        populateSupCombo();
        populateWorkQueueTable();
        populateWorkQueueTable2();
        populateQuantity();
        populateAvailable();
    }

    public void populateCombo() {
        for (OpioidMedication vaccine : cNetwork.getOpioidList().getOpioidList()) {
            comboVaccine.addItem(vaccine);
        }

    }

    public void populateSupCombo() {
        for (Organization organization1 : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization1 instanceof SupplierOrganization) {
                SupplierOrganization s = (SupplierOrganization) organization1;
                for (Supplier supplier : s.getSupplierList().getSupplierList()) {
                    comboSup.addItem(supplier);
                }

            }
        }
    }

    public void populateWorkQueueTable() {
        DefaultTableModel model = (DefaultTableModel) requestTable.getModel();

        model.setRowCount(0);

        for (WorkRequest work : business.getWorkQueue().getWorkRequestList()) {
            if (work instanceof PharmacyWorkRequest) {
                Object[] row = new Object[5];
                row[0] = ((PharmacyWorkRequest) work).getOpioidMed();
                row[1] = ((PharmacyWorkRequest) work).getRequestQuantity();
                row[2] = work;
                row[3] = work.getReceiver();
                row[4] = work.getSender();
                model.addRow(row);
            }
        }
    }

    public void populateWorkQueueTable2() {
        DefaultTableModel model = (DefaultTableModel) requestTable1.getModel();

        model.setRowCount(0);

        for (WorkRequest work : provider.getWorkQueue().getWorkRequestList()) {
            if (work instanceof ProviderWorkRequest) {
                Object[] row = new Object[6];
                row[0] = ((ProviderWorkRequest) work).getOpioidMed();
                row[1] = ((ProviderWorkRequest) work).getQuantity();
                row[2] = work;
                row[3] = work.getReceiver();
                row[4] = work.getSender();
                row[5] = ((ProviderWorkRequest) work).getSupplier();
                model.addRow(row);
            }
        }
    }

    public void populateAvailable() {
        DefaultTableModel model = (DefaultTableModel) availableTable.getModel();

        model.setRowCount(0);

        for (OpioidMedication vaccine : provider.getOpioidMediList().getOpioidList()) {

            Object[] row = new Object[2];
            row[0] = vaccine.getOpioidName();
            row[1] = vaccine.getQuantity();
            model.addRow(row);

        }
    }

    public void populateQuantity() {

        for (WorkRequest workRequest : provider.getWorkQueue().getWorkRequestList()) {
            // HashMap<WorkRequest,Integer> map = new HashMap<WorkRequest,Integer>();
            int temp = 0;
            ProviderWorkRequest p = (ProviderWorkRequest) workRequest;
            if (workRequest.getStatus().equals("Complete") && !p.isAdd()) { //&& add == false
                OpioidMedication v = p.getOpioidMed();

                for (OpioidMedication vaccine : provider.getOpioidMediList().getOpioidList()) {
                    if (v.getOpioidName().equals(vaccine.getOpioidName())) {
                        temp = 1;
                        vaccine.setQuantity(p.getQuantity() + vaccine.getQuantity());
                    }

                }
                if (temp == 0) {
                    OpioidMedication vac = provider.getOpioidMediList().addDisease();

                    vac.setOpioidName(v.getOpioidName());
                    vac.setQuantity(p.getQuantity());
                    //  organization.getP().getVaccine().getVaccineList().add(v);
                }
                p.setAdd(true);

            }
            //  account.getWorkQueue().getWorkRequestList().remove(workRequest);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        btnComplete = new javax.swing.JButton();
        reqBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        availableTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        requestTable = new javax.swing.JTable();
        comboVaccine = new javax.swing.JComboBox();
        txtquant = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        requestTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        reqBtn2 = new javax.swing.JButton();
        btnDelete2 = new javax.swing.JButton();
        comboSup = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        jLabel1.setText("Provider Work Area");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, -1, -1));
        add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 130, 20));

        btnComplete.setBackground(new java.awt.Color(36, 47, 65));
        btnComplete.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        btnComplete.setForeground(new java.awt.Color(255, 255, 255));
        btnComplete.setText("Complete");
        btnComplete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompleteActionPerformed(evt);
            }
        });
        add(btnComplete, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 440, 140, 30));

        reqBtn.setBackground(new java.awt.Color(36, 47, 65));
        reqBtn.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        reqBtn.setForeground(new java.awt.Color(255, 255, 255));
        reqBtn.setText("Assign To Me");
        reqBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reqBtnActionPerformed(evt);
            }
        });
        add(reqBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 440, 120, 30));

        availableTable.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        availableTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Opioid Name", "Quantity"
            }
        ));
        jScrollPane1.setViewportView(availableTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 290, 280, 400));

        jLabel4.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel4.setText("Opioids Requested from Pharma");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 270, 30));

        jLabel5.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel5.setText("Opioids Available");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 260, 170, 30));

        requestTable.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        requestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Opioid Name", "Quantity", "Status", "Receiver", "Sender"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(requestTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 500, 90));

        comboVaccine.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        add(comboVaccine, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 730, 120, -1));

        txtquant.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        txtquant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtquantActionPerformed(evt);
            }
        });
        txtquant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtquantKeyPressed(evt);
            }
        });
        add(txtquant, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 730, 100, -1));

        jLabel2.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel2.setText("Vaccine Name:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 730, 90, 20));

        backJButton.setBackground(new java.awt.Color(36, 47, 65));
        backJButton.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        backJButton.setForeground(new java.awt.Color(255, 255, 255));
        backJButton.setText("Refresh");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 660, -1, 30));

        btnDelete.setBackground(new java.awt.Color(36, 47, 65));
        btnDelete.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete request");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 440, -1, 30));

        requestTable1.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        requestTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Opioid Name", "Quantity", "Status", "Receiver", "Sender", "Supplier"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(requestTable1);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 550, 550, 90));

        jLabel6.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel6.setText("Opioids Requested to Supplier");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 520, 250, -1));

        reqBtn2.setBackground(new java.awt.Color(36, 47, 65));
        reqBtn2.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        reqBtn2.setForeground(new java.awt.Color(255, 255, 255));
        reqBtn2.setText("Request Vaccine");
        reqBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reqBtn2ActionPerformed(evt);
            }
        });
        add(reqBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 730, 170, 30));

        btnDelete2.setBackground(new java.awt.Color(36, 47, 65));
        btnDelete2.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        btnDelete2.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete2.setText("Delete request");
        btnDelete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete2ActionPerformed(evt);
            }
        });
        add(btnDelete2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 660, 160, 30));

        comboSup.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        add(comboSup, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 730, 130, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utility/tablets_capsules_multi-colored_drug_48978_1920x1080.jpg"))); // NOI18N
        jLabel7.setText("jLabel3");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 2500, 250));
    }// </editor-fold>//GEN-END:initComponents

    private void btnCompleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompleteActionPerformed
        // TODO add your handling code here:
        int selectedRow = requestTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select the row to assign the account", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            PharmacyWorkRequest p = (PharmacyWorkRequest) requestTable.getValueAt(selectedRow, 2);

            if (p.getReceiver() != null) {
                if (p.getStatus().equals("Pending")) {

                    if (account.getUsername().equalsIgnoreCase(p.getReceiver().getUsername())) {
                        UserAccount a = p.getSender();
                        int temp = 0;
                        if (provider.getOpioidMediList().getOpioidList().size() <= 0) {
                            JOptionPane.showMessageDialog(null, "No Stock available. Request from Supplier");
                            return;
                        }
                        for (OpioidMedication v : provider.getOpioidMediList().getOpioidList()) {
                            if (p.getOpioidMed().getOpioidName().equals(v.getOpioidName())) {
                                if (v.getQuantity() - p.getQuantity() < 0) {
                                    JOptionPane.showMessageDialog(null, "No enough Vaccines for supply. Wait for sometime");
                                    return;

                                }
                                temp = 1;
                                v.setQuantity(v.getQuantity() - p.getQuantity());

                            }

                        }
                        if (temp == 0) {
                            JOptionPane.showMessageDialog(null, "No Stock available. Request from Supplier.");
                            return;
                        }
                        p.setStatus("Complete");
                        JOptionPane.showMessageDialog(null, "You have successfully completed the request");
                        populateAvailable();
                        populateWorkQueueTable();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "You cannot complete it request again.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please assign first");
            }

        }
        populateAvailable();
    }//GEN-LAST:event_btnCompleteActionPerformed

    private void reqBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reqBtnActionPerformed

        int selectedRow = requestTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select the row to assign the account", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            PharmacyWorkRequest p = (PharmacyWorkRequest) requestTable.getValueAt(selectedRow, 2);
            if (p.getStatus().equalsIgnoreCase("Requested")) {
                p.setStatus("Pending");
                p.setReceiver(account);

                populateWorkQueueTable();
            } else {
                JOptionPane.showMessageDialog(null, "You can not assign twice samethingt", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
        ProviderWorkRequest request = new ProviderWorkRequest();
        request.setOpioidMed((OpioidMedication) comboVaccine.getSelectedItem());
       // request.setQuantity(Integer.parseInt(txtquant.getText()));
        request.setStatus("Requested");
        request.setSender(account);
        populateWorkQueueTable();

    }//GEN-LAST:event_reqBtnActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        new ProviderAdminWorkAreaJPanel(userProcessContainer, account, organization, enterprise, business, cNetwork);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int selectedRow = requestTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select the row to delete the account", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            PharmacyWorkRequest p = (PharmacyWorkRequest) requestTable.getValueAt(selectedRow, 2);

            business.getWorkQueue().getWorkRequestList().remove(p);

            //  business.getWorkQueue().getWorkRequestList().remove(p);
            JOptionPane.showMessageDialog(null, "You have successfully deleted the account");
            populateWorkQueueTable();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void reqBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reqBtn2ActionPerformed
        if (txtquant.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter a value");
        } else {

            String flag = "false";

            OpioidMedication o = ((OpioidMedication) comboVaccine.getSelectedItem());
            for (WorkRequest work : business.getWorkQueue().getWorkRequestList()) {
                if (work instanceof PharmacyWorkRequest) {
                    if (((PharmacyWorkRequest) work).getOpioidMed().getOpioidName().equalsIgnoreCase(o.getOpioidName())) {
                        flag = "true";
                    }
                }
            }
            if (flag == "true") {
                ProviderWorkRequest request = new ProviderWorkRequest();
                Supplier sup = (Supplier) comboSup.getSelectedItem();
                request.setQuantity(Integer.parseInt(txtquant.getText()));
                request.setOpioidMed((OpioidMedication) comboVaccine.getSelectedItem());
                request.setStatus("Requested");
                request.setSender(account);
                request.setSupplier(sup);
                sup.getWorkQueue().getWorkRequestList().add(request);
                provider.getWorkQueue().getWorkRequestList().add(request);
                populateWorkQueueTable2();

            } else {
                JOptionPane.showMessageDialog(null, "Selected opioid is not in a request queue", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_reqBtn2ActionPerformed

    private void btnDelete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete2ActionPerformed
        // TODO add your handling code here:
        int selectedRow = requestTable1.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select the row to delete the account", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            WorkRequest p = (WorkRequest) requestTable1.getValueAt(selectedRow, 2);

            // s.getWorkQueue().getWorkRequestList().remove(p);
            provider.getWorkQueue().getWorkRequestList().remove(p);
            account.getWorkQueue().getWorkRequestList().remove(p);
            business.getWorkQueue().getWorkRequestList().remove(p);
            JOptionPane.showMessageDialog(null, "You have successfully deleted the account");
            populateWorkQueueTable2();
        }
    }//GEN-LAST:event_btnDelete2ActionPerformed

    private void txtquantKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtquantKeyPressed
        // TODO add your handling code here:
        Validator.onlyInteger(evt, txtquant);
    }//GEN-LAST:event_txtquantKeyPressed

    private void txtquantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtquantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtquantActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable availableTable;
    private javax.swing.JButton backJButton;
    private javax.swing.JButton btnComplete;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDelete2;
    private javax.swing.JComboBox comboSup;
    private javax.swing.JComboBox comboVaccine;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton reqBtn;
    private javax.swing.JButton reqBtn2;
    private javax.swing.JTable requestTable;
    private javax.swing.JTable requestTable1;
    private javax.swing.JTextField txtquant;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables

}
