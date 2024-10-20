package persistence;

import model.Restaurant;
import java.io.*;



// Represents a Json writer that will be able to read 
// a file for loading purposes 
public class JsonSaver {

    // MODIFIES: this
    // EFFECTS: constructs a Json writer with the ability
    // to read the data of the application and save it 
    // to a file stored in the data package 
    public JsonSaver(String sourceFile) {
        // TODO - add the constructor 
    }

    // MODIFIES: this
    // EFFECTS: opens the file location to whatever the source
    // file is for saving purposes by preparing writer
    public void open() throws FileNotFoundException {
        // TODO - add implementation
    }

    // MODIFIES: this
    // EFFECTS: writes the Restaurant to the JSON file to save it
    // using the writer
    public void write(Restaurant restaurant) {
        // TODO - add implmentation
    }

    // MODIFIES: this
    // EFFECTS: closes the writer 
    public void close() {
        // TODO - add implementation
    }

}
