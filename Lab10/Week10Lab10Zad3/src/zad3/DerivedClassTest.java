package zad3;

public class DerivedClassTest
{
    public static void main(String[] args)
    {
        DerivedClass derivedClass = new DerivedClass();
        BaseClass baseClass = (BaseClass) derivedClass;
        baseClass.firstMethod();
    }
}
