package simple_Sorts;

class SelectionSort {
    static long sort(int arr[]) {
        //System.out.print("Selection Sort: \t");
        long startTime = System.nanoTime();
        int tmp;
        //Начинаем со второго элемента и до конца
        for(int mark = 1; mark < arr.length; mark++)
        //до выбранного выше
            for(int i = 0; i < mark; i++)
                if(arr[mark] < arr[i])
                { //если меньше то меняем их местами
                    tmp = arr[mark];
                    arr[mark] = arr[i];
                    arr[i] = tmp;
                }
        
        long result = System.nanoTime() - startTime;
        //System.out.println(result);
        return result;
    }

    static long sort1(int arr[]) {
        //System.out.print("Selection Sort1:\t");
        long startTime = System.nanoTime();

        //Начинаем со второго элемента и до конца
        for(int mark = 1; mark < arr.length; mark++)
        {
            int tmp;
            //до выбранного выше
            for(int i = 0; i < mark; i++)
                if(arr[mark] < arr[i])
                { //если меньше то меняем их местами
                    tmp = arr[mark];
                    arr[mark] = arr[i];
                    arr[i] = tmp;
                }
        }

        long result = System.nanoTime() - startTime;
        //System.out.println(result);
        return result;
    }

    static long sort2(int arr[]) {
        //System.out.print("Selection Sort1:\t");
        long startTime = System.nanoTime();

        //Начинаем со второго элемента и до конца
        for(int mark = 1; mark < arr.length; mark++)
        {
            //до выбранного выше
            for(int i = 0; i < mark; i++)
                if(arr[mark] < arr[i])
                { //если меньше то меняем их местами
                    int tmp = arr[mark];
                    arr[mark] = arr[i];
                    arr[i] = tmp;
                }
        }

        long result = System.nanoTime() - startTime;
        //System.out.println(result);
        return result;
    }
}