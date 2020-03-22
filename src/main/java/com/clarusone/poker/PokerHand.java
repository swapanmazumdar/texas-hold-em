package com.clarusone.poker;

import com.clarusone.poker.helper.PokerHandParser;
import com.clarusone.poker.helper.PokerRankingHelper;
import com.clarusone.poker.model.Card;
import com.clarusone.poker.model.PokerRanking;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Prepares 5 cards, sorts ascending and sets weighted distribution of cards, and allows comparison.
 */
public class PokerHand implements Comparable<PokerHand> {

    /**
     * It will use connected component algorithm to store the number of counts in the index position of rank or suit
     * respectively.
     */
    private int[] rankDistribution = new int[PokerRankingHelper.NO_OF_RANKS_IN_A_DECK]; // 13
    private int[] suitDistribution = new int[PokerRankingHelper.NO_OF_TYPE_OF_SUITS_IN_A_DECK]; // 4
    private Comparator<Card> byRank = (Card card1, Card card2) -> card1.getCardRank().compareTo(card2.getCardRank());

    public Optional<Card> getHighCard() {
        return highCard;
    }

    private Optional<Card> highCard;
    private List<Card> cards;

    /**
     * Prepares 5 cards, sorts ascending and sets weighted distribution of cards.
     */
    public PokerHand(String fiveCards) {
        cards = PokerHandParser.prepareCardsFromCardStr(fiveCards);
        Collections.sort(cards);
        setWeightedDistributionsOfCards(cards);
        setHighCard(cards);
    }

    private void setHighCard(List<Card> cards) {
        highCard = cards.stream().max(byRank);
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
     * Calculates weighted distribution of cards based on the connected component algorithm. Store count of a rank in
     * the index of that Rank.
     */
    private void setWeightedDistributionsOfCards(List<Card> cards) {
        for (Card card : cards) {
            rankDistribution[card.getCardRank().ordinal()]++;
            suitDistribution[card.getCardSuit().ordinal()]++;
        }
    }

    @Override
    public int compareTo(PokerHand opponentHand) {
        PokerRanking thisPokerRanking = PokerRankingHelper.rank(this);
        PokerRanking opponentPokerRanking = PokerRankingHelper.rank(opponentHand);
        int result = -1;
        if (thisPokerRanking.compareTo(opponentPokerRanking) > 0) {
            result = HandResult.WIN.comparatorValue;
        } else if (thisPokerRanking.compareTo(opponentPokerRanking) < 0) {
            result = HandResult.LOSS.comparatorValue;
        } else if (thisPokerRanking.compareTo(opponentPokerRanking) == 0) {
            result = specialCompareTo(this, opponentHand);
        }
        return result;
    }

    private static int specialCompareTo(PokerHand thisPokerHand, PokerHand opponentPokerHand) {
        // check if two or more players share the same four of a kind, then the fifth card kicker determines the winner.
        PokerRanking thisPokerRanking = PokerRankingHelper.rank(thisPokerHand);
        PokerRanking opponentPokerRanking = PokerRankingHelper.rank(opponentPokerHand);
        int result = thisPokerHand.highCard.get().compareTo(opponentPokerHand.highCard.get());
        if (result > 0) {
            return HandResult.WIN.comparatorValue;
        } else if (result == 0) {
            return HandResult.TIE.comparatorValue;
        } else {
            return HandResult.LOSS.comparatorValue;
        }
    }
}