package simple_Sorts;

class MyArray //implements Cloneable {
{
    int arr[];
    private int maxSize;
    private int currSize;

    MyArray(int n) {
        maxSize = n;
        arr = new int[maxSize];
        currSize = 0;
    }

    void fillArr(int n) {
        for (currSize = 0; currSize < n && currSize < maxSize; currSize++)
            arr[currSize] = (int)(Math.random()*11);
    }

    void showArr() {
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }

    void arrayCompare(final int[] arr)
    {
        System.out.println("Arrays are equal: " + java.util.Arrays.equals(this.arr, arr));
    }

    int getCurrSize() {return currSize;}
}