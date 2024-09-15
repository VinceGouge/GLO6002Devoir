public class Patient {
    private String name;
    private HealthCondition healthCondition;

    public Patient(String _name, int _gravity, VisibleSymptom _visibleSymptom){
        name = _name;
        healthCondition = new HealthCondition(_visibleSymptom, _gravity);
    }

    public boolean needsRadiology(){
        return healthCondition.requiresRadiology();
    }

    public int getGravity(){
        return healthCondition.getGravity();
    }

    public String getName(){
        return name;
    }

    public boolean hasCovid() {
        return healthCondition.getSymptom() == VisibleSymptom.CORONAVIRUS;
    }
}
