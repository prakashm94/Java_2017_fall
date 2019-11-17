/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Country;
import Business.Network.NetworkState;
import java.util.ArrayList;

/**
 *
 * @author sonal
 */
public class OpioidMedicationDirectory {

    private ArrayList<OpioidMedication> opioidList;

    public OpioidMedicationDirectory() {
        opioidList = new ArrayList<>();
    }

    public ArrayList<OpioidMedication> getOpioidList() {
        return opioidList;
    }

    public void setOpioidList(ArrayList<OpioidMedication> opioidList) {
        this.opioidList = opioidList;
    }

    public OpioidMedication addDisease() {
        OpioidMedication opioid = new OpioidMedication();
        opioidList.add(opioid);
        return opioid;
    }

    //Removing an Employee from the Directory
    public void removeDisease(OpioidMedication vaccine) {
        opioidList.remove(vaccine);
    }
    
    public Boolean isUniqueOpioid(String name)
    {
            for(OpioidMedication a:opioidList)
        {
            if(a.getOpioidName().equals(name))
                return false;
       
                
        }
        return true;
        
    }

    @Override
    public String toString() {
        return "OpioidMedicationDirectory{" + "opioidList=" + opioidList + '}';
    }
    
    

}
