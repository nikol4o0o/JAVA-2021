package providers;

import java.util.Arrays;

public class Result
{
    private int data;
    private char[] chars;

    public Result(int data, char[] chars)
    {
        setData(data);
        setChars(chars);
    }

    public int getData()
    {
        return data;
    }

    public void setData(int data)
    {
        if (data > 0)
            this.data = data;
        else
            this.data = 1;
    }

    public void setChars(char[] chars)
    {
        this.chars = chars.clone();
    }

    public char[] getChars()
    {
        int len = chars.length;
        char[] temp = new char[len];
        for (int i = 0; i < len; i++)
        {
            temp[i] = chars[i];
        }
        return temp;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("Data: " + data + "%n Chars: ");
        for (int i = 0; i < chars.length; i++) {
            string.append(chars[i]).append(" ");
        }
        return string.toString();
    }
}


