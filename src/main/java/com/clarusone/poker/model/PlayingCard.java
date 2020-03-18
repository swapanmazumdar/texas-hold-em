package com.clarusone.poker.model;

public class PlayingCard {

    private final char value;
    private final char suite;

    public static class CardBuilder {
        private final char value;
        private final char suite;

        public CardBuilder(char value, char suite) {
            this.value = value;
            this.suite = suite;
        }

        public PlayingCard build() {
            return new PlayingCard(this);
        }
    }

    private PlayingCard(CardBuilder builder) {
        this.value = builder.value;
        this.suite = builder.suite;
    }

}
