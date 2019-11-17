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
import userinterface.SystemAdminWorkAreas.SystemAdminWorkAreaJPanel;

/**
 *
 * @author sonal
 */
public class SystemAdminRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, NetworkState sNetwork, NetworkCountry cNetwork, EcoSystem business) {
        return new SystemAdminWorkAreaJPanel(userProcessContainer,account, business);
    }
    
}
