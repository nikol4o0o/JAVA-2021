package providers;

import com.services.Cipherable;

import java.util.Arrays;

public class CipherGenerator
{
    public static Result countDistinct(Cipherable cipher, int seed)
    {
        char[] randomSymbols = cipher.getSecretChars(seed);
        int symbolCount = 0;
        boolean unique;

        for(int i = 0; i < randomSymbols.length; i++) {
            unique = true;
            for(int j = 0; j < randomSymbols.length; j++){
                if(randomSymbols[i] == randomSymbols[j] && i != j){
                    unique = false;
                    break;
                }
            }

            if(unique){
                symbolCount++;
            }
        }

        return new Result(symbolCount, randomSymbols);
    }
}
