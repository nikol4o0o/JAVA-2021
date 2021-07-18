package coins;

public class MonetaryCoinTest {
    public static void main(String[] args) {

        MonetaryCoin coin1 = new MonetaryCoin(Face.TAIL, 1);
        MonetaryCoin coin2 = new MonetaryCoin(Face.HEAD, 5);

        int coinsSum = coin1.getValue() + coin2.getValue();
        System.out.printf("The sum of the coins is: %d \n", coinsSum);

        System.out.println("Monetary coins info:");
        System.out.println("Coin 1: " + coin1.toString());
        System.out.println("Coin 2: " + coin2.toString());


        // flip second coin 5 times
        System.out.println("Flipping the coin number 2 5 times to test the Random:");

        for(int i = 0; i < 5; i++){
            coin2.flip();
            System.out.println(coin2.getFace());
        }
    }
}

