package simple_Sorts;

class InsertSort {
    static long sort(int arr[]) {
        //System.out.print("Insert Sort:\t\t");
        long startTime = System.nanoTime();

        int buff;
        //начинаем с второго элемента и до конца
        for(int marker = 1; marker < arr.length; marker++)
        {
            //помещаем его в буфер
            buff = arr[marker];
            for (int i = marker-1; i >= 0; i--) 
            //перебираем все элементы перед ним
                if(arr[i] > buff){ //пока не найдем элемент меньше 
                    arr[i+1] = arr[i]; //меняем их местами
                    arr[i] = buff;
                }
        }
        
        long result = System.nanoTime() - startTime;
        //System.out.println(result);
        return result;
    }

    static long sort1(int arr[]) {
        //System.out.print("Insert Sort1:\t\t");
        long startTime = System.nanoTime();

        //начинаем с второго элемента и до конца
        for(int marker = 1; marker < arr.length; marker++)
        {
            //помещаем его в буфер
            int buff = arr[marker];
            for (int i = marker-1; i >= 0; i--) 
            //перебираем все элементы перед ним
                if(arr[i] > buff){ //пока не найдем элемент меньше 
                    arr[i+1] = arr[i]; //меняем их местами
                    arr[i] = buff;
                }
        }

        long result = System.nanoTime() - startTime;
        //System.out.println(result);
        return result;
    }
}