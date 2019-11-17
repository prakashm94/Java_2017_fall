/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Hospital;
import Business.Sytem.*;
import java.util.ArrayList;

/**
 *
 * @author sonal
 */
public class PTConditionsDirectory {

    private ArrayList<Conditions> conditionList;

    public PTConditionsDirectory() {
        conditionList = new ArrayList<>();
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
    public void removeCondition(Conditions condition) {
        conditionList.remove(condition);
    }

    @Override
    public String toString() {
        return "ConditionsDirectory{" + "conditionList=" + conditionList + '}';
    }
    
    

}
