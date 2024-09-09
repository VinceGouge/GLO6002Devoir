package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class CommunityCenter {
    private Queue<Patient> nurseQueue;
    private TriageType triageType;

    public CommunityCenter(TriageType triageType) {
        this.nurseQueue = new LinkedList<>();
        this.triageType = triageType;
    }

    public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
        // Si patient a CORONAVIRUS,n'ajouté à aucune file
        if (visibleSymptom == VisibleSymptom.CORONAVIRUS) {
            return; // Ne rien faire
        }
        Patient patient = new Patient(name, gravity, VisibleSymptom.NONE);

        // Triage pour file d'attente des consultations infirmières
        if (triageType == TriageType.GRAVITY && gravity > 5) {
            ((LinkedList<Patient>) nurseQueue).addFirst(patient);
        } else {
            nurseQueue.offer(patient);
        }
    }

    public Queue<Patient> getNurseQueue() {
        return nurseQueue;
    }
}

