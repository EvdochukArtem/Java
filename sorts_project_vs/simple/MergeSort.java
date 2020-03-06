package simple;

public class MergeSort {

    private static int arr[];

    public static long sort (int inputArr[])
    {
        long start = System.nanoTime();

        arr = inputArr;
        int tmpArr[] = new int[arr.length];
        recMerge(tmpArr, 0, arr.length - 1);

        return System.nanoTime() - start;
    }

    private static void recMerge (int tmpArr[], int start, int end)
    {
        if (start == end)
            return;
        int mid = (end + start)/2;
        recMerge(tmpArr, start, mid);
        recMerge(tmpArr, mid + 1, end);
        merge(tmpArr, start, end);
    }

    private static void merge (int tmpArr[], int startBound, int endBound)
    {
        int start = startBound;
        int midBound = (endBound + startBound)/2;
        int mid = midBound + 1;
        int i = 0;

        while (start <= midBound && mid <= endBound)
            if (arr[start] < arr[mid])
                tmpArr[i++] = arr[start++];
            else
                tmpArr[i++] = arr[mid++];
        while (start <= midBound)
            tmpArr[i++] = arr[start++];
        while (mid <= endBound)
            tmpArr[i++] = arr[mid++];
        for (i = 0; i < endBound - startBound + 1; i++)
            arr[startBound + i] = tmpArr[i];
    }
    
}