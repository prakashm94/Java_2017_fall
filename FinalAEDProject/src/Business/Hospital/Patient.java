/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Hospital;

import Business.Country.*;
import Business.EcoSystem;
import Business.WorkQueue.WorkQueue;
import java.util.Date;

/**
 *
 * @author indu
 */
public class Patient {

    private String patientName;
    //private String patientId;
    private String emailid;
    private String contactNumber;
    private Long conatctNumber;
    private String carrierName;
    private String uniquePatientId;
    private Person associatedPerson;
    private static int patCount;
    private WorkQueue workQueue;
    private Date appointmentdate;
     private static int eCount = 0;
    private EcoSystem system = EcoSystem.getInstance();

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public Long getConatctNumber() {
        return conatctNumber;
    }

    public void setConatctNumber(Long conatctNumber) {
        this.conatctNumber = conatctNumber;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public Patient() {
        if(eCount==0){
            eCount=system.patientCount;
        }
        //patientId = "per" + (++eCount);
        system.patientCount= eCount;
        
        associatedPerson = new Person();
        workQueue = new WorkQueue();
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

   /* public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
*/
    public static int getPatCount() {
        return patCount;
    }

    public Person getAssociatedPerson() {
        return associatedPerson;
    }

    public void setAssociatedPerson(Person associatedPerson) {
        this.associatedPerson = associatedPerson;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public String getUniquePatientId() {
        return uniquePatientId;
    }

    public void setUniquePatientId(String uniquePatientId) {
        this.uniquePatientId = uniquePatientId;
    }

    public Date getAppointmentdate() {
        return appointmentdate;
    }

    public void setAppointmentdate(Date appointmentdate) {
        this.appointmentdate = appointmentdate;
    }

    
    @Override
    public String toString() {
        return patientName;
    }
}
