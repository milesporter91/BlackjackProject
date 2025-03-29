package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.Card;

public class BlackjackApplication {
	// FIELDS
	private Scanner sc;
	private BlackjackDealer dealer;
	private BlackjackPlayer player;
	boolean startingHandEndsGame = false;
	// NO MORE FIELDS / DECK TYPE VARIABLES

	// CONSTRUCTOR
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
		dealer.shuffleDeck();
		System.out.println("Welcome to Blackjack! Dealing starting hands: ");
		System.out.println("Lets play!");
		dealStartingHands();
		checkStartingHands();
		if (startingHandEndsGame) {
			System.out.println("Game over!");
		} else {
			printPlayerHand();
			playerTurn();
			printPlayerHand();
			printDealerHand();
			if (player.getHandValue() < 22) {
				dealerTurn();
			}
			System.out.println("Player has " + player.getHandValue());
			System.out.println("Dealer has " + dealer.getHandValue());
			determineWinner();
			// THIS IS WHERE THE HIT/STAY LOOP WILL GO WITH CONDITIONALS FOR BUSTING OR
			// WINNING THE HAND //
		}
	}

	public void checkStartingHands() {
		if (player.getHandValue() == 21 && dealer.getHandValue() != 21) {
			printPlayerHand();
			System.out.println("WINNER WINNER CHICKEN DINNER!");
			startingHandEndsGame = true;
		} else if (player.getHandValue() != 21 && dealer.getHandValue() == 21) {
			printPlayerHand();
			printDealerHand();
			System.out.println("Dealer Blackjack!");
			startingHandEndsGame = true;
		} else if (player.getHandValue() == 21 && dealer.getHandValue() == 21) {
			printPlayerHand();
			printDealerHand();
			System.out.println("Dealer and Player both got Blackjack! Tie hand!");
			startingHandEndsGame = true;
		} else if (player.getHandValue() > 21) {
			printPlayerHand();
			System.out.println("You busted!");
			System.out.println(
					"...okay not really playing by the rules, but Aces only equal 11 here....sorry bout your luck.");
			startingHandEndsGame = true;
		} else {
			startingHandEndsGame = false;
		}
	}

	public void printDealerHand() {
		System.out.print("Dealer Hand: ");
		dealer.printHand();
	}
	
	public void printPlayerHand() {
		System.out.print("Player Hand: ");
		player.printHand();
	}
	
	public void dealerTurn() {
		while (dealer.getHandValue() < 17) {
			Card drawnCard = dealer.dealCard();
			dealer.hit(drawnCard);
			System.out.println("Dealer hits: " + drawnCard);
			System.out.println("Dealer hand total: " + dealer.getHandValue());
			if (dealer.getHandValue() > 21) {
				System.out.println("Dealer busts!");
			}
		}
		if (dealer.getHandValue() >= 17 && dealer.getHandValue() <= 21) {
			System.out.println("Dealer stays.");
		}
	}

	public void playerTurn() {
		String hitOrStay;
		boolean keepPlaying = true;
		while (keepPlaying) {
			System.out.println("Player hand value: " + player.getHandValue());
			System.out.println("Hit or Stay?");
			hitOrStay = sc.next();
			switch (hitOrStay) {
			case "Hit":
			case "hit":
			case "h":
			case "H":
				Card drawnCard = dealer.dealCard();
				player.hit(drawnCard);
				System.out.println(drawnCard);
				player.getHandValue();
				if (player.getHandValue() > 21) {
					System.out.println("BUSTED!");
					keepPlaying = false;
					break;
				}
				break;
			case "Stay":
			case "stay":
			case "S":
			case "s":
				System.out.println("Player stays!");
				keepPlaying = false;
				break;
			default: {
				System.out.println("Please enter a valid value (Hit, hit, H,h / Stay, stay, S, s):");
				continue;
			}
			}
		}
	}

	public void determineWinner() {
		if ((player.getHandValue() > dealer.getHandValue() && player.getHandValue() < 22)
				|| (player.getHandValue() < 22 && dealer.getHandValue() > 21)) {
			System.out.println("Player wins!");
		} else if (player.getHandValue() < dealer.getHandValue() || player.getHandValue() > 21) {
			System.out.println("Dealer wins!");
		} else if (player.getHandValue() == dealer.getHandValue()) {
			System.out.println("Player and Dealer tie!");
		}

	}

	public void dealStartingHands() {
		Card drawnCard = dealer.dealCard();
		player.hit(drawnCard);
		System.out.println("Player's first Card: " + drawnCard);
		drawnCard = dealer.dealCard();
		dealer.hit(drawnCard);
		System.out.println("Dealer's first card remains face down.");
		drawnCard = dealer.dealCard();
		player.hit(drawnCard);
		System.out.println("Player's second Card: " + drawnCard);
		drawnCard = dealer.dealCard();
		dealer.hit(drawnCard);
		System.out.println("Dealer's second Card: " + drawnCard);
	}

}
