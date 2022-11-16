import org.junit.Test;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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

    @Test
    public void testDealCards() throws IOException, HandFullException{
        CardGame.players = new ArrayList<>();
        CardGame.players.add(new Player(0));
        
        CardGame.decks = new ArrayList<>();
        CardGame.decks.add(new CardDeck(0));
        
        CardGame.mainDeck = new ArrayList<>();
        CardGame.mainDeck.add(new Card(1));
        CardGame.mainDeck.add(new Card(4));
        CardGame.mainDeck.add(new Card(2));
        CardGame.mainDeck.add(new Card(3));
        CardGame.mainDeck.add(new Card(5));
        CardGame.mainDeck.add(new Card(6));
        CardGame.mainDeck.add(new Card(7));
        CardGame.mainDeck.add(new Card(8));
        CardGame.mainDeck.add(new Card(9));
        CardGame.mainDeck.add(new Card(10));

        CardGame.dealCards();

        assertEquals(4, CardGame.players.get(0).getHand().length);
        assertEquals(4, CardGame.decks.get(0).getCards().size());
    }
}
