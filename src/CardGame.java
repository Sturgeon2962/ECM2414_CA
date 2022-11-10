import java.io.Console;

public class CardGame {
    public static void main(String[] args) {
        Console console = System.console();
        
        System.out.println("Please enter the number of players:");
        int numPlayers = -1;
        do {
            // Get user input
            String text = console.readLine();
            try {
                numPlayers = Integer.parseInt(text);
            } catch (NumberFormatException e) {
                System.out.println("That's not a valid number of players");
            }
        } while (numPlayers <= 0);

        System.out.println("Please enter valid pack location:");
        
    }
}
