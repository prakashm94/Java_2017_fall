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
public class PhysicalTherapy {

    private String ptName;
    private String ptId;
    private static int ptCount;
    private PatientDirectory patientdir;
    private WorkQueue workQueue;
    private static int eCount = 0;
    private EcoSystem system = EcoSystem.getInstance();

    public PhysicalTherapy() {
         if(eCount==0){
            eCount=system.ptCount;
        }
        ptId = "PT" + (++eCount);
        system.ptCount= eCount;
        
        patientdir = new PatientDirectory();
        workQueue = new WorkQueue();
    }

    public String getPtName() {
        return ptName;
    }

    public void setPtName(String ptName) {
        this.ptName = ptName;
    }

    public String getPtId() {
        return ptId;
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

    @Override
    public String toString() {
        return ptName;
    }
}
