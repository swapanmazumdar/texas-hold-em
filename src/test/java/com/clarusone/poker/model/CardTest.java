package com.clarusone.poker.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

public class CardTest {

    @Test
    public void should_BuildCard_ForValidRankAndSuite() {
        Card.CardBuilder builder = new Card.CardBuilder(CardRank.ACE, CardSuit.DIAMONDS);
        Card card = builder.build();
        Assert.assertTrue(Objects.nonNull(card));
    }

    @Test
    public void should_Pass_ReflexiveEqualityTest_ForValidCards() {
        Card.CardBuilder builder = new Card.CardBuilder(CardRank.EIGHT, CardSuit.CLUBS);
        Card cludsEightCard1 = builder.build();

        builder = new Card.CardBuilder(CardRank.EIGHT, CardSuit.CLUBS);
        Card cludsEightCard2 = builder.build();
        Assert.assertEquals(cludsEightCard1, cludsEightCard2);
    }

    @Test
    public void should_Pass_SymmetricEqualityTest_ForValidCards() {
        Card.CardBuilder builder = new Card.CardBuilder(CardRank.EIGHT, CardSuit.CLUBS);
        Card cludsEightCard1 = builder.build();

        builder = new Card.CardBuilder(CardRank.EIGHT, CardSuit.CLUBS);
        Card cludsEightCard2 = builder.build();
        Assert.assertTrue(cludsEightCard1.equals(cludsEightCard2));
        Assert.assertTrue(cludsEightCard2.equals(cludsEightCard1));
    }

    @Test
    public void should_Fail_SymmetricEqualityTest_ForDifferentCards() {
        Card.CardBuilder builder = new Card.CardBuilder(CardRank.FIVE, CardSuit.DIAMONDS);
        Card cludsEightCard1 = builder.build();

        builder = new Card.CardBuilder(CardRank.EIGHT, CardSuit.CLUBS);
        Card cludsEightCard2 = builder.build();
        Assert.assertFalse(cludsEightCard1.equals(cludsEightCard2));
        Assert.assertFalse(cludsEightCard2.equals(cludsEightCard1));
    }

    //TODO transitive and consistent tests

}
