package com.clarusone.poker;

import com.clarusone.poker.helper.PokerHandCardParser;

public class PokerHand implements Comparable<PokerHand> {

    private final String[] fiveCards;

    public PokerHand(String fiveCards) {
        this.fiveCards = PokerHandCardParser.parseCardsAs2Chars(fiveCards);
    }

    @Override
    public int compareTo(PokerHand opponentHand) {

        // Delete the line below
        throw new UnsupportedOperationException();
    }
}
