import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private List<IService> services;

    private Clinic(ClinicBuilder clinicBuilder) {
        services = clinicBuilder.services;
    }

    public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
        Patient patient = new Patient(name, gravity, visibleSymptom);
        for (IService service : services){
            service.triagePatient(patient);
        }
    }

    public Patient getNextDoctorPatient(){
        for (IService service : services){
            if (service instanceof DoctorService){
                return service.getNextPatient();
            }
        }

        return null;
    }

    public Patient getNextRadiologyPatient(){
        for (IService service : services){
            if (service instanceof RadiologyService){
                return service.getNextPatient();
            }
        }

        return null;
    }

    public static class ClinicBuilder {
        private final List<IService> services = new ArrayList<>();

        public ClinicBuilder() {}

        public ClinicBuilder withService(IService service){
            services.add(service);
            return this;
        }

        public Clinic build(){
            return new Clinic(this);
        }
    }
}
