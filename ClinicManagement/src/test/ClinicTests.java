import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ClinicTests {
    @Test
    public void patientWithMigraine_triagePatient_isAddedToDoctorQueue(){
        Clinic clinic = new Clinic(TriageType.FIFO);
        String patientName = "Bob";

        clinic.triagePatient(patientName, 965, VisibleSymptom.MIGRAINE);

        Patient nextDoctorPatient = clinic.GetNextDoctorPatient();
        assertEquals(patientName, nextDoctorPatient.GetName());
    }

    @Test
    public void patientWithMigraine_triagePatient_isNotAddedToRadiologyQueue(){
        Clinic clinic = new Clinic(TriageType.FIFO);
        String patientName = "Bob";

        clinic.triagePatient(patientName, 965, VisibleSymptom.MIGRAINE);

        Patient nextRadiologyPatient = clinic.GetNextRadiologyPatient();
        assertNull(nextRadiologyPatient);
    }

    @Test
    public void patientWithBrokenBone_triagePatient_isAddedToDoctorQueue(){
        Clinic clinic = new Clinic(TriageType.FIFO);
        String patientName = "Bob";

        clinic.triagePatient(patientName, 764, VisibleSymptom.BROKEN_BONE);

        Patient nextDoctorPatient = clinic.GetNextDoctorPatient();
        assertEquals(patientName, nextDoctorPatient.GetName());
    }

    @Test
    public void patientWithBrokenBone_triagePatient_isAddedToRadiologyQueue(){
        Clinic clinic = new Clinic(TriageType.FIFO);
        String patientName = "Bob";

        clinic.triagePatient(patientName, 764, VisibleSymptom.BROKEN_BONE);

        Patient nextRadiologyPatient = clinic.GetNextRadiologyPatient();
        assertEquals(patientName, nextRadiologyPatient.GetName());
    }

    @Test
    public void patientWithSprain_triagePatient_isAddedToDoctorQueue(){
        Clinic clinic = new Clinic(TriageType.FIFO);
        String patientName = "Bob";

        clinic.triagePatient(patientName, 764, VisibleSymptom.SPRAIN);

        Patient nextDoctorPatient = clinic.GetNextDoctorPatient();
        assertEquals(patientName, nextDoctorPatient.GetName());
    }

    @Test
    public void patientWithSprain_triagePatient_isAddedToRadiologyQueue(){
        Clinic clinic = new Clinic(TriageType.FIFO);
        String patientName = "Bob";

        clinic.triagePatient(patientName, 764, VisibleSymptom.SPRAIN);

        Patient nextRadiologyPatient = clinic.GetNextRadiologyPatient();
        assertEquals(patientName, nextRadiologyPatient.GetName());
    }
}
