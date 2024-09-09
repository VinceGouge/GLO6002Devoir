package org.example;

public class Patient {
    private final String name;
    private final int gravity;
    private final VisibleSymptom visibleSymptom;

    public Patient(String name, int gravity, VisibleSymptom visibleSymptom) {
        this.name = name;
        this.gravity = gravity;
        this.visibleSymptom = visibleSymptom;
    }

    public String getName() {
        return name;
    }

    public int getGravity() {
        return gravity;
    }

    public VisibleSymptom getVisibleSymptom() {
        return visibleSymptom;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", gravity=" + gravity +
                ", visibleSymptom=" + visibleSymptom +
                '}';
    }
}

