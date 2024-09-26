# My Personal Project: Tim Horton's Point Tracker

## Track your points and costs when shopping at Tim Horton's!

This application will **store information for a Tim Horton's restaurant** including points earned at the establishment, prices for menu items, and items currently in your cart. 

This *application is intended for* Tim Horton's customers to optimize their orders. 

This projct is of *interest to me* because I frequently shop at Tim Horton's and it would be useful for me to keep track of the points I have and earn for the menu items I buy. Likewise, If I can *run calculations* on item's in my cart to **optimize** what I order I can shop more efficiently at Tim Horton's. 

***Services of Application:***

- Add menu items from restaurant to your cart
- Search for an item in your cart by points, name, or price 
- Calculate total points of everything in your cart
- Calculate total price of everything in your cart
- Specify what you spend (money or points) to buy what is in your cart 
- Add points to total points for each item you purchase with money 
- Calculate and print which menu items user can purchase for "x" points in cart

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
    - int worthPonints

3. Cart (includes most calculation methods)
    - ArrayList<Food> userItems

In this case X would be Food (menu items) that the user adds to Cart (Y).

## User Stories:

1. As a user, I want to be able to add menu items from Tim Horton's to my cart. 
2. As a user, I want to print a list of all menu items in my cart. 
3. As a user, I want to calculate the total points and price the items in my cart are worth. 
4. As a user, I want to search for a specific item in the list using price, points, or name. 
5. As a user, I want to print a list of menu items I can purchase with my current points. 
6. As a user, I want to buy items in my cart with the money/points I give the application. 



