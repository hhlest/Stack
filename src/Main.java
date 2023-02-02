
public class Main {
    public static void main(String[] args) {
        String str1 = "A";
        String str2 = "B";
        String str3 = "C";

        Stack myStack = new Stack();
        myStack.addToStack(str1);
        myStack.addToStack(str2);
        myStack.addToStack(str3);
        System.out.println(myStack);

        myStack.removeLast();
        System.out.println(myStack);

        System.out.println(myStack.getLast());
        System.out.println(myStack.copyLast());

        System.out.print("One reference for two objects: " );
        System.out.println(myStack.getLast() == myStack.copyLast());
        System.out.print("Two equivalent objects: " );
        System.out.println(myStack.getLast().equals(myStack.copyLast()));
    }
}
