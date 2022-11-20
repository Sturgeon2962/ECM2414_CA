import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TestCardDeck {
    CardDeck deck;
    File output;

    public TestCardDeck(){}

    @Before
    public void initialisation() throws IOException {
        deck = new CardDeck(0);
        output = new File("deck0.txt");
    }

    @Test
    public void testCardDeckConstructor() throws IOException {
        assertNotNull(deck);
        assertNotNull(deck.getCards());
        assertEquals(ArrayList.class, deck.getCards().getClass());
    }

    @Test
    public void testAddCard() throws IOException{
        deck.addCard(new Card(4));
        deck.addCard(new Card(3));
        deck.addCard(new Card(2));
        deck.addCard(new Card(8));
        assertEquals(4, deck.getCards().get(0 ).getDenomination());
        assertEquals(8, deck.getCards().get(deck.getCards().size() -1 ).getDenomination());
    }

    @Test
    public void testRemoveCard() throws IOException {
        deck.addCard(new Card(4));
        deck.addCard(new Card(3));
        deck.addCard(new Card(2));
        deck.addCard(new Card(8)); 
        assertEquals(4, deck.removeCard().getDenomination());
        assertEquals(3, deck.getCards().size());
    }

    @Test
    public void testEventOccured() throws IOException {
        for (int i = 0; i < 5; i++) {
            deck.addCard(new Card(i+1));
        }
        EndGameEvent event = new EndGameEvent(deck, "test");
        deck.eventOccured(event);
        BufferedReader reader = new BufferedReader(new FileReader("deck0.txt"));
        assertEquals("deck0 contents: 1 2 3 4 5", reader.readLine());
        reader.close();
    }

    @After
    public void deleteOutput() {
        output.delete();
    }
}
