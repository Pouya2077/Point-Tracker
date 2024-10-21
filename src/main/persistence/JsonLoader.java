package persistence;

import org.json.JSONArray;
import org.json.JSONObject;
import model.ApplicationState;
import model.Cart;
import model.Food;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.nio.file.Files;

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
    // we turn into a Restaurant object to return
    public ApplicationState read(String key) throws IOException {
        String data = readFile(sourceFile);
        JSONObject jsonObject = new JSONObject(data);
        return makeApplicationState(jsonObject);
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

    // EFFECTS: creates a Restaurant from the data of the JSONObject
    private ApplicationState makeApplicationState(JSONObject jsonObject) {
        JSONObject restJson = jsonObject.getJSONObject("restaurant");
        JSONObject cartJson = jsonObject.getJSONObject("cart");

        Restaurant restaurant = new Restaurant();
        int points = restJson.getInt("userPoints");
        restaurant.setUserPoints(points);

        Cart cart = new Cart();

        JSONArray cartArray = cartJson.getJSONArray("cart");

        for (Object js: cartArray) {
            JSONObject foodJson = (JSONObject) js;
            
            int pointsToBuy = foodJson.getInt("pointsToBuy");
            double money = foodJson.getDouble("money");
            String name = foodJson.getString("name");
            int pointsWorth = foodJson.getInt("pointsWorth");

            Food food = new Food(name, pointsToBuy, money, pointsWorth);

            cart.addFood(food);
        }

        ApplicationState state = new ApplicationState(restaurant, cart);

        return state;
    }

}
