package matrix;

public class IntegerMatrix extends GenericMatrix<Integer> {
    @Override
    protected Integer add(Integer element1, Integer element2) {
        return element1 + element2;
    }

    @Override
    protected Integer multiply(Integer element1, Integer element2) {
        return element1 * element2;
    }

    @Override
    protected Integer zero() {
        return 0;
    }
}
