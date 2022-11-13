import java.io.BufferedReader;
import java.io.Console;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class CardGame {

    public static int numPlayers;
    public static ArrayList<Card> mainDeck;
    public static ArrayList<Player> players;
    public static ArrayList<CardDeck> decks;
    public static String winner;

    public static String getWinner() {
		return winner;
	}

	public static void setWinner(String winner) {
		CardGame.winner = winner;
	}

	public static void main(String[] args) throws IOException {
        Console console = System.console();
        numPlayers = getNumOfPlayers(console);
        mainDeck = getDeck(console);

        // Create players and decks
        players = new ArrayList<>();
        decks = new ArrayList<>();
        for (int x = 0; x < numPlayers; x++){
            players.add(new Player(x+1));
            decks.add(new CardDeck(x+1));
        }
        setPlayerDecks();

        Collections.shuffle(mainDeck);
        
        try {
            dealCards();
        } catch (HandFullException | IndexOutOfBoundsException e) {
            System.out.println("Error whilst dealing cards");
        }

        // Start the chaos
        for (Player player : players) {
            player.start();
        }
    }

    public static void setPlayerDecks() {
        for (Player player : players) {
            player.setLeftDeck(decks.get(player.getNumber()-1));
            player.setRightDeck(decks.get((player.getNumber())%numPlayers));
        }
    }

    /**
     * Deals a card from the top of the main deck.
     * 
     * @return Card from top of the main deck
     * @throws IndexOutOfBoundsException if the main deck is empty
     */
    public static Card dealCard() throws IndexOutOfBoundsException {
        return mainDeck.remove(0);
    }

    /**
     * Deals cards to all players and decks in a loop.
     * 
     * @throws HandFullException if any of the players hands are full
     */
    public static void dealCards() throws HandFullException {
        for (int i = 0; i < numPlayers; i++) {
            for (int j = 0; j < numPlayers; j++) {
                players.get(j).addCard(dealCard());
            }
            for (int j = 0; j < numPlayers; j++) {
                decks.get(j).addCard(dealCard());
            }
        }
    }
    
    /**
     * Takes the input for the number of players.
     * (Checks for valid number - >1)
     * 
     * @param console to take input from
     * @return An int of the number of players in the game
     */
    public static int getNumOfPlayers(Console console){
        System.out.println("Please enter the number of players:");
        int numPlayers = -1;
        do {
            String text = console.readLine();
            try {
                numPlayers = Integer.parseInt(text);
                if (numPlayers <= 1) {
                    System.out.println("The minimum number of players is 2");
                }
            } catch (NumberFormatException e) {
                // User input not integer
                System.out.println("That's not a valid number");
            }
        } while (numPlayers <= 1);
        
        return numPlayers;
    }

    /**
     * Creates the crad deck from user specified file.
     * 
     * @param console to take input from
     * @return An ArrayList<Card> containing all cards for the game
     */
    public static ArrayList<Card> getDeck(Console console){
        ArrayList<Card> cardNumbers = new ArrayList<>();
        System.out.println("Please enter valid deck location:");
        do {
            String deckLocation = console.readLine();
            // Read file line by line, creating cards with the values from each line
            try (BufferedReader reader = new BufferedReader(new FileReader(deckLocation))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    cardNumbers.add(new Card(Integer.valueOf(line)));
                }
            } catch (FileNotFoundException e) {
                System.out.println("File could not be found");
            } catch (IOException e) {
                System.out.println("An error has occured when attmpting to retrive data from file");
            }
        } while (cardNumbers.size() != 8*numPlayers);

        return cardNumbers;
    }
}

