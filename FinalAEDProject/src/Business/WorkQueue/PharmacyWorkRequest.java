/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Country.OpioidMedication;
import Business.Hospital.Perscription;

/**
 *
 * @author sonal
 */
public class PharmacyWorkRequest extends WorkRequest{
    private int requestQuantity;
    private Perscription perscription;
    private OpioidMedication opioidMed;
    private boolean add;
    
    public PharmacyWorkRequest(){
        add = false;
    }
    
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
