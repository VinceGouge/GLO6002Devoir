import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ClinicTests {
    @Test
    public void patientWithMigraine_triagePatient_isAddedToDoctorQueue(){
        Clinic clinic = new Clinic.ClinicBuilder()
                .withService(new DoctorService(TriageType.FIFO))
                .withService(new RadiologyService(TriageType.FIFO))
                .build();

        String patientName = "Bob";

        clinic.triagePatient(patientName, 965, VisibleSymptom.MIGRAINE);

        Patient nextDoctorPatient = clinic.getNextDoctorPatient();
        assertEquals(patientName, nextDoctorPatient.getName());
    }

    @Test
    public void patientWithMigraine_triagePatient_isNotAddedToRadiologyQueue(){
        Clinic clinic = new Clinic.ClinicBuilder()
                .withService(new DoctorService(TriageType.FIFO))
                .withService(new RadiologyService(TriageType.FIFO))
                .build();

        String patientName = "Bob";

        clinic.triagePatient(patientName, 965, VisibleSymptom.MIGRAINE);

        Patient nextRadiologyPatient = clinic.getNextRadiologyPatient();
        assertNull(nextRadiologyPatient);
    }

    @Test
    public void patientWithBrokenBone_triagePatient_isAddedToDoctorQueue(){
        Clinic clinic = new Clinic.ClinicBuilder()
                .withService(new DoctorService(TriageType.FIFO))
                .withService(new RadiologyService(TriageType.FIFO))
                .build();

        String patientName = "Bob";

        clinic.triagePatient(patientName, 764, VisibleSymptom.BROKEN_BONE);

        Patient nextDoctorPatient = clinic.getNextDoctorPatient();
        assertEquals(patientName, nextDoctorPatient.getName());
    }

    @Test
    public void patientWithBrokenBone_triagePatient_isAddedToRadiologyQueue(){
        Clinic clinic = new Clinic.ClinicBuilder()
                .withService(new DoctorService(TriageType.FIFO))
                .withService(new RadiologyService(TriageType.FIFO))
                .build();

        String patientName = "Bob";

        clinic.triagePatient(patientName, 764, VisibleSymptom.BROKEN_BONE);

        Patient nextRadiologyPatient = clinic.getNextRadiologyPatient();
        assertEquals(patientName, nextRadiologyPatient.getName());
    }

    @Test
    public void patientWithSprain_triagePatient_isAddedToDoctorQueue(){
        Clinic clinic = new Clinic.ClinicBuilder()
                .withService(new DoctorService(TriageType.FIFO))
                .withService(new RadiologyService(TriageType.FIFO))
                .build();

        String patientName = "Bob";

        clinic.triagePatient(patientName, 764, VisibleSymptom.SPRAIN);

        Patient nextDoctorPatient = clinic.getNextDoctorPatient();
        assertEquals(patientName, nextDoctorPatient.getName());
    }

    @Test
    public void patientWithSprain_triagePatient_isAddedToRadiologyQueue(){
        Clinic clinic = new Clinic.ClinicBuilder()
                .withService(new DoctorService(TriageType.FIFO))
                .withService(new RadiologyService(TriageType.FIFO))
                .build();

        String patientName = "Bob";

        clinic.triagePatient(patientName, 764, VisibleSymptom.SPRAIN);

        Patient nextRadiologyPatient = clinic.getNextRadiologyPatient();
        assertEquals(patientName, nextRadiologyPatient.getName());
    }

    @Test
    public void doctorQueueNotEmpty_newPatientWithHighGravity_newPatientIsFirstInDoctorQueue(){
        Clinic clinic = new Clinic.ClinicBuilder()
                .withService(new DoctorService(TriageType.GRAVITY))
                .build();

        String firstPatientName = "First";
        String secondPatientName = "Second";

        clinic.triagePatient(firstPatientName, 764, VisibleSymptom.SPRAIN);
        clinic.triagePatient(secondPatientName, 7, VisibleSymptom.FLU);

        Patient nextDoctorPatient = clinic.getNextDoctorPatient();
        assertEquals(secondPatientName, nextDoctorPatient.getName());
    }

    @Test
    public void radiologyFIFOQueueNotEmpty_newPatientWithHighGravity_newPatientIsNotFirstInRadioQueue(){
        Clinic clinic = new Clinic.ClinicBuilder()
                .withService(new DoctorService(TriageType.GRAVITY))
                .withService(new RadiologyService(TriageType.FIFO))
                .build();

        String firstPatientName = "First";
        String secondPatientName = "Second";

        clinic.triagePatient(firstPatientName, 764, VisibleSymptom.SPRAIN);
        clinic.triagePatient(secondPatientName, 7, VisibleSymptom.BROKEN_BONE);

        Patient nextRadioPatient = clinic.getNextRadiologyPatient();
        Patient secondRadioPatient = clinic.getNextRadiologyPatient();

        assertNotEquals(secondPatientName, nextRadioPatient.getName());
        assertEquals(secondPatientName, secondRadioPatient.getName());
    }

    @Test
    public void radiologyGravityQueueNotEmpty_newPatientWithHighGravity_newPatientIsFirstInRadioQueue(){
        Clinic clinic = new Clinic.ClinicBuilder()
                .withService(new DoctorService(TriageType.GRAVITY))
                .withService(new RadiologyService(TriageType.GRAVITY))
                .build();

        String firstPatientName = "First";
        String secondPatientName = "Second";

        clinic.triagePatient(firstPatientName, 764, VisibleSymptom.SPRAIN);
        clinic.triagePatient(secondPatientName, 7, VisibleSymptom.BROKEN_BONE);
        Patient nextRadioPatient = clinic.getNextRadiologyPatient();

        assertEquals(secondPatientName, nextRadioPatient.getName());
    }
}
