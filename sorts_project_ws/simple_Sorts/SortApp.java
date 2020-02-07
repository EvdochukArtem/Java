package simple_Sorts;

class SortApp {
    static MyArray arrToSort1;
    static MyArray arrToSort2;
    static MyArray arrUnsortedCopy;
    public static void main(String[] args) {

        int elemNum = 1000000;
        fillArrays(elemNum/10000);
        double[] insertSort = new double[elemNum + 1];
        double[] insertSort1 = new double[elemNum + 1];
        double[] trueInsertSort = new double[elemNum + 1];
        double[] selectionSort = new double[elemNum + 1];
        double[] selectionSort1 = new double[elemNum + 1];
        double[] selectionSort2 = new double[elemNum + 1];
        double[] trueSelectionSort = new double[elemNum + 1];

        for (int i = 0; i < elemNum; i++)
        {   
            insertSort[i] = InsertSort.sort(arrToSort1.arr);
            System.arraycopy(arrUnsortedCopy.arr, 0, arrToSort1.arr, 0, arrUnsortedCopy.getCurrSize());
            insertSort1[i] = InsertSort.sort1(arrToSort1.arr);
            trueInsertSort[i] = TrueInsertSort.sort(arrToSort2.arr);
            //arrToSort1.arrayCompare(arrToSort2.arr);

            System.arraycopy(arrUnsortedCopy.arr, 0, arrToSort1.arr, 0, arrUnsortedCopy.getCurrSize());
            System.arraycopy(arrUnsortedCopy.arr, 0, arrToSort2.arr, 0, arrUnsortedCopy.getCurrSize());
            
            selectionSort[i] = SelectionSort.sort(arrToSort1.arr);
            System.arraycopy(arrUnsortedCopy.arr, 0, arrToSort1.arr, 0, arrUnsortedCopy.getCurrSize());
            selectionSort1[i] = SelectionSort.sort1(arrUnsortedCopy.arr);
            selectionSort2[i] = SelectionSort.sort2(arrToSort1.arr);
            trueSelectionSort[i] = TrueSelectionSort.sort(arrToSort2.arr);
            //arrToSort1.arrayCompare(arrToSort2.arr);
        }
        
        for (int i = 0; i < elemNum; i++)
        {
            insertSort[elemNum] += insertSort[i];
            insertSort1[elemNum] += insertSort1[i];
            trueInsertSort[elemNum] += trueInsertSort[i];
            selectionSort[elemNum] += selectionSort[i];
            selectionSort1[elemNum] += selectionSort1[i];
            selectionSort2[elemNum] += selectionSort2[i];
            trueSelectionSort[elemNum] += trueSelectionSort[i];
        }
        System.out.println("Insert Sort:\t\t" + insertSort[elemNum]/elemNum);
        System.out.println("Insert Sort1:\t\t" + insertSort1[elemNum]/elemNum);
        System.out.println("True Insert Sort:\t" + trueInsertSort[elemNum]/elemNum);
        System.out.println("");
        System.out.println("Selection Sort:\t\t" + selectionSort[elemNum]/elemNum);
        System.out.println("Selection Sort1:\t" + selectionSort1[elemNum]/elemNum);
        System.out.println("Selection Sort2:\t" + selectionSort2[elemNum]/elemNum);
        System.out.println("True Selection Sort:\t" + trueSelectionSort[elemNum]/elemNum);
    }

    static void fillArrays(int num)
    {
        arrToSort1 = new MyArray(num);
        arrToSort2 = new MyArray(num);
        arrUnsortedCopy = new MyArray(num);
        arrToSort1.fillArr(num);
        System.arraycopy(arrToSort1.arr, 0, arrToSort2.arr, 0, arrToSort1.getCurrSize());
        System.arraycopy(arrToSort1.arr, 0, arrUnsortedCopy.arr, 0, arrToSort1.getCurrSize());
        System.out.println("Unsorted array:");
        arrToSort1.showArr();
        System.out.println("--------------------------------------------------------------------");        
    }
}