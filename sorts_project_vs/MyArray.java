class MyArray //implements Cloneable {
{
    int arr[];
    private int maxSize;

    MyArray(int n) {
        maxSize = n;
        arr = new int[maxSize];
    }

    void fillArr() {
        for (int i = 0; i < arr.length; i++)
            arr[i] = (int)(101 - Math.random()*202);
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
}