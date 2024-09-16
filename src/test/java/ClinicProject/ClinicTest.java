package ClinicProject;

import ClinicProject.Patient.Patient;
import ClinicProject.Patient.VisibleSymptom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClinicTest {

    @Test
    void WhenPatientArrivesAtTheClinicThenAddToDoctorList() {
        Clinic C1 = new Clinic();
        C1.triagePatient("One", 0, VisibleSymptom.COLD);

        assertEquals(C1.NextDoctorPatient(), new Patient("One", 0, VisibleSymptom.COLD));
    }


}