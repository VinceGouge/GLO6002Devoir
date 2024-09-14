import java.util.LinkedList;
import java.util.Queue;

public class DoctorService implements IService{
    private TriageType triageType;
    private Queue<Patient> queue = new LinkedList<>();

    public DoctorService(TriageType _triageType){
        triageType = _triageType;
    }

    @Override
    public String getName() {
        return "Doctor";
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
