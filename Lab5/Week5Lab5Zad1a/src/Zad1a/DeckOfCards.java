package Zad1a;

// Fig. 7.10: DeckOfCards.java
// DeckOfCards class represents a deck of playing cards.
import java.util.Random;

public class DeckOfCards
{
    private Card deck[]; // array of Card objects
    private int currentCard; // index of next Card to be dealt
    private final int NUMBER_OF_CARDS = 52; // constant number of Cards
    private Random randomNumbers; // random number generator

    // constructor fills deck of Cards
    public DeckOfCards()
    {
        String faces[] = { "Ace", "Deuce", "Three", "Four", "Five", "Six",
                "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
        String suits[] = { "Hearts", "Diamonds", "Clubs", "Spades" };

        deck = new Card[ NUMBER_OF_CARDS ]; // create array of Card objects
        currentCard = 0; // set currentCard so first Card dealt is deck[ 0 ]
        randomNumbers = new Random(); // create random number generator

        // populate deck with Card objects
        for ( int count = 0; count < deck.length; count++ )
            deck[ count ] =
                    new Card( faces[ count % 13 ], suits[ count / 13 ] );
    } // end DeckOfCards constructor

    // shuffle deck of Cards with one-pass algorithm
    public void shuffle()
    {
        // after shuffling, dealing should start at deck[ 0 ] again
        currentCard = 0; // reinitialize currentCard

        // for each Card, pick another random Card and swap them
        for ( int first = 0; first < deck.length; first++ )
        {
            // select a random number between 0 and 51
            int second =  randomNumbers.nextInt( NUMBER_OF_CARDS );

            // swap current Card with randomly selected Card
            Card temp = deck[ first ];
            deck[ first ] = deck[ second ];
            deck[ second ] = temp;
        } // end for
    } // end method shuffle

    // deal one Card
    public Card dealCard()
    {
        // determine whether Cards remain to be dealt
        if ( currentCard < deck.length )
            return deck[ currentCard++ ]; // return current Card in array
        else
            return null; // return null to indicate that all Cards were dealt
    } // end method dealCard

    // check if hand isStraight) two cards with the same face
    public boolean isPair(Card[] hand) {
        int[] facesCount = countFaces(hand);
        for (int i = 0; i < facesCount.length; i++) {
            if (facesCount[i] == 2) {
                return true;
            }
        }
        return false;
    }

    public boolean isStraightTwoPairs(Card[] hand) {
        int[] facesCount = countFaces(hand);
        int countPairs = 0;
        for (int i = 0; i < facesCount.length; ++i) {
            if (facesCount[i] == 2) {
                ++countPairs;
                if (countPairs == 2) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isStraightThreeOfAKind(Card[] hand) {
        int[] facesCount = countFaces(hand);
        for (int i = 0; i < facesCount.length; ++i) {
            if (facesCount[i] == 3) {
                return true;
            }
        }
        return false;
    }

    public boolean isStraightFourOfAKind(Card[] hand) {
        int[] facesCount = countFaces(hand);
        for (int i = 0; i < facesCount.length; ++i) {
            if (facesCount[i] == 4) {
                return true;
            }
        }
        return false;
    }

    public boolean isFlush(Card[] hand) {
        int[] suitsCount = countSuits(hand);
        for (int i = 0; i < suitsCount.length; ++i) {
            if (suitsCount[i] == 5) {
                return true;
            }
        }
        return false;
    }

    public boolean isStraight(Card[] hand) {
        int[] facesCount = countFaces(hand);
        int count = 0;
        for (int i = 0; i < facesCount.length; ++i) {
            if (facesCount[i] == 1) {
                count++;
                if (count == 5) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }

    public boolean isFullHouse(Card[] hand) {
        return isPair(hand) && isStraightThreeOfAKind(hand);
    }

    /**
     * Determine the rank of a Hand. The lower the rank, the better the hand.
     * @param hand
     * @return
     */
    public int rankHand(Card[] hand) {
        if (isStraightFourOfAKind(hand)) {
            return 1;
        }

        if (isFullHouse(hand)) {
            return 2;
        }

        if (isFlush(hand)) {
            return 3;
        }

        if (isStraight(hand)) {
            return 4;
        }

        if (isStraightThreeOfAKind(hand)) {
            return 5;
        }

        if (isStraightTwoPairs(hand)) {
            return 6;
        }

        if (isPair(hand)) {
            return 7;
        }

        return 8;
    }

    public String getRankLabel(int rank) {
        switch (rank) {
            case 1:
                return "Four Of A Kind";
            case 2:
                return "Full House";
            case 3:
                return "Flush";
            case 4:
                return "Straight";
            case 5:
                return "Three Of A Kind";
            case 6:
                return "Two Pair";
            case 7:
                return "One Pair";
            default:
                return "none";
        }
    }

    // [numberAces, numberDeuce, numberThree, ...]
    private int[] countFaces(Card[] hand) {
        int[] facesCount = new int[13];
        for (int i = 0; i < hand.length; i++) {
            switch (hand[i].getFace()) {
                case "Ace":
                    facesCount[0]++;
                    break;
                case "Deuce":
                    facesCount[1]++;
                    break;
                case "Three":
                    facesCount[2]++;
                    break;
                case "Four":
                    facesCount[3]++;
                    break;
                case "Five":
                    facesCount[4]++;
                    break;
                case "Six":
                    facesCount[5]++;
                    break;
                case "Seven":
                    facesCount[6]++;
                    break;
                case "Eight":
                    facesCount[7]++;
                    break;
                case "Nine":
                    facesCount[8]++;
                    break;
                case "Ten":
                    facesCount[9]++;
                    break;
                case "Jack":
                    facesCount[10]++;
                    break;
                case "Queen":
                    facesCount[11]++;
                    break;
                case "King":
                    facesCount[12]++;
                    break;
            }
        }
        return facesCount;
    }

    // [numberHearts, numberClubs, numberDiamonds, numberSpades]
    private int[] countSuits(Card[] hand) {
        int[] suitsCount = new int[4];
        for (int i = 0; i < hand.length; i++) {
            switch (hand[i].getSuit()) {
                case "Hearts":
                    suitsCount[0]++;
                    break;
                case "Diamonds":
                    suitsCount[1]++;
                    break;
                case "Clubs":
                    suitsCount[2]++;
                    break;
                case "Spades":
                    suitsCount[3]++;
                    break;
            }
        }
        return suitsCount;
    }
} // end class DeckOfCards}