package com.clarusone.poker;

import com.clarusone.poker.helper.PokerRankingHelper;
import com.clarusone.poker.model.PokerRanking;

/**
 * Prepares 5 cards, sorts ascending and sets weighted distribution of cards, and allows comparison.
 */
public class PokerHand extends PokerEngine implements Comparable<PokerHand> {

    /**
     * Prepares 5 cards, sorts ascending and sets weighted distribution of cards.
     */
    public PokerHand(String fiveCards) {
        super(fiveCards);
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

}