/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Hospital;

import java.util.ArrayList;

/**
 *
 * @author sonal
 */
public class DoctorDirectory {
    ArrayList<Doctor> doctorList;
    public DoctorDirectory() {
        doctorList = new ArrayList<>();
    }

    public ArrayList<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(ArrayList<Doctor> doctorList) {
        this.doctorList = doctorList;
    }
    public Doctor addDoctor() {
        Doctor doc = new Doctor();
        doctorList.add(doc);
        return doc;
    }

    //Removing an Employee from the Directory
    public void removeDoctor(Patient patient) {
        doctorList.remove(patient);
    }
        
    
}
