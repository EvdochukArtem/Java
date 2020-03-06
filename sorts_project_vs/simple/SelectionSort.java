package simple;

public class SelectionSort {

    public static long sort(int arr[])
    {
        long start = System.nanoTime();

        int min;
        for (int i = 0; i < arr.length - 1; i++)
        {
            min = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[min])
                    min = j;
            int tmp = arr[min];
            arr[min] = arr[i];
            arr[i] = tmp;
        }

        return System.nanoTime() - start;
    }
}