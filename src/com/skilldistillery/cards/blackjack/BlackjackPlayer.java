package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;

public class BlackjackPlayer {
	
	//NO MORE FIELDS
	protected BlackjackHand hand;
	
	public BlackjackPlayer() {
		hand = new BlackjackHand();
	}
	
	public void hit(Card card) {
		this.hand.addCard(card);
	}

	public int getHandValue() {
		return hand.getHandValue();
	}
	
	public void printHand() {
		hand.printCardsInHand();
	}

}
