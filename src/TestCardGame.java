import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.Console;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.junit.experimental.categories.Category;

public class TestCardGame {
    
    public TestCardGame() {}

    @Test
    public void testNumberOfPlayers() throws FileNotFoundException {
        InputStream prev = System.in;
        InputStream newStream = new FileInputStream("../src/playerInputsTest.txt");
        System.setIn(newStream);
        try {
            Console console = System.console();
            assertEquals(4, CardGame.getNumOfPlayers(console));
        } finally {
            System.setIn(prev);
        }
    }
}
