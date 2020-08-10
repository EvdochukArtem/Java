package nontrivial;

public class QuickSort {

    private static int arr[];

    public static long sort(int inputArr[])
    {
        long start = System.nanoTime();

        arr = inputArr;
        recQuickSort(0, arr.length - 1);

        return System.nanoTime() - start;
    }

    private static void recQuickSort(int start, int end)
    {
        if (end - start <= 0)
            return;
        int mid = doPart(start, end, arr[end]);
        recQuickSort(start, mid - 1);
        recQuickSort(mid + 1, end);
    }
    
    private static int doPart(int start, int end, int pivot)
    {
        int lowPtr = start - 1;
        int highPtr = end;
        while (true)
        {
            while (arr[++lowPtr] < pivot) ;
            while (highPtr > start && arr[--highPtr] > pivot) ;
            if (lowPtr >= highPtr) break;

            swap(lowPtr, highPtr);            
        }
        swap(end, lowPtr);
        return lowPtr;
    }

    private static void swap (int a, int b)
    {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}