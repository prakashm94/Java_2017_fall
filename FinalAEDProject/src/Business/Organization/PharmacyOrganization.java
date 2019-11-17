/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Country.OpioidMedicationDirectory;
import Business.Pharmacy.PharmacyDirectory;
import Business.Role.PharmacyOrganizationRole;
import Business.Role.Role;
import java.util.HashSet;

/**
 *
 * @author indu
 */
public class PharmacyOrganization extends Organization {

    private PharmacyDirectory pharmacyList;
    private OpioidMedicationDirectory opioididr;
    private String name;

    public PharmacyOrganization() {
        super(Organization.Type.PharmacyOrganization.getValue());
        pharmacyList = new PharmacyDirectory();
        opioididr = new OpioidMedicationDirectory();
    }

    public OpioidMedicationDirectory getOpioididr() {
        return opioididr;
    }

    public void setOpioididr(OpioidMedicationDirectory opioididr) {
        this.opioididr = opioididr;
    }

    public PharmacyDirectory getPharmacyList() {
        return pharmacyList;
    }

    public void setPharmacyList(PharmacyDirectory pharmacyList) {
        this.pharmacyList = pharmacyList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public HashSet<Role> getSupportedRole() {
        return null;
    }

}
