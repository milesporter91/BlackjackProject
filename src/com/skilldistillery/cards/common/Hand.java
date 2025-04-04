package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	
	protected List<Card> cardsInHand;
	
	public Hand() {
		cardsInHand = new ArrayList<>();
	}
	
	
	public void addCard(Card card) {
		cardsInHand.add(card);
	}
	
	public void clear() {
		cardsInHand.clear();
	}
	
	public abstract int getHandValue();

	public void printCardsInHand() {
		String playerCards = "";
		for (int i = 0; i < cardsInHand.size(); i++) {
			boolean moreCards = (i == cardsInHand.size() -1);
			playerCards = playerCards + cardsInHand.get(i)  + (moreCards ? "." : ", ");
		}
		System.out.println(playerCards);
	}
	
	
	
	
}
