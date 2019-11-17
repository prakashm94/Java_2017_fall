/*
 * AdminWorkAreaJPanel.java
 *
 * Created on October 10, 2008, 8:50 AM
 */

package userinterface.Hospital.HosOrganization;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.NetworkCountry;
import Business.Organization.HospitalOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author  sonal
 */
public class HospitalOrganizationAdminWorkAreaJPanel extends javax.swing.JPanel {
    
    JPanel userProcessContainer;
    UserAccount account; 
    HospitalOrganization organization; 
    Enterprise enterprise; 
    EcoSystem business;
    NetworkCountry cNetwork;
    /** Creates new form AdminWorkAreaJPanel */
    public HospitalOrganizationAdminWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, HospitalOrganization organization, Enterprise enterprise,NetworkCountry cNetwork, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.account=account;
        this.business=business;
        this.organization= organization;
        this.cNetwork = cNetwork;
        valueLabel.setText(enterprise.getName());
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        userJButton = new javax.swing.JButton();
        manageEmployeeJButton = new javax.swing.JButton();
        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        userJButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        jLabel1.setText("Hospital Organization Admin Work Area ");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 70, 440, -1));

        userJButton.setBackground(new java.awt.Color(36, 47, 65));
        userJButton.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        userJButton.setForeground(new java.awt.Color(255, 255, 255));
        userJButton.setText("Manage Employee User Account");
        userJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userJButtonActionPerformed(evt);
            }
        });
        add(userJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 310, 320, 80));

        manageEmployeeJButton.setBackground(new java.awt.Color(36, 47, 65));
        manageEmployeeJButton.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        manageEmployeeJButton.setForeground(new java.awt.Color(255, 255, 255));
        manageEmployeeJButton.setText("Manage Employee");
        manageEmployeeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageEmployeeJButtonActionPerformed(evt);
            }
        });
        add(manageEmployeeJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 210, 320, 80));

        enterpriseLabel.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        enterpriseLabel.setText("Enterprise :");
        add(enterpriseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 150, 120, 30));

        valueLabel.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 160, 130, 20));

        jButton1.setBackground(new java.awt.Color(36, 47, 65));
        jButton1.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("View Doctors Stats");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 410, 320, 80));

        jButton2.setBackground(new java.awt.Color(36, 47, 65));
        jButton2.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Add Physical Therapy Conditions");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 410, 320, 80));

        jButton3.setBackground(new java.awt.Color(36, 47, 65));
        jButton3.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Manage Patients");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 210, 320, 80));

        userJButton1.setBackground(new java.awt.Color(36, 47, 65));
        userJButton1.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        userJButton1.setForeground(new java.awt.Color(255, 255, 255));
        userJButton1.setText("Manage Patient User Account");
        userJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userJButton1ActionPerformed(evt);
            }
        });
        add(userJButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 310, 320, 80));

        jLabel6.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utility/787423_1.jpg"))); // NOI18N
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -140, 3000, 1500));
    }// </editor-fold>//GEN-END:initComponents

    private void userJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userJButtonActionPerformed
        // TODO add your handling code here:
        HospitalOrganizationManageUserAccountJPanel muajp = new HospitalOrganizationManageUserAccountJPanel( userProcessContainer,  account,  organization,  enterprise,  business);
        userProcessContainer.add("ClinicManageUserAccountJPanel", muajp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_userJButtonActionPerformed

    private void manageEmployeeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageEmployeeJButtonActionPerformed

        HospitalOrganizationManageEmployeeJPanel manageEmployeeJPanel = new HospitalOrganizationManageEmployeeJPanel(userProcessContainer,  account,  organization,  enterprise,  business);
        userProcessContainer.add("ClinicManageEmployeeJPanel", manageEmployeeJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_manageEmployeeJButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
       
        AddPTConditionsJPanel addPTConditionsJPanel = new AddPTConditionsJPanel(userProcessContainer,  account,  organization,  enterprise,  business);
        userProcessContainer.add("ClinicManageEmployeeJPanel", addPTConditionsJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        HospitalOrganizationManagePatientsJPanel hospitalOrganizationManagePatientsJPanel = new HospitalOrganizationManagePatientsJPanel(userProcessContainer,  account,  organization,  enterprise, cNetwork, business);
        userProcessContainer.add("ClinicManageEmployeeJPanel", hospitalOrganizationManagePatientsJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void userJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userJButton1ActionPerformed
        // TODO add your handling code here:
        HospitalOrganizationUserAccountForPatient hospitalOrganizationUserAccountForPatient = new HospitalOrganizationUserAccountForPatient( userProcessContainer,  account,  organization,  enterprise,  business);
        userProcessContainer.add("ClinicManageUserAccountJPanel", hospitalOrganizationUserAccountForPatient);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_userJButton1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ViewDocStatisticsJPanel hospitalOrganizationDocStats= new ViewDocStatisticsJPanel( userProcessContainer,  account,  organization,  enterprise,  business);
        userProcessContainer.add("ClinicManageDocStatsJPanel", hospitalOrganizationDocStats);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton manageEmployeeJButton;
    private javax.swing.JButton userJButton;
    private javax.swing.JButton userJButton1;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
    
}
