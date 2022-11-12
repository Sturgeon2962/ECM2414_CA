import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.categories.Category;

public class TestPlayer {
    
    public TestPlayer() {}

    @Test
    public void TestPlayerConstuctor() {
        assertNotNull(new Player(1));
    }

    @Test(expected = HandFullException.class)
    public void TestAddCard() throws HandFullException {
        Player player = new Player(1);
        player.addCard(new Card(3));
        player.addCard(new Card(3));
        player.addCard(new Card(1));
        player.addCard(new Card(3));
        assertEquals(new Card(1).getDenomination(), player.getHand()[2].getDenomination());
        player.removeCard(2);
        player.addCard(new Card(8));
        assertEquals(new Card(8).getDenomination(), player.getHand()[2].getDenomination());
        player.addCard(new Card(3));
    }

    @Test
    public void TestRemoveCard() throws HandFullException {
        Player player = new Player(1);
        player.addCard(new Card(3));
        player.addCard(new Card(5));
        player.addCard(new Card(1));
        player.addCard(new Card(3));
        assertEquals(new Card(5).getDenomination(), player.removeCard(1).getDenomination());
        assertEquals(player.getHand()[1], null);
    }

    @Test
    public void TestSelectDiscardCard() throws HandFullException {
        Player player = new Player(1);
        player.addCard(new Card(1));
        player.addCard(new Card(1));
        player.addCard(new Card(1));
        player.addCard(new Card(2));
        assertEquals(player.getHand()[player.selectDiscardCard()].getDenomination(), new Card(2).getDenomination());
    }

    @Test
    public void TestWin() throws HandFullException{
        Player player = new Player(0);
        player.addCard(new Card(1));
        player.addCard(new Card(1));
        player.addCard(new Card(1));
        player.addCard(new Card(1));
        assertEquals(true, player.checkWin());
        player.removeCard(0);
        player.addCard(new Card(4));
        assertEquals(false, player.checkWin());
        // Check if called when hand not full
        player.removeCard(1);
        assertEquals(false, player.checkWin());
        player.removeCard(0);
        assertEquals(false, player.checkWin());
    }
}
