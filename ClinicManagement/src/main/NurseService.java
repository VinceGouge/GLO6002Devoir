import java.util.LinkedList;
import java.util.Queue;

public class NurseService implements IService {
    private TriageType triageType;
    private Queue<Patient> queue = new LinkedList<>();

    public NurseService(TriageType _triageType) {
        triageType = _triageType;
    }

    @Override
    public String getName() {
        return "Nurse";
    }

    @Override
    public void triagePatient(Patient patient) {
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
