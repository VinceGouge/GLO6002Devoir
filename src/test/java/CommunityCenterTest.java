import org.example.CommunityCenter;
import org.example.TriageType;
import org.example.VisibleSymptom;
import org.junit.Test;
import static org.junit.Assert.*;

public class CommunityCenterTest {

    @Test
    public void patientAvecCoronavirus_devraitNePasEtreAjouteDansCommunityCenter() {
        CommunityCenter center = new CommunityCenter(TriageType.GRAVITY);

        center.triagePatient("Alice", 5, VisibleSymptom.CORONAVIRUS);

        assertEquals(0, center.getNurseQueue().size());
    }

    @Test
    public void patientSansCoronavirus_devraitEtreAjouteDansCommunityCenter() {
        CommunityCenter center = new CommunityCenter(TriageType.FIFO);

        center.triagePatient("John", 4, VisibleSymptom.FLU);

        assertEquals(1, center.getNurseQueue().size());
        assertEquals("John", center.getNurseQueue().peek().getName());
    }
}
