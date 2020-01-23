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
        if (!isFull())
            arr[++top] = input;
        else
            throw new StackIsFullException();
    }

    void show ()
    {
        if (isEmpty())
            new StackIsEmptyException();

        System.out.println("Elements of the Stack:");
        for (int i = 0; i <= top; i++)
            System.out.print(arr[i] + " ");
    }

    int size ()
    {
        return top + 1;
    }

    private boolean isFull()
    {
        return (top + 1 == arr.length);
    }

    private boolean isEmpty()
    {
        return (top == -1);
    }
}