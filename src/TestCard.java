import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.categories.Category;

public class TestCard {

    public TestCard() {}

    @Test
    public void testDenomination() {
        assertEquals(69, (new Card(69)).getDenomination());
    }
}
