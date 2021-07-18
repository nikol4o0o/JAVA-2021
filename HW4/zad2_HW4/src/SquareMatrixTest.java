import java.util.Random;

public class SquareMatrixTest
{
    public static void main(String[] args)
    {
        //testing the main exercise
        SquareMatrix mat = new SquareMatrix(returnRandomMatrix());
        //sout-ing the matrix using toString
        System.out.println(mat.toString());
        //testing method printAll()
        mat.printAll();
        System.out.println();
        //creating new matrix with null
        //testing for edge cases
        int[][] matr = null;
        SquareMatrix mat2 = new SquareMatrix(matr);
        System.out.println(mat2.toString());
        mat2.printAll();
    }
    //метод, който връща матрица, чиято големина е случайна в интервала [2;12], запълнена със случайни числа в интервала [0;8]
    public static int [][] returnRandomMatrix()
    {
        Random randSize = new Random();
        int size =  randSize.nextInt(11) + 2;
        int[][] matrix = new int[size][size];
        Random randElem = new Random();
        int elemArray;
        for (int i = 0; i < size; i++)
        {

            for (int j = 0; j < size; j++)
            {
                elemArray = randElem.nextInt(9);
                matrix[i][j] = elemArray;
            }
        }

        return matrix;
    }
}
