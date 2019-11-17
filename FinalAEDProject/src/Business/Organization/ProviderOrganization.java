/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.DistributorAdminRole;
import Business.Role.Role;
import Business.Supplier.Provider;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author sonal
 */
public class ProviderOrganization extends Organization{
    Provider provider;
    private String name;
      public ProviderOrganization() {
        super(Organization.Type.Provider.getValue());
        provider= new Provider();
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
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
