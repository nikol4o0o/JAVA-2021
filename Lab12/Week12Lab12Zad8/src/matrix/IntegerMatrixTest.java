package matrix;

public class IntegerMatrixTest {
    public static void main(String[] args) {
        IntegerMatrix integerMatrix = new IntegerMatrix();
        Integer[][] matrix1 = {
                {1, 1, 1},
                {2, 2, 2}
        };
        Integer[][] matrix2 = {
                {3, 4, 5},
                {1, 6, 3}
        };
        Number[][] matrix3 = integerMatrix.addMatrix(matrix1, matrix2);
        GenericMatrix.printResult(matrix1, matrix2, matrix3, '+');
    }
}
