package ClinicProject.Patient;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PatientTest {

    @Test
    void PatientHaveVisibleSymptom(){
        Patient patient = new Patient("Bill", 0, VisibleSymptom.CORONAVIRUS);
        assertEquals(patient.getSymptom(), VisibleSymptom.CHEST_PAIN);
    }
}
