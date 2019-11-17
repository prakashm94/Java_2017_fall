/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Hospital.Patient;
import Business.Hospital.Perscription;

/**
 *
 * @author sonal
 */
public class PrescriptionWorkRequest extends WorkRequest {
    private Perscription p;
    private Patient patient;
    private boolean add;
    private String email;
    private String contact;
    private String patinetName;
    

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PrescriptionWorkRequest() {
        this.p = p;
        patient = new Patient();
        add = false;
    }

    public Perscription getP() {
        return p;
    }

    public void setP(Perscription p) {
        this.p = p;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public boolean isAdd() {
        return add;
    }

    public void setAdd(boolean add) {
        this.add = add;
    }
    
    
    
}
