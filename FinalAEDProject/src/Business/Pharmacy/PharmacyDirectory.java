/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Pharmacy;

import Business.Hospital.Report;
import java.util.ArrayList;

/**
 *
 * @author indu
 */
public class PharmacyDirectory {
    private ArrayList<Pharmacy> pharmaList;

    public PharmacyDirectory() {
        pharmaList = new ArrayList<>();
    }

    public ArrayList<Pharmacy> getPharmaList() {
        return pharmaList;
    }

    public void setPharmaList(ArrayList<Pharmacy> pharmaList) {
        this.pharmaList = pharmaList;
    }
    
    public Pharmacy addPharma() {
        Pharmacy phar = new Pharmacy();
        pharmaList.add(phar);
        return phar;
    }

    //Removing an Employee from the Directory
    public void removePharma(Pharmacy pharm) {
        pharmaList.remove(pharm);
    }
    
}
