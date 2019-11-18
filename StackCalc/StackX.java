package StackCalc;

class StackX <T>
{
    private T[] arr;
    private int top;

    StackX (T[] arr)
    {
        this.arr = arr;
        top= -1;
    }

    T peek () throws StackIsEmptyException
    {
        if (!isEmpty())
            return arr[top];
        else
            throw new StackIsEmptyException();
    }

    T pop() throws StackIsEmptyException
    {
        if (!isEmpty())
            return arr[top--];
        else
            throw new StackIsEmptyException();
    }

    void push (T input) throws StackIsFullException
    {
        if (!isEmpty())
            arr[++top] = input;
        else
            throw new StackIsFullException();
    }

    private boolean isFull()
    {
        return (top == arr.length);
    }

    private boolean isEmpty()
    {
        return (top == -1);
    }
}

/*class StackIsEmptyException extends Exception   //Make separate file
{
    StackIsEmptyException ()
    {
        System.out.println("Stack is empty!");
    }
}

class StackIsFullException extends Exception   //Make separate file
{
    StackIsFullException ()
    {
        System.out.println("Stack is full!");
    }
}*/