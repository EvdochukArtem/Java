package simple_Sorts;

class SelectionSort {
    static void sort(int arr[]) {
        long startTime = System.nanoTime();
        for(int mark = 1; mark < arr.length; mark++)
            for(int i = 0; i < mark; i++)
                if(arr[mark] < arr[i]) {
                    int tmp = arr[mark];
                    arr[mark] = arr[i];
                    arr[i] = tmp;
                }
        System.out.println(System.nanoTime() - startTime);
    }
}