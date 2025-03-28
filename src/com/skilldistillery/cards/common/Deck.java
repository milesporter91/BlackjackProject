package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> deck = new ArrayList<>();

	// DO NOT GENERATE A GETTER FOR CARDS
	
	public Deck() {
		deck = loadDeck();
	}

	public List<Card> loadDeck() {
		List<Card> deckOfCards = new ArrayList<>(52);
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				deckOfCards.add(new Card(suit, rank));
			}
		}
		return deckOfCards;
	}

	
	public int checkCurrentDeckSize() {
		return deck.size();
	}
	
	public Card dealCard() {
		if(checkCurrentDeckSize() < 1) {
			return null;
		}
		return deck.remove(0);
	}
	
	public void shuffleDeck() {
		Collections.shuffle(deck);
	}
}
