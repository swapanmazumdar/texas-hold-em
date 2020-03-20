package com.clarusone.poker.model;

import com.clarusone.poker.exception.InvalidCardSuitException;

/**
 * Contains predefined suites in playing cards. Any new suite should be defined here for extensibility.
 */
public enum CardSuit {

    CLUBS,
    DIAMONDS,
    HEARTS,
    SPADES;

    public static CardSuit resolveAsCardSuit(char suitChar) {
        CardSuit cardSuit = null;
        switch (suitChar) {
            case 'C':
                cardSuit = CardSuit.CLUBS;
                break;
            case 'D':
                cardSuit = CardSuit.DIAMONDS;
                break;
            case 'H':
                cardSuit = CardSuit.HEARTS;
                break;
            case 'S':
                cardSuit = CardSuit.SPADES;
                break;
            default:
                throw new InvalidCardSuitException(suitChar + " is not a valid Card Suit");
        }
        return cardSuit;
    }
}