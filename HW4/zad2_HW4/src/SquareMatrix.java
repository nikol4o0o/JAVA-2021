
public class SquareMatrix
{
    private int[][] dataArray;
    //default constructor
    public SquareMatrix()
    {
        setDataArray(null);
    }
    //general purpose constructor
    public SquareMatrix(int[][] dataArray)
    {
        setDataArray(dataArray);
    }
    //copy constructor
    public SquareMatrix(SquareMatrix other)
    {
        this(other.dataArray);
    }
    //setter, използващ копие, за да защитим нашите данни
    public void setDataArray(int[][] dataArray)
    {
        //проверяваме дали подадената матрица не е нулевата
        if (dataArray != null && dataArray.length == dataArray[0].length)
        {
            //валидиране второ нива за проверка дали имаме квадратна матрица
                this.dataArray = new int[dataArray.length][dataArray.length];//we can use length because it is a square matrix
                for (int i = 0; i < dataArray.length; i++)
                {
                    for (int j = 0; j < dataArray.length; j++)
                    {
                        this.dataArray[i][j] = dataArray[i][j];
                    }
                }
        }
        else
        {
            //създаваме матрица, която да поеме случая, при който имаме невъведен коректно параметър
            System.out.println("Invalid matrix inputted, so it is now default 2x2 filled with 1es");
            //2x2 is default
            this.dataArray = new int[2][2];
            //запълваме с 1ци
            for (int i = 0; i < 2; i++)
            {
                for (int j = 0; j < 2; j++)
                {
                    this.dataArray[i][j] = 1;
                }
            }
        }
    }
    //връщаме копие, за да предпазим нашите данни от злонамерни действия
    public int[][] getDataArray()
    {
        int [][] copyArray = new int[dataArray.length][dataArray.length];
        for (int i = 0; i < dataArray.length; i++)
        {
            for (int j = 0; j < dataArray.length; j++)
            {
                copyArray[i][j] = dataArray[i][j];
            }
        }
        return copyArray;
    }
    //метод, който намира максималната сума от подмарица/и
    //Методът ползва първите два реда на пъравата итерация, след това добавя нов и премества първия, като гледаме редовете два по два, в
    //зависимост колко колони имаме, събираме сумата и след това сравняваме с максималната сума, ако имаме съвпадение, ние сменяваме сумата,
    //като после сравняваме с нея
    public int findMaxSum()
    {
        int sum =0;
        int biggestSum=0;
        for (int i = 0; i <dataArray.length ; i++)
        {
            int[] first = dataArray[i];
            if(i!=dataArray.length-1)
            {
                int[] second = dataArray[i+1];

                int counter=0;
                while (counter<first.length-1)
                {

                    sum+=first[counter];
                    sum+=second[counter];

                    sum+=first[counter+1];
                    sum+=second[counter+1];

                    if(sum>biggestSum){
                        biggestSum=sum;
                    }

                    sum=0;
                    counter++;
                }

            }
            else
            {
                break;
            }

        }
        return biggestSum;
    }

    //отново въртим подобен метод, при който взимаме два по два реда, в зависимост от колоните, като този път подаваме на метода
    //максималната сума, която връщаме от предишния метод. След като направим итерациите и като намерим съвпадение с условието
    //за най-голяма сума принтираме координатите на дадената матрица като по условие може да е повече от една
    public void findMaxSumSubMatrices(int biggestSum)
    {
        int sum =0;

        for (int i = 0; i <dataArray.length ; i++)
        {
            int[] first = dataArray[i];
            if(i!=dataArray.length-1)
            {
                int[] second = dataArray[i+1];

                int counter=0;
                while (counter<first.length-1)
                {
                    //добавяме към сумата
                    sum+=first[counter];
                    sum+=second[counter];

                    sum+=first[counter+1];
                    sum+=second[counter+1];

                    if(sum == biggestSum){
                        System.out.printf("[%d,%d]\n", i, counter);
                    }
                    sum=0;
                    counter++;
                }

            }
            else
            {
                break;
            }
        }
    }

    //принтираме желаните резултати от условието на задачата
        public void printAll()
        {
            int biggestSum = findMaxSum();
            System.out.printf("Maximum sum: %d%n", biggestSum);
            System.out.print("Submatrices with max sum\n");
            findMaxSumSubMatrices(biggestSum);
        }
        //пренаписваме toString, за да е удобен за зададената на нас задача, като ползваме StringBuilder, за да избегнем копирането
        // многократно на стринг, а когато вече сме готови просто правим toString на StringBuilder, за да изведем резултата
        @Override
        public String toString()
        {
            int size = dataArray.length;
            StringBuilder matrixResult = new StringBuilder();
            matrixResult.append(size).append("x").append(size).append("\n");

            for (int i = 0; i < size; i++)
            {
                for (int j = 0; j < size; j++)
                {
                    matrixResult.append(dataArray[i][j]).append(" ");
                }
                matrixResult.append("\n");
            }

            return matrixResult.toString();
        }
    }








