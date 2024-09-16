package ClinicProject.Sorting;

import ClinicProject.Patient.Patient;

public class SortingListFactory {
    public static SortingList<Patient> createSortingList(TriageType triageType){
        switch (triageType) {
            case FIFO :
                return new SortingList<>();
            default:
                return null;
        }
    }
}
