package com.clarusone.poker.model;

import com.clarusone.poker.exception.InvalidCardRankException;
import org.junit.Assert;
import org.junit.Test;

public class CardRankTest {

    @Test
    public void should_Pass_ResolveAsCardRank() {
        char rank = '2';
        Assert.assertEquals(CardRank.TWO, CardRank.resolveAsCardRank(rank));

        rank = 'A';
        Assert.assertEquals(CardRank.ACE, CardRank.resolveAsCardRank(rank));

        rank = 'K';
        Assert.assertEquals(CardRank.KING, CardRank.resolveAsCardRank(rank));

        rank = 'Q';
        Assert.assertEquals(CardRank.QUEEN, CardRank.resolveAsCardRank(rank));

        rank = 'J';
        Assert.assertEquals(CardRank.JACK, CardRank.resolveAsCardRank(rank));
    }

    @Test(expected = InvalidCardRankException.class)
    public void should_Throw_InvalidCardRankException_For_InvalidCardRank() {
        char rank = 'B';
        CardRank.resolveAsCardRank(rank);
    }

}
