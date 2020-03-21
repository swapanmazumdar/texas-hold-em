package com.clarusone.poker.helper;

import com.clarusone.poker.model.Card;
import com.clarusone.poker.model.CardRank;
import com.clarusone.poker.model.CardSuit;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PokerHandParserTest {

    @Test
    public void should_ParseSuccessfully_When_ValidCardsString() {
        String cardsStr = "KS 2H 5C JD TD";
        String[] expecteds = {"KS", "2H", "5C", "JD", "TD"};
        String[] actuals = PokerHandParser.parseCardsAs2Chars(cardsStr);
        Assert.assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void should_ReturnNull_When_InputParamIsNull() {
        String cardsStr = null;
        String[] expected = null;
        String[] actual = PokerHandParser.parseCardsAs2Chars(cardsStr);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void should_PrepareCardsListFromCardStr() {
        String pokerHand = "KS 2H 5C JD TD";
        List<Card> actual = PokerHandParser.prepareCardsFromCardStr(pokerHand);

        List<Card> expected = new ArrayList<>();
        Card.CardBuilder builder = new Card.CardBuilder(CardRank.KING, CardSuit.SPADES);
        expected.add(builder.build());
        builder = new Card.CardBuilder(CardRank.TWO, CardSuit.HEARTS);
        expected.add(builder.build());
        builder = new Card.CardBuilder(CardRank.FIVE, CardSuit.CLUBS);
        expected.add(builder.build());
        builder = new Card.CardBuilder(CardRank.JACK, CardSuit.DIAMONDS);
        expected.add(builder.build());
        builder = new Card.CardBuilder(CardRank.TEN, CardSuit.DIAMONDS);
        expected.add(builder.build());

        Assert.assertEquals(expected, actual);
    }
}
