package com.clarusone.poker.helper;

import com.clarusone.poker.PokerHand;
import com.clarusone.poker.model.Card;
import com.clarusone.poker.model.CardSuit;

import java.util.Arrays;
import java.util.List;

public class PokerRankingHelper {

    public static final int NO_OF_RANKS_IN_A_DECK = 13;
    public static final int NO_OF_TYPE_OF_SUITS_IN_A_DECK = 4;
    public static final int MAX_NO_OF_SAME_SUIT_IN_A_HAND = 5;

    private PokerRankingHelper() {
    }

    public boolean isRoyalFlush(PokerHand pokerHand) {
        return false;
    }

    public boolean isStraightFlush() {
        return false;
    }

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
     * If all ranks have the same suit and not in sequence.
     * @param pokerHand
     * @return
     */
    public static boolean isFlush(PokerHand pokerHand) {
        return isAllRanksOfSameSuit(pokerHand) && !isInSequence(pokerHand);
    }

    /**
     * If all ranks are in sequence and all ranks are not of the same suit.
     * @param pokerHand
     * @return
     */
    public static boolean isStraight(PokerHand pokerHand) {
        boolean isInSequence = isInSequence(pokerHand);
        return false;
    }

    /**
     * If all 5 ranks are of the same suit in a poker hand.
     * @param pokerHand
     * @return
     */
    private static boolean isAllRanksOfSameSuit(PokerHand pokerHand) {
        int[] suitDistribution = pokerHand.getSuitDistribution();
        int[] newCopy = Arrays.copyOf(suitDistribution, suitDistribution.length);
        Arrays.sort(newCopy);
        int count = Arrays.binarySearch(suitDistribution, MAX_NO_OF_SAME_SUIT_IN_A_HAND);
        return (count == MAX_NO_OF_SAME_SUIT_IN_A_HAND);
    }

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

    public static boolean isTwoPairs(PokerHand pokerHand) {
        int[] rankDistribution = pokerHand.getRankDistribution();
        int noOfPairs = 0;
        for (int i = NO_OF_RANKS_IN_A_DECK - 1; i >= 0; i--) {
            if (rankDistribution[i] == 2) {
                noOfPairs++;
            }
        }
        return (noOfPairs == 2);
    }

    public static boolean isOnePair(PokerHand pokerHand) {
        int[] rankDistribution = pokerHand.getRankDistribution();
        for (int i = NO_OF_RANKS_IN_A_DECK - 1; i >= 0; i--) {
            if (rankDistribution[i] == 2) {
                return true;
            }
        }
        return false;
    }

    /**
     * If all ranks are unique and not in sequence.
     */
    public static boolean isHighCard(PokerHand pokerHand) {
        int[] rankDistribution = pokerHand.getRankDistribution();
        return !containsMoreRank(rankDistribution) && !isInSequence(pokerHand);
    }

    private static boolean containsMoreRank(int[] rankDistribution) {
        boolean hasMoreCount = true;
        for (int i = rankDistribution.length - 1; i >= 0; i--) {
            if (rankDistribution[i] > 1) {
                hasMoreCount = false; // found a rank with more counts
                break;
            }
        }
        return hasMoreCount;
    }

    private static boolean isInSequence(PokerHand pokerHand) {
        List<Card> cards = pokerHand.getCards();
        int ordinalPrev = cards.get(0).getCardRank().ordinal();
        for (int i = 1; i < cards.size() - 1; i++) {
            int ordinalCurrent = cards.get(i).getCardRank().ordinal();
            if (ordinalCurrent - ordinalPrev != 1) {
                return false;
            }
            ordinalPrev = ordinalCurrent;
        }
        return true;
    }

    public static boolean isOfSameSuit(PokerHand pokerHand) {
        List<Card> cards = pokerHand.getCards();
        CardSuit cardSuit = cards.get(0).getCardSuit();

        for (int i = 1; i < cards.size(); i++) {
            if (!cards.get(i).getCardSuit().equals(cardSuit)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PokerHand pokerHand = new PokerHand("AH KH QH JH TH");
        isAllRanksOfSameSuit(pokerHand);
    }
}
