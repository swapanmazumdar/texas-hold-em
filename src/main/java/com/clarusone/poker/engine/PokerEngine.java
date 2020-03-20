package com.clarusone.poker.engine;

import com.clarusone.poker.model.Card;
import com.clarusone.poker.model.CardRank;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PokerEngine {

/*
    public static Map<String, Integer> cardsParser(String cardsInHand) {

    }
*/
    /**
     *
     * @param cardsInHand
     * @return
     */
    public static boolean isPokerHandAHighCard(List<Card> cardsInHand) {
        boolean result = false;

        int count = 0;
        Card cardInHand = cardsInHand.get(0);
        for (Card card : cardsInHand) {
            if(card.getCardRank().equals(cardInHand.getCardRank())) {
                ++count;
            }
        }
        return result;
    }
}
