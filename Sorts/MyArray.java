package sorts;

class MyArray {
    long [] arr;
    int nElem;

    MyArray(int N) {
        arr = new long [N];
        nElem = 0;
    }

    void add(long newElem) {
        arr[nElem++] = newElem;
    }

    void fillArr(int N) {
        for (int i = 0; i < N && i < arr.length; i++)
            arr[i] = (int)(Math.random() * 100);
    }

    void display() {
        for (int i = 0; i < nElem; i++) 
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}