import org.example.Clinic;
import org.example.TriageType;
import org.example.VisibleSymptom;
import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.assertEquals;

public class ClinicTest {
    @Test
    public void fileESt_initiallementVide() {
        Clinic clinic = new Clinic(TriageType.FIFO, TriageType.FIFO);

        assert clinic.getDoctorQueue().isEmpty() : "Erreur: la file du médecin devrait être vide au départ.";
        assert clinic.getRadiologyQueue().isEmpty() : "Erreur: la file de radiologie devrait être vide au départ.";

        System.out.println("Test réussi: Les files sont initialement vides.");
    }

    @Test
    public void quandPatientOsCassseOuEntorse_devraitAjouterDocEtRadioFiles() {
        Clinic clinic = new Clinic(TriageType.FIFO, TriageType.FIFO);

        clinic.triagePatient("Alice", 5, VisibleSymptom.BROKEN_BONE);

        // Vérif qu'Alice est ajoutée dans la file du médecin
        assert clinic.getDoctorQueue().size() == 1 ;
        // Est-ce necessaire de checker pour rendre le test complet ???
        assert Objects.requireNonNull(clinic.getDoctorQueue().peek()).getName().equals("Alice") ;
        // Vérif qu'Alice est ajoutée dans la file de radiologie
        assert clinic.getRadiologyQueue().size() == 1 ;
        assert Objects.requireNonNull(clinic.getRadiologyQueue().peek()).getName().equals("Alice") ;
    }

    @Test
    public void quandPatientAvecAucunOsSymptome_devraitAjouterFileDocSeulement() {
        Clinic clinic = new Clinic(TriageType.FIFO, TriageType.FIFO);

        clinic.triagePatient("John", 4, VisibleSymptom.MIGRAINE);

        // Vérif patient dans la file du doc seulement
        assert clinic.getDoctorQueue().size() == 1 ;
        assert Objects.requireNonNull(clinic.getDoctorQueue().peek()).getName().equals("John") ;
        // Vérif  file radiologie vide
        assert clinic.getRadiologyQueue().isEmpty() ;
    }

    @Test
    public void quandDeuxPatientsPresent_deuxiemeAvecFluDevraitEtreAjouterSecondDansFileDuDocSeulement() {
        Clinic clinic = new Clinic(TriageType.FIFO, TriageType.FIFO);

        clinic.triagePatient("John", 4, VisibleSymptom.MIGRAINE);
        clinic.triagePatient("Alice", 2, VisibleSymptom.FLU);

        assert clinic.getDoctorQueue().size() == 2 ;
        assert Objects.requireNonNull(clinic.getDoctorQueue().peek()).getName().equals("John");
        assert Objects.requireNonNull(clinic.getDoctorQueue().toArray()[1]).toString().contains("Alice");
        assert clinic.getRadiologyQueue().isEmpty();
    }

    @Test
    public void quandPatientGravitePlusQue5_docTrieParGravite_PatientGraveDevraitEtrePremier() {
        Clinic clinic = new Clinic(TriageType.GRAVITY, TriageType.FIFO);

        clinic.triagePatient("John", 4, VisibleSymptom.MIGRAINE);
        clinic.triagePatient("Alice", 7, VisibleSymptom.FLU);

        // Vérif Alice en tête de la file du doc, car gravité est supérieure à 5
        assert clinic.getDoctorQueue().size() == 2 ;
        assert Objects.requireNonNull(clinic.getDoctorQueue().peek()).getName().equals("Alice") ;
    }

    @Test
    public void quandPatientAvecFractureEtGraviteEleveeArrive_devraitEtrePremierDansDocteurEtDeuxiemeDansRadiologie() {
        Clinic clinic = new Clinic(TriageType.GRAVITY, TriageType.FIFO);

        // Ajouter patient avec symptôme non osseux dans file du doc
        clinic.triagePatient("John", 4, VisibleSymptom.MIGRAINE);
        clinic.triagePatient("Bob", 3, VisibleSymptom.BROKEN_BONE);
        clinic.triagePatient("Alice", 7, VisibleSymptom.BROKEN_BONE);

        // Vérif qu'Alice est en tête de la file du médecin gravité est élevée (trie par gravité)
        assert clinic.getDoctorQueue().size() == 3 ;
        assert Objects.requireNonNull(clinic.getDoctorQueue().peek()).getName().equals("Alice") ;
        // Vérif q'Alice est deuxième dans file de radiologie (FIFO, pas tri par gravité)
        assert clinic.getRadiologyQueue().size() == 2 ;
        assert Objects.requireNonNull(clinic.getRadiologyQueue().toArray()[1]).toString().contains("Alice") ;
    }

    @Test
    public void quandPatientGravitePlusQue5_devraitEtrePremierDansFileDocEtRadiologie() {
        Clinic clinic = new Clinic(TriageType.GRAVITY, TriageType.GRAVITY);

        clinic.triagePatient("John", 4, VisibleSymptom.BROKEN_BONE);
        clinic.triagePatient("Alice", 7, VisibleSymptom.BROKEN_BONE);

        // Vérif Alice est en première dans la file du doc car gravité élevée
        assert Objects.requireNonNull(clinic.getDoctorQueue().peek()).getName().equals("Alice");
        // Vérif Alice est en première dans la file radiologie
        assert Objects.requireNonNull(clinic.getRadiologyQueue().peek()).getName().equals("Alice");
    }

    @Test
    public void quandPatientGraviteInferieureOuEgaleA5_radiologieTrieParGravite_PatientDevraitEtreAjouteEnDernier() {
        Clinic clinic = new Clinic(TriageType.FIFO, TriageType.GRAVITY);

        clinic.triagePatient("John", 4, VisibleSymptom.BROKEN_BONE);
        clinic.triagePatient("Alice", 3, VisibleSymptom.BROKEN_BONE);

        assert Objects.requireNonNull(clinic.getRadiologyQueue().peek()).getName().equals("John");
        assert Objects.requireNonNull(clinic.getRadiologyQueue().toArray()[1]).toString().contains("Alice");
    }

    @Test
    public void quandpPatientAvecCoronavirus_devraitNePasEtreAjoute() {
        Clinic clinic = new Clinic(TriageType.FIFO, TriageType.GRAVITY);

        clinic.triagePatient("Alice", 5, VisibleSymptom.CORONAVIRUS);

        // Vérif que patient pas ajouté dans file des médecins
        assertEquals(0, clinic.getDoctorQueue().size());
        assertEquals(0, clinic.getRadiologyQueue().size());
    }




}
