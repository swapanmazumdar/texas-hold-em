package com.clarusone.poker.helper;

import com.clarusone.poker.PokerHand;
import com.clarusone.poker.model.Card;
import com.clarusone.poker.model.CardRank;

import java.util.Arrays;
import java.util.List;

public class PokerRankingHelper {

    public static final int NO_OF_RANKS_IN_A_DECK = 13;
    public static final int NO_OF_TYPE_OF_SUITS_IN_A_DECK = 4;
    private static final int MAX_NO_OF_SAME_SUIT_IN_A_HAND = 5;
    private static String ACE_HIGH_CARDS_STR = "A K Q J T";

    private PokerRankingHelper() {
    }

    /**
     * Is an ace-high straight flush and all ranks are of the same suit.
     */
    public static boolean isRoyalFlush(PokerHand pokerHand) {
        return hasAceHighStraightFlush(pokerHand) && hasSameSuit(pokerHand);
    }

    /**
     * Is an ace-high straight flush; it contains Ace, King, Queen, Jack & Ten.
     */
    private static boolean hasAceHighStraightFlush(PokerHand pokerHand) {
        String[] cards = PokerHandParser.parseCardsAs2Chars(ACE_HIGH_CARDS_STR);
        return true;
    }

    public boolean isStraightFlush() {
        return false;
    }

    /**
     * Is there a four of a kind among the ranks.
     */
    public static boolean isFourOfAKind(PokerHand pokerHand) {
        int[] rankDistribution = pokerHand.getRankDistribution();
        for (int i = NO_OF_RANKS_IN_A_DECK - 1; i >= 0; i--) {
            if (rankDistribution[i] == 4) {
                return true;
            }
        }
        return false;
    }

    public static boolean isFullHouse(PokerHand pokerHand) {
        return false;
    }

    /**
     * Are all ranks of the same suit and not in sequence.
     */
    public static boolean isFlush(PokerHand pokerHand) {
        return hasSameSuit(pokerHand) && !isInSequence(pokerHand);
    }

    /**
     * Are all ranks in sequence and all ranks are not of the same suit.
     */
    public static boolean isStraight(PokerHand pokerHand) {
        boolean isInSequence = isInSequence(pokerHand);
        return false;
    }

    /**
     * Is three of a kind.
     */
    public static boolean isThreeOfAKind(PokerHand pokerHand) {
        int[] rankDistribution = pokerHand.getRankDistribution();
        for (int i = NO_OF_RANKS_IN_A_DECK - 1; i >= 0; i--) {
            if (rankDistribution[i] == 3) {
                return true;
            }
        }
        new IllegalArgumentException();
        return false;
    }

    /**
     * Has two pairs.
     */
    public static boolean hasTwoPairs(PokerHand pokerHand) {
        int[] rankDistribution = pokerHand.getRankDistribution();
        int noOfPairs = 0;
        for (int i = NO_OF_RANKS_IN_A_DECK - 1; i >= 0; i--) {
            if (rankDistribution[i] == 2) {
                noOfPairs++;
            }
        }
        return (noOfPairs == 2);
    }

    /**
     * Has one pair.
     * Implementation: Should have used descending ordering.
     */
    public static boolean hasOnePairOnly(PokerHand pokerHand) {
        int[] rankDistribution = pokerHand.getSuitDistribution();
        Arrays.sort(rankDistribution); //
        if (rankDistribution[rankDistribution.length - 1] == 1) {
            return true;
        }
        return false;
    }

    /**
     * Has unique ranks and not in sequence.
     */
    public static boolean isHighCard(PokerHand pokerHand) {
        int[] rankDistribution = pokerHand.getRankDistribution();
        return hasUniqueRanks(rankDistribution) && !isInSequence(pokerHand);
    }

    private static boolean hasUniqueRanks(int[] rankDistribution) {
        boolean hasMoreCount = true;
        for (int i = rankDistribution.length - 1; i >= 0; i--) {
            if (rankDistribution[i] > 1) {
                hasMoreCount = false; // found a rank with more counts
                break;
            }
        }
        return hasMoreCount;
    }

    /**
     * Are all ranks in sequence.
     */
    public static boolean isInSequence(PokerHand pokerHand) {
        List<Card> cards = pokerHand.getCards();
        CardRank cardRank = cards.get(0).getCardRank();
        for (int i = 1; i < cards.size() - 1; i++) {
            if (cardRank.compareTo(cards.get(i).getCardRank()) != 1) {
                return false;
            }
            cardRank = cards.get(i).getCardRank();
        }
        return true;
    }

    /**
     * Are all 5 ranks of the same suit in a poker hand by checking the suit distribution and searching for maximum
     * number of a suit.
     */
    private static boolean hasSameSuit(PokerHand pokerHand) {
        int[] suitDistribution = pokerHand.getSuitDistribution();
        int[] newCopy = Arrays.copyOf(suitDistribution, suitDistribution.length);
        Arrays.sort(newCopy);
        int count = Arrays.binarySearch(suitDistribution, MAX_NO_OF_SAME_SUIT_IN_A_HAND);
        return (count == MAX_NO_OF_SAME_SUIT_IN_A_HAND);
    }

}
