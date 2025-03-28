package com.skill.distillery.cards.common;

import java.util.Objects;

public class Card {
	private Suit suit;
	private Rank rank;

	public Card(Suit suit, Rank rank) {
		this.rank = rank;
		this.suit = suit;
	}

	public Card(Rank rank, Suit suit) {
		this (suit, rank);
	}

		public int getValue(Card card) {
			return rank.getValue();
		}
		
	@Override
	public int hashCode() {
		return Objects.hash(rank, suit);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return rank == other.rank && suit == other.suit;
	}
	
	@Override
	public String toString() {
		return rank + " of " + suit;
	}
	

}
