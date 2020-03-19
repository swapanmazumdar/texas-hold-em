package com.clarusone.poker.model;

/**
 * Contains predefined suites in playing cards. Any new suite should be defined here for extensibility.
 */
public enum CardSuite {

    CLUBS(1),
    DIAMONDS(2),
    HEARTS(3),
    SPADES(4);

    CardSuite(int suite) {
    }

}
