Feature: Use the website to amend EUR order from the basket
        So that I can order EUR currency
        As a customer
        I want to be able to select EUR currency and amend order from the basket
    Scenario Outline: Place order for EUR and amend
        Given I want to order <order>
        And I enter an <amount> in the Currency I Have
        And select <currency> from the Currency I Want
        And I proceed
        Then I should see the <currencyorder> in the basket
        And I populate the order form
        And I proceed1
        Then I should see the confirmation page
        
        
         Examples:
	    | order | amount | currency  | currencyorder |
	    | EUR   | 300    | EUR	     |   EUR         |

