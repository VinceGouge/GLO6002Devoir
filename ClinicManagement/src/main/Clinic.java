import java.util.LinkedList;
import java.util.Queue;

public class Clinic {
    public Clinic(TriageType _triageType) {
        triageType = _triageType;
    }

    public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
        Patient patient = new Patient(name, gravity, visibleSymptom);
        doctorWaitingList.add(patient);
        if (patient.NeedsRadiology()){
            radiologyWaitingList.add(patient);
        }
    }

    public Patient GetNextDoctorPatient(){
        return doctorWaitingList.poll();
    }

    public Patient GetNextRadiologyPatient(){
        return radiologyWaitingList.poll();
    }

    private TriageType triageType;
    private Queue<Patient> doctorWaitingList = new LinkedList<Patient>();
    private Queue<Patient> radiologyWaitingList = new LinkedList<Patient>();
}
