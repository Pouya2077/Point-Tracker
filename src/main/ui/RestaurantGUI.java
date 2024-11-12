package ui;

import model.*;

import javax.imageio.IIOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Scanner;
import persistence.*;

// Class responsible for being the GUI of application
public class RestaurantGUI {
    private JFrame frame;
    private JPanel mainPanel;
    private JButton menuButton;
    private JButton pointsButton;
    private JButton viewButton;
    private JButton saveButton;
    private JButton loadButton;
    private JButton canBuyButton;
    private JButton totalPointsButton;
    private JButton totalMoneyButton;
    private JButton buyWithPointsButton;
    private JLabel label;

    private ApplicationState state;
    private Restaurant restaurant;
    private Cart cart;
    private ArrayList<Food> menu;

    private JsonLoader loader;
    private JsonSaver saver;
    private Scanner userInput;
    private String saveLocation;


    // MODIFIES: this, all fields
    // EFFECTS: initializes fields of GUI and runs it 
    public RestaurantGUI() {
        init();

        initOperations();

        frame.setVisible(true);

    }

    // MODIFIES: restaurant, cart, state, menu, userInput, 
    // saveLocation, saver, and loader
    // EFFECTS: initializes the fields needed for GUI 
    // backend functionality and operations
    private void initOperations() {
        restaurant = new Restaurant();
        cart = new Cart();
        state = new ApplicationState(restaurant, cart);

        menu = new ArrayList<Food>();
        menu.add(RestaurantApp.FOOD1);
        menu.add(RestaurantApp.FOOD2);
        menu.add(RestaurantApp.FOOD3);
        menu.add(RestaurantApp.FOOD4);

        userInput = new Scanner(System.in);
        userInput.useDelimiter("\r?\n|\r");

        saveLocation = "./data/restaurantApp.json";
        saver = new JsonSaver(saveLocation);
        loader = new JsonLoader(saveLocation);

    }

    // MODIFIES frame, mainPanel, all buttons
    // EFFECTS: initializes the fields of class
    private void init() {
        frame = new JFrame("Tim Horton's Point Tracker!");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        label = new JLabel("Welcome To Timmies!", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 30));
        label.setBorder(BorderFactory.createEmptyBorder(100, 0, 140, 0));
        frame.add(label, BorderLayout.NORTH);

        initButtons();

        mainPanel = new JPanel();
        addInitialButtons();
        frame.add(mainPanel, BorderLayout.CENTER);

    }

    // MODIFIES: all buttons 
    // EFFECTS: initializes all the button fields
    private void initButtons() {
        menuButton = new JButton("Menu");
        pointsButton = new JButton("Current Points");
        viewButton = new JButton("View Cart");;
        saveButton = new JButton("Save");
        loadButton = new JButton("Load Previous");
        canBuyButton = new JButton("Can Buy With Points");
        totalPointsButton = new JButton("Cart Points Worth");
        totalMoneyButton = new JButton("Cart Money Worth");
        buyWithPointsButton = new JButton("Purchase With Points");

        initButtonCommands();

    }

    // MODIFIES: all buttons 
    // EFFECTS: initializes the functions of the buttons
    private void initButtonCommands() {
        pointsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("You have " + restaurant.getUserPoints() + " points.");
            }
        });

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveGUI();
            }
        });

        loadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadGUI();
            }
        });

        canBuyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                purchasables();
            }
        });


    }

    // EFFECTS: displays all the items in the user cart which 
    // can be purchased with the points they currently have
    private void purchasables() {
        ArrayList<String> list = cart.canPurchaseList(restaurant.getUserPoints());
        ArrayList<String> inCart = cart.getFoodNames();

        if (inCart.isEmpty()) {
            label.setText("Your cart is empty.");
        } else if (restaurant.getUserPoints() == 0) {
            label.setText("<html>You have 0 points, <br>nothing is purchasable.</br><html>");
        } else if (list.isEmpty()) {
            label.setText("You cannot purchase anything.");
        } else {
            JTextArea textArea = new JTextArea(10, 5);
            textArea.setEditable(false);

            for (String s: list) {
                textArea.append(s + "\n");
            }
            
            JScrollPane scrollPane = new JScrollPane(textArea);
            JOptionPane.showMessageDialog(null, scrollPane);

        }
    }

    //EFFECTS: loads the previous GUI state 
    private void loadGUI() {
        try {
            state = loader.read();
            restaurant = state.getRestaurant();
            cart = state.getCart();

            label.setText("<html>Successfully loaded <br>from " + saveLocation + ".</br></html>");
        } catch (IOException e) {
            label.setText("<html>Could not read <br>from " + saveLocation + ".</br></html>");

        }
    }

    // EFFECTS: saves the GUI state to appropriate save location
    private void saveGUI() {
        try {
            state.setRestaurant(restaurant);
            state.setCart(cart);

            saver.open();
            saver.write(state);
            saver.close();
            label.setText("<html>Successfully saved <br>to " + saveLocation + ".</br></html>");

        } catch (FileNotFoundException e) {
            label.setText("Unable to save to location " + saveLocation + ".");
        }
    }

    // MODIFIES: mainPanel
    // EFFECTS: adds the buttons to the panel
    private void addInitialButtons() {
        mainPanel.add(menuButton);
        mainPanel.add(pointsButton);
        mainPanel.add(viewButton);
        mainPanel.add(saveButton);
        mainPanel.add(loadButton);
        mainPanel.add(canBuyButton);
        mainPanel.add(totalPointsButton);
        mainPanel.add(totalMoneyButton);
        mainPanel.add(buyWithPointsButton);

    }

}
