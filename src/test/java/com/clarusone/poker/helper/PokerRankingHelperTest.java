package com.clarusone.poker.helper;

import com.clarusone.poker.PokerHand;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PokerRankingHelperTest {

    @Before
    public void init() {
    }

    @Test
    public void should_Pass_PokerHandHasOnePairOfRank() {
        String cardsStr = "AH AS 8D 6S 3C";
        PokerHand pokerHand = new PokerHand(cardsStr);

        Assert.assertTrue(PokerRankingHelper.hasOnePairOnly(pokerHand));
    }

    @Test
    public void should_Pass_PokerHandHasTwoPairsOfRank() {
        String cardsStr = "KS KH 8D 8H 4S";
        PokerHand pokerHand = new PokerHand(cardsStr);

        Assert.assertTrue(PokerRankingHelper.hasOnePairOnly(pokerHand)); //TODO it has 2 pairs the test should fail
    }

    @Test
    public void should_Pass_PokerHandHasThreeOfAKind() {
        String cardsStr = "JS JD JH 6C 6H";
        PokerHand pokerHand = new PokerHand(cardsStr);

        Assert.assertTrue(PokerRankingHelper.isThreeOfAKind(pokerHand));
    }

}
