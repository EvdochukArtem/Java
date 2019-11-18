package StackCalc;

public class StackIsFullException extends Exception
{
    StackIsFullException ()
    {
        System.out.println("Stack is full!");
    }
}