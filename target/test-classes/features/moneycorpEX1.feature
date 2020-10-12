Feature: Use the website to get a Euro currency quote
        So that I can check the Euro rate
        As a customer
        I want to be able to select the Euro currency
        
    Scenario Outline: Get Euro rate of exchange
        Given I want to "get the Euro rate"
        When I enter an <amount> in the Currency I Have
        Then I should see the Euro exchange rate
        
	    Examples:
	    | amount |
	    | 100	 |
	    
	   
    
    

        

        