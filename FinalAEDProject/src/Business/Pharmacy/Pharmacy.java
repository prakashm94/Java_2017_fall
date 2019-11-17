/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Pharmacy;

import Business.Country.OpioidMedication;

/**
 *
 * @author indu
 */
public class Pharmacy {
    private OpioidMedication opioidList;
    private String pharmacyName;

    public Pharmacy(){
        opioidList= new OpioidMedication();
    }

    public OpioidMedication getOpioidList() {
        return opioidList;
    }

    public void setOpioidList(OpioidMedication opioidList) {
        this.opioidList = opioidList;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }
    
    @Override
    public String toString(){
        return pharmacyName;
    }
}
