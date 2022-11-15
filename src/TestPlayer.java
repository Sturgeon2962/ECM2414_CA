import org.junit.Test;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TestPlayer {
    
    public TestPlayer() {}

    @Test
    public void testPlayerConstuctor() throws IOException {
        assertNotNull(new Player(1));
    }

    @Test(expected = HandFullException.class)
    public void testAddCard() throws HandFullException, IOException {
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
    public void testRemoveCard() throws HandFullException, IOException {
        Player player = new Player(1);
        player.addCard(new Card(3));
        player.addCard(new Card(5));
        player.addCard(new Card(1));
        player.addCard(new Card(3));
        assertEquals(new Card(5).getDenomination(), player.removeCard(1).getDenomination());
        assertEquals(player.getHand()[1], null);
    }

    @Test
    public void testSelectDiscardCard() throws HandFullException, IOException {
        Player player = new Player(1);
        player.addCard(new Card(1));
        player.addCard(new Card(1));
        player.addCard(new Card(1));
        player.addCard(new Card(2));
        assertEquals(player.getHand()[player.selectDiscardCard()].getDenomination(), new Card(2).getDenomination());
    }

    @Test
    public void testCheckWin() throws HandFullException, IOException{
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

    @Test
    public void testEventOccured() throws IOException, HandFullException {
        Player player = new Player(12);
        EndGameEvent event = new EndGameEvent(player, "test");
        // Test when self wins
        CardGame.setWinner("player 12");
        for (int i = 0; i < 4; i++) {
            player.addCard(new Card(1));
        }
        player.eventOccured(event);
        BufferedReader reader = new BufferedReader(new FileReader("player12.txt"));
        assertEquals("", reader.readLine());
        assertEquals("player 12 wins", reader.readLine());
        assertEquals("player 12 exits", reader.readLine());
        assertEquals("player 12 final hand: 1 1 1 1", reader.readLine());
        reader.close();
        // Test when other wins
        Player player2 = new Player(50);
        for (int i = 0; i < 2; i++) {
            player2.addCard(new Card(1));
            player2.addCard(new Card(2));
        }
        player2.eventOccured(event);
        BufferedReader reader2 = new BufferedReader(new FileReader("player50.txt"));
        assertEquals("", reader2.readLine());
        assertEquals("player 12 has informed player 50 that player 12 has won", reader2.readLine());
        assertEquals("player 50 exits", reader2.readLine());
        assertEquals("player 50 final hand: 1 2 1 2", reader2.readLine());
        reader2.close();
    }

    @Test
    public void testRun() throws IOException, HandFullException {
        CardGame.players = new ArrayList<>();
        CardGame.decks = new ArrayList<>();
        // Test picking up card and then winning
        Player player2 = new Player(32);
        CardGame.players.add(player2);
        CardDeck left = new CardDeck(2);
        CardDeck right = new CardDeck(4);
        left.addCard(new Card(32));
        for (int i = 0; i < 3; i++) {
            player2.addCard(new Card(32));
        }
        player2.addCard(new Card(1));
        player2.setLeftDeck(left);
        player2.setRightDeck(right);
        player2.run();
        assertEquals(0, left.getCards().size());
        assertEquals(1, right.getCards().size());
        BufferedReader reader = new BufferedReader(new FileReader("player32.txt"));
        assertEquals("player 32 initial hand 32 32 32 1", reader.readLine());
        assertEquals("", reader.readLine());
        assertEquals("player 32 draws a 32 from deck2", reader.readLine());
        assertEquals("player 32 discards a 1 to deck4", reader.readLine());
        assertEquals("player 32 current hand is 32 32 32 32", reader.readLine());
        assertEquals("", reader.readLine());
        assertEquals("player 32 wins", reader.readLine());
        assertEquals("player 32 exits", reader.readLine());
        assertEquals("player 32 final hand: 32 32 32 32", reader.readLine());
        reader.close();
    }
}
