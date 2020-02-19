public class StackIsEmptyException extends Exception
{
    private static final long serialVersionUID = 1133877243401712701L;

    StackIsEmptyException()
    {
        System.out.println("Stack is empty!");
    }
}