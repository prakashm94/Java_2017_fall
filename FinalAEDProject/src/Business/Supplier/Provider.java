/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Supplier;

import Business.Country.OpioidMedicationDirectory;
import Business.EcoSystem;
import Business.Organization.SupplierOrganization;
import Business.WorkQueue.WorkQueue;

/**
 *
 * @author sonal
 */
public class Provider {
    private String providerName;
    private static int pCount;
    private String providerId;
    private OpioidMedicationDirectory opioidMediList;
    private WorkQueue workQueue;
    private static int eCount = 0;
    private EcoSystem system = EcoSystem.getInstance();
    
    public Provider(){
        if(eCount==0){
            eCount=system.providerCount;
        }
        providerId= "PID"+(++eCount);
        system.providerCount= eCount;
        
        opioidMediList= new OpioidMedicationDirectory();
        workQueue= new WorkQueue();
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }
    
    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public OpioidMedicationDirectory getOpioidMediList() {
        return opioidMediList;
    }

    public void setOpioidMediList(OpioidMedicationDirectory opioidMediList) {
        this.opioidMediList = opioidMediList;
    }

    
    @Override
    public String toString(){
        return providerName;
    }
}
