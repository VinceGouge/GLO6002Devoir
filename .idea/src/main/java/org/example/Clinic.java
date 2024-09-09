package org.example;
import java.util.LinkedList;
import java.util.Queue;

public class Clinic {
    private Queue<Patient> doctorQueue;
    private Queue<Patient> radiologyQueue;
    private TriageType doctorTriageType;
    private TriageType radiologyTriageType;

    public Clinic(TriageType doctorTriageType, TriageType radiologyTriageType) {
        this.doctorQueue = new LinkedList<>();
        this.radiologyQueue = new LinkedList<>();
        this.doctorTriageType = doctorTriageType;
        this.radiologyTriageType = radiologyTriageType;
    }

    public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
        // Si patient a CORONAVIRUS, n'est ajouté à aucune file
        if (visibleSymptom == VisibleSymptom.CORONAVIRUS) {
            return; // Ne rien faire
        }
        Patient patient = new Patient(name, gravity, visibleSymptom);

        // Triage pour la file d'attente du médecin
        if (doctorTriageType == TriageType.GRAVITY && gravity > 5) {
            ((LinkedList<Patient>) doctorQueue).addFirst(patient);
        } else {
            // Triage pour la file d'attente du médecin (FIFO)
            doctorQueue.offer(patient);
        }

        // Si patient a fracture ou entorse, ajouter à file radiologie
        if (visibleSymptom == VisibleSymptom.BROKEN_BONE || visibleSymptom == VisibleSymptom.SPRAIN) {
            if (radiologyTriageType == TriageType.GRAVITY && gravity > 5) {
                ((LinkedList<Patient>) radiologyQueue).addFirst(patient);
            } else {
                radiologyQueue.offer(patient);
            }
        }
    }

    public Queue<Patient> getDoctorQueue() {
        return doctorQueue;
    }

    public Queue<Patient> getRadiologyQueue() {
        return radiologyQueue;
    }

    // D'autres méthodes pour gérer les files peuvent être ajoutées
}
