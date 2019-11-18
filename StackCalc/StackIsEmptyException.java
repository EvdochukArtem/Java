package StackCalc;

public class StackIsEmptyException extends Exception
{
    StackIsEmptyException ()
    {
        System.out.println("Stack is empty!");
    }
}