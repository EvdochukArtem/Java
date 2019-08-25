package simple_Sorts;

class MyArray implements Cloneable {

    int arr[];
    private int maxSize;
    private int currSize;

    MyArray(int n) {
        maxSize = n;
        arr = new int[maxSize];
        currSize = 0;
    }

    @Override
    public MyArray clone() throws CloneNotSupportedException {
        MyArray clone = (MyArray)super.clone();
        return clone;
    }

    void fillArr(int n) {
        for (currSize = 0; currSize < n && currSize < maxSize; currSize++)
            arr[currSize] = (int)(Math.random()*11);
    }

    void showArr() {
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }

    int getCurrSize() {return currSize;}
}