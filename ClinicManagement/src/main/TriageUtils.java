import java.util.LinkedList;
import java.util.Queue;

public class TriageUtils {
    public static Queue<Patient> fifo(Patient patient, Queue<Patient> queue){
        queue.add(patient);
        return queue;
    }

    public static Queue<Patient> gravity(Patient patient, Queue<Patient> queue){
        int gravityThreshold = 5;
        if (patient.getGravity() <= gravityThreshold){
            queue.add(patient);
            return queue;
        }

        Queue<Patient> prioritizedQueue = new LinkedList<>();
        prioritizedQueue.add(patient);
        prioritizedQueue.addAll(queue);
        return prioritizedQueue;
    }
}
