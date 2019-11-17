/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Doctor;

import Business.Country.OpioidMedication;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import static Business.Enterprise.Enterprise.EnterpriseType.PharmacyEnterprise;
import Business.Enterprise.PharmacyEnterprise;
import Business.Hospital.Doctor;
import Business.Hospital.Patient;
import Business.Hospital.Perscription;
import Business.Hospital.PhysicalTherapy;
import Business.Hospital.Report;
import Business.Network.NetworkCountry;
import Business.Network.NetworkState;
import Business.Organization.HospitalOrganization;
import Business.Organization.Organization;
import Business.Organization.PharmacyOrganization;
import Business.Organization.RehabOrganization;
import Business.Organization.SupplierOrganization;
import Business.Pharmacy.Pharmacy;
import Business.Role.SupplierRole;
import Business.Sytem.Conditions;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.DoctorWorkRequest;
import Business.WorkQueue.PatientWorkRequest;
import Business.WorkQueue.PharmacyWorkRequest;
import Business.WorkQueue.PrescriptionWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import userinterface.Patient.PatientAppointmentJPanel;
import utility.Validator;

/**
 *
 * @author Vignesh Murali
 */
public class addRequestJPanel extends javax.swing.JPanel {

    EcoSystem business;
    HospitalOrganization organization;
    UserAccount account;
    PatientWorkRequest p;
    NetworkCountry cNetwork;
    NetworkState sNetwork;
    Report patientReport = null;
    PharmacyOrganization porganization;
    ArrayList<Perscription> perscriptionArray;
    ArrayList<Perscription> tempPrescpArray;
    JPanel userProcessContainer;
    String patientName;
    int pilldosage;

    /**
     * Creates new form addRequestJPanel
     */
    public addRequestJPanel(EcoSystem business, HospitalOrganization organization, UserAccount account, PatientWorkRequest p, NetworkCountry cNetwork, NetworkState sNetwork, JPanel userProcessContainer) {
        initComponents();
        this.business = business;
        this.organization = organization;
        this.account = account;
        this.sNetwork = sNetwork;
        this.p = p;
        this.cNetwork = cNetwork;
        this.userProcessContainer = userProcessContainer;
        docName.setText(account.getEmployee().getName());
        doctId.setText(p.getDoctor().getDoctorId());
        for (Report r : organization.getReportDir().getReportList()) {
            if (r.getPatient() != null) {
                if (r.getPatient().getUniquePatientId().equals(p.getSender().getPatient().getUniquePatientId())) {
                    patientReport = r;
//                    for (Perscription p1 : r.getPerscriptionList()) {
//                        if (p1.isSenttopharmacy() == false) {
//                            p1.setSenttopharmacy(true);
//                        }
//                    }

                }
            }
        }
        populatecombo();
        populatePtList();
        dosageName.setEditable(false);
        opioidConboBox.setEditable(false);
        pillsPerDay.setEditable(false);
        noOfDays.setEditable(false);
        submitButton.setEnabled(false);
        submitRehabBtn.setEnabled(false);
        jCheckBoxreject.setEnabled(false);
        perscriptionArray = new ArrayList();
        tempPrescpArray = new ArrayList<>();
        submitFollowBtn.setEnabled(false);
        pharmaComboList1.setEnabled(true);
        submitPharmBtn.setEnabled(true);
        rehabComboList.setEnabled(false);
        submitRehabBtn.setEnabled(false);
        populatePrescription();
        populatePharmacy();
        populateRehab();
        patientName = p.getSender().getPatient().getPatientName();
        System.out.println("Patient name is " + patientName);

    }

    public void populatecombo() {
        System.out.println("userinterface.Doctor.addRequestJPanel.populatecombo()" + business.getConditionsList());
        for (Conditions c : business.getConditionsList().getConditionList()) {
            comboConditions.addItem(c);

        }
    }

    public void populatePtList() {
        for (PhysicalTherapy p : organization.getHosPtDir().getPhysicalTherapyList()) {
            ptComboList.addItem(p);

        }
    }

    public void populatePharmacy() {
        for (Enterprise p : sNetwork.getEnterpriseDirectory().getEnterpriseList()) {
            for (Organization og : p.getOrganizationDirectory().getOrganizationList()) {
                if (og instanceof PharmacyOrganization) {
                    pharmaComboList1.addItem(og);
                }
            }

        }
    }

    public void populateRehab() {
        for (Enterprise p : sNetwork.getEnterpriseDirectory().getEnterpriseList()) {
            for (Organization og : p.getOrganizationDirectory().getOrganizationList()) {
                if (og instanceof RehabOrganization) {
                    rehabComboList.addItem(og);
                }
            }

        }
    }

    public void populateOpioidCombo() {
        opioidConboBox.removeAllItems();
        System.out.println(cNetwork.getOpioidList());
        Conditions c = (Conditions) comboConditions.getSelectedItem();
        for (OpioidMedication m : cNetwork.getOpioidList().getOpioidList()) {
            if (m.getConditionList().contains(c)) {
                if (!m.getOpioidName().equals("Reversal")) {
                    opioidConboBox.addItem(m);
                }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboConditions = new javax.swing.JComboBox();
        dosageName = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        doctId = new javax.swing.JTextField();
        docName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        opioidConboBox = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        pillsPerDay = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        noOfDays = new javax.swing.JTextField();
        ptBtn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        ptComboList = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        submitFollowBtn = new javax.swing.JButton();
        submitPharmBtn = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        pharmaComboList1 = new javax.swing.JComboBox();
        submitRehabBtn = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        rehabComboList = new javax.swing.JComboBox();
        jCheckBoxreject = new javax.swing.JCheckBox();
        backJButton = new javax.swing.JButton();
        dosErrLbl = new javax.swing.JLabel();
        pillsErrLbl = new javax.swing.JLabel();
        daysErrLbl = new javax.swing.JLabel();
        dateErrLbl = new javax.swing.JLabel();
        apptDateTxt = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(36, 47, 65));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        jTable1.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Prescription ID", "ConditionName", "OpioidName", "Dosage", "Pills Per Day", "DoctorID", "No of Days", "Quantity"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, 1109, 130));

        jLabel2.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel2.setText("Dosage");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 730, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel3.setText("Opioid Name");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 680, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel4.setText("Condition");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 610, -1, -1));

        comboConditions.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        comboConditions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboConditionsActionPerformed(evt);
            }
        });
        add(comboConditions, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 610, 221, -1));

        dosageName.setEditable(false);
        dosageName.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        dosageName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dosageNameKeyPressed(evt);
            }
        });
        add(dosageName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 730, 201, -1));

        submitButton.setBackground(new java.awt.Color(36, 47, 65));
        submitButton.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        submitButton.setForeground(new java.awt.Color(255, 255, 255));
        submitButton.setText("Submit Prescription");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        add(submitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 830, -1, -1));

        jLabel1.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        jLabel1.setText("Create a prescription");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 240, -1));

        jLabel5.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel5.setText("Doctor Name :");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 107, -1));

        doctId.setEditable(false);
        doctId.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        add(doctId, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 340, 161, -1));

        docName.setEditable(false);
        docName.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        add(docName, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 380, 161, -1));

        jLabel6.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel6.setText("Prescription Details :");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 158, 25));

        opioidConboBox.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        add(opioidConboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 680, 220, -1));

        jLabel7.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel7.setText("Pills Per Day");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 770, -1, -1));

        pillsPerDay.setEditable(false);
        pillsPerDay.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        pillsPerDay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pillsPerDayKeyPressed(evt);
            }
        });
        add(pillsPerDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 760, 201, -1));

        jLabel8.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel8.setText("No of Days");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 800, -1, -1));

        noOfDays.setEditable(false);
        noOfDays.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        noOfDays.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                noOfDaysKeyPressed(evt);
            }
        });
        add(noOfDays, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 790, 201, -1));

        ptBtn.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        ptBtn.setText("Send to Physical Therapy");
        ptBtn.setEnabled(false);
        ptBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ptBtnActionPerformed(evt);
            }
        });
        add(ptBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 650, 187, -1));

        jLabel9.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel9.setText("Select Physical Therapy:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 610, -1, -1));

        ptComboList.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        add(ptComboList, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 610, 190, -1));

        jLabel10.setText("Set Appointment Date");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 890, -1, -1));

        submitFollowBtn.setText("Submit Follow-up Date");
        submitFollowBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitFollowBtnActionPerformed(evt);
            }
        });
        add(submitFollowBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 890, -1, -1));

        submitPharmBtn.setBackground(new java.awt.Color(36, 47, 65));
        submitPharmBtn.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        submitPharmBtn.setForeground(new java.awt.Color(255, 255, 255));
        submitPharmBtn.setText("Send request to pharmacy");
        submitPharmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitPharmBtnActionPerformed(evt);
            }
        });
        add(submitPharmBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 730, 200, -1));

        jLabel11.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel11.setText("Select Pharmacy :");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 690, -1, -1));

        pharmaComboList1.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        add(pharmaComboList1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 690, 196, -1));

        submitRehabBtn.setBackground(new java.awt.Color(36, 47, 65));
        submitRehabBtn.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        submitRehabBtn.setForeground(new java.awt.Color(255, 255, 255));
        submitRehabBtn.setText("Send request to Rehab");
        submitRehabBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitRehabBtnActionPerformed(evt);
            }
        });
        add(submitRehabBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 810, 200, -1));

        jLabel12.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel12.setText("Select Rehab :");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 780, -1, -1));

        rehabComboList.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        add(rehabComboList, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 770, 196, -1));

        jCheckBoxreject.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jCheckBoxreject.setText("Reject Refill");
        jCheckBoxreject.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBoxrejectMouseClicked(evt);
            }
        });
        jCheckBoxreject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxrejectActionPerformed(evt);
            }
        });
        jCheckBoxreject.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCheckBoxrejectKeyPressed(evt);
            }
        });
        add(jCheckBoxreject, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 640, -1, -1));

        backJButton.setBackground(new java.awt.Color(36, 47, 65));
        backJButton.setForeground(new java.awt.Color(255, 255, 255));
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 280, -1, -1));

        dosErrLbl.setForeground(new java.awt.Color(255, 51, 51));
        add(dosErrLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 405, -1, -1));

        pillsErrLbl.setForeground(new java.awt.Color(255, 0, 0));
        add(pillsErrLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 438, -1, -1));

        daysErrLbl.setForeground(new java.awt.Color(255, 0, 51));
        add(daysErrLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 468, -1, -1));

        dateErrLbl.setForeground(new java.awt.Color(255, 51, 51));
        add(dateErrLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(412, 562, -1, -1));
        add(apptDateTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 890, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utility/tablets_capsules_multi-colored_drug_48978_1920x1080.jpg"))); // NOI18N
        jLabel13.setText("jLabel3");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 2500, 250));

        jLabel14.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel14.setText("Doctor ID:");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void comboConditionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboConditionsActionPerformed
        // TODO add your handling code here:

        Conditions c = (Conditions) comboConditions.getSelectedItem();
        System.out.println("usrmed()" + c.getDiseaseName());
        if (c != null) {
            ArrayList<String> Ptlist = new ArrayList<>();
            for (int i = 0; i <= organization.getPtConditions().getConditionList().size() - 1; i++) {
                Ptlist.add(organization.getPtConditions().getConditionList().get(i).getDiseaseName());

            }
            System.out.println("ATTENTION :" + Ptlist);

            if (Ptlist.contains(c.getDiseaseName())) {
                System.out.println("containing");
                if (patientReport.isPtSuccessFlag() == true) {
                    ptBtn.setEnabled(true);
                    dosageName.setEditable(false);
                    opioidConboBox.setEditable(false);
                    pillsPerDay.setEditable(false);
                    noOfDays.setEditable(false);
                    submitButton.setEnabled(false);
                    rehabComboList.setEnabled(false);
                    submitRehabBtn.setEnabled(false);
                } else {

                    if (patientReport.getRefillCount() > 2) {
                        //send this to rehab
                        rehabComboList.setEnabled(true);
                        submitRehabBtn.setEnabled(true);
                    } else {
                        rehabComboList.setEnabled(false);
                        submitRehabBtn.setEnabled(false);
                        if (patientReport.getReversalMedCount() > 2) {
                            rehabComboList.setEnabled(true);
                            submitRehabBtn.setEnabled(true);
                            //send rehab request
                        } else {
                            Date latestDate = null;
                            for (Perscription p : patientReport.getPerscriptionList()) {

                                Date perscDate = p.getFollowUp();

                                Calendar calendar = Calendar.getInstance();
                                calendar.setTime(perscDate);
                                calendar.set(Calendar.HOUR_OF_DAY, 0);
                                calendar.set(Calendar.MINUTE, 0);
                                calendar.set(Calendar.SECOND, 0);
                                calendar.set(Calendar.MILLISECOND, 0);

                                //p.setFollowUp(calendar.getTime());
                                if (latestDate == null && perscDate != null) {
                                    latestDate = perscDate;
                                    pilldosage = p.getOpioidDosage();
                                } else {

                                    if (perscDate.after(latestDate)) {
                                        latestDate = p.getFollowUp();
                                        pilldosage = p.getOpioidDosage();

                                    }
                                }
                            }
                            System.out.println("p." + p.getRequestDate());

                            if (latestDate != null) {
                                if (latestDate.after(p.getRequestDate()) || patientReport.isPtRefillflag() == true) {
                                    jCheckBoxreject.setEnabled(true);
//                                if (jCheckBoxreject.isSelected() == true) {
//                                    dosageName.setEditable(true);
//                                    opioidConboBox.setEditable(true);
//                                    pillsPerDay.setEditable(true);
//                                    noOfDays.setEditable(true);
//                                    submitButton.setEnabled(true);
//                                    submitFollowBtn.setEnabled(true);
//                                    pharmaComboList1.setEnabled(true);
//                                    submitPharmBtn.setEnabled(true);
//                                    opioidConboBox.removeAllItems();
//                                    for (OpioidMedication m : cNetwork.getOpioidList().getOpioidList()) {
//                                        if (m.getOpioidName().equals("Reversal")) {
//                                            opioidConboBox.addItem(m);
//
//                                        }
//                                    }
//                                    int count = patientReport.getReversalMedCount();
//                                    patientReport.setReversalMedCount(count + 1);
//
//                                } else {
//                                    dosageName.setEditable(true);
//                                    opioidConboBox.setEditable(true);
//                                    pillsPerDay.setEditable(true);
//                                    noOfDays.setEditable(true);
//                                    submitButton.setEnabled(true);
//                                    submitFollowBtn.setEnabled(true);
//                                    pharmaComboList1.setEnabled(true);
//                                    submitPharmBtn.setEnabled(true);
//                                    int countR = patientReport.getRefillCount();
//                                    patientReport.setRefillCount(countR + 1);
//                                    populateOpioidCombo();
//                                    int recommendedDosage = pilldosage - 10;
//                                    if (recommendedDosage <= 0) {
//                                        JOptionPane.showMessageDialog(null, "Previous dosage amount was " + pilldosage + " since we cannot perscribe less than 0, we recommend still perscribing dosage less then amount.", "Decereased Dosage", JOptionPane.WARNING_MESSAGE);
//                                    } else {
//                                        JOptionPane.showMessageDialog(null, "Previous dosage amount was " + pilldosage + " We recommend you perscribe " + recommendedDosage + "or less", "Decreased Dosage", JOptionPane.WARNING_MESSAGE);
//                                    }
//                                }
                                } else {
                                    dosageName.setEditable(true);
                                    opioidConboBox.setEditable(true);
                                    pillsPerDay.setEditable(true);
                                    noOfDays.setEditable(true);
                                    submitButton.setEnabled(true);
                                    submitFollowBtn.setEnabled(true);
                                    pharmaComboList1.setEnabled(true);
                                    submitPharmBtn.setEnabled(true);
                                    populateOpioidCombo();

                                }
                            } else {
                                System.out.println("userinterface is enabled");
                                dosageName.setEditable(true);
                                opioidConboBox.setEditable(true);
                                pillsPerDay.setEditable(true);
                                noOfDays.setEditable(true);
                                submitButton.setEnabled(true);
                                submitFollowBtn.setEnabled(true);
                                pharmaComboList1.setEnabled(true);
                                ptBtn.setEnabled(false);
                                ptComboList.setEnabled(false);
                                submitPharmBtn.setEnabled(true);
                                populateOpioidCombo();
                            }
                        }
                    }

                }
            } else {

                ptBtn.setEnabled(false);
                System.out.println("u" + patientReport.getRefillCount());
                if (patientReport.getRefillCount() > 2) {
                    //send this to rehab
                    rehabComboList.setEnabled(true);
                    submitRehabBtn.setEnabled(true);
                } else {
                    submitRehabBtn.setEnabled(false);

                    if (patientReport.getReversalMedCount() > 2) {
                        rehabComboList.setEnabled(true);
                        submitRehabBtn.setEnabled(true);
                        //send rehab request
                    } else {
                        Date latestDate = null;

                        for (Perscription p : patientReport.getPerscriptionList()) {
                            if (p.getFollowUp() != null) {
                                Date perscDate = p.getFollowUp();

                                Calendar calendar = Calendar.getInstance();
                                calendar.setTime(perscDate);
                                calendar.set(Calendar.HOUR_OF_DAY, 0);
                                calendar.set(Calendar.MINUTE, 0);
                                calendar.set(Calendar.SECOND, 0);
                                calendar.set(Calendar.MILLISECOND, 0);

                                //p.setFollowUp(calendar.getTime());
                                if (latestDate == null && perscDate != null) {
                                    latestDate = perscDate;
                                    pilldosage = p.getOpioidDosage();
                                } else {

                                    if (perscDate.after(latestDate)) {
                                        latestDate = p.getFollowUp();
                                        pilldosage = p.getOpioidDosage();

                                    }
                                }
                            }
                        }
                        System.out.println(latestDate + "lastest");
                        if (latestDate != null) {
                            if (latestDate.after(p.getRequestDate()) || patientReport.isPtRefillflag() == true) {
                                System.out.println("1");
                                jCheckBoxreject.setEnabled(true);
                                System.out.println("2");
//                            if (jCheckBoxreject.isSelected() == true) {
//                                System.out.println("3");
//                                dosageName.setEditable(true);
//                                opioidConboBox.setEditable(true);
//                                pillsPerDay.setEditable(true);
//                                noOfDays.setEditable(true);
//                                submitButton.setEnabled(true);
//                                submitFollowBtn.setEnabled(true);
//                                pharmaComboList1.setEnabled(true);
//                                submitPharmBtn.setEnabled(true);
//                                opioidConboBox.removeAllItems();
//                                for (OpioidMedication m : cNetwork.getOpioidList().getOpioidList()) {
//                                    if (m.getOpioidName().equals("Reversal")) {
//                                        opioidConboBox.addItem(m);
//                                    }
//                                }
//                                int count = patientReport.getReversalMedCount();
//                                patientReport.setReversalMedCount(count + 1);
//
//                            } else {
                                dosageName.setEditable(true);
                                opioidConboBox.setEditable(true);
                                pillsPerDay.setEditable(true);
                                noOfDays.setEditable(true);
                                submitButton.setEnabled(true);
                                submitFollowBtn.setEnabled(true);
                                pharmaComboList1.setEnabled(true);
                                submitPharmBtn.setEnabled(true);
                                int countR = patientReport.getRefillCount();
                                patientReport.setRefillCount(countR + 1);
                                populateOpioidCombo();
//                                int recommendedDosage = pilldosage - 10;
//                                if (recommendedDosage <= 0) {
//                                    JOptionPane.showMessageDialog(null, "Previous dosage amount was " + pilldosage + " since we cannot perscribe less than 0, we recommend still perscribing dosage less then amount.", "Decereased Dosage", JOptionPane.WARNING_MESSAGE);
//                                } else {
//                                    JOptionPane.showMessageDialog(null, "Previous dosage amount was " + pilldosage + " We recommend you perscribe " + recommendedDosage + "or less", "Decreased Dosage", JOptionPane.WARNING_MESSAGE);
//                                }
//                            }
                            } else {

                                System.out.println("userinterface is enabled");
                                dosageName.setEditable(true);
                                opioidConboBox.setEditable(true);
                                pillsPerDay.setEditable(true);
                                noOfDays.setEditable(true);
                                submitButton.setEnabled(true);
                                submitFollowBtn.setEnabled(true);
                                pharmaComboList1.setEnabled(true);
                                submitPharmBtn.setEnabled(true);
                                populateOpioidCombo();

                            }
                        } else {
                            System.out.println("userinterface is enabled");
                            dosageName.setEditable(true);
                            opioidConboBox.setEditable(true);
                            pillsPerDay.setEditable(true);
                            noOfDays.setEditable(true);
                            submitButton.setEnabled(true);
                            submitFollowBtn.setEnabled(true);
                            pharmaComboList1.setEnabled(true);
                            submitPharmBtn.setEnabled(true);
                            populateOpioidCombo();
                        }
                    }
                }

            }
        }
    }//GEN-LAST:event_comboConditionsActionPerformed

    private void ptBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ptBtnActionPerformed
        // TODO add your handling code here:

        if (ptComboList.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "No physical therapy unit available!");
        } else {
            Date latestDate = null;
            for (Perscription p : patientReport.getPerscriptionList()) {

                Date perscDate = p.getFollowUp();

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(perscDate);
                calendar.set(Calendar.HOUR_OF_DAY, 0);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);

                //p.setFollowUp(calendar.getTime());
                if (latestDate == null && perscDate != null) {
                    latestDate = perscDate;
                    pilldosage = p.getOpioidDosage();
                } else {

                    if (perscDate.after(latestDate)) {
                        latestDate = p.getFollowUp();
                        pilldosage = p.getOpioidDosage();

                    }
                }
            }
            Conditions c = (Conditions) comboConditions.getSelectedItem();

            PhysicalTherapy pt = (PhysicalTherapy) ptComboList.getSelectedItem();
            DoctorWorkRequest request = new DoctorWorkRequest();
            for (UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()) {
                for (WorkRequest work : ua.getWorkQueue().getWorkRequestList()) {
                    if (work instanceof DoctorWorkRequest) {
                        if (work != null) {
                            if (((DoctorWorkRequest) work).getConditions() != null) {

                                if (work.getStatus().equalsIgnoreCase("Requested")
                                        && ((DoctorWorkRequest) work).getConditions().getDiseaseName().equalsIgnoreCase(c.getDiseaseName())
                                        && ((DoctorWorkRequest) work).getPwr().getSender().getPatient().getUniquePatientId().equalsIgnoreCase(p.getSender().getPatient().getUniquePatientId())) {
                                    work.setStatus("Cancelled");
                                }
                            }
                        }
                    }
                }
            }

            p.setPatientName(patientName);
            request.setPwr(p);
            request.setStatus("Requested");
            request.setSender(account);
            request.setConditions(c);

            if (latestDate != null) {
                if (latestDate.after(p.getRequestDate())) {
                    request.setPatientRefillRequest(true);
                } else {
                    request.setPatientRefillRequest(false);
                }
            } else {
                request.setPatientRefillRequest(false);
            }

            //    request.setReceiver((PhysicalTherapy)ptComboList.getSelectedItem());
            for (UserAccount u : organization.getUserAccountDirectory().getUserAccountList()) {
                if (u.getEmployee() != null) {
                    if (u.getEmployee().getName().equalsIgnoreCase(pt.getPtName())) {
                        System.out.println("request 1");
                        u.getWorkQueue().getWorkRequestList().add(request);

                    }
                }
            }
            account.getWorkQueue().getWorkRequestList().add(request);
            JOptionPane.showMessageDialog(null, "Request sent to physical therapy department");
            System.out.println("request sent to pt");
        }
    }//GEN-LAST:event_ptBtnActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:

        dosErrLbl.setText("");
        dosageName.setBorder(new LineBorder(Color.black));
        pillsErrLbl.setText("");
        pillsPerDay.setBorder(new LineBorder(Color.black));
        daysErrLbl.setText("");
        noOfDays.setBorder(new LineBorder(Color.black));
        if (comboConditions.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "There are no conditions set.");
            return;
        }
        if (opioidConboBox.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Opioids have not been added.");
            return;
        }
        if (dosageName.getText().equals("")) {
            dosErrLbl.setText("Please enter dosage level.");
            dosageName.setBorder(new LineBorder(Color.red));
            return;
        }
        if (pillsPerDay.getText().equals("")) {
            pillsErrLbl.setText("Please pills prescribed per day.");
            pillsPerDay.setBorder(new LineBorder(Color.red));
            return;
        }
        if (noOfDays.getText().equals("")) {
            daysErrLbl.setText("Please enter number of days.");
            noOfDays.setBorder(new LineBorder(Color.red));
            return;
        }

        if (doctId.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill all fields!");
        } else {

            Date latestDate = null;
            for (Perscription pa : patientReport.getPerscriptionList()) {
                if (pa.getFollowUp() != null) {
                    Date perscDate = pa.getFollowUp();

                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(perscDate);
                    calendar.set(Calendar.HOUR_OF_DAY, 0);
                    calendar.set(Calendar.MINUTE, 0);
                    calendar.set(Calendar.SECOND, 0);
                    calendar.set(Calendar.MILLISECOND, 0);

                    //p.setFollowUp(calendar.getTime());
                    if (latestDate == null && perscDate != null) {
                        latestDate = perscDate;
                        pilldosage = pa.getOpioidDosage();
                    } else {

                        if (perscDate.after(latestDate)) {
                            latestDate = pa.getFollowUp();
                            pilldosage = pa.getOpioidDosage();

                        }
                    }
                }
            }
            if (latestDate != null) {
                if (latestDate.after(p.getRequestDate())) {
                    int perscribedAmount = Integer.parseInt(dosageName.getText());
                    if (perscribedAmount > pilldosage) {
                        int vil = p.getDoctor().getViolationCount() + 1;
                        sNetwork.setViolationCount(sNetwork.getViolationCount() + 1);
                        //System.out.println("State Violations are "+sNetwork.getViolationCount());
                        p.getDoctor().setViolationCount(vil);
                    }
                }
            }

            int dosage = Integer.parseInt(dosageName.getText());
            String opioidName = opioidConboBox.getSelectedItem().toString();
            String conditionName = comboConditions.getSelectedItem().toString();
            int pillsperday = Integer.parseInt(pillsPerDay.getText());
            int noofdays = Integer.parseInt(noOfDays.getText());
            String docid = doctId.getText();
            float mmeMulti = 0;
            for (OpioidMedication opi : cNetwork.getOpioidList().getOpioidList()) {
                if (opioidName.equals(opi.getOpioidName())) {
                    mmeMulti = opi.getMmeMultiplier();
                }
            }
            int dialogButton = 0;
            float dosagemme = mmeMulti * dosage;
            if (dosagemme >= 50) {
                //dialogButton  = JOptionPane.showConfirmDialog (null, "Are you sure?","WARNING", dialogButton);
                if (JOptionPane.showConfirmDialog(null, "Dosage you perscribed is above 50 mg after multiplying with MME. Are you sure you you want to perscribe?", "Confirmation",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    if (perscriptionArray != null) {
                        for (Perscription pres : perscriptionArray) {
                            if (pres.getConditionName().equalsIgnoreCase(conditionName)) {
                                JOptionPane.showMessageDialog(null, null, " prescription with selected condition already exists!", JOptionPane.WARNING_MESSAGE);
                                return;
                            }
                        }

                        Perscription pir = new Perscription();

                        pir.setConditionName(conditionName);
                        pir.setOpioidName(opioidName);
                        pir.setOpioidDosage(dosage);
                        pir.setNumberofDays(noofdays);
                        pir.setPillsPerDay(pillsperday);
                        pir.setDoctorId(docid);

                        patientReport.getPerscriptionList().add(pir);

                        patientReport.getHm().put(pir.getOpioidName(), 0);

                        perscriptionArray.add(pir);
                        tempPrescpArray.add(pir);
                        int vil = p.getDoctor().getViolationCount() + 1;
                        sNetwork.setViolationCount(sNetwork.getViolationCount() + 1);
                        //System.out.println("State Violations are "+sNetwork.getViolationCount());
                        p.getDoctor().setViolationCount(vil);
                        JOptionPane.showMessageDialog(null, "Prescription added succesfully!");
                        populatePrescription();
                    } else {
                        Perscription pir = new Perscription();

                        pir.setConditionName(conditionName);
                        pir.setOpioidName(opioidName);
                        pir.setOpioidDosage(dosage);
                        pir.setNumberofDays(noofdays);
                        pir.setPillsPerDay(pillsperday);
                        pir.setDoctorId(docid);

                        patientReport.getPerscriptionList().add(pir);

                        patientReport.getHm().put(pir.getOpioidName(), 0);

                        perscriptionArray.add(pir);
                        int vil = p.getDoctor().getViolationCount() + 1;
                        sNetwork.setViolationCount(sNetwork.getViolationCount() + 1);
                        //System.out.println("State Violations are "+sNetwork.getViolationCount());
                        p.getDoctor().setViolationCount(vil);
                        JOptionPane.showMessageDialog(null, "Prescription added succesfully!");
                        populatePrescription();
                    }
                }
            } else {
                Perscription p = new Perscription();

                p.setConditionName(conditionName);
                p.setOpioidName(opioidName);
                p.setOpioidDosage(dosage);
                p.setNumberofDays(noofdays);
                p.setPillsPerDay(pillsperday);
                p.setDoctorId(docid);
                tempPrescpArray.add(p);
                patientReport.getPerscriptionList().add(p);

                patientReport.getHm().put(p.getOpioidName(), 0);

                perscriptionArray.add(p);

                JOptionPane.showMessageDialog(null, "Prescription added succesfully!");
                populatePrescription();
            }

        }


    }//GEN-LAST:event_submitButtonActionPerformed

    private void submitFollowBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitFollowBtnActionPerformed
        if (tempPrescpArray.size() == 0) {
            Date dob = null;
            Date x = apptDateTxt.getDate();
            Calendar midnight = Calendar.getInstance();
            midnight.set(Calendar.HOUR_OF_DAY, 0);
            midnight.set(Calendar.MINUTE, 0);
            midnight.set(Calendar.SECOND, 0);
            midnight.set(Calendar.MILLISECOND, 0);
            System.out.println("date bew" + midnight.getTime());
            String backDateFlag = "false";
            if (midnight.getTime().after(x)) {
                backDateFlag = "true";
            } else {
                backDateFlag = "false";
            }
            if (backDateFlag == "false") {
                SimpleDateFormat parser = new SimpleDateFormat("MM-dd-yyyy");
                String date = parser.format(x);
                System.out.println(date);

                dateErrLbl.setText("");
                apptDateTxt.setBorder(new LineBorder(Color.black));
                if (date.equals("")) {
                    dateErrLbl.setText("Please enter date");
                    apptDateTxt.setBorder(new LineBorder(Color.red));
                    return;
                }
                Date newDate = null;
                try {
                    newDate = parser.parse(date);
                } catch (ParseException ex) {
                    dateErrLbl.setText("Please type proper date format.");
                    apptDateTxt.setBorder(new LineBorder(Color.red));
                    return;
                }
                Date latestDate = null;

                for (Perscription p : patientReport.getPerscriptionList()) {
                    if (p.getFollowUp() != null) {
                        Date perscDate = p.getFollowUp();

                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(perscDate);
                        calendar.set(Calendar.HOUR_OF_DAY, 0);
                        calendar.set(Calendar.MINUTE, 0);
                        calendar.set(Calendar.SECOND, 0);
                        calendar.set(Calendar.MILLISECOND, 0);

                        if (latestDate == null && perscDate != null) {
                            latestDate = perscDate;
                        } else {

                            if (perscDate.after(latestDate)) {
                                latestDate = p.getFollowUp();

                            }
                        }
                    }
                }
                if (latestDate != null) {
                    if (latestDate.after(newDate)) {
                        JOptionPane.showMessageDialog(null, "Date can not be back date", "Warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    } else {

                        for (Perscription p : perscriptionArray) {
                            for (Perscription pa : patientReport.getPerscriptionList()) {
                                if (pa.getPerscriptionId().equals(p.getPerscriptionId())) {

                                    pa.setFollowUp(newDate);
                                }
                            }
                        }

                        Doctor docName = null;

                        for (Doctor d : organization.getHosDoctorDir().getDoctorList()) {
                            for (Patient pat : organization.getHosPatientDir().getPatientList()) {
                                if (pat.getUniquePatientId().equals(p.getSender().getPatient().getUniquePatientId())) {
                                    if (d.getDoctorId().equals(doctId.getText())) {
                                        docName = d;
                                        for (WorkRequest work : account.getWorkQueue().getWorkRequestList()) {

                                            if (work instanceof PatientWorkRequest) {
                                                if (work.getStatus().equalsIgnoreCase("Requested")) {
                                                    work.setStatus("Completed");
                                                }
                                            }
                                        }
                                        PatientWorkRequest request = new PatientWorkRequest();
                                        request.setDoctor(docName);
                                        request.setStatus("Requested");

                                        request.setSender(p.getSender());
                                        request.setRequestDate(newDate);

                                        for (UserAccount u : organization.getUserAccountDirectory().getUserAccountList()) {
                                            if (u.getEmployee() != null) {
                                                if (u.getEmployee().getName().equalsIgnoreCase(docName.getDocName())) {
                                                    u.getWorkQueue().getWorkRequestList().add(request);
                                                }
                                            }
                                        }
                                        p.getSender().getWorkQueue().getWorkRequestList().add(request);

                                    }
                                }
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Appointment Confirmed");

                    }
                } else {
                    for (Perscription p : perscriptionArray) {
                        for (Perscription pa : patientReport.getPerscriptionList()) {
                            if (pa.getPerscriptionId().equals(p.getPerscriptionId())) {

                                pa.setFollowUp(newDate);
                            }
                        }
                    }

                    Doctor docName = null;

                    for (Doctor d : organization.getHosDoctorDir().getDoctorList()) {
                        for (Patient pat : organization.getHosPatientDir().getPatientList()) {
                            if (pat.getUniquePatientId().equals(p.getSender().getPatient().getUniquePatientId())) {
                                if (d.getDoctorId().equals(doctId.getText())) {
                                    docName = d;

                                    if (p.getStatus().equalsIgnoreCase("Requested")) {
                                        p.setStatus("Completed");
                                    }
                                    PatientWorkRequest request = new PatientWorkRequest();
                                    request.setDoctor(docName);
                                    request.setStatus("Requested");

                                    request.setSender(p.getSender());
                                    request.setRequestDate(newDate);

                                    for (UserAccount u : organization.getUserAccountDirectory().getUserAccountList()) {
                                        if (u.getEmployee() != null) {
                                            if (u.getEmployee().getName().equalsIgnoreCase(docName.getDocName())) {
                                                u.getWorkQueue().getWorkRequestList().add(request);
                                            }
                                        }
                                    }
                                    p.getSender().getWorkQueue().getWorkRequestList().add(request);

                                }
                            }
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Appointment Confirmed");

                }
            } else {
                JOptionPane.showMessageDialog(null, "Selected date can not be back date");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Send all the prescriptions to pharmacy before setting  next appointment.", "Warning", JOptionPane.WARNING_MESSAGE);                  
        }
    }//GEN-LAST:event_submitFollowBtnActionPerformed

    private void submitPharmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitPharmBtnActionPerformed
        // TODO add your handling code here:
        if (pharmaComboList1.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "No pharmacy is available");
        } else {

            int selected = jTable1.getSelectedRow();

            if (selected < 0) {
                JOptionPane.showMessageDialog(null, "Please select a row before proceeding");
            } else {
                Perscription p1 = (Perscription) jTable1.getValueAt(selected, 0);

                if (p1.isSenttopharmacy() == false) {

                    PrescriptionWorkRequest prequest = new PrescriptionWorkRequest();
                    prequest.setPerscription(p1);
                    prequest.setStatus("Requested");
                    prequest.setSender(account);
                    for (Patient p : organization.getHosPatientDir().getPatientList()) {
                        prequest.setEmail(p.getEmailid());
                        prequest.setContact(p.getContactNumber());
                    }
                    System.out.println("ocntact" + prequest.getContact());
                    PharmacyOrganization po = (PharmacyOrganization) pharmaComboList1.getSelectedItem();

                    for (Enterprise p : sNetwork.getEnterpriseDirectory().getEnterpriseList()) {
                        for (Organization og : p.getOrganizationDirectory().getOrganizationList()) {
                            if (og instanceof PharmacyOrganization) {
                                if (og.getName().equalsIgnoreCase(po.getName())) {
                                    og.getWorkQueue().getWorkRequestList().add(prequest);
                                }
                            }
                        }
                    }

                    p1.setSenttopharmacy(true);
                    tempPrescpArray.remove(p1);
                    JOptionPane.showMessageDialog(null, "Request successfully sent");

                } else {
                    JOptionPane.showMessageDialog(null, "Prescription is already requested", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_submitPharmBtnActionPerformed

    private void submitRehabBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitRehabBtnActionPerformed
        // TODO add your handling code here:
        if (rehabComboList.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "No rehab centers available");
        } else {
            PrescriptionWorkRequest prequest = new PrescriptionWorkRequest();
//            int selected = jTable1.getSelectedRow();
//            if (selected < 0) {
//                JOptionPane.showMessageDialog(null, "Please select a row");
//            } else {

               // Perscription p1 = (Perscription) jTable1.getValueAt(selected, 0);

                prequest.setPatient(p.getSender().getPatient());
                prequest.setStatus("Requested");
                prequest.setSender(account);

                p.setStatus("Sent to RegetPatientNamehab");
                patientReport.setFlag(true);
                
                System.out.println("dfnjfd" + prequest.getPatient().getPatientName());

                RehabOrganization po = (RehabOrganization) rehabComboList.getSelectedItem();

                for (Enterprise p : sNetwork.getEnterpriseDirectory().getEnterpriseList()) {
                    for (Organization og : p.getOrganizationDirectory().getOrganizationList()) {
                        if (og instanceof RehabOrganization) {
                            if (og.getName().equalsIgnoreCase(po.getName())) {
                                og.getWorkQueue().getWorkRequestList().add(prequest);
                            }
                        }
                    }
                }

                //
                int rcount = sNetwork.getRehabCount();
                sNetwork.setRehabCount(rcount + 1);
                System.out.println("Rehab count is " + sNetwork.getRehabCount());
//                for (OpioidMedication om : cNetwork.getOpioidList().getOpioidList()) {
//                    if (om.getOpioidName().equals(p1.getOpioidName())) {
//                        om.setAddictionCount(om.getAddictionCount() + 1);
//                    }
//                }
//                sNetwork.setReversalCount(sNetwork.getReversalCount() - 1);
                //

                JOptionPane.showMessageDialog(null, "Request successfully sent to Rehab center");

            
        }
    }//GEN-LAST:event_submitRehabBtnActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        //  Component[] componentArray = userProcessContainer.getComponents();
        // Component component = componentArray[componentArray.length - 1];
        //CountryAdminWorkAreaJPanel sysAdminwjp = (CountryAdminWorkAreaJPanel) component;
        //sysAdminwjp.populateTree();

        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ViewPatientListJPanel manageAccountJPanel = (ViewPatientListJPanel) component;
        manageAccountJPanel.populateWorkQueueTable();
        //  manageAccountJPanel.checkComplete();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void dosageNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dosageNameKeyPressed
        // TODO add your handling code here:
        Validator.onlyInteger(evt, dosageName);
    }//GEN-LAST:event_dosageNameKeyPressed

    private void pillsPerDayKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pillsPerDayKeyPressed
        // TODO add your handling code here:
        Validator.onlyInteger(evt, pillsPerDay);
    }//GEN-LAST:event_pillsPerDayKeyPressed

    private void noOfDaysKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_noOfDaysKeyPressed
        // TODO add your handling code here:
        Validator.onlyInteger(evt, noOfDays);
    }//GEN-LAST:event_noOfDaysKeyPressed

    private void jCheckBoxrejectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxrejectActionPerformed
        // TODO add your handling code here:

        System.out.println("userinterface.Doctor.addRequestJPanel.jCheckBoxrejectActionPerformed()");
    }//GEN-LAST:event_jCheckBoxrejectActionPerformed

    private void jCheckBoxrejectKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCheckBoxrejectKeyPressed
        // TODO add your handling code here:
        opioidConboBox.removeAllItems();

        if (jCheckBoxreject.isSelected() == true) {
            opioidConboBox.removeAllItems();
            System.out.println(cNetwork.getOpioidList());
            Conditions c = (Conditions) comboConditions.getSelectedItem();
            for (OpioidMedication m : cNetwork.getOpioidList().getOpioidList()) {
                if (m.getConditionList().contains(c)) {
                    if (!m.getOpioidName().equals("Reversal")) {
                        opioidConboBox.addItem(m);
                    }
                }
            }

        } else {

            for (OpioidMedication m : cNetwork.getOpioidList().getOpioidList()) {
                if (m.getOpioidName().equals("Reversal")) {

                    opioidConboBox.addItem(m);

                    System.out.println("reversal   " + m.getOpioidName());
                }
            }
            System.out.println("5");
        }
    }//GEN-LAST:event_jCheckBoxrejectKeyPressed

    private void jCheckBoxrejectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxrejectMouseClicked
        // TODO add your handling code here:
        if (jCheckBoxreject.isEnabled() == true) {
            opioidConboBox.removeAllItems();

            if (jCheckBoxreject.isSelected() == true) {

                for (OpioidMedication m : cNetwork.getOpioidList().getOpioidList()) {
                    if (m.getOpioidName().equals("Reversal")) {

                        opioidConboBox.addItem(m);

                        System.out.println("reversal   " + m.getOpioidName());
                    }
                }
                System.out.println("5");

                //
                int count = patientReport.getReversalMedCount();
                patientReport.setReversalMedCount(count + 1);
                int stateRevcount = sNetwork.getReversalCount();
                if (patientReport.getReversalMedCount() > 0 && patientReport.getReversalMedCount() <= 2) {
                    sNetwork.setReversalCount(stateRevcount + 1);

                    for (OpioidMedication om : cNetwork.getOpioidList().getOpioidList()) {
                        for (Perscription p : patientReport.getPerscriptionList()) {
                            if (p.getOpioidName().equals(om.getOpioidName())) {
                                om.setPotentialAddictionCount(om.getAddictionCount() + 1);
                            }
                        }
                    }
                }
                System.out.println(sNetwork.getReversalCount() + "     reversal test");
                //

            } else {

                opioidConboBox.removeAllItems();
                System.out.println(cNetwork.getOpioidList());
                Conditions c = (Conditions) comboConditions.getSelectedItem();
                for (OpioidMedication m : cNetwork.getOpioidList().getOpioidList()) {
                    if (m.getConditionList().contains(c)) {
                        if (!m.getOpioidName().equals("Reversal")) {
                            opioidConboBox.addItem(m);
                        }
                    }
                }

                dosageName.setEditable(true);
                opioidConboBox.setEditable(true);
                pillsPerDay.setEditable(true);
                noOfDays.setEditable(true);
                submitButton.setEnabled(true);
                submitFollowBtn.setEnabled(true);
                pharmaComboList1.setEnabled(true);
                submitPharmBtn.setEnabled(true);
                int countR = patientReport.getRefillCount();
                patientReport.setRefillCount(countR + 1);
                populateOpioidCombo();
                int recommendedDosage = pilldosage - 10;
                if (recommendedDosage <= 0) {
                    JOptionPane.showMessageDialog(null, "Previous dosage amount was " + pilldosage + " since we cannot perscribe less than 0, we recommend still perscribing dosage less then amount.", "Decereased Dosage", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Previous dosage amount was " + pilldosage + " We recommend you perscribe " + recommendedDosage + "or less", "Decreased Dosage", JOptionPane.WARNING_MESSAGE);
                }

            }
        }
    }//GEN-LAST:event_jCheckBoxrejectMouseClicked

    void populatePrescription() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        model.setRowCount(0);
        for (Perscription p : patientReport.getPerscriptionList()) {

            Object[] row = new Object[8];
            // row[0] = enterprise.getName();
            row[0] = p;
            row[1] = p.getConditionName();
            row[2] = p.getOpioidName();
            row[3] = p.getOpioidDosage();
            row[4] = p.getPillsPerDay();
            row[5] = p.getDoctorId();
            row[6] = p.getNumberofDays();
            row[7] = p.getQuantity();

            model.addRow(row);

        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser apptDateTxt;
    private javax.swing.JButton backJButton;
    private javax.swing.JComboBox comboConditions;
    private javax.swing.JLabel dateErrLbl;
    private javax.swing.JLabel daysErrLbl;
    private javax.swing.JTextField docName;
    private javax.swing.JTextField doctId;
    private javax.swing.JLabel dosErrLbl;
    private javax.swing.JTextField dosageName;
    private javax.swing.JCheckBox jCheckBoxreject;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField noOfDays;
    private javax.swing.JComboBox opioidConboBox;
    private javax.swing.JComboBox pharmaComboList1;
    private javax.swing.JLabel pillsErrLbl;
    private javax.swing.JTextField pillsPerDay;
    private javax.swing.JButton ptBtn;
    private javax.swing.JComboBox ptComboList;
    private javax.swing.JComboBox rehabComboList;
    private javax.swing.JButton submitButton;
    private javax.swing.JButton submitFollowBtn;
    private javax.swing.JButton submitPharmBtn;
    private javax.swing.JButton submitRehabBtn;
    // End of variables declaration//GEN-END:variables
}
