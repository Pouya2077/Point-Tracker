package ui;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

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
    private String currentCommand;
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
        label.setFont(new Font("Comic Sans", Font.BOLD, 30));
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

    private void initButtonCommands() {


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
