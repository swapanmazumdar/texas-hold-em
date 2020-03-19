package com.clarusone.poker.helper;

public class PlayingCardHelper {

    /**
     * Parses cards from a given cards string. Assuming there are only 5 cards which are space separated in the string
     * to keep things simple.
     *
     * @param cardsStr
     * @return
     */
    public static String[] parseCards(String cardsStr) {
        String[] cards = null;
        if(cardsStr != null) {
            cards = cardsStr.split(" ");
        }
        return cards;
    }
}
