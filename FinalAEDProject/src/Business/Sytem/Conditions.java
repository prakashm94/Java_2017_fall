/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Sytem;

import Business.EcoSystem;

/**
 *
 * @author sonal
 */
public class Conditions {
    private String diseaseName;
    private String diseaseId;
    private static int dCount;
    private static int eCount = 0;
    private EcoSystem system = EcoSystem.getInstance();
    
    public Conditions(){
         if(eCount==0){
            eCount=system.conditionsCount;
        }
        diseaseId= "CON"+(++eCount);
        system.conditionsCount= eCount;
        
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getDiseaseId() {
        return diseaseId;
    }

    @Override
    public String toString(){
    return diseaseName;
}
    
    
}
