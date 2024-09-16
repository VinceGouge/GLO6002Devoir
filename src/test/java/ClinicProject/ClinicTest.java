package ClinicProject;

import ClinicProject.Patient.Patient;
import ClinicProject.Patient.VisibleSymptom;
import ClinicProject.Sorting.TriageType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClinicTest {

    @Test
    void WhenCreateClinic_EachMedicalServiceHaveEmptyList() {
        Clinic C1 = new Clinic(TriageType.FIFO, TriageType.FIFO);
    }

    @Test
    void WhenPatientArrivesAtTheClinicThenAddToDoctorList() {
        Clinic C1 = new Clinic(TriageType.FIFO, TriageType.FIFO);
        C1.triagePatient("One", 0, VisibleSymptom.COLD);

        assertEquals(C1.NextDoctorPatient(), new Patient("One", 0, VisibleSymptom.COLD));
    }


}