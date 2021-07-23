package MyStack;

public class MyStackTest {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();

        System.out.printf("isEmpty: %b\n", myStack.isEmpty());
        System.out.printf("Peek: %s\n", myStack.peek());
        System.out.printf("Pop: %s\n", myStack.pop());

        myStack.push("test");

        System.out.println("Pushed 'test'");

        System.out.printf("Pop: %s\n", myStack.pop());
        System.out.printf("Size: %d\n", myStack.getSize());

        System.out.printf("isEmpty: %b\n", myStack.isEmpty());
        System.out.printf("Peek: %s\n", myStack.peek());
        System.out.printf("Size: %d\n", myStack.getSize());

    }
}
