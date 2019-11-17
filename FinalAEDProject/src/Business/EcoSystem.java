package Business;

import Business.Country.OpioidMedicationDirectory;
import Business.Enterprise.Enterprise;
import Business.Network.NetworkCountry;
import Business.Network.NetworkState;
import Business.Organization.Organization;
import Business.Role.CountryAdminRole;
import Business.Role.DepartmentOfHealthAdminRole;
import Business.Role.DistributorAdminRole;
import Business.Role.HospitalAdminRole;
import Business.Role.PharmaEnterpriseAdminRole;
import Business.Role.RehabEnterpriseAdminRole;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import Business.Sytem.ConditionsDirectory;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author sonal
 */
public class EcoSystem extends Organization {

    private static EcoSystem business;
    private ArrayList<NetworkCountry> networkCList;
    private ConditionsDirectory conditionsList;
    public int employeeidCount;
    public int opoidMedicationCount;
    public int doctorCount;
    public int patientCount;
    public int perscriptionCount;
    public int ptCount;
    public int reportCount;
    public int providerCount;
    public int supplierCount;
    public int conditionsCount;
    public int organizationCount;
    public static EcoSystem getInstance() {
        if (business == null) {
            business = new EcoSystem();
        }
        return business;
    }

    private EcoSystem() {
        super(null);
        networkCList = new ArrayList<>();
        conditionsList= new ConditionsDirectory();
    }
    
    public ArrayList<NetworkCountry> getNetworkCList() {
        return networkCList;
    }

    public void setNetworkCList(ArrayList<NetworkCountry> networkCList) {
        this.networkCList = networkCList;
    }

    public static void setInstance(EcoSystem system) {
        business = system;
    }

    public ConditionsDirectory getConditionsList() {
        return conditionsList;
    }

    public void setConditionsList(ConditionsDirectory conditionsList) {
        this.conditionsList = conditionsList;
    }
    
    public NetworkCountry createAndAddNetworkCountry() {
        NetworkCountry network = new NetworkCountry();
        networkCList.add(network);
        return network;
    }
    
    public Boolean isUniqueCountry(String name)
    {
        for(NetworkCountry a:networkCList)
        {
            if(a.getName().equals(name))
                return false;
       
                
        }
        return true;
        
    }

    @Override
    public HashSet<Role> getSupportedRole() {
        roles.add(new SystemAdminRole());
        roles.add(new DistributorAdminRole());
        roles.add(new DepartmentOfHealthAdminRole());
        roles.add(new PharmaEnterpriseAdminRole());
        roles.add(new RehabEnterpriseAdminRole());
        roles.add(new HospitalAdminRole());
        return roles;
    }

    public static boolean checkIfUsernameIsUnique(String username) {

        //  if (!this.getUserAccountDirectory().checkIfUsernameIsUnique(username)) {
        //for(NetworkCountry networkCountry:business.getNetworkCList()){
        for (NetworkCountry networkC : business.getNetworkCList()) {
            for (NetworkState network : networkC.getNetworkStateList()) {

                
                for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                    for (UserAccount ua : enterprise.getUserAccountDirectory().getUserAccountList()) {
                        if (ua.getUsername().equals(username)) {
                            return false;
                        }
                    }

                    for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                        for (UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()) {
                            if (ua.getUsername().equals(username)) {
                                return false;
                            }
                        }
                    }
                }
            }
        }

        // }
        return true;
    }
    
    public static boolean chckCountryAdminUser(String username)
    {
        for(UserAccount a : business.getUserAccountDirectory().getUserAccountList())
        {
            if(a.getUsername().equalsIgnoreCase(username))
                return false;
        }
        return true;
    }
}
