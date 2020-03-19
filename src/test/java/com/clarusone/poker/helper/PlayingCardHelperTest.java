package com.clarusone.poker.helper;

import org.junit.Assert;
import org.junit.Test;

public class PlayingCardHelperTest {

    @Test
    public void should_ParseSuccessfully_When_ValidCardsString() {
        String cardsStr = "KS 2H 5C JD TD";
        String[] expecteds = {"KS", "2H", "5C", "JD", "TD"};
        String[] actuals = PlayingCardHelper.parseCards(cardsStr);
        Assert.assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void should_ReturnNull_When_InputParamIsNull() {
        String cardsStr = null;
        String[] expected = null;
        String[] actual = PlayingCardHelper.parseCards(cardsStr);
        Assert.assertArrayEquals(expected, actual);
    }

}
