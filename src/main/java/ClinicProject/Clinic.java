package ClinicProject;

import ClinicProject.Patient.Patient;
import ClinicProject.Patient.VisibleSymptom;
import ClinicProject.Sorting.SortingList;
import ClinicProject.Sorting.SortingListFactory;
import ClinicProject.Sorting.TriageType;

public class Clinic {
    private final SortingList<Patient> doctorList;
    private final SortingList<Patient> radioList;
    public Clinic(TriageType doctorListTriageType, TriageType radiotherapyListTriageType) {
        doctorList = SortingListFactory.createSortingList(doctorListTriageType);
        radioList = SortingListFactory.createSortingList(radiotherapyListTriageType);
    }

    public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
        Patient newPatient = new Patient(name, gravity, visibleSymptom);
        doctorList.add(newPatient);
    }

    public Patient NextDoctorPatient() {
        return doctorList.pop();
    }
}
