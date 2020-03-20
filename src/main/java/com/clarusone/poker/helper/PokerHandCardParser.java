package com.clarusone.poker.helper;

import com.clarusone.poker.exception.InvalidCardRankException;
import com.clarusone.poker.model.Card;
import com.clarusone.poker.model.CardRank;
import com.clarusone.poker.model.CardSuit;

import java.util.ArrayList;
import java.util.List;

public class PokerHandCardParser {

    /**
     * Parses string of cards. Assuming there are only 5 cards which are space separated in the string to keep things
     * simple. For example, input "KS 2H 5C JD TD" will have an output of a String array as {"KS", "2H",
     * "5C", "JD", "TD"}
     */
    public static String[] parseCardsAs2Chars(String cardsStr) {
        String[] cards = null;
        if (cardsStr != null) {
            cards = cardsStr.split(" ");
        }
        return cards;
    }

    /**
     * Prepares Cards from cards string. Typically, the specified string should be a hand of 5 cards.
     * It is assumed that the specified input contains space separated a hand of 5 cards i.e. "KS 2H 5C JD TD"
     */
    public static List<Card> prepareCardsFromCardStr(String cardsStr) {
        String[] cards = parseCardsAs2Chars(cardsStr);
        List<Card> cardList = new ArrayList<>();
        for (String cardStr : cards) {
            char rank = cardStr.charAt(0);
            char suit = cardStr.charAt(1);
            Card.CardBuilder cardBuilder = new Card.CardBuilder(CardRank.resolveAsCardRank(rank), CardSuit.resolveAsCardSuit(suit));
            cardList.add(cardBuilder.build());
        }
        return cardList;
    }

    /**
     * Parses rank from specified string
     */
    private static CardRank parseCardRank(String cardStr) throws InvalidCardRankException {
        if (cardStr == null || cardStr.length() == 0) {
            throw new InvalidCardRankException("Card rank can't be null!");
        }
        return null;
    }
}