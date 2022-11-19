import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class TestCardGame {
    public TestCardGame(){}

    @Test
    public void testSetPlayerDecks() throws IOException{

        Player player1 = new Player(1);
        Player player2 = new Player(2);

        CardDeck deck1 = new CardDeck(1);
        CardDeck deck2 = new CardDeck(2);
        
        CardGame.numPlayers = 2;
        CardGame.decks = new ArrayList<>();
        CardGame.decks.add(deck1);
        CardGame.decks.add(deck2);
        CardGame.players = new ArrayList<>();
        CardGame.players.add(player1);
        CardGame.players.add(player2);
        CardGame.setPlayerDecks();

        assertEquals(deck1, player1.getLeftDeck());
        assertEquals(deck2, player1.getRightDeck());
        assertEquals(deck2, player2.getLeftDeck());
        assertEquals(deck1, player2.getRightDeck());
    }

    @Test
    public void testDealCard(){
        CardGame.mainDeck = new ArrayList<>();
        CardGame.mainDeck.add(new Card(1));
        assertEquals(1, CardGame.dealCard().getDenomination());
        assertEquals(0,CardGame.mainDeck.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDealCardException() {
        CardGame.mainDeck = new ArrayList<>();

        CardGame.dealCard();
    }

    @Test
    public void testDealCards() throws IOException, HandFullException{
        CardGame.numPlayers = 2;

        CardGame.players = new ArrayList<>();
        CardGame.players.add(new Player(0));
        CardGame.players.add(new Player(1));
        
        CardGame.decks = new ArrayList<>();
        CardGame.decks.add(new CardDeck(0));
        CardGame.decks.add(new CardDeck(1));
        
        CardGame.mainDeck = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            CardGame.mainDeck.add(new Card(i+1));
        }

        CardGame.dealCards();

        assertEquals(false, Arrays.asList(CardGame.players.get(0)).contains(null));
        assertEquals(4, CardGame.decks.get(0).getCards().size());
        assertEquals(false, Arrays.asList(CardGame.players.get(1)).contains(null));
        assertEquals(4, CardGame.decks.get(1).getCards().size());
    }
}
