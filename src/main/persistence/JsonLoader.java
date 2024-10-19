package persistence;

import java.io.IOException;

import org.json.JSONObject;

import model.Restaurant;

// Represents a Json loader, which will read a saved
// json source file for its saved Restaurant
public class JsonLoader {
    String sourceFile;

    // MODIFIES: this
    // EFFECTS: constructs a Json reader that 
    // can read from the given file 
    public JsonLoader(String sourceFile) {
        this.sourceFile = sourceFile;
        
    }

    // EFFECTS: reads the data from the source file 
    // into a string, the string becomes a JSONObject which
    // we then resolve to a Restaurant to return 
    public Restaurant read() throws IOException {
        String data = readFile(sourceFile);
        JSONObject jsonObject = new JSONObject (data);
        return MakeRestaurant(jsonObject);
    }

    private String readFile(String sourceFile2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readFile'");
    }

    private Restaurant MakeRestaurant(JSONObject jsonObject) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'MakeRestaurant'");
    }


}
