package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class Black2ackDealer extends BlackjackPlayer{

	//NO MORE FIELDS
	//NO GETTER FOR THE DECK
	private Deck deck;
	
	public Black2ackDealer() {
		super();
		deck = new Deck();
	}
	
	public void newDeck() {
		deck = new Deck();
		shuffleDeck();
	}
	
	public int getCurrentDeckSize() {
		return deck.checkCurrentDeckSize();
	}
	
	public Card dealCard() {
		return deck.dealCard();
	}
	
	public void shuffleDeck() {
		deck.shuffleDeck();
	}
	
}
