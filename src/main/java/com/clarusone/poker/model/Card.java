package com.clarusone.poker.model;

/**
 * Card consists of CardRank and CardSuite.
 */
public class Card {

    private CardRank cardRank;
    private CardSuite cardSuite;

    public static class CardBuilder {
        private final CardRank cardRank;
        private final CardSuite cardSuite;

        public CardBuilder(CardRank cardRank, CardSuite cardSuite) {
            this.cardRank = cardRank;
            this.cardSuite = cardSuite;
        }

        public Card build() {
            return new Card(this);
        }
    }

    private Card(CardBuilder builder) {
        this.cardRank = builder.cardRank;
        this.cardSuite = builder.cardSuite;
    }

    public CardRank getCardRank() {
        return cardRank;
    }

    public CardSuite getCardSuite() {
        return cardSuite;
    }

    @Override
    public int hashCode() {
        int result = this.cardRank.hashCode();
        result = 31 * result + this.cardSuite.hashCode();
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
        return cardRank.equals(card.getCardRank()) && cardSuite.equals(card.cardSuite);
    }
}