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
    public void should_Pass_PokerHandIsRoyalFlush() {
        String cardsStr = "AH KH QH JH TH";
        PokerHand pokerHand = new PokerHand(cardsStr);

        Assert.assertTrue(PokerRankingHelper.isRoyalFlush(pokerHand));
    }

    @Test
    public void should_Fail_PokerHandIsRoyalFlush() {
        String cardsStr = "AH KH QH JH 9H";
        PokerHand pokerHand = new PokerHand(cardsStr);

        Assert.assertFalse(PokerRankingHelper.isRoyalFlush(pokerHand));
    }

    @Test
    public void should_Pass_PokerHandIsStraightFlush() {
        String cardsStr = "TH 9H 8H 7H 6H";
        PokerHand pokerHand = new PokerHand(cardsStr);

        Assert.assertTrue(PokerRankingHelper.isStraightFlush(pokerHand));
    }

    @Test
    public void should_Fail_PokerHandIsStraightFlush() {
        String cardsStr = "TC 9H 8D 7S 6C";
        PokerHand pokerHand = new PokerHand(cardsStr);

        Assert.assertFalse(PokerRankingHelper.isStraightFlush(pokerHand));
    }

    @Test
    public void should_Pass_PokerHandIsFourOfAKind() {
        String cardsStr = "AC AH AD AS 6C";
        PokerHand pokerHand = new PokerHand(cardsStr);

        Assert.assertTrue(PokerRankingHelper.isFourOfAKind(pokerHand));
    }

    @Test
    public void should_Fail_PokerHandIsFourOfAKind() {
        String cardsStr = "KC AH AD AS 6C";
        PokerHand pokerHand = new PokerHand(cardsStr);

        Assert.assertFalse(PokerRankingHelper.isFourOfAKind(pokerHand));
    }

    @Test
    public void should_Pass_PokerHandIsFullHouse() {
        String cardsStr = "8S 8C 8D 6C 6H";
        PokerHand pokerHand = new PokerHand(cardsStr);

        Assert.assertTrue(PokerRankingHelper.isFullHouse(pokerHand));
    }

    @Test
    public void should_Fail_PokerHandIsFullHouse() {
        String cardsStr = "8S 8C 8D 6C 7H";
        PokerHand pokerHand = new PokerHand(cardsStr);

        Assert.assertFalse(PokerRankingHelper.isFullHouse(pokerHand));
    }

    @Test
    public void should_Pass_PokerHandIsAFlush() {
        String cardsStr = "KC QC TC 8C 6C";
        PokerHand pokerHand = new PokerHand(cardsStr);

        Assert.assertFalse(PokerRankingHelper.isFlush(pokerHand));
    }

    @Test
    public void should_Fail_PokerHandIsAFlush() {
        String cardsStr = "KC QS TH 8C 6D";
        PokerHand pokerHand = new PokerHand(cardsStr);

        Assert.assertFalse(PokerRankingHelper.isFlush(pokerHand));
    }

    @Test
    public void should_Pass_PokerHandHasOnlyOnePair() {
        String cardsStr = "AH AS 8D 6S 3C";
        PokerHand pokerHand = new PokerHand(cardsStr);

        Assert.assertTrue(PokerRankingHelper.hasOnePairOnly(pokerHand));
    }

    @Test
    public void should_Pass_PokerHandHasTwoPairs() {
        String cardsStr = "KS KH 8D 8H 4S";
        PokerHand pokerHand = new PokerHand(cardsStr);

        Assert.assertTrue(PokerRankingHelper.hasTwoPairs(pokerHand));
    }

    @Test
    public void should_Pass_PokerHandHasThreeOfAKind() {
        String cardsStr = "JS JD JH 6C 6H";
        PokerHand pokerHand = new PokerHand(cardsStr);

        Assert.assertTrue(PokerRankingHelper.isThreeOfAKind(pokerHand));
    }

}
