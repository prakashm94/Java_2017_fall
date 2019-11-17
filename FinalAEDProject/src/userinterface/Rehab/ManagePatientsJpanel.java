/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Rehab;

import Business.EcoSystem;
import Business.Network.NetworkCountry;
import Business.Network.NetworkState;
import Business.Organization.HospitalOrganization;
import Business.Organization.Organization;
import static Business.Organization.Organization.Type.RehabOrganization;
import Business.Organization.RehabOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.DoctorWorkRequest;
import Business.WorkQueue.PrescriptionWorkRequest;
import Business.WorkQueue.WorkQueue;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sonal
 */
public class ManagePatientsJpanel extends javax.swing.JPanel {
    JPanel userProcessContainer;
  RehabOrganization organization;
    EcoSystem business;
    UserAccount account;
    /**
     * Creates new form ManagePatientsJpanel
     */
        public ManagePatientsJpanel(JPanel userProcessContainer, EcoSystem business, RehabOrganization organization, UserAccount account, NetworkCountry cNetwork,NetworkState sNetwork) {
        initComponents();
         this.business=business;
        this.userProcessContainer=userProcessContainer;
       this.organization=organization;
        this.account=account;
        populateWorkQueueTable();
    }
        
        public void populateWorkQueueTable(){
         DefaultTableModel model = (DefaultTableModel) requestTable1.getModel();
        
        model.setRowCount(0);
         
        for (WorkRequest work : organization.getWorkQueue().getWorkRequestList()){
           if(work instanceof PrescriptionWorkRequest){ 
            Object[] row = new Object[5];
            row[0] = ((PrescriptionWorkRequest) work).getPatient().getPatientName();
            row[1] = ((PrescriptionWorkRequest) work).getRequestDate();
            row[2] = work;
            row[3] = work.getReceiver();
            row[4] = ((PrescriptionWorkRequest) work).getPatient().getUniquePatientId();
            model.addRow(row);
           }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnComplete = new javax.swing.JButton();
        reqBtn = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        requestTable1 = new javax.swing.JTable();
        backJButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnComplete.setBackground(new java.awt.Color(36, 47, 65));
        btnComplete.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        btnComplete.setForeground(new java.awt.Color(255, 255, 255));
        btnComplete.setText("Complete");
        btnComplete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompleteActionPerformed(evt);
            }
        });
        add(btnComplete, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 430, 140, 50));

        reqBtn.setBackground(new java.awt.Color(36, 47, 65));
        reqBtn.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        reqBtn.setForeground(new java.awt.Color(255, 255, 255));
        reqBtn.setText("Assign To Me");
        reqBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reqBtnActionPerformed(evt);
            }
        });
        add(reqBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 430, 120, 50));

        btnDelete.setBackground(new java.awt.Color(36, 47, 65));
        btnDelete.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete request");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, -1, 50));

        jLabel2.setFont(new java.awt.Font("Dubai Medium", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Rehab Requests");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel3.setText("Patients sent by Doctors");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, -1, -1));

        requestTable1.setBackground(new java.awt.Color(36, 47, 65));
        requestTable1.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        requestTable1.setForeground(new java.awt.Color(255, 255, 255));
        requestTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Doctor Name", "Date", "Status", "Receiver", "Patient Name"
            }
        ));
        jScrollPane4.setViewportView(requestTable1);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 500, 90));

        backJButton.setBackground(new java.awt.Color(36, 47, 65));
        backJButton.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        backJButton.setForeground(new java.awt.Color(255, 255, 255));
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utility/ekg.jpeg"))); // NOI18N
        jLabel6.setText("jLabel3");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 2500, 250));
    }// </editor-fold>//GEN-END:initComponents

    private void btnCompleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompleteActionPerformed
        // TODO add your handling code here:
        
        int selected = requestTable1.getSelectedRow();
        if(selected<0)
            JOptionPane.showMessageDialog(null,"Please select a row");
        else
        {
        PrescriptionWorkRequest p1 = (PrescriptionWorkRequest) requestTable1.getValueAt(selected, 2);
        if(p1.getStatus().equalsIgnoreCase("Completed")){
            JOptionPane.showMessageDialog(null,"Cannot complete again");
            return;
        }
        if(p1.getReceiver()==null)
        {
            JOptionPane.showMessageDialog(null, "Please assign before completing!");
            return;
        }
        
              if (p1.getStatus().equals("Pending")) {
    p1.setStatus("Completed");
    p1.setSender(account);
        }
        
        }
        
  populateWorkQueueTable();

    }//GEN-LAST:event_btnCompleteActionPerformed

    private void reqBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reqBtnActionPerformed
    int selectedRow= requestTable1.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Please select the row to assign the account", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        else{

            PrescriptionWorkRequest p=(PrescriptionWorkRequest) requestTable1.getValueAt(selectedRow, 2);
            if(p.getStatus().equalsIgnoreCase("Requested")){
                p.setStatus("Pending");
                p.setReceiver(account);
                
                populateWorkQueueTable();
            }else{
                JOptionPane.showMessageDialog(null, "You can not assign twice samethingt", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
        
    }//GEN-LAST:event_reqBtnActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JButton btnComplete;
    private javax.swing.JButton btnDelete;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton reqBtn;
    private javax.swing.JTable requestTable1;
    // End of variables declaration//GEN-END:variables
}