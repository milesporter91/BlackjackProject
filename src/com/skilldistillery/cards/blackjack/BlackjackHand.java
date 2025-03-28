package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Hand;

public class BlackjackHand extends Hand{
	
	// NO FIELDS
	
		
	@Override
	public int getHandValue() {
		int handValue = 0;
		for (int i = 0; i < cardsInHand.size(); i++) {
		handValue +=cardsInHand.get(i).getValue(cardsInHand.get(i));
		}
		return handValue;
	}

}
