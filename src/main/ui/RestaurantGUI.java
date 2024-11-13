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
    private JLabel label;

    private JButton menuButton;
    private JButton pointsButton;
    private JButton viewButton;
    private JButton saveButton;
    private JButton loadButton;
    private JButton canBuyButton;
    private JButton totalPointsButton;
    private JButton totalMoneyButton;
    private JButton buyWithPointsButton;

    private JButton backButton;
    private JButton cappButton;
    private JButton coffeeButton;
    private JButton bagelButton;
    private JButton bitsButton;

    private JButton yesButton;
    private JButton noButton;

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
        viewButton = new JButton("View Cart");
        saveButton = new JButton("Save");
        loadButton = new JButton("Load Previous");
        canBuyButton = new JButton("Can Buy With Points");
        totalPointsButton = new JButton("Cart Points Worth");
        totalMoneyButton = new JButton("Cart Money Worth");
        buyWithPointsButton = new JButton("Purchase With Points");

        backButton = new JButton("Back");
        cappButton = new JButton("Ice Capp");
        coffeeButton = new JButton("Coffee");
        bagelButton = new JButton("Bagel");
        bitsButton = new JButton("Tim Bits");

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

        initSerializers();

        canBuyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                purchasables();
            }
        });

        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewCart();
            }
        });

        initWorthFunctions();

        buyWithPointsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                purchaseWithPoints();
            }
        });

        initComplexCommands();

    }

    // MODIFIES: add, menu, remove, an buy with money buttons
    // EFFECTS: adds functionality for the complex buttons
    private void initComplexCommands() {
        menuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayOptions();
            }
        });

    }

    // EFFECTS: displays the menu options of the restaurant
    private void displayOptions() {
        mainPanel.removeAll();
        label.setText("Our Menu...");

        initMenuCommands();

        mainPanel.add(backButton);
        mainPanel.add(cappButton);
        mainPanel.add(coffeeButton);
        mainPanel.add(bagelButton);
        mainPanel.add(bitsButton);

        mainPanel.revalidate();
        mainPanel.repaint();

    }

    // EFFECTS: adds the menu button commands
    private void initMenuCommands() {
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                addInitialButtons();
                mainPanel.revalidate();
                mainPanel.repaint();
                label.setText("Welcome to Timmies!");
            }
        });

        foodCommands();
    }

    // EFFECTS: add commands for food buttons of menu
    private void foodCommands() {
        cappButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                optionToAdd(RestaurantApp.FOOD1);
            }
        });

        coffeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                optionToAdd(RestaurantApp.FOOD2);
            }
        });

        bagelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                optionToAdd(RestaurantApp.FOOD3);
            }
        });

        bitsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                optionToAdd(RestaurantApp.FOOD4);
            }
        });
    }

    // EFFECTS: give the user the option to add the given food
    // to their cart with a pop up
    private void optionToAdd(Food food) {
        JOptionPane optionPane = new JOptionPane("What would you like to do?",
                JOptionPane.QUESTION_MESSAGE);

        yesButton = new JButton("Add");
        noButton = new JButton("Remove");

        JDialog dialog = optionPane.createDialog(null, "Add or Remove " + food.getName());

        yesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText(food.getName() + " added!");
                cart.addFood(food);
                optionPane.setValue(JOptionPane.YES_OPTION);
                dialog.dispose();
            }
        });

        noButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText(food.getName() + " removed!");
                cart.removeFood(food);
                optionPane.setValue(JOptionPane.NO_OPTION);
                dialog.dispose();
            }
        });

        optionPane.setOptions(new Object[] {yesButton, noButton});
        dialog.setVisible(true);

    }

    // EFFECTS: purchases all items in the cart with current points
    private void purchaseWithPoints() {
        int pointsLeft = cart.purchaseWithPoints(restaurant.getUserPoints());
        restaurant.setPoints(pointsLeft);
        label.setText("\nYou have " + pointsLeft + " points left.\n");

    }

    // EFFECTS: initializes the functions that determine cart worth
    private void initWorthFunctions() {
        totalPointsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pointsWorth();
            }
        });

        totalMoneyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                moneyWorth();
            }
        });
    }

    // EFFECTS: displays the points that the cart is worth
    private void pointsWorth() {
        int worth = cart.totalPoints();
        label.setText("Your cart is worth " + worth + " points.");

    }

    // EFFECTS: displays the money the cart is worth
    private void moneyWorth() {
        double worth = cart.totalMoney();
        label.setText("Your cart is worth " + "$" + worth + ".");

    }

    // EFFECTS: initialize the serialization commands for
    // their respective buttons
    private void initSerializers() {
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

    }

    // EFFECTS: displays the items currently in the cart
    private void viewCart() {
        ArrayList<Food> foodList = cart.getCart();
        ArrayList<String> names = new ArrayList<String>();

        for (Food food : foodList) {
            names.add(food.getName());

        }

        JTextArea textArea = new JTextArea(10, 5);
        textArea.setEditable(false);

        for (String name : names) {
            textArea.append(name + "\n");
        }

        JScrollPane scrollPane = new JScrollPane(textArea);
        JOptionPane.showMessageDialog(null, scrollPane);

    }

    // EFFECTS: displays all the items in the user cart which
    // can be purchased with the points they have
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

            for (String s : list) {
                textArea.append(s + "\n");
            }

            JScrollPane scrollPane = new JScrollPane(textArea);
            JOptionPane.showMessageDialog(null, scrollPane);

        }
    }

    // EFFECTS: loads the previous GUI state
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
