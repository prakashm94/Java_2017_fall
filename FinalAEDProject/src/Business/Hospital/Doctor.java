/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Hospital;

import Business.EcoSystem;
import Business.Organization.HospitalOrganization;
import Business.WorkQueue.WorkQueue;

/**
 *
 * @author sonal
 */
public class Doctor extends HospitalOrganization{
    private String docName;
    private String doctorId;
    private static int docCount;
    private PatientDirectory patientdir;
    private WorkQueue workQueue;
    private int capacity;
    private int currentPatientNum;
    private int violationCount;
    private static int eCount = 0;
    private EcoSystem system = EcoSystem.getInstance();

    
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCurrentPatientNum() {
        return currentPatientNum;
    }

    public void setCurrentPatientNum(int currentPatientNum) {
        this.currentPatientNum = currentPatientNum;
    }
    
    public Doctor(){
        if(eCount==0){
            eCount=system.doctorCount;
        }
        doctorId= "DOC"+(++eCount);
        system.doctorCount= eCount;
        
        patientdir = new PatientDirectory();
        workQueue = new WorkQueue();
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDoctorId() {
        return doctorId;
    } 

    public PatientDirectory getPatientdir() {
        return patientdir;
    }

    public void setPatientdir(PatientDirectory patientdir) {
        this.patientdir = patientdir;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public int getViolationCount() {
        return violationCount;
    }

    public void setViolationCount(int violationCount) {
        this.violationCount = violationCount;
    }
    
    @Override
    public String toString(){
        return docName;
    }
}
