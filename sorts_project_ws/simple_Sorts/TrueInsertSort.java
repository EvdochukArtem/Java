package simple_Sorts;

class TrueInsertSort {
    static void sort(int arr[]) {
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
        System.out.println(System.nanoTime() - startTime);
    }
}