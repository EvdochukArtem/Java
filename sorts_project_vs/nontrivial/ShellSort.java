package nontrivial;

public class ShellSort {

    public static long sort (int arr[])
    {
        long start = System.nanoTime();

        int h = intervalCalc(arr.length);
        int tmp, out, in;

        while (h > 0)
        {
            for (out = h; out < arr.length; out += h)
            {
                tmp = arr[out];
                in = out;
                while (in > h - 1 && arr[in - h] > tmp)
                {
                    arr[in] = arr[in - h];
                    in -= h;
                }
                arr[in] = tmp;
            }
            h = (h - 1)/3;
        }

        return System.nanoTime() - start;
    }

    private static int intervalCalc (int length)
    {
        int h = 1;
        while (3*h + 1 < length)
            h = 3*h + 1;
        return h;
    }
}