/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Hospital;

import Business.EcoSystem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author indu
 */
public class Report {

    private Patient patient;
    private ArrayList<Perscription> perscriptionList;
    private String reportId;
    private int refillCount;
    private int reversalMedCount;
    private boolean ptSuccessFlag;
    private boolean ptRefillflag;
    HashMap<String, Integer> hm = new HashMap<>();
    private static int eCount = 0;
    private EcoSystem system = EcoSystem.getInstance();
    private boolean flag;

    public boolean isPtRefillflag() {
        return ptRefillflag;
    }

    public void setPtRefillflag(boolean ptRefillflag) {
        this.ptRefillflag = ptRefillflag;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Report() {
        perscriptionList = new ArrayList<>();
        ptSuccessFlag = true;
        flag=false;
        ptRefillflag = false;
        if (eCount == 0) {
            eCount = system.reportCount;
        }
        reportId = "REP" + (++eCount);
        system.reportCount = eCount;

    }

    public HashMap<String, Integer> getHm() {
        return hm;
    }

    public void setHm(HashMap<String, Integer> hm) {
        this.hm = hm;
    }

    public boolean isPtSuccessFlag() {
        return ptSuccessFlag;
    }

    public void setPtSuccessFlag(boolean ptSuccessFlag) {
        this.ptSuccessFlag = ptSuccessFlag;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public ArrayList<Perscription> getPerscriptionList() {
        return perscriptionList;
    }

    public void setPerscriptionList(ArrayList<Perscription> perscriptionList) {
        this.perscriptionList = perscriptionList;
    }

    public int getRefillCount() {
        return refillCount;
    }

    public void setRefillCount(int refillCount) {
        this.refillCount = refillCount;
    }

    public int getReversalMedCount() {
        return reversalMedCount;
    }

    public void setReversalMedCount(int reversalMedCount) {
        this.reversalMedCount = reversalMedCount;
    }

    public String getReportId() {
        return reportId;
    }

    public Perscription addReport() {
        Perscription persc = new Perscription();
        perscriptionList.add(persc);
        return persc;
    }

    //Removing an Employee from the Directory
    public void removePerscription(Perscription perscript) {
        perscriptionList.remove(perscript);
    }

    @Override
    public String toString() {
        return reportId;
    }
}
