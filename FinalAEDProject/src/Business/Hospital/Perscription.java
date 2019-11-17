/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Hospital;

import Business.Country.OpioidMedication;
import Business.EcoSystem;
import Business.Sytem.Conditions;
import java.util.Date;

/**
 *
 * @author indu
 */
public class Perscription {

    private String doctorId;
    private int opioidDosage;
    private String opioidName;
    private String conditionName;
    private String perscriptionId;
    private static int perscriptCount;
    private int pillsPerDay;
    private int numberofDays;
    private int quantity;
    private Date followUp;
    private boolean senttopharmacy;
    private static int eCount = 0;
    private EcoSystem system = EcoSystem.getInstance();
    
    public Perscription () {
         if(eCount==0){
            eCount=system.perscriptionCount;
        }
        perscriptionId = "perscript" + (++eCount);
        system.perscriptionCount= eCount;
        
        senttopharmacy=false;
    }

    public boolean isSenttopharmacy() {
        return senttopharmacy;
    }

    public void setSenttopharmacy(boolean senttopharmacy) {
        this.senttopharmacy = senttopharmacy;
    }

    public int getQuantity() {
        return pillsPerDay*numberofDays;
    }

    public Date getFollowUp() {
        return followUp;
    }

    public void setFollowUp(Date followUp) {
        this.followUp = followUp;
    }
    
    
    

    public int getPillsPerDay() {
        return pillsPerDay;
    }

    public void setPillsPerDay(int pillsPerDay) {
        this.pillsPerDay = pillsPerDay;
    }

    public int getNumberofDays() {
        return numberofDays;
    }

    public void setNumberofDays(int numberofDays) {
        this.numberofDays = numberofDays;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getOpioidName() {
        return opioidName;
    }

    public void setOpioidName(String opioidName) {
        this.opioidName = opioidName;
    }

    public String getConditionName() {
        return conditionName;
    }

    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
    }

    public int getOpioidDosage() {
        return opioidDosage;
    }

    public void setOpioidDosage(int opioidDosage) {
        this.opioidDosage = opioidDosage;
    }

    public static int getPerscriptCount() {
        return perscriptCount;
    }

    public static void setPerscriptCount(int perscriptCount) {
        Perscription.perscriptCount = perscriptCount;
    }

    public String getPerscriptionId() {
        return perscriptionId;
    }

    public int caluclateTotalPills(int pillPerDay, int days) {
        int totalPill = pillPerDay * days;
        return totalPill;
    }

    @Override
    public String toString() {
        return perscriptionId;
    }
}
