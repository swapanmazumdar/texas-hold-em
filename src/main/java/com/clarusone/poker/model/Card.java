package com.clarusone.poker.model;

/**
 * Card consists of CardRank and CardSuite. Two Card objects may be compared with each other according to the comparable
 * natural ordering.
 */
public class Card implements Comparable<Card> {

    public static final int NO_OF_RANKS_IN_A_DECK = 13;
    public static final int NO_OF_SUITS_IN_A_DECK = 4;

    private CardRank cardRank;
    private CardSuit cardSuit;

    public static class CardBuilder {
        private final CardRank cardRank;
        private final CardSuit cardSuit;

        public CardBuilder(CardRank cardRank, CardSuit cardSuite) {
            this.cardRank = cardRank;
            this.cardSuit = cardSuite;
        }

        public Card build() {
            return new Card(this);
        }
    }

    private Card(CardBuilder builder) {
        this.cardRank = builder.cardRank;
        this.cardSuit = builder.cardSuit;
    }

    public CardRank getCardRank() {
        return cardRank;
    }

    public CardSuit getCardSuit() {
        return cardSuit;
    }

    public int getRankValue() {
        return cardRank.ordinal();
    }

    @Override
    public int hashCode() {
        int result = this.cardRank.hashCode();
        result = 31 * result + this.cardSuit.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Card)) {
            return false;
        }
        Card card = (Card) obj;
        return cardRank.equals(card.getCardRank()) && cardSuit.equals(card.cardSuit);
    }

    @Override
    public int compareTo(Card otherCard) {
        int thisHashCode = this.hashCode();
        int otherHashCode = otherCard.hashCode();
        if (thisHashCode < otherHashCode) {
            return -1;
        } else if (thisHashCode > otherHashCode) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "CardRank: " + this.cardRank + ", CardSuit: " + this.cardSuit;
    }
}