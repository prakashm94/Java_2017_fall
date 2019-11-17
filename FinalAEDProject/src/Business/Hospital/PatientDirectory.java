/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Hospital;

import Business.Country.*;
import java.util.ArrayList;

/**
 *
 * @author indu
 */
public class PatientDirectory {
     private ArrayList<Patient> patientList;
     
     public PatientDirectory() {
        patientList = new ArrayList<>();
    }

    public Patient addPatient() {
        Patient person = new Patient();
        patientList.add(person);
        return person;
    }

    public ArrayList<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(ArrayList<Patient> patientList) {
        this.patientList = patientList;
    }
    

    //Removing an Employee from the Directory
    public void removePatient(Patient patient) {
        patientList.remove(patient);
    }
}
