import java.util.EnumSet;

public class HealthCondition {
    private VisibleSymptom symptom;
    private int gravity;
    private static final EnumSet<VisibleSymptom> symptomsNeedingRadiology = EnumSet.of(VisibleSymptom.BROKEN_BONE, VisibleSymptom.SPRAIN);

    public HealthCondition(VisibleSymptom _symptom, int _gravity){
        symptom = _symptom;
        gravity = _gravity;
    }

    public boolean RequiresRadiology(){
        return symptomsNeedingRadiology.contains(symptom);
    }
}
