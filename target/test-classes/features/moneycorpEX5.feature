Feature: Use the website to order two currencies and remove one
        So that I can order EUR and US
        As a customer
        I want to be able to remove US from the order
    Scenario Outline: Place order for VND and OMR
        Given I want to "order 500 EUROS and 1000 US"
        And I enter an <amount> in the Currency I Have
        And select <currency> from the Currency I Want
        And I proceed
        Then I should see the <currencyorder> in the basket
        And I add another currency
        Then I should see the Enter Purchase Amount screen
        And I enter an <amount1> in the Currency I Have
        And select <currency1> from the Currency I Want
        And proceed
        Then I should remove the "EUR" currency

        
        
        Examples:
	    | amount | currency  | currencyorder | amount1 | currency1 |
	    | 500	 | EUR       | EUR	         | 1000    | USD       |
        
        
