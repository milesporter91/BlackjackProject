package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class BlackjackDealer extends BlackjackPlayer{

	//NO MORE FIELDS
	//NO GETTER FOR THE DECK
	private Deck deck;
	
	public BlackjackDealer() {
		super();
		deck = new Deck();
	}
	
	public Card dealCard() {
		return deck.dealCard();
	}
		
}
