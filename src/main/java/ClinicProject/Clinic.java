package ClinicProject;

import ClinicProject.Patient.Patient;
import ClinicProject.Patient.VisibleSymptom;
import ClinicProject.Sorting.SortingList;

public class Clinic {
    private SortingList<Patient> DoctorList = new SortingList<Patient>();
    public Clinic(/* ... */) {
    }

    public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
        Patient newPatient = new Patient(name, gravity, visibleSymptom);
        DoctorList.add(newPatient);
    }

    public Patient NextDoctorPatient() {
        return DoctorList.pop();
    }
}
