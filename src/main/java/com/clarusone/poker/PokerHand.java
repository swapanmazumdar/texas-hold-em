package com.clarusone.poker;

import com.clarusone.poker.helper.PokerHandCardParser;
import com.clarusone.poker.helper.PokerRankingHelper;
import com.clarusone.poker.model.Card;
import com.clarusone.poker.model.PokerRanking;

import java.util.Collections;
import java.util.List;

public class PokerHand implements Comparable<PokerHand> {

    /**
     * It will use connected commponent algorithm to store the number of counts in the index position of rank or suit
     * respectively.
     */
    private int[] rankDistribution = new int[Card.NO_OF_RANKS_IN_A_DECK]; // 13
    private int[] suitDistribution = new int[Card.NO_OF_SUITS_IN_A_DECK]; // 4

    private List<Card> cards = null;

    public List<Card> getCards() {
        return cards;
    }

    /**
     * Initializes 5 cards and sets weighted distribution of cards.
     */
    public PokerHand(String fiveCards) {
        cards = PokerHandCardParser.prepareCardsFromCardStr(fiveCards);
        setWeightedDistributionsOfCards(cards);
    }

    /**
     * Calculates weighted distribution of cards based on the connected component algorithm. Data structure used will
     * store ordered Rank. Store count of a rank in the index of that Rank.
     */
    private void setWeightedDistributionsOfCards(List<Card> cards) {
        Collections.sort(cards);
        for (Card card : cards) {
            rankDistribution[card.getCardRank().ordinal()]++;
            suitDistribution[card.getCardSuit().ordinal()]++;
        }
    }

    @Override
    public int compareTo(PokerHand opponentHand) {
        PokerRanking myPokerRanking = PokerRankingHelper.findPairsOfRank(cards);

        // Oponent Hand
        List<Card> oponentCards = opponentHand.getCards();
        PokerRanking oponentRanking = PokerRankingHelper.findPairsOfRank(oponentCards);
        if (myPokerRanking.ordinal() > oponentRanking.ordinal()) {
            return HandResult.WIN.comparatorValue;
        } else if (myPokerRanking.ordinal() == oponentRanking.ordinal()) {
            return HandResult.TIE.comparatorValue;
        } else {
            return HandResult.LOSS.comparatorValue;
        }
    }
}
