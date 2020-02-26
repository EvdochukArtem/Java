import simple.*;

class SortApp {
    static MyArray arrToSort;
    static MyArray arrUnsortedCopy;
    public static void main(String[] args) {

        int elemNum = 100000;
        fillArrays(elemNum/100);
        long i = SelectionSort.sort(arrToSort.arr);
        arrToSort.arrayCompare(arrUnsortedCopy.arr);
        System.out.println(i);

        /*double[] bubleSort = new double[elemNum + 1];
        double[] insertSort = new double[elemNum + 1];
        double[] trueInsertSort = new double[elemNum + 1];
        double[] selectionSort = new double[elemNum + 1];
        double[] trueSelectionSort = new double[elemNum + 1];

        for (int i = 0; i < elemNum; i++)
        {   
            bubleSort[i] = BubbleSort.sort(arrToSort.arr);
            unsortArray();
            insertSort[i] = InsertSort.sort(arrToSort.arr);
            unsortArray();
            trueInsertSort[i] = InsertSort.sortT(arrToSort.arr);
            unsortArray();
            selectionSort[i] = SelectionSort.sort(arrToSort.arr);
            unsortArray();
            trueSelectionSort[i] = TrueSelectionSort.sort(arrToSort.arr);
        }
        
        for (int i = 0; i < elemNum; i++)
        {
            bubleSort[elemNum] += bubleSort[i];
            insertSort[elemNum] += insertSort[i];
            trueInsertSort[elemNum] += trueInsertSort[i];
            selectionSort[elemNum] += selectionSort[i];
            trueSelectionSort[elemNum] += trueSelectionSort[i];
        }
        System.out.println("Bubble sort:\t\t" + bubleSort[elemNum]/elemNum);
        System.out.println("");
        System.out.println("Insert Sort:\t\t" + insertSort[elemNum]/elemNum);
        System.out.println("True Insert Sort:\t" + trueInsertSort[elemNum]/elemNum);
        System.out.println("");
        System.out.println("Selection Sort:\t\t" + selectionSort[elemNum]/elemNum);
        System.out.println("True Selection Sort:\t" + trueSelectionSort[elemNum]/elemNum);*/
    }

    private static void fillArrays(int num)
    {
        arrToSort = new MyArray(num);
        arrUnsortedCopy = new MyArray(num);
        arrUnsortedCopy.fillArr(num);
        unsortArray();
        System.out.println("Unsorted array:");
        arrUnsortedCopy.showArr();
        System.out.println("--------------------------------------------------------------------");        
    }

    private static void unsortArray()
    {
        System.arraycopy(arrUnsortedCopy.arr, 0, arrToSort.arr, 0, arrUnsortedCopy.getCurrSize());
    }
}