package providers;

import com.services.Cipherable;

import java.util.Random;

public class Wrapper
{
    private int size;

    public Wrapper()
    {
        setSize(1);
    }

    public Wrapper(int size)
    {
        setSize(size);
    }

    public int getSize()
    {
        return size;
    }

    public void setSize(int size)
    {
        if(size>0)
        this.size = size;
        else
            size=1;
    }

    class FixedRandom implements Cipherable
    {
        @Override
        public char[] getSecretChars(int seed)
        {
            char[] randomSymbols = new char[size];
            Random random = new Random(seed);
            for (int i = 0; i < randomSymbols.length; i++)
            {
                randomSymbols[i] = (char) (random.nextInt(26) + 65);
            }

            return randomSymbols;
        }
    }

    class FixesSelection implements Cipherable
    {
            @Override
            public char[] getSecretChars(int seed)
            {
            Random generator = new Random();
            int randomIndex; // случаен индекс за попълване на масива randomSymbolsResult

            char[] randomSymbolsResult = new char[size];

            // масив, който ще съхранява seed на брой случайно генерирани символи
            char[] randomGeneratedSymbols = new char[seed];

            for(int i = 0; i < randomGeneratedSymbols.length; i++)
            {
                randomGeneratedSymbols[i] = (char)(generator.nextInt(26) + 65);
            }

            // попълване на масива randomSymbolsResult със случайно генериран индекс,
            // като се вземе стойността на масива randomGeneratedSymbols в този индекс
            // по този начин се формира произволна последователност от символите
            for(int i = 0; i < randomSymbolsResult.length; i++)
            {
                randomIndex = generator.nextInt(seed);
                randomSymbolsResult[i] = randomGeneratedSymbols[randomIndex];
            }

            return randomSymbolsResult;
        }
    }

    public Cipherable makeFixedRandom()
    {
        return new FixesSelection();
    }

    public Cipherable makeFixedSelection()
    {
        return new FixedRandom();
    }

}
