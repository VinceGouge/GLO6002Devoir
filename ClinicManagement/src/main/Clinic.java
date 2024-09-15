public class Clinic extends HealthEstablishment {
    private Clinic() {}

    public static class ClinicBuilder {
        private Clinic clinic;

        public ClinicBuilder() {
            clinic = new Clinic();
        }

        public ClinicBuilder withDoctorService(TriageType triageType) {
            clinic.services.add(new DoctorService(triageType));
            return this;
        }

        public ClinicBuilder withRadiologyService(TriageType triageType) {
            clinic.services.add(new RadiologyService(triageType));
            return this;
        }

        public Clinic build() {
            return clinic;
        }
    }
}
