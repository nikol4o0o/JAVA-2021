package zad1b;

public class PhoneCoder
{
    private int key;

    public PhoneCoder()
    {
        setKey(1);
    }

    public PhoneCoder(int key)
    {
        setKey(key);
    }

    public int getKey()
    {
        return key;
    }

    public void setKey(int key)
    {
        if(key >=1 && key <=9) {
            this.key = key;
        }
        else {
            this.key = 1;
        }
    }

    public String encode(String phoneNumber)
    {
        if(phoneNumber == null || phoneNumber.length() != 4)
        {
            return "Invalid";
        }
        else
        {
            int originalNumber = Integer.parseInt(phoneNumber);

            int fourthDigit = originalNumber % 10;
            originalNumber /= 10;
            int thirdDigit = originalNumber % 10;
            originalNumber /= 10;
            int secondDigit = originalNumber % 10;
            originalNumber /= 10;
            int firstDigit = originalNumber % 10;

            firstDigit = (firstDigit + key) % 10;
            secondDigit = (secondDigit + key) % 10;
            thirdDigit = (thirdDigit + key) % 10;
            fourthDigit = (fourthDigit + key) % 10;

            return String.format("%d%d%d%d", thirdDigit, fourthDigit, firstDigit, secondDigit);

        }
    }

    public String decode(String codedPhoneNumber)
    {

        if (codedPhoneNumber == null || codedPhoneNumber.length() != 4)
        {
            return "Invalid";
        }
        else
            {
            int originalNumber = Integer.parseInt(codedPhoneNumber);

            int fourthDigit = originalNumber % 10;
            originalNumber /= 10;

            int thirdDigit = originalNumber % 10;
            originalNumber /= 10;

            int secondDigit = originalNumber % 10;
            originalNumber /= 10;

            int firstDigit = originalNumber % 10;

            firstDigit = (firstDigit + (10 - key)) % 10;
            secondDigit = (secondDigit + (10 - key)) % 10;
            thirdDigit = (thirdDigit + (10 - key)) % 10;
            fourthDigit = (fourthDigit + (10 - key)) % 10;

            return String.format("%d%d%d%d", thirdDigit, fourthDigit, firstDigit, secondDigit);
        }
    }

    public String toString()
    {
        return String.format("Phone coder: %d", key);
    }

}
