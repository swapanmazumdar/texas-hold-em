package com.clarusone.poker.helper;

import com.clarusone.poker.engine.PokerRanking;
import com.clarusone.poker.model.Card;
import com.clarusone.poker.model.CardRank;
import com.clarusone.poker.model.CardSuit;

import java.util.*;

public class PokerRankingHelper {

    private TreeMap<CardRank, Integer> cardRankWithCount = new TreeMap<>();
    private TreeMap<CardSuit, Integer> cardSuitWithCount = new TreeMap<>();

    /**
     * Capture counts of each Card Rank and Card Suite as a new Card is added to the hand.
     * Imagine looking at your cards as you get a Card.
     */
    public void captureCountOfRank(List<Card> cards) {
        for (Card card : cards) {
            CardRank cardRank = card.getCardRank();
            if (cardRankWithCount.containsKey(cardRank)) {
                Integer count = cardRankWithCount.get(card.getCardRank());
                cardRankWithCount.replace(card.getCardRank(), ++count);
            } else {
                cardRankWithCount.put(cardRank, 1);
            }
        }
    }

    public void captureCountOfSuite(List<Card> cards) {
        for (Card card : cards) {
            CardSuit cardSuite = card.getCardSuit();
            if (cardSuitWithCount.containsKey(cardSuite)) {
                Integer count = cardSuitWithCount.get(card.getCardSuit());
                cardSuitWithCount.replace(card.getCardSuit(), ++count);
            } else {
                cardSuitWithCount.put(cardSuite, 1);
            }
        }
    }

    /**
     * Returns an object - CardRank plus count of pair (a pair, two pairs, three cards with the same rank
     */
    public PokerRanking findPairsOfRank() {
        PokerRanking pokerRanking = null;
        CardRank cardWithHighestRank;
        Integer pairCount = 0;

        Set cardRankSet = cardRankWithCount.entrySet();
        Iterator iterator = cardRankSet.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            if((Integer) entry.getValue() > pairCount) {
                pairCount = (Integer) entry.getValue();
            }
            System.out.printf("Key: %s & Value: %d%n", entry.getKey(), (Integer) entry.getValue());
        }

        if(pairCount == 1) {
            pokerRanking = PokerRanking.NONE;
        } else if(pairCount == 2) {
            pokerRanking = PokerRanking.ONE_PAIR;
        } else if(pairCount == 3) {
            pokerRanking = PokerRanking.THREE_OF_A_KIND;
        } else if(pairCount == 4) {
            pokerRanking = PokerRanking.FOUR_OF_A_KIND;
        }

        return pokerRanking;
    }

    private void showMyCardsRanking() {
        Set cardRankSet = cardRankWithCount.entrySet();
        Iterator iterator = cardRankSet.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.printf("Key: %s & Value: %d%n", entry.getKey(), (Integer) entry.getValue());
        }

        Set cardSuiteSet = cardSuitWithCount.entrySet();
        iterator = cardSuiteSet.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.printf("Key: %s & Value: %d%n", entry.getKey(), (Integer) entry.getValue());
        }

    }

    public static void main(String[] args) {
        PokerRankingHelper pokerRankingHelper = new PokerRankingHelper();
        List<Card> cards = new ArrayList<>();

        cards.add(new Card.CardBuilder(CardRank.KING, CardSuit.DIAMONDS).build());
        cards.add(new Card.CardBuilder(CardRank.KING, CardSuit.CLUBS).build());
        cards.add(new Card.CardBuilder(CardRank.EIGHT, CardSuit.HEARTS).build());
        cards.add(new Card.CardBuilder(CardRank.ACE, CardSuit.HEARTS).build());

        pokerRankingHelper.captureCountOfRank(cards);
        pokerRankingHelper.captureCountOfSuite(cards);
        pokerRankingHelper.showMyCardsRanking();
    }

}
