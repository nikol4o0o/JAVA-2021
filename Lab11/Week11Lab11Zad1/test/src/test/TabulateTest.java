package test;

import com.Functions;
import com.Tabulate;
import services.Computable;

public class TabulateTest {
    public static void main(String[] args) {
        Tabulate tabulate = new Tabulate(new Functions().getSinFunction());
        tabulate.tabulate(1, 10, 2);
        System.out.println();
        Tabulate.tabulateFunction(1, 21, 21, new Computable() {
            @Override
            public double function(double x) {
                return 1.0 / x;
            }
        });
    }
}