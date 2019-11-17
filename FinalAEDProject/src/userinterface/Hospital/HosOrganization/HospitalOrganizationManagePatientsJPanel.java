/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Hospital.HosOrganization;

import Business.Country.Person;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Hospital.Patient;
import Business.Hospital.Perscription;
import Business.Hospital.Report;
import Business.Hospital.ReportDirectory;
import Business.Network.NetworkCountry;
import Business.Network.NetworkState;
import Business.Organization.HospitalOrganization;
import Business.Organization.Organization;
import Business.Role.PatientRole;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.PharmacyWorkRequest;
import java.awt.CardLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import utility.Validator;

/**
 *
 * @author sonal
 */
public class HospitalOrganizationManagePatientsJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    UserAccount account;
    HospitalOrganization organization;
    Enterprise enterprise;
    EcoSystem business;
    NetworkCountry cNetwork;

    /**
     * Creates new form HospitalOrganizationManagePatientsJPanel
     */
    public HospitalOrganizationManagePatientsJPanel(JPanel userProcessContainer, UserAccount account, HospitalOrganization organization, Enterprise enterprise, NetworkCountry cNetwork, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.account = account;
        this.business = business;
        this.organization = organization;
        this.cNetwork = cNetwork;
        populateTable(organization);
    }

    private void populateTable(HospitalOrganization organization) {
        DefaultTableModel model = (DefaultTableModel) organizationJTable.getModel();

        model.setRowCount(0);

        for (Patient p : organization.getHosPatientDir().getPatientList()) {

            Object[] row = new Object[2];
            row[0] = p.getUniquePatientId();
            row[1] = p;

            model.addRow(row);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        organizationJTable = new javax.swing.JTable();
        addJButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        nameJTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        txtpatientid = new javax.swing.JTextField();
        usrErrLbl = new javax.swing.JLabel();
        passErrLbl = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        emailText = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        ContactTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

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
        organizationJTable.setToolTipText("");
        jScrollPane1.setViewportView(organizationJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(372, 321, 480, 92));

        addJButton.setBackground(new java.awt.Color(36, 47, 65));
        addJButton.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        addJButton.setForeground(new java.awt.Color(255, 255, 255));
        addJButton.setText("Create Patient");
        addJButton.setToolTipText("");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });
        add(addJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 734, 190, 60));

        backJButton.setBackground(new java.awt.Color(36, 47, 65));
        backJButton.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        backJButton.setForeground(new java.awt.Color(255, 255, 255));
        backJButton.setText("<< Back");
        backJButton.setToolTipText("");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 281, 90, 50));

        jLabel2.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel2.setText("Name");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(502, 491, 40, -1));

        nameJTextField.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        nameJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameJTextFieldActionPerformed(evt);
            }
        });
        nameJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nameJTextFieldKeyPressed(evt);
            }
        });
        add(nameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 490, 190, -1));

        jLabel4.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Manage Patients in the hospital");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 350, 30));

        jLabel1.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel1.setText("Patient Identification");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(502, 540, -1, -1));

        jComboBox1.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Passportid", "license", "ssn", "license" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(636, 540, 246, -1));

        txtpatientid.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        add(txtpatientid, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 540, 202, -1));

        usrErrLbl.setForeground(new java.awt.Color(255, 51, 51));
        add(usrErrLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(813, 264, -1, -1));

        passErrLbl.setForeground(new java.awt.Color(255, 51, 51));
        add(passErrLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(1107, 313, -1, -1));

        jButton1.setBackground(new java.awt.Color(36, 47, 65));
        jButton1.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Remove Patient");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 380, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel3.setText("Email id:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(502, 583, 116, -1));

        emailText.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        add(emailText, new org.netbeans.lib.awtextra.AbsoluteConstraints(636, 580, 262, -1));

        jLabel6.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel6.setText("Select a Carrier :");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(502, 624, -1, -1));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jRadioButton1.setText("AT&T");
        add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 620, -1, -1));

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jRadioButton2.setText("Verizon");
        add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(709, 620, -1, -1));

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jRadioButton3.setText("Sprint");
        add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 620, -1, -1));

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jRadioButton4.setText("T-Mobile");
        add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(871, 620, -1, -1));

        ContactTextField.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        add(ContactTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 663, 268, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utility/social-network-media-data-ss-1920.jpg"))); // NOI18N
        jLabel7.setText("jLabel3");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 2500, 250));
    }// </editor-fold>//GEN-END:initComponents

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed

        passErrLbl.setText("");
        txtpatientid.setBorder(new LineBorder(Color.black));
        usrErrLbl.setText("");

        nameJTextField.setBorder(new LineBorder(Color.black));
        ArrayList<String> chckID = new ArrayList<>();
        for (Patient p : organization.getHosPatientDir().getPatientList()) {
            chckID.add(p.getUniquePatientId());

        }
        System.out.println(chckID);
        if (chckID.contains(txtpatientid.getText())) {
            passErrLbl.setText("A patient has been registered with this ID number already!");
            txtpatientid.setBorder(new LineBorder(Color.red));
            return;
        }

        if (nameJTextField.getText().equalsIgnoreCase("")) {
            usrErrLbl.setText("Please enter a name.");
            nameJTextField.setBorder(new LineBorder(Color.red));
            return;
        }
        if (txtpatientid.getText().equalsIgnoreCase("")) {
            passErrLbl.setText("Please enter a patient ID.");
            txtpatientid.setBorder(new LineBorder(Color.red));
            return;

        }

        if (emailText.getText().equalsIgnoreCase("")) {
            passErrLbl.setText("Please enter a email ID.");
            emailText.setBorder(new LineBorder(Color.red));
            return;

        }
        if ((jRadioButton1.isSelected() == false) && (jRadioButton2.isSelected() == false)
                && (jRadioButton3.isSelected() == false) && (jRadioButton4.isSelected() == false)) {

            passErrLbl.setText("Please select a caerrier");
            jRadioButton1.setBorder(new LineBorder(Color.red));
            return;
        }

        if ((ContactTextField.getText().equals(""))) {

            passErrLbl.setText("Please enter a contact number");
            ContactTextField.setBorder(new LineBorder(Color.red));
            return;
        }

        

        //ClinicOrganization organization = (HospitalOrganization) organizationEmpJComboBox.getSelectedItem();
        String name = nameJTextField.getText();
        String patientId = txtpatientid.getText();
        String emailId = emailText.getText();
        Patient p = (Patient) organization.getHosPatientDir().addPatient();
        boolean oldPerson = false;
        if (organization.getReportDir() == null) {
            organization.setReportDir(new ReportDirectory());
        }
        String conatct="";
        if (jRadioButton1.isSelected() == true) {
             conatct= ContactTextField.getText() + "@txt.att.net";
            System.out.println("contact)" + conatct);
        } else if (jRadioButton2.isSelected() == true) {
             conatct = ContactTextField.getText() + "@vmobl.com";

        } else if (jRadioButton3.isSelected() == true) {
             conatct = ContactTextField.getText() + "@messaging.sprintpcs.com";

        } else if (jRadioButton4.isSelected() == true) {
             conatct = ContactTextField.getText() + "@tmomail.net";

        }
        Report r = null;
        ArrayList<Perscription> perscList = new ArrayList<Perscription>();

        for (Person per : cNetwork.getPersonDir().getPersonList()) {
            if (per.getPersonId().equals(patientId)) {
                p.setPatientName(per.getPersonName());
                p.setAssociatedPerson(per);
                p.setEmailid(emailId);
                p.setContactNumber(conatct);
                
                System.out.println("conatct" + p.getContactNumber());
                p.setUniquePatientId(per.getPersonId());
                r = organization.getReportDir().addReport();
                r.setPatient(p);
                for (NetworkState ns : cNetwork.getNetworkStateList()) {
                    for (Enterprise e : ns.getEnterpriseDirectory().getEnterpriseList()) {
                        for (Organization or : e.getOrganizationDirectory().getOrganizationList()) {
                            if (or instanceof HospitalOrganization) {
                                if ((HospitalOrganization) or != organization) {
                                    for (Report re : ((HospitalOrganization) or).getReportDir().getReportList()) {
                                        if (re.getPatient().getUniquePatientId().equals(patientId)) {
                                            for (Perscription pers : re.getPerscriptionList()) {
                                                perscList.add(pers);
                                            }
                                            r.setRefillCount(re.getRefillCount());
                                            r.setPtRefillflag(re.isPtRefillflag());
                                            r.setReversalMedCount(re.getReversalMedCount());
                                            r.setPtSuccessFlag(re.isPtSuccessFlag());
                                            r.setFlag(re.isFlag());
                                            r.setHm(re.getHm());
                                            r.setPatient(re.getPatient());
                                            
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                for (Perscription pir : perscList) {
                    r.getPerscriptionList().add(pir);
                }
                oldPerson = true;
                break;
            }
        }
        if (oldPerson == false) {
            Person pNew = cNetwork.getPersonDir().addPerson();
            pNew.setPersonId(txtpatientid.getText());
            pNew.setPersonName(nameJTextField.getText());
            p.setAssociatedPerson(pNew);
            p.setPatientName(nameJTextField.getText());
            p.setUniquePatientId(pNew.getPersonId());
            p.setEmailid(emailId);
            p.setContactNumber(conatct);
            r = organization.getReportDir().addReport();
            r.setPatient(p);

            System.out.println("email" + p.getEmailid());
        }
        JOptionPane.showMessageDialog(null, "Successfully added patient");
        populateTable(organization);


    }//GEN-LAST:event_addJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void nameJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameJTextFieldActionPerformed

    private void nameJTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameJTextFieldKeyPressed
        // TODO add your handling code here:
        Validator.onlyString(evt, nameJTextField);
    }//GEN-LAST:event_nameJTextFieldKeyPressed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int selectedRow = organizationJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select the patient to delete the account", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            Patient p = (Patient) organizationJTable.getValueAt(selectedRow, 1);
            System.out.println(p.getUniquePatientId());
            UserAccount tempu = new UserAccount();
            for (UserAccount u : organization.getUserAccountDirectory().getUserAccountList()) {
                if (u.getPatient() != null) {
                    if (u.getPatient().getUniquePatientId().equalsIgnoreCase(p.getUniquePatientId())) {
                        tempu = u;
                    }
                }
            }
            organization.getUserAccountDirectory().getUserAccountList().remove(tempu);

            organization.getHosPatientDir().getPatientList().remove(p);
            JOptionPane.showMessageDialog(null, "Patient is removed");
            populateTable(organization);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ContactTextField;
    private javax.swing.JButton addJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField emailText;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JTable organizationJTable;
    private javax.swing.JLabel passErrLbl;
    private javax.swing.JTextField txtpatientid;
    private javax.swing.JLabel usrErrLbl;
    // End of variables declaration//GEN-END:variables
}