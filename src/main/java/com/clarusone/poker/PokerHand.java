package com.clarusone.poker;

import com.clarusone.poker.helper.PokerHandCardParser;
import com.clarusone.poker.helper.PokerRankingHelper;
import com.clarusone.poker.model.Card;
import com.clarusone.poker.model.PokerRanking;

import java.util.List;

public class PokerHand implements Comparable<PokerHand> {

    public List<Card> getCards() {
        return cards;
    }

    private List<Card> cards = null;


    public PokerHand(String fiveCards) {
        cards = PokerHandCardParser.prepareCardsFromCardStr(fiveCards);
    }

    @Override
    public int compareTo(PokerHand opponentHand) {
        PokerRanking myPokerRanking = PokerRankingHelper.findPairsOfRank(cards);

        // Oponent Hand
        List<Card> oponentCards = opponentHand.getCards();
        PokerRanking oponentRanking = PokerRankingHelper.findPairsOfRank(oponentCards);
        if(myPokerRanking.ordinal() > oponentRanking.ordinal()) {
            return HandResult.WIN.comparatorValue;
        } else if(myPokerRanking.ordinal() == oponentRanking.ordinal()) {
            return HandResult.TIE.comparatorValue;
        } else {
            return HandResult.LOSS.comparatorValue;
        }
    }
}
