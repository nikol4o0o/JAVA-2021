import java.util.Scanner;

public class Hamming
{

        public static void main(String[] args)
        {
            //Creating the Scanner class for the input
            Scanner input = new Scanner(System.in);
            System.out.print("Enter the first 8-bit digit:\n ");
            byte n1 = input.nextByte();//the first 8-bit digit
            System.out.print("Enter the secong 8-bit digit:\n");
            byte n2 = input.nextByte();//the second 8-bit digit

            String s1 = formatFunctionBinary(n1);
            String s2 = formatFunctionBinary(n2);
            System.out.printf(" The first digit is  %s%n The second digit is %s%n", s1, s2);
            System.out.printf(" The hamming distance is %d%n",hammingDistance(n1, n2));
        }
        //Стандартно Java премахва 0лите, затова ще използваме метод, с който ще направим, така че да се появят на
       //потребителския екран
        public static String formatFunctionBinary(byte n1)
        {
            return String.format("%8s", Integer.toBinaryString(n1 )).replace(' ', '0');
        }
        //функция, с която гледаме разликата по Hamming
       public static int hammingDistance(byte n1, byte n2)
       {
           int count = 0;
           // Първо намираме XOR на двете числа. XOR дава 1 само ако след като съберем побитово двете числа имаме
           // два различни бита например 0 + 1 = 1 и 1 + 0 = 1, при еднаквите наприме 0 + 0 и 1 + 1,
           // дава резултат нула, следователно това ни връща  число, което е различно от нула
           int xor = n1 ^ n2;
           //въртим цикъл докато не стане 0 и увеличаваме брояча на всяка итерация, в която имаме разлика
           while (xor != 0)
           {
               count++;
               //ползваме &, което е побитовият оператор за AND, който след извършване на операцията ни връща числото
               //без 1цата в бинарна, което присъединяваме на ексор и продължаваме цикъла, докато числото стане 0
               xor = xor & (xor - 1);
           }
        return count;
       }
}

