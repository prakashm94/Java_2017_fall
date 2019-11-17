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
public class Supplier {
    private String supplierName;
    private static int sCount;
    private String supplierId;
    private OpioidMedicationDirectory opioidMedList;
    private WorkQueue workQueue;
    private static int eCount = 0;
    private EcoSystem system = EcoSystem.getInstance();
    
    public Supplier(){
        if(eCount==0){
            eCount=system.supplierCount;
        }
        supplierId= "SID"+(++eCount);
        system.supplierCount= eCount;
        
        opioidMedList= new OpioidMedicationDirectory();
        workQueue= new WorkQueue();
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public OpioidMedicationDirectory getOpioidMedList() {
        return opioidMedList;
    }

    public void setOpioidMedList(OpioidMedicationDirectory opioidMedList) {
        this.opioidMedList = opioidMedList;
    }



    
    @Override
    public String toString(){
        return supplierName;
    }
    
}
