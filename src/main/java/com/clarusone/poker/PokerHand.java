package com.clarusone.poker;

import com.clarusone.poker.helper.PokerHandParser;
import com.clarusone.poker.helper.PokerRankingHelper;
import com.clarusone.poker.model.Card;

import java.util.Collections;
import java.util.List;

public class PokerHand implements Comparable<PokerHand> {

    /**
     * It will use connected commponent algorithm to store the number of counts in the index position of rank or suit
     * respectively.
     */
    private int[] rankDistribution = new int[PokerRankingHelper.NO_OF_RANKS_IN_A_DECK]; // 13
    private int[] suitDistribution = new int[PokerRankingHelper.NO_OF_TYPE_OF_SUITS_IN_A_DECK]; // 4

    private List<Card> cards = null;

    /**
     * Initializes 5 cards and sets weighted distribution of cards.
     */
    public PokerHand(String fiveCards) {
        cards = PokerHandParser.prepareCardsFromCardStr(fiveCards);
        setWeightedDistributionsOfCards(cards);
    }

    public List<Card> getCards() {
        return cards;
    }

    public int[] getRankDistribution() {
        return rankDistribution;
    }

    public int[] getSuitDistribution() {
        return suitDistribution;
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
        int[] rankDistribution = this.getRankDistribution();
        return 0;
    }
}
