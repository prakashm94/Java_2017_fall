/*
 * AdminWorkAreaJPanel.java
 *
 * Created on October 10, 2008, 8:50 AM
 */
package userinterface.Pharmacy;

import Business.Country.OpioidMedication;
import Business.Country.OpioidMedicationDirectory;
import Business.Pharmacy.Pharmacy;
import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Hospital.Perscription;
import Business.Network.NetworkCountry;
import Business.Network.NetworkState;
import Business.Organization.HospitalOrganization;
import Business.Organization.Organization;
import static Business.Organization.Organization.Type.PharmacyOrganization;
import Business.Organization.PharmacyOrganization;
import Business.Organization.ProviderOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.DoctorWorkRequest;
import Business.WorkQueue.PharmacyWorkRequest;
import Business.WorkQueue.PrescriptionWorkRequest;
import Business.WorkQueue.WorkQueue;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.SendFailedException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import utility.Validator;

/**
 *
 * @author sonal
 */
public class PharmacyAdminWorkAreaJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    UserAccount account;
    PharmacyOrganization organization;
    Enterprise enterprise;
    EcoSystem business;
    NetworkCountry cNetwork;
    NetworkState sNetwork;

    /**
     * Creates new form AdminWorkAreaJPanel
     */
    public PharmacyAdminWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, PharmacyOrganization organization, Enterprise enterprise, EcoSystem business, NetworkCountry cNetwork, NetworkState sNetwork) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.account = account;
        this.business = business;
        this.organization = organization;
        this.sNetwork = sNetwork;
        this.cNetwork = cNetwork;
        populateCombo();
        populateQuantity();
        populateWorkQueueTable();
        populateAvailable();
        populateProvider();
        populateRequestTable();

    }

    public void populateCombo() {
        for (OpioidMedication m : cNetwork.getOpioidList().getOpioidList()) {

            opioidConboBox.addItem(m);

        }
    }

    public void populateProvider() {
        for (Enterprise p : sNetwork.getEnterpriseDirectory().getEnterpriseList()) {
            for (Organization og : p.getOrganizationDirectory().getOrganizationList()) {
                if (og instanceof ProviderOrganization) {
                    comboProvider.addItem(og);
                }
            }

        }
    }

    public void populateWorkQueueTable() {
        DefaultTableModel model = (DefaultTableModel) requestTable.getModel();

        model.setRowCount(0);

        for (WorkRequest work : organization.getWorkQueue().getWorkRequestList()) {
            if (work instanceof PrescriptionWorkRequest) {
                Object[] row = new Object[6];
                row[0] = ((PrescriptionWorkRequest) work).getStatus();
                row[1] = ((PrescriptionWorkRequest) work).getSender();
                row[2] = work;
                row[3] = work.getReceiver();
                row[4] = ((PrescriptionWorkRequest) work).getPerscription().getOpioidName();
                row[5] = ((PrescriptionWorkRequest) work).getPerscription().getQuantity();
                model.addRow(row);
            }
        }
    }

    public void populateAvailable() {
        DefaultTableModel model = (DefaultTableModel) availableTable.getModel();

        model.setRowCount(0);
        //Pharmacy p= organization.getP();
        for (OpioidMedication op : organization.getOpioididr().getOpioidList()) {

            Object[] row = new Object[2];
            row[0] = op.getOpioidName();
            row[1] = op.getQuantity();
            model.addRow(row);

        }
    }

    public void populateQuantity() {

        for (WorkRequest workRequest : account.getWorkQueue().getWorkRequestList()) {
            // HashMap<WorkRequest,Integer> map = new HashMap<WorkRequest,Integer>();
            int temp = 0;
            PharmacyWorkRequest p = (PharmacyWorkRequest) workRequest;
            if (workRequest.getStatus().equals("Complete") && !p.isAdd()) { //&& add == false
                OpioidMedication v = p.getOpioidMed();
                if (organization.getOpioididr() == null) {
                    organization.setOpioididr(new OpioidMedicationDirectory());
                }
                for (OpioidMedication vaccine : organization.getOpioididr().getOpioidList()) {
                    if (v.getOpioidName().equals(vaccine.getOpioidName())) {
                        temp = 1;
                        vaccine.setQuantity(p.getQuantity() + vaccine.getQuantity());
                    }

                }
                if (temp == 0) {
                    OpioidMedication vac = organization.getOpioididr().addDisease();
                    vac.setOpioidName(v.getOpioidName());
                    vac.setQuantity(p.getQuantity());
                }
                p.setAdd(true);
            }
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
        reqBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        availableTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        requestTable = new javax.swing.JTable();
        txtquant = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        btnDelete1 = new javax.swing.JButton();
        reqBtn1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        comboProvider = new javax.swing.JComboBox();
        opioidConboBox = new javax.swing.JComboBox();
        jScrollPane4 = new javax.swing.JScrollPane();
        requestTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        jLabel1.setText("Pharmacy Work Area");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, -1, -1));

        reqBtn.setBackground(new java.awt.Color(36, 47, 65));
        reqBtn.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        reqBtn.setForeground(new java.awt.Color(255, 255, 255));
        reqBtn.setText("Request Opioid");
        reqBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reqBtnActionPerformed(evt);
            }
        });
        add(reqBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 600, 170, 50));

        availableTable.setBackground(new java.awt.Color(36, 47, 65));
        availableTable.setForeground(new java.awt.Color(255, 255, 255));
        availableTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Opioid Name", "Quantity"
            }
        ));
        jScrollPane1.setViewportView(availableTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 320, -1, 90));

        jLabel4.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel4.setText("Opioid Medication Requested");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 240, 30));

        jLabel5.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel5.setText("Available Opioids");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 280, 150, 30));

        requestTable.setBackground(new java.awt.Color(36, 47, 65));
        requestTable.setForeground(new java.awt.Color(255, 255, 255));
        requestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Status", "Sender", "Status", "Receiver", "Opioid Name", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(requestTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, -1, 90));

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
        add(txtquant, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 490, 170, -1));

        jLabel2.setBackground(new java.awt.Color(36, 47, 65));
        jLabel2.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel2.setText("Select Provider :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 540, 120, 20));

        backJButton.setBackground(new java.awt.Color(36, 47, 65));
        backJButton.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        backJButton.setForeground(new java.awt.Color(255, 255, 255));
        backJButton.setText("Refresh");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 650, 130, 40));

        btnDelete1.setBackground(new java.awt.Color(36, 47, 65));
        btnDelete1.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        btnDelete1.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete1.setText("Delete request");
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
            }
        });
        add(btnDelete1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, -1, 50));

        reqBtn1.setBackground(new java.awt.Color(36, 47, 65));
        reqBtn1.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        reqBtn1.setForeground(new java.awt.Color(255, 255, 255));
        reqBtn1.setText("Assign To Me");
        reqBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reqBtn1ActionPerformed(evt);
            }
        });
        add(reqBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 440, 120, 50));

        jLabel3.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel3.setText("Opioid Name:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 440, 90, 20));

        add(comboProvider, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 540, 160, -1));

        add(opioidConboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 440, 170, -1));

        requestTable2.setBackground(new java.awt.Color(36, 47, 65));
        requestTable2.setForeground(new java.awt.Color(255, 255, 255));
        requestTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Doctor Name", "Date", "Status", "Patient Name"
            }
        ));
        jScrollPane4.setViewportView(requestTable2);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 530, -1, 100));

        jButton1.setBackground(new java.awt.Color(36, 47, 65));
        jButton1.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Complete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 440, 120, 50));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utility/tablets_capsules_multi-colored_drug_48978_1920x1080.jpg"))); // NOI18N
        jLabel6.setText("jLabel3");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 2500, 250));

        jLabel7.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel7.setText("Amount:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 490, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void reqBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reqBtnActionPerformed

        if (comboProvider.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "There is no provider available!");
        } else {
            if (txtquant.getText().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Please enter quantity", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    String flag = "false";

                    OpioidMedication o = ((OpioidMedication) opioidConboBox.getSelectedItem());
                    for (WorkRequest work : organization.getWorkQueue().getWorkRequestList()) {
                        if (work instanceof PrescriptionWorkRequest) {
                            if (work.getPerscription().getOpioidName().equalsIgnoreCase(o.getOpioidName())) {
                                flag = "true";
                            }
                        }
                    }
                    if (flag == "true") {
                        PharmacyWorkRequest request = new PharmacyWorkRequest();
                        request.setOpioidMed((OpioidMedication) opioidConboBox.getSelectedItem());
                        request.setRequestQuantity(Integer.parseInt(txtquant.getText()));
                        request.setStatus("Requested");

                        request.setSender(account);
                        organization.getWorkQueue().getWorkRequestList().add(request);
                        account.getWorkQueue().getWorkRequestList().add(request);
                        business.getWorkQueue().getWorkRequestList().add(request);

                        populateRequestTable();
                    } else {
                        JOptionPane.showMessageDialog(null, "Selected opioid is not in a request queue", "Warning", JOptionPane.WARNING_MESSAGE);
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Please enter quantity in integer", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        }

    }//GEN-LAST:event_reqBtnActionPerformed

    public void populateRequestTable() {
        DefaultTableModel model = (DefaultTableModel) requestTable2.getModel();

        model.setRowCount(0);
        if (account.getWorkQueue() == null) {
            account.setWorkQueue(new WorkQueue());
        }
        for (WorkRequest work : account.getWorkQueue().getWorkRequestList()) {
            System.out.println("madhu is waste");
            if (work instanceof PharmacyWorkRequest) {
                System.out.println("userinter");
                Object[] row = new Object[4];
                row[0] = ((PharmacyWorkRequest) work).getSender();
                row[1] = ((PharmacyWorkRequest) work).getRequestDate();
                row[2] = work;
                row[3] = ((PharmacyWorkRequest) work).getRequestQuantity();
                model.addRow(row);
            }
        }
    }
    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        new PharmacyAdminWorkAreaJPanel(userProcessContainer, account, organization, enterprise, business, cNetwork, sNetwork);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void txtquantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtquantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtquantActionPerformed

    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed
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
    }//GEN-LAST:event_btnDelete1ActionPerformed

    private void reqBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reqBtn1ActionPerformed
        int selectedRow = requestTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select the row to assign the account", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            PrescriptionWorkRequest p = (PrescriptionWorkRequest) requestTable.getValueAt(selectedRow, 2);
            if (p.getStatus().equalsIgnoreCase("Requested")) {
                p.setStatus("Pending");
                p.setReceiver(account);

                populateWorkQueueTable();
            } else {
                JOptionPane.showMessageDialog(null, "You can not assign twice to the same account");
            }
        }
    }//GEN-LAST:event_reqBtn1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        if (organization.getOpioididr().getOpioidList().isEmpty()) {
            JOptionPane.showMessageDialog(null, "You have no opioids available! Please request from provider");
        } else {

            int selected = requestTable.getSelectedRow();
            if (selected < 0) {
                JOptionPane.showMessageDialog(null, "Please select a row");
                return;
            }
            PrescriptionWorkRequest p1 = (PrescriptionWorkRequest) requestTable.getValueAt(selected, 2);
            if (p1.getStatus().equalsIgnoreCase("Completed")) {
                JOptionPane.showMessageDialog(null, "Cannot complete reuqest again");
                System.out.println("p1.getEmail()");

                return;
            }
            if (p1.getReceiver() == null) {
                JOptionPane.showMessageDialog(null, "Please assign before completing!");
                return;
            }

            for (OpioidMedication om : organization.getOpioididr().getOpioidList()) {
                if (p1.getPerscription().getOpioidName().equals(om.getOpioidName())) {
                    if (p1.getPerscription().getQuantity() > om.getQuantity()) {
                        JOptionPane.showMessageDialog(null, "Not enough units of this medication is left");
                        return;
                    }
                }

            }

            if (account.getUsername().equalsIgnoreCase(p1.getReceiver().getUsername())) {
                if (p1.getStatus().equals("Pending")) {
                    p1.setStatus("Completed");
                    p1.setSender(account);

                    for (OpioidMedication om : organization.getOpioididr().getOpioidList()) {
                        if (p1.getPerscription().getOpioidName().equals(om.getOpioidName())) {
                            om.setQuantity(om.getQuantity() - p1.getPerscription().getQuantity());
                        }
                    }
                    System.out.println(p1.getEmail() + "    p1.getEmail()");
                    try {
                        Validator.sendMessage(p1.getEmail());
                        Validator.senMessage(p1.getContact());
                    } catch (SendFailedException ex) {
                        Logger.getLogger(PharmacyAdminWorkAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    JOptionPane.showMessageDialog(null, "Request successfully sent");
                }
            }
        }

        populateWorkQueueTable();
        populateAvailable();
//
// for (Enterprise p : sNetwork.getEnterpriseDirectory().getEnterpriseList()) {
//            for (Organization og : p.getOrganizationDirectory().getOrganizationList()) {
//                if (og instanceof PharmacyOrganization) {
//                        og.getWorkQueue().getWorkRequestList().add(prequest);
//                    
//                }
//            }
// }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtquantKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtquantKeyPressed
        // TODO add your handling code here:
        Validator.onlyInteger(evt, txtquant);
    }//GEN-LAST:event_txtquantKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable availableTable;
    private javax.swing.JButton backJButton;
    private javax.swing.JButton btnDelete1;
    private javax.swing.JComboBox comboProvider;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JComboBox opioidConboBox;
    private javax.swing.JButton reqBtn;
    private javax.swing.JButton reqBtn1;
    private javax.swing.JTable requestTable;
    private javax.swing.JTable requestTable2;
    private javax.swing.JTextField txtquant;
    // End of variables declaration//GEN-END:variables

}
