public class CommunityCenter extends HealthEstablishment {
    private CommunityCenter() {}

    public static class CommunityCenterBuilder {
        private final CommunityCenter communityCenter;

        public CommunityCenterBuilder() {
            communityCenter = new CommunityCenter();
        }

        public CommunityCenterBuilder withNurseService(TriageType triageType) {
            communityCenter.services.add(new NurseService(triageType));
            return this;
        }

        public CommunityCenter build() {
            return communityCenter;
        }
    }
}
