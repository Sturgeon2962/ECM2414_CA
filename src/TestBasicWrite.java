import org.junit.Test;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestBasicWrite {

    public TestBasicWrite(){}

    @Test
    public void testWriteToFile() throws IOException {
        BasicWrite writer = new BasicWrite("test.txt");
        writer.writeToFile("testing writing to file");
        BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
        assertEquals("testing writing to file", reader.readLine());
        reader.close();
    }
}
