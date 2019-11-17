/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.RehabEnterprise;


import userinterface.PharmacyEnterprise.*;
import Business.Hospital.Doctor;
import Business.Pharmacy.Pharmacy;
import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.Organization.Type;
import static Business.Organization.Organization.Type.PharmacyOrganization;
import static Business.Organization.Organization.Type.RehabOrganization;
import Business.Organization.PharmacyOrganization;
import Business.Organization.ProviderOrganization;
import Business.Organization.RehabOrganization;
import Business.Organization.SupplierOrganization;
import Business.Role.PharmacyOrganizationRole;
import Business.Role.ProviderRole;
import Business.Role.RehabManagerRole;
import Business.Role.Role;
import Business.Role.SupplierRole;
import Business.Supplier.Provider;
import Business.Supplier.Supplier;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Vignesh Murali
 */
public class RehabManageUserAccountJPanel extends javax.swing.JPanel {
private JPanel userProcessContainer; 
private Enterprise enterprise;
    /**
     * Creates new form PharmacyManageUserAccountJPanel
     */
   

    RehabManageUserAccountJPanel(JPanel userProcessContainer, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.enterprise=enterprise;
        
         popOrganizationComboBox();
       // employeeJComboBox.removeAllItems();
        popData();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        createUserJButton = new javax.swing.JButton();
        nameJTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userJTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        employeeJComboBox = new javax.swing.JComboBox();
        backjButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        organizationJComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        roleJComboBox = new javax.swing.JComboBox();
        passwordJTextField = new javax.swing.JPasswordField();
        deleteBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        createUserJButton.setBackground(new java.awt.Color(36, 47, 65));
        createUserJButton.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        createUserJButton.setForeground(new java.awt.Color(255, 255, 255));
        createUserJButton.setText("Create");
        createUserJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserJButtonActionPerformed(evt);
            }
        });
        add(createUserJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 670, 140, 30));

        nameJTextField.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        add(nameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 585, 146, -1));

        jLabel1.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel1.setText("User Name");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 585, -1, -1));

        userJTable.setBackground(new java.awt.Color(36, 47, 65));
        userJTable.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        userJTable.setForeground(new java.awt.Color(255, 255, 255));
        userJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Name", "Role"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(userJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, 375, 179));

        jLabel2.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel2.setText("Password");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 625, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel3.setText("Employee");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 515, -1, -1));

        employeeJComboBox.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        add(employeeJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 515, 146, -1));

        backjButton1.setBackground(new java.awt.Color(36, 47, 65));
        backjButton1.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        backjButton1.setForeground(new java.awt.Color(255, 255, 255));
        backjButton1.setText("<< Back");
        backjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButton1ActionPerformed(evt);
            }
        });
        add(backjButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 285, 112, -1));

        jLabel5.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Manage Rehab Enterprise User Account ");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, -1, -1));

        organizationJComboBox.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        organizationJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationJComboBoxActionPerformed(evt);
            }
        });
        add(organizationJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 475, 146, -1));

        jLabel4.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel4.setText("Role");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 555, -1, -1));

        roleJComboBox.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        roleJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleJComboBoxActionPerformed(evt);
            }
        });
        add(roleJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 555, 146, -1));

        passwordJTextField.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        passwordJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordJTextFieldActionPerformed(evt);
            }
        });
        add(passwordJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 620, 150, -1));

        deleteBtn.setBackground(new java.awt.Color(36, 47, 65));
        deleteBtn.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        deleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteBtn.setText("Delete Account");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });
        add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 670, 190, -1));

        updateBtn.setBackground(new java.awt.Color(36, 47, 65));
        updateBtn.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        updateBtn.setForeground(new java.awt.Color(255, 255, 255));
        updateBtn.setText("Update Account");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });
        add(updateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 670, 220, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utility/social-network-media-data-ss-1920.jpg"))); // NOI18N
        jLabel6.setText("jLabel3");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 2500, 250));

        jLabel7.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel7.setText("Organization");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 480, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void createUserJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserJButtonActionPerformed
        String userName = nameJTextField.getText();
        String password = passwordJTextField.getText();
        
        if(userName.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please enter a username");
            return;
        }
        
         if(password.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please enter a username");
            return;
        }
         
        if(organizationJComboBox.getSelectedItem()==null)
        {
             JOptionPane.showMessageDialog(null, "No Organization available");
            return;
            
        }
        
         if(employeeJComboBox.getSelectedItem()==null)
        {
             JOptionPane.showMessageDialog(null, "No employee available");
            return;
            
        }
        
         
                if(roleJComboBox.getSelectedItem()==null)
        {
             JOptionPane.showMessageDialog(null, "No role available");
            return;
            
        }
        
        if(EcoSystem.checkIfUsernameIsUnique(userName)){
            Organization organization = (Organization) organizationJComboBox.getSelectedItem();
            Employee employee = (Employee) employeeJComboBox.getSelectedItem();
            Role role = (Role) roleJComboBox.getSelectedItem();
            //        if (role instanceof SupplierRole){
                //        Supplier organizations = new Supplier();
                //        //enterprise.getOrganizationDirectory().createOrganization(Type.Sup);
                //         organizations.getUserAccountDirectory().createUserAccount(userName, password, employee, role);
                //        }
            //        else{
                //           Provider  organizations = new Provider();
                //            organizations.getUserAccountDirectory().createUserAccount(userName, password, employee, role);
                //
                //        }
//            if (organization instanceof SupplierOrganization){
//                Supplier s= new Supplier();
//
//                s.setSupplierName(employee.getName());
//                ((SupplierOrganization) organization).getSupplierList().getSupplierList().add(s);
//
//            }
            if (organization instanceof PharmacyOrganization){
                Pharmacy p= new Pharmacy();

                p.setPharmacyName(employee.getName());

                ((PharmacyOrganization) organization).getPharmacyList().getPharmaList().add(p);

            }
            organization.getUserAccountDirectory().createUserAccount(userName, password, employee, role);
            popData();
        }
        else{
            JOptionPane.showMessageDialog(null, "Please enter unique username", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_createUserJButtonActionPerformed
 public void popOrganizationComboBox() {
        organizationJComboBox.removeAllItems();

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            organizationJComboBox.addItem(organization);
        }
    }
    
    public void populateEmployeeComboBox(Organization organization){
        employeeJComboBox.removeAllItems();
        
        for (Employee employee : organization.getEmployeeDirectory().getEmployeeList()){
            employeeJComboBox.addItem(employee);
        }
    }
    
    private void populateRoleComboBox(Enterprise e){
        roleJComboBox.removeAllItems();
        Organization organization = (Organization) organizationJComboBox.getSelectedItem();
        if(organization instanceof RehabOrganization){
       // for (Role role : e.getSupportedRole()){
            roleJComboBox.addItem(new RehabManagerRole());
        }
        
       // }
    }

    public void popData() {

        DefaultTableModel model = (DefaultTableModel) userJTable.getModel();

        model.setRowCount(0);

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            for (UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()) {
                Object row[] = new Object[2];
                row[0] = ua;
                row[1] = ua.getRole();
                ((DefaultTableModel) userJTable.getModel()).addRow(row);
            }
        }
    }

    private void backjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backjButton1ActionPerformed

    private void organizationJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationJComboBoxActionPerformed
        Organization organization = (Organization) organizationJComboBox.getSelectedItem();
        if (organization != null){
            populateEmployeeComboBox(organization);
            populateRoleComboBox(enterprise);
        }
    }//GEN-LAST:event_organizationJComboBoxActionPerformed

    private void passwordJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordJTextFieldActionPerformed

    private void roleJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roleJComboBoxActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:

        int selectedRow = userJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select the UserAccount to delete", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            UserAccount a = (UserAccount)userJTable.getValueAt(selectedRow, 0);
            Organization organization = (Organization) organizationJComboBox.getSelectedItem();
            organization.getUserAccountDirectory().removeAccount(a);
            JOptionPane.showMessageDialog(null,"Successfully deleted account");
            popData();
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:

        int selectedRow = userJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select the UserAccount to update", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            updateUserAccountJPanel manageOrganizationJPanel = new updateUserAccountJPanel(userProcessContainer, enterprise,(UserAccount)userJTable.getValueAt(selectedRow, 0));
            userProcessContainer.add("HospitalManageOrganizationJPanel", manageOrganizationJPanel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
    }//GEN-LAST:event_updateBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjButton1;
    private javax.swing.JButton createUserJButton;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JComboBox employeeJComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JComboBox organizationJComboBox;
    private javax.swing.JPasswordField passwordJTextField;
    private javax.swing.JComboBox roleJComboBox;
    private javax.swing.JButton updateBtn;
    private javax.swing.JTable userJTable;
    // End of variables declaration//GEN-END:variables
}
