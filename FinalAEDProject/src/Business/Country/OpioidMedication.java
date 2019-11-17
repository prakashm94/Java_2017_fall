/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Country;

import Business.EcoSystem;
import Business.Sytem.Conditions;
import java.util.ArrayList;

/**
 *
 * @author sonal
 */
public class OpioidMedication {
    private String opioidName;
    private String opioidId;
    private float mmeMultiplier;
    private static int oCount;
    private ArrayList<Conditions> conditionList;
    int quantity;
    int AddictionCount;
    int PotentialAddictionCount;
    private static int eCount = 0;
    private EcoSystem system = EcoSystem.getInstance();

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
    
    public OpioidMedication(){
        if(eCount==0){
            eCount=system.employeeidCount;
        }
        opioidId= "MED"+(++eCount);
        system.opoidMedicationCount= eCount;
        
        conditionList = new ArrayList<Conditions>();
    }

    public String getOpioidName() {
        return opioidName;
    }

    public void setOpioidName(String opioidName) {
        this.opioidName = opioidName;
    }

    public String getOpioidId() {
        return opioidId;
    }

    public static int getoCount() {
        return oCount;
    }

    public float getMmeMultiplier() {
        return mmeMultiplier;
    }

    public void setMmeMultiplier(float mmeMultiplier) {
        this.mmeMultiplier = mmeMultiplier;
    }

    
    public static void setoCount(int oCount) {
        OpioidMedication.oCount = oCount;
    }

    public ArrayList<Conditions> getConditionList() {
        return conditionList;
    }

    public void setConditionList(ArrayList<Conditions> conditionList) {
        this.conditionList = conditionList;
    }

    public Conditions addCondition() {
        Conditions condition = new Conditions();
        conditionList.add(condition);
        return condition;
    }

    //Removing an Employee from the Directory
    public void removeConditions(Conditions cond) {
        conditionList.remove(cond);
    }

    public int getAddictionCount() {
        return AddictionCount;
    }

    public void setAddictionCount(int AddictionCount) {
        this.AddictionCount = AddictionCount;
    }

    public int getPotentialAddictionCount() {
        return PotentialAddictionCount;
    }

    public void setPotentialAddictionCount(int PotentialAddictionCount) {
        this.PotentialAddictionCount = PotentialAddictionCount;
    }

    
    @Override
    public String toString(){
    return opioidName;
}
    
    
}
