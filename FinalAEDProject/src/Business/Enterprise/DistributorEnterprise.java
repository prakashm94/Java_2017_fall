/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.ProviderRole;
import Business.Role.Role;
import Business.Role.SupplierRole;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author sonal
 */
public class DistributorEnterprise extends Enterprise{
    
      public DistributorEnterprise(String name) {
        super(name, Enterprise.EnterpriseType.Distributor);
    }

    @Override
    public HashSet<Role> getSupportedRole() {
        roles = new HashSet<>();
        roles.add(new ProviderRole());
        roles.add(new SupplierRole());
        return roles;
    }
}
