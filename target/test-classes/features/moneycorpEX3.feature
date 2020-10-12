Feature: Use the website to order 600000 VND and 100 OMR
        So that I can order Vietnamese Dong and Omani Rial
        As a customer
        I want to be able to enter VND and OMR currency and place an order
    Scenario Outline: Place order for VND and OMR
        Given I want to "order 600000 VND and 100 OMR"
        And I enter an <amount> in the Currency I Have
        And select <currency> from the Currency I Want
        And I proceed
        Then I should see the <currencyorder> in the basket
        And I add another currency
        Then I should see the Enter Purchase Amount screen
        And I enter an <amount1> in the Currency I Have
        And select <currency1> from the Currency I Want
        And proceed
        Then I should see the currency order in the basket
        And I populate the order form
        And I proceed1
        Then I should see the confirmation page
        
        
        Examples:
	    | amount | currency  | currencyorder | amount1 | currency1 |
	    | 21.43	 | VND       | VND	         | 207.71    | OMR     |

