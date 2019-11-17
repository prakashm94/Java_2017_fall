/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Enterprise.DepartmentOfHealth;
import Business.Organization.Organization.Type;
import Business.Supplier.Provider;
import Business.Supplier.Supplier;
import java.util.ArrayList;

/**
 *
 * @author sonal
 */
public class OrganizationDirectory {

    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

    public Organization createOrganization(Type type, String name, double latitude, double longitude) {
        Organization organization = null;
        if (type.getValue().equals(Type.HospitalOrganization.getValue())) {
            organization = new HospitalOrganization();
            organization.setName(name);
            organization.setLatitude(latitude);
            organization.setLongitude(longitude);
            organizationList.add(organization);
        }
        return organization;
    }

    public Organization createOrganization(Type type, String name) {
        Organization organization = null;
        if (type.getValue().equals(Type.Supplier.getValue())) {
            organization = new SupplierOrganization();
            organization.setName(name);
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.Provider.getValue())) {
            organization = new ProviderOrganization();
            organization.setName(name);
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.RehabOrganization.getValue())) {
            organization = new RehabOrganization();
            organization.setName(name);
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.PharmacyOrganization.getValue())) {
            organization = new PharmacyOrganization();
            organization.setName(name);
            organizationList.add(organization);
        }
        return organization;
    }
}
