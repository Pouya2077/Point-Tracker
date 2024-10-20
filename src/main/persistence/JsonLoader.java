package persistence;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.nio.file.Files;

import java.util.ArrayList;

import model.Restaurant;
import model.Food;

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
    // we turn into a Restaurant object to return 
    public Restaurant read() throws IOException {
        String data = readFile(sourceFile);
        JSONObject jsonObject = new JSONObject (data);
        return MakeRestaurant(jsonObject);
    }

    // EFFECTS: reads the sourceFile and turns it into data that
    // the JSONObject can use (a single string)
    private String readFile(String sourceFile) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(sourceFile), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString(); 
    }
    // CITATION: the basis for the code in the readFile method was 
    // inspired by the example provided in the phase 2 Edx

    // EFFECTS: creates a Restaurant from the data of the JSONObject
    private Restaurant MakeRestaurant(JSONObject jsonObject) {
        int points = jsonObject.getInt("userPoints");

        Restaurant restaurant = new Restaurant();
        restaurant.setUserPoints(points);

        return restaurant;
    }


}
