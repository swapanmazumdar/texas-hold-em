package com.clarusone.poker.helper;

import com.clarusone.poker.model.PokerRanking;
import com.clarusone.poker.model.Card;
import com.clarusone.poker.model.CardRank;
import com.clarusone.poker.model.CardSuit;

import java.util.*;

public class PokerRankingHelper {

    /**
     * Maps count of each Card Rank present in the Cards.
     */
    private static Map<CardRank, Integer> mapRankWithCountRank(List<Card> cards) {
        Map<CardRank, Integer> cardRankWithCount = new TreeMap<>();
        for (Card card : cards) {
            CardRank cardRank = card.getCardRank();
            if (cardRankWithCount.containsKey(cardRank)) {
                Integer count = cardRankWithCount.get(card.getCardRank());
                cardRankWithCount.replace(card.getCardRank(), ++count);
            } else {
                cardRankWithCount.put(cardRank, 1);
            }
        }
        return cardRankWithCount;
    }

    /**
     * Map count of each Card Suite present in the Cards.
     */
    private static Map<CardSuit, Integer> MapSuiteWithCount(List<Card> cards) {
        Map<CardSuit, Integer> cardSuitWithCount = new TreeMap<>();

        for (Card card : cards) {
            CardSuit cardSuite = card.getCardSuit();
            if (cardSuitWithCount.containsKey(cardSuite)) {
                Integer count = cardSuitWithCount.get(card.getCardSuit());
                cardSuitWithCount.replace(card.getCardSuit(), ++count);
            } else {
                cardSuitWithCount.put(cardSuite, 1);
            }
        }
        return cardSuitWithCount;
    }

    /**
     * Returns PokerRanking by counting CardRank in single, pair, three and four of a kind.
     * TODO don't forget to check 2 pairs
     */
    public static PokerRanking findPairsOfRank(List<Card> cards) {
        Map<CardRank, Integer> cardRankWithCount = mapRankWithCountRank(cards);
        PokerRanking pokerRanking = PokerRanking.NONE; // default

        CardRank cardRank = null;
        Integer rankCount = 0;

        Set cardRankSet = cardRankWithCount.entrySet();
        Iterator iterator = cardRankSet.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            if((Integer) entry.getValue() > rankCount) {
                cardRank = (CardRank) entry.getKey();
                rankCount = (Integer) entry.getValue();
            }
        }

        if(rankCount == 1) {
            pokerRanking = PokerRanking.NONE;
        } else if(rankCount == 2) {
            pokerRanking = PokerRanking.ONE_PAIR;
        } else if(rankCount == 3) {
            pokerRanking = PokerRanking.THREE_OF_A_KIND;
        } else if(rankCount == 4) {
            pokerRanking = PokerRanking.FOUR_OF_A_KIND;
        }

        return pokerRanking;
    }

    /**
     * Calculates the rank and suit distributions.
     */
    public void calculateDistributions(List<Card> cards) {
        int rankDist[] = new int[6];
        for (Card card : cards) {
//            rankDist[card.getRank()]++;
  //          suitDist[card.getSuit()]++;
        }
    }
}
