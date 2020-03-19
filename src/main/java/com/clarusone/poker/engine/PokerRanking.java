package com.clarusone.poker.engine;

/**
 * Rankings in Poker (Texas Hold'em) from the lowest to the highest.
 */
public enum PokerRanking {
    HIGH_CARD, // has no pair - KD 7S 5D 3C 2S
    ONE_PAIR, // has one pair - AH AS 8D 6S 3C
    TWO_PAIRS, // has 2 pairs - KS KH 8D 8H 4S
    THREE_OF_A_KIND, // has 3 ranks - JS JD JH 6C 3S
    STRAIGHT, // 5 sequential cards which is not of the same suite - 10C 9H 8D 7S 6C
    FLUSH, // any 5 cards of an identical suite KC QC 10C 8C 6C
    FULL_HOUSE, // 3 of a kind plus a pair
    FOUR_OF_A_KIND, // 4 of a kind
    STRAIGHT_FLUSH, // 5 sequential cards which is of the SAME suite - 10H 9H 8H 7H 6H
    ROYAL_FLUSH; // 5 sequential cards which is of the SAME suite, all 5 cards are of the highest ranks - AH KH QH JH 10H
}