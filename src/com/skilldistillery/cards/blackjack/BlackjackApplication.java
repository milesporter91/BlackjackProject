package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

public class BlackjackApplication {
	// FIELDS
	private Scanner sc;
	private BlackjackDealer dealer;
	private BlackjackPlayer player;
	// NO MORE FIELDS / DECK TYPE VARIABLES
	
	//CONSTRUCTOR
	public BlackjackApplication() {
		this.sc = new Scanner(System.in);
		this.dealer = new BlackjackDealer();
		this.player = new BlackjackPlayer();
	}
	
	// MAIN METHOD
	public static void main(String[] args) {
		new BlackjackApplication().launch();
		
		
	}
	
	
	// LAUNCH METHOD
	private void launch() {
		// dealing hands
		//dealStartingHands();
		if ( player.hand.getHandValue() == 21 && dealer.hand.getHandValue() != 21 ) {
			System.out.println("WINNER WINNER CHICKEN DINNER!");
			
			} 
		else if ( player.hand.getHandValue() != 21 && dealer.hand.getHandValue() == 21 ) {
			System.out.println("Dealer Blackjack!");
			}
		else if ( player.hand.getHandValue() == 21 && dealer.hand.getHandValue() == 21 ) {
			System.out.println("Dealer and Player both got Blackjack! Tie hand!");
			}
//		Else If ( (player.hand.getHandValue() != 21) && (dealer.hand.getHandValue() != 21) ) {
			
				//        THIS IS WHERE THE HIT/STAY LOOP WILL GO WITH CONDITIONALS FOR BUSTING OR WINNING THE HAND		//

//			}

		
	}

}
