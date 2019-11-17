/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.DoctorRole;
import Business.Role.RehabManagerRole;
import Business.Role.Role;
import java.util.HashSet;

/**
 *
 * @author indu
 */
public class RehabOrganization extends Organization{
    private String name;
    public RehabOrganization() {
        super(Organization.Type.RehabOrganization.getValue());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    @Override
    public HashSet<Role> getSupportedRole() {  
        return null;
    }
    @Override
    public String toString() {
        return name;
    }
}
