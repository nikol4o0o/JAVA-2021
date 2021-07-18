package zad1;

import java.util.Locale;

public class RouteCipher {
    private int key;

    public RouteCipher(int key) //Constructing the class
    {
        setKey(key);//setting the key via setter
    }

    public int getKey()//getter for the key
    {
        return key;
    }

    public void setKey(int key) //setter for the key
    {
        if (key > 0)//for positive key validation
        {
            this.key = key;
        } else if (key < 0)//for negative key validation
        {
            this.key = key;
        } else//if the key is 0 we'll set it to be positive
        {
            this.key = 1;
        }
    }

    public String encrypt(String plainText) {
        int rows, columns;
        columns = Math.abs(key);//getting the absolute value because we need to initialize the columns as positive
        plainText = plainText.trim();//removing all the characters, which are punctuation
        plainText = plainText.replaceAll("\\s", "");//replacing all the empty spaces
        plainText = plainText.toUpperCase(Locale.ROOT);//validating the input to upper case as shown

        //if it fits perfectly we do not need to add Xes to the blank spaces in the matrix
        if (plainText.length() % columns == 0) {
            rows = plainText.length() / columns;//setting the needed rows

            //if it does not fit we add Xes to the blank spaces
        } else {
            while (plainText.length() % columns != 0) {
                plainText += 'X';
            }
            rows = plainText.length() / columns;//setting the needed rows
        }

        char[][] array = new char[rows][columns];//creating the char array with the size we need
        //initializing it with the transformed input we have
        for (int i = 0, k = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[i][j] = plainText.toCharArray()[k];
                k = ++k;
            }
        }
        //printing the message in a table
        System.out.println("Message in a table");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        //the case when we read from the upper left corner down(positive key)
        char[][] tArray = new char[columns][rows];//creating the transpose matrix
        //Lets have the example: hello world and the key is 5 :)                H W    /encoded message is/
        for (int j = 0; j < columns; j++) {            //  H E L L O -->    E O   /reading in spiral way/
            for (int i = 0; i < rows; i++) {          //   W O R L D -->    L R --> HWORLDOLLE
                tArray[j][i] = array[i][j];          //                     L L
            }                                       //                      O D
        }
        //the case when we read from the bottom right corner upwards(negative key)
        //we get the transposed matrix and rearrange it
        if (key < 0)                                        //  H W        D O   /encoded message is/
        {                                               //   E O        L L
            tArray = horizontalReflection(tArray);      //    L R -->    R L
            tArray = verticalReflection(tArray);       //     L L -->    O E -->  DOLLEHWORL
            return readSpiral(rows, columns, tArray); //      O D        W H
        }                                           //
        return readSpiral(rows, columns, tArray);
    }

    public String decrypt(String cipherText) {
        int rows = Math.abs(key);//getting the absolute value because we need to initialize the rows as positive
        int columns = cipherText.length() / rows;
        //temporary variables because we are modifying them
        int tempRows = rows;
        int tempColumns = columns;
        char[] val = cipherText.toCharArray();//getiing the string to char array
        char[][] newArr = new char[tempRows][tempColumns];//creating new array
        String newString = "";//the string we are going to use to store the result
        /*
        tempRows - ending row index
        tempColumns - ending column index */
        int startRowIndex = 0, startColumnIndex = 0;
        for (int j = 0; j < cipherText.length(); j++) {
            while (startRowIndex < tempRows && startColumnIndex < tempColumns) {
                //Print the first row from the remaining rows
                for (int i = startColumnIndex; i < tempColumns; ++i) {
                    newArr[startRowIndex][i] = val[j++];
                }

                startRowIndex++;

                // Print the last column from the remaining columns
                for (int i = startRowIndex; i < tempRows; ++i) {
                    newArr[i][tempColumns - 1] = val[j++];
                }
                tempColumns--;

                // Print the last row from the remaining rows
                if (startRowIndex < tempRows) {
                    for (int i = tempColumns - 1; i >= startColumnIndex; --i) {
                        newArr[tempRows - 1][i] = val[j++];
                    }
                    tempRows--;
                }

                // Print the first column from the remaining columns
                if (startColumnIndex < tempColumns) {
                    for (int i = tempRows - 1; i >= startRowIndex; --i) {
                        newArr[i][startColumnIndex] = val[j++];
                    }
                    startColumnIndex++;
                }
            }
        }
        //for the positive key we read the matrix and adding to the string variable in normal way
        if (key > 0) {
            for (int j = 0; j < columns; j++) {
                for (int i = 0; i < rows; i++) {
                    if (newArr[i][j] != 'X')
                        newString += newArr[i][j];
                }
            }
        }
        //for the negative key we read the matrix and adding to the string variable in reverse way and start
        else {
            for (int j = columns - 1; j >= 0; j--) {
                for (int i = rows - 1; i >= 0; i--) {
                    if (newArr[i][j] != 'X')
                        newString += newArr[i][j];
                }
            }
        }
        return newString;
    }



    //method to help us transform the matrix in a horizontal reflection
    private String readSpiral(int rows, int columns, char[][] tArray) {
        int startRowIndex = 0, startColumnIndex = 0;//starting row and column values
        String encodedMessage = "";//string to store the readed message

        while (startRowIndex < columns && startColumnIndex < rows) {
            // Print the first row from the remaining rows
            for (int i = startColumnIndex; i < rows; ++i) {
                encodedMessage += tArray[startRowIndex][i];
            }
            startRowIndex++;

            // Print the last column from the remaining columns
            for (int i = startRowIndex; i < columns; ++i) {
                encodedMessage += tArray[i][rows - 1];
                // System.out.print(tArray[i][rows - 1] + " ");
            }
            rows--;

            // Print the last row from the remaining rows
            if (startRowIndex < columns) {
                for (int i = rows - 1; i >= startColumnIndex; --i) {
                    encodedMessage += tArray[columns - 1][i];
                    //System.out.print(tArray[columns - 1][i] + " ");
                }
                columns--;
            }

            // Print the first column from the remaining  columns
            if (startColumnIndex < rows) {
                for (int i = columns - 1; i >= startRowIndex; --i) {
                    encodedMessage += tArray[i][startColumnIndex];
                }
                startColumnIndex++;
            }
        }
        return encodedMessage;
    }

    //method to help us transform the matrix in a horizontal reflection
    private char[][] horizontalReflection(char[][] array) {
        int m = array.length;
        int n = array[0].length;
        char temp = ' ';
        for (int i = 0; i < m / 2; i++) {
            for (int j = 0; j < n; j++) {
                temp = array[i][j];
                array[i][j] = array[m - (i + 1)][j];
                array[m - (i + 1)][j] = temp;
            }
        }
        return array;
    }

    //method to help us transform the matrix in a vertical reflection
    private char[][] verticalReflection(char[][] array)
    {
        int m = array.length;
        int n = array[0].length;
        char temp = ' ';
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m; j++) {
                temp = array[j][i];
                array[j][i] = array[j][n - (i + 1)];
                array[j][n - (i + 1)] = temp;
            }
        }
        return array;
    }

    @Override
    public String toString() {
        return String.format("The word is:");
    }
}
