package com.clarusone.poker.helper;

import com.clarusone.poker.PokerHand;
import com.clarusone.poker.model.Card;
import com.clarusone.poker.model.CardRank;
import com.clarusone.poker.model.PokerRanking;

import java.util.Arrays;
import java.util.List;

public class PokerRankingHelper {

    public static final int NO_OF_RANKS_IN_A_DECK = 13;
    public static final int NO_OF_TYPE_OF_SUITS_IN_A_DECK = 4;
    private static final int MAX_NO_OF_SAME_SUIT_IN_A_HAND = 5;
    private static final int THREE_OF_A_KIND = 3;

    private PokerRankingHelper() {
    }

    /**
     * Is an ace-high straight flush and all ranks are of the same suit.
     */
    public static boolean isRoyalFlush(PokerHand pokerHand) {
        return hasAceHighStraightFlush(pokerHand) && hasSameSuit(pokerHand);
    }

    /**
     * Is an ace-high straight flush. It contains Ace, King, Queen, Jack & Ten.
     */
    private static boolean hasAceHighStraightFlush(PokerHand pokerHand) {
        List<Card> cards = pokerHand.getCards();
        // CardSuit can be null since it is not part of
        // Search for presence of Ace, King, Queen, Jack & Ten
        if (cards.contains(new Card.CardBuilder(CardRank.ACE, null).build())
                && cards.contains(new Card.CardBuilder(CardRank.KING, null).build())
                && cards.contains(new Card.CardBuilder(CardRank.QUEEN, null).build())
                && cards.contains(new Card.CardBuilder(CardRank.JACK, null).build())
                && cards.contains(new Card.CardBuilder(CardRank.TEN, null).build())) {
            return true;
        }
        return false;
    }

    /**
     * Is a straight flush; has cards in sequence and all in same suit.
     */
    public static boolean isStraightFlush(PokerHand pokerHand) {
        return isStraight(pokerHand) && hasSameSuit(pokerHand);
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

    /**
     * Has 3 of a kind and a pair.
     */
    public static boolean isFullHouse(PokerHand pokerHand) {
        return isThreeOfAKind(pokerHand) && hasOnePairOnly(pokerHand);
    }

    /**
     * Are all ranks of the same suit and not in sequence.
     */
    public static boolean isFlush(PokerHand pokerHand) {
        return hasSameSuit(pokerHand) && !isInSequence(pokerHand);
    }

    /**
     * Are all ranks in sequence.
     */
    public static boolean isStraight(PokerHand pokerHand) {
        return isInSequence(pokerHand);
    }

    /**
     * Is three of a kind.
     */
    public static boolean isThreeOfAKind(PokerHand pokerHand) {
        int[] rankDistribution = pokerHand.getRankDistribution();
        Arrays.sort(rankDistribution);
        int index = Arrays.binarySearch(rankDistribution, THREE_OF_A_KIND);
        return index >= 0;
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
     * Has one pair only.
     */
    public static boolean hasOnePairOnly(PokerHand pokerHand) {
        int[] rankDistribution = pokerHand.getRankDistribution();
        int count = 0;
        for (int i = 0; i < rankDistribution.length; i++) {
            if (rankDistribution[i] == 2) {
                count++;
            }
        }
        return count == 1;
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
        int count = 1;
        for (int i = 1; i < cards.size(); i++) {
            if (cardRank.compareTo(cards.get(i).getCardRank()) == -1) { // should have -1 for 5.compareTo(6)
                count++;
            }
            cardRank = cards.get(i).getCardRank();
        }
        if (count == 5) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Are all 5 ranks of the same suit in a poker hand by checking the suit distribution and searching for maximum
     * number of a suit.
     */
    private static boolean hasSameSuit(PokerHand pokerHand) {
        int[] suitDistribution = pokerHand.getSuitDistribution();
        int count = Arrays.binarySearch(suitDistribution, MAX_NO_OF_SAME_SUIT_IN_A_HAND);
        return (count >= 0); // a positive value means there exist maximum no. of a type of a suit
    }

    public static PokerRanking rank(PokerHand pokerHand) {
        if (isRoyalFlush(pokerHand)) {
            return PokerRanking.ROYAL_FLUSH;
        } else if (isStraightFlush(pokerHand)) {
            return PokerRanking.STRAIGHT_FLUSH;
        } else if (isFourOfAKind(pokerHand)) {
            return PokerRanking.FOUR_OF_A_KIND;
        } else if (isFullHouse(pokerHand)) {
            return PokerRanking.FULL_HOUSE;
        } else if (isFlush(pokerHand)) {
            return PokerRanking.FLUSH;
        } else if (isStraight(pokerHand)) {
            return PokerRanking.STRAIGHT;
        } else if (isThreeOfAKind(pokerHand)) {
            return PokerRanking.THREE_OF_A_KIND;
        } else if (hasTwoPairs(pokerHand)) {
            return PokerRanking.TWO_PAIRS;
        } else if (hasOnePairOnly(pokerHand)) {
            return PokerRanking.ONE_PAIR;
        } else {
            return PokerRanking.HIGH_CARD;
        }
    }
}
