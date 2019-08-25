package simple_Sorts;

class SortApp {
    public static void main(String[] args) {
        MyArray arr1 = new MyArray(10);
        MyArray arr2;
        arr1.fillArr(5);
        System.out.println("First array:");
        arr1.showArr();
        try {
            arr2 = arr1.clone();
            arr2.arr = arr1.arr.clone();
            System.out.println("Clonned array:");
            arr2.showArr();
            arr2.fillArr(5);
            System.out.println("First array:");
            arr1.showArr();
            //System.out.println(arr1.getCurrSize());           
            System.out.println("Second array:");
            arr2.showArr();
            //System.out.println(arr2.getCurrSize());    
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void main1(String[] args) {
        MyArray arr1 = new MyArray(10);
        MyArray arr2;
        arr1.fillArr(10);
        System.out.println("Original Array:");
        arr1.showArr();
        try {
            System.out.println("for TrueSelectionSort:");
            arr2 = arr1.clone();
            arr2.showArr();
            TrueSelectionSort.sort(arr2.arr);
            arr2.showArr();
        } catch (CloneNotSupportedException ex) {
            System.out.println(ex);
        }
        //BubbelSort.sort(arr1.arr);
        System.out.println("for SelectionSort:");
        arr1.showArr();
        SelectionSort.sort(arr1.arr);
        //InsertSort.sort(arr1.arr);
        //TrueInsertSort.sort(arr1.arr);
        arr1.showArr();
    }
}