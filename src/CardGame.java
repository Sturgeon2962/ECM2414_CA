import java.io.BufferedReader;
import java.io.Console;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class CardGame {

    public static int numPlayers;
    public static ArrayList<Card> mainDeck;
    public static void main(String[] args) {
        Console console = System.console();
        numPlayers = getNumOfPlayers(console);
        mainDeck = getDeck(console);
    }
    
    public static int getNumOfPlayers(Console console){
        System.out.println("Please enter the number of players:");
        int numPlayers = -1;
        do {
            String text = console.readLine();
            try {
                numPlayers = Integer.parseInt(text);
            } catch (NumberFormatException e) {
                System.out.println("That's not a valid number of players");
            }
        } while (numPlayers <= 0);
        
        return numPlayers;
    }

    public static ArrayList<Card> getDeck(Console console){
        ArrayList<Card> cardNumbers = new ArrayList<>();
        do {
            System.out.println("Please enter valid deck location:");
            String deckLocation = console.readLine();
            try (BufferedReader reader = new BufferedReader(new FileReader(deckLocation))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    cardNumbers.add(new Card(Integer.valueOf(line)));
                }
            } catch (FileNotFoundException e) {
                System.out.println("Hmm, where the file at?");
            } catch (Exception e) {
                // TODO - Tom
            }
        } while (cardNumbers.size() != 8*numPlayers);
        return cardNumbers;
    }
}
