package com.clarusone.poker.helper;

import com.clarusone.poker.model.PokerRanking;
import com.clarusone.poker.model.Card;
import com.clarusone.poker.model.CardRank;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PokerRankingHelperTest {

    @Before
    public void init() {
    }

    @Test
    public void should_Pass_OnePairOfRankTest() {
        String pokerHand = "AH AS 8D 6S 3C";
        List<Card> onePairInCards = PokerHandCardParser.prepareCardsFromCardStr(pokerHand);

        PokerRankingHelper pokerRankingHelper = new PokerRankingHelper();
        PokerRanking actualPokerRanking = pokerRankingHelper.findPairsOfRank(onePairInCards);

        Assert.assertEquals(PokerRanking.ONE_PAIR, actualPokerRanking);
    }

    @Test
    public void should_Pass_TwoPairsOfRankTest() {
        String pokerHand = "KS KH 8D 8H 4S";
        List<Card> twoPairsInCards = PokerHandCardParser.prepareCardsFromCardStr(pokerHand);

        PokerRankingHelper pokerRankingHelper = new PokerRankingHelper();
        PokerRanking actualPokerRanking = pokerRankingHelper.findPairsOfRank(twoPairsInCards);

        Assert.assertEquals(PokerRanking.TWO_PAIRS, actualPokerRanking);
    }
}
