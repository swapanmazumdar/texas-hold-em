package com.clarusone.poker.helper;

import com.clarusone.poker.model.Card;
import com.clarusone.poker.model.CardRank;
import com.clarusone.poker.model.CardSuit;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PokerHandCardParserTest {

    @Test
    public void test_PrepareCardsListFromCardStr() {
        String pokerHand = "KS 2H 5C JD TD";
        List<Card> actual = PokerHandCardParser.prepareCardsListFromCardStr(pokerHand);

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
