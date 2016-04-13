
import java.io.*;

public class CapitilizationReader extends BufferedReader {
    
    public CapitilizationReader(Reader in) {
        super(in);
    }
    
    @Override
    public String readLine() throws IOException {
        String line = super.readLine();
        if(line != null)
            return line.toUpperCase();
        
        return null;
    }
}