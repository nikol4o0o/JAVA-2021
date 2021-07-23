package Zad1a;

public class DeckOfCardsTest
{
    // execute application
    public static void main( String args[] )
    {
        DeckOfCards myDeckOfCards = new DeckOfCards();
        myDeckOfCards.shuffle(); // place Cards in random order

        Card[] leftHand = new Card[5];
        Card[] rightHand = new Card[5];

        System.out.printf("%-20s%-20s\n", "Left hand:", "Right hand:");

        for (int i = 0; i < leftHand.length; ++i) {
            Card leftCard = myDeckOfCards.dealCard();
            Card rightCard = myDeckOfCards.dealCard();
            leftHand[i] = leftCard;
            rightHand[i] = rightCard;
            System.out.printf("%-20s%-20s\n", leftCard, rightCard);
        }

        int leftHandRank = myDeckOfCards.rankHand(leftHand);
        int rightHandRank = myDeckOfCards.rankHand(rightHand);
        System.out.println("\nHand values:");
        System.out.printf("%-20s%-20s\n", myDeckOfCards.getRankLabel(leftHandRank),
                myDeckOfCards.getRankLabel(rightHandRank));

        System.out.print("\nResult: ");
        if (leftHandRank < rightHandRank) {
            System.out.println("left hand is better");
        } else if (rightHandRank < leftHandRank) {
            System.out.println("right hand is better");
        } else {
            System.out.println("both hands have the same rank");
        }
        // print all 52 Cards in the order in which they are dealt
//        for ( int i = 0; i < 13; ++i )
//        {
//            // deal and print 4 Cards
//            System.out.printf( "%-20s%-20s%-20s%-20s\n",
//                    myDeckOfCards.dealCard(), myDeckOfCards.dealCard(),
//                    myDeckOfCards.dealCard(), myDeckOfCards.dealCard() );
//        } // end for
    } // end main
} // end class DeckOfCardsTest


