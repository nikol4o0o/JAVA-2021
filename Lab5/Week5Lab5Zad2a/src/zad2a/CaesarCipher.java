package zad2a;

public class CaesarCipher
{
    private  int shiftLenght;

    CaesarCipher(int shiftLenght)
    {
        setShiftLength(shiftLenght);
    }

    public void setShiftLength(int shiftLength)
    {
        if(shiftLength > 0)
        this.shiftLenght = shiftLength;
        else
            shiftLength = 1;
    }

    public String encode(String text)
    {
        char[] letters = text.toCharArray();
        for (int i = 0; i < letters.length; i++)
        {
            int newLetterCode;
            int lettercode = letters[i];
            if(Character.isUpperCase(lettercode) && Character.isLetter(lettercode))
            {
                int upperA = 'A';
                newLetterCode = (lettercode + shiftLenght - upperA) % 26 + upperA;
            }
            else if(!Character.isUpperCase(lettercode) && Character.isLetter(lettercode))
            {
                int lowerA = 'a';
                newLetterCode = (lettercode + shiftLenght - lowerA) % 26 + lowerA;
            }
            else
                {
                    newLetterCode = lettercode;
                }
            letters[i] = (char) newLetterCode;
        }
        return new String(letters);
    }

    public String decode(String encodedText)
    {
        char[] letters = encodedText.toCharArray();
        for (int i = 0; i < letters.length; i++)
        {
            int newLetterCode = 0;
            int lettercode = letters[i];
            if(Character.isUpperCase(lettercode) && Character.isLetter(lettercode))
            {
                int upperA = 'A';
                newLetterCode = (lettercode + (26 - shiftLenght) - upperA) % 26 + upperA;
            }
            else if(!Character.isUpperCase(lettercode) && Character.isLetter(lettercode))
            {
                int lowerA = 'a';
                newLetterCode = ((lettercode + (26 - shiftLenght) - lowerA)) % 26 + lowerA;
            }
            else
            {
                newLetterCode = lettercode;
            }
             
            letters[i] = (char) newLetterCode;
        }
        return new String(letters);
    }
}
