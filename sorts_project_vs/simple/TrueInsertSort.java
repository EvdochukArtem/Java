package simple_Sorts;

class TrueInsertSort {
    static long sort(int arr[]) {
        //System.out.print("True Insert Sort:\t");
        long startTime = System.nanoTime();

        int in, out;
        for(out=1; out<arr.length; out++) // out - разделительный маркер
        {
            int temp = arr[out]; // Скопировать помеченный элемент
            in = out; // Начать перемещения с out
            while(in>0 && arr[in-1] >= temp) // Пока не найден меньший элемент
            {
                arr[in] = arr[in-1]; // Сдвинуть элемент вправо
                --in; // Перейти на одну позицию влево
            }
            arr[in] = temp; 
        }

        long result = System.nanoTime() - startTime;
        //System.out.println(result);
        return result;
    }
}