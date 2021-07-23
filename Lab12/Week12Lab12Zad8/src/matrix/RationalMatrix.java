package matrix;

public class RationalMatrix extends GenericMatrix<Rational> {
    @Override
    protected Rational add(Rational element1, Rational element2) {
        return element1.add(element2);
    }

    @Override
    protected Rational multiply(Rational element1, Rational element2) {
        return element1.multiply(element2);
    }

    @Override
    protected Rational zero() {
        return new Rational(0, 1);
    }
}
