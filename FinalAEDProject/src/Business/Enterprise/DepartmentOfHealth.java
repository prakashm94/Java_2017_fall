/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Country.OpioidMedicationDirectory;
import Business.Role.HospitalAdminRole;
import Business.Role.RehabEnterpriseAdminRole;
import Business.Role.Role;
import Business.Sytem.ConditionsDirectory;
import java.util.HashSet;

/**
 *
 * @author indu
 */
public class DepartmentOfHealth extends Enterprise {

    private OpioidMedicationDirectory opioidList;
    private ConditionsDirectory conditionsList;

    public DepartmentOfHealth(String name) {
        super(name, Enterprise.EnterpriseType.DepartmentOfHealth);
        opioidList = new OpioidMedicationDirectory();
        conditionsList = new ConditionsDirectory();
    }

    public OpioidMedicationDirectory getOpioidList() {
        return opioidList;
    }

    public void setOpioidList(OpioidMedicationDirectory opioidList) {
        this.opioidList = opioidList;
    }

    public ConditionsDirectory getConditionsList() {
        return conditionsList;
    }

    public void setConditionsList(ConditionsDirectory conditionsList) {
        this.conditionsList = conditionsList;
    }

    
    
    @Override
    public HashSet<Role> getSupportedRole() {
        roles.add(new HospitalAdminRole());
        roles.add(new RehabEnterpriseAdminRole());
        return roles;
    }

}
