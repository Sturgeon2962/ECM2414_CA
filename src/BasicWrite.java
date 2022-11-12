import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BasicWrite {

    private BufferedWriter out;
    
    BasicWrite(String filename) throws IOException {
        this.out = new BufferedWriter( new FileWriter( filename ) );
    }

    /**
     * Writes the given text to the file.
     * 
     * @param message to be written
     * @throws IOException
     */
    protected void writeToFile(String message) throws IOException {
        this.out.write(message);
        this.out.newLine();
        this.out.flush();
    }
}
