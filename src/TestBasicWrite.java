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
    BasicWrite out;

    public TestBasicWrite(){}

    @Before
    public void createOutputFile() throws IOException {
        output = new File("test.txt");
        out = new BasicWrite("test.txt");
    }

    @Test
    public void testBasicWriteConstructor() throws IOException {
        assertNotNull(out);
    }

    @Test
    public void testWriteToFile() throws IOException {
        out.writeToFile("testing writing to file");
        BufferedReader reader = new BufferedReader(new FileReader(output));
        assertEquals("testing writing to file", reader.readLine());
        reader.close();
    }

    @After
    public void deleteOutputFile() {
        output.delete();
    }
}
