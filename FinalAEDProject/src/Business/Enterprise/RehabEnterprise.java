/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.RehabManagerRole;
import Business.Role.Role;
import java.util.HashSet;

/**
 *
 * @author Vignesh Murali
 */
public class RehabEnterprise extends Enterprise {

    public RehabEnterprise(String name) {
        super(name, EnterpriseType.Rehab);
    }

    @Override
    public HashSet<Role> getSupportedRole() {
        roles = new HashSet<>();
        roles.add(new RehabManagerRole());
        return roles;
    }
    
}
