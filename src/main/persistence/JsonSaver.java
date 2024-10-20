package persistence;

import model.Restaurant;
import java.io.*;

import org.json.JSONObject;

// Represents a Json writer that will be able to read 
// a file for loading purposes 
public class JsonSaver {
    private String sourceFile;
    private PrintWriter writer;

    // MODIFIES: this
    // EFFECTS: constructs a Json writer with the ability
    // to read the data of the application and save it
    // to a file stored in the data package
    public JsonSaver(String sourceFile) {
        this.sourceFile = sourceFile;

    }

    // MODIFIES: this
    // EFFECTS: opens the file location to whatever the source
    // file is for saving purposes by preparing writer
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(sourceFile));

    }

    // MODIFIES: this
    // EFFECTS: writes the Restaurant to the JSON file to save it
    // using the writer
    public void write(Restaurant restaurant) {
        JSONObject json = restaurant.toJson();
        saveToFile(json.toString());

    }

    // MODIFIES: this
    // EFFECTS: closes the writer
    public void close() {
        writer.close();

    }

    // MODIFIES: this
    // EFFECTS: writes the json file as a string to the give location
    private void saveToFile(String jsonString) {
        writer.print(jsonString);
    }

}
