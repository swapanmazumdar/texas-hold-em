package com.clarusone.poker.model;

public class PlayingCard {

    private CardRank cardRank;
    private CardSuite cardSuite;

    public static class CardBuilder {
        private final CardRank cardRank;
        private final CardSuite cardSuite;

        public CardBuilder(CardRank cardRank, CardSuite cardSuite) {
            this.cardRank = cardRank;
            this.cardSuite = cardSuite;
        }

        public PlayingCard build() {
            return new PlayingCard(this);
        }
    }

    private PlayingCard(CardBuilder builder) {
        this.cardRank = builder.cardRank;
        this.cardSuite = builder.cardSuite;
    }

}