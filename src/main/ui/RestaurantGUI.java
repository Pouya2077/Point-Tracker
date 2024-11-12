package ui;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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

    // TODO

    // MODIFIES: this, all fields
    // EFFECTS: initializes fields of GUI and runs it 
    public RestaurantGUI() {
        init();

        initOperations();

        frame.setVisible(true);

    }

    // MODIFIES frame, mainPanel, all buttons
    // EFFECTS: initializes the fields of class
    public void init() {
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
    public void initButtons() {
        menuButton = new JButton("Menu");

        pointsButton = new JButton("Current Points");
        pointsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("You have 0 points.");
            }
        });

        viewButton = new JButton("View Cart");;
        saveButton = new JButton("Save");
        loadButton = new JButton("Load Previous");
        canBuyButton = new JButton("Can Buy With Points");
        totalPointsButton = new JButton("Cart Points Worth");
        totalMoneyButton = new JButton("Cart Money Worth");
        buyWithPointsButton = new JButton("Purchase With Points");

    }

    // MODIFIES: mainPanel
    // EFFECTS: adds the buttons to the panel
    public void addInitialButtons() {
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

    // MODIFIES: 
    // EFFECTS: initializes the fields needed for GUI 
    // backend functionality and operations
    public void initOperations() {

    }

}
