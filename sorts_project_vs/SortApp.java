import simple.*;
import nontrivial.*;

class SortApp {
    static MyArray arrToSort;
    static MyArray arrUnsortedCopy;
    public static void main(String[] args) {

        int elemNum = 100000;
        fillArrays(elemNum/100);

        long bubleSort = 0;
        long insertSort = 0;
        long selectionSort = 0;
        long mergeSort = 0;
        long shellSort = 0;

        for (int i = 0; i < elemNum; i++)
        {   
            bubleSort += BubbleSort.sort(arrToSort.arr);
            unsortArray();
            insertSort += InsertSort.sort(arrToSort.arr);
            unsortArray();
            selectionSort += SelectionSort.sort(arrToSort.arr);
            unsortArray();
            mergeSort += MergeSort.sort(arrToSort.arr);
            unsortArray();
            shellSort += ShellSort.sort(arrToSort.arr);
        }

        System.out.println("Bubble sort:\t\t" + (double)bubleSort/elemNum);
        System.out.println("");
        System.out.println("Insert Sort:\t\t" + (double)insertSort/elemNum);
        System.out.println("");
        System.out.println("Selection Sort:\t\t" + (double)selectionSort/elemNum);
        System.out.println("");
        System.out.println("Merge Sort:\t\t" + (double)mergeSort/elemNum);
        System.out.println();
        System.out.println("Shell Sort:\t\t" + (double)shellSort/elemNum);
    }

    private static void fillArrays(int num)
    {
        arrToSort = new MyArray(num);
        arrUnsortedCopy = new MyArray(num);
        arrUnsortedCopy.fillArr();
        unsortArray();
        System.out.println("Unsorted array:");
        arrUnsortedCopy.showArr();
        System.out.println("--------------------------------------------------------------------");        
    }

    private static void unsortArray()
    {
        System.arraycopy(arrUnsortedCopy.arr, 0, arrToSort.arr, 0, arrUnsortedCopy.arr.length);
    }
}