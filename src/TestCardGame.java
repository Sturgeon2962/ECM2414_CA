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
}
