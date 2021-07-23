package zad9;

public class RecursiveSeries {
    public static void main(String[] args) {
        System.out.printf("%-10s%-10s\n","i","sum");

        for (int i = 1; i < 11; i++) {
            System.out.printf("%-10d%-10.2f\n",i,computeSum(i));
        }
    }

    private static double computeSum(int i) {
        if(i<=0){
            return 0;
        }
        double currentSum = i/(2.0*i+1);
        return currentSum + computeSum(--i);
    }
}
