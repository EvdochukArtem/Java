import simple.*;
import nontrivial.*;

class SortApp {
    static MyArray arrToSort;
    static MyArray arrUnsortedCopy;

    /*public static void main(String[] args) {
        int elemNum = 100;
        fillArrays(elemNum);

        long insertSort = InsertSort.sort(arrToSort.arr);
        long quickSort = QuickSort.sort(arrUnsortedCopy.arr);
        System.out.println(quickSort + "\t" + insertSort);
        arrToSort.arrayCompare(arrUnsortedCopy.arr);
    }*/

    public static void main(String[] args) {

        int elemNum = 50;
        //long bubleSort = 0;
        //long selectionSort = 0;
        long insertSort = 0;
        long shellSort = 0;
        long mergeSort = 0;
        long quickSort = 0;
        long quickSortImproved = 0;

        for (int i = 0; i < elemNum/50; i++)
        {   
            fillArrays(elemNum);
            //bubleSort += BubbleSort.sort(arrToSort.arr);
            //unsortArray();
            //selectionSort += SelectionSort.sort(arrToSort.arr);
            //unsortArray();
            insertSort += InsertSort.sort(arrToSort.arr);
            unsortArray();
            shellSort += ShellSort.sort(arrToSort.arr);
            unsortArray();
            mergeSort += MergeSort.sort(arrToSort.arr);
            unsortArray();
            quickSort += QuickSort.sort(arrToSort.arr);
            unsortArray();
            quickSortImproved += QuickSortImproved.sort(arrToSort.arr);
        }

        //System.out.println("Bubble sort:\t\t" + (double)bubleSort/elemNum);
        //System.out.println("");
        //System.out.println("Selection Sort:\t\t" + (double)selectionSort/elemNum);
        //System.out.println("");
        System.out.println("Insert Sort:\t\t" + (double)insertSort/elemNum);
        System.out.println("");
        System.out.println("Shell Sort:\t\t" + (double)shellSort/elemNum);
        System.out.println();
        System.out.println("Merge Sort:\t\t" + (double)mergeSort/elemNum);
        System.out.println();
        System.out.println("Quick Sort:\t\t" + (double)quickSort/elemNum);
        System.out.println();
        System.out.println("Quick Sort Improved:\t" + (double)quickSortImproved/elemNum);
    }

    private static void fillArrays(int num)
    {
        arrToSort = new MyArray(num);
        arrUnsortedCopy = new MyArray(num);
        arrUnsortedCopy.fillArr();
        unsortArray();
        //System.out.println("Unsorted array:");
        //arrUnsortedCopy.showArr();
        //System.out.println("--------------------------------------------------------------------");        
    }

    private static void unsortArray()
    {
        System.arraycopy(arrUnsortedCopy.arr, 0, arrToSort.arr, 0, arrUnsortedCopy.arr.length);
    }
}