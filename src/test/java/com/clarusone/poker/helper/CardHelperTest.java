package com.clarusone.poker.helper;

import org.junit.Assert;
import org.junit.Test;

public class CardHelperTest {

    @Test
    public void should_ParseSuccessfully_When_ValidCardsString() {
        String cardsStr = "KS 2H 5C JD TD";
        String[] expecteds = {"KS", "2H", "5C", "JD", "TD"};
        String[] actuals = PokerHandCardParser.parseCardsAs2Chars(cardsStr);
        Assert.assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void should_ReturnNull_When_InputParamIsNull() {
        String cardsStr = null;
        String[] expected = null;
        String[] actual = PokerHandCardParser.parseCardsAs2Chars(cardsStr);
        Assert.assertArrayEquals(expected, actual);
    }

}
