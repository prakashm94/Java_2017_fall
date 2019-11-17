/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.PharmacyOrganizationRole;
import Business.Role.Role;
import java.util.HashSet;

/**
 *
 * @author indu
 */
public class PharmacyEnterprise extends Enterprise {

    public PharmacyEnterprise(String name) {
        super(name, Enterprise.EnterpriseType.PharmacyEnterprise);
    }

    @Override
    public HashSet<Role> getSupportedRole() {
        roles = new HashSet<>();
        roles.add(new PharmacyOrganizationRole());
        return roles;
    }

}
