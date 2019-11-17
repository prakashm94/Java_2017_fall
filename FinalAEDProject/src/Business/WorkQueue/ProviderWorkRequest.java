/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Country.OpioidMedication;
import Business.Supplier.Supplier;

/**
 *
 * @author sonal
 */
public class ProviderWorkRequest extends WorkRequest{
   private int requestQuantity;
    private boolean add;
    private Supplier supplier;
    private OpioidMedication opioidMed;

     public ProviderWorkRequest(){
        add = false;
    }
     
    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public boolean isAdd() {
        return add;
    }

    public void setAdd(boolean add) {
        this.add = add;
    }
    
    
    public int getQuantity() {
        return requestQuantity;
    }

    public void setQuantity(int quantity) {
        this.requestQuantity = quantity;
    }

    public int getRequestQuantity() {
        return requestQuantity;
    }

    public void setRequestQuantity(int requestQuantity) {
        this.requestQuantity = requestQuantity;
    }

    public OpioidMedication getOpioidMed() {
        return opioidMed;
    }

    public void setOpioidMed(OpioidMedication opioidMed) {
        this.opioidMed = opioidMed;
    }

    
   
   
}
