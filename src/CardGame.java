import java.io.BufferedReader;
import java.io.Console;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class CardGame {
    public static void main(String[] args) {
        Console console = System.console();
        
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

        ArrayList<Integer> cardNumber = new ArrayList<>();
        do {
            System.out.println("Please enter valid deck location:");
            String deckLocation = console.readLine();
            try (BufferedReader reader = new BufferedReader(new FileReader(deckLocation))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    cardNumber.add(Integer.valueOf(line));
                }
            } catch (FileNotFoundException e) {
                System.out.println("Hmm, where the file at?");
            } catch (Exception e) {
                // TODO - Tom
            }
        } while (cardNumber.size() != 8*numPlayers);
    }
}
