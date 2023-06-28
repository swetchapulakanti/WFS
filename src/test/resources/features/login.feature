
Feature: login to sauce Page

  @SaucePage
  Scenario: login
    Given user navigate to the <url> in browser
    When enter the username and password
    And click on login 
    Then login is successful and home page should be displayed

    Examples: 
      | url  | username | password  |
      | https://www.saucedemo.com | standard_user | secret_sauce |
      
  @SaucePage1
 Scenario: Adding products to the cart
    Given select the product user required 
    When Add the product to the cart
    And repeat the above steps for multiple products
    Then verify products should be added to the cart
    And remove to few products in the cart
    Then verify products are removed
       
   @sort
 Scenario: Sort the products using name and price
    Given user login in to the home page 
    When sort the products by name z-a by using sort dropdown
    Then verify products are sorted
    And sort the products by price low to high by using sort dropdown
    Then verify products are sorted by price


 @checkout
 Scenario: checkout the added products
    Given user added few products to the cart
    Then verify the products and proceed for checkout
    And add firstname, lastname, postal code 
    And  click on continue
    Then verify the payment info and shipping details
    And click on finish 
    Then verify order should be placed successfully
    
    
    
      
      
      