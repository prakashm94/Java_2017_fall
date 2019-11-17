/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.NetworkCountry;
import Business.Network.NetworkState;
import Business.Organization.HospitalOrganization;
import Business.Organization.Organization;
import static Business.Organization.Organization.Type.PharmacyOrganization;
import Business.Organization.PharmacyOrganization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.Pharmacy.PharmacyAdminWorkAreaJPanel;

/**
 *
 * @author indu
 */
public class PharmacyOrganizationRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, NetworkState sNetwork, NetworkCountry cNetwork, EcoSystem business) {
       return new PharmacyAdminWorkAreaJPanel(userProcessContainer, account, (PharmacyOrganization) organization,enterprise,business, cNetwork, sNetwork);
    }
    
}
