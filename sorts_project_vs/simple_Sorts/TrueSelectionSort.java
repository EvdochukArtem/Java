package simple_Sorts;

class TrueSelectionSort {
    static long sort(int arr[]) {
        //System.out.print("True Selection Sort:\t");
        long startTime = System.nanoTime();

        int out, in, min;
        for(out=0; out<arr.length-1; out++) {
            min = out; // Минимум
            for(in=out+1; in<arr.length; in++) // Внутренний цикл
                if(arr[in] < arr[min] ) // Если значение min больше,
                    min = in; // значит, найден новый минимум
            int tmp = arr[out];
            arr[out] = arr[min];
            arr[min] = tmp;
        }

        long result = System.nanoTime() - startTime;
        //System.out.println(result);
        return result;
    }
}