# My Personal Project: Tim Horton's Point Tracker

## Track your points and costs when shopping at Tim Horton's!

This application will **store information for a Tim Horton's restaurant** including points earned at the establishment, prices for menu items, and items currently in your cart. 

This *application is intended for* Tim Horton's customers to optimize their orders. 

This projct is of *interest to me* because I frequently shop at Tim Horton's and it would be useful for me to keep track of the points I have and earn for the menu items I buy. Likewise, If I can *run calculations* on item's in my cart to **optimize** what I order I can shop more efficiently at Tim Horton's. 

***Classes and their Fields:***

1. Restaurant 
    - String name 
    - ArrayList<Food> menuItems
    - int userPoints
    - Cart cart

2. Food 
    - int costInPoints
    - double costInMoney
    - String name 
    - int worthPoints

3. Cart (includes most calculation methods)
    - ArrayList<Food> userItems

In this case X would be Food (menu items) that the user adds to Cart (Y).

## User Stories:

1. As a user, I want to be able to add menu items and remove menu items from my cart.
2. As a user, I want to see the names of all menu items in my cart. 
3. As a user, I want to calculate the total points and price the items in my cart are worth. 
4. As a user, I want to see a list of menu items I can purchase with my current points. 
5. As a user, I want to buy items in my cart with the money/points I give the application. 
6. As a user, I want to have the option to save my restaurant and cart state.
7. As a user, I want to have the option to load a previous state of my restaurant and cart. 

## Instructions for End User

1. You can add an X to a Y (food/meny item class to the cart class) by first clicking the menu button. 
    - This will take you to another screen where you can choose the menu item you would like to add or remove from your cart. 

2. You can generate the first required action related to the user story "adding X's to a Y" by clicking the "Can Buy With Points" button. 
    - This will display which menu items you can purchase with the points you currently have. 

3. You can generate the second required action related to the user story "adding X's to a Y" by clicking the view cart button. 
    - This will show every single item you currently have in your cart. 

4. You can generate a third required action related to the user story "adding X's to a Y" by clicking the "Purchase with Money" button. 
    - This allows the user to specify the amount of money they want to spend and adds points to their account with respect to what they purchased.

5. You can generate a fourth required action related to the user story "adding X's to a Y" by clicking the "Purchase with Points" button. 
    - This purchases as many items in the user cart with the user's points until their points run out.

6. You can generate other required actions by clicking "Current Points," "Cart Points Worth," or "Cart Money Worth"   
    - These will show how many points the user has currently, the points to purchase everything in the cart, and the money to purchase everything in the cart respectively. 

7. The visual component can be located by clicking the "Purchase with Money," "Purchase with Points," "Save," or "Load" buttons. 
    - These display a success animation upon being clicked. 
    - The file used for the visual component can be found in the project folder. 

8. You can save the state of the application or load the state of the application by clicking the "Save" or "Load" buttons respectively. 
    - The state is saved to a JSON file that the terminal GUI also used. 
    - Loading the application reads from this save JSON file and parses the data to the appropriate class objects. 



