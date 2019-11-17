/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Enterprise.EnterpriseDirectory;
import Business.Organization.Organization;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author sonal
 */
public class NetworkState{
    
    private String name;
    private EnterpriseDirectory enterpriseDirectory;
    private int rehabCount;
    private int reversalCount;
    private int violationCount;

    public NetworkState() {
       
        enterpriseDirectory = new EnterpriseDirectory();
    }
    

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRehabCount() {
        return rehabCount;
    }

    public void setRehabCount(int rehabCount) {
        this.rehabCount = rehabCount;
    }

    public int getReversalCount() {
        return reversalCount;
    }

    public void setReversalCount(int reversalCount) {
        this.reversalCount = reversalCount;
    }

    public int getViolationCount() {
        return violationCount;
    }

    public void setViolationCount(int violationCount) {
        this.violationCount = violationCount;
    }
    
    
    
    

    @Override
    public String toString() {
        return name;
    }

   
}
