package simple;

public class InsertSort {
    
    public static long sort(int arr[])
    {
        long startTime = System.nanoTime();

        int buff, out, in;
        for (out = 1; out < arr.length; out++)
        {
            buff = arr[out];
            in = out;
            while (in > 0 && arr[in - 1] >= buff)
            {
                arr[in] = arr[in-1];
                in--;
            }
            arr[in] = buff;
        }
        
        return System.nanoTime() - startTime;
    }
}