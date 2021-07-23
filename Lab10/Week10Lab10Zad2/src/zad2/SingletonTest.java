package zad2;

public class SingletonTest
{

    public static void main(String[] args)
    {
        Signleton first = Signleton.getInstance();
        Signleton second = Signleton.getInstance();
        if(first == second)
        {
            System.out.println("Same");
        }
    }

}
