/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Hospital;

import java.util.ArrayList;

/**
 *
 * @author sonal
 */
public class PhysicalTherapyDirectory {
    ArrayList<PhysicalTherapy> physicalTherapyList;
    public PhysicalTherapyDirectory() {
        physicalTherapyList = new ArrayList<>();
    }

    public ArrayList<PhysicalTherapy> getPhysicalTherapyList() {
        return physicalTherapyList;
    }

    public void setPhysicalTherapyList(ArrayList<PhysicalTherapy> physicalTherapyList) {
        this.physicalTherapyList = physicalTherapyList;
    }

    
    public PhysicalTherapy addPhysicalTherapy() {
        PhysicalTherapy pt = new PhysicalTherapy();
        physicalTherapyList.add(pt);
        return pt;
    }

    //Removing an Employee from the Directory
    public void removeDoctor(Patient patient) {
        physicalTherapyList.remove(patient);
    }
        
    
}
