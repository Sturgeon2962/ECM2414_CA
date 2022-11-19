import org.junit.Test;
import static org.junit.Assert.*;

public class TestCard {

    public TestCard() {}

    @Test
    public void testCardConstructor() {
        Card card = new Card(5);
        assertNotNull(card);
        assertEquals(5, card.getDenomination());
    }

    @Test
    public void testDenomination() {
        assertEquals(69, (new Card(69)).getDenomination());
    }
}
