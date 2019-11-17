/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Hospital.DoctorDirectory;
import Business.Hospital.PTConditionsDirectory;
import Business.Hospital.PatientDirectory;
import Business.Hospital.PhysicalTherapy;
import Business.Hospital.PhysicalTherapyDirectory;
import Business.Hospital.ReportDirectory;
import Business.Role.DoctorRole;
import Business.Role.PatientRole;
import Business.Role.PhysicalTherapyRole;
import Business.Role.Role;
import java.util.HashSet;

/**
 *
 * @author sonal
 */
public class HospitalOrganization extends Organization{
    private PatientDirectory hosPatientDir;
    private DoctorDirectory hosDoctorDir;
    private PhysicalTherapyDirectory hosPtDir;
    private PTConditionsDirectory ptConditions;
    private ReportDirectory reportDir;

    
    public HospitalOrganization() {
        super(Organization.Type.HospitalOrganization.getValue());
        hosPatientDir = new PatientDirectory();
        hosDoctorDir = new DoctorDirectory();
        hosPtDir = new PhysicalTherapyDirectory();
        ptConditions= new PTConditionsDirectory();
        reportDir= new ReportDirectory();
    }

   
    
    public ReportDirectory getReportDir() {
        return reportDir;
    }

    public void setReportDir(ReportDirectory reportDir) {
        this.reportDir = reportDir;
    }

    public PTConditionsDirectory getPtConditions() {
        return ptConditions;
    }

    public void setPtConditions(PTConditionsDirectory ptConditions) {
        this.ptConditions = ptConditions;
    }

    public PatientDirectory getHosPatientDir() {
        return hosPatientDir;
    }
    
    public void setHosPatientDir(PatientDirectory hosPatientDir) {
        this.hosPatientDir = hosPatientDir;
    }

    public DoctorDirectory getHosDoctorDir() {
        return hosDoctorDir;
    }

    public void setHosDoctorDir(DoctorDirectory hosDoctorDir) {
        this.hosDoctorDir = hosDoctorDir;
    }

    public PhysicalTherapyDirectory getHosPtDir() {
        return hosPtDir;
    }

    public void setHosPtDir(PhysicalTherapyDirectory hosPtDir) {
        this.hosPtDir = hosPtDir;
    }
    
    @Override
    public HashSet<Role> getSupportedRole() {  
        roles = new HashSet<>();
        roles.add(new DoctorRole());
        roles.add(new PatientRole());
        roles.add(new PhysicalTherapyRole());
        return roles;
    }
     
}