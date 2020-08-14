package nontrivial;

public class QuickSortImproved {
    
    private static int[] arr;

    public static long sort(int inputArr[])
    {
        long start = System.nanoTime();

        arr = inputArr;
        reqSort(0, arr.length - 1);

        return System.nanoTime() - start;
    }

    private static void reqSort(int start, int end)
    {
        if (end - start < 3)
            manualSort(start, end);
        else
        {
            int mid = doSort(start, end);
            reqSort(start, mid - 1);
            reqSort(mid + 1, end);
        }
    }

    private static int doSort(int start, int end)
    {
        manualSort(start, end);
        int splitter = arr[(end + start)/2];
        swap((end + start)/2, end - 1);
        int left = start + 1;
        int right = end - 2;
        while (true)
        {
            while (arr[left] < splitter)
                left++;
            while (right > 0 && arr[right] > splitter)
                right--;
            if (left >= right)
                break;
            swap(left, right);
        }
        swap(left, end - 1);
        return left;
    }

    private static void manualSort(int start, int end)
    {
        if (end - start <= 0)
            return;
        if (arr[end] < arr[start])
            swap(end, start);
        int mid = (end + start)/2;
        if (mid == start)
            return;
        if (arr[mid] < arr[start])
            swap(start, mid);
        if (arr[end] < arr[mid])
            swap(mid, end);
    }

    private static void swap(int a, int b)
    {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}