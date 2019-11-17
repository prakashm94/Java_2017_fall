/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Hospital;

import java.util.ArrayList;

/**
 *
 * @author indu
 */
public class ReportDirectory {
    private ArrayList<Report> reportList;

    public ReportDirectory() {
        reportList = new ArrayList<Report>();
    }

    public ArrayList<Report> getReportList() {
        return reportList;
    }

    public void setReportList(ArrayList<Report> reportList) {
        this.reportList = reportList;
    }

    
    public Report addReport() {
        Report rep = new Report();
        reportList.add(rep);
        return rep;
    }

    //Removing an Employee from the Directory
    public void removeReport(Report report) {
        reportList.remove(report);
    }
}
