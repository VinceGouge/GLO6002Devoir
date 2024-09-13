public class Patient {
    private String name;
    private HealthCondition healthCondition;

    public Patient(String _name, int _gravity, VisibleSymptom _visibleSymptom){
        name = _name;
        healthCondition = new HealthCondition(_visibleSymptom, _gravity);
    }

    public boolean NeedsRadiology(){
        return healthCondition.RequiresRadiology();
    }

    public String GetName(){
        return name;
    }
}
