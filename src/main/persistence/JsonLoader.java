package persistence;

import java.io.IOException;
import model.Restaurant;

// Represents a Json reader that will be able to 
// read a file for saving purposes 
public class JsonLoader {

    // MODIFIES: this
    // EFFECTS: constructs a Json reader that 
    // can read from the given file 
    public JsonLoader(String sourceFile) {
        // TODO - create constructor 
    }

    // EFFECTS: reads the data from the source file 
    // and loads it for the program
    public Restaurant read() throws IOException {
        return new Restaurant(); 
        // TODO - create reading capabilities
    }

}
