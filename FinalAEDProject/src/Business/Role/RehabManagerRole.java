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
import Business.Organization.RehabOrganization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.Patient.PatientJPanel;
import userinterface.Rehab.RehabManagerJPanel;

/**
 *
 * @author Vignesh Murali
 */
public class RehabManagerRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, NetworkState sNetwork, NetworkCountry cNetwork, EcoSystem business) {
        //throw new RehabManagerRole(userProcessContainer,account, organization,enterprise, sNetwork, cNetwork, business);
        return new RehabManagerJPanel(userProcessContainer,account, (RehabOrganization)organization,enterprise, sNetwork, cNetwork, business);
    }
    
}
