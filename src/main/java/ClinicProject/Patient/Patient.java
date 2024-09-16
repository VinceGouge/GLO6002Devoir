package ClinicProject.Patient;

public class Patient {
    private final String name ;
    private final int  gravity;
    private final VisibleSymptom symptom;

    public Patient(String patientName, int patientGravity, VisibleSymptom patientSymptom){
        name = patientName;
        gravity = patientGravity;
        symptom = patientSymptom;
    }

    public VisibleSymptom getSymptom() {
        return symptom;
    }
}

