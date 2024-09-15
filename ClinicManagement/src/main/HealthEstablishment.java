import java.util.ArrayList;
import java.util.List;

public abstract class HealthEstablishment {
    protected List<IService> services = new ArrayList<>();

    public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
        Patient patient = new Patient(name, gravity, visibleSymptom);
        for (IService service : services){
            service.triagePatient(patient);
        }
    }

    public Patient getNextPatient(Class<? extends IService> serviceType){
        for (IService service : services){
            if (service.getClass().equals(serviceType)){
                return service.getNextPatient();
            }
        }

        return null;
    }
}
