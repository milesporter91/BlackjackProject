package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.Card;

public class BlackjackApplication {
	// FIELDS
	private Scanner sc;
	private BlackjackDealer dealer;
	private BlackjackPlayer player;
	boolean startingHandEndsGame = false;

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
		playGame();
	}

	// PLAY GAME
	public void playGame() {
		dealer.shuffleDeck();
		System.out.println("Welcome to Blackjack! \nLet's play!");
		while (dealer.getCurrentDeckSize() > 9) {
			dealAndCheckHands();
			if (startingHandEndsGame) {
				System.out.println("Game over!");
			} else {
				takeTurns();
			}
			checkIfShuffleNeeded();
		}
	}

	public void takeTurns() {
		playerTurn();
		if (player.getHandValue() < 22) {
			dealerTurn();
		}
		determineWinner();
	}

	// STARTING HANDS METHODS

	public void dealAndCheckHands() {
//		dealFixedHands();
		dealStartingHands();
		checkStartingHands();
	}

	public void checkStartingHands() {
		if (player.getHandValue() > 21) {
			printPlayerHand();
			userTrollBust();
			startingHandEndsGame = true;
		} else if (dealer.getHandValue() > 21) {
			printDealerHand();
			dealerTrollBust();
			startingHandEndsGame = true;
		} else {

			if (player.getHandValue() == 21 && dealer.getHandValue() != 21) {
				printPlayerHand();
				chickenDinner();
				startingHandEndsGame = true;
			} else if (player.getHandValue() != 21 && dealer.getHandValue() == 21) {
				printPlayerHand();
				printDealerHand();
				dealerBlackjack();
				startingHandEndsGame = true;
			} else if (player.getHandValue() == 21 && dealer.getHandValue() == 21) {
				printPlayerHand();
				printDealerHand();
				System.out.println("Dealer and Player both got Blackjack! Tie hand!");
				startingHandEndsGame = true;
			} else {
				startingHandEndsGame = false;
			}
		}
	}

	public void userTrollBust() {
		System.out.println("       .-\"\"\"\"-.");
		System.out.println("      / -   -  \\");
		System.out.println("     |  .-. .-. |");
		System.out.println("     |  \\o| |o/ |");
		System.out.println("      \\   ^    /");
		System.out.println("       '.    .' ");
		System.out.println("         '--'  ");
		System.out.println();
		System.out.println("Feaux Bust! Two Aces got you!");
		System.out.println("     Troll Face Activated!");
	}

	public void dealerTrollBust() {
		System.out.println("Dealer Feaux Bust!");
		System.out.println();
		System.out.println("         .-\"\"\"\"-.");
		System.out.println("        / -   -  \\");
		System.out.println("       |  O   O   |");
		System.out.println("       |    ^     |");
		System.out.println("        \\  '-'   /");
		System.out.println("         '-....-'");
		System.out.println("           /  \\");
		System.out.println("      .---'----'---.");
		System.out.println("     /  /|    |\\    \\");
		System.out.println("    |  / |    | \\    |");
		System.out.println("     \\_/  |____|  \\__/");
		System.out.println();
		System.out.println("You found the tooth fairy,");
		System.out.println("   the only bug that pays!");
	}

	public void dealerBlackjack() {
		System.out.println("============================================");
		System.out.println("|       DEALER GOT BLACKJACK!              |");
		System.out.println("============================================");
		System.out.println("The house wins with a natural Blackjack!");
	}

	public void chickenDinner() {
		System.out.println("  ___________________________________________  ");
		System.out.println(" /                                           \\ ");
		System.out.println("|   WINNER WINNER CHICKEN DINNER!             |");
		System.out.println(" \\___________________________________________/ ");
		System.out.println("           \\   ^__^");
		System.out.println("            \\  (oo)\\_______");
		System.out.println("               (__)\\       )\\/\\");
		System.out.println("                   ||----w |");
		System.out.println("                   ||     ||");
	}

	// PRINT HANDS METHODS

	public void dealerHandValue() {
		System.out.println("Dealer has " + dealer.getHandValue());
	}

	public void playerHandValue() {
		System.out.println("Player has " + player.getHandValue());
	}

	public void printDealerHand() {
		System.out.print("Dealer Hand: ");
		dealer.printHand();
	}

	public void printPlayerHand() {
		System.out.print("Player Hand: ");
		player.printHand();
	}

	// TURN METHODS
	public void dealerTurn() {
		while (dealer.getHandValue() < 17) {
			Card drawnCard = dealer.dealCard();
			dealer.hit(drawnCard);
			System.out.println("Dealer hits: " + drawnCard);
			if (dealer.getHandValue() > 21) {
				System.out.println("Dealer busts!");
			}
		}
		if (dealer.getHandValue() >= 17 && dealer.getHandValue() <= 21) {
			System.out.println("Dealer stays.");
		}
	}

	public void playerTurn() {
		printPlayerHand();
		String hitOrStay;
		boolean keepPlaying = true;
		while (keepPlaying) {
			playerHandValue();
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
		printPlayerHand();
		printDealerHand();
	}

	// DETERMINE WINNER METHOD
	public void determineWinner() {
		playerHandValue();
		dealerHandValue();
		if ((player.getHandValue() > dealer.getHandValue() && player.getHandValue() < 22)
				|| (player.getHandValue() < 22 && dealer.getHandValue() > 21)) {
			System.out.println("Player wins!");
		} else if (player.getHandValue() < dealer.getHandValue() || player.getHandValue() > 21) {
			System.out.println("Dealer wins!");
		} else if (player.getHandValue() == dealer.getHandValue()) {
			System.out.println("Player and Dealer tie!");
		}

	}

	// DEAL STARTING HANDS METHOD
	public void dealStartingHands() {
		System.out.println("________________________________\n");
		System.out.println("Cards left in deck: " + dealer.getCurrentDeckSize());
		System.out.println("Dealing New Hand!");
		System.out.println("________________________________");
		player.clearHand();
		dealer.clearHand();
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

	// CHECK DECK SIZE AND SHUFFLE IF USER WANTS TO PLAY AGAIN
	public void checkIfShuffleNeeded() {
		if (dealer.getCurrentDeckSize() <= 9) {
			System.out.println("_____________________________");
			System.out.println("There aren't enough cards in the deck to play again!");
			System.out.println("Would you like to shuffle and play again?");
			String playAgain = sc.next();
			switch (playAgain) {
			case "Yes":
			case "yes":
			case "y":
			case "Y":
				dealer.newDeck();
				break;
			case "No":
			case "no":
			case "N":
			case "n":
				System.out.println("Have a great day!");
			}
		}
	}

//	public void dealFixedHands() {
//		dealer.clearHand();
//		player.clearHand();
//		dealer.hit(new Card(Rank.ACE, Suit.CLUBS));
//		dealer.hit(new Card(Rank.KING, Suit.CLUBS));
//		player.hit(new Card(Rank.ACE, Suit.CLUBS));
//		player.hit(new Card(Rank.FIVE, Suit.CLUBS));
//		for (int i = 0; i < 42; i++) {
//			dealer.dealCard();
//		}
//	}

}
