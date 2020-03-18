package com.clarusone.poker.model;

import java.util.SortedSet;
import java.util.TreeSet;

public enum CardRank {

    ACE(Character.getNumericValue('A')),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(Character.getNumericValue('J')),
    QUEEN(Character.getNumericValue('Q')),
    KING(Character.getNumericValue('K'));

    private final SortedSet set = new TreeSet<CardRank>(); // internal sorted binary tree

    CardRank(int value) {
        set.add(value);
    }

    public boolean isValid(char rank) {
        final boolean contains = set.contains(rank);
        return contains;
    }

    public static void main(String[] args) {
        int numValue = Character.getNumericValue('J');
        System.out.println(numValue);
    }
}
