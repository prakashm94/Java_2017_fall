/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Country.OpioidMedication;
import Business.Country.OpioidMedicationDirectory;
import Business.Country.PersonDirectory;
import Business.Employee.Employee;
import java.util.ArrayList;

/**
 *
 * @author sonal
 */
public class NetworkCountry {
    
    
    private String name;
    private ArrayList<NetworkState> networkStateList;
    private OpioidMedicationDirectory opioidList;
    private PersonDirectory personDir;
    

    public NetworkCountry() {
        networkStateList = new ArrayList<>();
        opioidList = new OpioidMedicationDirectory();
        OpioidMedication o= opioidList.addDisease();
        o.setOpioidName("Reversal");
     //   o.set("Reversal");
        personDir = new PersonDirectory();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OpioidMedicationDirectory getOpioidList() {
        return opioidList;
    }

    public void setOpioidList(OpioidMedicationDirectory opioidList) {
        this.opioidList = opioidList;
    }
    
    public ArrayList<NetworkState> getNetworkStateList() {
        return networkStateList;
    }

    public void setNetworkStateList(ArrayList<NetworkState> networkStateList) {
        this.networkStateList = networkStateList;
    }

    public PersonDirectory getPersonDir() {
        return personDir;
    }

    public void setPersonDir(PersonDirectory personDir) {
        this.personDir = personDir;
    }
    
    
    
    public NetworkState createAndAddNetwork() {
        NetworkState network = new NetworkState();
        networkStateList.add(network);
        return network;
        
    }
    
    @Override
    public String toString() {
        return name;
    }
    
    public Boolean isUniqueState(String name)
    {
            for(NetworkState a:networkStateList)
        {
            if(a.getName().equals(name))
                return false;
       
                
        }
        return true;
        
    }
}
