import org.junit.Test;
import static org.junit.Assert.*;

public class TestCard {

    public TestCard() {}

    @Test
    public void testDenomination() {
        assertEquals(69, (new Card(69)).getDenomination());
    }
}
