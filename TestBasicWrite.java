import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TestBasicWrite {
    File output;

    public TestBasicWrite(){}

    @Before
    public void createOutputFile() {
        output = new File("test.txt");
    }

    @Test
    public void testBasicWriteConstructor() throws IOException {
        BasicWrite out = new BasicWrite("test.txt");
        assertNotNull(out);
    }

    @Test
    public void testWriteToFile() throws IOException {
        BasicWrite writer = new BasicWrite("test.txt");
        writer.writeToFile("testing writing to file");
        BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
        assertEquals("testing writing to file", reader.readLine());
        reader.close();
    }

    @After
    public void deleteOutputFile() {
        output.delete();
    }
}
