Feature: Green Kart E-Commerce Site

@HomePage
Scenario: Home Page Item Select
	Given Add items to cart
	Then click cart button
	
	@CheckOut
	Scenario: Proceed To CheckOut
		When Click checkout button
		And Enter promo key
		And Click promo button
		Then Click button order placed
		 
