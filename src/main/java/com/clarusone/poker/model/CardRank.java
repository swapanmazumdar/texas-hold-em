package com.clarusone.poker.model;

import com.clarusone.poker.exception.InvalidCardRankException;

/**
 * Contains predefined constants of all known ranks in playing cards in natural order. Any new rank should be defined
 * here for extensibility. The lowest ordinal is 0 for TWO and the highest ordinal is 12 for ACE. Though the rank starts
 * at 2 and goes up to 14. It will be straight forward to translate an input rank from 2 - 10 and map it with
 * Enum<CardRank>. The challenge will be to map input ranks - A, K, Q, J.
 */
public enum CardRank {
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13),
    ACE(14); // moved ACE to the highest ordinal position

    CardRank(int rank) {
    }

    public static boolean isValid(int rank) {
        boolean result = false; // assume it to be invalid to protect the system
        switch (rank) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                result = true;
                break;
            default:
                result = false;
        }
        return result;
    }

    public static CardRank resolveAsCardRank(char rankChar) {
        CardRank cardRank = null;
        switch (rankChar) {
            case '2':
                cardRank = CardRank.TWO;
                break;
            case '3':
                cardRank = CardRank.THREE;
                break;
            case '4':
                cardRank = CardRank.FOUR;
                break;
            case '5':
                cardRank = CardRank.FIVE;
                break;
            case '6':
                cardRank = CardRank.SIX;
                break;
            case '7':
                cardRank = CardRank.SEVEN;
                break;
            case '8':
                cardRank = CardRank.EIGHT;
                break;
            case '9':
                cardRank = CardRank.NINE;
                break;
            case 'T':
                cardRank = CardRank.TEN;
                break;
            case 'J':
                cardRank = CardRank.JACK;
                break;
            case 'Q':
                cardRank = CardRank.QUEEN;
                break;
            case 'K':
                cardRank = CardRank.KING;
                break;
            case 'A':
                cardRank = CardRank.ACE;
                break;
            default:
                throw new InvalidCardRankException(rankChar + " is not a valid Card Rank");
        }
        return cardRank;
    }

}
