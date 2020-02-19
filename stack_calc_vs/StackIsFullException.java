public class StackIsFullException extends Exception
{
    private static final long serialVersionUID = 5623204503304243489L;

    StackIsFullException()
    {
        System.out.println("Stack is full!");
    }
}