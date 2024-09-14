public interface IService {
    String getName();
    void triagePatient(Patient patient);
    Patient getNextPatient();
}
