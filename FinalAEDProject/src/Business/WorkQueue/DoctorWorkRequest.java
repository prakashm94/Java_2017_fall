/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Hospital.Patient;
import Business.Hospital.Perscription;
import Business.Sytem.Conditions;

/**
 *
 * @author indu
 */
public class DoctorWorkRequest extends WorkRequest {
    private int requestQuantity;
  //  private Patient patient;
    private PatientWorkRequest pwr;
    private Perscription perscription;
    private boolean add;
    private boolean patientRefillRequest;
    private Conditions conditions;
    
    public DoctorWorkRequest(){
        add = false;
       // patient= new Patient();
        pwr= new PatientWorkRequest();
        conditions= new Conditions();
        patientRefillRequest=false;
        
    }

    public Conditions getConditions() {
        return conditions;
    }

    public void setConditions(Conditions conditions) {
        this.conditions = conditions;
    }

    public boolean isPatientRefillRequest() {
        return patientRefillRequest;
    }

    public void setPatientRefillRequest(boolean patientRefillRequest) {
        this.patientRefillRequest = patientRefillRequest;
    }

    public PatientWorkRequest getPwr() {
        return pwr;
    }

    public void setPwr(PatientWorkRequest pwr) {
        this.pwr = pwr;
    }

    public int getRequestQuantity() {
        return requestQuantity;
    }

    public void setRequestQuantity(int requestQuantity) {
        this.requestQuantity = requestQuantity;
    }
//
//    public Patient getPatient() {
//        return patient;
//    }
//
//    public void setPatient(Patient patient) {
//        this.patient = patient;
//    }
    
    public int getQuantity() {
        return requestQuantity;
    }

    public void setQuantity(int quantity) {
        this.requestQuantity = quantity;
    }

    public boolean isAdd() {
        return add;
    }

    public void setAdd(boolean add) {
        this.add = add;
    }

    public Perscription getPerscription() {
        return perscription;
    }

    public void setPerscription(Perscription perscription) {
        this.perscription = perscription;
    }
    
}
