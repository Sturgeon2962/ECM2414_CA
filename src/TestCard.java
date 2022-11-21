import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;

public class TestCard {
    Card card;

    public TestCard() {}

    @Before
    public void createCard() {
        card = new Card(5);
    }

    @Test
    public void testCardConstructor() {
        assertNotNull(card);
        assertEquals(5, card.getDenomination());
    }

    @Test
    public void testDenomination() {
        assertEquals(5, card.getDenomination());
    }
}
