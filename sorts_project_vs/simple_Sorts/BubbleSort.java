package simple_Sorts;

class BubbelSort {
    static void sort(int arr[]) {
        long startTime = System.nanoTime();
        for (int i = arr.length; i > 0; i--)
            for (int j = 0; j < i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        System.out.println(System.nanoTime() - startTime);
    }
}