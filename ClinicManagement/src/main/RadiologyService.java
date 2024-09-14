import java.util.LinkedList;
import java.util.Queue;

public class RadiologyService implements IService{
    private TriageType triageType;
    private Queue<Patient> queue = new LinkedList<>();

    public RadiologyService(TriageType _triageType){
        triageType = _triageType;
    }

    @Override
    public String getName() {
        return "Radiology";
    }

    @Override
    public void triagePatient(Patient patient) {
        if (!patient.needsRadiology()){
            return;
        }

        if (triageType == TriageType.FIFO){
            queue = TriageUtils.fifo(patient, queue);
        } else if (triageType == TriageType.GRAVITY) {
            queue = TriageUtils.gravity(patient, queue);
        }
    }

    @Override
    public Patient getNextPatient() {
        return queue.poll();
    }
}
