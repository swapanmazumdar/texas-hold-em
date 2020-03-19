package com.clarusone.poker.model;

/**
 * Contains predefined constants of all known ranks in playing cards. Any new rank should be defined here for
 * extensibility.
 */
public enum CardRank {

    ACE(1),
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
    KING(13);

    CardRank(int rank) {
    }

}
