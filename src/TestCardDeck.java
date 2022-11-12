import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.categories.Category;

public class TestCardDeck {
    public TestCardDeck(){}

    @Test
    public void TestAddCard(){
        CardDeck deck = new CardDeck();
        deck.addCard(new Card(4));
        deck.addCard(new Card(3));
        deck.addCard(new Card(2));
        deck.addCard(new Card(8)); 
        assertEquals(8, deck.getCards().get(deck.getCards().size() -1 ).getDenomination());

    }

    @Test
    public void TestRemoveCard() {
        CardDeck deck = new CardDeck();
        deck.addCard(new Card(4));
        deck.addCard(new Card(3));
        deck.addCard(new Card(2));
        deck.addCard(new Card(8)); 
        assertEquals(4, deck.removeCard().getDenomination());

    }
}
