/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.NetworkCountry;
import Business.Network.NetworkState;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;

import javax.swing.JPanel;
import userinterface.CountryAdminWorkAreas.CountryAdminWorkAreaJPanel;
import userinterface.SystemAdminWorkAreas.SystemAdminWorkAreaJPanel;

/**
 *
 * @author raunak
 */
public class CountryAdminRole extends Role{

  
     @Override
    public String toString(){
        return RoleType.CountryAdmin.getValue();
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, NetworkState sNetwork, NetworkCountry cNetwork, EcoSystem business) {
        return new CountryAdminWorkAreaJPanel(userProcessContainer,account, cNetwork,business);
    }
}
