/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.DistributorAdminRole;
import Business.Role.Role;
import Business.Supplier.SupplierDirectory;
import java.util.HashSet;

/**
 *
 * @author sonal
 */
public class SupplierOrganization extends Organization {

    private SupplierDirectory supplierList;
    private String name;
    public SupplierOrganization() {
        super(Organization.Type.Supplier.getValue());
        supplierList = new SupplierDirectory();
    }

    public SupplierDirectory getSupplierList() {
        return supplierList;
    }

    public void setSupplierList(SupplierDirectory supplierList) {
        this.supplierList = supplierList;
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
