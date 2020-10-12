Feature: Use the website to order USD currency
        So that I can order US Dollars
        As a customer
        I want to be able to select USD and place an order
        
    Scenario Outline: Place order for USD
        Given I want to "order USD"
        And I enter an <amount> in the Currency I Have
        And select <currency> from the Currency I Want
        And I proceed
        Then I should see the <currencyorder> in the basket
        And I populate the order form
        And I proceed1
        Then I should see the confirmation page

        
        
	    Examples:
	    | amount | currency  | currencyorder |
	    | 500	 | USD       | USD			 |
        