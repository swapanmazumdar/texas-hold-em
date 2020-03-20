package com.clarusone.poker.model;

/**
 * Card consists of CardRank and CardSuite.
 */
public class Card {

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
    public String toString() {
        return "CardRank: " + this.cardRank + ", CardSuit: " + this.cardSuit;
    }
}