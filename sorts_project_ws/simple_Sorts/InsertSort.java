package simple_Sorts;

class InsertSort {
    static void sort(int arr[]) {
        long startTime = System.nanoTime();
        int buff;
        for(int marker = 1; marker < arr.length; marker++) {
            buff = arr[marker];
            for (int i = marker-1; i >= 0; i--)
                if(arr[i] > buff){
                    arr[i+1] = arr[i];
                    arr[i] = buff;
                }
        }
        System.out.println(System.nanoTime() - startTime);
    }
}