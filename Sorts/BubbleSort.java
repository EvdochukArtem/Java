class MyArray {
    long[] arr;
    int nElem;

    MyArray(int N) {
        arr = new long [N];
        nElem = 0;
    }

    void add(long newElem) {
        arr[nElem++] = newElem;
    }

    void fillArr(int N) {
        for (nElem = 0; nElem < N && nElem < arr.length; nElem++)
            arr[nElem] = (int)(Math.random() * 100);
    }

    void display() {
        for (int i = 0; i < nElem; i++) 
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}

class BubbleSort {
    static void sort(long[] inputArr, int nElem) {
        for (int i = nElem - 1; i > 0; i--)
            for (int j = 0; j < i; j++)
                if (inputArr[j] > inputArr[j+1])
                {
                    long temp = inputArr[j];
                    inputArr[j] = inputArr[j+1];
                    inputArr[j+1] = temp;
                }
    }
}

class BubbleSortApp {
    public static void main(String[] args) {
        MyArray arrNew = new MyArray(10);
        arrNew.fillArr(10);
        arrNew.display(); 
        BubbleSort.sort(arrNew.arr, 10);
        arrNew.display();
    }   
}